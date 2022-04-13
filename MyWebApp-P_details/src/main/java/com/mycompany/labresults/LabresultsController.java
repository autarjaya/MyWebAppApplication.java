package com.mycompany.labresults;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.*;

import java.util.*;

@Controller
public class LabresultsController {

    @Autowired
    private LabresultsService service3;

    @GetMapping("/Labresults")
    public String showLabresultsList(Model model){
        List<Labresults> listLabresults=service3.listall();
        model.addAttribute("listLabresults",listLabresults);
        return "Labresults";
    }
    @GetMapping("/Labresults/new")
    public String showNewLabresultsForm(Model model){
        model.addAttribute("labresults",new Labresults());
        model.addAttribute("pageTitle","Nieuwe labresultaat toevoegen");
        return "LabresultsForm";
    }
    @PostMapping("/Labresults/save")
    public  String saveLabresults(Labresults labresults, RedirectAttributes ra){
        service3.save(labresults);
        ra.addFlashAttribute("message","Het labresultaat is opgeslagen.");
        return "redirect:/Labresults";
    }
    @GetMapping("/Labresults/edit/{id}")
    public String showLabresultsEditForm(@PathVariable("id")Integer id,Model model,RedirectAttributes ra){
        try{
            Labresults labresults =service3.get(id);
            model.addAttribute("labresults",labresults);
            model.addAttribute("pageTitle","Labresultaat bewerken(ID:"+id+ ")");
            return "LabresultsForm";

        }catch ( LabresultsNotFoundException e){
            ra.addFlashAttribute("message",e.getMessage());
            return "redirect:Labresults";
        }
    }
    @GetMapping("/Labresults/delete/{id}")
    public String deleteLabresults(@PathVariable("id")Integer id,RedirectAttributes ra)
    {
        try{
            service3.delete(id);
            ra.addFlashAttribute("message","Het labresultaat van ID"+id+"is verwijderd.");

        }catch (LabresultsNotFoundException e){
            ra.addFlashAttribute("message",e.getMessage());
        }
        return"redirect:/Labresults";
    }
    @RequestMapping("/Labresults")
    public String Labresults() {
        return "Labresults";
    }
    // hier moet er nog andere mappings geplaats worden die naar de webpages verwijzen

}
