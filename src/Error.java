//Обработка ошибок

import java.io.*;

class Error {

static void Message(String Msg) {
   int ELine = Location.Line;
   while( Text.Ch != Text.chEOL && Text.Ch != Text.chEOT )
      Text.NextCh();
   if( Text.Ch == Text.chEOT ) System.out.println();
   for( int i = 1; i < Location.LexPos; i++ )
      OLangGUI.outputTextArea.append(" ");
   OLangGUI.outputTextArea.append("^\n");
   OLangGUI.outputTextArea.append("(Номер строки: " + ELine + ") Ошибка: " + Msg + "\n");
   OLangGUI.outputTextArea.append("\n");
   OLangGUI.outputTextArea.append("********************");
   try{ while( System.in.read() != '\n' ); }
   catch (IOException e) {};
   System.exit(0);
}

static void Expected(String Msg) {
   Message("Ожидается: " + Msg);
}

static void Warning(String Msg) {
   OLangGUI.outputTextArea.append("\n");
   OLangGUI.outputTextArea.append("Предупреждение: " + Msg + "\n");
}

}
