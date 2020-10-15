package com.turling.service;

import com.turling.entity.Menu;

import java.util.List;

public interface MenuService {
    public List<Menu> findAll();

    public List<Menu> findAllMenu();
}
