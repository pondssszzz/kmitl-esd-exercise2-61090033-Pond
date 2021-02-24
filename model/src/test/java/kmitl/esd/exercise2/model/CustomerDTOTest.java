package kmitl.esd.exercise2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDTOTest {

    private CustomerDTO customerDTO;

    /**
     * get customer dto ready
     */
    @BeforeEach
    void getCustomerDTO() {
        this.customerDTO = new CustomerDTO(1L, "Pond", 22);
    }

    /**
     * check if getter and setter for id works
     */
    @Test
    void getId() {
        assertEquals(customerDTO.getId(), 1L);
        this.customerDTO.setId(2L);
        assertEquals(customerDTO.getId(), 2L);
    }

    /**
     * check if getter and setter for name works
     */
    @Test
    void getName() {
        assertEquals(customerDTO.getName(), "Pond");
        this.customerDTO.setName("Dech");
        assertEquals(customerDTO.getName(), "Dech");
    }

    /**
     * check if getter and setter for age works
     */
    @Test
    void getAge() {
        assertEquals(customerDTO.getAge(), 15);
        this.customerDTO.setAge(30);
        assertEquals(customerDTO.getAge(), 30);
    }
}