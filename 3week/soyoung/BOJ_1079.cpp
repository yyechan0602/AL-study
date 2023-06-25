#include <iostream>
using namespace std;

int n, mafia, res;
int visit[16];
int score[16];
int board[16][16];

void kill(int num) {
	for (int i = 0; i < n; i++) 
		if (score[i]) score[i] += board[num][i];
	score[num] = 0;

	int ma = 0, index;
	for (int i = 0; i < n; i++) {
		if (ma < score[i] && score[i]) {
			ma = score[i];
			index = i;
		}
	}
	score[index] = 0;
}

void MAFIA(int cnt) {
	if (cnt == n/2 || !score[mafia]) {
		res = max(res, cnt);
		return;
	}

	int temp[16];
	for (int j = 0; j < n; j++) temp[j] = score[j];

	for (int i = 0; i < n ; i++) {
		if (!score[i]) continue;
		if (!visit[i]) {
			visit[i] = true;
			kill(i);
			MAFIA(cnt + 1);
			visit[i] = false;
			for (int j = 0; j < n; j++) score[j] = temp[j];
		}
	}
}

int main() {
	cin >> n;

	for (int i = 0; i < n; i++) cin >> score[i];

	for (int i = 0; i < n; i++) 
		for (int j = 0; j < n; j++) 
			cin >> board[i][j];

	cin >> mafia;

	if (n % 2) {
		int ma = 0, index;
		for (int i = 0; i < n; i++) {
			if (ma < score[i]) {
				ma = score[i];
				index = i;
			}
		}
		if (index == mafia) {
			cout << 0;
			return 0;
		}
		score[index] = 0;
	}

	MAFIA(0);
	cout << res;
}
