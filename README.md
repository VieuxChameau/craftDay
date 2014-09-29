Exercice de refactoring pour appréhender la dette technique et la chasser. 

# Pre-requis

* Java
* Maven 2.2.1 ou plus
* [SonarQube](http://www.sonarsource.org/downloads/) 4.2  ou plus
* [SonarQube Java Ecosystem](http://docs.codehaus.org/x/tZC7DQ) 2.2  ou plus


# L'applicatif

L'application représente l'interface d'un distributeur de boissons.
Trois commandes sont disponibles pour intéragir avec le distributeur:

### GET

Pour obtenir une boisson si assez d'argent a été inséré.

Format: "GET COCA"

Retour : "COCA"


### PUT
Permet d'ajouter des pièces

Format: "PUT 1"

Retour : ""

### COIN-RETURN

Permet de retourner le compte des pièces restantes

Format: "COIN-RETURN"

Retour : "2.0"


Plusieurs commandes peuvent être fournies en une seule fois (séparateur ,).

Exemple : "PUT 2, PUT 2, GET PERRIER, COIN-RETURN"

# Analyse Sonar


```sh
mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install -Dmaven.test.failure.ignore=true
mvn sonar:sonar
```

Ensuite consulter la [page Sonar](htpp://localhost:9000)

A vous de jouer
=============

