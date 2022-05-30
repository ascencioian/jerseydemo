package com.project.sneakersapi.demorest;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class SneakerRepository {
	//static test data
	//List<Sneaker> sneakers;
	Connection conn = null;
	
	public SneakerRepository() {
		
		String url =  "jdbc:mariadb://localhost:3306/sneakers"; 
		String USER = "root";
		String PASS = "password";
		String drivername = "org.mariadb.jdbc.Driver";
		try {
			Class.forName(drivername);
			Connection conn = DriverManager.getConnection(url, USER, PASS);
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		
		
		//static test data
		/*
		sneakers = new ArrayList<Sneaker>();
		

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
		*/
	}
	
	//return all Sneakers
	public List<Sneaker> getSneakers(){
		List<Sneaker> sneakers = new ArrayList<Sneaker>();
		
		String sql = "select * from sneaker";
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Sneaker s = new Sneaker();
				s.setSku(rs.getString(1));
				s.setName(rs.getString(2));
				s.setBrand(rs.getString(3));
				s.setGender(rs.getString(4));
				s.setColorway(rs.getString(5));
				s.setReleasedate(rs.getString(6));
				s.setRetailprice(rs.getInt(7));
				s.setMarketvalue(rs.getInt(8));
				s.setImage(rs.getString(9));
				
				sneakers.add(s);
			}
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		return sneakers;
	}
	
	//return a single sneaker
	public Sneaker getSneaker(String sku) {
		Sneaker s = new Sneaker();
		String sql = "select * from sneaker where sku=" + sku;
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				s.setSku(rs.getString(1));
				s.setName(rs.getString(2));
				s.setBrand(rs.getString(3));
				s.setGender(rs.getString(4));
				s.setColorway(rs.getString(5));
				s.setReleasedate(rs.getString(6));
				s.setRetailprice(rs.getInt(7));
				s.setMarketvalue(rs.getInt(8));
				s.setImage(rs.getString(9));
			}
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		return s;
		
	}
	
	public void createSneaker(Sneaker s1) {
		
		String sql = "insert into sneaker values (?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, s1.getSku());
			st.setString(1, s1.getName());
			st.setString(1, s1.getBrand());
			st.setString(1, s1.getGender());
			st.setString(1, s1.getColorway());
			st.setString(1, s1.getReleasedate());
			st.setInt(1, s1.getRetailprice());
			st.setInt(1, s1.getMarketvalue());
			st.setString(1, s1.getImage());
			st.executeUpdate();
		
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	
	
}
