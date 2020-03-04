package com.liferay.training.customers.actionCommand;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
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

    Log LOG = LogFactoryUtil.getLog(CustomerActionCommandRemove.class);

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
                SessionMessages.add(actionRequest, "customer-deleted");
            } catch (PortalException e) {
                SessionErrors.add(actionRequest, "could-not-delete");
                SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest)
                        + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
                LOG.debug("error prtletException: "+ e.getClass()+" ->  "+e.getMessage());
            }

        }
    }
}
