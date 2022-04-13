package com.mycompany.Appointments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AppointmentsController {
    @Autowired
    private AppointmentsService service5;

    @GetMapping("/Appointments")
    public String showAppointmentsList(Model model){
        List<Appointments> listAppointments=service5.listall();
        model.addAttribute("listAppointments",listAppointments);
        return "Appointments";
    }
    @GetMapping("/Appointments/new")
    public String showNewAppointmentsForm(Model model){
        model.addAttribute("appointments",new Appointments());
        model.addAttribute("pageTitle","Nieuwe info toevoegen");
        return "AppointmentsForm";
    }
    @PostMapping("/Appointments/save")
    public String saveAppointments(Appointments appointments, RedirectAttributes ra){
        service5.save(appointments);
        ra.addFlashAttribute("message","De nieuwe informatie is opgeslagen.");
        return "redirect:/Appointments";
    }
    @GetMapping("/Appointments/edit/{id}")
    public String showAppointmentsEditForm(@PathVariable("id")Integer id,Model model,RedirectAttributes ra){
        try{
            Appointments appointments=service5.get(id);
            model.addAttribute("appointments",appointments);
            model.addAttribute("pageTitle","Info bewerken(ID:"+id+")");
            return "AppointmentsForm";
        }catch (AppointmentsNotFoundException e){
            ra.addFlashAttribute("message",e.getMessage());
            return "redirect:/Appointments";
        }
    }
    @GetMapping("/Appointments/delete/{id}")
    public String deleteAppointments(@PathVariable("id")Integer id,RedirectAttributes ra){
        try{
            service5.delete(id);
            ra.addFlashAttribute("message","De informatie is verwijderd");
        }catch (AppointmentsNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/Appointments";
    }
}