package com.example.springtest.menu.controller;

import com.example.springtest.menu.dto.CategoryDTO;
import com.example.springtest.menu.dto.MenuDTO;
import com.example.springtest.menu.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/menu/")
public class MenuController
{
    private MenuService menuService;

    public MenuController(MenuService menuService)
    {
        this.menuService = menuService;
    }

    @GetMapping("list")
    public String foundAllMenu(Model model)
    {
        List<MenuDTO> menu = menuService.findAllMenu();
        model.addAttribute("menu",menu);
        return "menu/list";
    }

    @GetMapping("regist")
    public void menuRegist() {}

    @GetMapping(value = "category" , produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<CategoryDTO> findCategory()
    {
        return menuService.findCategory();
    }

    @PostMapping("regist")
    public String menuNewRegist(@ModelAttribute MenuDTO menu)
    {
        menuService.menuRegist(menu);
        return "redirect:/menu/list";
    }

    @GetMapping("modify")
    public void modify(){}

    @PostMapping("modify")
    public String menuModify(@ModelAttribute MenuDTO menu)
    {
        menuService.modifyMenu(menu);

        return "redirect:/menu/list";
    }

    @GetMapping("delete")
    public String menuDeletePage(Model model)
    {
        List<MenuDTO> menu = menuService.findAllMenu();
        model.addAttribute("menu",menu);
        return "/menu/delete";
    }

    @PostMapping("delete")
    public String deleteMenu1(@RequestParam("menuCode") int menuCode)
    {
        log.info("menuCode = " + menuCode);
       menuService.deleteMenuCode(menuCode);
        return "redirect:/menu/list";
    }

    @GetMapping("search")
    public void searchPage(){}

    @PostMapping ("search")
    public String searchCode(@ModelAttribute MenuDTO menuD,Model model)
    {
        log.info("code : " + menuD);
        MenuDTO menu = menuService.findMenu(menuD.getMenuCode());
        model.addAttribute("menu",menu);
        return "/menu/searchResult";
    }


}
