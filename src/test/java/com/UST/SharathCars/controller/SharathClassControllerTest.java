package com.UST.SharathCars.controller;

import  com.UST.SharathCars.model.Cars;
import com.UST.SharathCars.service.SharathClassService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SharathClassController.class)
class SharathClassControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SharathClassService mockService;


    @BeforeEach
    void setup() {

       Cars car = new Cars(1, "City", 1000, "HONDA", "White", 5, "2023-04-03");
    }

    @Test
    void testGetAllCars() throws Exception{

        final List<Cars> car = List.of(new Cars(1,"City",1000,"HONDA","White",5,"2023-04-03"));
        when(mockService.getallcars()).thenReturn(car);

        final MockHttpServletResponse response = mockMvc.perform(get("/SharathCars/Cars")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
    @Test
    void testGetCarsByDate() throws Exception {
        final List<Cars> car = List.of(new Cars(1,"City",1000,"HONDA","White",5,"2023-04-03"));
        when(mockService.getdate("date")).thenReturn(car);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/SharathCars/Cars/{date}", "date")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}
