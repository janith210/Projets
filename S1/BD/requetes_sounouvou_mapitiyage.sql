--SCRIPT requetes
--P.Sunouvou J.Mapitiyage

-- 1/ Nombre de client à l'entreprise
-- Utile pour les statistiques
SELECT COUNT(id_client) 
FROM Client;


-- 2/ Chercher les noms et prénoms des clients qui ont commandé un joint de culasse
-- Savoir si ce produit est 
SELECT C.prenom_client, C.nom_client 
FROM CLIENT C 
INNER JOIN DEMANDE D ON C.id_client = D.id_client
INNER JOIN COMMANDE CMD ON D.id_commande = CMD.id_commande
INNER JOIN CONTIENT CON ON CMD.id_commande = CON.id_commande
INNER JOIN PRODUIT P ON CON.id_produit = P.id_produit
WHERE nom_produit = "joint de culasse";


-- 3/ Afficher le nombre de commande que Solomon Holt doit faire
-- Une future appli pour les livreurs pourra etre réalisé leur montrant leur commandes a réalisé
SELECT COUNT(LI.id_livraison) AS Nb_livraison_S_HOLT
FROM LIVREUR LI
INNER JOIN LIVRAISON L ON LI.id_livraison = L.id_livraison
WHERE LI.nom_livreur = 'Holt' AND LI.prenom_livreur = 'Solomon';

--4/ Donner pour chaque commande le nombre de client qui ont une adresse email du type ...@protonmail.org ou ...@protonmail.net
-- récupérer ces adresses email sont de clients à l'international,
SELECT D.id_commande, COUNT(*) AS nb_cli_proton
FROM DEMANDE D
INNER JOIN CLIENT C ON D.id_client = C.id_client
WHERE C.email_client LIKE '%@protonmail.net' OR C.email_client LIKE '%@protonmail.org'
GROUP BY D.id_commande;

--5/Donner le nom des clients pour qui la commande et la livraison ont plus d'un mois d'intervalles
-- Si la commande a plus d'un mois d'intervalle entre la commande et la livraison 
SELECT nom_client, prenom_client 
FROM CLIENT C
INNER JOIN DEMANDE D ON C.id_client = D.id_client
INNER JOIN COMMANDE CMD ON D.id_commande = CMD.id_commande
INNER JOIN ASSOCIATION ASSO ON CMD.id_commande = ASSO.id_commande
INNER JOIN LIVRAISON L ON ASSO.id_livraison = L.id_livraison
WHERE (strftime('%Y', L.date_livraison) - strftime('%Y', CMD.date_commande)) * 12 +
      (strftime('%m', L.date_livraison) - strftime('%m', CMD.date_commande)) >= 1;


--6/Lister les livreurs ayant livré plus de 3 commandes
-- Il n'y a pas beaucoup de livraison donc le but est de les répartir tout ceux qui ont plus dde 2 livraisons serons allégées d'une
SELECT L.id_livreur, L.nom_livreur, L.prenom_livreur, COUNT(A.id_commande) AS commandes_livrees
FROM Livreur L
INNER JOIN Livre Li ON L.id_livreur = Li.id_livreur
INNER JOIN Livraison Lv ON Li.id_client = Lv.id_livraison
INNER JOIN Association A ON Lv.id_livraison = A.id_livraison
GROUP BY L.id_livreur, L.nom_livreur, L.prenom_livreur
HAVING COUNT(A.id_commande) >= 3;

--7 Trouver les clients ayant passé au moins plus de 3 commandes
--En ayant les clients qui achètent le plus nous obtenons donc des clients fidèles a qui nous pouvons leur donner des promotions 
SELECT C.id_client, C.nom_client, C.prenom_client, COUNT(Co.id_commande) AS nombre_commandes
FROM Client C
INNER JOIN Demande D ON C.id_client = D.id_client
INNER JOIN Commande Co ON D.id_commande = Co.id_commande
GROUP BY C.id_client, C.nom_client, C.prenom_client
HAVING COUNT(Co.id_commande) >= 3;


--8/ Trouver les clients ayant passé des commandes en 2024 :
-- Utile pour le bilan et le compte de résultat de l'entreprise
SELECT C.id_client, C.nom_client, COUNT(Co.id_commande) AS commandes_passees
FROM Client C
INNER JOIN Demande D ON C.id_client = D.id_client
INNER JOIN Commande Co ON D.id_commande = Co.id_commande
WHERE Co.date_commande BETWEEN '2024-01-01' AND '2024-12-31'
GROUP BY C.id_client, C.nom_client;

--9/ Produits au moins commandé 2 fois
-- Ce produit devient donc populaire et apparaitra sur la page d'accueil de notre site
SELECT P.id_produit, P.nom_produit, COUNT(Ct.id_commande) AS nombre_commandes
FROM Produit P
INNER JOIN Contient Ct ON P.id_produit = Ct.id_produit
GROUP BY P.id_produit, P.nom_produit
HAVING COUNT(Ct.id_commande) >= 2;

--10/ client ayant commandé les 6 dernier mois
-- nous obtenons une statistiques sur la fidelité des clients à long terme
SELECT DISTINCT C.nom_client, C.prenom_client
FROM CLIENT C
INNER JOIN DEMANDE D ON C.id_client = D.id_client
INNER JOIN COMMANDE Co ON D.id_commande = Co.id_commande
WHERE Co.date_commande >= DATE('now', '-6 months');

