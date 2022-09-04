package dev.logchange.hofund.testapp.stats;

import org.springframework.web.bind.annotation.*;

@RestController
public class StatsController {

    private final StatsService statsService;

    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping("/stats")
    Iterable<Stat> all() {
        return statsService.getStats();
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