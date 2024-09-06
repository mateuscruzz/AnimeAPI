package com.mateuscruzz.animeapi.domain;

import lombok.Data;

@Data
public class Anime {

    private int mal_id;
    private String title;
    private String synopsis;
    private String type;
    private String rating;
    private String image_url;
}
