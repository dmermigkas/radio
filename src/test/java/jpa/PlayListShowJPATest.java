package jpa;

import com.radio.Factories.FactoryGeneric;
import com.radio.Initializer;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by lotv on 28/02/2017.
 */
public class PlayListShowJPATest {
    Initializer dataHelper;
    FactoryGeneric playListShowDao;

    @Before
    public void setUpJPA(){
        dataHelper = new Initializer();
        //dataHelper.eraseData();
        //dataHelper.prepareData();
    }

}
