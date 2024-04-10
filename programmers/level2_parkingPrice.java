// 주차 요금 계산
// https://school.programmers.co.kr/learn/courses/30/lessons/92341

import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) { 
        // 각 차량 별 주차시간 Map 계산
        HashMap<String, Integer> parkingTime = getParkingTimeMap(records);

        int[] ans = new int[parkingTime.size()];

        String[] sortedCarNums = parkingTime.keySet().toArray(new String[parkingTime.size()]);

        // 차량번호 오름차순 정렬
        Arrays.sort(sortedCarNums);
        System.out.println(Arrays.toString(sortedCarNums));

        // 각 시간 별 요금 반환
        for(Map.Entry<String, Integer> parkingEntry : parkingTime.entrySet()) {
            int idx = Arrays.asList(sortedCarNums).indexOf(parkingEntry.getKey());
            ans[idx] = getParkingPrice(fees, parkingEntry.getValue());
        }


        return ans;
    }

    private int getParkingPrice(int[] fees, int parkingMinute) {
        int price = 0;
        // 무조건 기본요금 부과
        parkingMinute -= fees[0];
        price += fees[1];

        if(parkingMinute <= 0) {
            return price;
        }

        // 단위 시간
        price += Math.ceil((double)parkingMinute / fees[2]) * fees[3];
        return price;
    }

    private HashMap<String, Integer> getParkingTimeMap(String[] records) {
        HashMap<String, String> inTimeMap = new HashMap<>();
        HashMap<String, Integer> parkingTimeMap = new HashMap<>();

        for(String record : records) {
            String[] data = record.split(" ");
            String carNum = data[1];

            // 입차인 경우
            if(data[2].equals("IN")) {
                inTimeMap.put(carNum, data[0]);
            } else {
                // 출차인 경우 + 같은 차량이 하루에 두 번 주차하는 경우
                int parkingMinute = getParkingMinute(inTimeMap.get(carNum), data[0]);
                inTimeMap.remove(carNum);

                if(parkingTimeMap.containsKey(carNum)) {
                    parkingMinute += parkingTimeMap.get(carNum);
                }

                parkingTimeMap.put(carNum, parkingMinute);
            }
        }

        // 출차를 안한 차의 경우. (남은 차)
        for(String key: inTimeMap.keySet()) {
            int parkingMinute = getParkingMinute(inTimeMap.get(key), "23:59");
            // inTimeMap.remove(key);

            if(parkingTimeMap.containsKey(key)) {
                parkingMinute += parkingTimeMap.get(key);
            }

            parkingTimeMap.put(key, parkingMinute);
        }

        return parkingTimeMap;
    }

    private int getParkingMinute(String inTime, String outTime) {
        int inTimeHour = Integer.valueOf(inTime.split(":")[0]);
        int inTimeMinute = Integer.valueOf(inTime.split(":")[1]);
        int outTimeHour = Integer.valueOf(outTime.split(":")[0]);
        int outTimeMinute = Integer.valueOf(outTime.split(":")[1]);

        return ((outTimeHour - inTimeHour) * 60) + (outTimeMinute - inTimeMinute);
    }
}