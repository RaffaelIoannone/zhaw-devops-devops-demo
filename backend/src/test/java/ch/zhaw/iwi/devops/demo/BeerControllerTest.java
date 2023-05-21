package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BeerControllerTest {
    
    @Test
    void testCreate() {
        BeerController controller = new BeerController();
        var beer = new Beer(1, "Test Beer", "Water");
        controller.createBeer(1, beer);
        assertEquals(1, controller.beer().size());
    }

    @Test
    void testDelete() {
        BeerController controller = new BeerController();
        var beer = new Beer(1, "Test Beer", "Water");
        controller.createBeer(1, beer);
        assertEquals(1, controller.beer().size());
        controller.deleteBeer(1);
        assertEquals(0, controller.beer().size());

    }

}
