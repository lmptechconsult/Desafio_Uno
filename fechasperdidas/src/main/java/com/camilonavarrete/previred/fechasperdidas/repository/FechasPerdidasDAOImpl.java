package com.camilonavarrete.previred.fechasperdidas.repository;

import com.camilonavarrete.previred.fechasperdidas.model.FechasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FechasPerdidasDAOImpl implements FechasPerdidasDAO{

    private RestTemplate rest = new RestTemplate();
    @Autowired
    private Environment environment;

    public FechasServicio consultarServicio() {
        return rest.getForObject(environment.getProperty("servicio"), FechasServicio.class);

    }

}
