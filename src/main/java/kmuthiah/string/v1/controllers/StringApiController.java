package kmuthiah.string.v1.controllers;

import kmuthiah.string.v1.api.UtilitiesApi;
import kmuthiah.string.v1.models.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringApiController implements UtilitiesApi {
    @Override
    public ResponseEntity<Response> utilities() {
        return new ResponseEntity<>(new Response().text("Hello World!"), HttpStatus.OK);
    }
}
