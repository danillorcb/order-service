# Microserviço: order-service

### Method: GET
* **Endpoint:** http://host/order-service/{idPedido}

### Method: POST
* **Endpoint:** http://host/order-service/

* **Payload:** 
```json
{
    "idPedido": 2,
    "email": "email@teste.com",
    "nomeCompleto": "Nome do Comprador Número 1",
    "shippingAddress": "Av. Lins de Vasconcelos 1222 - Predio II",
    "itens": [
        {
            "idItem": 1,
            "descricaoItemPedido": "Notebook DELL",
            "quantidadeItensPedido": "2",
            "precoUnitItem": "2000"
        },
        {
            "idItem": 2,
            "descricaoItemPedido": "Smartphone SAMSUNG",
            "quantidadeItensPedido": "3",
            "precoUnitItem": "1000"
        },
        {
            "idItem": 3,
            "descricaoItemPedido": "SmartTV",
            "quantidadeItensPedido": "1",
            "precoUnitItem": "3000"
        }
    ],
    "precoTotalPagamento": "10000",
    "formaPagamento": "A Vista",
    "dataPedido": "25/03/2019",
    "statusPedido": "Aprovado",
    "transacao": {
        "idTransacao": 1,
        "numeroCartao": "1234-1234-1234-1234",
        "validadeCartao": "12/2020",
        "bandeira": "VISA"
    }
}
```

### Method: PATCH
* **Endpoint:** http://host/order-service/{idPedido}

* **Payload:** 

### Method: DELETE


