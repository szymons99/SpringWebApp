package pl.stefanski.javaee.project.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.stefanski.javaee.project.domain.Distributor;
import pl.stefanski.javaee.project.domain.Producer;
import pl.stefanski.javaee.project.service.DistributorService;

import javax.validation.Valid;

@Controller
public class WebDistributorController {
    private final DistributorService distributorService;

    public WebDistributorController(DistributorService distributorService) {
        this.distributorService = distributorService;
    }

    @GetMapping("/distributor")
    public String getAll(Model model) {
        model.addAttribute("distributors", distributorService.getAll());
        return "distributor-list";
    }

    @GetMapping("/distributor/create")
    public String createForm(Model model) {
        model.addAttribute("distributor", new Distributor());
        return "distributor-create";
    }

    @PostMapping("/distributor")
    public String create(@ModelAttribute("distributor") @Valid Distributor distributor, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "distributor-create";
        }
        return "redirect:/distributor";
    }

    @GetMapping("/distributor/update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        model.addAttribute("distributor", distributorService.getOne(id));
        return "distributor-update";
    }

    @PostMapping("/distributor/{id}")
    public String update(@ModelAttribute("distributor") @Valid Distributor distributor, BindingResult bindingResult, @PathVariable Long id) {
        if (bindingResult.hasErrors()) {
            return "distributor-update";
        }
        distributorService.update(id, distributor);
        return "redirect:/distributor";
    }

    @GetMapping("/distributor/delete/{id}")
    public String delete(@PathVariable Long id) {
        distributorService.delete(id);
        return "redirect:/distributor";
    }
}
