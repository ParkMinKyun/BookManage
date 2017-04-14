package �ڹα�30208;
 
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
 
public class Main {
 
	static Scanner scan = new Scanner(System.in);
	static File filePath = new File("C:\\test\\book.txt");
 
	public static void main(String args[]) throws IOException {
 
		int in = -1;
 
		while (in != 0) {
 
			display();
			in = scan.nextInt();
			scan.nextLine();
 
			switch (in) {
			case 1:
				printbook();
				break;
			case 2:
				searchbook();
				break;
			case 3:
				addbook();
				break;
			case 4:
				deletebook();
				break;
			case 0:
				System.out.println("�����մϴ�.");
				System.exit(0);
				break;
			default:
				System.out.println("�ٽ� �Է��� �ּ���.");
			}
		}
	}
 
	public static void display() {
		System.out.println("-- �������� ���α׷� --");
		System.out.println("1. ��ü ���� ���");
		System.out.println("2. ���� �˻�");
		System.out.println("3. ���� �߰�");
		System.out.println("4. ���� ���");
		System.out.println("0. ����");
		System.out.println("----------------");
	}
 
	private static void printbook() throws FileNotFoundException {
		System.out.println("");
		System.out.println("----- ���� ��� -----");
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		int count = 1;
		String str = "";
		try {
			while ((str = br.readLine()) != null) {
				System.out.println(count + ") " + str);
				count++;
			}
			System.out.println("");
		} catch (IOException e) {
			e.printStackTrace();
		}
 
	}
 
	private static void searchbook() throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		System.out.println("");
		System.out.println("------- �˻� -------");
		System.out.println("- 1. �̸� �˻�");
		System.out.println("- 2. ���� �˻�");
		System.out.println("- 3. ���� �˻�");
		System.out.println("------------------");
		System.out.println("");
		int searchOption = scan.nextInt();
		scan.nextLine();
 
		switch (searchOption) {
		case 1:
			search1();
			break;
		case 2:
			search2();
			break;
		case 3:
			search3();
			break;
		default:
			System.out.println("�ٽ� �Է����ּ���.");
		}
 
	}
 
	private static void search1() throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		System.out.println("ã���� �ϴ� å�� �̸��� �Է��Ͻÿ� : ");
		String keyword = "";
		keyword = scan.nextLine();
		int i = 0;
		String str = "";
		try {
			while ((str = br.readLine()) != null) {
				StringTokenizer parse = new StringTokenizer(str);
				String name = parse.nextToken();
				if (name.contains(keyword)) {
					System.out.println(str);
					i++;
				}
			}
			System.out.println("");
			System.out.println("  " + i + "���� �˻� �����Ͱ� �߰ߵǾ����ϴ�. ");
			System.out.println("");
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
 
	}
 
	private static void search2() throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		System.out.println("ã���� �ϴ� å�� ���ڸ� �Է��Ͻÿ� : ");
		String keyword = "";
		keyword = scan.nextLine();
		int i = 0;
		String str = "";
		try {
			while ((str = br.readLine()) != null) {
				StringTokenizer parse = new StringTokenizer(str);
				String name = parse.nextToken();
				String maker = parse.nextToken();
				if (maker.contains(keyword)) {
					System.out.println(str);
					i++;
				}
			}
			System.out.println("");
			System.out.println("  " + i + "���� �˻� �����Ͱ� �߰ߵǾ����ϴ�. ");
			System.out.println("");
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
 
	}
 
	private static void search3() throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(filePath));
 
		System.out.println("ã���� �ϴ� å�� ������ �Է��Ͻÿ� : ");
		String keyword = "";
		keyword = scan.nextLine();
		int i = 0;
		String str = "";
		try {
			while ((str = br.readLine()) != null) {
				if (str.contains(keyword)) {
					System.out.println(str);
					i++;
				}
			}
			System.out.println("");
			System.out.println("  " + i + "���� �˻� �����Ͱ� �߰ߵǾ����ϴ�. ");
			System.out.println("");
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 
	private static void addbook() throws IOException {
 
		Book b = new Book();
		BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true));
		try {
			System.out.print("å �̸� : ");
			b.setName(scan.nextLine());
 
			System.out.print("å ���� : ");
			b.setMaker(scan.nextLine());
 
			System.out.print("å ���ǻ� : ");
			b.setPublisher(scan.nextLine());
 
			System.out.print("å ���� : ");
			b.setCost(scan.nextInt());
		} catch (Exception e) {
			System.out.println(" �߸��� ���� �Է��ϼ̽��ϴ�.  �����մϴ�. ");
			System.exit(0);
		}
 
		System.out.println();
		System.out.println("�Է°� Ȯ��");
 
		System.out.println(b.getName() + "\t" + b.getMaker() + "\t" + b.getPublisher() + "\t" + b.getCost());
		bw.write(b.getName() + "\t" + b.getMaker() + "\t" + b.getPublisher() + "\t" + b.getCost());
		bw.newLine();
		bw.close();
	}
 
	private static void deletebook() throws IOException {
 
		System.out.println("å�� ��ȣ�� ���� �����Ͻ÷��� 1��,\n" + "å�� �̸��� ���� �����Ͻ÷��� 2�� �� �Է����ּ���. : ");
		int delete = scan.nextInt();
 
		scan.nextLine();
		switch (delete) {
		case 1:
			delete1();
			break;
 
		case 2:
			delete2();
			break;
		default:
			System.out.println("�ٽ� �Է����ּ���.");
		}
 
	}
 
	public static void delete1() throws IOException {
		String tmpfilePath = filePath + ".tmp";
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		BufferedWriter bw = new BufferedWriter(new FileWriter(tmpfilePath));
		System.out.println("�����Ϸ��� å�� ��ȣ�� �Է����ּ��� : ");
		int deletenumber = scan.nextInt();
		int count = 1;
		String str = "";
		while ((str = br.readLine()) != null) {
			if (count != deletenumber) {
				bw.write(str);
				bw.newLine();
			}
			count++;
		}
		bw.close();
		br.close();
 
		FileInputStream fis = new FileInputStream(tmpfilePath);
		FileOutputStream fos = new FileOutputStream(filePath);
 
		int data = 0;
		while ((data = fis.read()) != -1) {
			fos.write(data);
		}
		fis.close();
		fos.close();
 
		File f1 = new File("C:\\test\\book.txt.tmp");
		f1.deleteOnExit();
 
	}
 
	public static void delete2() throws IOException {
		String tmpfilePath = filePath + ".tmp";
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		BufferedWriter bw = new BufferedWriter(new FileWriter(tmpfilePath));
		System.out.println("�����Ϸ��� å�� �̸��� �Է����ּ��� : ");
		String deletename = scan.nextLine();
 
		String str1 = "";
		while ((str1 = br.readLine()) != null) {
			if (!str1.contains(deletename)) {
				bw.write(str1);
				bw.newLine();
			}
 
		}
		
		bw.close();
		br.close();
 
		FileInputStream fis1 = new FileInputStream(tmpfilePath);
		FileOutputStream fos1 = new FileOutputStream(filePath);
 
		int data1 = 0;
		while ((data1 = fis1.read()) != -1) {
			fos1.write(data1);
		}
		fis1.close();
		fos1.close();
 
		File f1 = new File("C:\\test\\book.txt.tmp");
		f1.deleteOnExit();
 
	}
 
}