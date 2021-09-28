package com.learnjava.frenemy.controller;

import com.learnjava.frenemy.model.UserDTO;
import com.learnjava.frenemy.service.FrenemyCalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;

@Controller
@SessionAttributes({"userDTO"})
public class AppController {

    @Autowired
    private FrenemyCalcService frenemyCalcService;

    // WITHOUT USING @ModelAttribute APPROACH
    @RequestMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "home-page";
    }

    // USING @ModelAttribute APPROACH
//    @RequestMapping("/")
//    public String getHomePage(@ModelAttribute("userDTO") UserDTO user) {
//        return "home-page";
//    }


      // REQUEST PARAM APPROACH
//    @RequestMapping("/processHomepage")
//    public String showResultPage(@RequestParam("userName") String userName,
//                                 @RequestParam("friendName") String friendName,
//                                 Model model) {
//        model.addAttribute("userName", userName);
//        model.addAttribute("friendName", friendName);
//        return "result-page";
//    }

    // DTO APPROACH
    // WITHOUT USING @ModelAttribute APPROACH
//    @RequestMapping("/processHomepage")
//    public String showResultPage(UserDTO userDTO, Model model) {
//
//        model.addAttribute("userDTO", userDTO);
//
//        return "result-page";
//    }

    // DTO APPROACH
    // USING @ModelAttribute APPROACH
    @RequestMapping("/processHomepage")
    public String showResultPage(@Valid @ModelAttribute("userDTO") UserDTO user,
                                 BindingResult result) {
        if (result.hasErrors()) {
            result.getAllErrors().forEach(System.out::println);
            return "home-page";
        }

        String relation = frenemyCalcService.findRelation(user.getUserName(), user.getFriendName());
        user.setRelation(relation);

        return "result-page";
    }
}
