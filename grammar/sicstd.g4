grammar sicstd;
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

programa: dec_start
  dec_instruccion*
dec_end;

dec_start:
  SIMBOLO? START (HEXADECIMAL) H? FIN_INSTRUCCION
  {
    Map<String, Object> mapaStart = new HashMap<String, Object>();
    mapaStart.put("Start", $HEXADECIMAL.text + $H.text);
    lineas.put(linea++,mapaStart);
  }
;

dec_end:
  END SIMBOLO?
  {
    Map<String, Object> mapaStart = new HashMap<String, Object>();
    mapaStart.put("END", $SIMBOLO.text);
    lineas.put(linea++,mapaStart);
  }
;

dec_instruccion:
  dec_f1
    {
      Map<Object, Integer> mapa = new HashMap<Object, Integer>();
      mapa.put($dec_f1.value, 1);
      lineas.put(linea++,mapa);
    }
  | dec_f2
    {
      Map<Object, Integer> mapa = new HashMap<Object, Integer>();
      mapa.put($dec_f2.value, 2);
      lineas.put(linea++,mapa);
    }
  | dec_f3
    {
      Map<Object, Integer> mapa = new HashMap<Object, Integer>();
      mapa.put($dec_f3.value, 3);
      lineas.put(linea++,mapa);
    }
  |dec_f4
    {
      Map<Object, Integer> mapa = new HashMap<Object, Integer>();
      mapa.put($dec_f4.value, 4);
      lineas.put(linea++,mapa);
    }
  | dec_directiva
;

dec_f2 returns [Object value]:
    SIMBOLO? INSF2 REGISTRO COMA REGISTRO FIN_INSTRUCCION
    {$value = $SIMBOLO.text + "," + "F2";}
;

dec_f1 returns [Object value]:
    SIMBOLO? INSF1 FIN_INSTRUCCION
    {$value = $SIMBOLO.text + "," + "F1";}
;

dec_f3 returns [Object value]:
    simple {$value = $simple.value;}
    | indirecto {$value = $indirecto.value;}
    | inmediato {$value = $inmediato.value;}
    |
    SIMBOLO ? 'RSUB' FIN_INSTRUCCION {$value = "F3";}
;



dec_f4 returns [Object value]:
    SIMBOLO? MAS(INSF3) (SIMBOLO | SIMBOLO COMA 'X') FIN_INSTRUCCION
    {$value = $SIMBOLO.text + "," + "F4";}
    |
    SIMBOLO? MAS(INSF3) (ARROBA | SHARP)(SIMBOLO | CONSTANTE) FIN_INSTRUCCION
    {$value = $SIMBOLO.text + "," + "F4";}
;

dec_directiva:
    dec_base | dec_byte | directiva
;

dec_base:
    SIMBOLO? BASE SIMBOLO FIN_INSTRUCCION
    {
      Map<String, Object> mapa = new HashMap<String, Object>();
      mapa.put("Base", $SIMBOLO.text);
      lineas.put(linea++,mapa);
    }
;
 dec_byte:
    SIMBOLO? BYTE C COMILLA valor_byte COMILLA FIN_INSTRUCCION
    {
        Map<String, Object> mapa = new HashMap<String, Object>();
        mapa.put("ByteC", $valor_byte.value);
        lineas.put(linea++,mapa);
    }
    |
    SIMBOLO? BYTE X COMILLA HEXADECIMAL COMILLA FIN_INSTRUCCION
    {
        Map<String, Object> mapa = new HashMap<String, Object>();
        mapa.put("ByteX", $HEXADECIMAL.text);
        lineas.put(linea++,mapa);
    }
 ;

 valor_byte returns [Object value]:
    SIMBOLO {$value = $SIMBOLO.text;}
    |
    HEXADECIMAL {$value = $HEXADECIMAL.text;}
 ;
directiva:
    SIMBOLO? DIRECTIVA CONSTANTE FIN_INSTRUCCION
    {
        Map<String, Object> mapa = new HashMap<String, Object>();
        mapa.put($DIRECTIVA.text, $CONSTANTE.text);
        lineas.put(linea++,mapa);
    }
    |
    SIMBOLO? DIRECTIVA HEXADECIMAL H? FIN_INSTRUCCION
    {
        Map<String, Object> mapa = new HashMap<String, Object>();
        mapa.put($DIRECTIVA.text, $HEXADECIMAL.text);
        lineas.put(linea++,mapa);
    }

;

simple returns [Object value]:
    SIMBOLO? INSF3 (CONSTANTE | SIMBOLO | CONSTANTE COMA 'X' | SIMBOLO COMA 'X' ) FIN_INSTRUCCION
    {$value = "F3";}
;

indirecto returns [Object value]:
    SIMBOLO? INSF3 ARROBA(CONSTANTE | SIMBOLO) FIN_INSTRUCCION
    {$value = "F3";}
;

inmediato returns [Object value]:
    SIMBOLO? INSF3 SHARP(CONSTANTE | SIMBOLO) FIN_INSTRUCCION
    {$value = "F3";}
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
REGISTRO: (X|'L'|'A'|'B'|'S'|'T'|'F');
DIRECTIVA: ('WORD'|'RESB'|'RESW');
INSF1:('FIX'|'FLOAT'|'HIO'|'SIO'|'TIO');
INSF2:('ADDR'|'CLEAR'|'COMPR'|'DIVR'|'MULR'|
'SHIFTL'|'SHIFTR'|'SUBR'|'SVC'|'TIXR');

INSF3:('ADD'|'ADDF'|'AND'|
         'COMP'|'COMPF'|'DIV'|'DIVF'|
         'J'|'JEQ'|'JGT'|'JLT'|'JSUB'|'LDA'|'LDB'|'LDCH'|
         'LDF'|'LDL'|'LDS'|'LDT'|'LDX'|'LPS'|'MUL'|
         'MULF'|'NORM'|'OR'|'RD'|'RMO'|
         'SSK'|'STA'|'STB'|'STCH'|'STF'|'TIX'|'STL'|'TD'|'STX' | 'WD');

COMILLA: ['];
SIMBOLO: [A-Z]+;
HEXADECIMAL: [A-F0-9]+;
CONSTANTE: [0-9]+;
FIN_INSTRUCCION: '\n';
EB  :   [\t\r]+ -> skip ;