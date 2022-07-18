/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.employee.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Employee service. Represents a row in the &quot;employee&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.employee.model.impl.EmployeeModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.employee.model.impl.EmployeeImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Employee
 * @generated
 */
@ProviderType
public interface EmployeeModel extends BaseModel<Employee> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a employee model instance should use the {@link Employee} interface instead.
	 */

	/**
	 * Returns the primary key of this employee.
	 *
	 * @return the primary key of this employee
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this employee.
	 *
	 * @param primaryKey the primary key of this employee
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the emp ID of this employee.
	 *
	 * @return the emp ID of this employee
	 */
	public long getEmpID();

	/**
	 * Sets the emp ID of this employee.
	 *
	 * @param empID the emp ID of this employee
	 */
	public void setEmpID(long empID);

	/**
	 * Returns the name of this employee.
	 *
	 * @return the name of this employee
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this employee.
	 *
	 * @param name the name of this employee
	 */
	public void setName(String name);

	/**
	 * Returns the email of this employee.
	 *
	 * @return the email of this employee
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this employee.
	 *
	 * @param email the email of this employee
	 */
	public void setEmail(String email);

	/**
	 * Returns the mobile of this employee.
	 *
	 * @return the mobile of this employee
	 */
	@AutoEscape
	public String getMobile();

	/**
	 * Sets the mobile of this employee.
	 *
	 * @param mobile the mobile of this employee
	 */
	public void setMobile(String mobile);

	@Override
	public Employee cloneWithOriginalValues();

}