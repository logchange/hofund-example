package dev.logchange.hofund.testapp.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PaymentController {

    private final PaymentRepository repository;

    @Autowired
    public PaymentController(PaymentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/payments")
    Iterable<Payment> all() {
        return repository.findAll();
    }

    @GetMapping("/payments/{id}")
    Payment byId(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/payments")
    Payment save(@RequestBody Payment cart) {
        return repository.save(cart);
    }

}