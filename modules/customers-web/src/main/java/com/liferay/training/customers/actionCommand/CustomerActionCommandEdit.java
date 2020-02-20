package com.liferay.training.customers.actionCommand;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.trainin.customers.model.Customer;
import com.liferay.trainin.customers.service.CustomerLocalService;
import com.liferay.training.customers.constants.CustomersConstans;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + CustomersConstans.CUSTOMERS,
                "mvc.command.name=" + CustomersConstans.CUSTOMER_ACTION_COMMAND_EDIT
        },
        service = MVCActionCommand.class)
public class CustomerActionCommandEdit implements MVCActionCommand {
    @Reference
    private CustomerLocalService _customerLocalService;

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse)
            throws PortletException {
            updateCustomer(actionRequest);
        return false;
    }

    private void updateCustomer(ActionRequest actionRequest) {
        long customerId = ParamUtil.getLong(actionRequest, "customerId", 0L);
        String name = ParamUtil.getString(actionRequest, "name", StringPool.BLANK);
        String address = ParamUtil.getString(actionRequest, "address", StringPool.BLANK);
        String phoneNumber = ParamUtil.getString(actionRequest, "phoneNumber", StringPool.BLANK);

        Date now = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());

        if(customerId <= 0){
            Customer customer = _customerLocalService.createCustomer(0);
            customer.setName(name);
            customer.setAddress(address);
            customer.setPhoneNumber(phoneNumber);
            customer.setCreateDate(now);
            _customerLocalService.addCustomerWithoutID(customer);
            SessionMessages.add(actionRequest, "success");

        }else{
            Customer customer = _customerLocalService.fetchCustomer(customerId);
            customer.setName(name);
            customer.setAddress(address);
            customer.setPhoneNumber(phoneNumber);
            customer.setModifiedDate(now);
            _customerLocalService.updateCustomer(customer);
        }
    }


}
