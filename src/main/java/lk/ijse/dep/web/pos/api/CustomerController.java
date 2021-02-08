package lk.ijse.dep.web.pos.api;

import lk.ijse.dep.web.pos.business.custom.CustomerBO;
import lk.ijse.dep.web.pos.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/api/v1/customers")
@RestController
public class CustomerController {

    @Autowired
    private CustomerBO customerBO;

    @GetMapping
    public List<CustomerDTO> getAllCustomers() throws Exception {
        return customerBO.findAllCustomers();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveCustomer(@RequestBody CustomerDTO customer) throws Exception {
        customerBO.saveCustomer(customer);
        return customer.getId();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id:I\\d{3}}")
    public void deleteCustomer(@PathVariable String id) throws Exception {
        customerBO.deleteCustomer(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{id:I\\d{3}}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCustomer(@PathVariable String id,
            @RequestBody CustomerDTO customer) throws Exception {
        customer.setId(id);
        customerBO.updateCustomer(customer);
    }
}
