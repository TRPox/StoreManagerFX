/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usecases.customerEBI;

import com.sm.storemanagerfx.dao.CustomerDAO;
import com.sm.storemanagerfx.entity.Customer;
import com.sm.storemanagerfx.interfaces.ICustomerRequestBoundary;
import com.sm.storemanagerfx.interfaces.IResponseModel;
import com.sm.storemanagerfx.interfaces.impl.BaseInteractor;
import java.util.List;

/**
 *
 * @author Sven
 */
public class CustomerInteractor extends BaseInteractor<Customer> implements ICustomerRequestBoundary{

    private CustomerDAO dao;

//    @Override
//    public boolean receiveRequest(IRequestModel request) {
//        if (InputValidator.isValid(request)) {
//            request.acceptVisitor(this);
//            return true;
//        }
//        return false;
//    }

    @Override
    public IResponseModel sendResponse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void addCustomers(List<Customer> addedList) {
        for (Customer c : addedList) {
            dao.add(c);
        }
    }

    public void setDao(CustomerDAO dao) {
        this.dao = dao;
    }

    @Override
    public void editCustomers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeCustomers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
