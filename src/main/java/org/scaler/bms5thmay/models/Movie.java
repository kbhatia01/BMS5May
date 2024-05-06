package org.scaler.bms5thmay.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity
public class Movie extends  BaseClass{

    private String name;
    private Date releaseDate;
    private float runningTime;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Features> features;
}
