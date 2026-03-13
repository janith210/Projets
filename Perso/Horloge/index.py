import datetime as dt 
import pygame as pg
import locale
import time

locale.setlocale(locale.LC_TIME,'')


Aujourdhui=dt.datetime.now()

Jour=Aujourdhui.strftime("%A")
Nombre= Aujourdhui.day
Mois= Aujourdhui.strftime("%B")
Annee= Aujourdhui.year
Heures=Aujourdhui.strftime("%H")
Minutes=Aujourdhui.strftime("%M")
Secondes=Aujourdhui.strftime("%S")

print(Jour,Nombre,Mois,Annee,"à", Heures,":",Minutes,":",Secondes)
try : 
    Valeur=input("Veux-tu mettre un minuteur (Y/N) : ")
    if(Valeur.upper()=="Y"):
        Temps=float(input("Combien de temps ? ( en minutes ) : "))*60
        start_time = time.perf_counter()
        #Attendre jusqu'à la fin
        time.sleep(Temps)
        end_time = time.perf_counter()
        #Initialisation de la musique 
        pg.mixer.init()
        pg.mixer.music.load("alarme.mp3")
        pg.mixer.music.play()
        #Attendre la fin de la musique 
        while pg.mixer.music.get_busy():
            pass
        #On calcule le temps d'execution du programme 
        execution_time = end_time - start_time
        print(f"Programme exécuté en : {execution_time: .5f} secondes")
    elif(Valeur.upper()=="N"):
        print("Pas de minuteur")
    else:
        print("Erreur de manipulation")
except ValueError:
    print("Erreur : Vous devez entrer un nombre ")

