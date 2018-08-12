package juno.springboot.junopetclinic.Controller;

import juno.springboot.junopetclinic.Services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets/index", "/vets/index.html","/vets.html"})
    public String listVets(Model model) {
        model.addAttribute("vetList", vetService.findAll());

        vetService.findAll().forEach(vet -> {
            System.out.println(vet.getId());
            System.out.println(vet.getFirstName());
            vet.getSpecialties().forEach(speciality -> {
                System.out.println(speciality.getId());
                System.out.println(speciality.getDescription());
            });
        });

        return "vets/index";
    }



}
