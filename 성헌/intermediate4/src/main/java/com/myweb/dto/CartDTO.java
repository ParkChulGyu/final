package com.myweb.dto;

import lombok.Data;

@Data
public class CartDTO {
	private int cart_idx;
	private String user_id;
    private String title_name;
    private String category;
    
}