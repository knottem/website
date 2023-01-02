package com.example.website.controller;

import com.example.website.entity.model.Account;
import com.example.website.entity.model.Address;
import com.example.website.entity.model.Telephone;
import com.example.website.entity.model.User;
import com.example.website.repository.AccountRepository;
import com.example.website.repository.AddressRepository;
import com.example.website.repository.TelephoneRepository;
import com.example.website.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import static com.example.website.utility.Encrypt.encryptSHA3;

@Controller
public class MyController {

    private final static Logger logger = LogManager.getLogger(MyController.class);

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final AccountRepository accountRepository;
    private final TelephoneRepository telephoneRepository;

    public MyController(UserRepository userRepository, AddressRepository addressRepository, AccountRepository accountRepository, TelephoneRepository telephoneRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.accountRepository = accountRepository;
        this.telephoneRepository = telephoneRepository;
    }

    @GetMapping("/login")
    public String login(Model model) {
        if (model.containsAttribute("message")) {
            model.addAttribute("message", model.getAttribute("message"));
        } else {
            model.addAttribute("message", "Welcome to the login page");
        }
        return "login";
    }

    @PostMapping({"/login", "/"})
    public String loginSubmit(Model model, String username, String password) {

        // Check the username and the encrypted password
        String pass = encryptSHA3(password);
        User user = userRepository.findByUsernameAndPassword(username, pass);
        logger.info(user);
        if (user != null) {
            List<Address> addresses = addressRepository.findByuserid(user.getId());
            List<Account> accounts = accountRepository.findByuserid(user.getId());
            List<Telephone> telephones = telephoneRepository.findByUserid(user.getId());
            model.addAttribute("user", user);
            model.addAttribute("addresses", addresses);
            model.addAttribute("accounts", accounts);
            model.addAttribute("telephones", telephones);
            return "user";
        } else {
            model.addAttribute("message", "Invalid username or password. Please try again.");
            return "login";
        }
    }

    @PostMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
        session.invalidate();
        redirectAttributes.addFlashAttribute("message", "You have been logged out");
        return "redirect:/login";
    }



    @GetMapping("/home")
    public String home(Model model) {
        // Add attributes to the model and return the name of the HTML template
        model.addAttribute("message", null);
        return "home";
    }


    @GetMapping("/error")
    public String error(Model model) {
        // Add attributes to the model and return the name of the HTML template
        model.addAttribute("message", "An error occurred. Please try again.");
        return "error";
    }
}
