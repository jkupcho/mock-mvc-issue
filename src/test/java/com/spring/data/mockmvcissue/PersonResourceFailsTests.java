package com.spring.data.mockmvcissue;

import com.jayway.jsonpath.JsonPath;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@RunWith(SpringRunner.class)
public class PersonResourceFailsTests {

    @Autowired
    private MockMvc mockMvc;

    /**
     * This 404's
     */
    @Test
    public void getPersons() throws Exception {
        String jsonResponse = mockMvc.perform(get("/persons"))
            .andExpect(status().isOk())
            .andReturn().getResponse().getContentAsString();

        List<String> names = JsonPath.read(jsonResponse, "$._embedded.persons[*].name");
        assertTrue(names.contains("Oliver Gierke"));
    }

}
