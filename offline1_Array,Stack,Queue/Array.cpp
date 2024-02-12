#include <iostream>
#include <cstdlib>
using namespace std;
#define SIZE 100
#define EMPTY -99

class Array
{
    int a[SIZE];
    int length;
    // you are not allowed to add any field; you can only add methods
public:
    // your code
    Array()
    {
        length = 0;
    }
    Array(int size)
    {
        length = size;
        for (int i = 0; i < size; i++)
        {
            a[i] = EMPTY;
        }
    }
    // your code
    Array(int size, int x[])
    {
        length = size;
        for(int i=0;i<size;i++)
        {
            a[i]=x[i];
        }
    }
    Array(int size, int n)
    {
        length = size;
        for(int i=0;i<size;i++)
        {
            a[i]=n;
        }
    }
    void setLength(int size)
    {
        length = size;
    }
    int getLength()
    {
        return length;
    }
    void setElementAt(int i, int e)
    {
        if(i >= length)
        {
            cout << "Invalid Index" << endl;
            exit(0);
        }
        // your code
        a[i]=e;
    }
    int getElementAt(int i)
    {
        if(i >= length)
        {
            cout << "Invalid Index" << endl;
            exit(0);
        }
        // your code
        return a[i];
    }
    void print()
    {
        for(int i =0; i < length; i++)
        {
            cout << a[i] << " ";
        }
        cout << endl;
    }
    // your code

    void clone(Array s)
    {
        length= s.length;
        for(int i=0;i<length;i++){
            a[i]=s.a[i];
        }
    }
};
