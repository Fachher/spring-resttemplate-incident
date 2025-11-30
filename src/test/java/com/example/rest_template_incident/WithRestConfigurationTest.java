package com.example.rest_template_incident;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles(Profiles.REST_CONFIGURATION)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WithRestConfigurationTest {

    @LocalServerPort
    private int port;

    @Test
    void shouldFindLinks() throws Exception {
        final String response = new RestTemplate().getForObject("http://localhost:%s/api/current-user".formatted(port), String.class);

        System.out.println(response);

        final ObjectMapper mapper = new ObjectMapper();
        final JsonNode jsonNode = mapper.readTree(response);
        assertThat(jsonNode.has("links")).isTrue();
    }
}