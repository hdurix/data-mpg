# mpg-data
Extrait &amp; envoie les joueurs de votre championnat MonPetitGazon

## Avant de commencer
Modifier dans le fichier send-diff.sh les variables `__BOT_ID__`, `__CHAT_ID__` (Telegram) et `__MPG_TOKEN__`

NB: pour connaître le token MPG lié à votre compte, vous pouvez le retrouver dans les requêtes HTTP envoyés sur le site de MPG.
Pour cela, il est nécessaire d'être connecté sur le site avec son compte.
Ouvrez le débuggeur Réseau de votre navigateur, et regardez les entêtes d'une requête HTTP. Vous trouverez le token dans Request Headers -> authorization.

## Exemple d'utilisation
Exemple d'appel de l'extracteur :
```
java -jar mpg-extract.jar mpg.csv __LEAGUE_ID__ __MPG_TOKEN__
```

Exemple d'appel de l'envoi (extraction + envoi Telegram) :
```
send-diff.sh fr __LEAGUE_ID__
```

Exemple crontab :
```
45 6 * * * cd /home/pi/java/mpg && ./send-diff.sh fr __LEAGUE_ID__ > log-cron.log
```

## Remarques
Le premier appel à send-diff.sh peut renvoyer une erreur car le message envoyé à Telegram sera trop grand.

Le code source du programme java est disponible de src, il peut être utilisé. Pour créer le .jar, lancez la commande suivante (le jar se trouvera dans le répertoire `target` :
```
mvn clean package
```