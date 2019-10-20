package by.bsuir.krestinin.service.validator;

import by.bsuir.krestinin.entity.Catalog;

public final class CatalogValidator extends PublicationValidator {

    private static final int MIN_PRICE = 0;
    private static final int MIN_AMOUNT_OF_ITEMS = 0;

    private CatalogValidator() {
    }

    public static boolean isValidCatalog(Catalog catalog) {
        return isValidPublication(catalog) &&
                isValidAmountOfItems(catalog.getAmountOfItems()) &&
                isValidPrice(catalog.getPrice()) &&
                isValidShortDescription(catalog.getShortDescription());
    }

    public static boolean isValidAmountOfItems(int amountOfItems) {
        return amountOfItems >= MIN_AMOUNT_OF_ITEMS;
    }

    public static boolean isValidPrice(double price) {
        return price >= MIN_PRICE;
    }

    public static boolean isValidShortDescription(String shortDescription) {
        return shortDescription != null && !shortDescription.isEmpty();
    }
}
