# projet-s3

## Add your files

- [ ] [Create](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#create-a-file) or [upload](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#upload-a-file) files
- [ ] [Add files using the command line](https://docs.gitlab.com/topics/git/add_files/#add-files-to-a-git-repository) or push an existing Git repository with the following command:

```
cd existing_repo
git remote add origin https://git.iut-orsay.fr/tp3f-goat/projet-s3.git
git branch -M main
git push -uf origin main
```

## Clone project
```
git clone https://git.iut-orsay.fr/tp3f-goat/projet-s3.git
Enter Username
Enter password
```

## Configuration local git
```
git config user.name "username"
git config user.email "email"
Vérif : git config --local --list
```
## Use of the project

- Avant chaque toute modification votre le dépot local :  
	1. Mettre à jour les informations sur le dépôt distant
		```bash
	   	git remote update
	   	```
	2. Vérification de l'état du dépôt : :
		```bash
	  	git status
	 	```
	3. (**Si besoin**) synchroniser votre dépôt local avec le dépôt distant :
		```bash
		git pull
		```
- Une fois notre TP terminé : 
	1. Suivre vos modifications (racine du projet) :
		```bash
		git add .
		```
	2. Afin de créer un historique des modifications suivies :
		```bash
		git commit -m "<Message décrivant vos modifications>"
		```
	3. Vérification de l'état du dépôt :
		```bash
		git status
		```
	4. Diffusion des changements sur le dépôt distant
		```bash
		git push
		```

## Cree une branche
```
git checkout -b [prefix]/[name]
```
## Push et lié une branche
```
git push -u origin [nom de la branche]
```
## Supprimer une branche
```
git checkout -D [prefix]/[name]
```
## Mettre a jour la liste des branches 
```
git fetch --prune
```



 for known vulnerabilities with Static Application Security Testing (SAST)](https://docs.gitlab.com/ee/user/application_security/sast/)
- [ ] [Deploy to Kubernetes, Amazon EC2, or Amazon ECS using Auto Deploy](https://docs.gitlab.com/ee/topics/autodevops/requirements.html)
- [ ] [Use pull-based deployments for improved Kubernetes management](https://docs.gitlab.com/ee/user/clusters/agent/)
- [ ] [Set up protected environments](https://docs.gitlab.com/ee/ci/environments/protected_environments.html)

***

