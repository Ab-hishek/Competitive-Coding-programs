/*Nancy has a cat named Lucy. She wants to paint her home which is made of N wooden boards of different lengths denoted by [A1, A2,..., An]. She hires K painters to do this work. Each painter takes 1 unit of time to paint 1 unit of board. Help her find the minimum time to get this job done under the constraint that a painter can only paint multiple boards if they are contiguous to each other. This means a configuration where painter 1 paints board 1 and board 3 but not board 2 is invalid.

Input:
The first line consists of a single integer T, the number of test cases. For each test case, the first line contains an integer k denoting the number of painters and integer n denoting the number of boards. Next line contains n- space separated integers denoting the size of boards.

Output:
For each test case, the output is an integer displaying the minimum time for painting that house.

Constraints:
1<=T<=100
1<=k , n <= 103
1<=A[i]<=104

Example:
Input:
2
2 4
10 10 10 10
2 4
10 20 30 40
Output:
20
60

Explanation:
1. Here we can divide the boards into 2 equal sized partitions, so each painter gets 20 units of the board and the total time taken is 20.
2. Here we can divide first 3 boards for one painter and the last board for the second painter.
*/
class NancySort
{

public static int getMax(int arr[], int n)
{
	int max = Integer.MIN_VALUE;;
	for (int i = 0; i < n; i++)
		if (arr[i] > max)
			max = arr[i];
	return max;
}

// return the sum of the elements in the array
public static int getSum(int arr[], int n)
{
	int total = 0;
	for (int i = 0; i < n; i++)
		total += arr[i];
	return total;
}

// find minimum required painters for given maxlen
// which is the maximum length a painter can paint
public static int numberOfPainters(int arr[], int n, int maxLen)
{
	int total = 0, numPainters = 1;

	for (int i = 0; i < n; i++) {
		total += arr[i];

		if (total > maxLen) {

			// for next count
			total = arr[i];
			numPainters++;
		}
	}

	return numPainters;
}

public static int Min_Time(int arr[], int n, int k)
{
	int lo = getMax(arr, n);
	int hi = getSum(arr, n);

	while (lo < hi) {
		int mid = lo + (hi - lo) / 2;
		int requiredPainters = numberOfPainters(arr, n, mid);

		// find better optimum in lower half
		// here mid is included because we
		// may not get anything better
		if (requiredPainters <= k)
			hi = mid;

		// find better optimum in upper half
		// here mid is excluded because it gives
		// required Painters > k, which is invalid
		else
			lo = mid + 1;
	}

	// required
	return lo;
}
}