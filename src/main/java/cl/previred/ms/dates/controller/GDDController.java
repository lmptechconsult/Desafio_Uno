package cl.previred.ms.dates.controller;

import cl.previred.ms.dates.domain.MissingDatesDto;
import cl.previred.ms.dates.facade.GDDService;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Franklin Conde / franklinpqn@gmail.com
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/gdd")
public class GDDController {

    private static final Logger logger = LoggerFactory.getLogger(GDDController.class.getSimpleName());

    private final GDDService gddService;

    @GetMapping(value = "/dates")
    public ResponseEntity<MissingDatesDto> findMissingDates() {
        logger.info("Get missing dates in the controller");
        return ResponseEntity.ok(gddService.findMissingDates());
    }

}