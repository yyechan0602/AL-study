#include <iostream>
using namespace std;

int n, m, chick, home;
int res = INT_MAX;
int arr[13];
bool visit[13];
pair<int, int> chicken[13];
pair<int, int> house[100];

void distance() {
	int sum = 0;
	for (int i = 0; i < home; i++) {
		int dist = 100;
		for (int j = 0; j < m; j++) {
			int garo = abs(house[i].first - chicken[arr[j]].first);
			int sero = abs(house[i].second - chicken[arr[j]].second);
			dist = min(dist, garo + sero);
		}
		sum += dist;
	}
	res = min(res, sum);
}

void searchM(int num, int cnt) {
	if (cnt == m) {
		distance();
		return;
	}

	for (int i = num; i < chick; i++) {
		if (!visit[i]) {
			visit[i] = true;
			arr[cnt] = i;
			searchM(i + 1, cnt + 1);
			visit[i] = false;
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			int a;	cin >> a;
			if (a == 1) house[home++] = { i, j };
			else if (a == 2) chicken[chick++] = { i, j };
		}
	}

	searchM(0, 0);
	cout << res;
}
