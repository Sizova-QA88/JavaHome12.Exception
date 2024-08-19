package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    ShopRepository reposhop = new ShopRepository();
    Product airbus = new Product(97, "самолёт", 2_000_000);
    Product house = new Product(87, "дом", 1_000_000);
    Product yacht = new Product(77, "яхта", 1_500);
    Product island = new Product(77, "остров", 7_000_000);

    @BeforeEach
    public void setUp() {
        reposhop.add(airbus);
        reposhop.add(house);
        reposhop.add(yacht);
    }

    @Test
    public void shouldRemoveIdNotFound() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            reposhop.removeById(55);
        });
    }

    @Test
    public void shouldRemoveExistingId() {

        reposhop.removeById(87);

        Product[] expected = {airbus, yacht};
        Product[] actual = reposhop.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addAvailableID() {


        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            reposhop.add(yacht);
        });
    }

    @Test
    public void addNewID() {

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            reposhop.add(island);
        });
    }
}