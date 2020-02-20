package com.liferay.training.customers.actionCommand;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.trainin.customers.service.CustomerLocalService;
import com.liferay.training.customers.constants.CustomersConstans;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + CustomersConstans.CUSTOMERS,
                "mvc.command.name=" + CustomersConstans.CUSTOMER_ACTION_COMMAND_REMOVE
        },
        service = MVCActionCommand.class)
public class CustomerActionCommandRemove implements MVCActionCommand {
    @Reference
    private CustomerLocalService _customerLocalService;

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse)
            throws PortletException {

            deleteCustomer(actionRequest);

        return false;
    }

    private void deleteCustomer(ActionRequest actionRequest) {
        long customerId = ParamUtil.getLong(actionRequest, CustomersConstans.CUSTOMER_ID, 0l);

        if (customerId > 0) {
            try {
                _customerLocalService.deleteCustomer(customerId);
                SessionMessages.add(actionRequest, "success");
            } catch (PortalException e) {

                e.printStackTrace();
            }
        }
    }
}
