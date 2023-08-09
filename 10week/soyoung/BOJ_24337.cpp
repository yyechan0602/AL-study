#include <iostream>
using namespace std;

int arr[100001];

int main() {
	// 입출력 속도를 단축시키기 위함
	ios::sync_with_stdio(0);
	cin.tie(0);

	int n, a, b;		cin >> n >> a >> b;

	if (a + b > n + 1) {
		cout << -1;
		return 0;
	}

	arr[n - b + 1] = max(a, b);

	int index = n - b;
	for (int i = a - 1; i > 0; i--) 
		arr[index--] = i;

	index = n;
	for (int i = 1; i < b; i++)
		arr[index--] = i;

	if(a == 1 && b != n)
		for (int i = 1; i <= n; i++)
			if (arr[i] != 0) {
				arr[1] = arr[i];
				arr[i] = 0;
				break;
			}

	for (int i = 1; i <= n; i++) {
		if (arr[i] == 0) cout << 1 << " ";
		else cout << arr[i] << " ";
	}
}
