#include<iostream>
#include<vector>
#include<unordered_set>
using namespace std;

vector<vector<string>> res;
vector<string> path;
int minL = 0;

bool check(string s1, string s2) {
    int flag = 0;
    for (int i = 0; i < s1.length(); i++) {
        if (s1[i] != s2[i]) {
            flag++;
            if (flag > 1) {
                return false;
            }
        }
    }
    if (flag == 0) {
        return false;
    }
    return true;
}

void backtrack(string cur, string endWord, vector<string>& words) {
    if (cur == endWord) {
        if (path.size() == minL) {
            res.push_back(path);
        }
        else if (path.size() < minL) {
            res.clear();
            minL = path.size();
            res.push_back(path);
        }
        return;
    }
    for (string s : words) {
        if (check(s, cur)) {
            path.push_back(cur);
            cur = s;
            backtrack(cur, endWord, words);
        }
    }
}

vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
    unordered_set<string> dict = { wordList.begin(), wordList.end() };
    if (dict.find(endWord) == dict.end()) {
        return res;
    }
    minL = wordList.size() + 1;
    backtrack(beginWord, endWord, wordList);
    return res;
}

int mian() {
    vector<string> wordList = { "hot","dot","dog","lot","log","cog" };
    findLadders("hit", "cog", wordList);
    return 0;
}