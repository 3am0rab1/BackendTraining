package com.example.demo.Controllers;

import com.example.demo.Entities.Frenship;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/frenships")
public class FrenshipController {

    private final FrenshipService frenshipServices;


    @GetMapping("/frenships")
    List<Frenship> getFrenship() {
        return frenshipServices.findAll();
    }

    @PostMapping("/frenships")
    Frenship newFrenship(@RequestBody Frenship newFrenship) {
        return frenshipServices.save(newFrenship);
    }


    @GetMapping("/fresnhips/{frenshipId}")
    Frenship getfrenship(@PathVariable Long frenshipId) {

        return frenshipServices.findByFrenshipId(frenshipId)
                .orElseThrow(() -> new FrenshipNotFoundException(frenshipId));
    }

    @PutMapping("/frenships/{frenshipId}")
    Frenship replaceFrenship(@RequestBody Frenship newFrenship, @PathVariable Long frenshipId) {

        return fresnhipServices.findByFrenshipId(frenshipId)
                .map(frenship -> {
                    return frenhsipServices.save(frenship);
                })
                .orElseGet(() -> {
                    newFrenship.setFrenshipId(frenshipId);
                    return frenshipServices.save(newFrenship);
                });
    }

    @DeleteMapping("/frenships/{frenshipId}")
    void deleteFrenship(@PathVariable Long frenshipId) {
    }
}
