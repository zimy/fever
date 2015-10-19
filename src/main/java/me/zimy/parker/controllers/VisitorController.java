package me.zimy.parker.controllers;

import me.zimy.parker.model.Ticket;
import me.zimy.parker.model.User;
import me.zimy.parker.model.VisitorEvent;
import me.zimy.parker.repositories.Tickets;
import me.zimy.parker.repositories.Users;
import me.zimy.parker.repositories.Visitors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Dmitriy I. Yakovlev $lt;zimy&at;yandex$dot;ru&gt; on 17.10.15.
 * Manages events on people who are coming in and out
 */
@Controller
public class VisitorController {
    @Autowired
    Visitors visitors;

    @Autowired
    Tickets tickets;

    @Autowired
    Users users;

    @RequestMapping("/ticket/{ticketId}")
    @ResponseBody
    public void saveTicket(@PathVariable("ticketId") Integer tickedId) {
        tickets.save(new Ticket(tickedId));
    }

    @RequestMapping("/tickets")
    @ResponseBody
    public List<Ticket> ticket() {
        return tickets.findAll();
    }

    @RequestMapping("/users")
    @ResponseBody
    public List<User> userz(){
        return users.findAll();
    }

    @RequestMapping(value = "/land", method = RequestMethod.POST)
    public String land(@RequestParam String mail, @RequestParam(required = false) Integer ticketId) {
        users.save(new User(mail, ticketId));
        return "thanks";
    }

    @RequestMapping("/stop/{distance}")
    @ResponseBody
    public void visitorLeave(@PathVariable Integer distance) {
        visitors.save(new VisitorEvent(false, LocalDateTime.now(), distance));
    }

    @RequestMapping("/start/{distance}")
    @ResponseBody
    public void visitorCome(@PathVariable Integer distance) {
        visitors.save(new VisitorEvent(true, LocalDateTime.now(), distance));
    }

    @RequestMapping("/visitors")
    @ResponseBody
    public List<VisitorEvent> getAll() {
        return visitors.findAll();
    }
}
