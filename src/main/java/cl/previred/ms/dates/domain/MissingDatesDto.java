package cl.previred.ms.dates.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Franklin Conde / franklinpqn@gmail.com
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class MissingDatesDto {

    private Long id;
    private LocalDate creationDate;
    private LocalDate finalDate;
    private List<LocalDate> dates;
    private List<LocalDate> missingDates;

}