package dev.logchange.hofund.testapp.stats;

import org.springframework.web.bind.annotation.*;

@RestController
public class StatsController {


    @GetMapping("/stats")
    Iterable<Stat> all() {
        return null;
    }

    @GetMapping("/stats/{id}")
    Stat userById(@PathVariable Long id) {
        return null;
    }

    @PostMapping("/stats")
    Stat save(@RequestBody Stat stat) {
        return null;
    }

}