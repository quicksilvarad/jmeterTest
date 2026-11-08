package com.quicksilvarad.jmeterTest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {

    private String customer_name;
    private String last_name;
    private String email;
    private String address;
    private String item_qty;
}
