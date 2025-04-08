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

public static void createProductsFile(int cantidadProductos) {
        ensureDataFolderExists();
        String fileName = DATA_FOLDER + "productos.csv";

        List<String> nombresProductos = Arrays.asList(
                "Shampoo", "Acondicionador", "Crema Facial", "Perfume", "Esmalte",
                "Labial", "Serum Facial", "Gel", "Loción", "Mascarilla"
        );

        if (cantidadProductos > nombresProductos.size()) {
            System.out.println("Error: La cantidad de productos solicitada excede los nombres disponibles.");
            return;
        }

        Collections.shuffle(nombresProductos);
        Random random = new Random();
        Set<String> idsGenerados = new HashSet<>();

        try (FileWriter writer = new FileWriter(fileName)) {
            for (int i = 0; i < cantidadProductos; i++) {
                String idProducto;
                do {
                    idProducto = "P" + (10000 + random.nextInt(90000));
                } while (!idsGenerados.add(idProducto));

                String nombreProducto = nombresProductos.get(i);
                int precio = 5000 + random.nextInt(995000);

                writer.write(idProducto + ";" + nombreProducto + ";" + precio + "\n");
            }
            System.out.println("productos.csv generado.");
        } catch (IOException e) {
            System.out.println("Error al generar productos.csv: " + e.getMessage());
        }
    }

