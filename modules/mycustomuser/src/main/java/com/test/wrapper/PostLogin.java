package com.test.wrapper;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        property = {
                "key = login.events.post"
        },
        service = LifecycleAction.class
)
public class PostLogin implements LifecycleAction{
        @Override
        public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {
                System.out.println("This will print after Login");
        }
}
