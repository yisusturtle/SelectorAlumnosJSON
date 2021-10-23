
package jesus;

//Clases
import java.io.*;
import org.json.JSONArray;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author jesus
 */
public class selectorDeAlumnosFinal {
    public static void main(String[] args) throws FileNotFoundException {
        //Buscamos el archivo json
        String rutaArchivo = new String("alumnos_classroom.json");
        File file = new File(rutaArchivo);
        
        try {
            //Leemos el archivo y lo metemos en un String
            String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
            //Sacamos el array que nos interesa
            JSONArray jArray = new JSONArray(content);
            JSONArray jArray2 = jArray.getJSONArray(0);
            JSONArray jArray3 = jArray2.getJSONArray(0);
            JSONArray jArray4 = jArray3.getJSONArray(2);
            
            //Incializo un random
            Random random = new Random();
            int numeroAleatorio = random.nextInt(jArray4.length()); //Numero aleatorio segun el numero de elementos del array
            
            JSONArray alumnoAleatorio = jArray4.getJSONArray(numeroAleatorio); //alumnoAleatorio.get(1) para obtener el nombre
            
            int menuSacarAlguien = JOptionPane.showConfirmDialog(null,"¿Quieres sacar a alguien?","Elige una opcion...",JOptionPane.YES_NO_OPTION);
            
            boolean archivoAlumnos = true;
            
            if(menuSacarAlguien == 0){ //Pregunta: ¿Sacar a alguien?
                int menuAlmacenarDatos = JOptionPane.showConfirmDialog(null,"¿Quieres sacar almacenar los datos en un archivo CSV?","Elige una opcion...",JOptionPane.YES_NO_OPTION);
                    
                    if(menuAlmacenarDatos == 0){ //Pregunta: ¿Almacenar los datos?
                            //Compruebo si el archivo ya existe o no
                            try{ 
                                File nombreArchivoLectura = new File("AlumnosProgramacion1DAW.csv");
                                FileReader lecturaArchivo = new FileReader(nombreArchivoLectura);
                                BufferedReader bufferLectura = new BufferedReader(lecturaArchivo);
                                JOptionPane.showMessageDialog(null, "Se va a escribir el en archivo 'AlumnosProgramacion1DAW.csv'");

                            }catch(IOException e){
                                archivoAlumnos = false;
                            }

                            if(archivoAlumnos == false){
                                //En el caso de que no exista lo creamos
                                try{ 
                                    File nombreArchivo = new File("AlumnosProgramacion1DAW.csv");
                                    FileWriter archivoEscribir = new FileWriter(nombreArchivo);
                                    BufferedWriter bufferArchivo = new BufferedWriter(archivoEscribir);
                                    JOptionPane.showMessageDialog(null, "Se ha creado el archivo 'AlumnosProgramacion1DAW.csv'");

                                }catch(IOException e){
                                    archivoAlumnos = true;
                                }
                            }
                            
                    } else{
                        //Hacer el programa sin almacenar los datos
                    }
                    
            } else{
                JOptionPane.showMessageDialog(null, "CERRANDO APLICACIÓN...");  
                
            }
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
