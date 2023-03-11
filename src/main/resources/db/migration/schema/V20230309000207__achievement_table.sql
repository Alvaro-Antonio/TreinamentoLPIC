CREATE SEQUENCE achievement_sequence
    INCREMENT BY 1
    START WITH 1
    MAXVALUE 9223372036854775807
    MINVALUE 1
    NO CYCLE;

create table achievement(
    id int8 NOT NULL DEFAULT nextval('achievement_sequence'),
    title varchar(20) not null,
    icon varchar(20) NOT NULL,
    description varchar(100),
    CONSTRAINT achievement_pkey PRIMARY KEY (id)
);

comment on table achievement is 'Nesta tabela estão presentes os nomes das conquistas.';