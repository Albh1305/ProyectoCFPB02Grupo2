import java.io.*;
import java.util.*;

public class GenerateInfoFiles {
    private static final String DATA_FOLDER = "datos/";

    private static void ensureDataFolderExists() {
        File folder = new File(DATA_FOLDER);
        if (!folder.exists() && !folder.mkdir()) {
            System.out.println("Error: No se pudo crear la carpeta 'datos'.");
        }
    }

