package com.turling.controller;

import com.turling.entity.Menu;
import com.turling.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/findAll")
    @ResponseBody
    public List<Menu> findAll(){
        List<Menu> list=new ArrayList<>();
        Menu m=new Menu();
        m.setId(1);
        m.setName("系统设置");
        m.setPid(0);
        list.add(m);
        return list;
    }

    @GetMapping("/showMenu")
    @ResponseBody
    public List<Menu> showMenu(){
        return menuService.findAll();
    }


    @GetMapping("/showMenu2")
    @ResponseBody
    public List<Menu> showMenu2(){
        return menuService.findAllMenu();
    }

}
