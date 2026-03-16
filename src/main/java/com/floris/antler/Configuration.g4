grammar Configuration;

@parser::header { package com.floris.antler; }
@lexer::header { package com.floris.antler; }

properties: property+;
property: ID '=' value;
value: INT | STRING;

ID: [a-zA-Z]+;
STRING: '"' .*? '"';
INT: [0-9]+;
WS: [ \t\r\n]+ -> skip;