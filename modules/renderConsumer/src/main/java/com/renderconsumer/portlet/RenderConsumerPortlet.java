package com.renderconsumer.portlet;

import com.liferay.portal.kernel.util.ParamUtil;
import com.renderconsumer.constants.RenderConsumerPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import java.io.IOException;

/**
 * @author MalicYur
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=RenderConsumer",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + RenderConsumerPortletKeys.RENDERCONSUMER,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user",
                "javax.portlet.supported-public-render-parameter=message"
        },
        service = Portlet.class
)
public class RenderConsumerPortlet extends MVCPortlet {
        @Override
        public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
                String message = ParamUtil.getString(renderRequest, "message");
                System.out.println(message);
                renderRequest.setAttribute("message", message);
                super.doView(renderRequest, renderResponse);
        }
}