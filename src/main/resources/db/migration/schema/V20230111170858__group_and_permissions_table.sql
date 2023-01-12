    CREATE SEQUENCE group_sequence
        INCREMENT BY 1
        START WITH 1
        MAXVALUE 9223372036854775807
        MINVALUE 1
        NO CYCLE;

    CREATE TABLE "group" (
        id int8 NOT NULL DEFAULT nextval('group_sequence'),
        "name" varchar(64) NOT NULL,
        description varchar(120) NOT NULL,
        CONSTRAINT group_pkey PRIMARY KEY (id)
    );


    CREATE SEQUENCE permission_sequence
        INCREMENT BY 1
        START WITH 1
        MAXVALUE 9223372036854775807
        MINVALUE 1
        NO CYCLE;

    create table "permission" (
         id int8 not null default nextval('permission_sequence'),
         "name" varchar(64) not null,
         description varchar(100) not null,

         constraint permission_pkey primary key(id)

    );

    create table group_permission(
        group_id int8 not null,
        permission_id int8 not null,

        constraint group_id_fk foreign key (group_id) references "group"(id),
        constraint permission_id_fk foreign key (permission_id) references "permission"(id),

        primary key(group_id,permission_id)
    );