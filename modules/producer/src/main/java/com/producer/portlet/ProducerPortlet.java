package com.producer.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.producer.constants.ProducerPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;
import javax.xml.namespace.QName;

/**
 * @author MalicYur
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.ipc",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=Producer",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + ProducerPortletKeys.PRODUCER,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user",
                "javax.portlet.supported-publishing-event=producemessage;http://a.com"
        },
        service = Portlet.class
)
public class ProducerPortlet extends MVCPortlet {

    @ProcessAction(name = "producer")
    public void producer(ActionRequest request, ActionResponse response) {
        String message = ParamUtil.getString(request, "message");
        QName qName = new QName("http://a.com", "producemessage");
        response.setEvent(qName, message);

    }
}