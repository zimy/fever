package me.zimy.parker.controllers;

import me.zimy.parker.model.ThermoEvent;
import me.zimy.parker.model.User;
import me.zimy.parker.repositories.Thermos;
import me.zimy.parker.repositories.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Main and only HTTP controller
 *
 * @author Dmitriy &lt;Zimy&gt; Yakovlev
 * @since 12/9/14.
 */
@Controller
@RequestMapping("/")
public class WebInterface {
    @Autowired
    Thermos thermos;

    @Autowired
    Users users;

    @RequestMapping("/data")
    public String getProbabilityResults(
            @RequestParam(defaultValue = "false", required = false) Boolean cache,
            @RequestParam(defaultValue = "false", required = false) Boolean mock,
            Model model) {
        List<ThermoEvent> all = thermos.findAll();
        model.addAttribute("secondResult", all);
        if (all.size() != 0) {
            model.addAttribute("lastValue", all.get(all.size() - 1));
        }
        model.addAttribute("amount", all.size());
        model.addAttribute("cacheable", false);
        return "answers";
    }

    @RequestMapping("/value")
    public String getMockedAndCached(Model model) {
        Random random = new Random();
        List<Integer> parts = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            parts.add(random.nextInt(18) + 20);
        }
        model.addAttribute("secondResult", parts);
        model.addAttribute("amount", parts.size());
        model.addAttribute("lastValue", parts.get(parts.size() - 1));
        model.addAttribute("cacheable", true);
        return "answers";
    }

    @RequestMapping(value = "/land", method = RequestMethod.POST)
    public String land(@RequestParam String mail, @RequestParam(required = false) Integer ticketId) {
        users.save(new User(mail, ticketId));
        return "thanks";
    }

    @RequestMapping("/")
    public String getLanding(Model model) {
        Random random = new Random();
        List<Integer> parts = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            parts.add(random.nextInt(18) + 20);
        }
        model.addAttribute("secondResult", parts);
        model.addAttribute("amount", parts.size());
        model.addAttribute("lastValue", parts.get(parts.size() - 1));
        model.addAttribute("cacheable", false);
        return "suenot";
    }
}
