package com.consumer.portlet;

import com.consumer.constants.ConsumerPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;
import javax.xml.namespace.QName;

import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;

/**
 * @author MalicYur
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.ipc",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=Consumer",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + ConsumerPortletKeys.CONSUMER,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user",
                "javax.portlet.supported-processing-event=producemessage;http://a.com"
        },
        service = Portlet.class
)
public class ConsumerPortlet extends MVCPortlet {
    @ProcessEvent(qname = "{http://a.com}producemessage")
    public void producer(EventRequest request, EventResponse response) {
        Event event = request.getEvent();
        String message = event.getValue().toString();
        request.setAttribute("message", message);
    }
}