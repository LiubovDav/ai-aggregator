package org.liubov.ai_aggregator.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "image_response")
@Data
public class ImageResponse {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Setter(value = AccessLevel.PRIVATE)
    private Integer id;
    @Column(nullable = false)
    private Integer imageDialogId;
    @Column(nullable = false)
    private Integer imageRequestId;
    @Column(nullable = false)
    // todo: modify the type
    private String image;
    @CreationTimestamp
    private LocalDateTime createdOn;
}
