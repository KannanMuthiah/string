package kmuthiah.string.v1.controllers;

import kmuthiah.string.v1.api.GenerateApi;
import kmuthiah.string.v1.models.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@RestController
public class GenerateController implements GenerateApi {
    private static final int UPPER_CASE_A = 'A';
    private static final int NUMERIC_0 = '0';
    @Override
    public ResponseEntity<Response> generateLicensePlateNumber(@RequestParam(value = "country", required = false) String country) {
        return new ResponseEntity<>(new Response().text(licensePlateNumber()), HttpStatus.OK);
    }

    private String licensePlateNumber() {
        StringBuffer stringBuffer = new StringBuffer();

        IntStream randomNumbers = ThreadLocalRandom.current().ints(4, 0,25);
        randomNumbers.forEach(alpha -> stringBuffer.append((char) (UPPER_CASE_A + alpha)));

        randomNumbers = ThreadLocalRandom.current().ints(3, 0,9);
        randomNumbers.forEach(numeric -> stringBuffer.append((char) (NUMERIC_0 + numeric)));

        return stringBuffer.toString();
    }
}
