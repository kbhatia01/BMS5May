package org.scaler.bms5thmay.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Region extends BaseClass{
    private String name;

//    private List<Theater> theaters;
}

// TODO: read about MappedBy