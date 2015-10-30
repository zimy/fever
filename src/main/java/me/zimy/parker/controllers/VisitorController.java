package me.zimy.parker.controllers;

import me.zimy.parker.model.Ticket;
import me.zimy.parker.model.User;
import me.zimy.parker.model.VisitorEvent;
import me.zimy.parker.repositories.Tickets;
import me.zimy.parker.repositories.Users;
import me.zimy.parker.repositories.Visitors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Dmitriy I. Yakovlev $lt;zimy&at;yandex$dot;ru&gt; on 17.10.15.
 * Manages events on people who are coming in and out
 */
@RestController
public class VisitorController {
    @Autowired
    Visitors visitors;

    @Autowired
    Tickets tickets;

    @Autowired
    Users users;

    @RequestMapping("/ticket/{ticketId}")
    public void saveTicket(@PathVariable("ticketId") Integer tickedId) {
        tickets.save(new Ticket(tickedId));
    }

    @RequestMapping("/tickets")
    public List<Ticket> ticket() {
        return tickets.findAll();
    }

    @RequestMapping("/users")
    public List<User> userz() {
        return users.findAll();
    }

    @RequestMapping("/stop/{distance}")
    public void visitorLeave(@PathVariable Integer distance) {
        visitors.save(new VisitorEvent(false, LocalDateTime.now(), distance));
    }

    @RequestMapping("/start/{distance}")
    public void visitorCome(@PathVariable Integer distance) {
        visitors.save(new VisitorEvent(true, LocalDateTime.now(), distance));
    }

    @RequestMapping("/visitors")
    public List<VisitorEvent> getAll() {
        return visitors.findAll();
    }
}
