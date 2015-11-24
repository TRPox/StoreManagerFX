/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usecases.customerEBI;

import com.sm.storemanagerfx.commands.BaseCommand;
import com.sm.storemanagerfx.commands.CommandFactory;
import com.sm.storemanagerfx.commands.CommandFactory.EntityType;
import com.sm.storemanagerfx.dao.CustomerDAO;
import com.sm.storemanagerfx.entity.Customer;
import com.sm.storemanagerfx.interfaces.ICustomerRequestBoundary;
import com.sm.storemanagerfx.interfaces.IResponseModel;
import com.sm.storemanagerfx.interfaces.impl.BaseInteractor;
import static com.sm.storemanagerfx.util.InputValidator.isValid;
import java.util.Map;

/**
 *
 * @author Sven
 */
public class CustomerInteractor extends BaseInteractor<Customer> implements ICustomerRequestBoundary {

    private final CustomerDAO dao;
    private final CommandFactory commandFactory;

    public CustomerInteractor(CustomerDAO dao, CommandFactory commandFactory) {
        this.dao = dao;
        this.commandFactory = commandFactory;
    }

    @Override
    public IResponseModel sendResponse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addCustomer(Map<String, Object> dataMap) {
        if (isValid(dataMap)) {
            BaseCommand command = commandFactory.createAddCommand(EntityType.CUSTOMER, dataMap);
            command.execute();
        }
    }

    @Override
    public void editCustomer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeCustomer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
