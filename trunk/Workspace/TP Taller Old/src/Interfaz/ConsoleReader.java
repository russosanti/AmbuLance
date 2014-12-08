package Interfaz;

import java.util.*;
import java.io.*;

public class ConsoleReader{
   private BufferedReader ingreso;

   public ConsoleReader() {
      super();
      try {
         ingreso = new BufferedReader(new InputStreamReader(System.in));
      }
      catch (Exception e) {
         e.printStackTrace();
      }
   }

   public ArrayList<String> getInput() {
      ArrayList<String> res = new ArrayList<String>();
      try {
         System.out.print(">");
         String lin = ingreso.readLine();
         Scanner sLin = new Scanner(lin).useDelimiter("[ \t\n\f\r]+");
         while (sLin.hasNext()) {
            String tok = sLin.next();
            res.add(tok);
         }
      }
      catch (Exception e){
         e.printStackTrace();
      }
      return res;
   }
}
