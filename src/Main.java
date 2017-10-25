
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Store s=new Store(args[0]);

        Random r=new Random();
        for(Day day:Day.month()){

            for(int hour=8;hour<21;hour++){

                for(int buyer=0;buyer<r.nextInt(11);buyer++ ){

                    ArrayList<Beverage> bought=new ArrayList<>();

                    for(int item=0;item<r.nextInt(11);item++){

                        int type=r.nextInt(2);
                        Beverage b=null;

                        if(type==0){
                            int index=r.nextInt(s.numberOfAlcoholBeverages());
                            b=s.getAlcoholBeverage(index);
                        }else{
                            int index=r.nextInt(s.numberOfAlcoholFreeBeverages());
                            b=s.getAlcoholFreeBeverage(index);

                        }

                        if(b.getAmount()<=0) {
                            item--;
                            continue;
                        }

                            b.setDefaultCharge();
                            if (day==Day.Saturday || day==Day.Sunday)
                                b.setExtracCharge(1.15);
                            if (hour >= 18 && hour < 20)
                                b.setExtracCharge(1.08);


                        for(Beverage b1:bought){
                            if(b.getName().equals(b1.getName()) && b.getPurachsePrice()==b1.getPurachsePrice()
                                    ) {

                                b.setExtracCharge(1.07);
                            }

                        }
                        String rule="";
                        if(b.getExtraCharge()==1.10)
                            rule="default rule";
                        else if(b.getExtraCharge()==1.08)
                            rule="Item was bought in time range [18,20)";
                        else if(b.getExtraCharge()==1.15)
                            rule = "Weekedns";

                        else if(b.getExtraCharge()==1.07)
                            rule="More then two items in the basket";
                        System.out.printf("Name: %s, Price: %.2f, ExtraCharge: %d%s, Rule: %s\n\n",b.getName(),b.getPrice(),(int)(Math.round((b.getExtraCharge()*100))-100),"%",rule);
                        b.sell();
                        s.addEarnedMoney(b.getPrice());
                        s.addSpentMoney(b.getPurachsePrice());

                        bought.add(b);

                    }

                }
            }

            s.buyItems();
        }

        s.finishEmulation();

    }
}
