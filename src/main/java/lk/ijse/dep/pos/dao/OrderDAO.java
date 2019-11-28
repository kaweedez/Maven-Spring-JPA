package lk.ijse.dep.pos.dao;

import lk.ijse.dep.pos.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderDAO extends JpaRepository<Order, Integer> {

    @Query(value = "SELECT IFNULL((SELECT id FROM `Order` ORDER BY id DESC LIMIT 1),0) AS id", nativeQuery = true)
    int getLastOrderId() throws Exception;

    @Query(value = "SELECT IF(EXISTS (SELECT customer_id FROM `Order` WHERE customer_id=?1),'TRUE', 'FALSE') AS customer_id", nativeQuery = true)
    boolean existsByCustomerId(String customerId) throws Exception;

}
