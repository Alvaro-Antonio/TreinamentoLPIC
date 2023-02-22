ALTER TABLE alternative
    DROP CONSTRAINT question_id_pkey,
    ADD CONSTRAINT  question_id_pkey
        FOREIGN KEY (question_id) REFERENCES question(id) ON DELETE CASCADE;