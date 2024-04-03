package com.example.data1700oblig3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class IndexController {
    private final List<ArrayClassThing> allTickets = new ArrayList<>();
    @PostMapping("/save")
    public void saveTicket(ArrayClassThing purchasedTicket){
        allTickets.add(purchasedTicket);
    }

    @GetMapping("/getAll")
    public List<ArrayClassThing> getAll(){
        return allTickets;
    }

    @GetMapping("/deleteAll")
    public void deleteAll(){
        allTickets.clear();
    }
}
