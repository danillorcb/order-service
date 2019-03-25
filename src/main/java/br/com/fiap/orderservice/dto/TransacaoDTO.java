package br.com.fiap.orderservice.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoDTO {
    private Long idTransacao;
    private String numeroCartao;
    private String validadeCartao;
    private String bandeira;
}
