package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Bid;
import com.nnk.springboot.services.BidService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bidList")
public class BidController {

    @Autowired
    private BidService bidService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("bidLists", bidService.findAll());
        return "bidList/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("bidList", new Bid());
        return "bidList/add";
    }

    @PostMapping("/validate")
    public String validate(@Valid @ModelAttribute("bidList") Bid bidList, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "bidList/add";
        }
        bidService.save(bidList);
        return "redirect:/bidList/list";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Bid bidList = bidService.findById(id);
        model.addAttribute("bidList", bidList);
        return "bidList/update";
    }

    @PostMapping("/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid @ModelAttribute("bidList") Bid bidList,
                            BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "bidList/update";
        }
        bidList.setBidListId(id);
        bidService.save(bidList);
        return "redirect:/bidList/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {
        bidService.delete(id);
        return "redirect:/bidList/list";
    }
}
