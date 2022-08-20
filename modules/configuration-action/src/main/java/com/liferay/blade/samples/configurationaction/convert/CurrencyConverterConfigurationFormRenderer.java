package com.liferay.blade.samples.configurationaction.convert;
//
//import com.liferay.configuration.admin.display.ConfigurationFormRenderer;
//import com.liferay.portal.kernel.util.ParamUtil;
//import org.osgi.service.component.annotations.Component;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.HashMap;
//import java.util.Map;
//
//@Component(immediate = true, service = ConfigurationFormRenderer.class)
//public class CurrencyConverterConfigurationFormRenderer
//        implements ConfigurationFormRenderer {
//
//    @Override
//    public String getPid() {
//        return "com.liferay.blade.samples.configurationaction.convert.CurrencyConverterConfiguration";
//    }
//
//    @Override
//    public void render(HttpServletRequest request, HttpServletResponse response)
//            throws IOException {
//
//        String formHtml = "<input name=\"mysymbols\" />";
//
//        PrintWriter writer = response.getWriter();
//
//        writer.print(formHtml);
//
//    }
//
//    @Override
//    public Map<String, Object> getRequestParameters(
//            HttpServletRequest request) {
//
//        Map<String, Object> params = new HashMap<>();
//
//        String[] mysymbols = ParamUtil.getParameterValues(request, "mysymbols");
//
//        params.put("symbols", mysymbols);
//
//        return params;
//    }
//}
