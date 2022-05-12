grammar pruebas;
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
        |
        SHARP(expresion)
    )

;

directiva:
    t1 = (SIMBOLO | HEXADECIMAL)?
    (
    DIRECTIVA (expresion)
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
    )
    |
    dir_equ
;

direccion returns [Object value]:
    HEXADECIMAL {$value = $HEXADECIMAL.text;}
    | NUMERO {$value = $NUMERO.text;}
    | SIMBOLO {$value = $SIMBOLO.text;}
;
simple:
    SIMBOLO? INSF3
    (   expresion
        |
        (termino) COMA X
    )
;
indirecto returns [Object value]:
    SIMBOLO? INSF3
    (
        ARROBA expresion
    )
;
inmediato returns [Object value]:
    SIMBOLO? INSF3
    (
        SHARP expresion
    )
;

termino returns [Object value]:
     PAR_A expresion PAR_C
     |
     HEXADECIMAL {$value = $HEXADECIMAL.text;}
     | NUMERO {$value = $NUMERO.text;}
     | SIMBOLO {$value = $SIMBOLO.text;}
;
dir_equ:
    SIMBOLO EQU direccion
    |
    SIMBOLO EQU POR
;
division:
    termino (ENTRE termino)*
;
resta:
    division (MENOS division)*
;
factor:
    resta (POR resta)*
;
expresion:
    factor (MAS factor)*
    |
    factor (MENOS factor)*
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