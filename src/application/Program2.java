package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("===== Teste 1: findId =====");
		Department department = departmentDao.findById(3);
		System.out.println(department);
		
		System.out.println("\n===== Teste 2: findAll =====");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n===== Teste 3: Insert =====");
		Department newDepartment = new Department(null, "Material de contrucao");
		departmentDao.insert(newDepartment);
		System.out.println("New Department id = " + newDepartment.getId());
		
		System.out.println("\n===== Teste 4: Update =====");
		department = departmentDao.findById(1);
		department.setName("Otica");
		departmentDao.update(department);
		System.out.println("Atualização ok");

		System.out.println("===== Teste 5: Delete =====");
		System.out.println("Digite o nr do Id do Departamentor: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete ok");
		
		sc.close();
	}

}
