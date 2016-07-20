###Algoritmo de búsqueda para grafos sin peso
El algoritmo de búsqueda de caminos cortos funciona por definición cortando la búsqueda en el momento que encuentra la conexión posible, y por tiempo de ejecución siempre acabará en el tiempo mas corto, es decir el camino menor.

Aun es ineficiente bajo ciertas circunstancias:

Si queremos ir de un punto del grafo a otro punto que no está conectado de forma directa con el grafo, el algoritmo comprobará el grafo entero para intentar llegar al punto, lo cual es una pérdida de tiempo.

La búsqueda se realiza de forma única, será mas eficiente si añado búsquedas en paralelo (como mínimo una).

# SocialNetwork
SN
