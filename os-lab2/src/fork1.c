#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>

int main(int argc, char** argv)
{
  int x=100;
  int return_value = 0;
  printf("Hello \n\n");

  return_value = fork();

  printf("bye\n");
  printf("x=%d\n", x);
  printf("return_value = %d\n",return_value);
  printf("process id= %d\n\n\n",getpid());

  return 0;
}
