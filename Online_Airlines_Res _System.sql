-------CREATING FAREUSER SCHEMA---------------

CREATE TABLESPACE TBS_FAREUSER  DATAFILE 'TBS_FAREUSER.DAT' SIZE 10M AUTOEXTEND ON;

CREATE USER FAREUSER IDENTIFIED BY 3899 DEFAULT TABLESPACE TBS_FAREUSER QUOTA UNLIMITED ON TBS_FAREUSER;

GRANT CREATE SESSION TO FAREUSER;
GRANT CREATE TABLE TO FAREUSER;
GRANT CREATE SEQUENCE TO FAREUSER;

-------CREATING SEARCH SCHEMA-------------------

CREATE TABLESPACE TBS_SEARCHUSER DATAFILE 'TBS_SEARCHUSER.DAT' SIZE 10M AUTOEXTEND ON;

CREATE USER SEARCHUSER IDENTIFIED BY 3899 DEFAULT TABLESPACE TBS_SEARCHUSER QUOTA UNLIMITED ON TBS_SEARCHUSER;

GRANT CREATE SESSION TO SEARCHUSER;
GRANT CREATE TABLE TO SEARCHUSER;
GRANT CREATE SEQUENCE TO SEARCHUSER;

--------CREATING BOOKING SCHEMA----------------

CREATE TABLESPACE TBS_BOOKINGUSER DATAFILE 'TBS_BOOKINGUSER.DAT' SIZE 10M AUTOEXTEND ON;

CREATE USER BOOKINGUSER IDENTIFIED BY 3899 DEFAULT TABLESPACE TBS_BOOKINGUSER QUOTA UNLIMITED ON TBS_BOOKINGUSER;

GRANT CREATE SESSION TO BOOKINGUSER;
GRANT CREATE TABLE TO BOOKINGUSER;
GRANT CREATE SEQUENCE TO BOOKINGUSER;

------CREATING CHECK IN SCHEMA------------

CREATE TABLESPACE TBS_CHECKINUSER DATAFILE 'TBS_CHECKINUSER.DAT' SIZE 10M AUTOEXTEND ON;

CREATE USER CHECKINUSER IDENTIFIED BY 3899 DEFAULT TABLESPACE TBS_CHECKINUSER QUOTA UNLIMITED ON TBS_CHECKINUSER;

GRANT CREATE SESSION TO CHECKINUSER;
GRANT CREATE TABLE TO CHECKINUSER;
GRANT CREATE SEQUENCE TO CHECKINUSER;

------CREATING TABLE AND SEQUENCES IN FAREUSER----

drop table fare cascade constraints;
drop sequence fare_seq;
create table fare (id number(19) primary key, fare varchar2(255), flight_date varchar2(255), flight_number varchar2(255));
create sequence fare_seq start with 1 increment by 1;

-------INSERTING DATA IN FAREUSER--------------

insert into fare(id, fare, flight_date, flight_number)values (fare_seq.nextVal, '100', '22-JAN-16', 'BF100');
insert into fare(id, fare, flight_date, flight_number) values (fare_seq.nextVal, '101', '22-JAN-16', 'BF101');
insert into fare(id, fare, flight_date, flight_number)values (fare_seq.nextVal, '102', '22-JAN-16', 'BF102');
insert into fare(id, fare, flight_date, flight_number)values (fare_seq.nextVal, '103', '22-JAN-16', 'BF103');
insert into fare(id, fare, flight_date, flight_number)values (fare_seq.nextVal, '104', '22-JAN-16', 'BF104');
insert into fare(id, fare, flight_date, flight_number)values (fare_seq.nextVal, '105', '22-JAN-16', 'BF105');
insert into fare values (fare_seq.nextVal, '106','22-JAN-16', 'BF106');

SELECT * FROM FAREUSER.FARE ORDER BY ID ASC;
COMMIT;
DELETE FROM FARE;
-------CREATING TABLE AND SEQUENCES IN SEARCHUSER------
drop table fare cascade constraints;
drop table flight cascade constraints;
drop table inventory cascade constraints;
drop sequence fare_seq;
drop sequence flight_seq;
drop sequence inventory_seq;

create sequence fare_seq start with 1 increment by 1;
create sequence flight_seq start with 1 increment by 1;
create sequence inventory_seq start with 1 increment by 1;

create table fare1(fare_id number(19) primary key, currency varchar2(255), price varchar2(255));

create table inventory(inv_id number(19) primary key, count number(10) not null);

create table flight(id number(19) primary key, destination varchar2(255), flight_date varchar2(255), flight_number varchar2(255), origin varchar2(255), fare_id number(19) references fare1(fare_id), inv_id number(19) references inventory(inv_id));

-----------------------------INSERT DATA IN SEARCHUSER-------------------------

