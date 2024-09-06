package com.mateuscruzz.animeapi.domain;

import lombok.Data;

@Data
public class Pagination {
    private int last_visible_page;
    private boolean has_next_page;

}
