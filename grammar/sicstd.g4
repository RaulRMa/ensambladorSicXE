grammar sicstd;
options{
    language = Java;
}
@parser::header{
    package sintaxis;
    import java.util.*;
}
@lexer::header{
    package sintaxis;
}

@parser::members{
    public ArrayList<Instruccion> listaInstrucciones = new ArrayList<>();
    public ArrayList<Simbolo> listaSimbolos = new ArrayList<>();
}

programa: start
    instruccion*
end;


start:
    SIMBOLO? START
    (
     NUMERO
        {
            listaInstrucciones.add(new Instruccion("Start",$NUMERO.text,$SIMBOLO.text, "Start"));
        }
     |
     HEXADECIMAL
        {
            listaInstrucciones.add(new Instruccion("Start",$HEXADECIMAL.text,$SIMBOLO.text, "Start"));
        }
     ) FIN_INSTRUCCION
;

end:
    END SIMBOLO?
    {listaInstrucciones.add(new Instruccion("END",$SIMBOLO.text));}
;

instruccion:
    inst_f1 FIN_INSTRUCCION
    |
    inst_f2 FIN_INSTRUCCION
    |
    inst_f3 FIN_INSTRUCCION
    |
    inst_f4 FIN_INSTRUCCION
    |
    directiva FIN_INSTRUCCION
;

inst_f1:
    SIMBOLO? INSF1
    {
        listaInstrucciones.add(new Instruccion("INSF1","",$SIMBOLO.text,$INSF1.text));
    }
;

inst_f2:
    SIMBOLO? INSF2 t1=(REGISTRO | X) COMA t2=(REGISTRO | X)
    {listaInstrucciones.add(new Instruccion("INSF2",$t1.text + "," + $t2.text,$SIMBOLO.text,$INSF2.text));}
    |
    SIMBOLO? CLEAR t1 = (REGISTRO | X)
    {listaInstrucciones.add(new Instruccion("INSF2",$t1.text,$SIMBOLO.text,$CLEAR.text));}
    |
    SIMBOLO? SHIFT t1=(REGISTRO | X) COMA NUMERO
    {listaInstrucciones.add(new Instruccion("INSF2",$t1.text,$SIMBOLO.text,$SHIFT.text));}
    |
    SIMBOLO? SVC NUMERO
    {listaInstrucciones.add(new Instruccion("INSF2",$NUMERO.text,$SIMBOLO.text,$SVC.text));}
;



inst_f3:
    simple
    |
    indirecto
    |
    inmediato
    |
    RSUB
    {
        listaInstrucciones.add(new Instruccion("INSF3","","","RSUB"));
    }
;

inst_f4:
    SIMBOLO? MAS(INSF3)
    (
        expresion
        |
        direccion COMA X
        {
            Instruccion inst = new Instruccion("INSF4",(String)$direccion.value + ", X",$SIMBOLO.text,$INSF3.text);
            inst.setF4(true);
            inst.setTipo("simple");
            inst.setIndexado(true);
            listaInstrucciones.add(inst);
        }
        |
        ARROBA(expresion)
        {
            Instruccion inst = new Instruccion("INSF4",(String)$expresion.value,$SIMBOLO.text,$INSF3.text);
            inst.setF4(true);
            inst.setTipo("indirecto");
            listaInstrucciones.add(inst);
        }
        |
        SHARP(expresion)
        {
             Instruccion inst = new Instruccion("INSF4",(String)$expresion.value,$SIMBOLO.text,$INSF3.text);
             inst.setF4(true);
             inst.setTipo("inmediato");
             listaInstrucciones.add(inst);
        }
    )

;

directiva:
    t1 = (SIMBOLO | HEXADECIMAL)?
    (
    DIRECTIVA (expresion)
    {
        Instruccion inst = new Instruccion($DIRECTIVA.text,$expresion.value,$t1.text);
        listaInstrucciones.add(inst);
    }
    |
    BYTE
        (
            C COMILLA SIMBOLO COMILLA
            {
                listaInstrucciones.add(new Instruccion("BYTEC",$SIMBOLO.text,$t1.text));
            }
            |
            X COMILLA t2=(HEXADECIMAL | NUMERO) COMILLA
            {listaInstrucciones.add(new Instruccion("BYTEX",$t2.text,$t1.text));}
        )
    |
    BASE SIMBOLO
    {listaInstrucciones.add(new Instruccion("BASE",$SIMBOLO.text));}
    |
    dir_equ
    {listaInstrucciones.add(new Instruccion("EQU",$dir_equ.value,$t1.text));}
    |
    dir_org
    {listaInstrucciones.add(new Instruccion("ORG",$dir_org.value,$t1.text));}
    )
;

direccion returns [Object value]:
    HEXADECIMAL {$value = $HEXADECIMAL.text;}
    | NUMERO {$value = $NUMERO.text;}
    | SIMBOLO {$value = $SIMBOLO.text;}
;
simple:
    SIMBOLO? INSF3
    (   expresion
        {
            Instruccion inst = new Instruccion("INSF3",(String)$expresion.value,$SIMBOLO.text,$INSF3.text);
            inst.setF4(false);
            inst.setTipo("simple");
            listaInstrucciones.add(inst);
        }
        |
        (termino) COMA X
        {
           Instruccion inst = new Instruccion("INSF3",$termino.value + ", X" ,$SIMBOLO.text,$INSF3.text);
           inst.setF4(false);
           inst.setTipo("simple");
           listaInstrucciones.add(inst);
        }
    )
