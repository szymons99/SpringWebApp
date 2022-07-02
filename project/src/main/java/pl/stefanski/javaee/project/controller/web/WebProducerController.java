package pl.stefanski.javaee.project.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.stefanski.javaee.project.domain.Producer;
import pl.stefanski.javaee.project.service.ProducerService;

import javax.validation.Valid;

@Controller
public class WebProducerController {
    private final ProducerService producerService;

    public WebProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping("/producer")
    public String getAll(Model model) {
        model.addAttribute("producers", producerService.getAll());
        return "producer-list";
    }

    @GetMapping("/producer/create")
    public String createForm(Model model) {
        model.addAttribute("producer", new Producer());
        return "producer-create";
    }

    @PostMapping("/producer")
    public String create(@ModelAttribute("producer") @Valid Producer producer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "producer-create";
        }
        return "redirect:/producer";
    }

    @GetMapping("/producer/update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        model.addAttribute("producer", producerService.getOne(id));
        return "producer-update";
    }

    @PostMapping("/producer/{id}")
    public String update(@ModelAttribute("producer") @Valid Producer producer, BindingResult bindingResult, @PathVariable Long id) {
        if (bindingResult.hasErrors()) {
            return "producer-update";
        }
        producerService.update(id, producer);
        return "redirect:/producer";
    }

    @GetMapping("/producer/delete/{id}")
    public String delete(@PathVariable Long id) {
        producerService.delete(id);
        return "redirect:/producer";
    }
}
