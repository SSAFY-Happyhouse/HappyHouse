create database if not exists springtest;
use springtest;

drop table if exists patient;
drop table if exists country;
drop table if exists userinfo;

create table country(
ccode char(2) primary key,
    cname varchar(20) not null
);

create table patient(
   pno varchar(30)  primary key,
   name varchar(20) not null,
    age int not null,
    ccode char(2),
    constraint fk_country foreign key(ccode) references country(ccode)
);

create table userinfo(
id varchar(20) primary key,
    pw varchar(20) not null
);


insert into country values('kr','대한민국') , ('us','미국'),('cn','중국');

insert into userinfo values('ssafy', 'ssafy');

insert into patient  values('1','홍길동', 20, 'kr'), ('2','andy', 25, 'us');

commit;

select * from country;
select * from patient;