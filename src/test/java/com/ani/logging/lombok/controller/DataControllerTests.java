package com.ani.logging.lombok.controller;

import com.ani.logging.lombok.DataController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@WebMvcTest(DataController.class)
class DataControllerTests {

    @Autowired
    private MockMvc mvc;

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
