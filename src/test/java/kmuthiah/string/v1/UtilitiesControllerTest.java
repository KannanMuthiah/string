package kmuthiah.string.v1;

import kmuthiah.string.v1.models.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilitiesControllerTest extends AbstractTest{
    @BeforeEach
    public void setUp() {
        super.setUp();
    }
    @Test
    public void getUtilities() throws Exception {
        URI uri = UriComponentsBuilder.fromPath("/utilities")
                .queryParam("action", "someAction")
                        .build().toUri();
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();
        Response utilities = super.mapFromJson(content, Response.class);
        assertEquals("Here is your action:someAction", utilities.getText());
    }
}