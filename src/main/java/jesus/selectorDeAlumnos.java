
package jesus;

//Clases
import java.io.*;
import org.json.JSONArray;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author jesus
 */
public class selectorDeAlumnos {
    public static void main(String[] args) throws FileNotFoundException {
        //Pasear archivo recogido desde google
        String rutaArchivo = new String("alumnos_classroom.json");
        File file = new File(rutaArchivo);
        try {
            String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
            
            JSONArray jArray = new JSONArray(content);
            JSONArray jArray2 = jArray.getJSONArray(0);
            JSONArray jArray3 = jArray2.getJSONArray(0);
            JSONArray jArray4 = jArray3.getJSONArray(2);
            
            for (int i=0;i<jArray4.length();i++){
                JSONArray jArray5 = jArray4.getJSONArray(i);
                System.out.println(jArray5.get(1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
