package com.radio;

import com.radio.Models.*;
import com.radio.Daos.*;

public class Main {

    public static void main(String[] args) {

        Producer prod = new Producer(new MusicTrackDao(), "dimitris", "mermigkas", new EmailAddress("ddsadasds"));
        MusicTrackDao dao = prod.getDao();

    }

}