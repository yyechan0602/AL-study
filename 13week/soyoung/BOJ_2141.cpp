#include <iostream>
#include <algorithm>
using namespace std;

long long n, people;

pair<int, int> arr[100000];

int main() {
	// 입출력 속도 향상을 위함
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		int a, b;	cin >> a >> b;
		arr[i] = { a, b };
		people += b;
	}

	sort(arr, arr + n);

	if (people % 2) people++;
	people /= 2;

	long long tmp = 0;
	int index = 0;
	while (tmp < people) tmp += arr[index++].second;

	cout << arr[index - 1].first;
}
