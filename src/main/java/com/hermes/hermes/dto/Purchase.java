package com.hermes.hermes.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int purchase_reg_num;
    private int purchase_product_reg_num;
    private String purchase_order_id;
    private int purchase_product_size;
    private String purchase_user_id;
    private String purchase_date;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date purchase_time;
    private String purchase_status;
}
