package com.liferay.blade.samples.configurationaction.lang;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Juergen Kappler
 */
@ExtendedObjectClassDefinition(category = "localization")
@Meta.OCD(
        id = "com.liferay.blade.samples.configurationaction.lang.SiteNavigationLanguageWebTemplateConfiguration",
        localization = "content/Language",
        name = "site-navigation-language-web-template-configuration-name"
)
public interface SiteNavigationLanguageWebTemplateConfiguration {

    @Meta.AD(
            deflt = "language-icon-menu-ftl", name = "ddm-template-key",
            required = false
    )
    public String ddmTemplateKey();

}
