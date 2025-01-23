package org.liubov.ai_aggregator.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "image_service")
@Data
public class ImageService {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Setter(value = AccessLevel.PRIVATE)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private boolean active;
    @CreationTimestamp
    private LocalDateTime createdOn;
}
