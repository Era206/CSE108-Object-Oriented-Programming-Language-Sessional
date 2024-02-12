#include <iostream>
#include <cstdlib>
using namespace std;

class Stack
{
    Array s;
    int size;
    int top;
    // you are not allowed to add any field; you can only add methods
public:
    // your code
    Stack()
    {
        top=0;
        size=0;
        s.setLength(0);
    }
    Stack(int n)
    {
        top=0;
        size = n;
        s.setLength(n);
    }
    int isFull()
    {
        if(size==top)
            return 1;
        else return 0;
    }
    int isEmpty()
    {
        if(top==0)
            return 1;
        else return 0;
    }
    void push(int x)
    {
        if(isFull())
        {
            cout << "Stack is full" << endl;
            exit(0);
        }
        // your code
        s.setLength(size);
        s.setElementAt(top, x);
        top++;

    }
    int pop()
    {
        if(isEmpty())
        {
            cout << "Stack is empty" << endl;
            exit(0);
        }
        // your code
        top--;
         return s.getElementAt(top);
    }
    // your code
    void clone(Stack a)
    {
        size = a.size;
        top = a.top;
        s.setLength(size);
        for(int i=0, j= top-1; i<size, j>=0;i++, j--){
            s.setElementAt(i, a.s.getElementAt(j));
        }
    }
};
