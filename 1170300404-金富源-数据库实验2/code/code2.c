//2��16����������16·�鲢����Ĵ���
// Extenal_Merge_Sort.cpp : �������̨Ӧ�ó������ڵ㡣
//

#include "stdafx.h"
#include <iostream>
#include <fstream>
#include <ctime>
#include <cstdlib>
#include <string.h>
#include <assert.h>
using namespace std;


typedef struct Data
{
int data; int num;
char name[121];

} Data;
//���ð�����
const int N = 1000000;//��������const int FILE_NUM = 16;//�ļ�����
const int MAX_PART = 62500;//ÿһ���ļ���СFILE *fpreads[FILE_NUM];
const int MIN = -1;	//��Сֵ,�����Ҫ�������ֵ���СֵҪС���������
const int MAX = 9999999; //���ֵ,�����Ҫ�������ֵ����ֵҪ�󣬷������

int result = 0;
int cmp(const void* a, const void *b)
{
if ((*(Data*)a).data > (*(Data *)b).data) return 1;
else if ((*(Data*)a).data < (*(Data *)b).data) return -1;
else
return 0;
}

//��unsort_data.txt�ж�ȡ����

int read_data(FILE *fp, Data *array, int N)
{
int length = 0;
for (int i = 0; i < MAX_PART && (EOF !=
fscanf_s(fp,	"%d	%d	%s\n",	&array[i].data,	&array[i].num,

array[i].name,_countof(array[i].name))); i++)
{
length++;
}
return length;
}



//��data0.txt - data9.txt��10���ļ�FILE* open_file(int count, char *mode)
{
FILE *fpwrite = NULL; char filename[20]; memset(filename, 0, 20);
sprintf_s(filename,20, "data%d.txt", count); fopen_s(&fpwrite,filename, mode); assert(fpwrite != NULL);
return fpwrite;
}

//��data0.txt - data9.txt��10���ļ�д���ź��������void write_data(Data *array, int N, int count)
{
FILE *fpwrite = open_file(count, "w"); int i = 0;
for (i = 0; i < N; i++)
{
fprintf(fpwrite,	"%d	%d	%s\n",	array[i].data,	array[i].num, array[i].name);

}
fprintf(fpwrite, "%d %d %s\n", MAX, array[i - 1].num, array[i-1].name);
//��ÿ���ļ����д��һ�����ֵ����ʾ�ļ�����fclose(fpwrite);
}

//�ڲ����򣬵���16�ο������򣬲���data0.txt - data16.txt��10�������ļ�
void interior_sort(void)
{
clock_t begin = clock(); FILE *fpread = NULL;
fopen_s(&fpread,"unsort_data.txt", "r"); assert(fpread != NULL);

int count = 0;
Data *array = new Data[MAX_PART]; assert(array != NULL);
while (1)
{
memset(array, 0, sizeof(Data)* MAX_PART);
int length = read_data(fpread, array, MAX_PART); if (length == 0)
{
break;
}
qsort(array, length, sizeof(Data), cmp); write_data(array, length, count); count++;

}
delete[] array; fclose(fpread); clock_t end = clock();
cout << "16 times Quick Sort Use Time " << (end - begin) / CLK_TCK
<< "s" << endl;
}

//����
void adjust(int ls[], Data data[], int s)
{
int t = (s + FILE_NUM) / 2; while (t)
{
if (data[s].data > data[ls[t]].data)
{
int temp = s; s = ls[t]; ls[t] = temp;
}
t /= 2;
}
ls[0] = s;
}

void create_loser_tree(int ls[], Data data[])
{
data[FILE_NUM].data = MIN;
for (int i = 0; i < FILE_NUM; i++)

{
ls[i] = FILE_NUM;
}
for (int i = FILE_NUM - 1; i >= 0; i--)
{
adjust(ls, data, i);
}
}

void merge_sort_by_losertree()
{
clock_t begin = clock();
FILE *fpreads[FILE_NUM];	//10���ļ���������
Data data[FILE_NUM + 1];	//10���ļ���10����ǰ��С����int ls[FILE_NUM];	//��Ű��������Ľڵ�
int index;
FILE *fpwrite = NULL; fopen_s(&fpwrite,"sort_data_by_losertree.txt", "w"); assert(fpwrite != NULL);

for (int i = 0; i < FILE_NUM; i++)
{
fpreads[i] = open_file(i, "r");
}
for (int i = 0; i < FILE_NUM; i++)
{
fscanf_s(fpreads[i],	"%d	%d	%s\n",	&data[i].data,	&data[i].num, data[i].name,_countof(data[i].name));
}


create_loser_tree(ls, data); //����������while (data[ls[0]].data != MAX)
{
index = ls[0];
fprintf(fpwrite,	"%d	%d	%s\n",	data[index].data,	data[index].num, data[index].name);
result++;//���������Ƿ�ȫ�����ꡣ
fscanf_s(fpreads[index],	"%d	%d	%s\n",	&data[index].data, &data[index].num, data[index].name, _countof(data[index].name));
adjust(ls, data, index);
}
for (int i = 0; i < FILE_NUM; i++)
{
fclose(fpreads[i]);
}
fclose(fpwrite); clock_t end = clock();
cout << "16 Path Merge Sort Use Time :" << (end - begin) / CLK_TCK
<< "s" << endl;
}


int _tmain(int argc, _TCHAR* argv[])
{
interior_sort(); merge_sort_by_losertree();
cout << "Merged Data:" << result << endl; getchar();

return 0;
}
