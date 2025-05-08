package za.ac.cput.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalutonMondo {

    @GetMapping({"/", "/home"})
    public String greeting(){

        return "Saluton Mondo!";
    }
}
