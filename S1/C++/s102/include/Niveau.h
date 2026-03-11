#ifndef NIVEAU_H
#define NIVEAU_H

#include "Objet.h"
#include "Dictionnaire.h"

#include <vector>

using namespace std;

class Niveau
{
  vector<Objet> _objets;
  int _nbPieces;
  //question 2.1
  bool _ennemisActifs=true;

public:

  Niveau (Image image, const string& nomDuFichier, const Dictionnaire& dictionnaire);

  void dessiner() const;

  // Retourne `true` si la case n'est pas occupee par un objet "solide"
  bool caseEstLibre(int x, int y) const;

  void testerBonusEtPrendre(int x, int y);

  // S'il y a un objet de propriete "propriete" à la case (x,y), cette
  // fonction retourne son indice dans le vecteur _objets. Sinon, elle
  // retourne -1.
  int indiceObjet(int x, int y, const string& propriete) const;
  //question 2.1
  bool ennemisActifs() const;
  //question 2.2
  void testerSpecial(int x,int y);
  //question 3.2
  void testerCoffreEtInteragir(int x,int y,Dictionnaire&dictionnaire);

  bool gagne() const;
};

#endif // NIVEAU_H
