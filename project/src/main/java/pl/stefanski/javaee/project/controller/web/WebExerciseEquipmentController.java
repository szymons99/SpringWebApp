package pl.stefanski.javaee.project.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.stefanski.javaee.project.domain.ExerciseEquipment;
import pl.stefanski.javaee.project.domain.UserManual;
import pl.stefanski.javaee.project.service.ExerciseEquipmentService;

import javax.validation.Valid;

@Controller
public class WebExerciseEquipmentController {
    private final ExerciseEquipmentService exerciseEquipmentService;

    public WebExerciseEquipmentController(ExerciseEquipmentService exerciseEquipmentService) {
        this.exerciseEquipmentService = exerciseEquipmentService;
    }

    @GetMapping("/exerciseEquipment")
    public String getAll(Model model) {
        model.addAttribute("exerciseEquipments", exerciseEquipmentService.getAll());
        return "exerciseEquipment-list";
    }

    @GetMapping("/exerciseEquipment/create")
    public String createForm(Model model) {
        ExerciseEquipment exerciseEquipment = new ExerciseEquipment();
        exerciseEquipment.setUserManual(new UserManual());

        model.addAttribute("exerciseEquipment", exerciseEquipment);
        model.addAttribute("producers", exerciseEquipmentService.getProducers());
        model.addAttribute("distributors", exerciseEquipmentService.getDistributors());
        return "exerciseEquipment-create";
    }

    @PostMapping("/exerciseEquipment")
    public String create(@ModelAttribute("exerciseEquipment") @Valid ExerciseEquipment exerciseEquipment, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("producers", exerciseEquipmentService.getProducers());
            model.addAttribute("distributors", exerciseEquipmentService.getDistributors());
            return "exerciseEquipment-create";
        }
        exerciseEquipmentService.create(exerciseEquipment);
        return "redirect:/exerciseEquipment";
    }

    @GetMapping("/exerciseEquipment/update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        model.addAttribute("exerciseEquipment", exerciseEquipmentService.getOne(id));
        model.addAttribute("producers", exerciseEquipmentService.getProducers());
        model.addAttribute("distributors", exerciseEquipmentService.getDistributors());
        return "exerciseEquipment-update";
    }

    @PostMapping("/exerciseEquipment/{id}")
    public String update(@ModelAttribute("exerciseEquipment") @Valid ExerciseEquipment exerciseEquipment, BindingResult bindingResult, @PathVariable Long id, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("producers", exerciseEquipmentService.getProducers());
            model.addAttribute("distributors", exerciseEquipmentService.getDistributors());
            return "exerciseEquipment-update";
        }
        exerciseEquipmentService.update(id, exerciseEquipment);
        return "redirect:/exerciseEquipment";
    }

    @GetMapping("/exerciseEquipment/delete/{id}")
    public String delete(@PathVariable Long id) {
        exerciseEquipmentService.delete(id);
        return "redirect:/exerciseEquipment";
    }
}
