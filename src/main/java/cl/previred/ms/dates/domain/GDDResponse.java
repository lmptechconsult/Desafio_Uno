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
public class GDDResponse {

    private Long id;
    private LocalDate fechaCreacion;
    private LocalDate fechaFin;
    private List<LocalDate> fechas;

}