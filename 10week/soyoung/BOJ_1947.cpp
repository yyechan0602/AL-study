#include <iostream>
using namespace std;

long long n, dp[1000001] = { 1, 0 };

int main() {
	cin >> n;
	for (int i = 2; i <= n; i++)
		dp[i] = ((i - 1) * (dp[i - 1] + dp[i - 2])) % 1000000000;
	cout << dp[n];
}
