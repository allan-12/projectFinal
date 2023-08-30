# projectFinal
Ce projet consiste en une application de gestion des clubs d'étudiants, permettant d'ajouter, mettre à jour, supprimer et afficher des informations sur les clubs et leurs membres.

## Comment Exécuter l'Application

1. Clonez ce dépôt sur votre machine locale.
2. Configurez la base de données PostgreSQL en mettant à jour les informations d'accès dans `src/main/resources/application.properties`.
3. Assurez-vous d'avoir Java et Maven installés sur votre machine.
4. Ouvrez une ligne de commande dans le répertoire du projet et exécutez la commande : `mvn spring-boot:run`.
5. L'application sera accessible à l'adresse : `http://localhost:8080`.

## Fonctionnalités
- Gestion des Etudiants : Ajouter, mettre à jour, supprimer et afficher les etudiants.
- Gestion des Clubs : Ajouter, mettre à jour, supprimer et afficher les clubs.
- Gestion des Membres : Ajouter, mettre à jour, supprimer et afficher les membres des clubs.
- Gestion des Événements : Ajouter, mettre à jour, supprimer et afficher les événements pour chaque club.
- Gestion des Participations : Ajouter, mettre à jour, supprimer et afficher les participations d'événements pour chaque club.

## Technologies Utilisées
- Java
- Spring Framework (Spring Boot)
- Spring Web
- PostgreSQL (Base de données)
- Lombok (Génération de code)

## Endpoints de l'API
- GetMapping("/student"):Récupérer la liste de tous les students.
- PostMapping("/insertStudent"):Ajouter un nouveau student
- PutMapping("/updateStudent"): Mettre à jour les informations d'un students existant
- DeleteMapping("/deleteStudent/{id}"): Supprimer un student
- GetMapping("/getStudent/{id}"):Récupérer la liste d'un student par id

- ... (Ajoutez les endpoints pour les événements,les participations;les memebres et les clubs )
