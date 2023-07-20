#include <iostream>
using namespace std;

struct robot {
	int r, c, d;
};
int a, b, n, m;
int board[101][101];
robot r[101];

int dr[] = { -1, 0, 1, 0 };
int dc[] = { 0, 1, 0, -1 };

bool move(int ro, int dist) {
	int row = r[ro].r;
	int col = r[ro].c;
	int dis = r[ro].d;

	board[row][col] = 0;

	for (int i = 1; i <= dist; i++) {
		row += dr[dis];
		col += dc[dis];

		if (row < 1 || row > b || col < 1 || col > a) {
			cout << "Robot " << ro << " crashes into the wall";
			return 1;
		}

		if (board[row][col]) {
			cout << "Robot " << ro << " crashes into robot " << board[row][col];
			return 1;
		}
	}

	board[row][col] = ro;
	r[ro] = { row, col, dis };

	return 0;
}

int main() {
	cin >> a >> b >> n >> m;

	for (int i = 1; i <= n; i++) {
		int x, y, d = 3;	char di;
		cin >> x >> y >> di;

		board[b - y + 1][x] = i;

		if (di == 'N') d = 0;
		else if (di == 'E') d = 1;
		else if (di == 'S') d = 2;

		r[i] = { b - y + 1, x, d };
	}

	for (int i = 0; i < m; i++) {
		int ro, dist;
		char order;
		cin >> ro >> order >> dist;

		if (order == 'F') {
			bool check = move(ro, dist);
			if (check) return 0;
		}
		else if (order == 'R') {
			int dis = r[ro].d;
			dis += dist;
			dis %= 4;

			r[ro].d = dis;
		}
		else {
			int dis = r[ro].d;
			dis -= dist;
			dis += 100;
			dis %= 4;

			r[ro].d = dis;
		}
	}
	cout << "OK";
}
