package funciones_20170823_115532;

import entidades.*;
import funciones.*;
import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FContratoTest {

    public FContratoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

@Test
    public void testobtener() throws Exception {
        System.out.println("obtener");
        String metodo = "obtener";
        String clase = "FContrato";
        Date vinicio = new Date();
        Boolean expResult = true;
        ArrayList<Contrato> result = null;
        try {
            result = FContrato.obtener();
        } catch (Exception e) {
        result = null;
        }
        Boolean res = false;
        if (result != null) {
            res = true;
        } else {
            res = false;
        }
        assertEquals(expResult, res);
        Date vfinal = new Date();
        long duracion = Util.DiferenciaFechas(vinicio, vfinal);
        
        Util.exportar(clase, metodo, duracion);
    }
@Test
    public void testinsertar() throws Exception {
        System.out.println("insertar");
        String metodo = "insertar";
        String clase = "FContrato";
        Date vinicio = new Date();
      Contrato param1 = new Contrato();
        Boolean expResult = true;
        int result = 0;
        try {
            result = FContrato.insertar(param1);
        } catch (Exception e) {
        result = 0;
        }
        Boolean res = false;
        if (result == 0) {
            res = true;
        } else {
            res = false;
        }
        assertEquals(expResult, res);
        Date vfinal = new Date();
       long duracion = Util.DiferenciaFechas(vinicio, vfinal); //este es el hora
        Util.exportar(clase, metodo, duracion);
    }}
