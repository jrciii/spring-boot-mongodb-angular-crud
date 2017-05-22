package com.jrciii.crudexample.domain;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

public class Employee {
	@Id
	private String id;

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;

	private String middleInitial;

	@Email
	private String emailAddress;

	@Pattern(regexp = "(^$|[0-9]{10})")
	private String phoneNumber;

	private EmployeePositionCategory positionCategory;

	@DateTimeFormat
	private Date dateHired;

	private String addressOne;

	private String addressTwo;

	private String city;

	private State state;

	@Digits(fraction = 0, integer = 5)
	private Integer zipCode;

	@NotNull
	private boolean active;

	public Employee() {

	}

	public Employee(String id, String firstName, String lastName, String middleInitial, String emailAddress,
			String phoneNumber, EmployeePositionCategory positionCategory, Date dateHired, String addressOne,
			String addressTwo, String city, State state, Integer zipCode, boolean active) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleInitial = middleInitial;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.positionCategory = positionCategory;
		this.dateHired = dateHired;
		this.addressOne = addressOne;
		this.addressTwo = addressTwo;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.active = active;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public EmployeePositionCategory getPositionCategory() {
		return positionCategory;
	}

	public void setPositionCategory(EmployeePositionCategory positionCategory) {
		this.positionCategory = positionCategory;
	}

	public Date getDateHired() {
		return dateHired;
	}

	public void setDateHired(Date dateHired) {
		this.dateHired = dateHired;
	}

	public String getAddressOne() {
		return addressOne;
	}

	public void setAddressOne(String addressOne) {
		this.addressOne = addressOne;
	}

	public String getAddressTwo() {
		return addressTwo;
	}

	public void setAddressTwo(String addressTwo) {
		this.addressTwo = addressTwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((addressOne == null) ? 0 : addressOne.hashCode());
		result = prime * result + ((addressTwo == null) ? 0 : addressTwo.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((dateHired == null) ? 0 : dateHired.hashCode());
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((middleInitial == null) ? 0 : middleInitial.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((positionCategory == null) ? 0 : positionCategory.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (active != other.active)
			return false;
		if (addressOne == null) {
			if (other.addressOne != null)
				return false;
		} else if (!addressOne.equals(other.addressOne))
			return false;
		if (addressTwo == null) {
			if (other.addressTwo != null)
				return false;
		} else if (!addressTwo.equals(other.addressTwo))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (dateHired == null) {
			if (other.dateHired != null)
				return false;
		} else if (!dateHired.equals(other.dateHired))
			return false;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (middleInitial == null) {
			if (other.middleInitial != null)
				return false;
		} else if (!middleInitial.equals(other.middleInitial))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (positionCategory != other.positionCategory)
			return false;
		if (state != other.state)
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}
}
