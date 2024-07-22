create table digits
(
    id          bigserial   not null,
    starting    int,
    ending      int,
    primary key (id)
);

create table letters
(
    id          bigserial   not null,
    starting    char(1),
    ending      char(1),
    primary key (id)
)