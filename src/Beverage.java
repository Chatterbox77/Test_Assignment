public abstract class Beverage {
    private String name;
    private double purachsePrice;
    private String classification;
    private double volume;
    private int amount;
    private double extraCharge;
    private int sold;
    private int bought;
//     constructor for the class Beverage
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

    //    set extraCharge to be 10%
    public void setDefaultCharge(){
            extraCharge=1.1;
    }

    //  return the name of the beverage
    public String getName() {
        return name;
    }


    //  get purchase price of the beverage
    public double getPurachsePrice() {
        return purachsePrice;
    }

    //  get current value of the variable extraCharge
    public double getExtraCharge(){return  extraCharge;}

    //  set extraCharge to be equal to the new value
    public void setExtracCharge(double extraCharge){this.extraCharge=extraCharge;}

    //  get the price of the beverage that is calculated using its purchasePrice and the current value of extraCharge
    public double getPrice(){return purachsePrice*extraCharge;}

    //  set the amount of beverages of this type
    public void setAmount(int amount){this.amount=amount;}

    //  get the amount of sold beverages of this type
    public int getSold(){return sold;}

    //  get the classification of the beverage
    public String getClassification() {
        return classification;
    }

    //  get the amount of bought beverages of this type
    public int getBought(){return bought;}

    //  set the amount of bought beverages of this type to be equal to the current amount + incr
    public void incrementBought(int incr){bought+=incr;}

    //  get the volume of the beverage
    public double getVolume() {
        return volume;
    }

    //  get the amount of beverages of this type
    public int getAmount() {
        return amount;
    }

    //sell item
    void sell(){
        amount--;
        sold++;

    }


}
