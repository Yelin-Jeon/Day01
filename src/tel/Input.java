package tel;
import java.util.Scanner;

class People
{
	Scanner scan = new Scanner(System.in);
	private int num;
	private String name; 
	private String phone;
	private int age;
	public static int count; 
	public int tra;

	People[] pArr = new People[100]; // 배열

	public void Save(){ 
		System.out.println("이름을 입력하시오.");
		String name1 = scan.next();
		System.out.println("번호를 입력하시오.");
		String phone1 = scan.next();
		System.out.println("나이를 입력하시오.");
		int age1 = scan.nextInt();
		System.out.println();

		for(int i=count;i<=count;i++){
			pArr[i] = new People(); 
			pArr[i].num=(i+1);
			pArr[i].name=name1;
			pArr[i].phone=phone1;
			pArr[i].age=age1;
			
			 try {
		         tra = Integer.parseInt(pArr[i].phone);
		         }
		         catch(NumberFormatException e){
		            tra=0;
		            System.out.println("숫자가 아닌 값이 입력되었습니다. 다시 입력하세요.");
		            count--;
		         }

	         int empLength=pArr[i].phone.length();
	         if(empLength!=8) {
	            System.out.println("8자리 수가 아닙니다. 다시 입력하세요.");
	            count--;
	         }
	         
	         for(int j=0;j<count;j++) {
	            if(pArr[i].phone.equals(pArr[j].phone)) {
	               System.out.println("동일한 전화번호는 입력이 불가합니다.");
	               count--;
	            }
		}
		}count++;
	}

	public void Info(){
		System.out.println("-------전체 데이터 조회-------");
		for(int i=0;i<count;i++){
			System.out.println("No: "+pArr[i].num);
			System.out.println("이름:"+pArr[i].name);
			System.out.println("번호:"+pArr[i].phone);
			System.out.println("나이:"+pArr[i].age);
			System.out.println();
		}
	}

	public void Delete(){
		System.out.println("삭제할 번호를 입력하시오.");
		int index = scan.nextInt();
		index--;
		for(int i=0;i<count;i++){ // 

			if(index==i){ 
				for(int j=i;j<=count-1;j++){ 
					pArr[j]=pArr[j+1]; 
					count--;
				}
			}
		}  
		System.out.println("삭제되었습니다.");
	}
	
	public void Modify() {
		System.out.println("수정할 번호를 입력하시오.");
		int index = scan.nextInt();
		for(int i=0;i<count;i++) {
		if((index-1)==i) {
			System.out.println("정보를 다시 입력하세요.");
			System.out.println("이름을 입력하시오.");
			pArr[i].name= scan.next();
			System.out.println("번호를 입력하시오.");
			pArr[i].phone = scan.next();
			System.out.println("나이를 입력하시오.");
			pArr[i].age= scan.nextInt();
			System.out.println();
		}
	}
}
}

class Input
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		People p = new People();

		int menu=0;
		int flag=1;

		while(true){
			System.out.println("메뉴를 선택하시오.");
			System.out.println("1. 데이터 입력");
			System.out.println("2. 전체 데이터 조회");
			System.out.println("3. 데이터 검색");
			System.out.println("4. 데이터 삭제");
			System.out.println("5. 데이터 수정");
			System.out.println("6. 프로그램 종료");
			menu = scan.nextInt();

			switch (menu)
			{
			case 1:
				p.Save();
				break;
			case 2:
				p.Info();
				
				break;
			case 3:
				//p.Find();
				break;
			case 4:
				p.Delete();
				break;
			case 5:
				p.Modify();
				break;
			case 6:
				System.out.println("시스템 종료");
				break;
			default :
				System.out.println("잘못된 메뉴 입니다.");
				break;
			}
		}
	}
}