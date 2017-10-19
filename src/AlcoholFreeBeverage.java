public class AlcoholFreeBeverage extends Beverage{
    private String[] composition;
    public AlcoholFreeBeverage(String name, double purachsePrice, String classification, double volume, int amount, String...composition) {
        super(name, purachsePrice, classification, volume, amount);
        this.composition=composition;
    }
}
