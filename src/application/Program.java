package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
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
		sellerDao.deleteById(4);
		System.out.println("Deleted!");
		
		System.out.println("\n\n  === TEST 7: departement findById ===\n");
		department = departmentDao.findById(3);
		System.out.println(department);
		
		System.out.println("\n\n  === TEST 8: department findAll ===\n");
		List<Department> departmentList = departmentDao.findAll();
		departmentList.forEach(System.out::println);
		
		System.out.println("\n\n  === TEST 9: department insert ===\n");
		department = new Department(null, "Others");
		departmentDao.insert(department);
		System.out.println("Inserted! New id = " + department.getId());
		
		System.out.println("\n\n  === TEST 10: department update ===\n");
		department = departmentDao.findById(1);
		department.setName("Cars");
		departmentDao.update(department);	
		System.out.println("Updated! New name = " + department.getName());
		
		System.out.println("\n\n  === TEST 11: department delete ===\n");
		departmentDao.deleteById(4);
		System.out.println("Deleted!");
	}

}
