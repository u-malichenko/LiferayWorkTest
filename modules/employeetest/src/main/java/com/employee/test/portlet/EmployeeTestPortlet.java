package com.employee.test.portlet;

import com.employee.model.Employee;
import com.employee.service.EmployeeLocalServiceUtil;
import com.employee.test.constants.EmployeeTestPortletKeys;

import com.liferay.calendar.service.CalendarLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;

/**
 * @author MalicYur
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=A",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=EmployeeTest",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + EmployeeTestPortletKeys.EMPLOYEETEST,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user",
                "javax.portlet.supported-public-render-parameter=id"
        },
        service = Portlet.class
)
public class EmployeeTestPortlet extends MVCPortlet {

    public void employeeSubmit(ActionRequest request, ActionResponse response) {
        String name = ParamUtil.getString(request, "name");
        String email = ParamUtil.getString(request, "email");
        String mobile = ParamUtil.getString(request, "mobile");
        Employee employee = EmployeeLocalServiceUtil.createEmployee(CounterLocalServiceUtil.increment());
        employee.setName(name);
        employee.setEmail(email);
        employee.setMobile(mobile);
        EmployeeLocalServiceUtil.addEmployee(employee);

        System.out.println("Create " + name);

        String message = ParamUtil.getString(request, "message");

        String id = String.valueOf(employee.getEmpID());
        System.out.println("id =============== " + id);
        response.setRenderParameter("id", id);

    }

}