package com.liferay.blade.samples.configurationaction.convert;
//
//import com.liferay.configuration.admin.display.ConfigurationScreen;
//import com.liferay.frontend.taglib.servlet.taglib.util.JSPRenderer;
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Reference;
//
//import javax.servlet.ServletContext;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Locale;
//
//@Component(immediate = true, service = ConfigurationScreen.class)
//public class SampleConfigurationScreen implements ConfigurationScreen {
//    @Override
//    public String getCategoryKey() {
//
//        return "third-party";
//
//    }
//
//    @Override
//    public String getKey() {
//
//        return "sample-configuration-screen";
//
//    }
//
//    @Override
//    public String getName(Locale locale) {
//
//        return "Sample Configuration Screen";
//
//    }
//
//    @Override
//    public String getScope() {
//
//        return "system";
//
//    }
//
//    @Override
//    public void render(HttpServletRequest request, HttpServletResponse response)
//            throws IOException {
//
//        _jspRenderer.renderJSP( _servletContext, request, response,
//                "/sample_configuration_screen.jsp");
//
//    }
//
//    @Reference
//    private JSPRenderer _jspRenderer;
//
//    @Reference(
//            target ="(osgi.web.symbolicname=com.liferay.currency.converter.web)",
//            unbind = "-")
//    private ServletContext _servletContext;
//}
