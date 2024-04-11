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
        String sql = "SELECT * FROM TicketClass ORDER BY lName";
        List<TicketClass> allTickets = db.query(sql, new BeanPropertyRowMapper(TicketClass.class));
        return allTickets;
    }

    public void deleteAllTickets (){
        String sql = "DELETE FROM TicketClass";
        String sql2 = "DROP TABLE TicketClass";
        String sql3 = "CREATE TABLE TicketClass\n" +
                "(\n" +
                "    id INTEGER AUTO_INCREMENT NOT NULL,\n" +
                "    choose VARCHAR(255) NOT NULL,\n" +
                "    amount VARCHAR(255) NOT NULL,\n" +
                "    fname VARCHAR(255) NOT NULL,\n" +
                "    lname VARCHAR(255) NOT NULL,\n" +
                "    tel VARCHAR(255) NOT NULL,\n" +
                "    email VARCHAR(255) NOT NULL,\n" +
                "    PRIMARY KEY (id)\n" +
                ")";
        db.update(sql);
        db.update(sql2);
        db.update(sql3);
    }
}
