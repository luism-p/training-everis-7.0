package com.liferay.training.customers.actionCommand;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.Constants;
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
                "mvc.command.name=" + CustomersConstans.CUSTOMER_ACTION_COMMAND_REMOVE
        },
        service = MVCActionCommand.class)
public class CustomerActionCommandRemove implements MVCActionCommand {
    @Reference
    private CustomerLocalService _customerLocalService;

    @Override public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse)
            throws PortletException {

            deleteCustomer(actionRequest);

        return false;
    }



    private void deleteCustomer(ActionRequest actionRequest) {
    }
}