--11/ Donner pour chaque numéro de stock le nb produits associé
--Nous donne une idée de la répartition des produits dans les stocks, cela évite aussi le débordement des produits
SELECT S.id_stock, COUNT(DISTINCT S.id_produit) AS nb_produit
FROM Stockage S
GROUP BY S.id_stock;

--12/ commande contenant plusierus produits diff
-- En analysant ces commandes nous pouvons promouvoir à ces personnes des produits similaires en se basant sur ces résultats
SELECT Ct.id_commande, COUNT(DISTINCT P.id_produit) AS types_produits
FROM Contient Ct
INNER JOIN Produit P ON Ct.id_produit = P.id_produit
GROUP BY Ct.id_commande
HAVING COUNT(DISTINCT P.id_produit) > 1;

--13/ donner le nom des clients qui ont commandé après le 1er juin 2024 l'ordonne par les dates
--une statistique intéresante, à la mi-année savoir combien de personnes ont déjà commandée
SELECT DISTINCT nom_client, prenom_client
FROM CLIENT C
INNER JOIN DEMANDE D ON C.id_client = D.id_client
INNER JOIN COMMANDE CMD ON D.id_commande = CMD.id_commande
WHERE date_commande >= '2024-06-01'
ORDER BY date_commande ASC;

--14/donner le temps d'acheminenements des commandes
-- Les livreurs auront le temps d'acheminenements assimilées de sorte à ce que les plus longs soit livrées lus rapidement
SELECT date_livraison, date_commande, julianday(date_livraison) - julianday(date_commande) AS temps_acheminement
FROM COMMANDE CMD
INNER JOIN ASSOCIATION A ON CMD.id_commande = A.id_commande
INNER JOIN LIVRAISON L ON A.id_livraison = L.id_livraison
WHERE date_livraison is NOT NULL
ORDER BY temps_acheminement DESC;

--15/ Lister tout les livreurs et ceux qu'ils délivrent
--cela nous permet d'avoir un tableau de bord sur la page administrateur des livreurs qui livrent qui

SELECT LV.nom_livreur, LV.prenom_livreur, C.nom_client, C.prenom_client
FROM LIVREUR LV
INNER JOIN LIVRAISON L ON LV.id_livraison = L.id_livraison
INNER JOIN ASSOCIATION ASSO ON L.id_livraison = ASSO.id_livraison
INNER JOIN COMMANDE CMD ON ASSO.id_commande = CMD.id_commande
INNER JOIN DEMANDE D ON CMD.id_commande = D.id_commande
INNER JOIN CLIENT C ON D.id_client = C.id_client;

--16/ donner les types de livraisons prévu pour le moi d'aout
-- si il y a beaucoup de livraison en été, il faut pouvoir organiser les congés des livreurs pour éviter les absences et temps
--d'acheminement trop long pour le client
SELECT id_livraison, type_livraison
FROM LIVRAISON
WHERE date_livraison >= '2024-08-01' AND date_livraison <= '2024-08-31';


--17/ Lister la commande de Shay Boone
-- Chaque client à une interface résumant ses statistiques ici on veut une commande spécifique
SELECT bon_de_commande, date_commande, nom_produit
FROM Produit P
INNER JOIN contient c ON p.id_produit = c.id_produit
INNER JOIN COMMANDE CMD ON c.id_commande = cmd.id_commande
INNER JOIN DEMANDE DM ON CMD.id_commande = DM.id_commande
INNER JOIN CLIENT CLI ON DM.id_client = CLI.id_client
WHERE prenom_client = "Shay" AND nom_client = "Boone";


--18/ Donner les produits qui sont stockés à deux endroits différents
-- pour le réapprovisionnement certain produits doivent être réparti équitablment entre les stocks
SELECT P.nom_produit, COUNT(DISTINCT S.id_stock) AS stock_position
FROM PRODUIT P
JOIN STOCKAGE S ON P.id_produit = S.id_produit
GROUP BY P.nom_produit
HAVING stock_position > 1;

--19/ afficher les produits en rupture de stock
-- les produits en rupture de stock doivent absolument être recommandé
SELECT p.id_produit, p.nom_produit, p.quantite_produit
FROM PRODUIT p
WHERE p.quantite_produit = 0;

--20/ afficher les produits qui ont été commandées une ou zero fois
--ces produits ne sont peu ou pas commandé. Ils seront mis vivement en avant dans notre catalogue si après
-- une certaine période ils sont toujours peu ou pas commandé il seront retirées peu ou pas commandé
SELECT p.id_produit, p.nom_produit, COUNT(ct.id_commande) AS num_orders
FROM PRODUIT p
INNER JOIN contient ct ON p.id_produit = ct.id_produit
GROUP BY p.id_produit
HAVING num_orders <= 1;


--21/ les commandes par mois
--utile pour la gestion et la comptabilité de l'entreprise, peut aussi être très utile pour accorder des mois de congés à certains 
--livreurs sur les moi ou les commandes sont les plus faibles
SELECT strftime('%Y-%m', l.date_livraison) AS delivery_month, COUNT(l.id_livraison) AS total_deliveries
FROM LIVRAISON l
WHERE strftime('%Y', l.date_livraison) = '2024'
GROUP BY delivery_month;



 
