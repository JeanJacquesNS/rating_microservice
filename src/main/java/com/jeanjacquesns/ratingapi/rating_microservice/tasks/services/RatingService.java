package com.jeanjacquesns.ratingapi.rating_microservice.tasks.services;

import com.jeanjacquesns.ratingapi.rating_microservice.tasks.dto.RatingDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Jean Jacques N. Shimwa
 * @created 04-01-2023 - 11:56 AM
 */
@Service
public class RatingService {
    public List<RatingDTO> findAllRatings() {
        return null;
    }

    public List<RatingDTO> findRatingsByBookId(Long bookId) {
        return null;
    }

    public RatingDTO createRating(RatingDTO rating) {
        return null;
    }

    public void deleteRating(Long ratingId) {
    }

    public RatingDTO updateRating(RatingDTO rating, Long ratingId) {
        return null;
    }

    public RatingDTO updateRating(Map<String, String> updates, Long ratingId) {
        return null;
    }
}
