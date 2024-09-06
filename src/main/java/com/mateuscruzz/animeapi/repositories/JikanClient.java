package com.mateuscruzz.animeapi.repositories;

import com.mateuscruzz.animeapi.domain.AnimeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(url = "https://api.jikan.moe/v4", name = "jikanClient")
public interface JikanClient {

    @GetMapping("/top/anime")
    AnimeResponse getTopAnime(
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "filter", required = false) String filter,
            @RequestParam(value = "rating", required = false) String rating,
            @RequestParam(value = "sfw", required = false) Boolean sfw,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "limit", required = false) Integer limit
    );

    @GetMapping("/anime")
    AnimeResponse searchAnimeByTitle(
            @RequestParam("q") String query,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "limit", required = false) Integer limit
    );
}
