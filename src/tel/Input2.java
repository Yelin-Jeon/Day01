package tel;
import java.util.InputMismatchException;
import java.util.Scanner;

class People
{
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
   People[] pArr = new People[100]; // �迭
   String[][] arr = new String[99][2];
   boolean boo=true;
   public void Save(){ 
	  
      System.out.println("�̸��� �Է��Ͻÿ�.");
      String name1 = scan.next();

      while(true) {
    	  try {
    	  System.out.println("��ȣ�� �Է��Ͻÿ�.");
          System.out.println("(-�� ����Ͽ� 010�� ������ 8�ڸ� ��ȣ�� �Է��Ͻÿ�.)");
      
    	  phone1 = scan.next();
         mobnum = phone1.split("-");
         for (int i = count; i < count+1; i++) {
            for (int j = 0; j < 2; j++) {
               arr[i][j] = mobnum[j];               
            }//for (int j = 0; j < mobnum.length; j++)
         }//for (int i = 0; i < mobnum.length-1; i++)

         empLength = Integer.parseInt(phone1);

      } catch (NumberFormatException e) {
         scan = new Scanner(System.in);

         if (phone1.indexOf("-")>-1) {

         }else {
            System.out.println("���ڰ� �ƴ� ���� �ԷµǾ����ϴ�. �ٽ� �Է��ϼ���.");
            System.out.println("��ȣ�� �Է��Ͻÿ�.");
            phone1 = scan.next(); 
       
         }         
      }
      empLength=phone1.length();
      if(empLength!=9) {
          System.out.println("8�ڸ� ���� �ƴմϴ�. �ٽ� �Է��ϼ���.");
       }
      else if(empLength==9) {
    	  break;
      }
      }
      System.out.println("���̸� �Է��Ͻÿ�.");
      int age1 = scan.nextInt();
      System.out.println();
      String writer1="";

      A_kim a = new A_kim();
      if(a.level=="mgr") {
         writer1="������";
      }else if(a.level=="submgr") {
         writer1="���� ������";
      }else if(a.level=="user") {
         writer1="�����";
      }else {
      }

      pArr[count] = new People(); 
      pArr[count].num=(count+1);
      pArr[count].name=name1;
      pArr[count].phone=phone1;         
      pArr[count].age=age1;
      pArr[count].writer=writer1;

      for(int j=0;j<count;j++) {
         if(pArr[count].phone.equals(pArr[j].phone)) {
            System.out.println("������ ��ȭ��ȣ�� �Է��� �Ұ��մϴ�.");
            count--;
         }
      }count++;
   }
   public void Info(){
      System.out.println("-------��ü ������ ��ȸ-------");
      for(int i=0;i<count;i++){
         System.out.println("No : "+pArr[i].num);
         System.out.println("�̸� : "+pArr[i].name);
         System.out.println("��ȣ : 010-"+pArr[i].phone);
         System.out.println("���� : "+pArr[i].age);
         System.out.println("�ۼ��� : "+pArr[i].writer);
         System.out.println();
      }
   }

   public void Delete(){
	      System.out.print("������ ��ȣ �Է�:");
	      int index=(scan.nextInt()+1);
	      if(index<1)
	       System.out.println("�ش��ϴ� ���� �����ϴ�.");
	      else{
	       for(int i=index;i<count-1;i++){
	        pArr[i]=pArr[i+1];    
	       }
	       count--;
	       System.out.println("�����Ͱ� �����Ǿ����ϴ�.\n");
	      }
   }
   public void Modify() {
      System.out.println("������ ��ȣ�� �Է��ϼ���.");
      System.out.print("������ ��ȣ : ");
      int grantNum=scan.nextInt();
      System.out.println("������ ��ȣ�� �Է��Ͻÿ�.");
      int index = scan.nextInt();
      for(int i=0;i<count;i++) {
         if((index-1)==i) {
            System.out.println("������ �ٽ� �Է��ϼ���.");
            System.out.println("�̸��� �Է��Ͻÿ�.");
            pArr[i].name= scan.next();
            System.out.println("��ȣ�� �Է��Ͻÿ�.");
            pArr[i].phone = scan.next();
            System.out.println("���̸� �Է��Ͻÿ�.");
            pArr[i].age= scan.nextInt();
            System.out.println();
         }
      }
   }

   public void search() {
	   
	      int index = -2;
	      System.out.println("�˻��Ͻ� ����� ������ �����ϼ���.");
	      System.out.println("|1.�̸�|2.����|3.��ȭ��ȣ|");
	      int a = scan.nextInt();
	      if (a == 1) {
	         System.out.print("�̸��� �Է��ϼ��� : ");
	         String name = scan.next();
	         for (int i = 0; i < count; i++) {
	            if (name.equals(pArr[i].name)) {
	               index = i;
	            }
	         }//for (int i = 0; i < t.length; i++)
	      }//if (a == 1)
	      else if (a == 2) {
	         try {
	            System.out.print("���̸� �Է��ϼ��� : ");
	            int age = scan.nextInt();
	            for (int i = 0; i < count; i++) {
	               if (age == pArr[i].age) {
	                  index = i;
	               }
	            }//for (int i = 0; i < t.length; i++)
	         } catch (InputMismatchException e) {
	            scan = new Scanner(System.in);
	            System.out.println("[Error]���� �� ǥ�Ⱑ �����Ǿ����ϴ�. ���ڷθ� �Է� �����մϴ�.");
	            index = -1;            
	         }
	         
	      }//else if (a == 2)
	      else if (a == 3) {
	         System.out.print("�޹�ȣ 4�ڸ��� �Է��ϼ��� : ");
	         String num = scan.next();
	         for (int i = 0; i < count; i++) {
	            if (pArr[i].phone.contains(num)) {
	               index = i;
	            }
	         }//for (int i = 0; i < t.length; i++)
	      }//else if (a == 3)
	      else {
	         System.out.println("�߸������̽��ϴ�. ��Ȯ�� ��ȣ�� �Է����ּ���.");
	         index = -1;
	         System.out.println("");
	      }

	      if (index >= 0) {
	         System.out.println("ã���ô� ����� ���� �Դϴ�.");
	         System.out.println("����� : "+"�̸� : "+pArr[index].name+", ���� : "+pArr[index].age+", ��ȭ��ȣ : "+pArr[index].phone);
	         System.out.println("");
	         index = -2;
	      }else if (index == -2) {
	         System.out.println("ã���ô� ����� ������ �����ϴ�.");
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
         System.out.println("�޴��� �����Ͻÿ�.");
         System.out.println("1. ������ �Է�");
         System.out.println("2. ��ü ������ ��ȸ");
         System.out.println("3. ������ �˻�");
         System.out.println("4. ������ ����");
         System.out.println("5. ������ ����");
         System.out.println("6. ������ ����");
         System.out.println("7. ���α׷� ����");
         System.out.print("�޴� �Է� : ");
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
            A_kim ak = new A_kim();
            ak.choice();
            ak.grant();
         break;
         case 7:
            System.out.println("�ý��� ����");

            break;
         default :
            System.out.println("�߸��� �޴� �Դϴ�.");
            break;

         }
      }
   }
}
