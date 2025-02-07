package org.liubov.ai_aggregator.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "image_request")
@Data
public class ImageRequest {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Setter(value = AccessLevel.PRIVATE)
    private Long id;

    @Column(nullable = false)
    private Long imageDialogId;

    @Column(nullable = false)
    private String text;

    @CreationTimestamp
    private LocalDateTime createdOn;
}
