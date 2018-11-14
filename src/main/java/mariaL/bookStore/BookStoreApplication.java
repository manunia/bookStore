package mariaL.bookStore;

import mariaL.bookStore.entity.Autor;
import mariaL.bookStore.entity.Book;
import mariaL.bookStore.entity.OrderList;
import mariaL.bookStore.repo.AutorRepo;
import mariaL.bookStore.repo.BookRepo;
import mariaL.bookStore.repo.OrderListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class BookStoreApplication {

	@Autowired
	private BookRepo bookRepo;
	@Autowired
	private AutorRepo autorRepo;
	@Autowired
	private OrderListRepo orderListRepo;

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	private void test() { //метод для добавления тестовых данных
		Book book1 = new Book();
		book1.setId(1L);
		book1.setText("testbook1");
		Book book2 = new Book();
		book2.setId(2L);
		book2.setText("book2 text");
		Autor autor1 = new Autor();
		autor1.setId(1L);
		autor1.setName("autor1");
		autor1.setBook(book1);
		Autor autor2 = new Autor();
		autor2.setId(2L);
		autor2.setName("autor1");
		autor2.setBook(book2);
		bookRepo.save(book1);
		bookRepo.save(book2);
		autorRepo.save(autor1);

		OrderList orderList = new OrderList();
		orderList.setId(1L);
		orderList.setUserName("Mike");
		orderList.setUserAddress("Moskow");
		orderList.setBook(book1);

		orderListRepo.save(orderList);

		bookRepo.findAll().forEach(it -> System.out.println(it));
		autorRepo.findAll().forEach(it -> System.out.println(it));

		orderListRepo.findAll().forEach(it -> System.out.println(it));
	}
}
