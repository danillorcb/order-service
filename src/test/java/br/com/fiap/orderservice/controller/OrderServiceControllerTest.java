package br.com.fiap.orderservice.controller;

import br.com.fiap.orderservice.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
        String idPedido = "2";
        mvc.perform(get("/"+idPedido)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
