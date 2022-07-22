package com.test.portlet;

import com.employee.service.EmployeeLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.test.constants.EmployeServiceTestPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.util.Objects;

/**
 * @author MalicYur
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=EmployeServiceTest",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + EmployeServiceTestPortletKeys.EMPLOYESERVICETEST,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user",
                "javax.portlet.supported-public-render-parameter=id"
        },
        service = Portlet.class
)
public class EmployeServiceTestPortlet extends MVCPortlet {
    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        try {
            String ids = ParamUtil.getString(renderRequest, "id");
            System.out.println("id==========" + ids);

            if (!ids.isBlank()){
                long id = Long.parseLong(ids);
                String message = EmployeeLocalServiceUtil.getEmployee(id).getName();
                System.out.println(message);
                renderRequest.setAttribute("message", message);

            }
			super.doView(renderRequest, renderResponse);
        } catch (PortalException e) {
            throw new RuntimeException(e);
        }
        super.doView(renderRequest, renderResponse);
    }
}