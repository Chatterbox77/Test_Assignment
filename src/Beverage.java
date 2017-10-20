public abstract class Beverage {
    private String name;
    private double purachsePrice;
    private String classification;
    private double volume;
    private int amount;

    public Beverage(String name, double purachsePrice, String classification, double volume, int amount) {
        this.name = name;
        this.purachsePrice = purachsePrice;
        this.classification = classification;
        this.volume = volume;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getPurachsePrice() {
        return purachsePrice;
    }

    public String getClassification() {
        return classification;
    }

    public double getVolume() {
        return volume;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", purachsePrice=" + purachsePrice +
                ", classification='" + classification + '\'' +
                ", volume=" + volume +
                ", amount=" + amount;
    }
}
