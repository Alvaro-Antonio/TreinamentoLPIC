create table indicators_achievement(
    indicators_id int8 not null,
    achievement_id int8 not null,

    constraint indicators_id_fk foreign key (indicators_id) references indicators(id),
    constraint achievement_id_fk foreign key (achievement_id) references achievement(id),

    primary key (indicators_id, achievement_id)

);

comment on table indicators_achievement is 'Tabela que contém as conquistas de cada incicador/usuário';