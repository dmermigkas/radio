package com.radio.Factories;

import com.radio.Models.Show;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public interface ShowFactory extends FactoryGeneric<Show,Integer>{

    List<Show> getShowsByDate(Long yesterday,Long now);

}
