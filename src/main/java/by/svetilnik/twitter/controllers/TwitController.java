package by.svetilnik.twitter.controllers;

import by.svetilnik.twitter.entities.Twit;
import by.svetilnik.twitter.entities.User;
import by.svetilnik.twitter.repos.TwitRepo;
import by.svetilnik.twitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class TwitController {

    @Autowired
    private TwitRepo twitRepo;

    @Autowired
    private UserService userService;

    @GetMapping("/twits")
    public String twits(Principal principal, Model model)
    {
        User user = (User) userService.loadUserByUsername(principal.getName());

        List<Twit> twits = twitRepo.findByUserId(user.getId());
        model.addAttribute("twits", twits);
        model.addAttribute("user", user);

        return "twits";
    }

    @PostMapping("/addtwit")
    public String addTwit(Principal principal, String title, String twit)
    {
        User user = (User) userService.loadUserByUsername(principal.getName());

        Twit newTwit = new Twit();
        newTwit.setTitle(title);
        newTwit.setTwit(twit);
        newTwit.setUserId(user.getId());

        twitRepo.save(newTwit);

        return "redirect:/twits";
    }


}
