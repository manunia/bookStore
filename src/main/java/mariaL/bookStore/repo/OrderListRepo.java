package mariaL.bookStore.repo;

import mariaL.bookStore.entity.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderListRepo extends JpaRepository<OrderList,Long> {
}
