alter table user_manager add column
    indicators_id int8,
    add constraint indicators_id_fk foreign key (indicators_id) references indicators(id) on delete cascade;

comment on table user_manager is 'Tabela que contém os usuários do sistema.';