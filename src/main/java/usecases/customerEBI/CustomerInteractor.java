/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usecases.customerEBI;

import com.sm.storemanagerfx.commands.BaseCommand;
import com.sm.storemanagerfx.commands.CommandFactory;
import com.sm.storemanagerfx.commands.CommandFactory.CommandType;
import com.sm.storemanagerfx.dao.CustomerDAO;
import com.sm.storemanagerfx.entity.Address;
import com.sm.storemanagerfx.entity.Customer;
import com.sm.storemanagerfx.interfaces.ICustomerRequestBoundary;
import com.sm.storemanagerfx.interfaces.IResponseModel;
import com.sm.storemanagerfx.interfaces.impl.BaseInteractor;
import com.sm.storemanagerfx.util.InputValidator.InvalidInputException;
import java.time.LocalDate;
import java.util.Map;

/**
 *
 * @author Sven
 */
public class CustomerInteractor extends BaseInteractor<Customer> implements ICustomerRequestBoundary {

    private final CustomerDAO dao;

//    @Override
//    public boolean receiveRequest(IRequestModel request) {
//        if (InputValidator.isValid(request)) {
//            request.acceptVisitor(this);
//            return true;
//        }
//        return false;
//    }

    public CustomerInteractor(CustomerDAO dao) {
        this.dao = dao;
//        this.commandFactory = commandFactory;
    }
    
    @Override
    public IResponseModel sendResponse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addCustomer(Map<String, Object> dataMap) {
        Customer c = createCustomerFromMap(dataMap);
        BaseCommand command  = CommandFactory.createCustomerCommand(CommandType.ADD, c);
        command.execute();
    }

    private Customer createCustomerFromMap(Map<String, Object> dataMap) {
        try {
            return createCustomer(dataMap);
        } catch (Exception e) {
            throw new InvalidInputException();
        }
    }

    private Customer createCustomer(Map<String, Object> dataMap) {
        Customer c = new Customer();
        String firstName = (String) dataMap.get("firstName");
        String lastName = (String) dataMap.get("lastName");
        LocalDate birthday = (LocalDate) dataMap.get("birthday");
        Address address = createAddressFromMap(dataMap);
        c.setFirstName(firstName);
        c.setLastName(lastName);
        c.setAddress(address);
        c.setBirthday(birthday);
        return c;
    }

    private Address createAddressFromMap(Map<String, Object> dataMap) {
        Address address = new Address();
        address.setCity((String) dataMap.get("city"));
        address.setEmail((String) dataMap.get("email"));
        address.setPhone((String) dataMap.get("phone"));
        address.setPostalCode((String) dataMap.get("postalCode"));
        address.setStreet((String) dataMap.get("street"));
        return address;
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
