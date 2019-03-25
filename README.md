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
    "nomeCompleto": "Nome do Comprador Número 2",
    "shippingAddress": "Av. Lins de Vasconcelos, 1222",
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
        }
    ],
    "precoTotalPagamento": "7000",
    "formaPagamento": "A Vista",
    "dataPedido": "25/03/2019",
    "statusPedido": "Pendente",
    "transacao": {
        "idTransacao": 1,
        "numeroCartao": "1111-2222-3333-4444",
        "validadeCartao": "12/2020",
        "bandeira": "VISA"
    }
}
```

### Method: PATCH
* **Endpoint:** http://host/order-service/{idPedido}

* **Payload:** 

### Method: DELETE


