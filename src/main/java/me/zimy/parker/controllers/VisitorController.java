package me.zimy.parker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;

/**
 * Created by Dmitriy I. Yakovlev $lt;zimy&at;yandex$dot;ru&gt; on 17.10.15.
 * Manages events on people who are coming in and out
 */
@Controller
public class VisitorController {
    @RequestMapping("/stop/{distance}")
    public void visitorLeave(@RequestPart Integer distance){

    }

    @RequestMapping("/start/{distance}")
    public void visitorCome(@RequestPart Integer distance){

    }
}
