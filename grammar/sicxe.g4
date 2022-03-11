grammar sicxe;
options{
    language = Java;
}
@parser::header{
    package sintaxis;
    import java.util.Map;
    import java.util.HashMap;
}
@lexer::header{
    package sintaxis;
}

@parser::members{
    int linea = 0;
    Map<String, Object> tablaSimbolos = new HashMap<String, Object>();
    Map<Integer, Object> lineas = new HashMap<Integer, Object>();
}

programa: start
    instruccion*
end;

start:
    SIMBOLO? START (NUMERO | HEXADECIMAL)
;

end:
    END SIMBOLO?
;

instruccion:
    inst_f1
    |
    inst_f2
    |
    inst_f3
    |
    inst_f4
    |
    directiva
;

inst_f1:
    SIMBOLO? INSF1
;

inst_f2:
    SIMBOLO? INSF2 (REGISTRO | X) COMA (REGISTRO | X)
    |
    SIMBOLO? CLEAR (REGISTRO | X)
    |
    SIMBOLO? SHIFT (REGISTRO | X) COMA NUMERO
    |
    SIMBOLO? SVC NUMERO
;

inst_f3:
    simple | indirecto | inmediato | RSUB
;

inst_f4:
    SIMBOLO? MAS(INSF3)
    (
        direccion
        |
        direccion COMA X
        |
        ARROBA(direccion)
        |
        SHARP(direccion)
    )

;

directiva:
    SIMBOLO?
    (
    DIRECTIVA (NUMERO | HEXADECIMAL)
    |
    BYTE
        (
            C COMILLA SIMBOLO COMILLA
            |
            X COMILLA HEXADECIMAL COMILLA
        )
    |
    BASE SIMBOLO
    )

;

direccion:
    HEXADECIMAL | NUMERO | SIMBOLO
;
simple:
    SIMBOLO? INSF3
    (   NUMERO
        |
        direccion
        |
        (NUMERO | direccion) COMA X
    )
;
indirecto:
    SIMBOLO? INSF3
    (
        ARROBA NUMERO
        |
        ARROBA direccion
    )
;
inmediato:
    SIMBOLO? INSF3
    (
        SHARP NUMERO
        |
        SHARP direccion
    )
;

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

COMILLA: ['];
NUMERO:[0-9]+;
HEXADECIMAL: [A-F0-9]+(H)*;
SIMBOLO: [a-zA-Z0-9]+;

EB  :   [\t\r\n]+ -> skip ;