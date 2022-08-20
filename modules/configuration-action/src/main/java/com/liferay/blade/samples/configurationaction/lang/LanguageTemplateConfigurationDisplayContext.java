package com.liferay.blade.samples.configurationaction.lang;

import java.util.ArrayList;
import java.util.List;

public class LanguageTemplateConfigurationDisplayContext {

    public void addTemplateValue(
            String templateKey, String templateDisplayName) {

        _templateValues.add(new String[] {templateKey, templateDisplayName});
    }

    public String getCurrentTemplateName() {
        return _currentTemplateName;
    }

    public String getFieldLabel() {
        return _fieldLabel;
    }

    public List<String[]> getTemplateValues() {
        return _templateValues;
    }

    public void setCurrentTemplateName(String currentTemplateName) {
        _currentTemplateName = currentTemplateName;
    }

    public void setFieldLabel(String fieldLabel) {
        _fieldLabel = fieldLabel;
    }

    private String _currentTemplateName;
    private String _fieldLabel;
    private final List<String[]> _templateValues = new ArrayList<>();

}