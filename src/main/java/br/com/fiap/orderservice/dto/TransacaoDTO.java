package br.com.fiap.orderservice.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoDTO {

    @ApiModelProperty(notes = "The Transacao ID")
    private Long idTransacao;

    @ApiModelProperty(notes = "Número do Cartão")
    private String numeroCartao;

    @ApiModelProperty(notes = "Data de validade do Cartão")
    private String validadeCartao;

    @ApiModelProperty(notes = "Bandeira do cartão")
    private String bandeira;
}
