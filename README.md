# CRUD DOCERIA

##### CRUD:
refere-se a um conjunto de operações básicas para manipular dados de um sistema. 
É um acrônimo para as palavras: Create, Read, Update e Delete. Ou seja, Criar, Ler, Atualizar e Deletar dados

---

### Endereço:
```
http://localhost:8880/
```
---

## Endpoints

### GET

**Descrição**: Obtém a lista dos doces cadastrados.


`http://localhost:8080/api/doceria`

---

### POST

**Descrição**:Adiciona um novo doce.

`http://localhost:8080/api/doceria/new`


**Request Example**:

```json
 {
    "nome": "Brigadeiro",
    "valor": 2.50,
    "descricao": "Três por esse valor ",
    "imgUrl": "https://exemplo.com/imagens/Brigadeiro.jpg"
}
```
---

### PUT 

**Descrição**:Atualiza um doce já existente.


`http://localhost:8080/api/doceria/edit{id}`


**Request Example**:
```json
 {
    "nome": "Brigadeiro",
    "valor": 4.50,
    "descricao": "Três por esse valor ",
    "imgUrl": "https://exemplo.com/imagens/Brigadeiro.jpg"
}
```

### DELETE

**Descrição**: Deleta um doce pelo seu ID.

`http://localhost:8080/api/doceria/dell{id}`
