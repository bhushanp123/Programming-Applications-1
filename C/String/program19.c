//Accept the string from user and toggle that string 

#include<stdio.h>

void strtoggleX(char str[])
{
    while(*str != '\0')
    {
        if((*str >= 'A') && (*str <= 'Z'))
        {
            *str = *str + 32;
        }
        else if((*str >= 'a') && (*str <= 'z'))
        {
            *str = *str - 32;
        }
        str++;
    }
}

int main()
{
    char Arr[20];

    printf("Enter string: \n");
    scanf("%[^'\n']s",Arr);

    strtoggleX(Arr);
    printf("String after toggle : %s ",Arr);

    return 0;
}
