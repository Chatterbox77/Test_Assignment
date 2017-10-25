import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Scanner;

public class Store {
    private ArrayList<AlcoholBeverage> alcohol;
    private ArrayList<AlcoholFreeBeverage> alcoholFree;
    private double spentMoney;
    private double earnedMoney;
    private String path;

    public Store(String path){
            alcohol=new ArrayList<>();
            alcoholFree=new ArrayList<>();
            init(path);
            this.path=path;
            spentMoney=0.;
            earnedMoney=0.;

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
    private String[] composition(String[] in){

        try{
            String s=in[4].trim();
            Double.parseDouble(s.substring(0,s.length()-1));
        }catch (Exception e){
            String[] dest=new String[in.length-1-4];
            System.arraycopy(in,4, dest,0,in.length-1-4);
            return dest;

        }
        return new String[]{};

    }
    private void dumpToCSV(){


        try{
            FileWriter stream =new FileWriter(new File(path), false);

            for(AlcoholBeverage b:alcohol){

                stream.write(b.toString()+"\n");
            }
            for(AlcoholFreeBeverage b:alcoholFree){

                stream.write(b.toString()+"\n");
            }
            stream.close();
        }catch(IOException e){
            System.out.println("Error. File identified by path: "+path+" doesn't exist.");
            System.exit(1);
        }



    }
    private void init(String path){
        Scanner in=null;
        try {
            in = new Scanner(new File(path));
        }catch (FileNotFoundException e){
            System.out.println("Error. File identified by path: "+path+" doesn't exist.");
            System.exit(1);
        }
        while(in.hasNext()){

            String[] s=in.nextLine().split(",");
            String[] composition=composition(s);
            if(composition.length==0){
                String s1=s[4].trim();
                alcohol.add(new AlcoholBeverage(
                   s[0],Double.parseDouble(s[1].trim()),s[2],Double.parseDouble(s[3].trim()),
                        Integer.parseInt(s[5].trim()),Double.parseDouble(s1.substring(0,s1.length()-1))
                ));
            }else{
                alcoholFree.add(new AlcoholFreeBeverage(
                        s[0],Double.parseDouble(s[1].trim()),s[2],Double.parseDouble(s[3].trim()),
                        Integer.parseInt(s[s.length-1].trim()),composition
                ));
            }


        }
    }
    public void buyItems(){
        for(int i=0;i<alcohol.size();i++){
            if(alcohol.get(i).getAmount()<10){
                alcohol.get(i).setAmount(alcohol.get(i).getAmount()+150);
                alcohol.get(i).incrementBought(150);

            }
        }
        for(int i=0;i<alcoholFree.size();i++){
            if(alcoholFree.get(i).getAmount()<10){
                alcoholFree.get(i).setAmount(alcoholFree.get(i).getAmount()+150);
                alcoholFree.get(i).incrementBought(150);

            }
        }
    }
    public void finishEmulation(){
        try{
            File out=Paths.get(new File(path).getParentFile().toString(),"results.txt").toFile();
            out.createNewFile();
            FileWriter stream =new FileWriter(out, false);
            for(Beverage b:alcohol){
                stream.write(b.getName()+" Sold: "+b.getSold()+" Bought: "+b.getBought()+"\n");
            }
            for(Beverage b:alcoholFree){
                stream.write(b.getName()+" Sold: "+b.getSold()+" Bought: "+b.getBought()+"\n");
            }

            stream.write(new Formatter().format("Earned Money: %.2f",(earnedMoney-spentMoney)).toString()+"\n");
            stream.write(new Formatter().format("Spent Money: %.2f",spentMoney).toString());
            stream.close();

        }catch(IOException e){
            System.out.println("Error. Cannot create file identified by path: "+path);
            System.exit(1);
        }
        dumpToCSV();
    }
    public String toString(){
        return alcohol.toString()+"\n"+alcoholFree.toString();
    }


}
