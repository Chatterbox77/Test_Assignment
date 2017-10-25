public class AlcoholBeverage extends Beverage{
    private double strength;
//    constructor for the class AlcoholBeverage
    public AlcoholBeverage(String name, double purachsePrice, String classification, double volume, int amount, double strength) {
        super(name, purachsePrice, classification, volume, amount);
        this.strength=strength;
    }
//    return the strength of the beverage
    public double getStrength(){
        return strength;
    }
//    override toString
    public String toString(){
        return getName()+", "+getPurachsePrice()+", "+getClassification()+", "+getVolume()+", "+strength+"%, "+getAmount();

    }
}
