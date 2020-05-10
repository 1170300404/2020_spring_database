
//1、生成1000000个128字节的元组代码：
#include <iostream>
#include <fstream>
#include <ctime>
#include <cstdlib>
using namespace std;

const int N = 1000000;

string RandomChineseCharacters()
{
//srand( (unsigned)time(NULL));
int high = 0xd7 - 0xc1;//16-55区汉字int low= 0xfe - 0xa1;
int high_zn ; int low_zn; char name[3]; name[2] = '\0';

string s;
for(int i = 0; i < 60; i++)
{
high_zn = rand()%high + 0xc1; low_zn = rand()%low + 0xa1; name[0]=high_zn; name[1]=low_zn; s.append(name);
}
return s;
}
int main()
{
ofstream ofp ("example2.txt"); if (!ofp.is_open())
{
cout<<"can't open file!"<<endl; return 0;
}
srand( (unsigned)time(NULL)); int t1 = 0,t2 = 0;//4+
string name;
for(int i = 1;i <= N;i++)
{
t1 = rand(); t2 = i;
name = RandomChineseCharacters();
//cout<<name <<sizeof(t1)<<sizeof(t2)<<name.length()<<endl;

ofp<<t1<<" "<<t2<<" "<<name<<endl;
}

return 0;

}
