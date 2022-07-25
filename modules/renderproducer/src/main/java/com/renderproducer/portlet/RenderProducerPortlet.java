package com.renderproducer.portlet;

import com.liferay.portal.kernel.util.ParamUtil;
import com.renderproducer.constants.RenderProducerPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;
import javax.xml.namespace.QName;

import org.osgi.service.component.annotations.Component;

/**
 * @author MalicYur
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=A",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=RenderProducer",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + RenderProducerPortletKeys.RENDERPRODUCER,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user",
                "javax.portlet.supported-public-render-parameter=message"
        },
        service = Portlet.class
)
public class RenderProducerPortlet extends MVCPortlet {

        @ProcessAction(name = "renderProducer")
        public void renderProducer(ActionRequest request, ActionResponse response) {
                String message = ParamUtil.getString(request, "message");

                response.setRenderParameter("message", message);

        }
}