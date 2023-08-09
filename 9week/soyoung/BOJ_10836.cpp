#include <iostream>
using namespace std;

int n, m;
int arr[700][700];
int three[3];
int grow[1400];

int main() {
	cin >> n >> m;

	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++) arr[i][j] = 1;

	for (int d = 0; d < m; d++) {
		cin >> three[0] >> three[1] >> three[2];
		int index = 0;
		while (three[0]) {
			grow[index++] += 0;
			three[0]--;
		}
		while (three[1]) {
			grow[index++] += 1;
			three[1]--;
		}
		while (three[2]) {
			grow[index++] += 2;
			three[2]--;
		}			
	}

	int index = 0;
	for (int i = n - 1; i >= 0; i--)
		arr[i][0] += grow[index++];

	for (int i = 1; i < n; i++)
		arr[0][i] += grow[index++];

	for (int i = 1; i < n; i++)
		for (int j = 1; j < n; j++)
			arr[i][j] = max(arr[i - 1][j], max(arr[i][j - 1], arr[i - 1][j - 1]));

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) cout << arr[i][j] << " ";
		cout << "\n";
	}
}
