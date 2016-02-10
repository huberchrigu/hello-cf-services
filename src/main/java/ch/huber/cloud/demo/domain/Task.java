package ch.huber.cloud.demo.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author christoph.huber
 */
@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String title;

    private String description;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
