package juno.springboot.junopetclinic.Controller;

import juno.springboot.junopetclinic.Model.Owner;
import juno.springboot.junopetclinic.Services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"/owners", "/owners/index", "/owners/index.html"})
    public String listOwners(Model model) {

        model.addAttribute("ownerList", ownerService.findAll());

        Set<Owner> listOfOwners = ownerService.findAll();
        listOfOwners.forEach(owner -> {
            System.out.println(owner.getId());
            System.out.println(owner.getFirstName());
            System.out.println(owner.getLastName());
            System.out.println(owner.getAddress());
            System.out.println(owner.getCity());
            System.out.println(owner.getContactNumber());
            owner.getPets().forEach(pet -> {
                System.out.println(pet.getName());
                System.out.println(pet.getId());
                System.out.println(pet.getDateOfBirth());
                System.out.println(pet.getPetType().getId());
                System.out.println(pet.getPetType().getName());
            });
        });

        return "owners/index";
    }


}
