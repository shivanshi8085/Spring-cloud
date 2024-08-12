package com.rays.service01.config;

import org.springframework.batch.item.ItemProcessor;

import com.rays.service01.dto.Product;

public class CustomItemProcessor implements ItemProcessor<Product, Product> {
	@Override
	public Product process(Product item) throws Exception {
		try {
			System.out.println(item.getDescription());
			// Assuming description is already a string, no need to parse it
			// Convert discount to double directly
			double discountPer = Double.parseDouble(item.getDiscount().trim());
			double originalPrice = Double.parseDouble(item.getPrice().trim());
			double discount = (discountPer / 100) * originalPrice;
			double finalPrice = originalPrice - discount;
			item.setDiscountedPrice(String.valueOf(finalPrice));
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
		}
		return item;
	}
}
