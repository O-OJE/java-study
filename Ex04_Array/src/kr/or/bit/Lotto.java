package kr.or.bit;

import java.util.Random;
import java.util.Scanner;

/*
1. 1~45까지의 난수를 발생시켜 6개의 배열에 담으세요
	(int)(Math.random()*45 + 1)
	lotto[0] = 44 , lotto[1] = 1 .... lotto[5] = 33
2. 배열에 담긴 6개의 배열값은 중복값이 나오면 안되요  (중복값 검증 :별찍기 비슷)
3. 배열에 있는 6개의 값은 낮은 순으로 정렬 시키세요  (정렬 : 자리바꿈)
4. 위 결과를 담고 있는 배열을 출력하세요 (화면 출력)
*/
//
public class Lotto {
	//public int[] numbers = new int[6];   틀린코드는 아닌데 개선의 여지
	 private int[] numbers;  //초기화 
	// public Scanner scanner = new Scanner(System.in); //개선의 여지
	 private Scanner scanner;
	 private Random r; // new Random();
	 
	 public Lotto() { //초기화 (member field)
		 	numbers = new int[6]; 
		 	scanner = new Scanner(System.in);
		 	r = new Random();
	 }
	 
	 //기능  >> method >> 함수 하나당 기능 하나  
	 // public >> 참조변수
	 // private >>  내부 사용 (공통)
	 //실번호 추출해 주세요
	 //중복값 나오면 안되요
	 //낮은 순으로 정렬해 주세요
	 //화면에 출력해 주세요
	 //메뉴 기능을 만들어 주세요
	 
	 public void selectLottoNumbers() {
	 loop_1 : while(true) {
			 			String selectnum = showMenu();
			 			switch (selectnum) {
			 					case "1":  //makeLottoNumbers();  //실번호 추출
			 					                //showLottoNumbers();
			 									do {
			 										makeLottoNumbers();
			 									}while(!checkAverage());
			 									showLottoNumbers();
			 						break;
			 					case "2": //프로그램 종료 :  >> 함수 종료(return) , 프로그램 종료 (System.exit(0)) , 라벨값
				 					System.out.println("Good Lucky ^^");
			 						break loop_1; // break 지점이 switch ... 라벨(loop_1) 위치 ....  while  탈출
			 					default:
			 						System.out.println("not in operation~~");
			 						break;
						}
			 	}
	}
	 
	 private String showMenu() {
		 System.out.println("***************************");
		 System.out.println("**1. 당첨 예상 번호 추출하기**");
		 System.out.println("**2. 프로그램 종료 ^^! ^^! ^^**");
		 System.out.println("***************************");
		 System.out.println("원하는 메뉴 번호를 입력하세요 :");
		 String selectnum = scanner.nextLine();
		 return selectnum;
	 }
	 
	 //번호 추출 , 중복값 배제
	 private void makeLottoNumbers() {
			for(int i = 0 ; i < 6 ; i++) {
				numbers[i] = (int)(Math.random()*45 + 1);
				 for(int j = 0 ; j < i ; j++) { //j < i (채워진 개수 만큼 비교)
					 if(numbers[i] == numbers[j]) {
						 i--; //point 같은 방의 값을 바꾸어여 한다
						 break;
					 }
				 }
			}    
	 }
	 //화면에 출력 (낮은 값)
	 private void showLottoNumbers() {
		 for(int i = 0 ; i < numbers.length ;i++) {
				for(int j=i+1 ; j < numbers.length ; j++) {
					if(numbers[i] > numbers[j]) {
						int temp = numbers[i];
						numbers[i] = numbers[j];
						numbers[j] = temp;
					}
				}
			}
		
			//출력하기
		    System.out.println("[ 선택한  Lotto 번호 ]");
			for(int i = 0 ; i < numbers.length ; i++) {
				System.out.printf("[%2d]",numbers[i]);
			}
			System.out.println();
	 }
	 
	 //로또 (로또 번호의 합의 평균 범위) 아니면 재추출
	 private boolean checkAverage() {
		 int sum = 0;
		 int average = 0;
		 for(int num:numbers) {
			 sum+=num;
		 }
		 average=sum/numbers.length;
		 System.out.println("평균" + average);
		 return(average >= 15&&average<=35);	//true (ok), false(재추출)
	 }
}











