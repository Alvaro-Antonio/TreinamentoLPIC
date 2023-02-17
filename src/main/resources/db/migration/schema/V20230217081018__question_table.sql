CREATE SEQUENCE question_sequence
    INCREMENT BY 1
    START WITH 1
    MAXVALUE 9223372036854775807
    MINVALUE 1
    NO CYCLE;

CREATE TABLE question
(
    id int8 NOT NULL DEFAULT nextval('question_sequence'),
    title varchar(512) NOT NULL,
    feedback_id int8 not null,
    user_create_id int8 not null ,

    CONSTRAINT question_pkey PRIMARY KEY (id),
    CONSTRAINT feedback_id_pkey FOREIGN KEY (feedback_id) references feedback(id) ON DELETE CASCADE,
    CONSTRAINT user_create_id_pkey foreign key (user_create_id) references user_manager(id)
);