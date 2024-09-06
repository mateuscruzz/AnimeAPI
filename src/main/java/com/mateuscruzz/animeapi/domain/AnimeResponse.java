package com.mateuscruzz.animeapi.domain;


import lombok.Data;

import java.util.List;

@Data
public class AnimeResponse{
    private List<Anime> data;
}
