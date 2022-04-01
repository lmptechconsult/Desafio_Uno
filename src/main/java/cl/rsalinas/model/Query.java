package cl.rsalinas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Validated
public class Query {
    @JsonProperty("id")
    private Long id = null;

    @JsonProperty("fechaCreacion")
    private LocalDate creationDate = null;

    @JsonProperty("fechaFin")
    private LocalDate endDate = null;

    @JsonProperty("fechas")
    @Valid
    private List<LocalDate> dates = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<LocalDate> getDates() {
        return dates;
    }

    public void setDates(List<LocalDate> dates) {
        this.dates = dates;
    }

    @Override
    public String toString() {
        return "Query{" +
                "id=" + id +
                ", fechaCreacion=" + creationDate +
                ", fechaFin=" + endDate +
                ", fechas=" + dates +
                '}';
    }
}
