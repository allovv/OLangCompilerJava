//Виртуальная машина языка О
import java.io.*;

class OVM {

static final int  MEMSIZE = 8*1024;

static final int
   cmStop   = -1,

   cmAdd    = -2,
   cmSub    = -3,
   cmMult   = -4,
   cmDiv    = -5,
   cmMod    = -6,
   cmNeg    = -7,

   cmLoad   = -8,
   cmSave   = -9,

   cmDup    = -10,
   cmDrop   = -11,
   cmSwap   = -12,
   cmOver   = -13,

   cmGOTO   = -14,
   cmIfEQ   = -15,
   cmIfNE   = -16,
   cmIfLE   = -17,
   cmIfLT   = -18,
   cmIfGE   = -19,
   cmIfGT   = -20,

   cmIn      = -21,
   cmOut     = -22,
   cmOutLn   = -23,

   cmPause   = -100;

static int M[] = new int[MEMSIZE];

static void readln() {
   try { while( System.in.read() != '\n' ); }
   catch (IOException e) {};
}

private static StreamTokenizer input = 
   new StreamTokenizer(new InputStreamReader(System.in));  

static int ReadInt() {
   try{ input.nextToken(); } catch (IOException e) {};
   return (int)input.nval;
}

static void Run() {
   int PC = 0;
   int SP = MEMSIZE;
   int Cmd;
   int Buf;
   
   loop: for (;;)
      if ( (Cmd = M[PC++]) >= 0 )
         M[--SP] = Cmd;
      else
         switch( Cmd ) {
         case cmAdd:
            SP++; M[SP] += M[SP-1];
            break;
         case cmSub:
            SP++; M[SP] -= M[SP-1];
            break;
         case cmMult:
            SP++; M[SP] *= M[SP-1];
            break;
         case cmDiv:
            SP++; M[SP] /= M[SP-1];
            break;
         case cmMod:
            SP++; M[SP] %= M[SP-1];
            break;
         case cmNeg:
            M[SP] = -M[SP];
            break;
         case cmLoad:
            M[SP] = M[M[SP]];
            break;
         case cmSave:
            M[M[SP+1]] = M[SP];
            SP += 2;
            break;
         case cmDup:
            SP--; M[SP] = M[SP+1];
            break;
         case cmDrop:
            SP++;
            break;
         case cmSwap:
            Buf = M[SP]; M[SP] = M[SP+1]; M[SP+1] = Buf;
            break;
         case cmOver:
            SP--; M[SP] = M[SP+2];
            break;
         case cmGOTO:
            PC = M[SP++];
            break;
         case cmIfEQ:
            if ( M[SP+2] == M[SP+1] )
               PC = M[SP];
            SP += 3;
            break;
         case cmIfNE:
            if ( M[SP+2] != M[SP+1] )
               PC = M[SP];
            SP += 3;
            break;
         case cmIfLE:
            if ( M[SP+2] <= M[SP+1] )
               PC = M[SP];
            SP += 3;
            break;
         case cmIfLT:
            if ( M[SP+2] < M[SP+1] )
               PC = M[SP];
            SP += 3;
            break;
         case cmIfGE:
            if ( M[SP+2] >= M[SP+1] )
               PC = M[SP];
            SP += 3;
            break;
         case cmIfGT:
            if ( M[SP+2] > M[SP+1] )
               PC = M[SP];
            SP += 3;
            break;
         case cmIn:
            System.out.print('?');
            M[--SP] = ReadInt();
            break;
         case cmOut:
            int w = M[SP] - (new Integer(M[SP+1])).
               toString().length();
            for( int i = 1; i <= w; i++ )
               System.out.print(" ");
            System.out.print(M[SP+1]);
            SP += 2;
            break;
         case cmOutLn:
            System.out.println();
            break;
         case cmStop:
            break loop;

            //*******************
         case cmPause:
            break;
            //*******************

         default:
            System.out.println("OVM: Недопустимый код операции");
            break loop;
         }
   System.out.println();
   if( SP < MEMSIZE )
      System.out.println("Код возврата " + M[SP]);
   System.out.print("Выполнено успешно");
   readln();
}

static void ShowCode() {
   OLangGUI.outputTextArea.append("\n");
   OLangGUI.outputTextArea.append("\n");
   OLangGUI.outputTextArea.append("****************************************" + "\n");
   for (int i = 0; i < Gen.PC; i++) {
      OLangGUI.outputTextArea.append(i + ")");
      switch (M[i]) {
         case cmStop:
            OLangGUI.outputTextArea.append("Stop!" + "\n");
            break;
         case cmAdd:
            OLangGUI.outputTextArea.append("Add" + "\n");
            break;
         case cmSub:
            OLangGUI.outputTextArea.append("Sub" + "\n");
            break;
         case cmMult:
            OLangGUI.outputTextArea.append("Mult" + "\n");
            break;
         case cmDiv:
            OLangGUI.outputTextArea.append("Div" + "\n");
            break;
         case cmMod:
            OLangGUI.outputTextArea.append("Mod" + "\n");
            break;
         case cmNeg:
            OLangGUI.outputTextArea.append("Neg" + "\n");
            break;
         case cmLoad:
            OLangGUI.outputTextArea.append("Load" + "\n");
            break;
         case cmSave:
            OLangGUI.outputTextArea.append("Save" + "\n");
            break;
         case cmDup:
            OLangGUI.outputTextArea.append("Dup" + "\n");
            break;
         case cmDrop:
            OLangGUI.outputTextArea.append("Drop" + "\n");
            break;
         case cmSwap:
            OLangGUI.outputTextArea.append("Swap" + "\n");
            break;
         case cmOver:
            OLangGUI.outputTextArea.append("Over" + "\n");
            break;
         case cmGOTO:
            OLangGUI.outputTextArea.append("GOTO" + "\n");
            break;
         case cmIfEQ:
            OLangGUI.outputTextArea.append("IFEQ" + "\n");
            break;
         case cmIfNE:
            OLangGUI.outputTextArea.append("IfNE" + "\n");
            break;
         case cmIfLE:
            OLangGUI.outputTextArea.append("IfLE" + "\n");
            break;
         case cmIfLT:
            OLangGUI.outputTextArea.append("IfLT" + "\n");
            break;
         case cmIfGE:
            OLangGUI.outputTextArea.append("IfGE" + "\n");
            break;
         case cmIfGT:
            OLangGUI.outputTextArea.append("IfGT" + "\n");
            break;
         case cmIn:
            OLangGUI.outputTextArea.append("In" + "\n");
            break;
         case cmOut:
            OLangGUI.outputTextArea.append("Out" + "\n");
            break;
         case cmOutLn:
            OLangGUI.outputTextArea.append("OutLn" + "\n");
            break;
         case cmPause:
            OLangGUI.outputTextArea.append("Pause" + "\n");
            break;
         default:
            OLangGUI.outputTextArea.append(M[i] + "\n");
            break;
      }
   }
   OLangGUI.outputTextArea.append("****************************************" + "\n");
}

}
