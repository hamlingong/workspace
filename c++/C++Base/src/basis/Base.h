//============================================================================
// Name        : Algorithms.cpp
// Author      : hamlin
// Version     :
// Copyright   : hamlin
// Description : Algorithms in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

class Base {
    public:
        Base() {
            cout << "===Base()===" << endl;
        }
        virtual ~Base() {
            cout << "===~Base()===" << endl;
        }
};

class Sub : public Base {
    public:
        Sub() {
            cout << "===Sub()===" << endl;
        }
        ~Sub() {
            cout << "===~Sub()===" << endl;
        }
};
