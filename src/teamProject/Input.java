package teamProject;
import java.util.InputMismatchException;
import java.util.Scanner;

class People
{
   int pw;//비밀번호입력을 통한 권한부여
   String level;


   void choice() {
      System.out.print("권한선택을 위한 비밀번호를 입력해주십시오 : ");
      pw = scan.nextInt();    
      grant();
   }
   void grant() {
      if(pw==0000) {   
         level ="mgr";
      }else if(pw==1111) {
         level ="submgr";
      }else if(pw==2222) {
         level ="user";   
      }else {
         System.out.println("사용할수 없는 비밀번호입니다.");
      }
   }

   Scanner scan = new Scanner(System.in);
   public int num;
   public String name; 
   public String phone;
   public int age;
   public int count = 0; 
   public int tra;
   public String writer;
   int empLength;
   String phone1;
   String[] mobnum;
   People[] pArr = new People[100]; // 배열
   String[][] arr = new String[99][2];
   boolean bool=true;
   public void Save(){ 
      choice();
      
      System.out.println("이름을 입력하시오.");
      String name1 = scan.next();

      do{
     
         System.out.println("번호를 입력하시오.");
         System.out.println("(-를 사용하여 010을 제외한 8자리 번호를 입력하시오.)");
         phone1 = scan.next();
         mobnum = phone1.split("-");
         empLength=phone1.length();
         
         for(int j=0;j<count;j++) {
             if(phone1.equals(pArr[j].phone)) {
                System.out.println("동일한 전화번호는 입력이 불가합니다.");
             }
         }
      }while(empLength!=9); 
      
      System.out.println("나이를 입력하시오.");
      int age1 = scan.nextInt();
      System.out.println();
      String writer1="";

      if(pw==0000) {
         writer1="관리자";
      }else if(pw==1111) {
         writer1="보조 관리자";
      }else if(pw==2222) {
         writer1="사용자";
      }else {
      }

      pArr[count] = new People(); 
      pArr[count].num=(count+1);
      pArr[count].name=name1;
      pArr[count].phone=phone1;         
      pArr[count].age=age1;
      pArr[count].writer=writer1;

      count++;
      }

   
   
   public void Info(){
      System.out.println("-------전체 데이터 조회-------");
      for(int i=0;i<count;i++){
         System.out.println("No : "+pArr[i].num);
         System.out.println("이름 : "+pArr[i].name);
         System.out.println("번호 : 010-"+pArr[i].phone);
         System.out.println("나이 : "+pArr[i].age);
         System.out.println("작성자 : "+pArr[i].writer);
         System.out.println();
      }
   }

   public void Delete(){
      System.out.print("삭제할 번호 입력:");
      int index=(scan.nextInt()+1);
      if(index<1)
         System.out.println("해당하는 값이 없습니다.");
      else{
         for(int i=index;i<count-1;i++){
            pArr[i]=pArr[i+1];    
         }
         count--;
         System.out.println("데이터가 삭제되었습니다.\n");
      }
   }
   public void Modify() {
	      System.out.println("권한자 번호를 입력하세요.");
	      System.out.print("권한자 번호 : ");
	      int grantNum=scan.nextInt();
	      System.out.println("수정할 번호를 입력하시오.");
	      int index = scan.nextInt();
	      
	      if(grantNum==1111) {
	      for(int i=0;i<count;i++) {
	         if((index-1)==i) {
	            if(pw!=0000) {
	            System.out.println("정보를 다시 입력하세요.");
	            System.out.println("이름을 입력하시오.");
	            pArr[i].name= scan.next();
	            System.out.println("번호를 입력하시오.");
	            pArr[i].phone = scan.next();
	            System.out.println("나이를 입력하시오.");
	            pArr[i].age= scan.nextInt();
	            System.out.println();
	            }else {
	               System.out.println("권한이 부족합니다.");
	            }
	            }
	      }
	      }else if(grantNum==2222) {
	         for(int i=0;i<count;i++) {
	            if((index-1)==i) {
	               if(pw!=0000 &&pw!=1111) {
	               System.out.println("정보를 다시 입력하세요.");
	               System.out.println("이름을 입력하시오.");
	               pArr[i].name= scan.next();
	               System.out.println("번호를 입력하시오.");
	               pArr[i].phone = scan.next();
	               System.out.println("나이를 입력하시오.");
	               pArr[i].age= scan.nextInt();
	               System.out.println();
	               }else {
	                  System.out.println("권한이 부족합니다.");
	               }
	               }
	         }
	      }else {
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

	   public void search() {

	      int index = -2;
	      System.out.println("검색하실 사람의 정보를 선택하세요.");
	      System.out.println("|1.이름|2.나이|3.전화번호|");
	      int a = scan.nextInt();
	      if (a == 1) {
	         System.out.print("이름을 입력하세요 : ");
	         String name = scan.next();
	         for (int i = 0; i < count; i++) {
	            if (name.equals(pArr[i].name)) {
	               index = i;
	            }
	         }//for (int i = 0; i < t.length; i++)
	      }//if (a == 1)
	      else if (a == 2) {
	         try {
	            System.out.print("나이를 입력하세요 : ");
	            int age = scan.nextInt();
	            for (int i = 0; i < count; i++) {
	               if (age == pArr[i].age) {
	                  index = i;
	               }
	            }//for (int i = 0; i < t.length; i++)
	         } catch (InputMismatchException e) {
	            scan = new Scanner(System.in);
	            System.out.println("[Error]숫자 외 표기가 감지되었습니다. 숫자로만 입력 가능합니다.");
	            index = -1;            
	         }

	      }//else if (a == 2)
	      else if (a == 3) {
	         System.out.print("뒷번호 4자리를 입력하세요 : ");
	         String num = scan.next();
	         for (int i = 0; i < count; i++) {
	            if (pArr[i].phone.contains(num)) {
	               index = i;
	            }
	         }//for (int i = 0; i < t.length; i++)
	      }//else if (a == 3)
	      else {
	         System.out.println("잘못누르셨습니다. 정확한 번호를 입력해주세요.");
	         index = -1;
	         System.out.println("");
	      }

	      if (index >= 0) {
	         System.out.println("찾으시는 사람의 정보 입니다.");
	         System.out.println("사용자 : "+"이름 : "+pArr[index].name+", 나이 : "+pArr[index].age+", 전화번호 : "+pArr[index].phone);
	         System.out.println("");
	         index = -2;
	      }else if (index == -2) {
	         System.out.println("찾으시는 사람의 정보가 없습니다.");
	         System.out.println("");
	      }

	   }
	}

	class Input 
	{

	   Scanner scan = new Scanner(System.in);
	   People p = new People();

	   int menu=0;
	   int flag=1;


	   public Input() {
	      new People();
	   }
	   void menu() {


	      while(true){
	         System.out.println("메뉴를 선택하시오.");
	         System.out.println("1. 데이터 입력");
	         System.out.println("2. 전체 데이터 조회");
	         System.out.println("3. 데이터 검색");
	         System.out.println("4. 데이터 수정");
	         System.out.println("5. 데이터 삭제");
	         System.out.println("6. 프로그램 종료");
	         System.out.print("메뉴 입력 : ");
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
	            p.search();
	            break;
	         case 4:
	            p.Modify();
	            break;
	         case 5:
	            p.Delete();
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