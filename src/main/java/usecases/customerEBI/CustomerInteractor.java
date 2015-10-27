/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usecases.customerEBI;

import com.sm.storemanagerfx.entity.Customer;
import com.sm.storemanagerfx.interfaces.IEntity;
import com.sm.storemanagerfx.interfaces.IRequestModel;
import com.sm.storemanagerfx.interfaces.IResponseModel;
import com.sm.storemanagerfx.interfaces.impl.AddedEntityRequestModel;
import com.sm.storemanagerfx.interfaces.impl.BaseInteractor;
import com.sm.storemanagerfx.util.InputValidator;

/**
 *
 * @author Sven
 */
public class CustomerInteractor extends BaseInteractor<Customer>{

    @Override
    public boolean receiveRequest(IRequestModel request) {
        if(InputValidator.isValid(request)) {
            request.acceptVisitor(this);
            return true;
        }
        return false;
    }

    @Override
    public IResponseModel sendResponse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(AddedEntityRequestModel request) {
        if(!request.isEmpty()) {
            for(IEntity c : request.getAddedList()) {
                dao.add(c);
            }
        }
    }
    
}
