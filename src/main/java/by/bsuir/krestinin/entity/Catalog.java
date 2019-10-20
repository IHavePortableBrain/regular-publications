package by.bsuir.krestinin.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Catalog extends Publication implements Serializable {
    private static final long serialVersionUID = -6931097108288203519L;

    private double price;
    private int amountOfItems;
    private String shortDescription;

    public Catalog() {
        super();
    }

    public Catalog(int id, String title, Date publicationDate, List<Author> authors, double price, int amountOfItems, String shortDescription) {
        super(id, title, publicationDate, authors);

        this.price = price;
        this.amountOfItems = amountOfItems;
        this.shortDescription = shortDescription;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmountOfItems() {
        return amountOfItems;
    }

    public void setAmountOfItems(int amountOfItems) {
        this.amountOfItems = amountOfItems;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Catalog catalog = (Catalog) o;
        return Double.compare(catalog.getPrice(), getPrice()) == 0 &&
                getAmountOfItems() == catalog.getAmountOfItems() &&
                getShortDescription().equals(catalog.getShortDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPrice(), getAmountOfItems(), getShortDescription());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Catalog.class.getSimpleName() + "[", "]")
                .add("price=" + price)
                .add("amountOfItems=" + amountOfItems)
                .add("shortDescription='" + shortDescription + "'")
                .toString();
    }
}
