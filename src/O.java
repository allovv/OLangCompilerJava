// Язык "О"
public class O {

static void Init() {
   Text.Reset();
   if( !Text.Ok )
      Error.Message(Text.Message);
   Scan.Init();
   Gen.Init();
}

static void Done() {
   Text.Close();
}

public static void main(String[] args) {
   OLangGUI.outputTextArea.append("\n Компилятор языка О" + "\n");
   if( args.length == 0 )
      Location.Path = null;
   else
      Location.Path = args[0];

   //*******************************
   Text.GetProgrammText();
   OLangGUI OGUI = new OLangGUI();

   OGUI.createGUI();
   OGUI.outputTextProgramm();
   //*******************************
}

}
