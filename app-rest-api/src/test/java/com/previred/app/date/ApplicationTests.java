package com.previred.app.date;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.previred.app.date.dto.ResponseDTO;
import com.previred.app.date.exception.InteropException;
import com.previred.app.date.exception.ServicesException;
import com.previred.app.date.service.IProcessService;

import lombok.extern.slf4j.Slf4j;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

/**
 * 
 * @author lmancild
 * @version 1.0.0 
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Slf4j
class ApplicationTests {

	@Autowired
	private IProcessService processService;
	@Value("classpath:INPUT.json")
	private Resource resourceInputJSONFile;
	@Value("classpath:OUTPUT.json")
	private Resource resourceOutputJSONFile;
	@Value("${server.port.test}")
	private int port;
	private MockWebServer mockBackEnd;

    @BeforeEach
    public void setUp() throws IOException {
    	mockBackEnd = new MockWebServer();
    	mockBackEnd.start(port);
    	mockBackEnd.url("http://localhost:" + mockBackEnd.getPort() +  "/periodos/api");
    }
    
    @AfterEach
    public void tearDown() throws IOException {
        mockBackEnd.shutdown();
    }
     
    @Test
    public void testMissingDates() throws URISyntaxException, 
    	IOException, ServicesException, InteropException {
    	log.info("INIT :: testMissingDates");
    	mockBackEnd.enqueue(new MockResponse()
    		      .setBody(FileUtils.readFileToString(resourceInputJSONFile.getFile(), "UTF-8"))
    		      .addHeader("Content-Type", "application/json"));

    	ResponseDTO response = processService.processRequestDate();
        String responseCompareJSON = FileUtils.readFileToString(resourceOutputJSONFile.getFile(), "UTF-8");
        JsonObject o1 = JsonParser.parseString(response.getMissingDatesJSON()).getAsJsonObject();
        JsonObject o2 = JsonParser.parseString(responseCompareJSON).getAsJsonObject();
        assertEquals(o1, o2);
        log.info("END :: testMissingDates");
    }

}
