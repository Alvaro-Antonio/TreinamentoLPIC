CREATE SEQUENCE user_sequence
    INCREMENT BY 1
    START WITH 1
    MAXVALUE 9223372036854775807
    MINVALUE 1
    NO CYCLE;

CREATE TABLE "user" (
                        id int8 NOT NULL DEFAULT nextval('user_sequence'),
                        first_name varchar(64) NOT NULL,
                        last_name varchar(64) NOT NULL,
                        email varchar(64) UNIQUE NOT NULL,
                        password VARCHAR(256) NOT NULL,
                        profile_picture VARCHAR(1024) NULL,
                        creation_date TIMESTAMP NOT NULL,
                        last_login_date TIMESTAMP NULL,
                        CONSTRAINT user_pkey PRIMARY KEY (id)
);