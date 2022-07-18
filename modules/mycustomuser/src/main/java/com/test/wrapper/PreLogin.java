package com.test.wrapper;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.service.ServiceWrapper;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        property = {
                "key = login.events.pre"
        },
        service = LifecycleAction.class
)
public class PreLogin implements LifecycleAction{
        @Override
        public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {
                System.out.println("This will print before Login");
        }
}
