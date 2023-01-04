package com.jeanjacquesns.ratingapi.rating_microservice.tasks.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Jean Jacques N. Shimwa
 * @created 04-01-2023 - 11:54 AM
 */
@Setter
@Getter
public class RatingDTO {
    private long id;
    private Long bookId;
    private int stars;
}
