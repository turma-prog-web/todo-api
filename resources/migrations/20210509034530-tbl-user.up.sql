create table if not exists tbl_user (
    id serial not null primary key,
    name varchar(200) not null,
    password varchar(200) not null,
    email varchar(200) not null,
    image_profile varchar(200),
    created_at timestamp default CURRENT_TIMESTAMP not null,
    updated_at timestamp default CURRENT_TIMESTAMP not null,
    deleted_at timestamp
);

