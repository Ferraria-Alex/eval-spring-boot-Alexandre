# API Categories

---
Une categorie contient : \
**id :** Auto generé et que s'incremente toute seule \
**libelle :** Une chaine de characteres qui besoin au moins 2 characteres.

### Exemple Categorie JSON

```
{
    "id": 1,
    "libelle": "Bien-etre"
}
```

## Ajouter une Categorie :

---

| URL                                                   | Method |
|-------------------------------------------------------|--------|
| [/api/categorie](http://localhost:9000/api/categorie) | POST   |


### Exemple :

JSON d'envoi :
```
{
    "libelle": "Bien-etre"
}
```

JSON reçu dans le cas ou il est valide et accepté :
```
{
    "id": 1,
    "libelle": "Bien-etre"
}
```

| RESPONSE CODE | NAME    |
|---------------|---------|
| 201           | CREATED |

JSON reçu dans le cas où il existe deja une categorie avec le libelle fournie :
```
{
    "Error": "Une categorie avec la libelle : (Bien-etre) existe deja!"
}
```
| RESPONSE CODE | NAME     |
|---------------|----------|
| 409           | CONFLICT |

JSON reçu dans le cas ou rien est fournie :
```
{
    "Error": "La nouvelle categorie n'est pas valide : Paramètres mal saisis. | Libelle : "
}
```
| RESPONSE CODE | NAME        |
|---------------|-------------|
| 400           | BAD REQUEST |

## Recuperer une categorie par son id :

---

| URL                                                          | Method | {id}         |
|--------------------------------------------------------------|--------|--------------|
| [/api/categorie/{id}](http://localhost:9000/api/categorie/1) | GET    | Un id valide |


### Exemple :

JSON reçu dans le cas où il est valide et accepté :
LIEN UTILISÉ : http://localhost:9000/api/categorie/1
```
{
    "id": 1,
    "libelle": "Bien-etre"
}
```

| RESPONSE CODE | NAME |
|---------------|------|
| 200           | OK   |

JSON reçu dans le cas où il n'existe pas une categorie avec l'id fournie :
LIEN UTILISÉ : http://localhost:9000/api/categorie/2
```
{
    "Error": "La categorie avec l'id (2) n'existe pas"
}
```
| RESPONSE CODE | NAME      |
|---------------|-----------|
| 404           | NOT FOUND |

## Recuperer la liste de tous les categories :

---

| URL                                                     | Method |
|---------------------------------------------------------|--------|
| [/api/categories](http://localhost:9000/api/categories) | GET    |


### Exemple :

JSON reçu dans le cas où il est valide et accepté :
```
[
    {
        "id": 1,
        "libelle": "Bien-etre"
    },
    {
        "id": 2,
        "libelle": "Électronique"
    },
    {
        "id": 3,
        "libelle": "Maison"
    },
    {
        "id": 4,
        "libelle": "Loisirs"
    }
]
```

| RESPONSE CODE | NAME |
|---------------|------|
| 200           | OK   |

JSON reçu dans le cas où il n'existe pas des categories :
```
{
    "Error": "Aucune categorie n'a été trouvé"
}
```
| RESPONSE CODE | NAME      |
|---------------|-----------|
| 404           | NOT FOUND |

# API Produits

---
Un produit contient : \
**id :** Auto generé et que s'incremente toute seule \
**nom :** Une chaine de characteres qui besoin au moins 2 characteres et ne peut pas etre vide \
**prix :** Un nombre dans le type Double qui doit etre plus grand que 0. \
**categorie :** Un object du type Categorie

### Exemple Produit JSON

```
{
    "id": 152,
    "nom": "Smart Watch",
    "prix": 19.99,
    "categorie": {
        "id": 1,
        "libelle": "Électronique"
    }
}
```

## Ajouter un Produit :

---

| URL                                               | Method |
|---------------------------------------------------|--------|
| [/api/produit](http://localhost:9000/api/produit) | POST   |


### Exemple :

JSON d'envoi :

Attention l'id pour la categorie doi exister

```
{
    "nom":"Smart Watch",
    "prix": 19.99,
    "categorie":
        {
            "id":1
        }
}
```

JSON reçu dans le cas où il est valide et accepté :
```
{
    "id": 153,
    "nom": "Smart Watch",
    "prix": 19.99,
    "categorie": {
        "id": 1,
        "libelle": null
    }
}
```

| RESPONSE CODE | NAME    |
|---------------|---------|
| 201           | CREATED |

JSON reçu dans le cas ou il existe deja un produit avec les parametres fournie :
```
{
    "Error": "Un produit avec le nom : (Smart Watch) existe deja!"
}
```
| RESPONSE CODE | NAME     |
|---------------|----------|
| 409           | CONFLICT |

JSON reçu dans le cas ou un où plusiers parametres ne sont pas fournie :
```
{
    "Error": "Le nouvelle produit n'est pas valide : Paramètres mal saisis. | Nom :  | Prix : 19.99"
}
```
| RESPONSE CODE | NAME        |
|---------------|-------------|
| 400           | BAD REQUEST |

## Recuperer un produit par son id :

---

| URL                                                      | Method | {id}         |
|----------------------------------------------------------|--------|--------------|
| [/api/produit/{id}](http://localhost:9000/api/produit/1) | GET    | Un id valide |


### Exemple :

JSON reçu dans le cas où il est valide et accepté :
LIEN UTILISÉ : http://localhost:9000/api/produit/153
```
{
    "id": 153,
    "nom": "Smart Watch",
    "prix": 19.99,
    "categorie": {
        "id": 1,
        "libelle": "Électronique"
    }
}
```

| RESPONSE CODE | NAME |
|---------------|------|
| 200           | OK   |

JSON reçu dans le cas où il n'existe pas un produit avec l'id fournie :
LIEN UTILISÉ : http://localhost:9000/api/produit/154
```
{
    "Error": "Le produit avec l'id (154) n'existe pas"
}
```
| RESPONSE CODE | NAME      |
|---------------|-----------|
| 404           | NOT FOUND |

## Recuperer la liste de tous les categories :

---

| URL                                                  | Method |
|------------------------------------------------------|-------|
| [/api/produits](http://localhost:9000/api/produits)  | GET   |


### Exemple :

JSON reçu dans le cas où il est valide et accepté :
```
[
    {
        "id": 153,
        "nom": "Smart Watch",
        "prix": 19.99,
        "categorie": {
            "id": 1,
            "libelle": "Électronique"
        }
    },
    {
        "id": 154,
        "nom": "Watch",
        "prix": 9.99,
        "categorie": {
            "id": 1,
            "libelle": "Électronique"
        }
    },
    {
        "id": 155,
        "nom": "Cellphone",
        "prix": 119.99,
        "categorie": {
            "id": 1,
            "libelle": "Électronique"
        }
    }
]
```

| RESPONSE CODE | NAME |
|---------------|------|
| 200           | OK   |

JSON reçu dans le cas où il n'existe pas des produits :
```
{
    "Error": "Aucun produit n'a été trouvé"
}
```
| RESPONSE CODE | NAME      |
|---------------|-----------|
| 404           | NOT FOUND |
