/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interactor;

import com.sm.storemanagerfx.dao.CustomerDAO;
import com.sm.storemanagerfx.entity.Customer;
import com.sm.storemanagerfx.requests.IRequestModel.EmptyRequestException;
import com.sm.storemanagerfx.interfaces.AddedEntityRequestModel;
import com.sm.storemanagerfx.util.InputValidator.InvalidInputException;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;
import org.junit.Before;
import org.junit.Test;
import usecases.customerEBI.CustomerInteractor;

/**
 *
 * @author Sven
 */
public class CustomerInteractorRequestTest {
    
    private CustomerInteractor ci;
    
    @Before
    public void setUp() {
        ci = new CustomerInteractor();
        ci.setDao(new CustomerDAO());
    }
    
//    @Test(expected = InvalidInputException.class)
//    public void givenNull_shouldThrowInvalidInputException() {
//        ci.receiveRequest(null);
//    }
    
//    @Test
//    public void givenValidRequest_shouldReturnTrue() {
//        AddedEntityRequestModel<Customer> aer = new AddedEntityRequestModel();
//        aer.getAddedList().add(new Customer());
//        assertThat(ci.receiveRequest(aer), equalTo(true));
//    }
//    
//    @Test(expected = EmptyRequestException.class)
//    public void givenEmptyAddedEntityRequestModel_shouldThrowEmptyRequestException() {
//        ci.receiveRequest(new AddedEntityRequestModel());
//    }
//    
//    can only be tested after responses are implemented
//    @Test
//    public void givenValidAddedEntityRequestModel_shouldAddToDAO() {
//        
//    }
}
