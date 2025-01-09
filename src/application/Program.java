package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("  === TEST 1: seller findById ===\n");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n\n  === TEST 2: seller findByDepartment ===\n");
		Department department = new Department(2, null);
		List<Seller> sellerList = sellerDao.findByDepartment(department);
		sellerList.forEach(System.out::println);
		
		System.out.println("\n\n  === TEST 3: seller findAll ===\n");
		sellerList = sellerDao.findAll();
		sellerList.forEach(System.out::println);
		
		System.out.println("\n\n  === TEST 4: seller insert ===\n");
		seller = new Seller(null, "Greg", "greg@outlook.com", new Date(), 4000.0, department);
		sellerDao.insert(seller);
		System.out.println("Inserted! New id = " + seller.getId());
		
		System.out.println("\n\n  === TEST 5: seller update ===\n");
		seller = sellerDao.findById(1);
		seller.setName("Caio Oliveira");
		sellerDao.update(seller);
		System.out.println("Updated! New name = " + seller.getName());
		
		System.out.println("\n\n  === TEST 6: seller delete ===\n");
		sellerDao.deleteById(null);;
		System.out.println("Updated! New name = " + seller.getName());
		
	}

}
