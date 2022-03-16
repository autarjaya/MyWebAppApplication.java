package com.mycompany.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @Autowired private UserService service;

    @GetMapping("/users")
    public  String showUserList(Model model){
        List<User> listUsers = service.listall();
        model.addAttribute("listUsers",listUsers);

        return "users";
    }

    @GetMapping("/users/new")
    public String showNewForm(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("pageTitle", "Nieuwe patiënt toevoegen");
        return "user_form";
    }
    @PostMapping("/users/save")
    public String saveUser(User user, RedirectAttributes ra){
        service.save(user);
        ra.addFlashAttribute("message","Patiënt succesvol opgeslagen.");
        return "redirect:/users";
    }
    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable("id")Integer id,Model model, RedirectAttributes ra  ){
       try{
        User user =service.get(id);
        model.addAttribute("user",user);
        model.addAttribute("pageTitle", "Bewerking info van patient met (ID: "+id+ ")");

        return "user_form";
    } catch (UserNotFoundException e){
           ra.addFlashAttribute("message",e.getMessage());
           return "redirect:/users";
       }
    }
    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id")Integer id, RedirectAttributes ra  )
    {
        try{
          service.delete(id);
            ra.addFlashAttribute("message","De info van ID "+id+ " is verwijderd.");


        } catch (UserNotFoundException e){
            ra.addFlashAttribute("message",e.getMessage());

        }
        return "redirect:/users";
    }

    // code for viewing different webpages
    // Request om van 1 webpage naar een andere te gaan wordt door de "controller" behandeld.
    // Dus de mapping moet eerst in de controller gedaan worden voordat men naar een andere webpage wilt, dat is standaard in Spring Framework

    @RequestMapping("/covid-19")
    public String covid19() {
        return "covid-19";
    }

    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @RequestMapping("login_frontp2")
    public String loginfp2(){
        return "login";
    }

    @RequestMapping("Ziekte1")
    public String ziekte1(){return  "ziekte1";}

    @RequestMapping("Ziekte2")
    public String ziekte2(){return  "ziekte2";}

    @RequestMapping("Ziekte3")
    public String ziekte3(){return  "ziekte3";}
}
