package com.learnjava.frenemy.controller;

import com.learnjava.frenemy.model.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AppController {

      // WITHOUT USING @ModelAttribute APPROACH
//    @RequestMapping("/")
//    public String getHomePage(Model model) {
//
//        UserDTO userDTO = new UserDTO();
//        model.addAttribute("userDTO", userDTO);
//
//        return "home-page";
//    }

    // USING @ModelAttribute APPROACH
    @RequestMapping("/")
    public String getHomePage(@ModelAttribute("userDTO") UserDTO user) {
        return "home-page";
    }


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
            /* List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError objErr : allErrors) {
                System.out.println(objErr);
            } */
            return "home-page";
        }
        return "result-page";
    }
}
