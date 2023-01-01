//S -> E + i 
//E -> i * E  
//E -> t 

#include <stdio.h> 
 char ch; 
 int fail = 0; 
 void next(char n)
{
	if (ch == n)
  {
		ch = getchar(); 
  } 
  else {
	  printf("Error");     
	  fail = 1; 
  } 
}  
void next2() { 
	if (ch == 'i') {
		next('i');
		next('*');
		next2(); 
  } else if (ch == 't') {
	  next('t'); 
  } 
}  void start() {
	next2();
	if (ch == '+') {
		next('+'); 
		next('i');
		} else { 
			fail = 1;
			printf("Error"); 
  } 
}  int main() {
	ch = getchar(); 
	start(); 
   if (!fail)
	   printf("Success"); 
} 
