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
   for (int i = 0; i < Gen.PC; i++) {
      System.out.print(i + ")");
      switch (M[i]) {
         case cmStop:
            System.out.println("Stop");
            break;
         case cmAdd:
            System.out.println("Add");
            break;
         case cmSub:
            System.out.println("Sub");
            break;
         case cmMult:
            System.out.println("Mult");
            break;
         case cmDiv:
            System.out.println("Div");
            break;
         case cmMod:
            System.out.println("Mod");
            break;
         case cmNeg:
            System.out.println("Neg");
            break;
         case cmLoad:
            System.out.println("Load");
            break;
         case cmSave:
            System.out.println("Save");
            break;
         case cmDup:
            System.out.println("Dup");
            break;
         case cmDrop:
            System.out.println("Drop");
            break;
         case cmSwap:
            System.out.println("Swap");
            break;
         case cmOver:
            System.out.println("Over");
            break;
         case cmGOTO:
            System.out.println("GOTO");
            break;
         case cmIfEQ:
            System.out.println("IFEQ");
            break;
         case cmIfNE:
            System.out.println("IfNE");
            break;
         case cmIfLE:
            System.out.println("IfLE");
            break;
         case cmIfLT:
            System.out.println("IfLT");
            break;
         case cmIfGE:
            System.out.println("IfGE");
            break;
         case cmIfGT:
            System.out.println("IfGT");
            break;
         case cmIn:
            System.out.println("In");
            break;
         case cmOut:
            System.out.println("Out");
            break;
         case cmOutLn:
            System.out.println("OutLn");
            break;
         case cmPause:
            System.out.println("Pause");
            break;
         default:
            System.out.println(M[i]);
            break;
      }
   }
}

}
