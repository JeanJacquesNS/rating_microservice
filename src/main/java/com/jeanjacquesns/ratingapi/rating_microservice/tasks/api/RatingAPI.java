package com.jeanjacquesns.ratingapi.rating_microservice.tasks.api;

import com.jeanjacquesns.ratingapi.rating_microservice.tasks.dto.RatingDTO;
import com.jeanjacquesns.ratingapi.rating_microservice.tasks.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Jean Jacques N. Shimwa
 * @created 04-01-2023 - 11:55 AM
 */
@RestController
@RequestMapping("/ratings")
public class RatingAPI {
    @Autowired
    private RatingService ratingService;

    @GetMapping
    public List<RatingDTO> findRatingsByBookId(
            @RequestParam(required = false, defaultValue = "0") Long bookId) {
        if (bookId.equals(0L)) {
            return ratingService.findAllRatings();
        }
        return ratingService.findRatingsByBookId(bookId);
    }

    @PostMapping
    public RatingDTO createRating(@RequestBody RatingDTO rating) {
        return ratingService.createRating(rating);
    }

    @DeleteMapping("/{ratingId}")
    public void deleteRating(@PathVariable Long ratingId) {
        ratingService.deleteRating(ratingId);
    }

    @PutMapping("/{ratingId}")
    public RatingDTO updateRating(@RequestBody RatingDTO rating, @PathVariable Long ratingId) {
        return ratingService.updateRating(rating, ratingId);
    }

    @PatchMapping("/{ratingId}")
    public RatingDTO updateRating(
            @RequestBody Map<String, String> updates,
            @PathVariable Long ratingId) {
        return ratingService.updateRating(updates, ratingId);
    }
}
