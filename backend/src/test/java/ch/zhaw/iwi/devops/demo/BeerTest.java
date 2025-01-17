package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BeerTest {

    @Test
    void testBeer() {
        var beer = new Beer(42, "TestBeer", "Water");
        beer.setId(42);
        assertEquals("TestBeer", beer.getTitle());
        assertEquals("Water", beer.getRecipe());
        assertEquals(42, beer.getId());
    }

    @Test
    void testEmptyBeer() {
        var beer = new Beer();
        beer.setId(69);
        assertEquals(null, beer.getTitle());
        assertEquals(null, beer.getRecipe());
        assertEquals(69, beer.getId());
    }
    
}
