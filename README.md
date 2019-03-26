# Microserviço: order-service

### Method: GET
* *Endpoint:* http://host/order-service/{idPedido}

### Method: POST
* *Endpoint:* http://host/order-service/
* *Payload:* 
```json5
{
    "idPedido": 2,
    "email": "email@teste.com",
    "nomeCompleto": "Nome do Comprador Número 2",
    "shippingAddress": "Av. Lins de Vasconcelos, 1222",
    "itens": [
        {
            "idItem": 1,
            "descricaoItemPedido": "Notebook",
            "quantidadeItensPedido": 2,
            "precoUnitItem": 2000.00
        },
        {
            "idItem": 2,
            "descricaoItemPedido": "Smartphone",
            "quantidadeItensPedido": 1,
            "precoUnitItem": 1000.00
        }
    ],
    "precoTotalPagamento": 5000.00,
    "formaPagamento": "A Vista",
    "dataPedido": "03/23/2019",
    "statusPedido": "Pendente",
    "transacao": {
        "idTransacao": 1,
        "numeroCartao": "1234-1234-1234-1234",
        "validadeCartao": "12/2020",
        "bandeira": "VISA"
    }
}
```
* *Response:* http://host/order-service/{idPedido}

### Method: PATCH
* *Endpoint:* http://host/order-service/{idPedido}

* *Payload:* 
```json5
{
    "shippingAddress": "Av. Lins de Vasconcelos, 1222 - Lins II",
    "itens": [
        {
            "idItem": 1,
            "descricaoItemPedido": "Notebook DELL",
            "quantidadeItensPedido": 2,
            "precoUnitItem": 2000.00
        },
        {
            "idItem": 2,
            "descricaoItemPedido": "Smartphone SAMSUNG",
            "quantidadeItensPedido": 2,
            "precoUnitItem": 1000.00
        }
    ],
    "precoTotalPagamento": 6000.00,
    "formaPagamento": "A Vista",
    "dataPedido": "03/23/2019",
    "transacao": {
        "idTransacao": 1,
        "numeroCartao": "1111-2222-3333-4444",
        "validadeCartao": "03/2025",
        "bandeira": "Mastercard"
    }
}
```
* *Response:* http://host/order-service/{idPedido}

### Method: DELETE
* *Endpoint:* http://host/order-service/{idPedido}

