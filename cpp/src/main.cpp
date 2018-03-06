//
// Created by John Seol on 3/6/18.
//

#include "main.h"

#include <iostream>
#include <map>
#include <string>
#include <fstream>


using std::cin;
using std::cout;
using std::endl;
using std::string;
using std::map;



int main(int argc, char * argv[]) {
    std::ifstream file("https://gist.githubusercontent.com/nicknytko/70004f44176a92d11612f62318ddb830"
                               "/raw/5b684a9e15c9e6cbf2cc031c5a489b328f259908/17921-0.txt");
    string content;
    while(file >> content) {
        cout << content << ' ';
    }
    return 0;
}