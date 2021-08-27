package quiz;

import java.util.Random;
import java.util.Scanner;

public class Quiz01 {
	/*
	 * 주민등록번호 생성하기
	 * 조건 1. 지역별로 남녀 구분
	 * 조건 2. 주민번호가 DB에 있다는 가정 하에 주민번호 뒷자리는 랜덤으로 100개 
	 * 조건 3. 첫번째 두번째: 1900~2000년 생
	 * 조건 4. 세번째 네번째: 01~12월 생
	 * 조건 5. 다섯번째 여섯번째: 01~31일 생
	 * 조건 6. 일곱번째: 1과 3은 남자, 2와 4는 여자
	 * 조건 7. 지역_ 서울: 00~08, 부산: 09~12, 인천: 13~15, 경기: 16~25,
	 *            강원: 26~34, 충북: 35~39, 충남: 40~47, 대전: 40
	 *            전북: 48~55, 전남: 56~66, 광주: 65~66
	 *            경북: 67~88, 대구: 67~69, 경남: 81~99, 울산: 85
	 */

	public static void main(String[] args) {
		Random random = new Random();
		Scanner scan = new Scanner(System.in);
		
		int year = random.nextInt(100);
		int month = random.nextInt(12)+1;
		int day = 0; 
		
		if((year%100)==0 && month==4) {
			day = random.nextInt(28) + 1;
		} else if((year%4)==0 && month==4) {
			day = random.nextInt(29) + 1;
		} else if(month==4) {
			day = random.nextInt(28) + 1;
		} else if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12) {
			day = random.nextInt(31)+1;
		} else {
			day = random.nextInt(30)+1;
		}

		String yearS = String.format("%02d", year);
		String monthS = String.format("%02d", month);
		String dayS = String.format("%02d", day);
		
		int gender = 0;
		int from = 0; 
		
		System.out.print("너 여자야? 아님 남자? ");
		if (scan.next() == "여자" || scan.next() == "여") {
			gender = 2 ;
		} else if (scan.next() == "남자" || scan.next() == "남") {
			gender = 1 ;
		} else {
			System.out.println("제삼의 성");
			gender = 0;
		}
		System.out.print("너 어디에서 태어났어? ");
		if(scan.next() == "서울") {
			from = random.nextInt(9);
		} else if(scan.next() == "부산") {
			from = random.nextInt(2) + 9 ;
		} else if(scan.next() == "인천") {
			from = random.nextInt(3) + 13 ;
		}  else if(scan.next() == "경기") {
			from = random.nextInt(8) + 16 ;
		} else if(scan.next() == "강원") {
			from = random.nextInt(8) + 26 ;
		} else if(scan.next() == "충북") {
			from = random.nextInt(5) + 35 ;
		} else if(scan.next() == "대전") {
			from = random.nextInt(1) + 40 ;
		}
		
		String fromS = String.format("%02d", from);
		
		System.out.println(yearS + monthS + dayS + "-" + gender + fromS);
		

	}

}
