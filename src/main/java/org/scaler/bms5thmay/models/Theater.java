package org.scaler.bms5thmay.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theater extends BaseClass{
    private String name;
    @ManyToOne
    private Region region;

    @OneToMany
    private List<Screen> screens;

    private TheaterType theaterType;
}
