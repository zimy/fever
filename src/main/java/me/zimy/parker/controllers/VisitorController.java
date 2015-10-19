package me.zimy.parker.controllers;

import me.zimy.parker.model.Ticket;
import me.zimy.parker.model.VisitorEvent;
import me.zimy.parker.repositories.Tickets;
import me.zimy.parker.repositories.Visitors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/ticket/{ticketId}")
    @ResponseBody
    public void saveTicket(@PathVariable("ticketId") Integer tickedId)
    {
        tickets.save(new Ticket(tickedId));
    }

    @RequestMapping("/tickets")
    @ResponseBody
    public List<Ticket> ticket(){
        return tickets.findAll();
    }

    @RequestMapping("/stop/{distance}")
    @ResponseBody
    public void visitorLeave(@PathVariable Integer distance) {
        visitors.save(new VisitorEvent(false, LocalDateTime.now(), distance));
    }

    @RequestMapping("/start/{distance}")
    @ResponseBody
    public void visitorCome(@PathVariable Integer distance) {
        visitors.save(new VisitorEvent(false, LocalDateTime.now(), distance));
    }

    @RequestMapping("/visitors")
    @ResponseBody
    public List<VisitorEvent> getAll() {
        return visitors.findAll();
    }
}
