# DesafioTecnico Backend
Aplicação de back-end básico utilizando Java 11, Spring Boot, Spring Data e SQlite 3.

## Para testar a aplicação no Postman


>Retorna todos os registros do banco

http://localhost:8080/api-desafio1.0/findAll (GET)

---

>Retorna a entidade correspondente ao seu identificador ‘logic’

http://localhost:8080/api-desafio1.0/findByLogic/{logic} (GET) 

---

>Insere objeto entidade no banco de dados.

http://localhost:8080/api-desafio1.0/insert (POST) -  

Apenas modelo 
<code>Content-Type:Text/HTML: logic;serial;model;sam;ptid;plat;version;mxr;mxf;VERFM</code>

respeitando os tipos
<code>Integer;String;String;Integer;String;Integer;String;Integer;Integer;String</code>

Será aceito pelo validador.

---

>Atualiza uma entidade do banco com os dados

http://localhost:8080/api-desafio1.0/update/{logic} (PUT)

Dados devem ser formatados para JSON no Body onde o identificador ‘logic’ seja correspondente.

Respeitando o Schema:

```json
{ 
"title": "Terminal", 
"type": "object", 
"properties": { 
       "logic": { 
            "type": "integer" 
        }, 
       "serial": { 
            "type": "string" 
        }, 
       "sam": { 
            "type": "integer", "minimum": 0 
        }, 
       "ptid": {    
            "type": "string" 
        }, 
       "plat": { 
            "type": "integer" 
        }, 
       "version": { 
            "type": "string" 
        }, 
       "mxr": { 
            "type": "integer" 
        }, 
       "VERFM": { 
            "type": "string" 
        } 
   }, 
   "required": ["logic", "serial", "model", "version"] 
}
```
