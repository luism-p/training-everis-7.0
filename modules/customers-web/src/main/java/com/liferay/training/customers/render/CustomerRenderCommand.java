package com.liferay.training.customers.render;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.trainin.customers.model.Customer;
import com.liferay.trainin.customers.service.CustomerLocalService;
import com.liferay.training.customers.constants.CustomersConstans;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + CustomersConstans.CUSTOMERS,
                "mvc.command.name=" + CustomersConstans.CUSTOMER_RENDER_COMMAND
        },
        service = MVCRenderCommand.class
)
public class CustomerRenderCommand implements MVCRenderCommand {

        @Reference
        private CustomerLocalService _customerLocalService;

        @Override
        public String render(RenderRequest renderRequest, RenderResponse renderResponse)
                throws PortletException {
                List<Customer> customers = _customerLocalService.getCustomers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
                renderRequest.setAttribute(CustomersConstans.LIST_CUSTOMERS, customers);
                renderRequest.setAttribute(CustomersConstans.CUSTOMER_LOCAL_SERVICE, _customerLocalService);

                return CustomersConstans.VIEW_JSP;
        }
}
