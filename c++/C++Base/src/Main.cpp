//============================================================================
// Name        : C++Base.cpp
// Author      : hamlin
// Version     :
// Copyright   : hamlin
// Description : Hello World in C++, Ansi-style
//============================================================================

#include "algorithms/Algorithms.h"
#include "basis/Base.h"

int main() {
    // Test the virtual method
    Base* base = new Sub();
    delete base;
    return 0;
}
