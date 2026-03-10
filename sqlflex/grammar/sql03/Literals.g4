
lexer grammar Literals;

import Alphabet, Symbol;

IDENTIFIER_
    : [A-Za-z_$0-9\u0080-\uFFFF]*?[A-Za-z_$\u0080-\uFFFF]+?[A-Za-z_$0-9\u0080-\uFFFF]*
    |  DQ_ ~'"'+ DQ_
    | DQ_TOKEN
    // | '<MASK_' [0-9]+ '>'
    // | '<PAREN_' [0-9]+ '>'
    ;

MASK_TOKEN
    : '<MASK_' [0-9]+ '>'
    ;

PAREN_TOKEN
    : '<PAREN_' [0-9]+ '>'
    ;

SQ_TOKEN
    : '##SQ_' [0-9]+ '##'
    ;

DQ_TOKEN
    : '##DQ_' [0-9]+ '##'
    ;
STRING_ 
    : (SQ_ ('\\'. | '\'\'' | ~('\'' | '\\'))* SQ_)
    ;

NUMBER_
    : INT_? DOT_? INT_ (E (PLUS_ | MINUS_)? INT_)?
    ;

HEX_DIGIT_
    : '0x' HEX_+ | 'X' SQ_ HEX_+ SQ_
    ;

BIT_NUM_
    : '0b' ('0' | '1')+ | B SQ_ ('0' | '1')+ SQ_
    ;

fragment INT_
    : [0-9]+
    ;

fragment HEX_
    : [0-9a-fA-F]
    ;
