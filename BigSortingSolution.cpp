#include <vector>
#include <iostream>
#include <algorithm>
#include <string>
#include <math.h>
#include <regex>

bool compareBySizeAndValue(const std::string& a, const std::string& b);
void createArray(int n);
void display(std::vector<std::string> unsorted);
bool isPositive(const std::string& s);
bool rightLength(const std::string& s);

//
// The main function.
int main(){
    int n;
    std::cin >> n;
    
    if (n >= 1 && n <= (2 * pow(10.0, 5.0))) createArray(n);
    
    return 0;
}

//
// This function allows the user to input data
// into the vector of positive integers.
void createArray(int n)
{
    std::vector<std::string> unsorted;
    
    std::string temp;
    for(int i = 0; i < n; i++) {
        std::cin >> temp;
        if (isPositive(temp) && rightLength(temp)) unsorted.push_back(temp);
        temp.clear();
    }
    
    std::sort(unsorted.begin(), unsorted.end(), compareBySizeAndValue);
    
    display(unsorted);
}

//
// This function iterates through the vector of positive integers.
void display(std::vector<std::string> unsorted)
{
    for(std::vector<std::string>::iterator it = unsorted.begin(); it != unsorted.end(); it++)
    {
        std::cout << *it << std::endl;
    }
}

//
// This boolean function is a predicate that is used
// by the std::sort function. It takes two std::strings
// as arguments. If the two strings are of the same length,
// then the function verifies which one is the smallest.
bool compareBySizeAndValue(const std::string &a, const std::string &b)
{
    return a.size() == b.size() ? a < b : a.size() < b.size();
}

//
// This boolean function makes sure that each string respects 
// this coding challenge's constraint about the length. The latter
// must be inclusively between 1 and 10 to the power of 6.
bool rightLength(const std::string& s) { return s.length() >= 1 && s.length() <= pow(10.0, 6.0); }

//
// This function makes sure that the std::string does not have
// one or many leading zeroes. Secondly, it makes sure that
// the std::string does not have a minus sign anywhere.
bool isPositive(const std::string& s) {
	return    !std::regex_search(s, std::regex("-")) &&
		      !std::regex_match(s, std::regex("0*"));
}
