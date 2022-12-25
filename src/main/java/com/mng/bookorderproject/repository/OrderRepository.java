package com.mng.bookorderproject.repository;

import com.mng.bookorderproject.model.Customer;
import com.mng.bookorderproject.model.Order;
import com.mng.bookorderproject.repository.mapping.MonthlyStatistics;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {
    List<Order> getOrdersByCustomer(Customer customer);
    Order save(Order order);
    Order getOrderByOrderId(Long orderId);
    List<Order> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);


    @Query(value = "SELECT TO_CHAR(o.created_at, 'fmMonth') AS \"Month\", COUNT(*) AS total_order_count, SUM(b.amount) AS total_purchased_amount, SUM(o.book_count) AS total_book_count " +
            "FROM orders o " +
            "JOIN book b ON o.book_id = b.book_id JOIN customer c ON c.customer_id = o.customer_id " +
            "WHERE c.customer_id = :customerId " +
            "GROUP BY TO_CHAR(o.created_at, 'fmMonth')", nativeQuery = true)
    List<MonthlyStatistics> getOrdersStatistics(@Param("customerId") Long customerId);
}
