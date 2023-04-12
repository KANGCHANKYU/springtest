package com.example.springtest.menu.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TBL_MENU")
@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
@ToString
@SequenceGenerator(
        name = "SEQ_MENU_CODE_GENERATOR", // 해당 시퀀스 설정에 대한 이름
        sequenceName = "SEQ_MENU_CODE", // 사용할 시퀀스 이름
        initialValue = 100, // 초기값인데 아무 값이라도 지정은 해주어야 한다.(DB의 설정을 따름)
        allocationSize = 1 // 증가값
)
public class Menu
{
    @Id
    @Column(name = "MENU_CODE")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, // 값 생성 시 시퀀스 전략을 이용하겠다는 설정
            generator = "SEQ_MENU_CODE_GENERATOR" // 사용할 시퀀스 설정 이름
    )
    private int menuCode;

    @Column(name = "MENU_NAME")
    private String menuName;

    @Column(name = "MENU_PRICE")
    private int menuPrice;

    @Column(name = "CATEGORY_CODE")
    private int categoryCode;

    @Column(name = "ORDERABLE_STATUS")
    private String orderableStatus;

}
