grammar evaluador;

expresion returns [Object value]:
    t4 = MENOS?
    (   t1= factor {$value = $t4.text != null ? - (int)$t1.value : (int)$t1.value; }
        ( MAS t2= factor
            {$value = $t4.text != null ? - (int)$value + (int)$t2.value : (int)$value + (int)$t2.value; }
            |
          MENOS t3= factor
            {$value = $t4.text != null ? - (int)$value - (int)$t3.value : (int)$value - (int)$t3.value; }
        )*
    )
;

factor returns [Object value]:
    t1 = termino { $value = (int)$t1.value;}
    ( MULT t2=termino{$value = (int)$value * (int)$t2.value; }
       |
      DIV t3=termino{$value = (int)$value / (int)$t3.value; }
    )*
;

termino returns [Object value]:
    PAR_INI expresion PAR_FIN {$value = $expresion.value; }
    |
    NUMERO { $value = Integer.parseInt($NUMERO.text); }
;

print:
    expresion
    {
        System.out.println($expresion.value);
    }
;

MAS: '+';
MENOS: '-';
MULT: '*';
DIV: '/';
PAR_INI: '(';
PAR_FIN:')';
NUMERO: [0-9]+;
EB  :   [\t\r]+ -> skip;