grammar sicstd; //Encabezado que especifica el nombre de la gramática

options{
    language = Java;
}
@parser::header{
    package sintaxis;
}
@lexer::header{
    package sintaxis;
}

programa: dec_start
    dec_instruccion*
dec_end;

dec_start:
    SIMBOLO EB START EB HEXADECIMAL EB? FIN_INSTRUCCION
    |
    EB START EB HEXADECIMAL EB? FIN_INSTRUCCION;

dec_end:
    EB END EB SIMBOLO
    |
    EB END;

dec_instruccion:
    SIMBOLO EB INSTRUCCION EB cod_op EB? FIN_INSTRUCCION // Instrucción de formato 3 con símbolo
    |
    EB INSTRUCCION EB cod_op EB? FIN_INSTRUCCION // Instrucción de formato 3 sin símbolo
    |
    SIMBOLO EB MAS INSTRUCCION EB cod_op EB? FIN_INSTRUCCION //Instrucción de formato 4 con simbolo
    |
    EB MAS INSTRUCCION EB cod_op EB? FIN_INSTRUCCION // Instrucción de formato 4 sin símbolo
    |
    f1
    |
    dec_directiva
;

dec_directiva:
    SIMBOLO EB DIRECTIVA EB valor_o_numero EB? FIN_INSTRUCCION
    |
    EB DIRECTIVA EB valor_o_numero EB? FIN_INSTRUCCION
    |
    dec_byte
    |
    dec_base
;

cod_op:
    f2
    |
    f3_4
;

f1:
 EB INSTRUCCION EB? FIN_INSTRUCCION
 |
 SIMBOLO EB INSTRUCCION EB? FIN_INSTRUCCION
;
f2:
    REGISTRO COMA REGISTRO | REGISTRO COMA 'X'
    |
    REGISTRO COMA NUMERO
    |
    SIMBOLO COMA REGISTRO
    |
    REGISTRO
;
f3_4:
    f_simple
    |
    f_indirecto
    |
    f_inmediato
;
dir_memoria:
    NUMERO | HEXADECIMAL | SIMBOLO;

f_simple:
    dir_memoria COMA REGISTRO | dir_memoria COMA ('X')
    |
    NUMERO
    |
    dir_memoria
;
f_indirecto:
    ARROBA NUMERO
    |
    ARROBA dir_memoria
;

f_inmediato:
    SHARP NUMERO
    |
    SHARP dir_memoria
;
valor_o_numero:
    NUMERO | HEXADECIMAL
;
dec_byte:
    SIMBOLO EB BYTE EB 'X' COMILLA (VALOR_HEXADECIMAL | NUMERO) COMILLA FIN_INSTRUCCION
    |
    EB BYTE EB 'X' COMILLA (VALOR_HEXADECIMAL | NUMERO) COMILLA FIN_INSTRUCCION
    |
    SIMBOLO EB BYTE EB 'C' COMILLA (SIMBOLO | NUMERO) COMILLA FIN_INSTRUCCION
    |
    EB BYTE EB 'C' COMILLA (SIMBOLO | NUMERO) COMILLA FIN_INSTRUCCION
;
dec_base:
    EB BASE EB SIMBOLO FIN_INSTRUCCION
;

INSTRUCCION: ('ADD'|'ADDF'|'ADDR'|'AND'|'CLEAR'|
 'COMP'|'COMPF'|'COMPR'|'DIV'|'DIVF'|'DIVR'|
 'FIX'|'FLOAT'|'HIO'|'J'|'JEQ'|'JGT'|'JLT'|'JSUB'|'LDA'|'LDB'|'LDCH'|
 'LDF'|'LDL'|'LDS'|'LDT'|'LDX'|'LPS'|'MUL'|
 'MULF'|'MULR'|'NORM'|'OR'|'RD'|'RMO'|'RSUB'|
 'SHIFTL'|'SHIFTR'|'SIO'|'SSK'|'STA'|'STB'|
 'STCH'|'STF'|'TIX'|'STL'|'TD'|'STX');

DIRECTIVA: ('WORD'|'RESB'|'RESW');
REGISTRO: ('A'|'L'|'X'|'B'|'S'|'T'|'F');
EB: (' '+ | '\t'|'\r'); //Espacios en blanco
BASE: 'BASE';
BYTE: 'BYTE';
START: 'START';
END: 'END';
COMA: ',';
SHARP: '#';
ARROBA: '@';
MAS: '+';
COMILLA: ['];
X: [X];

SIMBOLO: [A-Z]+[A-Z0-9]*;
FIN_INSTRUCCION: '\n';
NUMERO: [0-9]+;
HEXADECIMAL: [0-9]+('h'|'H');
TEXTO: [a-zA-Z]+[a-zA-Z0-9]*;
VALOR_HEXADECIMAL: [A-Z0-9]+;