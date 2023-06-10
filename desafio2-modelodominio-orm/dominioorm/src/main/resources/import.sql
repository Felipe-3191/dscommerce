INSERT INTO tb_categoria (descricao) VALUES ('Curso');
INSERT INTO tb_categoria (descricao) VALUES ('Oficina');

INSERT INTO tb_atividade (nome,descricao,preco,id_categoria) VALUES ('Curso de HTML', 'Aprenda HTML de forma prática', 80.00, 1);
INSERT INTO tb_atividade (nome,descricao,preco,id_categoria) VALUES ('Oficina de Github', 'Controle versões dos seus projetos', 50.00, 2);

INSERT INTO tb_bloco (inicio,fim,id_atividade) VALUES ('20170925T08:00:00Z', '20170925T11:00:00Z', 1);
INSERT INTO tb_bloco (inicio,fim,id_atividade) VALUES ('20170925T14:00:00Z', '20170925T18:00:00Z', 2);
INSERT INTO tb_bloco (inicio,fim,id_atividade) VALUES ('20170926T08:00:00Z', '20170926T11:00:00Z', 2);

INSERT INTO tb_participante(nome,email) VALUES ('José Silva', 'jose@gmail.com');
INSERT INTO tb_participante(nome,email) VALUES ('Tiago Faria', 'tiago@gmail.com');
INSERT INTO tb_participante(nome,email) VALUES ('Maria do Rosario', 'maria@gmail.com');
INSERT INTO tb_participante(nome,email) VALUES ('Teresa Silva', 'teresa@gmail.com');

INSERT INTO tb_atividade_participante (id_atividade,id_participante) VALUES (1,1);
INSERT INTO tb_atividade_participante (id_atividade,id_participante) VALUES (1,2);
INSERT INTO tb_atividade_participante (id_atividade,id_participante) VALUES (1,3);
INSERT INTO tb_atividade_participante (id_atividade,id_participante) VALUES (2,1);
INSERT INTO tb_atividade_participante (id_atividade,id_participante) VALUES (2,3);
INSERT INTO tb_atividade_participante (id_atividade,id_participante) VALUES (2,4);
