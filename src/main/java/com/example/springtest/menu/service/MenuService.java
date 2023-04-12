package com.example.springtest.menu.service;

import com.example.springtest.menu.dto.CategoryDTO;
import com.example.springtest.menu.dto.MenuDTO;
import com.example.springtest.menu.entity.Category;
import com.example.springtest.menu.entity.Menu;
import com.example.springtest.menu.repository.MenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MenuService
{
    @PersistenceContext
    private EntityManager em;

    private ModelMapper modelMapper;

    private MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository, ModelMapper modelMapper)
    {
        this.menuRepository = menuRepository;
        this.modelMapper = modelMapper;
    }


    public List<MenuDTO> findAllMenu()
    {
        List<Menu> menuList = menuRepository.findAllMenu(em);

        return menuList.stream().map(menu -> modelMapper.map(menu,MenuDTO.class))
                .collect(Collectors.toList());

    }
    @Transactional
    public void menuRegist(MenuDTO menu)
    {
        menuRepository.menuRegist(em,modelMapper.map(menu, Menu.class));
    }

    public List<CategoryDTO> findCategory()
    {
        List<Category> category = menuRepository.findCategory(em);
        return category.stream().map(c -> modelMapper.map(c, CategoryDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public void modifyMenu(MenuDTO menu)
    {
        menuRepository.modify(em,modelMapper.map(menu,Menu.class));
    }

    @Transactional
    public void deleteMenuCode(int menuCode)
    {
        menuRepository.delete(em,menuCode);
    }

    public MenuDTO findMenu(int code)
    {
        log.info("g2");
        Menu menu = menuRepository.findMenu(em,code);
        log.info("Q2");
        return modelMapper.map(menu,MenuDTO.class);
    }
}
