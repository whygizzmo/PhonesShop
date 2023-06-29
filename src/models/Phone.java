package models;

public class Phone {
    private int id;
    private String manufacturer;
    private  String model;
    private  int memory;
    private int megapixel;
    private double price;
    private int release;
    private  int count;

    public Phone() {
    }

    public Phone(String manufacturer, String model, int memory, int megapixel, double price, int release,int count) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.memory = memory;
        this.megapixel = megapixel;
        this.price = price;
        this.release = release;
        this.count = count;
    }

    public Phone(int id, String manufacturer, String model, int memory, int megapixel, double price, int release,int count) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.memory = memory;
        this.megapixel = megapixel;
        this.price = price;
        this.release = release;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getMegapixel() {
        return megapixel;
    }

    public void setMegapixel(int megapixel) {
        this.megapixel = megapixel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRelease() {
        return release;
    }

    public void setRelease(int release) {
        this.release = release;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", memory=" + memory +
                ", megapixel=" + megapixel +
                ", price=" + price +
                ", release=" + release +
                ", count=" + count +
                '}';
    }
}
