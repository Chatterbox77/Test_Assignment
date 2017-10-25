public abstract class Beverage {
    private String name;
    private double purachsePrice;
    private String classification;
    private double volume;
    private int amount;
    private double extraCharge;
    private int sold;
    private int bought;

    public Beverage(String name, double purachsePrice, String classification, double volume, int amount) {
        this.name = name;
        this.purachsePrice = purachsePrice;
        this.classification = classification;
        this.volume = volume;
        this.amount = amount;
        extraCharge=1.1;
        sold=0;
        bought=0;

    }
    public void setDefaultCharge(){
            extraCharge=1.1;
    }

    public String getName() {
        return name;
    }


    public double getPurachsePrice() {
        return purachsePrice;
    }
    public double getExtraCharge(){return  extraCharge;}
    public void setExtracCharge(double extraCharge){this.extraCharge=extraCharge;}
    public double getPrice(){return purachsePrice*extraCharge;}
    public void setAmount(int amount){this.amount=amount;}
    public int getSold(){return sold;}

    public String getClassification() {
        return classification;
    }
    public int getBought(){return bought;}
    public void incrementBought(int incr){bought+=incr;}
    public double getVolume() {
        return volume;
    }

    public int getAmount() {
        return amount;
    }
    void sell(){
        amount--;
        sold++;

    }


}
