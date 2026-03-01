# Projet S3 - Gestion de Département 

Ce projet est une application web basée sur une architecture MVC (Modèle-Vue-Contrôleur) permettant la gestion pédagogique (étudiants, enseignants, cours, covoiturage).

---

## Installation & Configuration 

### 1. Base de Données
Le projet nécessite une base de données pour fonctionner.
1. Ouvrez votre gestionnaire de base de données (ex: phpMyAdmin).
2. Créez une base de données vide (ex: `projet_s3`).
3. Importez le script SQL situé dans le dossier du projet :
 **`/sql**

### 2. Configuration PHP
Vérifiez les paramètres de connexion à la base de données dans le fichier :
 **`config/connexion.php`**

### 3. Comptes de Test
* **Enseignant Formation:**
  * Login : `psangoku`
  * Mdp :`pass1`
* **Enseignant Filière:**
  * Login : `amartin`
  * Mdp :`pass2`
* **Enseignant Année:**
  * Login : `cpetit`
  * Mdp :`pass4`
* **Enseignant Semestre:**
  * Login : `srichard`
  * Mdp :`pass6`
* **Étudiant :**
  * Login : `lmartin`
  * Mdp : `pass21`

---

## :tools: Guide Développeur & Git

### Setup Initial

## Ajouter vos fichiers


- [ ] [Creer](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#create-a-file) or [mise à jour](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#upload-a-file) files
- [ ] [Ajouter un dossier](https://docs.gitlab.com/topics/git/add_files/#add-files-to-a-git-repository):


```
cd existing_repo
git remote add origin https://git.iut-orsay.fr/tp3f/projet-s3.git
git branch -M main
git push -uf origin main
```


## Clone project
```
git clone https://git.iut-orsay.fr/tp3f/projet-s3.git
Enter login
Enter mot de passe
```


## Configuration local git
```
git config user.name "username"

