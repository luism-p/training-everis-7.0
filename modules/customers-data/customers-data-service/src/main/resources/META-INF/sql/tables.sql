create table TRAINING_Customer (
	uuid_ VARCHAR(75) null,
	customerId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	address VARCHAR(75) null,
	phoneNumber VARCHAR(75) null
);