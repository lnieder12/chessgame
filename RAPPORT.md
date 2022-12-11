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

Piece
-----

Peut donner sa valeur (pour le compte des points).
Donne ses mouvements. <br>
Vérifie s'il a déjà été bougé (pour le pion, roi et tour).

30/11/2022 <br>

Les mouvements sont donnés par une liste de "coordonnées".

09/12/2022 <br>

Les mouvements donnés sont indépendants de tout plateau, car il n'a aucune vu sur le plateau de jeu. C'est une préférence algorithmique lors des vérifications plateau.

Joueur
------

Est assigné une couleur et ses pièces. À aussi une liste des pièces qu'il a capturées.

09/12/2022 <br>

Le joueur ne possède plus les pièces pour éviter les redondances. Il n'a plus qu'un champ couleur pour différencier les 2 joueurs.
Il sert seulement à stocker les données afficher tel que : son score, les pièces que le joueur à capturer, son nom.

Game
----

30/11/2022 <br>

Instancie le plateau et les joueurs, le Main pour commencer la partie.

09/12/2022 <br>

Classe façade qui enveloppe le plateau et les joueurs, notamment utile pour la capture de pièces : changements de score et ajout de pièce capturé dans joueur. <br>
Mettra à jour la vue et utiliser comme intermédiaire pour modifier le model par le controller.

11/12/2022 <br>

Met à jour le model et non la vue.

Main
----

09/12/2022 <br>

Instancie une partie et la lance (Board, Player, Game).

11/12/2022 <br>

Créer aussi controller et vues.