package jpa.dao;

import java.util.List;

import jpa.entitymodels.Sneaker;

public interface SneakerDao {

	List<Sneaker> getAllCourses();

	Sneaker getSneakerBySku(String Sku);
}
