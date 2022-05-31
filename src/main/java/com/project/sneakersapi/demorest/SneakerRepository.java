package com.project.sneakersapi.demorest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SneakerRepository {
	
	Connection conn = null;
	
	//---------------------connect to database with JBDC
	public SneakerRepository() {
		
		
		
		String url =  "jdbc:mariadb://localhost:3306/sneakers"; 
		String USER = "root";
		String PASS = "password";
		String drivername = "org.mariadb.jdbc.Driver";
		try {
			Class.forName(drivername);
			conn = DriverManager.getConnection(url, USER, PASS);

		}
		catch(Exception e){
			System.out.println(e);
		}

	}
	
	//------------------------return all Sneakers from DB
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
	
	//---------------------------return a single sneaker
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
	
	//-------------------create a sneaker 
	public void createSneaker(Sneaker s1) {
		

		String sql = "insert into sneaker values (?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, s1.getSku());
			st.setString(2, s1.getName());
			st.setString(3, s1.getBrand());
			st.setString(4, s1.getGender());
			st.setString(5, s1.getColorway());
			st.setString(6, s1.getReleasedate());
			st.setInt(7, s1.getRetailprice());
			st.setInt(8, s1.getMarketvalue());
			st.setString(9, s1.getImage());
			st.executeUpdate();

		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}
	
	//-----------------------update a sneaker
public void updateSneaker(Sneaker s1) {
		

		String sql = "insert into sneaker values (?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, s1.getSku());
			st.setString(2, s1.getName());
			st.setString(3, s1.getBrand());
			st.setString(4, s1.getGender());
			st.setString(5, s1.getColorway());
			st.setString(6, s1.getReleasedate());
			st.setInt(7, s1.getRetailprice());
			st.setInt(8, s1.getMarketvalue());
			st.setString(9, s1.getImage());
			st.executeUpdate();

		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}

}
