package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.model.Country;
import com.example.demo.service.cityService.CityServiceImpl;
import com.example.demo.service.countryService.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/city")
public class CityController {
    @Autowired
    public CityServiceImpl cityService;

    @Autowired
    public CountryService countryService;

    @GetMapping("/detail/{id}")
    public ModelAndView detailCity(@PathVariable("id") Integer id) {
        City city = cityService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("city", city);
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView listCity() {
        Iterable<City> cities = cityService.findAll();
        ModelAndView modelAndView = new ModelAndView("listcity");
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        Iterable<Country> countries = countryService.findAll();
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("countries", countries);
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createCity(@Validated @ModelAttribute("city") City city, BindingResult bindingResult, RedirectAttributes redirect) {
        Iterable<Country> countries = countryService.findAll();
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("create");
            modelAndView.addObject("countries", countries);
            return modelAndView;
        }
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("listcity");
        modelAndView.addObject("message", "Thêm thành phố mới thành công!");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable("id") Integer id) {
        Iterable<Country> countries = countryService.findAll();
        City city = cityService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("countries", countries);
        modelAndView.addObject("city", city);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String editCity(@ModelAttribute("city") City city, RedirectAttributes redirect) {
        cityService.save(city);
        redirect.addFlashAttribute("message", "Chỉnh sửa thành phố thành công!");
        return "redirect:/city/list";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable("id") Integer id) {
        City city = cityService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("city", city);
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteCity(@ModelAttribute("city") City city, RedirectAttributes redirect) {
        cityService.delete(city);
        redirect.addFlashAttribute("message", "Đã xóa thành phố bạn vừa chọn!");
        return "redirect:/city/list";
    }
}
