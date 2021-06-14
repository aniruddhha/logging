package com.ani.logging.lombok.controller;

import com.ani.logging.lombok.DataController;
import com.ani.logging.lombok.Device;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
@WebMvcTest(DataController.class)
class DataControllerTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    @DisplayName("testing read operation")
    void testRead() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/data/read/")
        ).andExpect(
                MockMvcResultMatchers
                        .content()
                        .string("reading data")
        );
    }

    @Test
    void testPost() throws Exception {

        Device device = new Device(2L, "abc",  LocalDate.now());
        mvc.perform(
                MockMvcRequestBuilders.post("/data/save")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(mapper.writeValueAsString(device))
        ).andExpect(
                MockMvcResultMatchers
                        .status()
                        .is(HttpStatus.CREATED.value())
        );
    }

    @Test
    @DisplayName("testing start operation - true")
    void testStartOperationTrue() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/data/start/true")
        ).andExpect(
                MockMvcResultMatchers
                        .content()
                        .string("started")
        );
    }
//
//    @Test
//    @DisplayName("checking logger")
//    void checkLogger() {
//
//    }
}