insert into fare1 values (fare_seq.nextVal, 'USD', 100);
insert into fare1 values (fare_seq.nextVal, 'USD', 101);
insert into fare1 values (fare_seq.nextVal, 'USD', 102);
insert into fare1 values (fare_seq.nextVal, 'USD', 103);
insert into fare1 values (fare_seq.nextVal, 'USD', 104);
insert into fare1 values (fare_seq.nextVal, 'USD', 105);
insert into fare1 values (fare_seq.nextVal, 'USD', 106);

SELECT * FROM FARE1;

insert into inventory (count, inv_id) values (100, inventory_seq.nextVal);
insert into inventory (count, inv_id) values (100, inventory_seq.nextVal);
insert into inventory (count, inv_id) values (100, inventory_seq.nextVal);
insert into inventory (count, inv_id) values (100, inventory_seq.nextVal);
insert into inventory (count, inv_id) values (100, inventory_seq.nextVal);
insert into inventory (count, inv_id) values (100, inventory_seq.nextVal);
insert into inventory (count, inv_id) values (100, inventory_seq.nextVal);

SELECT * FROM INVENTORY;

insert into flight (id, flight_number, origin, destination, flight_date, fare_id, inv_id) values (flight_seq.nextVal, 'BF100', 'SEA', 'SFO', '22-JAN-16', 1, 1);
insert into flight (id, flight_number, origin, destination, flight_date, fare_id, inv_id) values (flight_seq.nextVal, 'BF101', 'NYC', 'SFO', '22-JAN-16', 2, 2);
insert into flight (id, flight_number, origin, destination, flight_date, fare_id, inv_id) values (flight_seq.nextVal, 'BF102', 'CHI', 'SFO', '22-JAN-16', 3, 3);
insert into flight (id, flight_number, origin, destination, flight_date, fare_id, inv_id) values (flight_seq.nextVal, 'BF103', 'HOU', 'SFO', '22-JAN-16', 4, 4);
insert into flight (id, flight_number, origin, destination, flight_date, fare_id, inv_id) values (flight_seq.nextVal, 'BF104', 'LAX', 'SFO', '22-JAN-16', 5, 5);
insert into flight (id, flight_number, origin, destination, flight_date, fare_id, inv_id) values (flight_seq.nextVal, 'BF105', 'NYC', 'SFO', '22-JAN-16', 6, 6);
insert into flight (id, flight_number, origin, destination, flight_date, fare_id, inv_id) values (flight_seq.nextVal, 'BF106', 'NYC', 'SFO', '22-JAN-16', 7, 7);

SELECT * FROM FLIGHT;

COMMIT;

---------CREATE TABLE AND SEQUENCES IN BOOKINGUSER--------------
drop table inventory cascade constraints;
drop table booking_record cascade constraints;
drop table passenger cascade constraints;

drop sequence booking_seq;
drop sequence inventory_seq;
drop sequence passenger_seq;

create sequence booking_seq start with 1 increment by 1;
create sequence inventory_seq1 start with 1 increment by 1;
create sequence passenger_seq start with 1 increment by 1;

create table booking_record (id number(19) primary key, booking_date timestamp, destination varchar2(255),price varchar2(255), flight_date varchar2(255), flight_number varchar2(255), origin varchar2(255), status varchar2(255));

create table inventory (id number(19) primary key, available number(10) not null, flight_date varchar2(255), flight_number varchar2(255));

create table passenger (id number(19) primary key, first_name varchar2(255), gender varchar2(255), last_name varchar2(255), booking_id number(19)references booking_record(id));


-----------INSERT DATA IN BOOKINGUSER----------------

insert into inventory(flight_number, flight_date, available, id) values ('BF100', '22-JAN-16', 100, inventory_seq1.nextVal);
insert into inventory(flight_number, flight_date, available, id) values ('BF101', '22-JAN-16', 100, inventory_seq1.nextVal);
insert into inventory(flight_number, flight_date, available, id) values ('BF102', '22-JAN-16', 100, inventory_seq1.nextVal);
insert into inventory(flight_number, flight_date, available, id) values ('BF103', '22-JAN-16', 100, inventory_seq1.nextVal);
insert into inventory(flight_number, flight_date, available, id) values ('BF104', '22-JAN-16', 100, inventory_seq1.nextVal);
insert into inventory(flight_number, flight_date, available, id) values ('BF105', '22-JAN-16', 100, inventory_seq1.nextVal);
insert into inventory(flight_number, flight_date, available, id) values ('BF106', '22-JAN-16', 100, inventory_seq1.nextVal);

COMMIT;

SELECT * FROM INVENTORY;


drop table check_in_record cascade constraints;
drop sequence checkin_seq;

create sequence checkin_seq start with 1 increment by 1;

create table check_in_record (id number(19)primary key, booking_id number(19) not null, check_in_time timestamp, first_name varchar2(255), flight_date varchar2(255), flight_number varchar2(255), last_name varchar2(255), seat_number varchar2(255));





select * from v$datafile;
select * from v$tablespace;

select value from v$parameter where name = 'db_create_file_dest';

Select FILE_NAME from dba_data_files ;