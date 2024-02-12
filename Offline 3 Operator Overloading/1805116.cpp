#include<bits/stdc++.h>
using namespace std;

void str_rev(char *p)
{
    int i,j;
    for(i=0,j=strlen(p)-1;i<strlen(p)/2;i++,j--)
        swap(p[i],p[j]);
}

class StringMath
{
    char* p;
public:
// Add necessary constructors and destructors and functions
    StringMath()
    {
        p = NULL;
    }
    StringMath(char *p)
    {
        this->p = new char[strlen(p)+1];
        if(p[0]=='-')
        {
            cout << "negative number which is invalid" << endl;
            exit(1);
        }
        else
            strcpy(this->p, p);
    }
    StringMath(const StringMath &s)
    {
        p=new char[strlen(s.p)];
        strcpy(p, s.p);
    }

    char *get_p(){
     return this->p;
    }
    StringMath &operator=(const StringMath &s);
    StringMath operator+(StringMath &s);
    friend StringMath operator+(StringMath &st, int n);
    friend StringMath operator+(int n, StringMath &st);
    bool operator>(StringMath &st);
    bool operator>(int n);
    StringMath operator++(int x);
    ~StringMath(){
        delete []p;
    }
};

StringMath &StringMath::operator=(const StringMath &s)
{
    if(this->p==s.p)
        return *this;
        p = new char[strlen(s.p) +1];
    strcpy(p, s.p);
    return *this;
}

StringMath StringMath:: operator+(StringMath &s)
{
    StringMath tmp;
    int len, b_len, s_len;
    int l=0;
    char temp;

    if(strlen(p)>strlen(s.p)){
        b_len = strlen(p);
        s_len = strlen(s.p);
    }
    else {
         s_len = strlen(p);
        b_len = strlen(s.p);
    }

    tmp.p = new char[b_len+1];
    str_rev(p);
    str_rev(s.p);

    for(int j=0; j<s_len;j++){
            if(l==1) temp = '1';
            else temp = '0';
        if((p[j] + s.p[j]+ temp-'0'-'0')>'9'){
            tmp.p[j] = p[j] + s.p[j] + temp -'0'-'0'-10;
            l=1;
        }
        else{
            tmp.p[j] = p[j] + s.p[j] +temp-'0' -'0';
            l=0;
        }
    }

    for(int i=s_len;i<b_len;i++){
             if(l==1) temp = '1';
            else temp = '0';
        if(strlen(p)==b_len){
             if((p[i] + temp-'0')>'9'){
            tmp.p[i] = p[i] + temp -'0'-10;
            l=1;
        }
        else{
            tmp.p[i] = p[i] + temp -'0';
            l=0;
        }
        }
     else {
             if((s.p[i] + temp-'0')>'9'){
            tmp.p[i] = s.p[i] + temp -'0'-10;
            l=1;
        }
        else{
            tmp.p[i] = s.p[i] + temp -'0';
            l=0;
        }
        }
    }
    if(l!=0){
        tmp.p[b_len]=temp;
        tmp.p[b_len+1]='\0';
    }
    else tmp.p[b_len]='\0';

    str_rev(tmp.p);
    str_rev(p);
    str_rev(s.p);

    return tmp;
}

bool StringMath::operator>(StringMath &st)
{
    int len1 = strlen(this->p), len2 = strlen(st.p);
    if(len1==len2){
        if(strcmp(this->p, st.p)>0)
            return 1;
        else return 0;
    }
    else if(len1>len2)
        return 1;
        else return 0;
}

bool StringMath::operator>(int n)
{
    char *s;
    int len=ceil(log10(n));
    s = new char[len];
    for(int i=len-1;i>=0;i--){
        s[i]=n%10+'0';
        n/=10;
    }
    StringMath temp(s);

    return (*this>temp);

}

StringMath operator+(StringMath &st, int n)
{
    char *s;
    int len=ceil(log10(n));
    s = new char[len];
    for(int i=len-1;i>=0;i--){
        s[i]=n%10+'0';
        n/=10;
    }
    StringMath temp(s);
    StringMath tempo;
    tempo=temp+st;
    return tempo;
}

StringMath operator+(int n, StringMath &st)
{
    char *s;
    int len=ceil(log10(n));
    s = new char[len];
    for(int i=len-1;i>=0;i--){
        s[i]=n%10+'0';
        n/=10;
    }
    StringMath temp(s);
    StringMath tempo;
    tempo=temp+st;
    return tempo;
}

StringMath StringMath::operator++(int x)
{
    StringMath temp("1");
    StringMath tempo(p);
    strcpy(p,(temp+tempo).p);
    return tempo;
}

int main()
{
    StringMath S1;
    StringMath S2("123");
    StringMath S3("757");
    StringMath S4("220");
    StringMath S5;
    int n=345;
    S1=S4;
//Print the character string of S1 and S4
cout << S1.get_p() << endl;
cout << S4.get_p() << endl;

    S1=S2+S3+S4;
    cout << S1.get_p() << endl;
    cout << S2.get_p() << endl;
    cout << S3.get_p() << endl;
    cout << S4.get_p() << endl;
//Print the character string of S1, S2, S3 and S4, where S1 contains the character string: “1100”
    S5=S4=S3;
    cout << S5.get_p() << endl;
    cout << S4.get_p() << endl;
    cout << S3.get_p() << endl;
// Print the character string of S5, S4 and S3
    if(S3 > n )
    {
        S5= S3+n;
    }
    cout << S5.get_p()<<endl;
// Print the character string of S5, where S5 contains the character string: “1102”
    S5= n+S2;
    cout << S5.get_p()<<endl;
// Print the character string of S5, where S5 contains the character string: “468”
   if(S5 > S2)
    {
        S5++; //Assume prefix increment
    }
    cout << S5.get_p() << endl;
// Print the character string of S5, where S5 contains the character string: “469”
}


