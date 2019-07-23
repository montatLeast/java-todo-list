create table items (
    id bigint primary key,
    name varchar(200)
);

create sequence HIBERNATE_SEQUENCE
minvalue 1
maxvalue 999999
start with 1
increment by 1
cache 20;
