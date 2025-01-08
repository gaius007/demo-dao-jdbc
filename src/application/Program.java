package application;

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
		
	}

}
