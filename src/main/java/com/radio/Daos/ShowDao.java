package com.radio.Daos;

import com.radio.Models.Show;

import javax.persistence.EntityManager;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public interface ShowDao extends DaoGeneric<Show,Integer>{

    List<Show> getTodaysShows(EntityManager em, Long yesterday,Long now);

    List<Show> getShowsByDate(EntityManager em, Long from,Long to);

}
