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
    SIMBOLO? INSF2 (REGISTRO | X) COMA (REGISTRO | X)
    {listaInstrucciones.add(new Instruccion("INSF2","",$SIMBOLO.text,$INSF2.text));}
    |
    SIMBOLO? CLEAR (REGISTRO | X)
    {listaInstrucciones.add(new Instruccion("INSF2","",$SIMBOLO.text,$CLEAR.text));}
    |
    SIMBOLO? SHIFT (REGISTRO | X) COMA NUMERO
    {listaInstrucciones.add(new Instruccion("INSF2","",$SIMBOLO.text,$SHIFT.text));}
    |
    SIMBOLO? SVC NUMERO
    {listaInstrucciones.add(new Instruccion("INSF2",$NUMERO.text,$SIMBOLO.text,$SVC.text));}
;

op_insf2 returns [String value]:
    REGISTRO {$value = $REGISTRO.text;}
    | X {$value = $X.text;}
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
        direccion
        {
            Instruccion inst = new Instruccion("INSF4",(String)$direccion.value,$SIMBOLO.text,$INSF3.text);
            inst.setF4(true);
            inst.setTipo("simple");
            listaInstrucciones.add(inst);
        }
        |
        direccion COMA X
        {
            Instruccion inst = new Instruccion("INSF4",(String)$direccion.value + ", X",$SIMBOLO.text,$INSF3.text);
            inst.setF4(true);
            inst.setTipo("simple");
            listaInstrucciones.add(inst);
        }
        |
        ARROBA(direccion)
        {
            Instruccion inst = new Instruccion("INSF4",(String)$direccion.value,$SIMBOLO.text,$INSF3.text);
            inst.setF4(true);
            inst.setTipo("indirecto");
            listaInstrucciones.add(inst);
        }
        |
        SHARP(direccion)
        {
            Instruccion inst = new Instruccion("INSF4",(String)$direccion.value,$SIMBOLO.text,$INSF3.text);
            inst.setF4(true);
            inst.setTipo("inmediato");
            listaInstrucciones.add(inst);
        }
    )

;

directiva:
    SIMBOLO?
    (
    DIRECTIVA (NUMERO {listaInstrucciones.add(new Instruccion($DIRECTIVA.text,$NUMERO.text,$SIMBOLO.text));}
        | HEXADECIMAL {listaInstrucciones.add(new Instruccion($DIRECTIVA.text,$HEXADECIMAL.text,$SIMBOLO.text));})
    |
    BYTE
        (
            C COMILLA SIMBOLO COMILLA
            {
                listaInstrucciones.add(new Instruccion("BYTEC",$SIMBOLO.text,"C"));
            }
            |
            X COMILLA HEXADECIMAL COMILLA
            {listaInstrucciones.add(new Instruccion("BYTEX",$HEXADECIMAL.text,"X"));}
        )
    |
    BASE SIMBOLO
    {listaInstrucciones.add(new Instruccion("BASE",$SIMBOLO.text));}
    )

;

direccion returns [Object value]:
    HEXADECIMAL {$value = $HEXADECIMAL.text;}
    | NUMERO {$value = $NUMERO.text;}
    | SIMBOLO {$value = $SIMBOLO.text;}
;
simple:
    SIMBOLO? INSF3
    (   NUMERO
        {
            Instruccion inst = new Instruccion("INSF3",$NUMERO.text,$SIMBOLO.text,$INSF3.text);
            inst.setTipo("simple");
            inst.setConstante(true);
            listaInstrucciones.add(inst);
        }
        |
        direccion {
            Instruccion inst = new Instruccion("INSF3",(String)$direccion.value,$SIMBOLO.text,$INSF3.text);
            inst.setTipo("simple");
            listaInstrucciones.add(inst);
        }
        |
        (NUMERO {
                Instruccion inst = new Instruccion("INSF3",$NUMERO.text + ",X",$SIMBOLO.text,$INSF3.text);
                inst.setTipo("simple");
                inst.setConstante(true);
                listaInstrucciones.add(inst);
            }
        | direccion {
                Instruccion inst = new Instruccion("INSF3",(String)$direccion.value + ",X",$SIMBOLO.text,$INSF3.text);
                inst.setTipo("simple");
                inst.setIndexado(true);
                listaInstrucciones.add(inst);
            }) COMA X
    )
;
indirecto returns [Object value]:
    SIMBOLO? INSF3
    (
        ARROBA NUMERO
        {
            Instruccion inst = new Instruccion("INSF3",$NUMERO.text,$SIMBOLO.text,$INSF3.text);
            inst.setTipo("indirecto");
            inst.setConstante(true);
            listaInstrucciones.add(inst);}
        |
        ARROBA direccion
        {
            Instruccion inst = new Instruccion("INSF3",(String)$direccion.value,$SIMBOLO.text,$INSF3.text);
            inst.setTipo("indirecto");
            listaInstrucciones.add(inst);}
    )
;
inmediato returns [Object value]:
    SIMBOLO? INSF3
    (
        SHARP NUMERO
        {
            Instruccion inst = new Instruccion("INSF3",$NUMERO.text,$SIMBOLO.text,$INSF3.text);
            inst.setTipo("inmediato");
            inst.setConstante(true);
            listaInstrucciones.add(inst);}
        |
        SHARP direccion
        {
            Instruccion inst = new Instruccion("INSF3",(String)$direccion.value,$SIMBOLO.text,$INSF3.text);
            inst.setTipo("inmediato");
            listaInstrucciones.add(inst);}
    )
;

//FIN_INS: '\n';
START: 'START';
END: 'END';
COMA:',';
SHARP: '#';
ARROBA: '@';
H: ('H'|'h');
MAS: '+';
BYTE: 'BYTE';
BASE: 'BASE';
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
HEXADECIMAL: [A-F0-9]+(H)*;
SIMBOLO: [a-zA-Z0-9]+;

EB  :   [\t\r]+ -> skip;