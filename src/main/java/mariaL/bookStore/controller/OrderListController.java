package mariaL.bookStore.controller;

import mariaL.bookStore.entity.Book;
import mariaL.bookStore.entity.OrderList;
import mariaL.bookStore.repo.BookRepo;
import mariaL.bookStore.repo.OrderListRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderListController {

    private final OrderListRepo orderListRepo;
    private final BookRepo bookRepo;

    public OrderListController(OrderListRepo orderListRepo, BookRepo bookRepo) {
        this.orderListRepo = orderListRepo;
        this.bookRepo = bookRepo;
    }

    @GetMapping
    public List<OrderList> getAll() {
        return orderListRepo.findAll();
    }

    @GetMapping("{id}")
    public OrderList getOne(@PathVariable("id") OrderList orderList) {
        return orderList;
    }

    //создание заказа
    @PostMapping
    public OrderList createOrder(@RequestBody OrderList orderList) {
        return orderListRepo.save(orderList);
    }

    //обновление
    @PutMapping("{id}")
    public OrderList update(
            @PathVariable("id") OrderList orderFromDb,
            @RequestBody OrderList orderList
    ) {
        BeanUtils.copyProperties(orderList,orderFromDb,"id");

        return orderListRepo.save(orderFromDb);
    }

    //удаление
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") OrderList orderList) {
        orderListRepo.delete(orderList);
    }
}
