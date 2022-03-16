package com.mycompany.P_details;


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
public class P_detailsController {
    @Autowired private P_detailsService service2;

   @GetMapping("/P_details")
    public String showP_detailsList(Model model){
       List<P_details> listP_details=service2.listall();
       model.addAttribute("listP_details",listP_details);
       return "P_details";
   }
   @GetMapping("/P_details/new")
    public String showNewP_detailsForm(Model model){
       model.addAttribute("p_details",new P_details());
       model.addAttribute("pageTitle","Nieuwe info patiënt toevoegen");
       return "P_detailsForm";
   }
   @PostMapping("/P_details/save")
    public  String saveP_details(P_details p_details, RedirectAttributes ra){
       service2.save(p_details);
       ra.addFlashAttribute("message","De info is opgeslagen.");
       return "redirect:/P_details";
   }
   @GetMapping("/P_details/edit/{id}")
    public String showP_detailsEditForm(@PathVariable("id")Integer id,Model model,RedirectAttributes ra){
       try{
           P_details p_details=service2.get(id);
           model.addAttribute("p_details",p_details);
           model.addAttribute("pageTitle","Patiënt info bewerken(ID:"+id+ ")");
           return "P_detailsForm";
       }catch (P_detailsNotFoundException e){
           ra.addFlashAttribute("message",e.getMessage());
           return "redirect:P_details";
       }
   }
   @GetMapping("/P_details/delete/{id}")
    public String deleteP_details(@PathVariable("id")Integer id,RedirectAttributes ra)
   {
       try{
           service2.delete(id);
           ra.addFlashAttribute("message","De info van ID"+id+"is verwijderd.");

       }catch (P_detailsNotFoundException e){
           ra.addFlashAttribute("message",e.getMessage());
       }
       return"redirect:/P_details";
   }
    @RequestMapping("/P_details")
    public String P_details() {
        return "P_details";
    }
    // hier moet er nog andere mappings geplaats worden die naar de webpages verwijzen

}
