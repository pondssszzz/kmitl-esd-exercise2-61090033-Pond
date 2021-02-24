package kmitl.esd.exercise.service;

import java.util.List;
import java.util.ArrayList;
import kmitl.esd.exercise2.model.CustomerDTO;

public class CustomerService {

    /**
     * Singleton service
     */
    public static CustomerService INSTANCE = new CustomerService();

    /**
     * Customer list to represent the database containing customers
     */
    private static List<CustomerDTO> customers = new ArrayList<>();

    /**
     * Since there is no database, this static section is used to create customers
     * and add it into the customers list
     */
    static {
        CustomerDTO customerPond = new CustomerDTO(1L, "Pond", 27);
        CustomerDTO customerDech = new CustomerDTO(2L, "Dech", 12);

        customers.add(customerPond);
        customers.add(customerDech);
    }

    /**
     * Private constructor - singleton pattern
     */
    private CustomerService() {}

    /**
     * Function to get all of the customers
     *
     * @return list of customers
     */
    public List<CustomerDTO> getAllCustomers() {
        return customers;
    }

    /**
     * Function to create customer
     *
     * @return customer
     */
    public CustomerDTO createCustomer(CustomerDTO customer) {
        customers.add(customer);
        return customer;
    }

    /**
     * Function to update customer
     *
     * @return customer
     */
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

    /**
     * Function to delete customer
     *
     * @param customerId
     * @return boolean - the result of deletion
     */
    public boolean deleteCustomer(Long customerId) {
        CustomerDTO customerToBeDeleted = customers.stream().filter(c -> c.getId().equals(customerId)).findFirst().get();
        if (customerToBeDeleted != null) {
            customers.remove(customerToBeDeleted);
            return true;
        } else {
            return false;
        }
    }
}
