#include <iostream>
#include <algorithm>
using namespace std;

int arr[100000];

int main() {
    int n;  cin >> n;
    for (int i = 0; i < n; i++) cin >> arr[i];

    sort(arr, arr + n);

    int gap = INT_MAX;
    int res = arr[0], res2 = arr[n - 1];
    int start = 0, end = n - 1;

    while (start < end) {
        int sum = arr[start] + arr[end];
        if (gap > abs(sum)) {
            gap = abs(sum);
            res = arr[start]; res2 = arr[end];
        }

        if (sum == 0) break;
        else if (sum < 0) start++;
        else end--;
    }

    cout << res << " " << res2;
}
