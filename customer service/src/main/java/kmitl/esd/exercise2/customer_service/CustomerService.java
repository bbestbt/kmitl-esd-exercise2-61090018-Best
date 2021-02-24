package kmitl.esd.exercise2.customer_service;

import kmitl.esd.exercise2.model.CustomerDTO;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {


    public static CustomerService INSTANCE = new CustomerService(); //singleton
    private List<CustomerDTO> customerDTO = new ArrayList<>();// customer list

    /**
     * private constructor
     */
    private CustomerService(){

    }

    /**
     * function to get instance CustomerService
     * @return INSTANCE singleton instance CustomerService
     */
    public static CustomerService getInstance(){
        if (INSTANCE != null) {
            return INSTANCE;
        }

        INSTANCE = new CustomerService();

        return INSTANCE;

    }

    /**
     * get all customer
     * @return list of all customers
     */
    public List<CustomerDTO> getCustomer(){
        return customerDTO;
    }

    /**
     * create customer
     * @param customer as a request body
     * @return the saved version of the customer
     */
    public CustomerDTO createCustomer(CustomerDTO customer){
        customerDTO.add(customer);
        return customer;
    }

    /**
     * Delete a customer
     * @param customerId id of the customer
     * @return true if deleted, false if not found
     */
    public Boolean deleteCustomer(Long customerId){
        CustomerDTO customerToBeDeleted = customerDTO.stream().filter(c->c.getId().equals(customerId)).findFirst().get();
        if(customerToBeDeleted!=null){
            customerDTO.remove(customerToBeDeleted);
            return true;
        }else{
            return false;
        }

    }

    /**
     * update/ modify a customer
     * @param customer as a request body
     * @return the updated customer object or null if update not successful
     */
    public CustomerDTO updateCustomer(CustomerDTO customer){
        CustomerDTO customerToBeUpdated = customerDTO.stream().filter(c->c.getId().equals(customer.getId())).findFirst().get();
        if(customerToBeUpdated!=null){ //exists -> replace
            customerDTO.remove(customerToBeUpdated);
        }else{
            return null; // no customer found for the update
        }
        customerDTO.add(customer);
        return customer;
    }


}
