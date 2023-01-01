%{
	#include <stdio.h>
	#include <stdlib.h>
	void yyerror(char *msg);
	extern int val[];
%}
%token NUM ID
%%
SS: SS S
  | S
  ;
S : A ';'		{printf ("Answer of expression is %d\n",$1); }
A : ID '=' A		{val[$1]=$3;printf("A=%d val[]=%d\n",$3,val[$1]); $$=$3;}
  | E			{$$=$1;}
    ;
E : E '+' T		{$$ = $1 + $3;}
  | E '-' T		{$$ = $1 - $3;}
  | T			{$$ = $1;}										
  ;
T : T '*' F		{$$ = $1 * $3;}
  | T '/' F		{$$ = $1 / $3;}
  | F			{$$ = $1;}
  ;
F : NUM		{$$ = $1;}
  | ID 		{printf("A=%d\n",val[$1]);$$= val[$1];}
  | '(' E ')'		{$$ = $2;}
  ;
%%
void yyerror(char *msg)
{
	printf("%s\n",msg);
}
int main()
{

yyparse();
return 0;
}
