#include <iostream>
#include <algorithm>
#include <climits>
using namespace std;

long long n, m, weight, money, res = LLONG_MAX;
long long sum[100000];
pair<long long, long long> arr[100000];

bool cmp(pair<long long, long long> a, pair<long long, long long> b) {
	if (a.first != b.first) return a.first < b.first;
	return a.second > b.second;
}

int main() {
	// 입출력 속도 향상을 위함
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		int a, b;	cin >> a >> b;
		arr[i] = { b, a };
	}

	sort(arr, arr + n, cmp);

	if (arr[0].second >= m) {
		cout << arr[0].first;
		return 0;
	}

	weight = arr[0].second;
	money = arr[0].first;

	int index = 1;
	while (index < n) {
		weight += arr[index].second;
		if (arr[index].first > arr[index - 1].first) money = arr[index].first;
		else money += arr[index].first;

		if (weight >= m) res = min(res, money);
		index++;
	}

	if (res == LLONG_MAX) cout << -1;
	else cout << res;
}
