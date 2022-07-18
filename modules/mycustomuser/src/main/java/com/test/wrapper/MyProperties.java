package com.test.wrapper;

import com.liferay.portal.kernel.language.UTF8Control;
import com.liferay.portal.kernel.service.ServiceWrapper;
import org.osgi.service.component.annotations.Component;

import java.util.Enumeration;
import java.util.ResourceBundle;

@Component(
        property = {
                "language.id = en_US"
        },
        service = ResourceBundle.class
)
public class MyProperties extends ResourceBundle {
private final ResourceBundle resource = ResourceBundle.getBundle("content.Language", UTF8Control.INSTANCE);

    @Override
    protected Object handleGetObject(String key) {
        return resource.getObject(key);
    }

    @Override
    public Enumeration<String> getKeys() {
        return resource.getKeys();
    }
}
