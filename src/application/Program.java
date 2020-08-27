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
		
		System.out.println("===== Teste 1: findId =====");
		Seller seller = sellerDao.findById(3); // Todos o vendedor id 3
		System.out.println(seller);
		
		System.out.println("\n===== Teste 2: findByDepartment =====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n===== Teste 3: findAll =====");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n===== Teste 4: Insert =====");
		Seller newSeller = new Seller(null, "Giba", "giba@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("New Seller id = " + newSeller.getId());
		
		System.out.println("\n===== Teste 5: Update =====");
		seller = sellerDao.findById(1);// busca um vendedor
		seller.setName("Maria");// altera o nome dele no obj
		sellerDao.update(seller);// atualiza no BD o objeto do vendedor
		System.out.println("Atualização ok");

	}

}
