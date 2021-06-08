package model;

public class Product {
    private  int id;
    private  String name ;
    private  int quanlity;
    private  float price;
    private String color;
    private  String description;
    Category category ;

    public Product() {
    }

    public Product(int id, String name, int quanlity, float price, String color, String description, Category category) {
        this.id = id;
        this.name = name;
        this.quanlity = quanlity;
        this.price = price;
        this.color = color;
        this.description = description;
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(int quanlity) {
        this.quanlity = quanlity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
