package org.liubov.ai_aggregator.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "image_dialog")
@Data
public class ImageDialog {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Setter(value = AccessLevel.PRIVATE)
    private Integer id;
    @Column(nullable = false)
    private Integer userId;
    @CreationTimestamp
    private LocalDateTime createdOn;
}
