package com.johncnstn.data.dto;

import lombok.Getter;
import lombok.Setter;

public class TourDto {

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private String date;

    @Setter
    @Getter
    private long countryId;
    @Setter
    @Getter
    private long tourId;
}
