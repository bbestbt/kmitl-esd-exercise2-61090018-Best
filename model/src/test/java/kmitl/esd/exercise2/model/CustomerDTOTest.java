package kmitl.esd.exercise2.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * test customerDTO
 */
class CustomerDTOTest {
    private CustomerDTO customer = new CustomerDTO(1, "Best", 20);

    /**
     * test to get details
     */
    @Test
    void testToString() {
        assertEquals(customer.toString(),"1 , Best , 20");
    }

    /**
     * test to get id
     */
    @Test
    void getId() {
        assertEquals(customer.getId(),1L);
    }

    /**
     * test to set id
     */
    @Test
    void setId() {
        customer.setId(2L);
        assertEquals(customer.getId(),2L);
    }


}