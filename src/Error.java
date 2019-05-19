//Обработка ошибок

import java.io.*;

class Error {

static void Message(String Msg) {
   int ELine = Location.Line;
   while( Text.Ch != Text.chEOL && Text.Ch != Text.chEOT )
      Text.NextCh();
   if( Text.Ch == Text.chEOT ) System.out.println();
   for( int i = 1; i < Location.LexPos; i++ )
      System.out.print(' ');
   System.out.println("^");
   System.out.println(
      "(��ப� " + ELine + ") �訡��: " + Msg
   );
   System.out.println();
   System.out.print("������ ����");
   try{ while( System.in.read() != '\n' ); }
   catch (IOException e) {};
   System.exit(0);
}

static void Expected(String Msg) {
   Message("Ожидается: " + Msg);
}

static void Warning(String Msg) {
   System.out.println();
   System.out.println("Предупреждение: " + Msg);
}

}
