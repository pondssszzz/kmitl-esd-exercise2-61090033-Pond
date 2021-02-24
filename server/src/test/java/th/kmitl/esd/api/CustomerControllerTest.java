package th.kmitl.esd.api;

import kmitl.esd.exercise2.model.CustomerDTO;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CustomerControllerTest {
    private CustomerController controller = new CustomerController();
    @Test
    void getAllCustomer() {
        List<CustomerDTO> customers = controller.getAllCustomer();
        assertEquals(customers.size(), 2);
    }

    /**
     * Test for creating customer
     */
    @Test
    void createCustomer() {
        controller.createCustomer(new CustomerDTO(4L, "Pond", 29));

        assertEquals(controller.getAllCustomer().size(),3);

        controller.deleteCustomer(4L);
    }

    /**
     * Test for updating customer
     */
    @Test
    void updateCustomer() {
        CustomerDTO customer = controller.createCustomer(new CustomerDTO(2L, "Pond", 29));
        customer.setAge(40);

        CustomerDTO updatedCustomer = controller.updateCustomer(customer);
        assertEquals(updatedCustomer.getAge(), 40);

        controller.deleteCustomer(2L);
    }

    /**
     * Test for deleting customer
     */
    @Test
    void deleteCustomer() {
        assertEquals(controller.getAllCustomer().size(), 2);

        controller.deleteCustomer(1L);

        assertEquals(controller.getAllCustomer().size(), 1);

        controller.createCustomer(new CustomerDTO(1L, "Jerry", 35));
    }
}