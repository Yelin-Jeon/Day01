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

	People[] pArr = new People[100]; // �迭

	public void Save(){ 
		System.out.println("�̸��� �Է��Ͻÿ�.");
		String name1 = scan.next();
		System.out.println("��ȣ�� �Է��Ͻÿ�.");
		String phone1 = scan.next();
		System.out.println("���̸� �Է��Ͻÿ�.");
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
		            System.out.println("���ڰ� �ƴ� ���� �ԷµǾ����ϴ�. �ٽ� �Է��ϼ���.");
		            count--;
		         }

	         int empLength=pArr[i].phone.length();
	         if(empLength!=8) {
	            System.out.println("8�ڸ� ���� �ƴմϴ�. �ٽ� �Է��ϼ���.");
	            count--;
	         }
	         
	         for(int j=0;j<count;j++) {
	            if(pArr[i].phone.equals(pArr[j].phone)) {
	               System.out.println("������ ��ȭ��ȣ�� �Է��� �Ұ��մϴ�.");
	               count--;
	            }
		}
		}count++;
	}

	public void Info(){
		System.out.println("-------��ü ������ ��ȸ-------");
		for(int i=0;i<count;i++){
			System.out.println("No: "+pArr[i].num);
			System.out.println("�̸�:"+pArr[i].name);
			System.out.println("��ȣ:"+pArr[i].phone);
			System.out.println("����:"+pArr[i].age);
			System.out.println();
		}
	}

	public void Delete(){
		System.out.println("������ ��ȣ�� �Է��Ͻÿ�.");
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
		System.out.println("�����Ǿ����ϴ�.");
	}
	
	public void Modify() {
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
			System.out.println("�޴��� �����Ͻÿ�.");
			System.out.println("1. ������ �Է�");
			System.out.println("2. ��ü ������ ��ȸ");
			System.out.println("3. ������ �˻�");
			System.out.println("4. ������ ����");
			System.out.println("5. ������ ����");
			System.out.println("6. ���α׷� ����");
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
				System.out.println("�ý��� ����");
				break;
			default :
				System.out.println("�߸��� �޴� �Դϴ�.");
				break;
			}
		}
	}
}