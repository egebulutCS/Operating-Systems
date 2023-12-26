#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

int main(int argc, char** argv)
{
  int status;
  int return_value;
  char *message;
  int n;

  printf("fork is starting \n");
  return_value = fork();
  switch(return_value)
  {
    case -1:
      perror("fork failed");
      return 1;
    case 0:
      message = "This is the child";
      n = 5;
      break;
    default:
       wait(&status);
      message = "This is the parent";
      n = 2;
      break;
  }
  
  for(; n > 0; n--) {
    printf(" %s\n", message);
    sleep(1);
  }
  return 0;
}
