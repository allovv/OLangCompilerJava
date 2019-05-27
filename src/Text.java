// Драйвер исходного текста

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class Text {

   static final int  TABSIZE = 3;
   static final char chSPACE = ' ';    // Пробел
   static final char chTAB   = '\t';   // Табуляция
   static final char chEOL   = '\n';   // Конец строки
   static final char chEOT   = '\0';   // Конец текста

   static boolean Ok = false;
   static String Message = "файл не открыт";
   static int Ch = chEOT;

   private static InputStream f;
   static ArrayList<String> textFile = new ArrayList<String>();

   static void NextCh() {
      if (Error.printText) {
         try {
            if( (Ch = f.read()) == -1 )
               Ch = chEOT;
            else if( Ch == '\n' ) {
               OLangGUI.outputTextArea.append("\n");

               //***********************
               if (Pars.genPause) {
                  Gen.Cmd(OVM.cmPause);
               }
               //***********************

               Location.Line++; Location.Pos = 0; Ch = chEOL;
            }
            else if( Ch == '\r' )
               NextCh();
            else if( Ch != '\t' ) {
               OLangGUI.outputTextArea.append(Character.toString((char)Ch));
               Location.Pos++;
            }
            else
               do
                  OLangGUI.outputTextArea.append(" ");
               while( ++Location.Pos % TABSIZE != 0 );
         } catch (IOException e) {};
      } else {
         Ch = chEOT;
      }
   }

   static void Reset() {
      if( Location.Path == null ) {
         OLangGUI.outputTextArea.append("Формат вызова:\n   О <Входной файл>");
         System.exit(1);
         }
      else 
         try {
            f = new FileInputStream(Location.Path);
            Ok = true; Message = "Ok";
            Location.Pos = 0; Location.Line = 1;
            NextCh();
         } catch (IOException e) {
            Ok = false;
            Message = "Входной файл не найден";
         }
   }

   static void Close() {
      try {
         f.close();
      } catch (IOException e) {};
   }

   static void GetProgrammText() {
      try (BufferedReader reader = new BufferedReader(
              new InputStreamReader(
                      new FileInputStream("Primes.o"), StandardCharsets.UTF_8))){
         String line;
         while ((line = reader.readLine()) != null) {
            textFile.add(line);
         }
      } catch (IOException e) {
         OLangGUI.outputTextArea.append("ERROR!");
         // log error
      }
   }

}
