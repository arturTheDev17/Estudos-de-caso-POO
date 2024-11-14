package classesEC6M;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Essa classe-filho de {@link PadraoStation } serve para ser possível instanciar objetos e manipulá-los
 * @author artur_hopner
 */
public class WeatherStation extends PadraoStation {

    public WeatherStation ( ) {

    }

    public WeatherStation ( String nome ) {
        setNome( nome );
    }

}