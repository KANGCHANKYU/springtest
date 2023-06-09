package com.example.springtest.menu.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
public class CategoryDTO
{
    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;
}
