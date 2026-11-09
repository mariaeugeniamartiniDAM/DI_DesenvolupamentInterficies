
# Lloguer de Videojocs
Aplicació desenvolupada amb Java Swing per gestionar el lloguer de videojocs: usuaris, jocs, plataformes, estoc i lloguers.

## Funcionalitats
- Finestra principal amb una taula que conté tots els lloguers: número de registre, joc, usuari, plataforma, data d'inici del lloguer, data de tornada i gènere del joc.
- Ordenació de la taula per número de registre en ordre descendent i comptador total de lloguers.
- Colors de la fila:
  -   **Verd**: lloguer retornat
  -   **Vermell**: lloguer vençut però encara actiu.
- Registrar un lloguer amb usuari, joc i plataforma.
- Consultar les unitats disponibles a cada plataforma abans de confirmar el lloguer.
- Tornar un lloguer actiu i restaurar automàticament l'estoc.
- Crear i esborrar usuaris.
- Crear i esborrar jocs.
- Interfície en català, amb textes centralitzats.

## Regles
- La data de inici d'un lloguer no es pot modificar i la tornada es calcula automàticament a 7 dies vista.
- Un lloguer està vençut si continua actiu i la data actual supera la data prevista de tornada.
- No es pot registrar un lloguer sense estoc disponible. (radio buttons desactivats)
- No es pot registrar un lloguer actiu del mateix usuari, joc i plataforma.
- En tornar un lloguer, s'augmenta una unitat de l'estoc.
- El DNI de l'usuari ha de ser únic, alfanumèric i màxim de 9 caracters.
- EL nom de l'usuari ha de començar amb majúscula.
- El telèfon només pot contenir dígits i té un màxim de 15 caràcters.

## Dades de prova

En iniciar l'aplicació es carreguen:

- 2 usuaris: Marc Rosselló Puig i Laia Serra Vidal.
- 2 jocs: The Legend of Zelda i Forza Horizon.
- 2 lloguers inicials, amb l'estoc ja descomptat.
- Un dels lloguers està vençut a propòsit per comprovar la fila vermella.

## Validació

Els formularis es validen amb validationapi.ValidationAPI. Els mètodes llancen ValidationException amb una clau (exemple, nom.buit) i es mostra l'error amb un JOptionPane. 

Es va valorar implementar la llibreria ValidationLib dels vídeos, però es va descartar per a aquesta entrega ja que no cobreix les regles pròpies de l'enunciat. 

A més, al intentar-ho amb el vídeo de guia, no apareixia l'opció d'afegir 'ValidationPanel' als contenidors de Swing. No podia trobar l'error i vaig decidir continuar la tasca. 
Al mirar-ho una vegada feta la tasca, he descobert que el motiu era una confusió en el nom del jar a afegir a la llibreria: el vídeo ho presenta com 'validation' però el nom actual és 'simplevalidation'.
Com l'enunciat no imposava missatges emergents o 'ValidationPanel' vaig decidir mantenir els errors amb 'JOptionPane'.


## Casos de proves i comprovacions
S'han realitzat les següents proves per comprovar el funcionament de l'aplicació i la validació de les dades:

### Lloguers
- Registrar: el lloguer es registra correctament i que l'estoc de la plataforma disminueix.
- Tornar: es pot retornar un lloguer actiu i l'estoc es recupera automàticament.

### Usuaris:
- Nom en minúscules: no s'accepta un nom si no comencça amb majúscula.
- Introduir caràcters alfabètics al telèfon: només s'accepten dígits.
- Introduir un DNI incorrecte: el DNI ha de cumplir amb els criteris establerts.

### Jocs:
- Crear un joc duplicat: no es permet registrar un joc que ja existeix.
- Introduir valors numèrics negatius: no es permet introduir un stoc negatiu, ni mitjançant els controls ni escrivint directament amb teclat.
- Esborrar un joc amb lloguers associats: no està permés eliminar un joc amb lloguers actius.

## Estructura del projecte
```text
src/main/java/
              model/         -- GestorDades, Joc, Lloguer, Usuari, Plataforma, gèneres i excepcions
              validationapi/ -- ValidationAPI i ValidationException
              vista/         -- FinestraPrincipal, Textes i diàlegs de l'aplicació
src/main/resources/
              Bundle_ca.properties
pom.xml
```

## Com executar
Requisits: JDK 24 o superior i Maven.
Descarregar el ZIP del projecte.

Des de NetBeans:

1. Obre el projecte.
2. Executa'l amb **Run Project** (`F6`).
3. La classe principal és `vista.FinestraPrincipal`.



## Notes

- Les dades es mantenen en memòria: en tancar l'aplicació es reinicien.
- Els textos de la interfície es troben a `Bundle_ca.properties`, guardat en UTF-8.
- Durant el desenvolupament vaig tenir problemes per vincular el projecte de NetBeans amb GitHub. En un principi, la integració automàtica des de NetBeans no va funcionar correctament. Tampoc estic segura que l'historial de commits hagi quedat ben reflectit, ja que també s'ha sobreescrit el repositori en el darrer moment.
