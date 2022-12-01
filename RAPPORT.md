Rapport
=======

Détails des choix de conceptions.

Plateau
-------

Tableau de 2 dimensions de la classe Case.

30/11/2022 <br>

Sera responsable pour la vérification des mouvements possible d'une pièce.

01/12/2022 <br>

Responsable pour savoir si un roi est en échec. Vérifie quelles sont les pièces qui le met en échec (dans le cas d'un échec en début de tour). Vérifie si on se met en échec après un mouvement (à la vérif)


Piece
-----

Peut donner sa valeur (pour le compte des points).
Donne ses mouvements. <br>
Vérifie s'il a déjà été bougé (pour le pion, roi et tour)

30/11/2022 <br>
Les mouvements sont donnés par une liste de "coordonnées".

Joueur
------

Est assigné une couleur et ses pièces. <br>
A aussi une liste des pièces qu'il a capturées

Game
----

30/11/2022 <br>

Instancie le plateau et les joueurs, le Main pour commancer la partie 


