//============================================================================
// Name        : Algorithms.cpp
// Author      : hamlin
// Version     :
// Copyright   : hamlin
// Description : Algorithms in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

#define N 10;

/*
 * 直接插入排序
 *
 * 1、基本思想:
 *   假设待排序的记录存放在数组R[1..n]中。初始时，R[1]自成1个有序区，无序区为R[2..n]。
 * 从i=2起直至i=n为止，依次将R[i]插入当前的有序区R[1..i-1]中，生成含n个记录的有序区。
 *
 * 2、第i-1趟直接插入排序：
 *   通常将一个记录R[i](i=2，3，…，n-1)插入到当前的有序区，使得插入后仍保证该区间里的记录是按关键字有序的操作称第i-1趟直接插入排序。
 *   排序过程的某一中间时刻，R被划分成两个子区间R[1．．i-1]（已排好序的有序区）和R[i．．n]（当前未排序的部分，可称无序区）。
 * 直接插入排序的基本操作是将当前无序区的第1个记录R[i]插人到有序区R[1．．i-1]中适当的位置上，使R[1．．i]变为新的有序区。因为这种方法每次使有序区增加1个记录，通常称增量法。
 *   插入排序与打扑克时整理手上的牌非常类似。摸来的第1张牌无须整理，此后每次从桌上的牌(无序区)中摸最上面的1张并插入左手的牌(有序区)中正确的位置上。
 * 为了找到这个正确的位置，须自左向右(或自右向左)将摸来的牌与左手中已有的牌逐一比较。
 */
void insertSort(int data[], int n) {
    int i, j, tmp; //对顺序表R中的记录data[0..n-1]按递增序进行插入排序
    for(i = 1; i < n; i++) { //依次插入data[0],..., data[n-1]中
        if(data[i] < data[i-1]) { //若data[i]大于等于有序区中的所有值, 那么data[i]就在原来的位置
            tmp = data[i];
            j = i-1;
            do { //从右向左在有序区data[0...i-1]中查找data[i]的位置
                data[j+1] = data[j]; //关键字大于data[i]的后移
                j--;
            } while (tmp < data[j] && j >= 0); //若data[j] >= tmp则终止
            data[j+1] = tmp; //data[i]插入到正确的位置上
        } //endif
    }
}

void myInsertSort(int data[], int length) {
    int i = 1;
    int j = i -1;
    for(j; j< length; j++) {
        if(data[i] < data[j]) {
            int tmp;
            do{
                cout << "data[]: " << endl;
                tmp = data[j];
                data[j] = data[i];
                data[i] = tmp;
                i--;
                j = i - 1;
            } while(j-1>= 0 && data[i] < data[j]);
        }
    }
}

void printData(int data[], int n) {
	cout << "data[]: " << endl;
    for(int i = 0; i < n; i++) {
        cout << data[i] << endl;
    }
}

int test() {
    int data[] = {10, 23, 22, 14, 12, 15, 37, 99, 30, 223};
    insertSort(data, 10);
    myInsertSort(data, 10);
    printData(data, 10);
    return 0;
}

