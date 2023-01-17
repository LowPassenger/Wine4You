create table meals
(
    id        bigserial not null,
    meal_name varchar(255),
    primary key (id)
);

alter table if exists wines
    add constraint FK15e5jxb5oyeijbe5vfow0xiw0
        foreign key (meal_id)
            references meals