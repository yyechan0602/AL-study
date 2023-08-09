#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, ma;
string arr[20000];
vector<pair<string, int>> v;
vector<int> res;
vector<int> tmp;

int main() {
	// 입출력 속도 향상을 위함
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
		v.push_back({ arr[i], i});
	}

	sort(v.begin(), v.end());
	v.push_back({ "-", 1000000000 });

	for (int i = 0; i < n; i++) {
		bool check = false;
		for (int j = i + 1; j <= n; j++) {
			int index = 0;
			while (index < v[i].first.size() && index < v[j].first.size())
				if (v[i].first[index] == v[j].first[index]) index++;
				else break;
			if (j == i + 1 && ma <= index) {
				if (ma < index) check = true;
				ma = index;
				tmp.clear();
				tmp.push_back({ v[i].second });
				tmp.push_back({ v[j].second });
			}
			else if (j > i + 1 && ma == index) tmp.push_back({ v[j].second });
			else if (j > i + 1 && ma > index) {
				if (res.empty() || check) {
					res = tmp;
                    sort(res.begin(), res.end());
					tmp.clear();
					break;
				}

				sort(tmp.begin(), tmp.end());

				if (arr[tmp[0]] == arr[tmp[1]]) {
					tmp.clear();
					break;
				}

				if (res[0] > tmp[0]) res = tmp;
				else if (res[0] == tmp[0]) {
					if (res[1] > tmp[1]) res = tmp;
				}

				tmp.clear();
				break;
			}
			else if (j == i + 1 && ma > index) break;
		}
	}
	sort(res.begin(), res.end());
	cout << arr[res[0]] << "\n";
	cout << arr[res[1]] << "\n";
}
