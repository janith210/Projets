--SCRIPT creation bd
--P.Sunouvou J.Mapitiyage

BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "ASSOCIATION" (
	"id_livraison"	INTEGER,
	"id_commande"	INTEGER,
	PRIMARY KEY("id_livraison","id_commande"),
	FOREIGN KEY("id_commande") REFERENCES "COMMANDE"("id_commande"),
	FOREIGN KEY("id_livraison") REFERENCES "LIVRAISON"("id_livraison")
);
CREATE TABLE IF NOT EXISTS "CLIENT" (
	"id_client"	INTEGER,
	"prenom_client"	TEXT NOT NULL,
	"nom_client"	TEXT NOT NULL,
	"tel_client"	TEXT NOT NULL,
	"email_client"	TEXT,
	"adresse_client"	TEXT NOT NULL,
	PRIMARY KEY("id_client")
);
CREATE TABLE IF NOT EXISTS "COMMANDE" (
	"id_commande"	INTEGER,
	"bon_de_commande"	TEXT NOT NULL,
	"date_commande"	DATE NOT NULL,
	PRIMARY KEY("id_commande")
);
CREATE TABLE IF NOT EXISTS "LIVRAISON" (
	"id_livraison"	INTEGER,
	"type_livraison"	TEXT NOT NULL,
	"date_livraison"	DATE ,
	PRIMARY KEY("id_livraison")
);
CREATE TABLE IF NOT EXISTS "LIVREUR" (
	"id_livreur"	INTEGER,
	"nom_livreur"	TEXT NOT NULL,
	"prenom_livreur"	TEXT NOT NULL,
	"id_livraison"	INTEGER,
	PRIMARY KEY("id_livreur"),
	FOREIGN KEY("id_livraison") REFERENCES "LIVRAISON"("id_livraison")
);
CREATE TABLE IF NOT EXISTS "PRODUIT" (
	"id_produit"	INTEGER,
	"quantite_produit"	INTEGER NOT NULL,
	"nom_produit"	TEXT NOT NULL,
	PRIMARY KEY("id_produit")
);
CREATE TABLE IF NOT EXISTS "STOCK" (
	"id_stock"	INTEGER,
	"niveau_stock"	INTEGER NOT NULL,
	"emplacement_stock"	TEXT NOT NULL,
	PRIMARY KEY("id_stock")
);
CREATE TABLE IF NOT EXISTS "STOCKAGE" (
	"id_produit"	INTEGER,
	"id_stock"	INTEGER,
	PRIMARY KEY("id_produit","id_stock"),
	FOREIGN KEY("id_produit") REFERENCES "PRODUIT"("id_produit"),
	FOREIGN KEY("id_stock") REFERENCES "STOCK"("id_stock")
);
CREATE TABLE IF NOT EXISTS "contient" (
	"id_produit"	INTEGER,
	"id_commande"	INTEGER,
	PRIMARY KEY("id_produit","id_commande"),
	FOREIGN KEY("id_commande") REFERENCES "COMMANDE"("id_commande"),
	FOREIGN KEY("id_produit") REFERENCES "PRODUIT"("id_produit")
);
CREATE TABLE IF NOT EXISTS "demande" (
	"id_client"	INTEGER,
	"id_commande"	INTEGER,
	PRIMARY KEY("id_client","id_commande"),
	FOREIGN KEY("id_client") REFERENCES "CLIENT"("id_client"),
	FOREIGN KEY("id_commande") REFERENCES "COMMANDE"("id_commande")
);
CREATE TABLE IF NOT EXISTS "livre" (
	"id_client"	INTEGER,
	"id_livreur"	INTEGER,
	PRIMARY KEY("id_client","id_livreur"),
	FOREIGN KEY("id_client") REFERENCES "CLIENT"("id_client"),
	FOREIGN KEY("id_livreur") REFERENCES "LIVREUR"("id_livreur")
);

COMMIT;
