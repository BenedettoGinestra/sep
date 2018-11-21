package world;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
// serve per leggere le stringhe da file
public class Utils {
	
	public static String loadFileAsString(String path){
		StringBuilder builder = new StringBuilder();
		
		try{
                        // leggo caratteri da file
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
                        // leggo la linea finchè non termino il file
			while((line = br.readLine()) != null)
				builder.append(line + "\n"); // leggo matrice e salvo le righe
			// chiudo il file
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return builder.toString();
	}
	// per convertire stringa in intero
	public static int parseInt(String number){
		try{
			return Integer.parseInt(number);
		}catch(NumberFormatException e){
			e.printStackTrace();
			return 0;
		}
	}

}
