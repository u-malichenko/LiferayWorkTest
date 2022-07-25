package com.css.testing.portlet;

import com.css.testing.constants.CSSTestingPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.service.UserLocalServiceUtil;
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
		"javax.portlet.display-name=CSSTesting",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/test/view.jsp",
		"javax.portlet.name=" + CSSTestingPortletKeys.CSSTESTING,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CSSTestingPortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		System.out.println("Testing for CSS==="+ UserLocalServiceUtil.getUsersCount());
		super.doView(renderRequest, renderResponse);
	}
}