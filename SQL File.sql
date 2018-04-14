/*Database SQL Queries*/

create database banking;

use banking;

create table employee(empid varchar(20) primary key,empname varchar(20),emppassword varchar(20),empphone varchar(20),empaddress varchar(20));

create table account(customerid varchar(20) ,accountid varchar(20) primary key,accountbalance varchar(20),accounttype varchar(20));

create table customer(customerid varchar(20) primary key,customername varchar(20),customeraddress varchar(20),customercity varchar(20),customerphone varchar(20));

create table loan(customerid varchar(20),loanid varchar(20) primary key,loanamount varchar(20));

create table payment(loanid varchar(20),paymentid varchar(20) primary key,paymentdate varchar(50),paymentamount varchar(20));

create table transaction(customerid varchar(20),accountid varchar(20),date varchar(50),type varchar(20),destinationid varchar(20),amount varchar(20));
