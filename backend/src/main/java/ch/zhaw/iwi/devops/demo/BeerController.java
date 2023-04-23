package ch.zhaw.iwi.devops.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class BeerController {

    private Map<Integer, Beer> beers = new HashMap<Integer, Beer>();

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        this.beers.put(1,new Beer(1, "Lager", "Wasser Hopfen Malz"));
        this.beers.put(2,new Beer(2, "IPA", "Wasser Hopfen Malz"));
        this.beers.put(3,new Beer(3, "Pale Ale", "Wasser Hopfen Malz"));
        this.beers.put(4,new Beer(4, "Weizen", "Wasser Hopfen Malz"));
        this.beers.put(5,new Beer(5, "Triple", "Wasser Hopfen Malz"));
        System.out.println("Init Data");
    }

    @GetMapping("/services/beer")
    public List<PathListEntry<Integer>> beer() {
        var result = new ArrayList<PathListEntry<Integer>>();
        for (var beer : this.beers.values()) {
            var entry = new PathListEntry<Integer>();
            entry.setKey(beer.getId(), "beerKey");
            entry.setName(beer.getTitle());
            entry.getDetails().add(beer.getRecipe());
            entry.setTooltip(beer.getRecipe());
            result.add(entry);
        }
        return result;
    }

    @GetMapping("/services/beer/{id}")
    public Beer getBeer(@PathVariable Integer id) {
        return this.beers.get(id);
    }

    @PostMapping("/services/beer")
    public void createBeer(@RequestBody Beer beer) {
        var newId = this.beers.keySet().stream().max(Comparator.naturalOrder()).orElse(0) + 1;
        beer.setId(newId);
        this.beers.put(newId, beer);
    }

    @PutMapping("/services/beer/{id}")
    public void createBeer(@PathVariable Integer id, @RequestBody Beer beer) {
        beer.setId(id);
        this.beers.put(id, beer);
    }

    @DeleteMapping("/services/beer/{key}")
    public Beer deleteBeer(@PathVariable Integer id) {
        return this.beers.remove(id);
    }
}
