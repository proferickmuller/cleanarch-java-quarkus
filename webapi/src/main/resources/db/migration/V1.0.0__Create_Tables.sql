create table pessoas (id text(100) primary key, nome text(100), endereco_email text(100), data_nascimento text(10));

create table cursos (id text(100) primary key, nome text(100), ativo bool);

create table estudantes (
                            pessoa_id text(100),
                            curso_id text(100),
                            foreign key (pessoa_id) references pessoas(id),
                            foreign key (curso_id) references cursos(id)
);