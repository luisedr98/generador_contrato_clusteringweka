/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import funciones.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 *
 * @author Admin
 */
public class Ejecutable {
    
    public static void main(String[] args) {
        //ingresar ruta de la carpeta de pruebas generado
        String direccionTest="C:\\Users\\Luiz\\Documents\\NetBeansProjects\\CONTRATO-matriz\\test\\funciones_20170823_115532";
        //extraer paquete name
        String[] split=direccionTest.split("\\\\");
        String paquete=split[split.length-1];
        //Lectura de los test
        List<String> test=leerTest(direccionTest);
        //Creación de la suite de pruebas
        crearSuite(test, paquete);
        
    }
    
    public static List<String> leerTest(String path){
        List<String> test=new ArrayList<>();
        try{
            File f=new File(path);
            if(f.exists()){
                File[] archivos=f.listFiles();
                for(File archivo:archivos){
                    int n=archivo.getName().length();
                    test.add(archivo.getName().substring(0,n-5));
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return test;
    }
    
    public static void crearSuite(List<String> test,String paquete){
        String nombreArchivo=System.getProperty("user.dir")+"\\test\\funciones\\SuiteExample.java";
        /*
        File f=new File(nombreArchivo);
        if(f.exists()){
            f.delete();
        }*/
        
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo));
            // Escribimos los casos de prueba
     
            bw.write("package funciones;\n"
                    + "import org.junit.runner.RunWith;\n"
                    + "import org.junit.runners.Suite;\n"
                    + "import org.junit.runners.Suite.SuiteClasses;\n"
                    + "import "+paquete+".*;\n"
                    + "@RunWith(Suite.class)\n"
                    + "@SuiteClasses({\n");
            //listado de tests
           for(int i=0;i<test.size();i++){
               bw.write(test.get(i)+".class");
               if(i!=test.size()-1){
                   bw.write(",\n");
               }
           }
                    
                  bw.write("})\n"
                    + "public class SuiteExample {}");//capturar nombre de la carpeta

            // Hay que cerrar el fichero
            bw.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
