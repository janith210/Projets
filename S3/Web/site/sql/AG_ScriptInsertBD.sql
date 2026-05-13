USE login;

-- =========================================
-- 1. PROMOTIONS
-- =========================================
INSERT INTO AG_Promotion (NomPromotion) VALUES 
('BUT-1'), ('BUT-2'), ('BUT-3');

-- =========================================
-- COVOITURAGE (6)
-- =========================================
INSERT INTO AG_Covoiturage (NumCovoiturage) VALUES 
(1), 
(2), 
(3), 
(4), 
(5), 
(6),
(7),
(8),
(9),
(10),
(11),
(12);

-- =========================================
-- 3. UTILISATEURS (70)
-- =========================================
INSERT INTO AG_Utilisateur (NumUtilisateur, LoginUtilisateur, MotDePasseUtilisateur, TypeUtilisateur) VALUES
-- Enseignants (1-20)
(1, 'psangoku', 'pass1', 'enseignant'), (2, 'amartin', 'pass2', 'enseignant'),
(3, 'lbernard', 'pass3', 'enseignant'), (4, 'cpetit', 'pass4', 'enseignant'),
(5, 'probert', 'pass5', 'enseignant'), (6, 'srichard', 'pass6', 'enseignant'),
(7, 'mdurand', 'pass7', 'enseignant'), (8, 'jmoreau', 'pass8', 'enseignant'),
(9, 'asimon', 'pass9', 'enseignant'), (10, 'elaurent', 'pass10', 'enseignant'),
(11, 'nlefevre', 'pass11', 'enseignant'), (12, 'lmichel', 'pass12', 'enseignant'),
(13, 'tgarcia', 'pass13', 'enseignant'), (14, 'cfournier', 'pass14', 'enseignant'),
(15, 'dmartinez', 'pass15', 'enseignant'), (16, 'lbonnet', 'pass16', 'enseignant'),
(17, 'adupuis', 'pass17', 'enseignant'), (18, 'mblanc', 'pass18', 'enseignant'),
(19, 'jgauthier', 'pass19', 'enseignant'), (20, 'cfaure', 'pass20', 'enseignant'),
-- Étudiants (21-120)
(21, 'lmartin', 'pass21', 'etudiant'), (22, 'ebernard', 'pass22', 'etudiant'),
(23, 'lpetit', 'pass23', 'etudiant'), (24, 'crobert', 'pass24', 'etudiant'),
(25, 'grichard', 'pass25', 'etudiant'), (26, 'ldurand', 'pass26', 'etudiant'),
(27, 'amoreau', 'pass27', 'etudiant'), (28, 'msimon', 'pass28', 'etudiant'),
(29, 'nlaurent', 'pass29', 'etudiant'), (30, 'llefevre', 'pass30', 'etudiant'),
(31, 'egarcia', 'pass31', 'etudiant'), (32, 'jmapiti', 'pass32', 'etudiant'),
(33, 'tmartinez', 'pass33', 'etudiant'), (34, 'jbonnet', 'pass34', 'etudiant'),
(35, 'adupuis', 'pass35', 'etudiant'), (36, 'cblanc', 'pass36', 'etudiant'),
(37, 'mgauthier', 'pass37', 'etudiant'), (38, 'sfaure', 'pass38', 'etudiant'),
(39, 'ndubois', 'pass39', 'etudiant'), (40, 'erobin', 'pass40', 'etudiant'),
(41, 'hmorel', 'pass41', 'etudiant'), (42, 'ihenry', 'pass42', 'etudiant'),
(43, 'groux', 'pass43', 'etudiant'), (44, 'lnicolas', 'pass44', 'etudiant'),
(45, 'lperrin', 'pass45', 'etudiant'), (46, 'aleclerc', 'pass46', 'etudiant'),
(47, 'lfayard', 'pass47', 'etudiant'), (48, 'clopez', 'pass48', 'etudiant'),
(49, 'agermain', 'pass49', 'etudiant'), (50, 'ebaron', 'pass50', 'etudiant'),
(51, 'nguillaume', 'pass51', 'etudiant'), (52, 'lfabre', 'pass52', 'etudiant'),
(53, 'eolivier', 'pass53', 'etudiant'), (54, 'arenaud', 'pass54', 'etudiant'),
(55, 'lad', 'pass55', 'etudiant'), (56, 'jmarchand', 'pass56', 'etudiant'),
(57, 'psounouvou', 'pass57', 'etudiant'), (58, 'mcharroin', 'pass58', 'etudiant'),
(59, 'mriviere', 'pass59', 'etudiant'), (60, 'scolin', 'pass60', 'etudiant'),
(61, 'nmasson', 'pass61', 'etudiant'), (62, 'ehenry', 'pass62', 'etudiant'),
(63, 'hmarchal', 'pass63', 'etudiant'), (64, 'irousseau', 'pass64', 'etudiant'),
(65, 'ggiraud', 'pass65', 'etudiant'), (66, 'lmartine', 'pass66', 'etudiant'),
(67, 'llemoine', 'pass67', 'etudiant'), (68, 'cdupuis', 'pass68', 'etudiant'),
(69, 'acharpenti', 'pass69', 'etudiant'), (70, 'lroussel', 'pass70', 'etudiant'),
(71, 'tvasseur', 'pass71', 'etudiant'), (72, 'mdumont', 'pass72', 'etudiant'),
(73, 'jleroy', 'pass73', 'etudiant'), (74, 'smoreau', 'pass74', 'etudiant'),
(75, 'nfournier', 'pass75', 'etudiant'), (76, 'cgirard', 'pass76', 'etudiant'),
(77, 'lbonnet', 'pass77', 'etudiant'), (78, 'lrousseau', 'pass78', 'etudiant'),
(79, 'hblanc', 'pass79', 'etudiant'), (80, 'mgarnier', 'pass80', 'etudiant'),
(81, 'afaure', 'pass81', 'etudiant'), (82, 'kboucher', 'pass82', 'etudiant'),
(83, 'rmercier', 'pass83', 'etudiant'), (84, 'ablanchard', 'pass84', 'etudiant'),
(85, 'pguerin', 'pass85', 'etudiant'), (86, 'efontaine', 'pass86', 'etudiant'),
(87, 'vchevalier', 'pass87', 'etudiant'), (88, 'oboyer', 'pass88', 'etudiant'),
(89, 'alegrand', 'pass89', 'etudiant'), (90, 'jbrunan', 'pass90', 'etudiant'),
(91, 'tgautier', 'pass91', 'etudiant'), (92, 'mperrin', 'pass92', 'etudiant'),
(93, 'drobin', 'pass93', 'etudiant'), (94, 'eclement', 'pass94', 'etudiant'),
(95, 'fmorin', 'pass95', 'etudiant'), (96, 'snicolas', 'pass96', 'etudiant'),
(97, 'bhenry', 'pass97', 'etudiant'), (98, 'aroussel', 'pass98', 'etudiant'),
(99, 'gmathieu', 'pass99', 'etudiant'), (100, 'lmasson', 'pass100', 'etudiant'),
(101, 'mmarchand', 'pass101', 'etudiant'), (102, 'jduval', 'pass102', 'etudiant'),
(103, 'bdenis', 'pass103', 'etudiant'), (104, 'adumont', 'pass104', 'etudiant'),
(105, 'plefevre', 'pass105', 'etudiant'), (106, 'clamy', 'pass106', 'etudiant'),
(107, 'aroche', 'pass107', 'etudiant'), (108, 'troyer', 'pass108', 'etudiant'),
(109, 'gnoel', 'pass109', 'etudiant'), (110, 'mmeyer', 'pass110', 'etudiant'),
(111, 'llucas', 'pass111', 'etudiant'), (112, 'ecarpentie', 'pass112', 'etudiant'),
(113, 'jmuller', 'pass113', 'etudiant'), (114, 'cjean', 'pass114', 'etudiant'),
(115, 'rvidal', 'pass115', 'etudiant'), (116, 'acollet', 'pass116', 'etudiant'),
(117, 'bprevost', 'pass117', 'etudiant'), (118, 'xhubert', 'pass118', 'etudiant'),
(119, 'mfabre', 'pass119', 'etudiant'), (120, 'adupuy', 'pass120', 'etudiant'),
(121, 'amartin', 'pass121', 'etudiant'), (122, 'jbernard', 'pass122', 'etudiant'), (123, 'lthomas', 'pass123', 'etudiant'),
(124, 'ppetit', 'pass124', 'etudiant'), (125, 'crobert', 'pass125', 'etudiant'), (126, 'mrichard', 'pass126', 'etudiant'),
(127, 'edurand', 'pass127', 'etudiant'), (128, 'ndubois', 'pass128', 'etudiant'), (129, 'smoreau', 'pass129', 'etudiant'),
(130, 'tlaurent', 'pass130', 'etudiant'), (131, 'hsimon', 'pass131', 'etudiant'), (132, 'amichel', 'pass132', 'etudiant'),
(133, 'klefebvre', 'pass133', 'etudiant'), (134, 'yleroy', 'pass134', 'etudiant'), (135, 'froux', 'pass135', 'etudiant'),
(136, 'bdavid', 'pass136', 'etudiant'), (137, 'rbertrand', 'pass137', 'etudiant'), (138, 'vmorel', 'pass138', 'etudiant'),
(139, 'gfournier', 'pass139', 'etudiant'), (140, 'lgirard', 'pass140', 'etudiant'), (141, 'pbonnet', 'pass141', 'etudiant'),
(142, 'mdupont', 'pass142', 'etudiant'), (143, 'slambert', 'pass143', 'etudiant'), (144, 'jfontaine', 'pass144', 'etudiant'),
(145, 'erousseau', 'pass145', 'etudiant'), (146, 'avincent', 'pass146', 'etudiant'), (147, 'cmuller', 'pass147', 'etudiant'),
(148, 'hlefevre', 'pass148', 'etudiant'), (149, 'mfaure', 'pass149', 'etudiant'), (150, 'randre', 'pass150', 'etudiant'),
(151, 'pmercier', 'pass151', 'etudiant'), (152, 'lblanc', 'pass152', 'etudiant'), (153, 'tguerin', 'pass153', 'etudiant'),
(154, 'jboyer', 'pass154', 'etudiant'), (155, 'fgarnier', 'pass155', 'etudiant'), (156, 'cchevalier', 'pass156', 'etudiant'),
(157, 'mfrancois', 'pass157', 'etudiant'), (158, 'slegrand', 'pass158', 'etudiant'), (159, 'dgauthier', 'pass159', 'etudiant'),
(160, 'rgarcia', 'pass160', 'etudiant'), (161, 'aperrin', 'pass161', 'etudiant'), (162, 'mrobin', 'pass162', 'etudiant'),
(163, 'lclement', 'pass163', 'etudiant'), (164, 'bmorin', 'pass164', 'etudiant'), (165, 'jnicolas', 'pass165', 'etudiant'),
(166, 'phenry', 'pass166', 'etudiant'), (167, 'rroussel', 'pass167', 'etudiant'), (168, 'gmathieu', 'pass168', 'etudiant'),
(169, 'cgautier', 'pass169', 'etudiant'), (170, 'lmasson', 'pass170', 'etudiant'), (171, 'pmarchand', 'pass171', 'etudiant'),
(172, 'rduval', 'pass172', 'etudiant'), (173, 'mdenis', 'pass173', 'etudiant'), (174, 'sdumont', 'pass174', 'etudiant'),
(175, 'jmarie', 'pass175', 'etudiant'), (176, 'alemaire', 'pass176', 'etudiant'), (177, 'pnoel', 'pass177', 'etudiant'),
(178, 'hmeyer', 'pass178', 'etudiant'), (179, 'cdufour', 'pass179', 'etudiant'), (180, 'mmeunier', 'pass180', 'etudiant'),
(181, 'lbrun', 'pass181', 'etudiant'), (182, 'vlucas', 'pass182', 'etudiant'), (183, 'gverrier', 'pass183', 'etudiant'),
(184, 'aroche', 'pass184', 'etudiant'), (185, 'rroy', 'pass185', 'etudiant'), (186, 'pphilippe', 'pass186', 'etudiant'),
(187, 'mbeneit', 'pass187', 'etudiant'), (188, 'jetienne', 'pass188', 'etudiant'), (189, 'lrenard', 'pass189', 'etudiant'),
(190, 'fadam', 'pass190', 'etudiant'), (191, 'cboucher', 'pass191', 'etudiant'), (192, 'rpicard', 'pass192', 'etudiant'),
(193, 'mgaillard', 'pass193', 'etudiant'), (194, 'pguillaume', 'pass194', 'etudiant'), (195, 'slacroix', 'pass195', 'etudiant'),
(196, 'jfabre', 'pass196', 'etudiant'), (197, 'mdupuis', 'pass197', 'etudiant'), (198, 'lolivier', 'pass198', 'etudiant'),
(199, 'arenaud', 'pass199', 'etudiant'), (200, 'scolin', 'pass200', 'etudiant'), (201, 'mbourgeois', 'pass201', 'etudiant'),
(202, 'aschmitt', 'pass202', 'etudiant'), (203, 'lroyer', 'pass203', 'etudiant'), (204, 'pklein', 'pass204', 'etudiant'),
(205, 'mevrard', 'pass205', 'etudiant'), (206, 'jmaillard', 'pass206', 'etudiant'), (207, 'fbaron', 'pass207', 'etudiant'),
(208, 'rvidal', 'pass208', 'etudiant'), (209, 'gjoly', 'pass209', 'etudiant'), (210, 'mjean', 'pass210', 'etudiant'),
(211, 'lroger', 'pass211', 'etudiant'), (212, 'pcaron', 'pass212', 'etudiant'), (213, 'slucas', 'pass213', 'etudiant'),
(214, 'mverdier', 'pass214', 'etudiant'), (215, 'gbrunet', 'pass215', 'etudiant'), (216, 'jcordier', 'pass216', 'etudiant'),
(217, 'fmarquis', 'pass217', 'etudiant'), (218, 'lvincent', 'pass218', 'etudiant'), (219, 'pnavarro', 'pass219', 'etudiant'),
(220, 'mferrand', 'pass220', 'etudiant');

