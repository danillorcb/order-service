package br.com.fiap.orderservice.controller;

import br.com.fiap.orderservice.dto.ItemDTO;
import br.com.fiap.orderservice.dto.OrderDTO;
import br.com.fiap.orderservice.dto.TransacaoDTO;
import br.com.fiap.orderservice.repository.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderServiceController.class)
public class OrderServiceControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private OrderRepository repository;

    @Test
    public void notFound() throws Exception {
        String idPedido = "3"; //idPedido = 3 não existe
        mvc.perform(get("/order-service/"+idPedido)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void orderFounded() throws Exception {
        OrderDTO orderDTO = new OrderDTO(
                1l,
                "email@teste.com",
                "Nome do Comprador Número 1",
                "Av. Lins de Vasconcelos 1222",
                new ArrayList<ItemDTO>(
                        Arrays.asList(
                                new ItemDTO(1l, "Notebook", 2, new BigDecimal(2000.00)),
                                new ItemDTO(2l, "Smartphone", 1, new BigDecimal(1000.00))
                        )
                ),
                new BigDecimal(5000.00),
                "A Vista",
                "03/23/2019",
                "Aprovado",
                new TransacaoDTO(1l, "1234-1234-1234-1234", "12/2020", "VISA")
        );

        //idPedido = 1 existe
        when(this.repository.get(1l)).thenReturn(orderDTO);
        mvc.perform(get("/order-service/" + orderDTO.getIdPedido())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(response -> {
                    String json = response.getResponse().getContentAsString();
                    OrderDTO orderDTOFounded = new ObjectMapper().readValue(json, OrderDTO.class);
                    assertThat(orderDTO).isEqualToComparingFieldByField(orderDTOFounded);
                });
    }

    @Test
    public void insertOrder() throws Exception {
        OrderDTO orderDTO = new OrderDTO(
                2l,
                "email@teste.com",
                "Nome do Comprador Número 1",
                "Av. Lins de Vasconcelos 1222",
                new ArrayList<ItemDTO>(
                        Arrays.asList(
                                new ItemDTO(1l, "Notebook", 2, new BigDecimal(2000.00)),
                                new ItemDTO(2l, "Smartphone", 1, new BigDecimal(1000.00))
                        )
                ),
                new BigDecimal(5000.00),
                "A Vista",
                "03/23/2019",
                "Aprovado",
                new TransacaoDTO(2l, "1234-1234-1234-1234", "12/2020", "VISA")
        );

        //Optional<OrderDTO> empty = Optional.empty();
        when(this.repository.get(2l)).thenReturn(orderDTO); //Optional.empty()
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        String jsonInString = mapper.writeValueAsString(orderDTO);

        mvc.perform(post("/order-service/")
                .accept(MediaType.APPLICATION_JSON)
                .content(jsonInString))
                .andExpect(status().isCreated());
    }
}
