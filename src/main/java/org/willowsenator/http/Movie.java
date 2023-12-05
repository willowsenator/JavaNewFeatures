package org.willowsenator.http;

import java.time.LocalDate;

public record Movie(
        Double movie_id,
        String name,
        Integer year,

        String cast,
        LocalDate release_date
    )
{

}
