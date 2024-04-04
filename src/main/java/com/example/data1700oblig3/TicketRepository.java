package com.example.data1700oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketRepository {
    @Autowired
    private JdbcTemplate db;
    public void saveTicket(TicketClass innTicket){
        String sql = "INSERT INTO TicketClass(choose, amount, fname, lname, tel, email) VALUES(?,?,?,?,?,?)";
        db.update(sql, innTicket.getChoose(), innTicket.getAmount(), innTicket.getfName(), innTicket.getlName(), innTicket.getTel(), innTicket.getEmail());
    }

    public List<TicketClass> getAllTickets(){
        String sql = "SELECT * FROM TicketClass";
        List<TicketClass> allTickets = db.query(sql, new BeanPropertyRowMapper(TicketClass.class));
        return allTickets;
    }

    public void deleteAllTickets (){
        String sql = "DELETE FROM TicketClass";
        db.update(sql);
    }
}
