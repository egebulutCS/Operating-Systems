#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdlib.h>     

int main(void)
{
  int return_value=0;
  
  return_value=fork();
  if(return_value!=0)  // fork() returns new pid to the parent process
  {
    printf("\nParent: Hello, I am the Parent process\n");
    printf("Parent: Here's my PID: %d\n", getpid());
    printf("Parent: The PID returned by fork() is: %d\n\n", return_value);

  }
  else // fork() returns 0 to the child process
  {
    printf("\n\nChild: Hello, I am the Child process\n");
    printf("Child: Here's my PID: %d\n", getpid());
    printf("Child: The PID returned by fork() is: %d\n\n", return_value);
  }
  
  return 0;
}
