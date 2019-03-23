package br.com.fiap.orderservice.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoDTO {
    public Long idTransacao;
    public String numeroCartao;
    public String validadeCartao;
    public String bandeira;
}
