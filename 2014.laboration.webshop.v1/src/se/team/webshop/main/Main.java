package se.team.webshop.main;

import se.team.webshop.model.User;
import se.team.webshop.model.Product;
import se.team.webshop.repository.InMemoryUserRepository;
import se.team.webshop.repository.UserRepository;
import se.team.webshop.repository.InMemoryProductRepository;
import se.team.webshop.repository.ProductRepository;
import se.team.webshop.repository.InMemoryOrderRepository;
import se.team.webshop.repository.OrderRepository;
import se.team.webshop.service.ECommerceService;

public class Main {

	public static void main(String[] args) {

		UserRepository customerRepository = new InMemoryUserRepository();
		ProductRepository productRepository = new InMemoryProductRepository();
		OrderRepository orderRepository = new InMemoryOrderRepository();

		ECommerceService eCommerceService = new ECommerceService(
				customerRepository, productRepository, orderRepository);

		// ----------------------------------------------------------------------------------------------

		eCommerceService.addUser(new User("01A", "Lilly Mulugeta", "lilly01",
				"her street", "lilly@yahoo.com", "079-8900887"));
		eCommerceService.addUser(new User("02A", "Liliana Santiesteban",
				"lili02", "her street", "liliana@hotmail.com", "079-797979"));
		eCommerceService.addUser(new User("03C", "Anders Carlsson", "anders03",
				"his street", "anders@hotmail.com", "079-7985559"));
		eCommerceService.addUser(new User("04D", "Salvador Duenas", "sds04",
				"my street", "salvador@yahoo.com", "079-7808079"));

		System.out.println(eCommerceService.getUsers());

		eCommerceService.deleteUser("01A");

		System.out.println(eCommerceService.getUsers());

		System.out.println(eCommerceService.getUser("02A"));

		System.out.println();

		// ----------------------------------------------------------------------------------------------

		eCommerceService.addProduct(new Product("001-F", "Electric saw",
				"Funky device to feel as if you were Jason", 290.99));
		eCommerceService.addProduct(new Product("004-C", "Sun glasses",
				"For the UV protection", 560.39));
		eCommerceService.addProduct(new Product("024-J", "Magic cup",
				"To avoid monsters under the bed", 230.29));
		eCommerceService.addProduct(new Product("124-K", "Java homework",
				"Relax while we do it for you :)", 1000.00));
				eCommerceService.addProduct(new Product("125-T", "Chinese te",
				"For the fika :)", 10.00));
		
		Product product2 = eCommerceService.getProduct("125-T"); 
		eCommerceService.updateProduct("001-F", product2);// Updating product 001-F with product2

		System.out.println(eCommerceService.getProducts());

		System.out.println(eCommerceService.getProduct("001-F"));

		System.out.println();

		eCommerceService.deleteProduct("124-K");

		System.out.println(eCommerceService.getProducts());

		System.out.print("Getting a product price from => eCommerceService.getProduct(String idKey).getPrice():  ");
		System.out.println(eCommerceService.getProduct("001-F").getPrice());
		System.out.println();

		// ----------------------------------------------------------------------------------------------

		User user1 = eCommerceService.getUser("02A"); // Storing a user as user1

		Product product1 = eCommerceService.getProduct("001-F"); // Storing a product as product1

		user1.getUserCart().addProductToCart(product1);

		System.out.println(user1.getUserCart().getProducts());

		System.out.println();
		System.out.print("Getting how many products '1' the cart have from => (user1.getUserCart().getProductsInCart().get(product1)):  ");
		System.out.println(user1.getUserCart().getProductsInCart().get(product1));
		System.out.println();

		user1.getUserCart().addProductToCart(product1); // Adding the same product1 twice

		System.out.println(user1.getUserCart().getProductsInCart().get(product1));

		user1.getUserCart().addProductToCart(product1); // Adding the same product1 again

		System.out.println(user1.getUserCart().getProductsInCart().get(product1));

		user1.getUserCart().removeProductInCart(product1); // Removing 1 product1 from List<Product>

		System.out.println();
		System.out.println("Getting all the remain products from the cart using => (user1.getUserCart().getProducts():  ");
		System.out.println(user1.getUserCart().getProducts());

		System.out.println();
		System.out.print("Getting the total price of the cart products from user1 => user1.getUserCart().getTotalPrice():  ");
		System.out.println(user1.getUserCart().getTotalPrice());

		// user1.getUserCart().clearCart(); EMPTIES THE CART

		// System.out.println(user1.getUserCart().getProducts()); RETURNS AN EMPTY MAP

		// ----------------------------------------------------------------------------------------------

		eCommerceService.addOrder(user1);// Creating an order from user1
		eCommerceService.addOrder(user1);// Creating another order from user1
		
		System.out.println();
		System.out.println("Orders in memory:");
		System.out.println(eCommerceService.getOrders());
		
		System.out.println();
		System.out.println("Order 1 in memory:");
		System.out.println(eCommerceService.getOrder(1, user1));// Getting order1 from user1
		
		eCommerceService.deleteOrder(2, user1);// Removing order2 from user1
		
		System.out.println();
		System.out.println(eCommerceService.getOrders());
		
		// ----------------------------------------------------------------------------------------------

		// Link between user, cart and order

	}
}
