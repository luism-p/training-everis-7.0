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
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Customer}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Customer
 * @generated
 */
@ProviderType
public class CustomerWrapper implements Customer, ModelWrapper<Customer> {

	public CustomerWrapper(Customer customer) {
		_customer = customer;
	}

	@Override
	public Class<?> getModelClass() {
		return Customer.class;
	}

	@Override
	public String getModelClassName() {
		return Customer.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("customerId", getCustomerId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("address", getAddress());
		attributes.put("phoneNumber", getPhoneNumber());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long customerId = (Long)attributes.get("customerId");

		if (customerId != null) {
			setCustomerId(customerId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String phoneNumber = (String)attributes.get("phoneNumber");

		if (phoneNumber != null) {
			setPhoneNumber(phoneNumber);
		}
	}

	@Override
	public Object clone() {
		return new CustomerWrapper((Customer)_customer.clone());
	}

	@Override
	public int compareTo(Customer customer) {
		return _customer.compareTo(customer);
	}

	/**
	 * Returns the address of this customer.
	 *
	 * @return the address of this customer
	 */
	@Override
	public String getAddress() {
		return _customer.getAddress();
	}

	/**
	 * Returns the create date of this customer.
	 *
	 * @return the create date of this customer
	 */
	@Override
	public Date getCreateDate() {
		return _customer.getCreateDate();
	}

	/**
	 * Returns the customer ID of this customer.
	 *
	 * @return the customer ID of this customer
	 */
	@Override
	public long getCustomerId() {
		return _customer.getCustomerId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _customer.getExpandoBridge();
	}

	/**
	 * Returns the modified date of this customer.
	 *
	 * @return the modified date of this customer
	 */
	@Override
	public Date getModifiedDate() {
		return _customer.getModifiedDate();
	}

	/**
	 * Returns the name of this customer.
	 *
	 * @return the name of this customer
	 */
	@Override
	public String getName() {
		return _customer.getName();
	}

	/**
	 * Returns the phone number of this customer.
	 *
	 * @return the phone number of this customer
	 */
	@Override
	public String getPhoneNumber() {
		return _customer.getPhoneNumber();
	}

	/**
	 * Returns the primary key of this customer.
	 *
	 * @return the primary key of this customer
	 */
	@Override
	public long getPrimaryKey() {
		return _customer.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _customer.getPrimaryKeyObj();
	}

	/**
	 * Returns the uuid of this customer.
	 *
	 * @return the uuid of this customer
	 */
	@Override
	public String getUuid() {
		return _customer.getUuid();
	}

	@Override
	public int hashCode() {
		return _customer.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _customer.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _customer.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _customer.isNew();
	}

	@Override
	public void persist() {
		_customer.persist();
	}

	/**
	 * Sets the address of this customer.
	 *
	 * @param address the address of this customer
	 */
	@Override
	public void setAddress(String address) {
		_customer.setAddress(address);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_customer.setCachedModel(cachedModel);
	}

	/**
	 * Sets the create date of this customer.
	 *
	 * @param createDate the create date of this customer
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_customer.setCreateDate(createDate);
	}

	/**
	 * Sets the customer ID of this customer.
	 *
	 * @param customerId the customer ID of this customer
	 */
	@Override
	public void setCustomerId(long customerId) {
		_customer.setCustomerId(customerId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_customer.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_customer.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_customer.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the modified date of this customer.
	 *
	 * @param modifiedDate the modified date of this customer
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_customer.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this customer.
	 *
	 * @param name the name of this customer
	 */
	@Override
	public void setName(String name) {
		_customer.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_customer.setNew(n);
	}

	/**
	 * Sets the phone number of this customer.
	 *
	 * @param phoneNumber the phone number of this customer
	 */
	@Override
	public void setPhoneNumber(String phoneNumber) {
		_customer.setPhoneNumber(phoneNumber);
	}

	/**
	 * Sets the primary key of this customer.
	 *
	 * @param primaryKey the primary key of this customer
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_customer.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_customer.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the uuid of this customer.
	 *
	 * @param uuid the uuid of this customer
	 */
	@Override
	public void setUuid(String uuid) {
		_customer.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Customer> toCacheModel() {
		return _customer.toCacheModel();
	}

	@Override
	public Customer toEscapedModel() {
		return new CustomerWrapper(_customer.toEscapedModel());
	}

	@Override
	public String toString() {
		return _customer.toString();
	}

	@Override
	public Customer toUnescapedModel() {
		return new CustomerWrapper(_customer.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _customer.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CustomerWrapper)) {
			return false;
		}

		CustomerWrapper customerWrapper = (CustomerWrapper)obj;

		if (Objects.equals(_customer, customerWrapper._customer)) {
			return true;
		}

		return false;
	}

	@Override
	public Customer getWrappedModel() {
		return _customer;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _customer.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _customer.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_customer.resetOriginalValues();
	}

	private final Customer _customer;

}