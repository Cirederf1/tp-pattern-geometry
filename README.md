# tp-pattern-geometry

## Description

Projet de démarrage pour le [TP - Mise en oeuvre des patterns sur des Geometry](http://mborne.github.io/cours-patron-conception/annexe/tp-geometry/index.html) associé au cours sur [les patrons de conception](http://mborne.github.io/cours-patron-conception/)

## Principes

* La branche par défaut ("initial") permet de récupérer un projet maven pour commencer à travailler
* La branche master correspond aux travaux en cours.
* Les branches 0.1, 0.2, etc. correspondent aux réponses pour chaque question du TP
* junit et mockito permettent l'écriture de tests unitaires
* La commande maven suivante permet la construction, l'exécution des tests et la génération d'un rapport de couverture :

```bash
mvn clean package jacoco:report

```

(ouvrir `target/site/jacoco/index.html` pour visualiser le rapport de couverture)


