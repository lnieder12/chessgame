Rapport
=======

Détails des choix de conceptions.

Plateau
-------

Tableau de 2 dimensions de la classe Case.

30/11/2022 <br>

Sera responsable pour la vérification des mouvements possible d'une pièce.

01/12/2022 <br>

Responsable pour savoir si un roi est en échec. Vérifie quelles sont les pièces qui le met en échec (dans le cas d'un échec en début de tour). Vérifie si on se met en échec après un mouvement (à la vérif).

09/12/2022 <br>

Place ses pièces indépendamment des pièces joueurs (maintenant supprimées).

Rendu 2 <br>

Classe : Board <br>
Capable de donné les déplacements possibles d'une pièce sans se mettre en échec. Peut vérifier si une des couleurs est échec et mat à la fin du tour adverse. Est responsable de savoir à quelle tour c'est.

Piece
-----

Peut donner sa valeur (pour le compte des points).
Donne ses mouvements. <br>
Vérifie s'il a déjà été bougé (pour le pion, roi et tour).

30/11/2022 <br>

Les mouvements sont donnés par une liste de "coordonnées".

09/12/2022 <br>

Les mouvements donnés sont indépendants de tout plateau, car il n'a aucune vu sur le plateau de jeu. C'est une préférence algorithmique lors des vérifications plateau.

Rendu 2 <Br>

A un champ nom, pour facilement différencier les différents types de piece pour l'affichage et les cas exceptionnels (capture pion, roi).


Joueur
------

Est assigné une couleur et ses pièces. À aussi une liste des pièces qu'il a capturées.

09/12/2022 <br>

Le joueur ne possède plus les pièces pour éviter les redondances. Il n'a plus qu'un champ couleur pour différencier les 2 joueurs.
Il sert seulement à stocker les données afficher tel que : son score, les pièces que le joueur à capturer, son nom.

Rendu 2 <br>

Le nom du joueur n'est pas donné à la création de l'instance, mais donné par les champs de texte de la première fenêtre.

Game
----

30/11/2022 <br>

Instancie le plateau et les joueurs, le Main pour commencer la partie.

09/12/2022 <br>

Classe façade qui enveloppe le plateau et les joueurs, notamment utile pour la capture de pièces : changements de score et ajout de pièce capturé dans joueur. <br>
Mettra à jour la vue et utiliser comme intermédiaire pour modifier le model par le controller.

11/12/2022 <br>

Met à jour le model et non la vue.

Rendu 2 <br>

Connais quelle pièce a été dernièrement sélectionnée pour faire le déplacement. Responsable d'appeler la vérification d'échec et mat après un mouvement pour permettre le rendu visuel du dernier mouvement.

Main
----

09/12/2022 <br>

Instancie une partie et la lance (Board, Player, Game).

11/12/2022 <br>

Créer aussi controller et vues.

Rendu 2 <br>

Met en place les observer.

Position
--------

Rendu 2 <br>

Classe variable utilisé pour facilité la manipulation des coordonnées sur le plateau que ça soit niveau model ou visuelle.

Controller
----------

Rendu 2 <br>

Un controller pour le plateau et un pour les joueurs. 

Vue
---

Rendu 2 <br>

Une fenêtre en java swing qui est responsable de l'affichage des trois fenêtres (Menu, Partie et fin de partie). Elle utilise deux classes définies en interne : 
<br> - Le JButtonB qui combine un JButton classique et y ajoute un champ Boolean, ça permet de changer son comportement au click entre l'affichage des mouvements possibles d'une pièce et le déplacement d'une pièce sur une case en surbrillance.
<br> - Le PlayerInfo un JPanel remplie de tous les éléments nécessaires à l'affichage des informations joueurs à côté du plateau de jeu. Elle a ses propres méthodes pour mettre facilement à jour ses données.
<br> La mise à niveau de la vue se fait case par case et jamais en entier. Seul l'affichage des pièces capturées est à chaque fois écrasé et refait de zéro pour avoir les pièces rangées par ordre de valeur.