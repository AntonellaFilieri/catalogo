package com.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.model.impl.Book;
import com.model.impl.Food;
import com.model.impl.Medical;

public class TestProduct {

	@Test
	public void testEmptyProduct() {
		Book book = new Book();
		assertEquals(null, book.getProductName());

		Food food = new Food();
		assertEquals(null, food.getProductName());

		Medical medical = new Medical();
		assertEquals(null, medical.getProductName());

	}

	@Test
	public void testProduct() {
		
		Book book = new Book("Java for dummies");
		Food food = new Food("Spaghetti Barilla");
		Medical medical = new Medical("Aspirina");
		
		assertEquals("Java for dummies", book.getProductName());
		assertEquals("Spaghetti Barilla", food.getProductName());
		assertEquals("Aspirina", medical.getProductName());

		Book book2 = new Book("Java for dummies", 20.23);
		Food food2 = new Food("Spaghetti Barilla", 12.5);
		Medical medical2 = new Medical("Aspirina", 8.3);
		
		assertEquals("Java for dummies", book2.getProductName());
		assertEquals(20.23, book2.getPrice(), 0);
		assertEquals("Spaghetti Barilla", food2.getProductName());
		assertEquals(12.5, food2.getPrice(), 0);
		assertEquals("Aspirina", medical2.getProductName());
		assertEquals(8.3, medical2.getPrice(), 0);

		Book book3 = new Book("Java for dummies", 20.23, ProductOrigin.LOCAL);
		Food food3 = new Food("Spaghetti Barilla", 12.5, ProductOrigin.IMPORTED);
		Medical medical3 = new Medical("Aspirina", 8.3, ProductOrigin.LOCAL);
		
		assertEquals("Java for dummies", book3.getProductName());
		assertEquals(20.23, book3.getPrice(), 0);
		assertEquals(ProductOrigin.LOCAL, book3.getProductOrigin());

		assertEquals("Spaghetti Barilla", food3.getProductName());
		assertEquals(12.5, food3.getPrice(), 0);
		assertEquals(ProductOrigin.IMPORTED, food3.getProductOrigin());

		assertEquals("Aspirina", medical3.getProductName());
		assertEquals(8.3, medical3.getPrice(), 0);
		assertEquals(ProductOrigin.LOCAL, medical3.getProductOrigin());

	}

	@Test
	public void testDefaultLocalProduct() {
		Book book = new Book("ttd book");
		assertEquals("ttd book", book.getProductName());
		assertEquals(ProductOrigin.LOCAL, book.getProductOrigin());

		Food food = new Food("spaghetti");
		assertEquals("spaghetti", food.getProductName());
		assertEquals(ProductOrigin.LOCAL, book.getProductOrigin());

		Medical medical = new Medical("aspririna");
		assertEquals("aspririna", medical.getProductName());
		assertEquals(ProductOrigin.LOCAL, book.getProductOrigin());

	}

	@Test
	public void testIsImportedPoduct() {
		Book book = new Book("ttd book");
		book.setOrigin(ProductOrigin.LOCAL);
		assertEquals("ttd book", book.getProductName());
		assertEquals(false, book.isImported());

		Food food = new Food("spaghetti");
		food.setOrigin(ProductOrigin.IMPORTED);
		assertEquals("spaghetti", food.getProductName());
		assertEquals(true, food.isImported());

		Medical medical = new Medical("aspririna");
		medical.setOrigin(ProductOrigin.IMPORTED);
		assertEquals("aspririna", medical.getProductName());
		assertEquals(true, medical.isImported());

	}

}
