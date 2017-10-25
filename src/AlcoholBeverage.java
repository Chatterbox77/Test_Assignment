public class AlcoholBeverage extends Beverage{
    private double strength;
    public AlcoholBeverage(String name, double purachsePrice, String classification, double volume, int amount, double strength) {
        super(name, purachsePrice, classification, volume, amount);
        this.strength=strength;
    }
    public String toString(){
        return getName()+", "+getPurachsePrice()+", "+getClassification()+", "+getVolume()+", "+strength+"%, "+getAmount();

    }
}
