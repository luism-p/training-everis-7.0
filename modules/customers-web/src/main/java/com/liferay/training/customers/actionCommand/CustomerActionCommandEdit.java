package com.liferay.training.customers.actionCommand;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.trainin.customers.model.Customer;
import com.liferay.trainin.customers.service.CustomerLocalService;
import com.liferay.training.customers.constants.CustomersConstans;
import com.liferay.training.customers.util.CustomerValidator;
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
    Log LOG = LogFactoryUtil.getLog(CustomerActionCommandEdit.class);
    @Reference
    private CustomerLocalService _customerLocalService;

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse)
            throws PortletException {
            updateCustomer(actionRequest, actionResponse);
        return false;
    }

    private void updateCustomer(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
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

            if(CustomerValidator.isCustomerValid(customer)) {
                _customerLocalService.addCustomerWithoutID(customer);
                SessionMessages.add(actionRequest, "customer-added");
            }else{
                SessionErrors.add(actionRequest, "invalid-data");
                SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest)
                + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
            }

            actionResponse.setRenderParameter("mvcPath", "/edit.jsp");


        }else{
            Customer customer = _customerLocalService.fetchCustomer(customerId);
            customer.setName(name);
            customer.setAddress(address);
            customer.setPhoneNumber(phoneNumber);
            customer.setModifiedDate(now);
            if(CustomerValidator.isCustomerValid(customer)) {
                _customerLocalService.updateCustomer(customer);
                SessionMessages.add(actionRequest, "customer-update");
            }else{
                SessionErrors.add(actionRequest, "invalid-data");
                SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest)
                        + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
            }

            actionResponse.setRenderParameter("mvcPath", "/edit.jsp");
        }
    }


}
