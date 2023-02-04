ALTER TABLE group_permission
    DROP CONSTRAINT group_id_fk,
    ADD CONSTRAINT group_id_fk
        FOREIGN KEY (group_id) REFERENCES group_manager(id);

ALTER TABLE group_permission
    DROP CONSTRAINT permission_id_fk,
    ADD CONSTRAINT  permission_id_fk
        FOREIGN KEY (permission_id) REFERENCES permission_manager(id);