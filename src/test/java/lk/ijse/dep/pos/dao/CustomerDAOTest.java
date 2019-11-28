package lk.ijse.dep.pos.dao;

import lk.ijse.dep.pos.AppConfig;
import lk.ijse.dep.pos.entity.CustomEntity;
import lk.ijse.dep.pos.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringRunner.class)
public class CustomerDAOTest {

    @Autowired
    private CustomerDAO customerDAO;

    @Test
    public void getCustomerById() throws Exception {
        String id = "C001";
        Customer customerById = customerDAO.getCustomerById(id);
        System.out.println(customerById);
    }

    @Test
    public void getCustomersByNameLike() throws Exception{
        List<Customer> customersByNameLike = customerDAO.getCustomersByNameLike("k%");
        System.out.println(customersByNameLike);
    }

    @Test
    public void getFirstCustomerByIdOrderByIdDesc() throws Exception {
        Customer firstCustomerByIdOrderByIdDesc = customerDAO.getFirstCustomerByOrderByIdDesc();
        System.out.println(firstCustomerByIdOrderByIdDesc);
    }

    @Test
    public void countAllCustomersBy() throws Exception {
        int i = customerDAO.countAllCustomersBy();
        System.out.println(i);
    }

    @Test
    public void queryCustomerByIdAndName() throws Exception {
        Customer customer = customerDAO.queryCustomerByIdAndName("C001","kawee");
        System.out.println(customer);
    }

    @Test
    public void namedQuery1() throws Exception {
        List<Customer> customers = customerDAO.namedQuery1();
        System.out.println(customers);
    }

    @Test
    public void namedNativeQuery() throws Exception {
        Customer customer = customerDAO.namedNativeQuery("C001");
        System.out.println(customer);
    }

    @Test
    public void anotherQuery() throws Exception{
        Customer customer = customerDAO.anotherQuery("C001", "kawee");
        System.out.println(customer);
    }

    @Test
    public void anotherQuerySpell() throws Exception{
        Customer customer = customerDAO.anotherQuerySpell("C001", "kawee");
        System.out.println(customer);
    }

//    @Test
//    public void anotherNamedNativeQuerySpell() throws Exception{
//        Customer customer = customerDAO.anotherNamedNativeQuerySpell("C001", "kawee");
//        System.out.println(customer);
//    }

    @Test
    public void namedQuery2Spell() throws Exception {
        List<Customer> customer = customerDAO.namedQuery2Spell("C00");
        System.out.println(customer);
    }

    @Test
    public void depQuery2() throws Exception{

        CustomEntity customEntity = customerDAO.depQuery2(1);
        System.out.println(customEntity.getOrderDate());
        System.out.println(customEntity.getCustomerName());
    }

}