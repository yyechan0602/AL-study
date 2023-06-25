#include <iostream>
#include <vector>
using namespace std;

vector<int> v[20001];
int visit[20001];
int node, edge;

void DFS(int node) {
	if (!visit[node]) visit[node] = 1;

	for (int i = 0; i < v[node].size(); i++) {
		if (!visit[v[node][i]]) {
			if (visit[node] == 1) visit[v[node][i]] = 2;
			else if (visit[node] == 2) visit[v[node][i]] = 1;
			DFS(v[node][i]);
		}
	}
}

string check() {
	for (int i = 1; i <= node; i++) 
		for (int j = 0; j < v[i].size(); j++)
			if (visit[i] == visit[v[i][j]]) return "NO\n";
	return "YES\n";
}

int main() {
	int n;	cin >> n;
	while (n--) {
		cin >> node >> edge;
		for (int i = 1; i <= node; i++) v[i].clear();
		for (int i = 1; i <= node; i++) visit[i] = 0;

		for (int i = 0; i < edge; i++) {
			int a, b;	cin >> a >> b;
			v[a].push_back(b);
			v[b].push_back(a);
		}

		for (int i = 1; i <= node; i++)
			if (!visit[i]) DFS(i);

		cout << check();
	}
}
