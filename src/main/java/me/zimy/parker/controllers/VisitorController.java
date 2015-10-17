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
    @RequestMapping("/finish")
    public void visitor(){

    }

    @RequestMapping("/start/{distance}")
    public void visitor(@RequestPart Integer distance){

    }
}
