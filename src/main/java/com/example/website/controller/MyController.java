package com.example.website.controller;

import com.example.website.dao.AccountDatabase;
import com.example.website.entity.model.Account;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.TimeZone;

import static com.example.website.utility.Encrypt.encryptSHA3;

@Controller
public class MyController {

    private final static Logger logger = LogManager.getLogger(MyController.class);

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final AccountRepository accountRepository;
    private final TelephoneRepository telephoneRepository;
    private final AccountDatabase accountDatabase;

    public MyController(UserRepository userRepository, AddressRepository addressRepository, AccountRepository accountRepository, TelephoneRepository telephoneRepository, AccountDatabase dao) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.accountRepository = accountRepository;
        this.telephoneRepository = telephoneRepository;
        this.accountDatabase = dao;
    }

    @GetMapping({"/login", "/"})
    public String login(Model model) {
        if (model.containsAttribute("message")) {
            model.addAttribute("message", model.getAttribute("message"));
        } else {
            model.addAttribute("message", "Welcome to the login page");
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam String username, @RequestParam String password, Model model) {
        // Check the username and the encrypted password
        String pass = encryptSHA3(password);
        User user = userRepository.findByUsernameAndPassword(username, pass);
        logger.info(user);
        if (user != null) {
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("CET"));
            Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());
            user.setLast_access(timestamp);
            userRepository.save(user);
            model.addAttribute("user", user);
            model.addAttribute("addresses", addressRepository.findByuserid(user.getId()));
            model.addAttribute("accounts", accountRepository.findByuserid(user.getId()));
            model.addAttribute("telephones", telephoneRepository.findByUserid(user.getId()));
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

    @PostMapping("/createAccount")
    public String createAccount(Model model, int userid) {

        Account account = new Account();
        int accountNumber = accountDatabase.getAccountNumber();
        account.setAccountNumber(accountNumber);
        account.setBalance(0);
        account.setUserId(userid);
        accountRepository.save(account);

        model.addAttribute("user", userRepository.findById(userid));
        model.addAttribute("accounts", accountRepository.findByuserid(userid));
        model.addAttribute("addresses", addressRepository.findByuserid(userid));
        model.addAttribute("telephones", telephoneRepository.findByUserid(userid));
        return "user";
    }
}

