%{
#include "prac7.tab.h"
%}
alpha [A-Za-z]
digit [0-9]
%%
("++"|"--") {return UN;}
("int"|"float"|"char"|"double"|"struct"|"do"|"printf"|"return") {return KEYWORD;}
("if") {return IF;}
("else") {return ELSE;}
("for") {return FOR;}
("while"){return WHILE;}
{digit}+ {return NUM;}
{alpha}({alpha}|{digit})* {return ID;}
("{") {return OPEN;}
("}") {return CLOSE;}
(">") {return GT;}
("<") {return LT;}
(">=") {return GTE;}
("<=") {return LTE;}
("!=") {return NTE;}
("==") {return EQ;}
("=") {return AS;}
(";") {return SC;}
("(") {return OPENP;}
(")") {return CLOSEP;}
%%
int yywrap(){
return 0;
}
