create table demo_entity
(
  id          int auto_increment
    primary key,
  name        varchar(30)  not null,
  create_time datetime     null,
  update_time datetime     null,
  creator_id  int          null,
  updater_id  int          null,
  site_num    varchar(100) null,
  description varchar(100) null,
  constraint demo_name_uindex
  unique (name)
);