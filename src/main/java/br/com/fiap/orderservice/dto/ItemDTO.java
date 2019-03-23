package br.com.fiap.orderservice.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    public String descricaoItemPedido;
    public String quantidadeItensPedido;
    public String precoUnitItem;
}
