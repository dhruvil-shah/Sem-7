%{
int lc=0;
%}
%%
("/*"([^*]|\*+[^*/])*\*+"/") {printf("Multiline Comments\n");}
[#].* {printf("Header\n");}
[0-9]+/(";"|","|"\)") {printf("Integer ");}
("int"|"float"|"char"|"double"|"struct"|"if"|"while"|"do"|"printf"|"else"|"return"|"for") {printf(" Keywords ");}
([0-9]+[.][0-9]+) {printf(" Float ");}
([_A-Za-z]([_A-Za-z][0-9])*)+ {printf("Identifier ");}
([0-9]+[a-zA-Z][a-zA-Z0-9]+) {printf("Invalid ");}
([-+\*%]|"++"|"--") {printf(" Arithmetic Operator ");}
(">"|"<"|"=="|">="|"<="|"!=") {printf(" Relational Operator ");}
[=] {printf("Assignment\n");}
([/]{2}).* {printf("Comments\n");}
("\n") {lc++;printf("\t\t\t\t%d\n",lc);}
%%
int yywrap(){}
int main(){
    yylex();
    return 0;
}


