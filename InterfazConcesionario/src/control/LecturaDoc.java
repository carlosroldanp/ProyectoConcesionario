package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Lectura del documento csv
 * 
 * @author Carlos
 *
 */
public class LecturaDoc {

	public static List<String> lectura(String fichero) {

		List<String> listaFilas = new ArrayList<>();

		Path entrada = Paths.get(fichero);
		Charset charset = StandardCharsets.UTF_8;

		BufferedReader reader = null;
		try {

			reader = Files.newBufferedReader(entrada, charset);
			String linea = null;

			while ((linea = reader.readLine()) != null) {
				listaFilas.add(linea);
			}

		} catch (IOException io) {
			System.err.println(io);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException io) {
					System.err.println(io);
				}
			}
		}
		return listaFilas;
	}
}
