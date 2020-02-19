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

package com.liferay.trainin.customers.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Customer service. Represents a row in the &quot;TRAINING_Customer&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.trainin.customers.model.impl.CustomerModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.trainin.customers.model.impl.CustomerImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Customer
 * @generated
 */
@ProviderType
public interface CustomerModel extends BaseModel<Customer> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a customer model instance should use the {@link Customer} interface instead.
	 */

	/**
	 * Returns the primary key of this customer.
	 *
	 * @return the primary key of this customer
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this customer.
	 *
	 * @param primaryKey the primary key of this customer
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this customer.
	 *
	 * @return the uuid of this customer
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this customer.
	 *
	 * @param uuid the uuid of this customer
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the customer ID of this customer.
	 *
	 * @return the customer ID of this customer
	 */
	public long getCustomerId();

	/**
	 * Sets the customer ID of this customer.
	 *
	 * @param customerId the customer ID of this customer
	 */
	public void setCustomerId(long customerId);

	/**
	 * Returns the create date of this customer.
	 *
	 * @return the create date of this customer
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this customer.
	 *
	 * @param createDate the create date of this customer
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this customer.
	 *
	 * @return the modified date of this customer
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this customer.
	 *
	 * @param modifiedDate the modified date of this customer
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this customer.
	 *
	 * @return the name of this customer
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this customer.
	 *
	 * @param name the name of this customer
	 */
	public void setName(String name);

	/**
	 * Returns the address of this customer.
	 *
	 * @return the address of this customer
	 */
	@AutoEscape
	public String getAddress();

	/**
	 * Sets the address of this customer.
	 *
	 * @param address the address of this customer
	 */
	public void setAddress(String address);

	/**
	 * Returns the phone number of this customer.
	 *
	 * @return the phone number of this customer
	 */
	@AutoEscape
	public String getPhoneNumber();

	/**
	 * Sets the phone number of this customer.
	 *
	 * @param phoneNumber the phone number of this customer
	 */
	public void setPhoneNumber(String phoneNumber);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Customer customer);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Customer> toCacheModel();

	@Override
	public Customer toEscapedModel();

	@Override
	public Customer toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}