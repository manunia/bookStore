package mariaL.bookStore.repo;

import mariaL.bookStore.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepo extends JpaRepository<Autor,Long> {


}
