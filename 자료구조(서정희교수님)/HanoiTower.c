#include <stdio.h>

int Fild[3][4] = {{4,3,2,1},{NULL},{NULL}};
void Move(char from,char to);
void View();
void hanoi_tower(int n, char from, char tmp, char to);


int main()
{
   hanoi_tower(4,'A','B','C');
   return 0;
}

void hanoi_tower(int n, char from, char tmp, char to)
{

   if (n==1)
   {
      printf("원판1을%c에서 %c으로 옮긴다.\n",from,to);
      Move(from,to);
      View();
   }
   else
   {
      hanoi_tower(n-1,from,to,tmp);
      printf("원판%d을 %c에서 %c으로 옮긴다.\n",n,from,to);
      Move(from,to);
      View();
      hanoi_tower(n-1,tmp,from,to);
   }
}

void Move(char from,char to)
{
	int x = 3, y = 0, a, b;
	if (from == 'A') {
		while (Fild[0][x] == NULL) {
			x = x - 1;
		}
		a = Fild[0][x];
		Fild[0][x] = NULL;
	}
	else if (from == 'B') {
		while (Fild[1][x] == NULL) {
			x = x - 1;
		}
		a = Fild[1][x];
		Fild[1][x] = NULL;
	}
	else if (from == 'C') {
		while (Fild[2][x] == NULL) {
			x = x - 1;
		}
		a = Fild[2][x];
		Fild[2][x] = NULL;
	}

	if (to == 'A') {
		while (Fild[0][y] != NULL) {
			y = y + 1;
		}
		Fild[0][y] = a;
	}
	else if (to == 'B') {
		while (Fild[1][y] != NULL) {
			y = y + 1;
		}
		Fild[1][y] = a;
	}
	else if (to == 'C') {
		while (Fild[2][y] != NULL) {
			y = y + 1;
		}
		Fild[2][y] = a;
	}
   
}

void View()
{
   int a,b;
   printf("\n");
   for(a = 3; a >= 0; a--)
   {
      for (b = 0; b < 3; b++)
	  {  
         if (Fild[b][a] != 0)
            printf("\t%d\t",Fild[b][a]);
         else
            printf("\t \t");
      }
      puts("");
   }
   puts("──────────────────────────────────────────────");
   printf("\tA \t\tB \t\tC \n");
   printf("\n");
   printf("\n");
}