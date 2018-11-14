package mariaL.bookStore.repo;

import mariaL.bookStore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Long> {

    Book findByTextLike(String text);
}
