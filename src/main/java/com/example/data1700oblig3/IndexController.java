package com.example.data1700oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class IndexController {
    @Autowired
    private TicketRepository rep;
    @PostMapping("/save")
    public void saveTicket(TicketClass purchasedTicket){
        rep.saveTicket(purchasedTicket);
    }

    @GetMapping("/getAll")
    public List<TicketClass> getAll(){
        return rep.getAllTickets();
    }

    @GetMapping("/deleteAll")
    public void deleteAll(){
        rep.deleteAllTickets();
    }
}
