package cl.previred.ms.dates.facade;

import cl.previred.ms.dates.domain.MissingDatesDto;

/**
 *
 * @author Franklin Conde / franklinpqn@gmail.com
 */
public interface GDDService {

    MissingDatesDto findMissingDates();

}