-- =========================================
-- 4. ENSEIGNANTS BASE (20)
-- =========================================
INSERT INTO AG_Enseignant (NumEnseignant, NomEnseignant, PrenomEnseignant, DateNaissanceEnseignant, AdresseEnseignant, TelephoneEnseignant, EmailEnseignant, NumUtilisateur) VALUES
(1,'Sangoku','Pierre','1980-05-12','12 Rue A','+33612340001','pierre.sang@mail.com',1),
(2,'Martin','Alice','1975-07-23','23 Rue B','+33612340002','alice.martin@mail.com',2),
(3,'Bernard','Luc','1982-03-14','14 Rue C','+33612340003','luc.bernard@mail.com',3),
(4,'Petit','Claire','1981-11-02','2 Rue D','+33612340004','claire.petit@mail.com',4),
(5,'Robert','Paul','1979-01-22','22 Rue E','+33612340005','paul.robert@mail.com',5),
(6,'Richard','Sophie','1983-09-05','5 Rue F','+33612340006','sophie.richard@mail.com',6),
(7,'Durand','Marc','1978-12-11','11 Rue G','+33612340007','marc.durand@mail.com',7),
(8,'Moreau','Julie','1980-06-18','18 Rue H','+33612340008','julie.moreau@mail.com',8),
(9,'Simon','Antoine','1982-02-28','28 Rue I','+33612340009','antoine.simon@mail.com',9),
(10,'Laurent','Emma','1984-08-30','30 Rue J','+33612340010','emma.laurent@mail.com',10),
(11,'Lefevre','Nicolas','1977-04-10','10 Rue K','+33612340011','nicolas.lefevre@mail.com',11),
(12,'Michel','Laura','1981-05-21','21 Rue L','+33612340012','laura.michel@mail.com',12),
(13,'Garcia','Thomas','1979-09-12','12 Rue M','+33612340013','thomas.garcia@mail.com',13),
(14,'Fournier','Claire','1983-07-17','17 Rue N','+33612340014','claire.fournier@mail.com',14),
(15,'Martinez','David','1980-03-03','3 Rue O','+33612340015','david.martinez@mail.com',15),
(16,'Bonnet','Lucie','1982-10-20','20 Rue P','+33612340016','lucie.bonnet@mail.com',16),
(17,'Dupuis','Alex','1978-08-08','8 Rue Q','+33612340017','alex.dupuis@mail.com',17),
(18,'Blanc','Marie','1981-12-15','15 Rue R','+33612340018','marie.blanc@mail.com',18),
(19,'Gauthier','Julien','1980-01-05','5 Rue S','+33612340019','julien.gauthier@mail.com',19),
(20,'Faure','Charlotte','1983-11-25','25 Rue T','+33612340020','charlotte.faure@mail.com',20);

