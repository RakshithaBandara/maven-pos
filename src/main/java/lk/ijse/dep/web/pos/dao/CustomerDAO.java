package lk.ijse.dep.web.pos.dao;

import lk.ijse.dep.web.pos.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerDAO extends JpaRepository<Customer, String> {

    List<Customer> readCustomerByNameLike(String name);

    @Query(value = "SELECT c.name FROM Customer c WHERE c.address = ?1 AND c.name LIKE CONCAT(?2,'%')")
    List<String> findCustomerNames(String address, String name);
}
