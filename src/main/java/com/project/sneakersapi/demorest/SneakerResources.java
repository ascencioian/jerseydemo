package com.project.sneakersapi.demorest;

import java.util.List;
import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;

@Path("sneakers")
public class SneakerResources {
	
	SneakerRepository repo = new SneakerRepository();
	
	//------------------GET	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Sneaker> getSneakers()
	{
		System.out.println("getSneakers called");
		
		return repo.getSneakers();
	}
	
	@GET
	@Path("/sneaker/{sku}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Sneaker getSneaker(@PathParam("sku") String sku) {
		System.out.println("getSneaker called");
		System.out.println(repo.getSneaker(sku));
		return repo.getSneaker(sku);
	}
	
	//----------------DELETE
	@DELETE
	@Path("/sneaker/{sku}")
	public Sneaker deleteSneaker(@PathParam("sku") String sku) {
		System.out.println("deleteSneaker called");
		System.out.println(sku);
		Sneaker a = repo.getSneaker(sku);
		System.out.println(a.getName() + " " + a.getColorway());
		String skuToDelete = a.getSku();
		System.out.println(skuToDelete);
	if(a.getSku() != null) {
		repo.deleteSneaker(skuToDelete);
	}
		
		return a;
		
		
		
	}
	
	//------------------POST
	@POST
	@Path("sneaker")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Sneaker createSneaker(Sneaker s1) {
		System.out.println(s1);
		
		repo.createSneaker(s1);
		
		return s1;
	}
	
	//------------------PUT
	
	@PUT
	@Path("sneaker")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Sneaker updateSneaker(Sneaker s1) {
		System.out.println(s1);
		
		repo.updateSneaker(s1);
		
		return s1;
	}
	
}


//to fetch from database write JDBC code or hibernate framework, get object from database and return it