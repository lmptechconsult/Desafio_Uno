package cl.rsalinas.controller;

import cl.rsalinas.model.Query;
import cl.rsalinas.model.Response;
import cl.rsalinas.service.MissingPeriods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LostPeriodController {

    Logger log = LoggerFactory.getLogger(LostPeriodController.class);

    @Autowired
    private MissingPeriods missingPeriods;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/periodosFaltantes",produces = { "application/json" },method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Response> responseChallenge(){
        ResponseEntity<Query> query = restTemplate
                .getForEntity("http://localhost:8080/periodos/api", Query.class);
        return new ResponseEntity<>(missingPeriods.setLostPeriods(query.getBody()), HttpStatus.OK);
    }
}
