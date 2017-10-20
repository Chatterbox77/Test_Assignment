public class AlcoholBeverage extends Beverage{
    private double strength;
    public AlcoholBeverage(String name, double purachsePrice, String classification, double volume, int amount, double strength) {
        super(name, purachsePrice, classification, volume, amount);
        this.strength=strength;
    }
    public String toString(){
        return "AlcoholBeverage "+super.toString()+" strength= "+strength;
    }
}
