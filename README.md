# PROIECT-PAO-2023-Ionescu-Radu-Constantin
Acest proiect reprezinta o aplicatie destinata managementului unui lant de restaurante cu livrare la domiciliu. Se retin diverse produse oferite cu ingredientele si alergenii lor, clientii cu preferintele si alergiile lor, precum si gravitatea lor, comenzile cu produsele, bucatarii care le-au gatit, clientii lor si soferii care le livreaza, si altele.
S-au folosit Liste si Sorted Map
* Modele:
* Restaurant
* Persoana (clasa mama)
    * Bucatar 
    * Sofer
    * Client
* Locatie
* Oras
* Comanda
* Produs
Functionalitati:
* Add (pentru produs)
* Delete (pentru produs)
* Update (pentru produs)
* FindById (pentru produs)
* GetAll (pentru produse)
* getAge (pentru persoana)
* getRating (pentru sofer)
* valid (pentru persoana)
* comandaSigura (pentru comanda)
* sePotriveste (pentru client)
* Servicii:
Serviciile PersoanaService, ProdusService, ComandaService implementeaza operatiile de baza(adaugare/create, update, delete, getAll, findbyId, searchbyId),
in cazul persoanelor tratandu-se clasele mostenite(Sofer, Client, Bucatar) prin metode de citire diferite, getAll uri diferite, dar pentru functionalitati
care nu depind de tipul obiectului, ci doar de baza Persoana, cum ar fi delete, se foloseste o singura metoda, eventual cu downcasturi unde este nevoie.
