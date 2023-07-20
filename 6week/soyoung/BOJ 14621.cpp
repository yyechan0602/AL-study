#include <iostream>
#include <queue>
using namespace std;

int n ,m, res;
bool visit[1001];
vector<pair<int, int>> road[1001];
char uni[1001];

void prim() {
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	pq.push({0, 1});
	
	while (!pq.empty()) {
		pair<int, int> edge = pq.top();
		pq.pop();

		if (visit[edge.second]) continue;

		visit[edge.second] = true;
		res += edge.first;

		for (int i = 0; i < road[edge.second].size(); i++)
			if (!visit[road[edge.second][i].second]) 
				pq.push({road[edge.second][i].first, road[edge.second][i].second});
	}
}

int main() {
	cin >> n >> m;
	for (int i = 1; i <= n; i++) cin >> uni[i];
	for (int i = 0; i < m; i++) {
		int a, b, c;		cin >> a >> b >> c;
		if (uni[a] != uni[b]) {
			road[a].push_back({ c, b });
			road[b].push_back({ c, a });
		}
	}

	prim();

	for (int  i = 1; i <= n; i++)
		if (!visit[i]) {
			cout << -1;
			return 0;
		}

	cout << res;
}
