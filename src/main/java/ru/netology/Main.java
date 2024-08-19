package ru.netology;

public class Main {

    public static void main(String[] args) {
        ShopRepository repo = new ShopRepository();

        try {
            repo.removeById(50);
        } catch (NegativeArraySizeException e) {

        }
    }
}
