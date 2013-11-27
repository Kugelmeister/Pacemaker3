# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table activity (
  id                        bigint not null,
  user_id                   bigint not null,
  type                      varchar(255),
  location                  varchar(255),
  distance                  float,
  constraint pk_activity primary key (id))
;

create table my_user (
  id                        bigint not null,
  firstname                 varchar(255),
  lastname                  varchar(255),
  email                     varchar(255),
  password                  varchar(255),
  constraint pk_my_user primary key (id))
;

create sequence activity_seq;

create sequence my_user_seq;

alter table activity add constraint fk_activity_my_user_1 foreign key (user_id) references my_user (id);
create index ix_activity_my_user_1 on activity (user_id);



# --- !Downs

drop table if exists activity cascade;

drop table if exists my_user cascade;

drop sequence if exists activity_seq;

drop sequence if exists my_user_seq;

