#include <iostream>
using namespace std;

int n, res;
int arr[1000];
int result[1000];

int main() {
  	// 입출력 속도 향상을 위함
	  ios::sync_with_stdio(false);
  	cin.tie(NULL);

  	cin >> n;
  	for (int i = 0; i < n; i++) cin >> arr[i];
  	for (int i = 0; i < n; i++) cin >> result[i];

  	int gap = 0;
  	for (int i = 0; i < n; i++) {
    		int tmp = result[i] - arr[i];
  	  	if (tmp > 0) {
      			if (gap < 0) res += tmp;
      			else if (gap < tmp) res += (tmp - gap);
	    	}
				else {
						if (gap > 0) res -= tmp;
						else if (gap > tmp) res += (gap - tmp);
				}
				gap = tmp;
		}
		cout << res;
}
