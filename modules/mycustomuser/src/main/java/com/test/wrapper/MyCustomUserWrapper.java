package com.test.wrapper;

import com.liferay.portal.kernel.service.UserLocalServiceWrapper;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.service.component.annotations.Component;

/**
 * @author MalicYur
 */
@Component(
	immediate = true,
	property = {
	},
	service = ServiceWrapper.class
)
public class MyCustomUserWrapper extends UserLocalServiceWrapper {

	public MyCustomUserWrapper() {
		super(null);
	}

	@Override
	public int getUsersCount() {
		System.out.println("===============My Custom Method Call===============================================");
		return super.getUsersCount();
	}
}