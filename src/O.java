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
   System.out.println("\n Компилятор языка О");
   if( args.length == 0 )
      Location.Path = null;
   else
      Location.Path = args[0];
   Init();         //инициализация
   Pars.Compile(); //компиляция
   OVM.Run();      //выполнение
   Done();         //завершение
}

}