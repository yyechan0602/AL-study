#include <iostream>
#include <vector>
using namespace std;

int n, m, k;
vector<pair<int, int>> arr[301];
int dp[301][301];

int main() {
	// 입출력 속도 향상을 위함
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> n >> m >> k;

	for (int i = 0; i < k; i++) {
		int a, b, c;	cin >> a >> b >> c;
		if (a < b) arr[a].push_back({ b, c });
	}

	for (int i = 0; i < arr[1].size(); i++) 
		dp[arr[1][i].first][2] = max(dp[arr[1][i].first][2], arr[1][i].second);

	for (int i = 2; i <= n; i++) 
		for (int j = 1; j <= m; j++) 
			if (dp[i][j]) 
				for (int k = 0; k < arr[i].size(); k++) 
					dp[arr[i][k].first][j + 1] = max(dp[arr[i][k].first][j + 1], dp[i][j] + arr[i][k].second);
				
	int res = 0;
	for (int i = 2; i <= m; i++) res = max(res, dp[n][i]);
	cout << res;
}
