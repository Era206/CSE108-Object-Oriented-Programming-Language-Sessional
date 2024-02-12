#include <iostream>
#include <cstdlib>
using namespace std;

class Queue
{
    Array s;
    int size;
    int front;
    int rear;
    // you are not allowed to add any field; you can only add methods
public:
    // your code
    Queue()
    {
        s.setLength(0);
        size = 0;
        front = 0;
        rear = 0;
    }
    Queue(int n)
    {
        s.setLength(n);
        size = n;
        front = 0;
        rear = 0;
    }
    int isFull()
    {
        if(size==rear) return 1;
        else return 0;
    }
    int isEmpty()
    {
        if(front == rear) return 1;
        else return 0;
    }

    void enqueue(int x)
    {
        if(isFull())
        {
            cout << "Queue is full" << endl;
            exit(0);
        }
        // your code
        s.setLength(size);
        s.setElementAt(rear, x);
        rear++;

    }
    int dequeue()
    {
        if(isEmpty())
        {
            cout << "Queue is empty" << endl;
            exit(0);
        }
        // your code
        return s.getElementAt(front++);
    }
    void clone(Queue x)
    {
        size= x.size;
        front = x.front;
        rear = x.rear;
            s=x.s;
    }
    // your code
};
