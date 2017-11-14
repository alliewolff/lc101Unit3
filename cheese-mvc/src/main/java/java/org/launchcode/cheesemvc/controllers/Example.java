package java.org.launchcode.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class Example {

    static ArrayList<String> orderedMovies = new ArrayList<>(Arrays.asList("Sharkface", "Snakes on a Plane", "101 Dalmations"));


    @RequestMapping(value = "")
    public String handler(Model model) {
        model.addAttribute( "title","Example Page");

        model.addAttribute("movies", orderedMovies);

        return "index";

    }

    @RequestMapping(value = "", method=RequestMethod.POST)
    public String formHandler(@RequestParam String addMovie) {
        orderedMovies.add(addMovie);
        return "redirect:/";
    }
}
