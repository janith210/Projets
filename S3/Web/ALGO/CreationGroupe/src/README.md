# Modes de décision – Algorithmes gloutons de constitution de groupes


---

## Modèle général

### Entité principale
- **Etudiant**
  - Attributs utilisés :
    - type de bac (Techno / Général)
    - genre (F / M)
    - parcours
    - promotion
    - option anglais
    - covoiturage

### Objectif
Construire un groupe d’étudiants :
- respectant des **contraintes**
- suivant un **ordre de priorité**
- sans retour arrière (approche gloutonne)

---

## 1. Algorithme Parcours et Bac
- Filtre les étudiants pour ne garder uniquement ceux qui ont le bon parcours
- Filtre les bac afin de garantir un bon équilibre entre les 2 type de bac

---

## 2. Algorithme Bac et Parcours
- Filtre les étudiants par bac pour en ajouter le même nombre
- Vérifie en parallèle les parcours afin de maximiser le nombre du même parcours en priorité

--- 

## 3. Algorithme Covoiturage et Anglophone
- Filtre les étudiants par covoiturages
- Filtre en parralèle les étudiants en fonction de l'option anglais

---

## 4. Algorithme Anglophone et Covoiturage
- Filtre les étudiants par l'option d'anglais
- Filtre les étudiants par Covoiturages en parralèle afin de maximiser le rassemblement des étudiants souhaité

---

## 5. Algorithme Fille et Taille
- Filtre les étudiants dans le groupe afin de mettre un pourcentage souhaité de fille dans le groupe 
- Filtre en parallèle les étudiants afin de ne pas dépasser la taille maximal en ajoutant des garçons dans le reste du groupe

---

## 6. Algorithme Taille et Fille
- Ajoute les étudiants nécessaire au remplissage du groupe
- Ajoute des filles au groupe afin de maximiser le pourcentage souhaité sans dépasser la taille max du groupe 