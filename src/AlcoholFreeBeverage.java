import java.util.Arrays;

public class AlcoholFreeBeverage extends Beverage{
    private String[] composition;
    //    constructor for the class AlcoholFreeBeverage
    public AlcoholFreeBeverage(String name, double purachsePrice, String classification, double volume, int amount, String...composition) {
        super(name, purachsePrice, classification, volume, amount);
        this.composition=composition;
    }
//    get the composition of the beverage
    public String[] getComposition(){
        return composition;
    }
//    override toString
    public String toString(){
        return getName()+", "+getPurachsePrice()+", "+getClassification()+", "+getVolume()+", "
                +String.join(",",composition)+", "+getAmount();
    }
}