-- =========================================
-- 5. RESPONSABLE DE FORMATION (ID 1 UNIQUE)
-- =========================================
INSERT INTO AG_EnseignantResponsableFormation (NumEnseignant, DateDebutFormation, DateFinFormation) VALUES
(1, '2020-09-01', '2025-06-30');

-- =========================================
-- 6. ENSEIGNANTS RESPONSABLES (GÉNÉRIQUE)
-- IDs 2 à 16 (Pour pouvoir être Resp Filière, Année, Semestre ou de Groupe)
-- ID 1 n'est PAS ici car il est Resp Formation (table séparée)
-- =========================================
INSERT INTO AG_EnseignantResponsable (NumEnseignant, DateDebutFonction, DateFinFonction) VALUES
(2, '2020-09-01', '2025-06-30'), -- Sera Resp Filière
(3, '2020-09-01', '2025-06-30'), -- Sera Resp Filière
(4, '2020-09-01', '2025-06-30'), -- Sera Resp Année
(5, '2020-09-01', '2025-06-30'), -- Sera Resp Année
(6, '2020-09-01', '2025-06-30'), -- Sera Resp Semestre
(7, '2020-09-01', '2025-06-30'), -- Resp Groupe
(8, '2020-09-01', '2025-06-30'), -- Resp Groupe
(9, '2020-09-01', '2025-06-30'), -- Resp Groupe
(10, '2020-09-01', '2025-06-30'), -- Resp Groupe
(11, '2020-09-01', '2025-06-30'), -- Resp Groupe
(12, '2020-09-01', '2025-06-30'), -- Resp Groupe
(13, '2020-09-01', '2025-06-30'), -- Resp Groupe
(14, '2020-09-01', '2025-06-30'), -- Resp Groupe
(15, '2020-09-01', '2025-06-30'), -- Resp Groupe
(16, '2020-09-01', '2025-06-30'); -- Resp Groupe

-- =========================================
-- 7. RESPONSABLES DE FILIÈRE (ID 2 et 3 UNIQUEMENT)
-- =========================================
INSERT INTO AG_EnseignantResponsableFilière (NumEnseignant, NomFiliere) VALUES
(2, 'BUT-Informatique'),
(3, 'BUT-Chimie');

-- =========================================
-- 8. RESPONSABLES D'ANNÉE (ID 4 et 5 UNIQUEMENT)
-- =========================================
INSERT INTO AG_EnseignantResponsableAnnée (NumEnseignant, NomAnnee) VALUES
(4, 'BUT-1'),
(5, 'BUT-2');

-- =========================================
-- 9. RESPONSABLE DE SEMESTRE (ID 6 UNIQUE)
-- =========================================
INSERT INTO AG_EnseignantResponsableSemestre (NumEnseignant, NomSemestre) VALUES
(6, 'S1');

-- =========================================
-- 10. GROUPES (10)
-- NumEnseignantResponsableAnnee : Doit être 4 ou 5
-- NumEnseignantResponsable (du groupe) : Doit être dans la table AG_EnseignantResponsable (7-16)
-- =========================================
INSERT INTO AG_Groupe (TypeGroupe, CapaciteGroupe, NumEnseignantResponsableAnnee, NumEnseignantResponsable) VALUES
('TD', 25, 4, 7),  -- Groupe géré par ID 7, sous resp année 4
('TD', 25, 4, 8),
('TP', 15, 4, 9),
('TP', 15, 4, 10),
('TD', 25, 5, 11), -- Groupe géré par ID 11, sous resp année 5
('TD', 25, 5, 12),
('TP', 15, 5, 13),
('TP', 15, 5, 14),
('TD', 25, 5, 15),
('TP', 15, 5, 16);

