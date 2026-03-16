grammar Expressions;

@parser::header { package com.floris.antler; }
@lexer::header { package com.floris.antler; }

expressions : expr+ ;

expr   : term (PLUS term)* | MIN term (MIN term)* ;
term   : factor ((MULT | DIV) factor)* ;
factor : INT
       | LPAREN expr RPAREN
       ;

MIN    : '-' ;
PLUS   : '+' ;
MULT   : '*' ;
DIV    : '/' ;
LPAREN : '(' ;
RPAREN : ')' ;
INT    : [0-9]+ ;
WS     : [ \t\r\n]+ -> skip ;