package com.liferay.training.customers.render;

import com.google.gson.reflect.TypeToken;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.trainin.customers.model.Customer;
import com.liferay.trainin.customers.service.CustomerLocalService;
import com.liferay.training.customers.bean.Bean;
import com.liferay.training.customers.constants.CustomersConstans;
import com.luis.impl.GenericUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + CustomersConstans.CUSTOMERS,
                "mvc.command.name=" + CustomersConstans.CUSTOMER_RENDER_COMMAND
        },
        service = MVCRenderCommand.class
)
public class CustomerRenderCommand implements MVCRenderCommand, GenericUtils {
    private static final Log _log = LogFactoryUtil.getLog(CustomerRenderCommand.class);

    @Reference
    private CustomerLocalService _customerLocalService;

    public static<T> void pintar(T t){
        System.out.println(t);
    }

    @Override
    public <T> void print(T t) {
        GenericUtils.super.print(t);

    }

    @Override
    public String prueba(String str) {
        String s = str.concat(" perez");
        
        return GenericUtils.super.prueba(s);
    }

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse)
            throws PortletException {

        Consumer <String> consumer = System.out::println;
        consumer.accept(" hola");

        List<String> list = new ArrayList<>();

        list.forEach(CustomerRenderCommand::pintar);


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
            CustomerRenderCommand customerRenderCommand = new CustomerRenderCommand();
            List<Customer> customers = _customerLocalService.getCustomers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
            renderRequest.setAttribute(CustomersConstans.LIST_CUSTOMERS, customers);

            String json = "[{\"name\":\"luis\",\"hijos\":[{\"name\":\"Abril\",\"lastName\":\"Perez Janel\"},{\"name\":\"Luis\",\"lastName\":\"Perez\"}]},{\"name\":\"luismi\",\"lastName\":\"pacheco\"},{\"name\":\"luisa\",\"lastName\":\"gutierrez\"},{\"name\":\"Cristina\",\"lastName\":\"Moro\",\"hijos\":[{\"name\":\"Abril\",\"lastName\":\"Janel\"},{\"name\":\"Abril\",\"lastName\":\"Perez \"}]}]";
            Type listType = new TypeToken<List<Bean>>() {}.getType();
            List<Bean> bean = customerRenderCommand.jsonToBean(json, listType);

            //bean.stream().filter(Validator::isNotNull).forEach(System.out::println);

            String pruebaArrayJs =  "[\"test1\",\"test2\",\"test3\",\"test4\"]";

            try {
                JSONArray ja = JSONFactoryUtil.createJSONArray(pruebaArrayJs);
                ja.forEach(System.out::println);
            } catch (JSONException e) {
                e.printStackTrace();
            }


            String luis = "LuisMi";

            print(prueba(luis));



            return CustomersConstans.VIEW_JSP;
        }

    }
}