;
indirecto returns [Object value]:
    SIMBOLO? INSF3
    (
        ARROBA expresion
        {
          Instruccion inst = new Instruccion("INSF3",(String)$expresion.value,$SIMBOLO.text,$INSF3.text);
          inst.setF4(false);
          inst.setTipo("indirecto");
          listaInstrucciones.add(inst);
        }
    )
;
inmediato returns [Object value]:
    SIMBOLO? INSF3
    (
        SHARP expresion
        {
          Instruccion inst = new Instruccion("INSF3",(String)$expresion.value,$SIMBOLO.text,$INSF3.text);
          inst.setF4(false);
          inst.setTipo("inmediato");
          listaInstrucciones.add(inst);
        }
    )
;

termino returns [String value]:
     PAR_A expresion PAR_C {$value = $PAR_A.text +  $expresion.value + $PAR_C.text;}
     |
     HEXADECIMAL {$value = $HEXADECIMAL.text;}
     | NUMERO {$value = $NUMERO.text;}
     | SIMBOLO {$value = $SIMBOLO.text;}
;
dir_equ returns [String value]:
    EQU expresion
    { $value = (String) $expresion.value;}
    |
    EQU POR { $value = $POR.text; }
;
dir_org returns [String value]:
    ORG t1=(NUMERO | HEXADECIMAL)
    {$value = $t1.text; }
;
division returns [String value]:
    t1 = termino (ENTRE t2 = termino)* {
        try {
            $value = $t1.value + "/" + $t2.value;
        }catch (NullPointerException e){
            $value = $t1.value;
        }
    }
;
resta returns [String value]:
    t1 = division (MENOS t2 = division)*
    {
        try {
            $value = $t1.value + "-" + $t2.value;
        }catch (NullPointerException e){
            $value = $t1.value;
        }
    }
;
factor returns [String value]:
    t1 = resta (POR t2 = resta)*
    {

        try {
            $value = $t1.value + "*" + $t2.value;

        }catch (NullPointerException e){
                $value = $t1.value;
        }
    }
;
expresion returns [String value]:
    t3=MENOS? (t1 = factor (MAS t2 =factor)*)
    {
        try {
            $value =$t3.text != null ? "-" + $t1.value : $t1.value + "+" + $t2.value;
        }catch (NullPointerException e){
            $value = $t3.text != null ? "-" + $t1.value :  $t1.value;
        }
    }
;

termino_ar returns [Object value]:
     PAR_A expresion_ar PAR_C {$value = $expresion_ar.value;}
     |
     HEXADECIMAL {$value = $HEXADECIMAL.text;}
     | NUMERO {$value = Integer.parseInt($NUMERO.text);}
     | SIMBOLO {$value = $SIMBOLO.text;}
;

division_ar returns [Object value]:
    t1 = termino_ar {$value = (int)$t1.value;}(ENTRE t2 = termino_ar
    {
        $value = (int)$t1.value  /  (int)$t2.value;
    })*
;
resta_ar returns [Object value]:
    t1 = division_ar {$value = (int)$t1.value;}(MENOS t2 = division_ar {
    $value = (int)$t1.value  -  (int)$t2.value;})*
;
factor_ar returns [Object value]:
    t1 = resta_ar {$value = $t1.value;}(POR t2 = resta_ar
    {$value = (int)$t1.value  *  (int)$t2.value;})*
;
expresion_ar returns [Object value]:
    t3 = MENOS? (t1 = factor_ar {$value = $t3.text != null ? - (int)$t1.value : (int)$t1.value;}
    (MAS t2 =factor_ar{$value = $t3.text != null ? - (int)$t1.value  +  (int)$t2.value : (int)$t1.value  +  (int)$t2.value;})*)
;


//FIN_INS: '\n';
START: 'START';
END: 'END';
COMA:',';
SHARP: '#';
ARROBA: '@';
H: ('H'|'h');
MAS: '+';
MENOS: '-';
POR: '*';
ENTRE: '/';
PAR_A: '(';
PAR_C: ')';
BYTE: 'BYTE';
BASE: 'BASE';
EQU: 'EQU';
ORG: 'ORG';
X: 'X';
C:'C';
CLEAR:'CLEAR';
REGISTRO: (X|'L'|'A'|'B'|'S'|'T'|'F');
DIRECTIVA: ('WORD'|'RESB'|'RESW');
INSF1:('FIX'|'FLOAT'|'HIO'|'SIO'|'TIO');
INSF2:('ADDR'|'COMPR'|'DIVR'|'MULR'|
'SUBR'|'TIXR');
SHIFT: ('SHIFTL'|'SHIFTR');
SVC: 'SVC';
INSF3:('ADD'|'ADDF'|'AND'|
         'COMP'|'COMPF'|'DIV'|'DIVF'|
         'J'|'JEQ'|'JGT'|'JLT'|'JSUB'|'LDA'|'LDB'|'LDCH'|
         'LDF'|'LDL'|'LDS'|'LDT'|'LDX'|'LPS'|'MUL'|
         'MULF'|'NORM'|'OR'|'RD'|'RMO'|
         'SSK'|'STA'|'STB'|'STCH'|'STF'|'TIX'|'STL'|'TD'|'STX' | 'WD');

RSUB: 'RSUB';
FIN_INSTRUCCION: '\n';
COMILLA: ['];
NUMERO:[0-9]+;
HEXADECIMAL: [A-F0-9]+H;
SIMBOLO: [a-zA-Z0-9]+;

EB  :   [\t\r]+ -> skip;