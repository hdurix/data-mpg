# mpg-data
Extrait &amp; envoie les joueurs de votre championnat MonPetitGazon

## Avant de commencer
Modifier dans le fichier send-diff.sh les variables `__BOT_ID__`, `__CHAT_ID__` (Telegram) et `__LEAGUE_ID__` (MPG)

## Exemple d'utilisation
Exemple d'appel de l'extracteur :
```
java -jar extract.jar mpg.csv __LEAGUE_ID__
```

Exemple d'appel de l'envoi (extraction + envoi Telegram) :
```
send-diff.sh fr __LEAGUE_ID__
```

Exemple crontab :
```
45 6 * * * cd /home/pi/java/mpg && ./send-diff.sh fr __LEAGUE_ID__ > log-cron.log
```

## Remarque
Le premier appel à send-diff.sh peut renvoyer une erreur car le message envoyé à Telegram sera trop grand.
