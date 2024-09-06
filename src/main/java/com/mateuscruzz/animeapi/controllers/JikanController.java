package com.mateuscruzz.animeapi.controllers;

import com.mateuscruzz.animeapi.domain.AnimeResponse;
import com.mateuscruzz.animeapi.repositories.JikanClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anime")
public class JikanController {

    private final JikanClient jikanClient;

    public JikanController(JikanClient jikanClient) {
        this.jikanClient = jikanClient;
    }
    @GetMapping("/top")
    public ResponseEntity<AnimeResponse> getTopAnime(
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "filter", required = false) String filter,
            @RequestParam(value = "rating", required = false) String rating,
            @RequestParam(value = "sfw", required = false) Boolean sfw,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "limit", required = false) Integer limit
    ) {
        try {
            AnimeResponse response = jikanClient.getTopAnime(type, filter, rating, sfw, page, limit);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<AnimeResponse> searchAnime(
            @RequestParam("title") String title,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "limit", required = false) Integer limit
    ) {
        try {
            AnimeResponse response = jikanClient.searchAnimeByTitle(title, page, limit);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
