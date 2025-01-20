insert into users(id, username, firstname, lastname, password) values (nextval('user_seq'), 'david', 'david', 'cuthill', '123');

-- Publisher 1
insert into address (addressid, number, street, city, postcode, country) values (nextval('address_seq'), '75', ' Arlington Street', 'Boston', 'MA 02116', 'USA');
insert into publisher (publisherid, name, address_addressid) values (nextval('publisher_seq'), 'Addison-Wesley', 1);

-- Book 1
insert into author (id, firstname, lastname, biography) values (nextval('author_seq'), 'Erich', 'Gamma', 'A computer scientist');
insert into author (id, firstname, lastname, biography) values (nextval('author_seq'), 'Richard', 'Helm', 'A computer consultant');
insert into author (id, firstname, lastname, biography) values (nextval('author_seq'), 'Ralph', 'Johnston', 'Research Professor');
insert into author (id, firstname, lastname, biography) values (nextval('author_seq'), 'John', 'Vlissides', 'Software Engineer');

insert into book (bookid, title, isbn, price, publicationdate, discontinued, publisher_publisherid) values (nextval('book_seq'), 'Design Patterns', '123-4567890', 28.95, PARSEDATETIME('21/10/1994', 'dd/MM/yyyy'), false, 1);

insert into book_authors (book_bookid, authors_id) values (1, 1);
insert into book_authors (book_bookid, authors_id) values (1, 2);
insert into book_authors (book_bookid, authors_id) values (1, 3);
insert into book_authors (book_bookid, authors_id) values (1, 4);


-- Publisher 2
insert into address (addressid, number, street, city, postcode, country) values (nextval('address_seq'), '20', ' Baldwin Road', 'Shelter Island, Boston', 'NY 11964', 'USA');
insert into publisher (publisherid, name, address_addressid) values (nextval('publisher_seq'), 'Manning Publications', 2);

-- Book 2
insert into author (id, firstname, lastname, biography) values (nextval('author_seq'), 'Craig', 'Walls', 'A senior engineer with Pivotal as the Spring Social project lead');

insert into book (bookid, title, isbn, price, publicationdate, discontinued, publisher_publisherid) values (nextval('book_seq'), 'Spring In Action, Fifth Edition', '978-1617294945', 15.25, PARSEDATETIME('31/10/2018', 'dd/MM/yyyy'), false, 2);

insert into book_authors (book_bookid, authors_id) values (2, 5);

-- Test Publisher
insert into address (addressid, number, street, city, postcode, country) values (nextval('address_seq'), '1', ' Test Street', 'Test City', 'ABC 123', 'UK');
insert into publisher (publisherid, name, address_addressid) values (nextval('publisher_seq'), 'Test Publisher', 3);
