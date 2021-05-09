create table if not exists tbl_tasks (
    id serial not null primary key,
    title varchar(200) not null default null,
    description text,
    date_time_limit timestamp,
    created_at timestamp default CURRENT_TIMESTAMP not null,
    updated_at timestamp default CURRENT_TIMESTAMP not null,
    deleted_at timestamp
);

