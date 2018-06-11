#include "main.h"

#include <iostream>
#include <map>
#include <string>
#include <fstream>
#include <sstream>
#include <vector>
#include <algorithm>
#include <array>

using std::cin;
using std::cout;
using std::endl;
using std::string;
using std::map;
using std::vector;

std::string parseContent(string content);

std::vector<string> contentToVector(string &content);

std::map<string, int> countFrequencies(std::vector<string> &wordsVector);

/**
 * gets contents of the file by line by using ifstream
 * and then prints each word and its frequency
 */
int main(int argc, char * argv[]) {
    std::ifstream file("/Users/johnseol/CLionProjects/frequencycount-jseol073/cpp/text.txt");
    string content;
    string line;

    while(std::getline(file, line)) {
        content += line;
        content.push_back('\n');
    }

    std::transform(content.begin(), content.end(), content.begin(), ::tolower); //lowercases content
    string output = parseContent(content);
    std::vector<string> wordVector = contentToVector(output);
    string wordsOfVector;

    for (auto word : wordVector) {
        wordsOfVector += word + ", ";
    }

    std::map<string, int> frequencyMap = countFrequencies(wordVector);
    cout <<  wordsOfVector << endl;
    return 0;
}

/**
 * takes contents and removes certain characters as defined by specialChars array
 * @param content, string of the contents of the text file
 * @return a string without those characters
 */
std::string parseContent(string content) {
    const int charArrLength = 13;
    char specialChars[charArrLength] = {'#', '-', '[', ']', ',', '.', '(', ')', '@', '_', ';', '*', ':'};

    for (char i = 0; i < charArrLength; i++) {
        std::replace(content.begin(), content.end(), specialChars[i], ' ');
    }

    std::remove_if(content.begin(), content.end(), &isdigit); //removes all digits
    return content;
}

/**
 * splits the content by whitespaces and returns a vector<string> by that
 * @param content, string of the contents of the text file after parseContent
 * @return a vector<string> in which each element is a word
 */
std::vector<string> contentToVector(string &content) {
    //got code from https://stackoverflow.com/questions/2275135/splitting-a-string-by-whitespace-in-c
    std::istringstream buffer(content);
    std::vector<std::string> wordsVector;

    std::copy(std::istream_iterator<std::string>(buffer),
              std::istream_iterator<std::string>(),
              std::back_inserter(wordsVector));

    for (int wIndex = 0; wIndex < wordsVector.size(); wIndex++) { //removes empty elements
        if (wordsVector.at(wIndex) == "") {
            wordsVector.erase(wordsVector.begin() + wIndex);
        }
    }
    return wordsVector;
}

/**
 * Iterates through contentList and adds the words into the map and adds the frequency
 * by 1 (makes it 1 if its 0) if the same word is encountered
 * @param wordsVector, vector<string> from contentToVector
 * @return a map<string, int> in which the keys are the words from wordsVector
 * and the values are the frequencies of each word
 */
std::map<string, int> countFrequencies(std::vector<string> &wordsVector) {
    map<string, int> frequencyMap;
    for (auto word : wordsVector) {
        int frequencyCount;

        // Got cons_iterator from:
        // http://www.java2s.com/Tutorial/Cpp/0600__STL-Algorithms-Iterator/Findavalueinmapbykey.htm
        map<string, int>::const_iterator freqIterator = frequencyMap.find(word);
        if (freqIterator == frequencyMap.end()) {
            frequencyCount = 0;
        } else {
            frequencyCount = freqIterator -> second;
        }
        if (frequencyCount == 0) {
            frequencyCount = 1;
        } else {
            ++frequencyCount;
        }
        frequencyMap.insert(std::pair<string, int> (word, frequencyCount));
    }
    return frequencyMap;
}