-- =========================================
-- 11. ÉTUDIANTS (50)
-- NumEnseignantResponsableFiliere : Doit être 2 ou 3 uniquement
-- =========================================
INSERT INTO AG_Etudiant 
(NomEtudiant, PrenomEtudiant, DateNaissanceEtudiant, AdresseEtudiant, TelephoneEtudiant, GenreEtudiant, EmailEtudiant, TypeBacEtudiant, ParcoursEtudiant, OptionAnglaisEtudiant, PeriodeRedoublementEtudiant, NumUtilisateur, NumEnseignant, NumEnseignantResponsable, NumEnseignantResponsableFiliere, NumCovoiturage, NumPromotion, NumGroupe)
VALUES
('Martin','Lucas','2002-01-12','1 Rue A','+33610000001','M','lucas.martin@mail.com','General','A',1,'BUT-1',21, 1, 4, 2, 1, 1, 1),
('Bernard','Emma','2002-02-20','2 Rue B','+33610000002','F','emma.bernard@mail.com','Techno','B',0,'BUT-2',22, 1, 5, 3, 2, 2, 2),
('Petit','Léo','2002-03-14','3 Rue C','+33610000003','M','leo.petit@mail.com','General','C',1,'BUT-3',23, 1, 4, 2, 3, 3, 3),
('Robert','Chloé','2002-04-18','4 Rue D','+33610000004','F','chloe.robert@mail.com','Techno','A',0,'BUT-1',24, 1, 4, 3, 4, 1, 4),
('Richard','Gabriel','2002-05-23','5 Rue E','+33610000005','M','gabriel.richard@mail.com','General','B',1,'BUT-2',25, 1, 5, 2, 5, 2, 5),
('Durand','Léna','2002-06-10','6 Rue F','+33610000006','F','lena.durand@mail.com','Techno','C',0,'BUT-3',26, 1, 5, 3, 6, 3, 6),
('Moreau','Arthur','2002-07-05','7 Rue G','+33610000007','M','arthur.moreau@mail.com','General','A',1,'BUT-1',27, 7, 4, 2, 1, 1, 7),
('Simon','Manon','2002-08-12','8 Rue H','+33610000008','F','manon.simon@mail.com','Techno','B',0,'BUT-2',28, 8, 5, 3, 2, 2, 8),
('Laurent','Noah','2002-09-17','9 Rue I','+33610000009','M','noah.laurent@mail.com','General','C',1,'BUT-3',29, 9, 5, 2, 3, 3, 9),
('Lefevre','Lina','2002-10-22','10 Rue J','+33610000010','F','lina.lefevre@mail.com','Techno','A',0,'BUT-1',30, 10, 4, 3, 1, 1, 10),
('Garcia','Ethan','2002-11-01','11 Rue K','+33610000011','M','ethan.garcia@mail.com','General','B',1,'BUT-2',31, 11, 5, 2, 2, 2, 1),
('Mapiti','Janith','2002-12-12','12 Rue L','+33610000012','M','janith.mapiti@mail.com','Techno','C',0,'BUT-3',32, 12, 5, 3, 3, 3, 2),
('Martinez','Tom','2003-01-03','13 Rue M','+33610000013','M','tom.martinez@mail.com','General','A',1,'BUT-1',33, 13, 4, 2, 1, 1, 3),
('Bonnet','Julie','2003-02-15','14 Rue N','+33610000014','F','julie.bonnet@mail.com','Techno','B',0,'BUT-2',34, 14, 5, 3, 2, 2, 4),
('Dupuis','Alex','2003-03-18','15 Rue O','+33610000015','M','alex.dupuis@mail.com','General','C',1,'BUT-3',35, 15, 5, 2, 3, 3, 5),
('Blanc','Camille','2003-04-22','16 Rue P','+33610000016','F','camille.blanc@mail.com','Techno','A',0,'BUT-1',36, 16, 4, 3, 1, 1, 6),
('Gauthier','Maxime','2003-05-30','17 Rue Q','+33610000017','M','maxime.gauthier@mail.com','General','B',1,'BUT-2',37, 17, 5, 2, 2, 2, 7),
('Faure','Sarah','2003-06-05','18 Rue R','+33610000018','F','sarah.faure@mail.com','Techno','C',0,'BUT-3',38, 18, 5, 3, 3, 3, 8),
('Dubois','Nathan','2003-07-12','19 Rue S','+33610000019','M','nathan.dubois@mail.com','General','A',1,'BUT-1',39, 19, 4, 2, 1, 1, 9),
('Robin','Eva','2003-08-20','20 Rue T','+33610000020','F','eva.robin@mail.com','Techno','B',0,'BUT-2',40, 20, 5, 3, 2, 2, 10),
('Morel','Hugo','2003-09-05','21 Rue U','+33610000021','M','hugo.morel@mail.com','General','C',1,'BUT-3',41, 1, 5, 2, 3, 3, 1),
('Henry','Inès','2003-10-12','22 Rue V','+33610000022','F','ines.henry@mail.com','Techno','A',0,'BUT-1',42, 2, 4, 3, 1, 1, 2),
('Roux','Gabriel','2003-11-18','23 Rue W','+33610000023','M','gabriel.roux@mail.com','General','B',1,'BUT-2',43, 3, 5, 2, 2, 2, 3),
('Nicolas','Léa','2003-12-22','24 Rue X','+33610000024','F','lea.nicolas@mail.com','Techno','C',0,'BUT-3',44, 4, 5, 3, 3, 3, 4),
('Perrin','Louis','2004-01-05','25 Rue Y','+33610000025','M','louis.perrin@mail.com','General','A',1,'BUT-1',45, 5, 4, 2, 1, 1, 5),
('Leclerc','Anna','2004-02-11','26 Rue Z','+33610000026','F','anna.leclerc@mail.com','Techno','B',0,'BUT-2',46, 6, 5, 3, 2, 2, 6),
('Fayard','Lucas','2004-03-15','27 Rue AA','+33610000027','M','lucas.fayard@mail.com','General','C',1,'BUT-3',47, 7, 5, 2, 3, 3, 7),
('Lopez','Clara','2004-04-19','28 Rue BB','+33610000028','F','clara.lopez@mail.com','Techno','A',0,'BUT-1',48, 8, 4, 3, 1, 1, 8),
('Germain','Arthur','2004-05-23','29 Rue CC','+33610000029','M','arthur.germain@mail.com','General','B',1,'BUT-2',49, 9, 5, 2, 2, 2, 9),
('Baron','Emma','2004-06-28','30 Rue DD','+33610000030','F','emma.baron@mail.com','Techno','C',0,'BUT-3',50, 10, 5, 3, 3, 3, 10),
('Guillaume','Noah','2004-07-02','31 Rue EE','+33610000031','M','noah.guillaume@mail.com','General','A',1,'BUT-1',51, 11, 4, 2, 1, 1, 1),
('Fabre','Léa','2004-08-12','32 Rue FF','+33610000032','F','lea.fabre@mail.com','Techno','B',0,'BUT-2',52, 12, 5, 3, 2, 2, 2),
('Olivier','Ethan','2004-09-18','33 Rue GG','+33610000033','M','ethan.olivier@mail.com','General','C',1,'BUT-3',53, 13, 5, 2, 3, 3, 3),
('Renaud','Alice','2004-10-22','34 Rue HH','+33610000034','F','alice.renaud@mail.com','Techno','A',0,'BUT-1',54, 14, 4, 3, 1, 1, 4),
('AD','Laurent','2004-11-30','35 Rue II','+33610000035','M','ad.laur@mail.com','General','B',1,'BUT-2',55, 15, 5, 2, 2, 2, 5),
('Marchand','Julie','2004-12-05','36 Rue JJ','+33610000036','F','julie.marchand@mail.com','Techno','C',0,'BUT-3',56, 16, 5, 3, 3, 3, 6),
('Sounouvou','Pierre','2005-01-12','37 Rue KK','+33610000037','M','pierre.soun@mail.com','General','A',1,'BUT-1',57, 17, 4, 2, 1, 1, 7),
('Charroin','Matthieu','2005-02-18','38 Rue LL','+33610000038','M','matthieu.char@mail.com','Techno','B',0,'BUT-2',58, 18, 5, 3, 2, 2, 8),
('Riviere','Maxime','2005-03-22','39 Rue MM','+33610000039','M','maxime.riv@mail.com','General','C',1,'BUT-3',59, 19, 5, 2, 3, 3, 9),
('Colin','Sarah','2005-04-30','40 Rue NN','+33610000040','F','sarah.colin@mail.com','Techno','A',0,'BUT-1',60, 20, 4, 3, 1, 1, 10),
('Masson','Nathan','2005-05-05','41 Rue OO','+33610000041','M','nathan.mass@mail.com','General','B',1,'BUT-2',61, 1, 5, 2, 2, 2, 1),
('Henry','Eva','2005-06-12','42 Rue PP','+33610000042','F','eva.henry@mail.com','Techno','C',0,'BUT-3',62, 2, 5, 3, 3, 3, 2),
('Marchal','Hugo','2005-07-18','43 Rue QQ','+33610000043','M','hugo.marchal@mail.com','General','A',1,'BUT-1',63, 3, 4, 2, 1, 1, 3),
('Rousseau','Inès','2005-08-22','44 Rue RR','+33610000044','F','ines.rousseau@mail.com','Techno','B',0,'BUT-2',64, 4, 5, 3, 2, 2, 4),
('Giraud','Gabriel','2005-09-30','45 Rue SS','+33610000045','M','gabriel.giraud@mail.com','General','C',1,'BUT-3',65, 5, 5, 2, 3, 3, 5),
('Martine','Léa','2005-10-05','46 Rue TT','+33610000046','F','lea.martine@mail.com','Techno','A',0,'BUT-1',66, 6, 4, 3, 1, 1, 6),
('Lemoine','Louis','2005-11-12','47 Rue UU','+33610000047','M','louis.lemoine@mail.com','General','B',1,'BUT-2',67, 7, 5, 2, 2, 2, 7),
('Dupuis','Clément','2005-12-18','48 Rue VV','+33610000048','M','clement.dupuis@mail.com','Techno','C',1,'BUT-2',68, 8, 5, 3, 3, 3, 8),
('Charpentier','Anna','2005-12-25','49 Rue WW','+33610000049','F','anna.charp@mail.com','General','A',0,'BUT-1',69, 9, 4, 2, 1, 1, 9),
('Roussel','Lucas','2006-01-05','50 Rue XX','+33610000050','M','lucas.roussel@mail.com','Techno','B',1,'BUT-2',70, 10, 5, 3, 2, 2, 10),
('Vasseur','Thomas','2002-01-12','1 Rue A','+33610000001','M','thomas.vasseur@mail.com','General','A',1,'BUT-1',71, 1, 4, 2, 7, 1, null),
('Dumont','Marie','2002-02-20','2 Rue B','+33610000002','F','marie.dumont@mail.com','Techno','B',0,'BUT-2',72, 1, 5, 3, 8, 2, null),
('Leroy','Julien','2002-03-14','3 Rue C','+33610000003','M','julien.leroy@mail.com','General','C',1,'BUT-3',73, 1, 4, 2, 9, 3, null),
('Moreau','Sophie','2002-04-18','4 Rue D','+33610000004','F','sophie.moreau@mail.com','Techno','A',0,'BUT-1',74, 1, 4, 3, 10, 1, null),
('Fournier','Nicolas','2002-05-23','5 Rue E','+33610000005','M','nicolas.fournier@mail.com','General','B',1,'BUT-2',75, 1, 5, 2, 11, 2, null),
('Girard','Camille','2002-06-10','6 Rue F','+33610000006','F','camille.girard@mail.com','Techno','C',0,'BUT-3',76, 1, 5, 3, 12, 3, null),
('Bonnet','Lucas','2002-07-05','7 Rue G','+33610000007','M','lucas.bonnet@mail.com','General','A',1,'BUT-1',77, 7, 4, 2, 7, 1, null),
('Rousseau','Léa','2002-08-12','8 Rue H','+33610000008','F','lea.rousseau@mail.com','Techno','B',0,'BUT-2',78, 8, 5, 3, 8, 2, null),
('Blanc','Hugo','2002-09-17','9 Rue I','+33610000009','M','hugo.blanc@mail.com','General','C',1,'BUT-3',79, 9, 5, 2, 9, 3, null),
('Garnier','Manon','2002-10-22','10 Rue J','+33610000010','F','manon.garnier@mail.com','Techno','A',0,'BUT-1',80, 10, 4, 3, 10, 1, null),
('Faure','Alexandre','2002-11-01','11 Rue K','+33610000011','M','alexandre.faure@mail.com','General','B',1,'BUT-2',81, 11, 5, 2, 11, 2, null),
('Boucher','Kevin','2002-12-12','12 Rue L','+33610000012','M','kevin.boucher@mail.com','Techno','C',0,'BUT-3',82, 12, 5, 3, 12, 3, null),
('Mercier','Romain','2003-01-03','13 Rue M','+33610000013','M','romain.mercier@mail.com','General','A',1,'BUT-1',83, 13, 4, 2, 7, 1, null),
('Blanchard','Audrey','2003-02-15','14 Rue N','+33610000014','F','audrey.blanchard@mail.com','Techno','B',0,'BUT-2',84, 14, 5, 3, 8, 2, null),
('Guerin','Pierre','2003-03-18','15 Rue O','+33610000015','M','pierre.guerin@mail.com','General','C',1,'BUT-3',85, 15, 5, 2, 9, 3, null),
('Fontaine','Elise','2003-04-22','16 Rue P','+33610000016','F','elise.fontaine@mail.com','Techno','A',0,'BUT-1',86, 16, 4, 3, 10, 1, null),
('Chevalier','Victor','2003-05-30','17 Rue Q','+33610000017','M','victor.chevalier@mail.com','General','B',1,'BUT-2',87, 17, 5, 2, 11, 2, null),
('Boyer','Océane','2003-06-05','18 Rue R','+33610000018','F','oceane.boyer@mail.com','Techno','C',0,'BUT-3',88, 18, 5, 3, 12, 3, null),
('Legrand','Antoine','2003-07-12','19 Rue S','+33610000019','M','antoine.legrand@mail.com','General','A',1,'BUT-1',89, 19, 4, 2, 7, 1, null),
('Brunan','Julie','2003-08-20','20 Rue T','+33610000020','F','julie.brunan@mail.com','Techno','B',0,'BUT-2',90, 20, 5, 3, 8, 2, null),
('Gautier','Théo','2003-09-05','21 Rue U','+33610000021','M','theo.gautier@mail.com','General','C',1,'BUT-3',91, 1, 5, 2, 9, 3, null),
('Perrin','Marion','2003-10-12','22 Rue V','+33610000022','F','marion.perrin@mail.com','Techno','A',0,'BUT-1',92, 2, 4, 3, 10, 1, null),
('Robin','Damien','2003-11-18','23 Rue W','+33610000023','M','damien.robin@mail.com','General','B',1,'BUT-2',93, 3, 5, 2, 11, 2, null),
('Clement','Emma','2003-12-22','24 Rue X','+33610000024','F','emma.clement@mail.com','Techno','C',0,'BUT-3',94, 4, 5, 3, 12, 3, null),
('Morin','Florian','2004-01-05','25 Rue Y','+33610000025','M','florian.morin@mail.com','General','A',1,'BUT-1',95, 5, 4, 2, 7, 1, null),
('Nicolas','Sarah','2004-02-11','26 Rue Z','+33610000026','F','sarah.nicolas@mail.com','Techno','B',0,'BUT-2',96, 6, 5, 3, 8, 2, null),
('Henry','Baptiste','2004-03-15','27 Rue AA','+33610000027','M','baptiste.henry@mail.com','General','C',1,'BUT-3',97, 7, 5, 2, 9, 3, null),
('Roussel','Alice','2004-04-19','28 Rue BB','+33610000028','F','alice.roussel@mail.com','Techno','A',0,'BUT-1',98, 8, 4, 3, 10, 1, null),
('Mathieu','Guillaume','2004-05-23','29 Rue CC','+33610000029','M','guillaume.mathieu@mail.com','General','B',1,'BUT-2',99, 9, 5, 2, 11, 2, null),
('Masson','Laura','2004-06-28','30 Rue DD','+33610000030','F','laura.masson@mail.com','Techno','C',0,'BUT-3',100, 10, 5, 3, 12, 3, null),
('Marchand','Maxime','2004-07-02','31 Rue EE','+33610000031','M','maxime.marchand@mail.com','General','A',1,'BUT-1',101, 11, 4, 2, 7, 1, null),
('Duval','Juliette','2004-08-12','32 Rue FF','+33610000032','F','juliette.duval@mail.com','Techno','B',0,'BUT-2',102, 12, 5, 3, 8, 2, null),
('Denis','Benjamin','2004-09-18','33 Rue GG','+33610000033','M','benjamin.denis@mail.com','General','C',1,'BUT-3',103, 13, 5, 2, 9, 3, null),
('Dumont','Anaïs','2004-10-22','34 Rue HH','+33610000034','F','anais.dumont@mail.com','Techno','A',0,'BUT-1',104, 14, 4, 3, 10, 1, null),
('Lefevre','Paul','2004-11-30','35 Rue II','+33610000035','M','paul.lefevre@mail.com','General','B',1,'BUT-2',105, 15, 5, 2, 11, 2, null),
('Lamy','Chloé','2004-12-05','36 Rue JJ','+33610000036','F','chloe.lamy@mail.com','Techno','C',0,'BUT-3',106, 16, 5, 3, 12, 3, null),
('Roche','Adrien','2005-01-12','37 Rue KK','+33610000037','M','adrien.roche@mail.com','General','A',1,'BUT-1',107, 17, 4, 2, 7, 1, null),
('Royer','Thomas','2005-02-18','38 Rue LL','+33610000038','M','thomas.royer@mail.com','Techno','B',0,'BUT-2',108, 18, 5, 3, 8, 2, null),
('Noel','Grégoire','2005-03-22','39 Rue MM','+33610000039','M','gregoire.noel@mail.com','General','C',1,'BUT-3',109, 19, 5, 2, 9, 3, null),
('Meyer','Mélanie','2005-04-30','40 Rue NN','+33610000040','F','melanie.meyer@mail.com','Techno','A',0,'BUT-1',110, 20, 4, 3, 10, 1, null),
('Lucas','Léo','2005-05-05','41 Rue OO','+33610000041','M','leo.lucas@mail.com','General','B',1,'BUT-2',111, 1, 5, 2, 11, 2, null),
('Carpentier','Elodie','2005-06-12','42 Rue PP','+33610000042','F','elodie.carpentier@mail.com','Techno','C',0,'BUT-3',112, 2, 5, 3, 12, 3, null),
('Muller','Jean','2005-07-18','43 Rue QQ','+33610000043','M','jean.muller@mail.com','General','A',1,'BUT-1',113, 3, 4, 2, 7, 1, null),
('Jean','Clara','2005-08-22','44 Rue RR','+33610000044','F','clara.jean@mail.com','Techno','B',0,'BUT-2',114, 4, 5, 3, 8, 2, null),
('Vidal','Raphaël','2005-09-30','45 Rue SS','+33610000045','M','raphael.vidal@mail.com','General','C',1,'BUT-3',115, 5, 5, 2, 9, 3, null),
('Collet','Amandine','2005-10-05','46 Rue TT','+33610000046','F','amandine.collet@mail.com','Techno','A',0,'BUT-1',116, 6, 4, 3, 10, 1, null),
('Prevost','Bastien','2005-11-12','47 Rue UU','+33610000047','M','bastien.prevost@mail.com','General','B',1,'BUT-2',117, 7, 5, 2, 11, 2, null),
('Hubert','Xavier','2005-12-18','48 Rue VV','+33610000048','M','xavier.hubert@mail.com','Techno','C',1,'BUT-2',118, 8, 5, 3, 12, 3, null),
('Fabre','Morgane','2005-12-25','49 Rue WW','+33610000049','F','morgane.fabre@mail.com','General','A',0,'BUT-1',119, 9, 4, 2, 7, 1, null),
('Dupuy','Arthur','2006-01-05','50 Rue XX','+33610000050','M','arthur.dupuy@mail.com','Techno','B',1,'BUT-2',120, 10, 5, 3, 8, 2, null),
('Martin', 'Alice', '2004-01-10', '121 Rue Alpha', '+33600000121', 'F', 'alice.martin@mail.com', 'General', 'A', 1, 'BUT-1', 121, 1, 4, 2, NULL, 1, NULL),
('Bernard', 'Jean', '2004-02-15', '122 Rue Beta', '+33600000122', 'M', 'jean.bernard@mail.com', 'Techno', 'B', 0, 'BUT-1', 122, 1, 5, 3, NULL, 1, NULL),
('Thomas', 'Léa', '2004-03-20', '123 Rue Gamma', '+33600000123', 'F', 'lea.thomas@mail.com', 'General', 'C', 1, 'BUT-1', 123, 1, 4, 2, NULL, 1, NULL),
('Petit', 'Pierre', '2004-04-25', '124 Rue Delta', '+33600000124', 'M', 'pierre.petit@mail.com', 'Techno', 'A', 0, 'BUT-1', 124, 1, 4, 3, NULL, 1, NULL),
('Robert', 'Chloé', '2004-05-30', '125 Rue Epsilon', '+33600000125', 'F', 'chloe.robert@mail.com', 'General', 'B', 1, 'BUT-1', 125, 1, 5, 2, NULL, 1, NULL),
('Richard', 'Marc', '2004-06-05', '126 Rue Zeta', '+33600000126', 'M', 'marc.richard@mail.com', 'Techno', 'C', 0, 'BUT-1', 126, 1, 5, 3, NULL, 1, NULL),
('Durand', 'Emma', '2004-07-10', '127 Rue Eta', '+33600000127', 'F', 'emma.durand@mail.com', 'General', 'A', 1, 'BUT-1', 127, 2, 4, 2, NULL, 1, NULL),
('Dubois', 'Noah', '2004-08-15', '128 Rue Theta', '+33600000128', 'M', 'noah.dubois@mail.com', 'Techno', 'B', 0, 'BUT-1', 128, 2, 5, 3, NULL, 1, NULL),
('Moreau', 'Sarah', '2004-09-20', '129 Rue Iota', '+33600000129', 'F', 'sarah.moreau@mail.com', 'General', 'C', 1, 'BUT-1', 129, 2, 4, 2, NULL, 1, NULL),
('Laurent', 'Théo', '2004-10-25', '130 Rue Kappa', '+33600000130', 'M', 'theo.laurent@mail.com', 'Techno', 'A', 0, 'BUT-1', 130, 2, 4, 3, NULL, 1, NULL),
('Simon', 'Hugo', '2004-11-30', '131 Rue Lambda', '+33600000131', 'M', 'hugo.simon@mail.com', 'General', 'B', 1, 'BUT-1', 131, 3, 5, 2, NULL, 1, NULL),
('Michel', 'Ambre', '2004-12-05', '132 Rue Mu', '+33600000132', 'F', 'ambre.michel@mail.com', 'Techno', 'C', 0, 'BUT-1', 132, 3, 5, 3, NULL, 1, NULL),
('Lefebvre', 'Kylian', '2005-01-10', '133 Rue Nu', '+33600000133', 'M', 'kylian.lefebvre@mail.com', 'General', 'A', 1, 'BUT-1', 133, 3, 4, 2, NULL, 1, NULL),
('Leroy', 'Yanis', '2005-02-15', '134 Rue Xi', '+33600000134', 'M', 'yanis.leroy@mail.com', 'Techno', 'B', 0, 'BUT-1', 134, 4, 5, 3, NULL, 1, NULL),
('Roux', 'Flora', '2005-03-20', '135 Rue Omicron', '+33600000135', 'F', 'flora.roux@mail.com', 'General', 'C', 1, 'BUT-1', 135, 4, 5, 2, NULL, 1, NULL),
('David', 'Bastien', '2005-04-25', '136 Rue Pi', '+33600000136', 'M', 'bastien.david@mail.com', 'Techno', 'A', 0, 'BUT-1', 136, 4, 4, 3, NULL, 1, NULL),
('Bertrand', 'Rose', '2005-05-30', '137 Rue Rho', '+33600000137', 'F', 'rose.bertrand@mail.com', 'General', 'B', 1, 'BUT-1', 137, 5, 5, 2, NULL, 1, NULL),
('Morel', 'Valentin', '2005-06-05', '138 Rue Sigma', '+33600000138', 'M', 'valentin.morel@mail.com', 'Techno', 'C', 0, 'BUT-1', 138, 5, 5, 3, NULL, 1, NULL),
('Fournier', 'Gabin', '2005-07-10', '139 Rue Tau', '+33600000139', 'M', 'gabin.fournier@mail.com', 'General', 'A', 1, 'BUT-1', 139, 5, 4, 2, NULL, 1, NULL),
('Girard', 'Louna', '2005-08-15', '140 Rue Upsilon', '+33600000140', 'F', 'louna.girard@mail.com', 'Techno', 'B', 0, 'BUT-1', 140, 6, 5, 3, NULL, 1, NULL),
('Bonnet', 'Paul', '2005-09-20', '141 Rue Phi', '+33600000141', 'M', 'paul.bonnet@mail.com', 'General', 'C', 1, 'BUT-2', 141, 6, 5, 2, NULL, 2, NULL),
('Dupont', 'Mila', '2005-10-25', '142 Rue Chi', '+33600000142', 'F', 'mila.dupont@mail.com', 'Techno', 'A', 0, 'BUT-2', 142, 6, 4, 3, NULL, 2, NULL),
('Lambert', 'Sacha', '2005-11-30', '143 Rue Psi', '+33600000143', 'M', 'sacha.lambert@mail.com', 'General', 'B', 1, 'BUT-2', 143, 7, 5, 2, NULL, 2, NULL),
('Fontaine', 'Jade', '2005-12-05', '144 Rue Omega', '+33600000144', 'F', 'jade.fontaine@mail.com', 'Techno', 'C', 0, 'BUT-2', 144, 7, 5, 3, NULL, 2, NULL),
('Rousseau', 'Enzo', '2004-01-12', '145 Rue de Lyon', '+33600000145', 'M', 'enzo.rousseau@mail.com', 'General', 'A', 1, 'BUT-2', 145, 7, 4, 2, NULL, 2, NULL),
('Vincent', 'Arthur', '2004-02-18', '146 Rue de Lyon', '+33600000146', 'M', 'arthur.vincent@mail.com', 'Techno', 'B', 0, 'BUT-2', 146, 8, 5, 3, NULL, 2, NULL),
('Muller', 'Clara', '2004-03-22', '147 Rue de Lyon', '+33600000147', 'F', 'clara.muller@mail.com', 'General', 'C', 1, 'BUT-2', 147, 8, 5, 2, NULL, 2, NULL),
('Lefevre', 'Hugo', '2004-04-30', '148 Rue de Lyon', '+33600000148', 'M', 'hugo.lefevre@mail.com', 'Techno', 'A', 0, 'BUT-2', 148, 8, 4, 3, NULL, 2, NULL),
('Faure', 'Mathilde', '2004-05-05', '149 Rue de Lyon', '+33600000149', 'F', 'mathilde.faure@mail.com', 'General', 'B', 1, 'BUT-2', 149, 9, 5, 2, NULL, 2, NULL),
('Andre', 'Raphaël', '2004-06-12', '150 Rue de Lyon', '+33600000150', 'M', 'raphael.andre@mail.com', 'Techno', 'C', 0, 'BUT-2', 150, 9, 5, 3, NULL, 2, NULL),
('Mercier', 'Peio', '2004-07-18', '151 Rue de Lille', '+33600000151', 'M', 'peio.mercier@mail.com', 'General', 'A', 1, 'BUT-2', 151, 9, 4, 2, NULL, 2, NULL),
('Blanc', 'Lina', '2004-08-22', '152 Rue de Lille', '+33600000152', 'F', 'lina.blanc@mail.com', 'Techno', 'B', 0, 'BUT-2', 152, 10, 5, 3, NULL, 2, NULL),
('Guerin', 'Tom', '2004-09-30', '153 Rue de Lille', '+33600000153', 'M', 'tom.guerin@mail.com', 'General', 'C', 1, 'BUT-2', 153, 10, 5, 2, NULL, 2, NULL),
('Boyer', 'Julia', '2004-10-05', '154 Rue de Lille', '+33600000154', 'F', 'julia.boyer@mail.com', 'Techno', 'A', 0, 'BUT-2', 154, 10, 4, 3, NULL, 2, NULL),
('Garnier', 'Fanny', '2004-11-12', '155 Rue de Lille', '+33600000155', 'F', 'fanny.garnier@mail.com', 'General', 'B', 1, 'BUT-2', 155, 11, 5, 2, NULL, 2, NULL),
('Chevalier', 'Cédric', '2004-12-18', '156 Rue de Lille', '+33600000156', 'M', 'cedric.chevalier@mail.com', 'Techno', 'C', 0, 'BUT-2', 156, 11, 5, 3, NULL, 2, NULL),
('Francois', 'Maxime', '2005-01-25', '157 Rue de Brest', '+33600000157', 'M', 'maxime.francois@mail.com', 'General', 'A', 1, 'BUT-2', 157, 11, 4, 2, NULL, 2, NULL),
('Legrand', 'Sonia', '2005-02-05', '158 Rue de Brest', '+33600000158', 'F', 'sonia.legrand@mail.com', 'Techno', 'B', 0, 'BUT-2', 158, 12, 5, 3, NULL, 2, NULL),
('Gauthier', 'Dorian', '2005-03-12', '159 Rue de Brest', '+33600000159', 'M', 'dorian.gauthier@mail.com', 'General', 'C', 1, 'BUT-2', 159, 12, 5, 2, NULL, 2, NULL),
('Garcia', 'Ruben', '2005-04-18', '160 Rue de Brest', '+33600000160', 'M', 'ruben.garcia@mail.com', 'Techno', 'A', 0, 'BUT-2', 160, 12, 4, 3, NULL, 2, NULL),
('Perrin', 'Alix', '2005-05-22', '161 Rue de Nantes', '+33600000161', 'F', 'alix.perrin@mail.com', 'General', 'B', 1, 'BUT-2', 161, 13, 5, 2, NULL, 2, NULL),
('Robin', 'Maël', '2005-06-30', '162 Rue de Nantes', '+33600000162', 'M', 'mael.robin@mail.com', 'Techno', 'C', 0, 'BUT-2', 162, 13, 5, 3, NULL, 2, NULL),
('Clement', 'Lise', '2005-07-05', '163 Rue de Nantes', '+33600000163', 'F', 'lise.clement@mail.com', 'General', 'A', 1, 'BUT-3', 163, 13, 4, 2, NULL, 3, NULL),
('Morin', 'Basile', '2005-08-12', '164 Rue de Nantes', '+33600000164', 'M', 'basile.morin@mail.com', 'Techno', 'B', 0, 'BUT-3', 164, 14, 5, 3, NULL, 3, NULL),
('Nicolas', 'Julie', '2005-09-18', '165 Rue de Nantes', '+33600000165', 'F', 'julie.nicolas@mail.com', 'General', 'C', 1, 'BUT-3', 165, 14, 5, 2, NULL, 3, NULL),
('Henry', 'Pauline', '2005-10-22', '166 Rue de Nantes', '+33600000166', 'F', 'pauline.henry@mail.com', 'Techno', 'A', 0, 'BUT-3', 166, 14, 4, 3, NULL, 3, NULL),
('Roussel', 'Rémi', '2005-11-30', '167 Rue de Rennes', '+33600000167', 'M', 'remi.roussel@mail.com', 'General', 'B', 1, 'BUT-3', 167, 15, 5, 2, NULL, 3, NULL),
('Mathieu', 'Gaël', '2005-12-05', '168 Rue de Rennes', '+33600000168', 'M', 'gael.mathieu@mail.com', 'Techno', 'C', 0, 'BUT-3', 168, 15, 5, 3, NULL, 3, NULL),
('Gautier', 'Célia', '2004-01-20', '169 Rue de Rennes', '+33600000169', 'F', 'celia.gautier@mail.com', 'General', 'A', 1, 'BUT-3', 169, 15, 4, 2, NULL, 3, NULL),
('Masson', 'Loïc', '2004-02-25', '170 Rue de Rennes', '+33600000170', 'M', 'loic.masson@mail.com', 'Techno', 'B', 0, 'BUT-3', 170, 16, 5, 3, NULL, 3, NULL),
('Marchand', 'Pierre', '2004-03-30', '171 Rue de Rennes', '+33600000171', 'M', 'pierre.marchand@mail.com', 'General', 'C', 1, 'BUT-3', 171, 16, 5, 2, NULL, 3, NULL),
('Duval', 'Romane', '2004-04-05', '172 Rue de Caen', '+33600000172', 'F', 'romane.duval@mail.com', 'Techno', 'A', 0, 'BUT-3', 172, 16, 4, 3, NULL, 3, NULL),
('Denis', 'Marius', '2004-05-10', '173 Rue de Caen', '+33600000173', 'M', 'marius.denis@mail.com', 'General', 'B', 1, 'BUT-3', 173, 17, 5, 2, NULL, 3, NULL),
('Dumont', 'Solène', '2004-06-15', '174 Rue de Caen', '+33600000174', 'F', 'solene.dumont@mail.com', 'Techno', 'C', 0, 'BUT-3', 174, 17, 5, 3, NULL, 3, NULL),
('Marie', 'Jules', '2004-07-20', '175 Rue de Caen', '+33600000175', 'M', 'jules.marie@mail.com', 'General', 'A', 1, 'BUT-3', 175, 17, 4, 2, NULL, 3, NULL),
('Lemaire', 'Alice', '2004-08-25', '176 Rue de Caen', '+33600000176', 'F', 'alice.lemaire@mail.com', 'Techno', 'B', 0, 'BUT-3', 176, 18, 5, 3, NULL, 3, NULL),
('Noel', 'Patrice', '2004-09-30', '177 Rue de Toulon', '+33600000177', 'M', 'patrice.noel@mail.com', 'General', 'C', 1, 'BUT-3', 177, 18, 5, 2, NULL, 3, NULL),
('Meyer', 'Héloïse', '2004-10-05', '178 Rue de Toulon', '+33600000178', 'F', 'heloise.meyer@mail.com', 'Techno', 'A', 0, 'BUT-3', 178, 18, 4, 3, NULL, 3, NULL),
('Dufour', 'Cyril', '2004-11-12', '179 Rue de Toulon', '+33600000179', 'M', 'cyril.dufour@mail.com', 'General', 'B', 1, 'BUT-3', 179, 19, 5, 2, NULL, 3, NULL),
('Meunier', 'Maëlys', '2004-12-18', '180 Rue de Toulon', '+33600000180', 'F', 'maelys.meunier@mail.com', 'Techno', 'C', 0, 'BUT-3', 180, 19, 5, 3, NULL, 3, NULL),
('Brun', 'Lucas', '2005-01-25', '181 Rue de Toulon', '+33600000181', 'M', 'lucas.brun@mail.com', 'General', 'A', 1, 'BUT-1', 181, 19, 4, 2, NULL, 1, NULL),
('Lucas', 'Victor', '2005-02-05', '182 Rue de Nice', '+33600000182', 'M', 'victor.lucas@mail.com', 'Techno', 'B', 0, 'BUT-1', 182, 20, 5, 3, NULL, 1, NULL),
('Verrier', 'Garance', '2005-03-12', '183 Rue de Nice', '+33600000183', 'F', 'garance.verrier@mail.com', 'General', 'C', 1, 'BUT-1', 183, 20, 5, 2, NULL, 1, NULL),
('Roche', 'Adrien', '2005-04-18', '184 Rue de Nice', '+33600000184', 'M', 'adrien.roche@mail.com', 'Techno', 'A', 0, 'BUT-1', 184, 20, 4, 3, NULL, 1, NULL),
('Roy', 'Rémi', '2005-05-22', '185 Rue de Nice', '+33600000185', 'M', 'remi.roy@mail.com', 'General', 'B', 1, 'BUT-1', 185, 1, 5, 2, NULL, 1, NULL),
('Philippe', 'Pascal', '2005-06-30', '186 Rue de Nice', '+33600000186', 'M', 'pascal.philippe@mail.com', 'Techno', 'C', 0, 'BUT-1', 186, 1, 5, 3, NULL, 1, NULL),
('Beneit', 'Marie', '2005-07-05', '187 Rue d\'Angers', '+33600000187', 'F', 'marie.beneit@mail.com', 'General', 'A', 1, 'BUT-1', 187, 1, 4, 2, NULL, 1, NULL),
('Etienne', 'Julien', '2005-08-12', '188 Rue d\'Angers', '+33600000188', 'M', 'julien.etienne@mail.com', 'Techno', 'B', 0, 'BUT-1', 188, 2, 5, 3, NULL, 1, NULL),
('Renard', 'Léa', '2005-09-18', '189 Rue d\'Angers', '+33600000189', 'F', 'lea.renard@mail.com', 'General', 'C', 1, 'BUT-1', 189, 2, 5, 2, NULL, 1, NULL),
('Adam', 'Florian', '2005-10-22', '190 Rue d\'Angers', '+33600000190', 'M', 'florian.adam@mail.com', 'Techno', 'A', 0, 'BUT-1', 190, 2, 4, 3, NULL, 1, NULL),
('Boucher', 'Céline', '2005-11-30', '191 Rue d\'Angers', '+33600000191', 'F', 'celine.boucher@mail.com', 'General', 'B', 1, 'BUT-1', 191, 3, 5, 2, NULL, 1, NULL),
('Picard', 'Robin', '2005-12-05', '192 Rue de Reims', '+33600000192', 'M', 'robin.picard@mail.com', 'Techno', 'C', 0, 'BUT-1', 192, 3, 5, 3, NULL, 1, NULL),
('Gaillard', 'Manon', '2004-01-20', '193 Rue de Reims', '+33600000193', 'F', 'manon.gaillard@mail.com', 'General', 'A', 1, 'BUT-1', 193, 3, 4, 2, NULL, 1, NULL),
('Guillaume', 'Paul', '2004-02-25', '194 Rue de Reims', '+33600000194', 'M', 'paul.guillaume@mail.com', 'Techno', 'B', 0, 'BUT-1', 194, 4, 5, 3, NULL, 1, NULL),
('Lacroix', 'Sonia', '2004-03-30', '195 Rue de Reims', '+33600000195', 'F', 'sonia.lacroix@mail.com', 'General', 'C', 1, 'BUT-1', 195, 4, 5, 2, NULL, 1, NULL),
('Fabre', 'Julie', '2004-04-05', '196 Rue de Reims', '+33600000196', 'F', 'julie.fabre@mail.com', 'Techno', 'A', 0, 'BUT-1', 196, 4, 4, 3, NULL, 1, NULL),
('Dupuis', 'Mathéo', '2004-05-10', '197 Rue de Dijon', '+33600000197', 'M', 'matheo.dupuis@mail.com', 'General', 'B', 1, 'BUT-1', 197, 5, 5, 2, NULL, 1, NULL),
('Olivier', 'Léo', '2004-06-15', '198 Rue de Dijon', '+33600000198', 'M', 'leo.olivier@mail.com', 'Techno', 'C', 0, 'BUT-1', 198, 5, 5, 3, NULL, 1, NULL),
('Renaud', 'Alice', '2004-07-20', '199 Rue de Dijon', '+33600000199', 'F', 'alice.renaud@mail.com', 'General', 'A', 1, 'BUT-1', 199, 5, 4, 2, NULL, 1, NULL),
('Colin', 'Sacha', '2004-08-25', '200 Rue de Dijon', '+33600000200', 'M', 'sacha.colin@mail.com', 'Techno', 'B', 0, 'BUT-1', 200, 6, 5, 3, NULL, 1, NULL),
('Bourgeois', 'Maxence', '2004-09-30', '201 Rue de Dijon', '+33600000201', 'M', 'maxence.bourgeois@mail.com', 'General', 'C', 1, 'BUT-2', 201, 6, 5, 2, NULL, 2, NULL),
('Schmitt', 'Anaïs', '2004-10-05', '202 Rue de Nîmes', '+33600000202', 'F', 'anais.schmitt@mail.com', 'Techno', 'A', 0, 'BUT-2', 202, 6, 4, 3, NULL, 2, NULL),
('Royer', 'Léo', '2004-11-12', '203 Rue de Nîmes', '+33600000203', 'M', 'leo.royer@mail.com', 'General', 'B', 1, 'BUT-2', 203, 7, 5, 2, NULL, 2, NULL),
('Klein', 'Pierre', '2004-12-18', '204 Rue de Nîmes', '+33600000204', 'M', 'pierre.klein@mail.com', 'Techno', 'C', 0, 'BUT-2', 204, 7, 5, 3, NULL, 2, NULL),
('Evrard', 'Mélanie', '2005-01-25', '205 Rue de Nîmes', '+33600000205', 'F', 'melanie.evrard@mail.com', 'General', 'A', 1, 'BUT-2', 205, 7, 4, 2, NULL, 2, NULL),
('Maillard', 'Jérôme', '2005-02-05', '206 Rue de Nîmes', '+33600000206', 'M', 'jerome.maillard@mail.com', 'Techno', 'B', 0, 'BUT-2', 206, 8, 5, 3, NULL, 2, NULL),
('Baron', 'Florian', '2005-03-12', '207 Rue de Tours', '+33600000207', 'M', 'florian.baron@mail.com', 'General', 'C', 1, 'BUT-2', 207, 8, 5, 2, NULL, 2, NULL),
('Vidal', 'Raphaël', '2005-04-18', '208 Rue de Tours', '+33600000208', 'M', 'raphael.vidal@mail.com', 'Techno', 'A', 0, 'BUT-2', 208, 8, 4, 3, NULL, 2, NULL),
('Joly', 'Guillaume', '2005-05-22', '209 Rue de Tours', '+33600000209', 'M', 'guillaume.joly@mail.com', 'General', 'B', 1, 'BUT-2', 209, 9, 5, 2, NULL, 2, NULL),
('Jean', 'Mathilde', '2005-06-30', '210 Rue de Tours', '+33600000210', 'F', 'mathilde.jean@mail.com', 'Techno', 'C', 0, 'BUT-2', 210, 9, 5, 3, NULL, 2, NULL),
('Roger', 'Lucas', '2005-07-05', '211 Rue d\'Amiens', '+33600000211', 'M', 'lucas.roger@mail.com', 'General', 'A', 1, 'BUT-2', 211, 9, 4, 2, NULL, 2, NULL),
('Caron', 'Paul', '2005-08-12', '212 Rue d\'Amiens', '+33600000212', 'M', 'paul.caron@mail.com', 'Techno', 'B', 0, 'BUT-2', 212, 10, 5, 3, NULL, 2, NULL),
('Lucas', 'Sarah', '2005-09-18', '213 Rue d\'Amiens', '+33600000213', 'F', 'sarah.lucas@mail.com', 'General', 'C', 1, 'BUT-2', 213, 10, 5, 2, NULL, 2, NULL),
('Verdier', 'Maxime', '2005-10-22', '214 Rue d\'Amiens', '+33600000214', 'M', 'maxime.verdier@mail.com', 'Techno', 'A', 0, 'BUT-2', 214, 10, 4, 3, NULL, 2, NULL),
('Brunet', 'Gabin', '2005-11-30', '215 Rue d\'Amiens', '+33600000215', 'M', 'gabin.brunet@mail.com', 'General', 'B', 1, 'BUT-2', 215, 11, 5, 2, NULL, 2, NULL),
('Cordier', 'Julie', '2005-12-05', '216 Rue du Havre', '+33600000216', 'F', 'julie.cordier@mail.com', 'Techno', 'C', 0, 'BUT-3', 216, 11, 5, 3, NULL, 3, NULL),
('Marquis', 'Florian', '2004-01-20', '217 Rue du Havre', '+33600000217', 'M', 'florian.marquis@mail.com', 'General', 'A', 1, 'BUT-3', 217, 11, 4, 2, NULL, 3, NULL),
('Vincent', 'Louna', '2004-02-25', '218 Rue du Havre', '+33600000218', 'F', 'louna.vincent@mail.com', 'Techno', 'B', 0, 'BUT-3', 218, 12, 5, 3, NULL, 3, NULL),
('Navarro', 'Peio', '2004-03-30', '219 Rue du Havre', '+33600000219', 'M', 'peio.navarro@mail.com', 'General', 'C', 1, 'BUT-3', 219, 12, 5, 2, NULL, 3, NULL),
('Ferrand', 'Mylène', '2004-04-05', '220 Rue du Havre', '+33600000220', 'F', 'mylene.ferrand@mail.com', 'Techno', 'A', 0, 'BUT-3', 220, 12, 4, 3, NULL, 3, NULL);

INSERT INTO AG_Sondage (NomSondage, DescriptionSondage, TypeSondage, NumEnseignant) 
VALUES 
('Date Partiel PHP', 'Quelle date preferez-vous ?', 'unique', 2),
('Sortie Integration', 'Choix des activités sportives', 'multiple', 2),
('Choix Projet S4', 'Selectionnez votre sujet favori', 'unique', 2),
('Cantine', 'Sondage satisfaction repas', 'unique', 2);

INSERT INTO AG_Note (ValeurNote, NomNote, NumEtudiant) VALUES (14.5, 'Contrôle Web', 1),
(12, 'TP SQL', 1),
(18, 'Projet Java', 2),
(5, 'TP SQL', 3),
(10, 'Projet Java', 4);

INSERT INTO AG_Contrainte (NomContrainte, TypeContrainte, ValeurContrainte, NumEnseignant) VALUES
('option anglais', 'linguistique', 15, 5),
('% fille', 'mixité', 100, 5),
('covoiturage', 'transport', 5, 5),
('type parcours', 'orientation', 8, 5),
('type bac', 'homogénéité', 8, 5),
('testContrainte', 'tesType', 12, 3);