import yfinance as yf
import sqlite3
from datetime import datetime
import mysql.connector 

#dat.info
#dat.calendar
#dat.analyst_price_targets
#dat.quarterly_income_stmt
#dat.history(period='1mo')
#dat.option_chain(dat.options[0]).calls


def sauvegarder_recherche_mysql(ticker, prix, quantite):
    try:
        # Connexion au serveur MySQL de XAMPP
        conn = mysql.connector.connect(
            host="localhost",
            user="root",      # Utilisateur par défaut de XAMPP
            password="",      # Mot de passe vide par défaut
            database="bourse_db"
        )
        cursor = conn.cursor()
        
        sql = "INSERT INTO historique (ticker, prix, quantite_simulee, date_recherche) VALUES (%s, %s, %s, NOW())"
        cursor.execute(sql, (ticker, prix, quantite))
        
        conn.commit()
        conn.close()
        print("Données envoyées vers MySQL !")
    except Exception as e:
        print(f"Erreur MySQL : {e}")

def Ouvert(dat):
    return dat.info['regularMarketOpen']

def Eleve(dat):
    return dat.info['regularMarketDayHigh']

def Faible(dat):
    return dat.info['regularMarketDayLow']

def Close(dat):
    return dat.info['currentPrice']

def Volume(dat):
    return dat.info['volume']

def Action(dat,quantite):
    return quantite/Close(dat)

nom= str(input("Donner le nom de l'action : "))
quantite= int(input("Budget à investir : "))

try:
    dat = yf.Ticker(nom)
    print("Ouverture : ",Ouvert(dat),"$")
    print("Plus haut : ",Eleve(dat),"$")
    print("Plus bas : ",Faible(dat),"$")
    print("Prix actuel: ",Close(dat),"$")
    print("Volume : ",Volume(dat))
    print("Le nombre d'actions : ",Action(dat,quantite))
    sauvegarder_recherche_mysql(nom,Close(dat),Action(dat,quantite))
    print("Recherche sauvegardée en base de données.")
except Exception as e:
    print(e)
    


