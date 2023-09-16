#include <iostream>
#include <queue>
using namespace std;

int n, m;
int s, w;
char arr[250][250];
bool visit[250][250];

int dr[4] = { 0, 1, 0, -1 };
int dc[4] = { 1, 0, -1 ,0 };

void bfs(int i, int j) {
	queue<pair<int, int>> q;
	visit[i][j] = true;
	q.push({ i, j });

	int v = 0, o = 0;
	if (arr[i][j] == 'v')  v++;
	else o++;

	while (!q.empty()) {
		int r = q.front().first;
		int c = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int rr = r + dr[i];
			int cc = c + dc[i];

			if (0 > rr || rr >= n || 0 > cc || cc >= m) continue;
			if (visit[rr][cc] || arr[rr][cc] == '#') continue;

			if (arr[rr][cc] == 'v') v++;
			else if (arr[rr][cc] == 'o') o++;
			q.push({ rr, cc });
			visit[rr][cc] = true;
		}
	}

	if (v < o) w -= v;
	else s -= o;
}

int main() {
	cin >> n >> m;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++) {
			cin >> arr[i][j];
			if (arr[i][j] == 'v') w++;
			else if (arr[i][j] == 'o') s++;
		}

	for (int i= 0; i < n; i++)
		for (int j = 0; j < m; j++) {
			if ((arr[i][j] == 'v' || arr[i][j] == 'o') && visit[i][j] == false) bfs(i, j);
		}

	cout << s << " "<< w;
}
