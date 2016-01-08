# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table majors (
  major_id                  bigint auto_increment not null,
  major_name                varchar(255),
  constraint pk_majors primary key (major_id))
;

create table students (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  rollno                    bigint,
  age                       bigint,
  major_id                  bigint,
  constraint pk_students primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table majors;

drop table students;

SET FOREIGN_KEY_CHECKS=1;

