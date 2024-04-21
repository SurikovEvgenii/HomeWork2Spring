package org.surikov.top.springshops.controller;

import org.surikov.top.springshops.dao.ShopJDBCDao;
import org.surikov.top.springshops.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
@RequestMapping(value = "/shops")
public class ShopsController {

    private ShopJDBCDao shopDao;

    @Autowired
    public ShopsController(ShopJDBCDao shopDao) {
        this.shopDao = shopDao;
    }

    @GetMapping
    public String index(Model model) throws ClassNotFoundException {
        model.addAttribute("shops", shopDao.findAll());
        return "shops/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("shop", shopDao.find(id));
        return "shops/show";
    }

    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("shop", new Shop());
        return "shops/new";
    }

    @PostMapping
    public String create(@ModelAttribute("shop") Shop shop){
        shopDao.save(shop);
        return "redirect:/shops";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("shop", shopDao.find(id));
        return "shops/edit";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("shop") Shop shop){
        shopDao.update(id,shop);
        return "redirect:/shops";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        shopDao.delete(id);
        return "redirect:/shops";
    }

}
