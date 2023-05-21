#include <iostream>
#include <queue>
using namespace std;

int n, m;
char board[50][50];
bool gisit[50][50];	// 고슴도치의 방문 체크

int dr[4] = { -1, 0, 1, 0 };
int dc[4] = { 0, 1, 0, -1 };

queue<pair<int, int>> gq;
queue<pair<int, int>> wq;

void BFS() {
	int cnt = 0;

	while (!gq.empty()) {
		cnt++;

		int wize = wq.size();
		int gize = gq.size();

		for (int i = 0; i < wize; i++) {
			int wr = wq.front().first;
			int wc = wq.front().second;

			wq.pop();

			for (int j = 0; j < 4; j++) {
				int r = wr + dr[j];
				int c = wc + dc[j];

				if (r < 0 || c < 0 || r >= n || c >= m) continue;
				if (board[r][c] == '*') continue;
				if (board[r][c] == 'D') continue;

				wq.push({ r,c });
				board[r][c] = '*';
			}
		}

		for (int i = 0; i < gize; i++) {
			int gr = gq.front().first;
			int gc = gq.front().second;

			gq.pop();

			for (int j = 0; j < 4; j++) {
				int r = gr + dr[j];
				int c = gc + dc[j];

				if (r < 0 || c < 0 || r >= n || c >= m) continue;
				if (gisit[r][c]) continue;
				if (board[r][c] == '*') continue;

				if (board[r][c] == 'D') {
					cout << cnt;
					return;
				}
				gq.push({ r,c });
				gisit[r][c] = 1;
			}
		}
	}

	cout << "KAKTUS";
	return;
}

int main() {
	// 입출력 속도를 단축시키기 위함
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> n >> m;

	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++) {
			cin >> board[i][j];

			if (board[i][j] == '*') wq.push({ i, j });
			else if (board[i][j] == 'S') {
				gq.push({ i, j });
				gisit[i][j] = 1;
			}

			// 돌도 물과 같이 갈 수 없는 곳이므로 물과 같은 문자로 표시
			else if (board[i][j] == 'X') board[i][j] = '*';
		}

	BFS();
}
