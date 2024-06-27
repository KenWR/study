#include <iostream>
using namespace std;

double	get_lowest_cost(double *costs, double N, double L);

int main() {
	int		C;		// 반복 횟수 
	double	N, L;	// 공연장 대여 일수, 섭외된 최소 팀

	cin >> C;
	for (int i = 0; i < C; i++) {
		cin >> N >> L;
		double *costs = new double[(int)N];
		for (int j = 0; j < N; j++) {
			cin >> costs[j];
		}
		cout << fixed;
		cout.precision(11);
		cout << get_lowest_cost(costs, N, L) << endl;
		delete[] costs;
	}
}

double	get_lowest_cost(double *costs, double N, double L)
{
	double	added_date, average, costs_sum;	// 추가된 날짜, 평균 비용, 비용 합계

	average = 0;
	// 최소 모든 팀이 공연할 수 있을 때 까지
	for (int i = 0; i < N - L + 1; i++) {
		costs_sum = 0;
		added_date = 0;

		// 초기값 설정
		for (int j = i; j < i + L; j++) {
			costs_sum += costs[j];
		}
		if (average > costs_sum / L || average == 0)
			average = costs_sum / L;
		// 추가로 날짜를 늘려가며 평균 비용 계산
		for (int j = i + L; j < N; j++) {
			costs_sum += costs[j];
			added_date++;
			if (average > costs_sum / (L + added_date))
				average = costs_sum / (L + added_date);
		}
	}
	return (average);
}