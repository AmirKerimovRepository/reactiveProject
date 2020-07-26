create table card
(
	id int auto_increment,
	ownerName VARCHAR(32) not null,
	ownerSurname VARCHAR(32) not null,
	cardNumber VARCHAR(255) not null,
	constraint card_pk
		primary key (id)
);

