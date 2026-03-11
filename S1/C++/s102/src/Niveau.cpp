#include "Niveau.h"

#include <fstream>

Niveau::Niveau (Image image, const string& nomDuFichier, const Dictionnaire& dictionnaire)
{
    ifstream fichier(nomDuFichier);
    if (!fichier)
        throw std::runtime_error("Impossible de charger " + nomDuFichier);

    int nbLignes;
    //question 2.1
    fichier >> nbLignes;

    _nbPieces = 0;
    for (int i = 0; i < nbLignes; i ++)
    {
        string nom;
        int x, y;
        fichier >> nom >> x >> y;
        _objets.push_back(Objet(image, x * TAILLE_CASE, y * TAILLE_CASE, nom, dictionnaire));

        if (_objets[i].getPropriete() == "bonus")
            _nbPieces ++;
    }
}

void Niveau::dessiner() const
{
    for (int i = 0; i < _objets.size(); i ++)
        if (_objets[i].getPropriete() != "cache")
            _objets[i].dessiner();
}
//Question 3.1
bool Niveau::caseEstLibre(int x, int y) const
{
    return (indiceObjet(x, y, "solide") == -1) && (indiceObjet(x,y, "coffre") == -1);
}

void Niveau::testerBonusEtPrendre(int x, int y)
{
    int indice = indiceObjet(x, y, "bonus");
    if (indice != -1)
    {
        _nbPieces --;
        _objets[indice].cacher();
    }
}

int Niveau::indiceObjet(int x, int y, const string& propriete) const
{
    int indice = -1;
    int i = 0;

    while (indice == -1 && i < _objets.size())
    {
        if (_objets[i].getPropriete() == propriete
                && _objets[i].getX() == x
                && _objets[i].getY() == y)
            indice = i;
        else
            i ++;
    }

    return indice;
}
//question 2.1
bool Niveau::ennemisActifs()const
{
    return _ennemisActifs;
}
//question 2.2
void Niveau::testerSpecial(int x,int y)
{
    for(int i=0 ; i<_objets.size(); i++)
    {
        if (_objets[i].getPropriete()=="special")
        {
            if (x==_objets[i].getX() && y==_objets[i].getY())
            {
                _ennemisActifs=false;
            }
        }
    }
}

//Question 3.2
void Niveau::testerCoffreEtInteragir(int x,int y,Dictionnaire&dictionnaire)
{
    for(int i=0 ; i<_objets.size(); i++)
    {
        if (_objets[i].getPropriete()=="coffre")
        {
            if (x==_objets[i].getX() && y==_objets[i].getY())
            {
                if (_objets[i].getNom()=="Coffre_ferme")
                {
                    _objets[i].mettreAJour ("Coffre_ouvert",dictionnaire);
                }
                else
                {
                    _objets[i].mettreAJour ("Coffre_ferme",dictionnaire);
                }

            }
        }
    }
}

bool Niveau::gagne() const
{
    return _nbPieces == 0;
}
