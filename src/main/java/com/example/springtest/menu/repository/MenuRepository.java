package com.example.springtest.menu.repository;

import com.example.springtest.menu.dto.CategoryDTO;
import com.example.springtest.menu.dto.MenuDTO;
import com.example.springtest.menu.entity.Category;
import com.example.springtest.menu.entity.Menu;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MenuRepository
{
    private ModelMapper modelMapper;

    public MenuRepository(ModelMapper modelMapper)
    {
        this.modelMapper = modelMapper;
    }

    public List<Menu> findAllMenu(EntityManager em)
    {
        String jpql = "SELECT m FROM Menu m ORDER BY m.menuCode ASC";
        return em.createQuery(jpql, Menu.class).getResultList();
    }

    public void menuRegist(EntityManager em, Menu menu)
    {
        em.persist(menu);
    }

    public List<Category> findCategory(EntityManager em)
    {
        String jpql = "SELECT c FROM Category c ORDER BY c.categoryCode ASC";
        return em.createQuery(jpql,Category.class).getResultList();
    }

    public void modify(EntityManager em, Menu newMenu)
    {
        Menu menu = em.find(Menu.class,newMenu.getMenuCode());
        menu.setMenuName(newMenu.getMenuName());
        menu.setMenuPrice(newMenu.getMenuPrice());
        menu.setCategoryCode(newMenu.getCategoryCode());
        menu.setOrderableStatus(newMenu.getOrderableStatus());
    }


    public void delete(EntityManager em, int menuCode)
    {
       em.remove(em.find(Menu.class,menuCode));
    }

    public Menu findMenu(EntityManager em, int code)
    {
        return em.find(Menu.class,code);
    }
}
