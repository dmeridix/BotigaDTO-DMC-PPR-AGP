# DMC-ActivitatBotiga

Generar un controlador REST a partir del controlador actual de l’aplicació web, afegint algunes noves funcionalitats.
Canviar l’ús de les entitats al controlador per DTO’s i mapejos fent servir MapStruct.
Provar l’API amb swagger.

1 REST API
Controllers
12 Endpoints

1 DTOS MAPPERS
dependencies
properties
entitats - JPA

- Categoria
  Posar camps correctes
- Subcategoria
  Posar camps
  Relacio
  1 to N Categoria - Subcategoria
- Producte
  Afegir Categoria
  Afegir Subcategoria
  Relacions entre Categoria
  N to 1 Producte - Categoria
  DTOS
- Camps entitats menys ids i timestamps creacio i actualitzacio
  Mapper
- Interficie
  Repository
  Services - Opció B
  Implementacions
  Adaptacio cap a DTO

## Proves del controlador de Subcategoria

LlistarSubcategories:

![alt text](image.png)
![alt text](image-1.png)

LlistarSubcategoriesPerEstat:

![alt text](image-3.png)
![alt text](image-4.png)
![alt text](image-5.png)

- Si no li proporciones un estat, no permet fer el endpoint:
  ![alt text](image-2.png)

- Si el estatus no existeix, simplement retorna buit:
  ![alt text](image-6.png)

Inserir Subcategoria:
![alt text](image-7.png)
![alt text](image-8.png)
![alt text](image-9.png)

- Si no es permet afegir la subcategoria:
  ![alt text](image-10.png)
  ![alt text](image-12.png)

Modificar una subcategoria:

![alt text](image-14.png)

- Si no s'especifíca el id:
  ![alt text](image-13.png)

Eliminar una subcategoria:

![alt text](image-16.png)

- Si el id no existeix:
  ![alt text](image-15.png)

## Proves del controlador de Categoria

LlistarCategories:

- Retorna totes les categories existents:
  ![image](https://github.com/user-attachments/assets/d8601dff-2f0c-418d-bb77-1aae25ecb412)
  ![image](https://github.com/user-attachments/assets/4a23ab4e-8ff3-40b4-9bd7-064d7cb2cdba)

CercarCategoriesPerDescripcio:

- Amb una descripció parcial:
  ![image](https://github.com/user-attachments/assets/b1f000a4-3543-47e8-8ef7-3887785b8a29)
  ![image](https://github.com/user-attachments/assets/2279e2f2-fe38-4573-9ea8-529aaecdd1a4)


- Descripció completa:
  ![image](https://github.com/user-attachments/assets/30a32632-d227-45a7-ac8d-db5f04b40a2a)
  ![image](https://github.com/user-attachments/assets/c301d31a-fcce-4217-8d5b-78a4948407a1)



InserirCategoria:

- Inserció correcta d'una categoria:
  ![image](https://github.com/user-attachments/assets/e88e4a73-3b78-4cd6-9bd8-0601524b4d52)
  ![image](https://github.com/user-attachments/assets/da89d0ae-e9d7-434f-a333-2bbe2d0e9ea5)
  ![image](https://github.com/user-attachments/assets/45e3033a-537a-4d2b-80fa-8e8650b6862f)



ModificarStatusCategoria:

- Canvi d'estat correcte (ex: "Inactivo"):
  ![image](https://github.com/user-attachments/assets/212f1523-85ac-4806-9fdb-83e7eea9810a)
  ![image](https://github.com/user-attachments/assets/bfa118a2-6689-49a3-9244-4f448cb90dc3)
  ![image](https://github.com/user-attachments/assets/129840dc-535b-408a-a994-bce933a2efd0)
  


EliminarCategoria:

- Eliminació d'una categoria existent:
  ![image](https://github.com/user-attachments/assets/72d39554-f046-44e7-ba4b-4b81be95e3ea)
  ![image](https://github.com/user-attachments/assets/52bde450-0010-4254-94bd-21305181bef6)
  ![image](https://github.com/user-attachments/assets/20314b9a-4359-4c5d-9cd8-b294a15623ea)


## Proves del controlador de Producte

LlistarProductes:

![image](llistarProductes.png)

CercaProductes:

![image](cercaProductes.png)

FiltrarProductes:
> Parametres opcionals

- Per categoria
  
  ![image](filtrarPerCategoria.png)

- Per Subcategoria

  ![image](filtrarPerSubcategoria.png)

- Per Categoria Subcategoria

  ![image](subcatcat.png)

InserirProducte:

- Al inserir sense categoria existent:

  ![image](nocategoria.png)

- Al inserir sense subcategoria existent:

  ![image](nosubcat.png)

- Inserir Correctament

  ![image](insercio.png)

  --- BBDD

  ![image](insersql.png)

ModificarPreu:

- ID No valid

  ![image](novalidid.png)

- Correctament

  ![image](modificacio.png)

  --- BBDD

  ![image](modisql.png)

EliminarProducte:

  ![image](eliminar.png)

  --- BBDD

  ![image](eliminarsql.png)