package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Progam2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("==== TEST 1: department findById ====");
		Department dep = departmentDao.findById(3);
		System.out.println(dep);
		
		System.out.println();
		
		System.out.println("==== TEST 2: department findAll ====");
		List<Department> list = departmentDao.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println();
		
		System.out.println("==== TEST 3: department Insert ====");
		Department newDep = new Department(null, "Food");
		departmentDao.insert(newDep);
		System.out.println("Inserted! New Id = " + newDep.getId());
		
		System.out.println();
		
		System.out.println("==== TEST 4: department Update ====");
		dep = departmentDao.findById(5);
		dep.setName("Music");
		departmentDao.update(dep);
		System.out.println("Update completed!");
		
		System.out.println();
		
		System.out.println("==== TEST 5: department Delete ====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deletById(id);
		System.out.println("Delete completed!");
		
		sc.close();
	}

}
