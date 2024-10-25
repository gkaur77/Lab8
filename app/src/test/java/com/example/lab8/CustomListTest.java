package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {


    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }


    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        CustomList list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * Tests if a city is present in the list.
     */
    @Test
    public void hasCityTest() {
        City city = new City("Regina", "SK");
        list.addCity(city);
        assertTrue(list.hasCity(city));

        City nonExistentCity = new City("Calgary", "AB");
        assertFalse(list.hasCity(nonExistentCity));
    }

    /**
     * Tests if a city can be deleted from the list.
     * Ensures that deleting a non-existent city throws an exception.
     */
    @Test
    public void deleteCityTest() {
        City city = new City("Edmonton", "AB");
        list.addCity(city);
        assertTrue(list.hasCity(city));

        list.delete(city);
        assertFalse(list.hasCity(city));

        // Test that deleting a city not in the list throws an exception
        City nonExistentCity = new City("Vancouver", "BC");
        assertThrows(IllegalArgumentException.class, () -> {
            list.delete(nonExistentCity);
        });
    }


    /**
     * Tests counting the total number of cities in the list.
     */
    @Test
    public void countCitiesTest() {
        assertEquals(0, list.countCities());

        list.addCity(new City("Toronto", "ON"));
        list.addCity(new City("Montreal", "QC"));
        assertEquals(2, list.countCities());

        list.delete(new City("Toronto", "ON"));
        assertEquals(1, list.countCities());
    }


}
