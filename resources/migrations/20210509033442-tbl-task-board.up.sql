create table if not exists tbl_task_board (
    id serial not null primary key,
    title varchar(200) not null default null,
    created_at timestamp default CURRENT_TIMESTAMP not null,
    updated_at timestamp default CURRENT_TIMESTAMP not null,
    deleted_at timestamp
);