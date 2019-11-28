package lk.ijse.dep.pos.dao;

import lk.ijse.dep.pos.entity.CustomEntity;
import lk.ijse.dep.pos.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerDAO extends JpaRepository<Customer, String> {

    @Query(value = "SELECT id FROM Customer ORDER BY id DESC LIMIT 1", nativeQuery = true)
    String getLastCustomerId() throws Exception;

    Customer getCustomerById(String id) throws Exception;

    List<Customer> getCustomersByNameLike(String query) throws Exception;

    Customer getFirstCustomerByOrderByIdDesc() throws Exception;

    Customer queryCustomerByIdAndName(String id, String name) throws Exception;

    int countAllCustomersBy() throws Exception;

    List<Customer> namedQuery1() throws Exception;

    Customer namedNativeQuery(String id) throws Exception;

    @Query(value = "SELECT * FROM Customer WHERE id=?1 AND name=?2", nativeQuery = true)
    Customer anotherQuery(String id, String name) throws Exception;

    @Query(value = "SELECT * FROM Customer WHERE id=?#{[0]} AND name=?#{[1]}", nativeQuery = true)
    Customer anotherQuerySpell(String id, String name) throws Exception;

//    Customer anotherNamedNativeQuerySpell(String id, String name) throws Exception;

    @Query(value = "SELECT * FROM Customer WHERE id=:id",nativeQuery = true)
    Customer namedQuery2(@Param("id") String id) throws Exception;

    @Query(value = "SELECT * FROM Customer c WHERE c.id LIKE ?#{[0]+'%'}", nativeQuery = true)
//    @Query(value = "SELECT * FROM Customer c WHERE c.id LIKE CONCAT(?#{[0]+'%'})", nativeQuery = true)
    List<Customer> namedQuery2Spell(String c) throws Exception;

//    @Query(value = "SELECT NEW lk.ijse.dep.pos.entity.CustomEntity( c.name,o.date) FROM Order o INNER JOIN o.customer c WHERE o.id=?1")
    @Query(value = "SELECT NEW lk.ijse.dep.pos.entity.CustomEntity( c.name,o.date) FROM Order o INNER JOIN o.customer c WHERE o.id=?1")

    CustomEntity depQuery2(int id) throws Exception;

}
