#include <iostream>
using namespace std;

int arr[12][3];
int dp[10001];

int main() {

    int n, d, c = 0;   cin >> n >> d;
    for (int i = 0; i < n; i++) cin >> arr[i][0] >> arr[i][1] >> arr[i][2];

    for (int i = 1; i <= d; i++) {
        dp[i] = i;
        for (int j = 0; j < n; j++) {
            if (arr[j][1] == i) {
                dp[i] = min(dp[i], min(dp[arr[j][0]] + arr[j][2], dp[i - 1] + 1));
                c = 1;
            }
        }
        if (!c) dp[i] = dp[i - 1] + 1;
        c = 0;
    }

    cout << dp[d];
}
