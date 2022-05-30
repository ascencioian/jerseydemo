package com.project.sneakersapi.demorest;

import java.util.ArrayList;
import java.util.List;

public class SneakerRepository {

	List<Sneaker> sneakers;
	
	public SneakerRepository() {
		
		sneakers = new ArrayList<Sneaker>();
		
		//static test data
		Sneaker s1 = new Sneaker();
		
		s1.setSku("MSVRCSSN");
		s1.setName("Jaden Smith x Vision Racer 'Sunset Chaser - White Mirage Violet'");
		s1.setBrand("New Balance");
		s1.setGender("men");
		s1.setColorway("New Balance White/Mirage Violet");
		s1.setReleasedate("2022-05-27");
		s1.setRetailprice(150);
		s1.setMarketvalue(445);
		s1.setImage("image url");
		
		Sneaker s2 = new Sneaker();
		
		s2.setSku("207393-30T");
		s2.setName("Salehe Bembury x Pollex Clog 'Crocodile");
		s2.setBrand("Crocs");
		s2.setGender("men");
		s2.setColorway("Crocodile");
		s2.setReleasedate("2022-05-24");
		s2.setRetailprice(85);
		s2.setMarketvalue(230);
		s2.setImage("image url");
		
		sneakers.add(s1);
		sneakers.add(s2);
	}
	
	//return all Sneakers
	public List<Sneaker> getSneakers(){
		return sneakers;
	}
	
	//return a single sneaker
	public Sneaker getSneaker(String sku) {
		for(Sneaker s: sneakers) {
			if(s.getSku().contains(sku)) {
				return s;
			}
		}
		//does not matter what we return here
		System.out.println("sneaker not in repo");
		return new Sneaker();	
	}
	
	//create a sneaker with post request and postman
	public void createSneaker(Sneaker s1) {
		sneakers.add(s1);
	}
	
	//delete sneaker
	public void deleteSneaker(String sku) {
		for(Sneaker s: sneakers) {
			if(s.getSku().contains(sku)) {
				sneakers.remove(s);
				System.out.println("sneaker deleted");
			}
			//does not matter what we return here
			System.out.println("sneaker not in repo");
	}
}
}
