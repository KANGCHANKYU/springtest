package com.example.springtest.menu.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_CATEGORY")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Category
{
    @Id @Column(name = "CATEGORY_CODE")
    private int categoryCode;
    @Column(name = "CATEGORY_NAME")
    private String categoryName;
    @Column(name = "REF_CATEGORY_CODE")
    private Integer refCategoryCode;

    @Override
    public String toString() {
        return "CategoryAndMenu{" +
                "categoryCode=" + categoryCode +
                ", categoryName='" + categoryName + '\'' +
                ", refCategoryCode=" + refCategoryCode +
                '}';
    }
}
