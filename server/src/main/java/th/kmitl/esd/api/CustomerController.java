
package th.kmitl.esd.api;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import kmitl.esd.exercise2.model.CustomerDTO;
import java.util.List;
/**
 * Web service for customer
 * Produce endpoints as a part of the server API
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final AtomicLong counter = new AtomicLong();
    private static List<CustomerDTO> customers = new ArrayList<>();

    static {
        CustomerDTO customerTom = new CustomerDTO(1l,"Jerry", 15);
        customers.add(customerTom);

    }

    /**
     * Function to get all of the customers
     * Can be called using GET method
     *
     * @return list of all customers
     */
    @GetMapping("/findall")
    public List<CustomerDTO> getAllCustomer() {
        return customers; //ToDo provide a list of customer
    }

    /**
     * Function to delete customer
     * Can be called using DELETE method
     *
     * @param customerId
     * @return boolean - the result of deletion
     */
    @DeleteMapping("/{id}")
    public Boolean deleteCustomer(@PathVariable("id") Long customerId) {
        CustomerDTO customerToBeDeleted = customers.stream().filter(c -> c.getId().equals(customerId)).findFirst().get();
        if (customerToBeDeleted != null) {
            customers.remove(customerToBeDeleted);
            return true;
        } else {
            return false;
        }
    }
    /**
     * Function to create customer
     * Can be called using POST method
     *
     * @return customer
     */

    @PostMapping
    public CustomerDTO createCustomer(CustomerDTO customer) {
        customers.add(customer);
        return customer;
    }
    /**
     * Function to update customer
     * Can be called using PUT method
     *
     * @return customer
     */
    @PutMapping
    public CustomerDTO updateCustomer(CustomerDTO customer) {
        CustomerDTO customerToBeUpdated = customers.stream().filter(c -> c.getId().equals(customer.getId())).findFirst().get();
        if (customerToBeUpdated != null){
            customers.remove(customerToBeUpdated);

        } else{
            return null;
        }
        customers.add(customer);
        return customer;
    }
}