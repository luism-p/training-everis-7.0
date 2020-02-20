package com.liferay.training.customers.render;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
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

                String renderEdit = ParamUtil.getString(renderRequest, "renderEdit", StringPool.BLANK);
                long customerId = ParamUtil.getLong(renderRequest, CustomersConstans.CUSTOMER_ID, 0l);

                if(customerId > 0 && renderEdit.equals("renderEdit")){
                        String name = StringPool.BLANK;
                        String address = StringPool.BLANK;
                        String phoneNumber = StringPool.BLANK;
                        Customer customer = _customerLocalService.fetchCustomer(customerId);

                        name = customer.getName();
                        address = customer.getAddress();
                        phoneNumber = customer.getPhoneNumber();

                        renderRequest.setAttribute(CustomersConstans.CUSTOMER_NAME,name);
                        renderRequest.setAttribute(CustomersConstans.CUSTOMER_ADDRESS,address);
                        renderRequest.setAttribute(CustomersConstans.CUSTOMER_PHONE,phoneNumber);
                        return CustomersConstans.EDIT_JSP;
                }else{
                        List<Customer> customers = _customerLocalService.getCustomers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
                        renderRequest.setAttribute(CustomersConstans.LIST_CUSTOMERS, customers);

                        return CustomersConstans.VIEW_JSP;
                }



        }
}
