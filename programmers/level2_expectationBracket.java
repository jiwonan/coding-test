// https://school.programmers.co.kr/learn/courses/30/lessons/12985
// 예상 대진표

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        int level = 1;
        while(n != 0) {
            if(a % 2 == 1) {
                a++;
            }
            if(b % 2 == 1) {
                b++;
            }
            if(a == b) {
                return level;
            }
            
            a /= 2;
            b /= 2;
            n /= 2;
            level++;
        }

        return answer;
    }
}