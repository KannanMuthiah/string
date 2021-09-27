package kmuthiah.string.v1.controllers;

import kmuthiah.string.v1.api.UtilitiesApi;
import kmuthiah.string.v1.models.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringApiController implements UtilitiesApi {
    @Override
    public ResponseEntity<Response> utilities(@RequestParam(value = "action", required = true) String action) {
        return new ResponseEntity<>(new Response().text("Here is your action:" + action), HttpStatus.OK);
    }
}
