package org.scaler.bms5thmay.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "shows")
public class Show extends BaseClass{

    @ManyToOne
    private Movie movie;
    private Date startTime;
    private Date endTime;
    @ManyToOne
    private Screen screen;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Features> features;
}

/*
1            1
SHOW ====== MOVIE ==> M:1

  M            1


  1             1
  SHOW ------- SCREEN ==> M:1
     M           1
 */


