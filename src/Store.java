import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Store {
    private ArrayList<AlcoholBeverage> alcohol;
    private ArrayList<AlcoholFreeBeverage> alcoholFree;
    private double spentMoney;
    private double earnedMoney;

    public Store(){
            alcohol=new ArrayList<>();
            alcoholFree=new ArrayList<>();
//        init("/Users/macBookpro/desktop/r.csv");
            i();
            spentMoney=0.;
            earnedMoney=0.;

    }
    private double initSpentMoney(){
        double d=0.;
        for(int i=0;i<alcohol.size();i++){
            d+=alcohol.get(i).getAmount()*alcohol.get(i).getPurachsePrice();
        }
        for(int i=0;i<alcoholFree.size();i++){
            d+=alcoholFree.get(i).getAmount()*alcoholFree.get(i).getPurachsePrice();
        }
        return d;
    }
    public void addSpentMoney(double inc){spentMoney+=inc;}
    public double spentMoney(){
        return spentMoney;
    }
    public void addEarnedMoney(double inc){earnedMoney+=inc;}
    public double getEarnedMoney(){return earnedMoney;}
    public Beverage getAlcoholBeverage(int index){return alcohol.get(index);}
    public Beverage getAlcoholFreeBeverage(int index){return alcoholFree.get(index);}
    public int numberOfAlcoholBeverages(){return alcohol.size();}
    public int numberOfAlcoholFreeBeverages(){return alcoholFree.size();}
    private void init(String path){

    }
    public void buyItems(){
        for(int i=0;i<alcohol.size();i++){
            if(alcohol.get(i).getAmount()<10){
                alcohol.get(i).setAmount(alcohol.get(i).getAmount()+150);
//                spentMoney+=alcohol.get(i).getPurachsePrice()*150;
            }
        }
        for(int i=0;i<alcoholFree.size();i++){
            if(alcoholFree.get(i).getAmount()<10){
                alcoholFree.get(i).setAmount(alcoholFree.get(i).getAmount()+150);
//                spentMoney+=alcoholFree.get(i).getPurachsePrice()*150;
            }
        }
    }
    void i(){
        alcohol.add(
                new AlcoholBeverage("Пиво Одесское Новое", 13.25, "пиво", 0.5, 120, 4.3)
        );
        alcohol.add(
                new AlcoholBeverage("Красная испанка", 80.00, "вино", 0.75, 92, 14)
        );
        alcohol.add(
                new AlcoholBeverage("Мартини Биссе", 205.00, "ликеры",1.0, 12, 13)
        );
        alcohol.add(
                new AlcoholBeverage("Два моря", 195.00, "вино", 0.75, 0,12)
        );
        alcoholFree.add(
          new AlcoholFreeBeverage("Вода минеральная Хорошо", 9.99, "минеральные воды", 0.3,  570,"вода минеральная, лечебно-столовая")

        );
        alcoholFree.add(
                new AlcoholFreeBeverage("Вода минеральная Хорошо", 15.47, "минеральные воды", 1.5, 412,"вода минеральная, лечебно-столовая")

        );
        alcoholFree.add(
                new AlcoholFreeBeverage("Сок Богач Грейпфрутовый", 22.00, "соки", 0.95, 156,"вода, сок грейпфрутовый концентрированный, фруктоза, лимонная кислота")

        );
        alcoholFree.add(
                new AlcoholFreeBeverage("Енерджи бум Плюс", 24.15, "прочие напитки", 0.33, 78,"вода, лимонная кислота, ароматизатор Яблоко, Е-345, Е-120, Е-630, Е-632, краситель Вишня")


                );


    }
    public String toString(){
        return alcohol.toString()+"\n"+alcoholFree.toString();
    }


}
