package com.liferay.blade.samples.configurationaction.lang;


import com.liferay.configuration.admin.display.ConfigurationFormRenderer;
import com.liferay.dynamic.data.mapping.model.DDMTemplate;
import com.liferay.dynamic.data.mapping.service.DDMTemplateLocalService;
import com.liferay.frontend.taglib.servlet.taglib.util.JSPRenderer;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.servlet.taglib.ui.LanguageEntry;
import com.liferay.portal.kernel.util.LocaleThreadLocal;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Component(
        configurationPid = "com.liferay.blade.samples.configurationaction.lang.SiteNavigationLanguageWebTemplateConfiguration",
        immediate = true, service = ConfigurationFormRenderer.class
)
public class LanguageTemplateConfigurationFormRenderer implements ConfigurationFormRenderer{

    @Activate
    @Modified
    public void activate(Map<String, Object> properties) {
        _siteNavigationLanguageWebTemplateConfiguration =
                ConfigurableUtil.createConfigurable(
                        SiteNavigationLanguageWebTemplateConfiguration.class,
                        properties);
    }

    private volatile SiteNavigationLanguageWebTemplateConfiguration
            _siteNavigationLanguageWebTemplateConfiguration;

    @Override
    public String getPid() {
        return "com.liferay.blade.samples.configurationaction.lang." +
                "SiteNavigationLanguageWebTemplateConfiguration";
    }

    @Override
    public Map<String, Object> getRequestParameters(
            HttpServletRequest request) {

        Map<String, Object> params = new HashMap<>();

        String ddmTemplateKey = ParamUtil.getString(request, "ddmTemplateKey");

        params.put("ddmTemplateKey", ddmTemplateKey);

        return params;
    }

    @Override
    public void render(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Locale locale = LocaleThreadLocal.getThemeDisplayLocale();

        LanguageTemplateConfigurationDisplayContext
                languageTemplateConfigurationDisplayContext =
                new LanguageTemplateConfigurationDisplayContext();

        languageTemplateConfigurationDisplayContext.setCurrentTemplateName(
                _siteNavigationLanguageWebTemplateConfiguration.ddmTemplateKey());

        long groupId = 0;

        Group group = _groupLocalService.fetchCompanyGroup(
                CompanyThreadLocal.getCompanyId());

        if (group != null) {
            groupId = group.getGroupId();
        }

        List<DDMTemplate> ddmTemplates = _ddmTemplateLocalService.getTemplates(
                groupId, _portal.getClassNameId(LanguageEntry.class));

        for (DDMTemplate ddmTemplate : ddmTemplates) {
            languageTemplateConfigurationDisplayContext.addTemplateValue(
                    ddmTemplate.getTemplateKey(), ddmTemplate.getName(locale));
        }

        languageTemplateConfigurationDisplayContext.setFieldLabel(
                LanguageUtil.get(
                        ResourceBundleUtil.getBundle(
                                String.valueOf(locale), LanguageTemplateConfigurationFormRenderer.class),
                        "language-selection-style"));

        request.setAttribute(
                LanguageTemplateConfigurationDisplayContext.class.getName(),
                languageTemplateConfigurationDisplayContext);

        _jspRenderer.renderJSP(
                _servletContext, request, response,
                "/template.jsp");
    }


    @Reference
    private DDMTemplateLocalService _ddmTemplateLocalService;

    @Reference
    private GroupLocalService _groupLocalService;

    @Reference
    private JSPRenderer _jspRenderer;

    @Reference
    private Portal _portal;

    @Reference(
            target = "(osgi.web.symbolicname=com.liferay.blade.samples.configurationaction.lang)",
            unbind = "-"
    )
    private ServletContext _servletContext;
}
