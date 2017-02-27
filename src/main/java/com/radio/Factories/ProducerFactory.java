package com.radio.Factories;

import com.radio.Models.Producer;

public interface ProducerFactory extends FactoryGeneric<Producer,Integer>{

    public boolean removeAdmin(Integer id);

}
