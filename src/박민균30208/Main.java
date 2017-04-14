package 박민균30208;
 
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
				System.out.println("종료합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("다시 입력해 주세요.");
			}
		}
	}
 
	public static void display() {
		System.out.println("-- 도서관리 프로그램 --");
		System.out.println("1. 전체 도서 출력");
		System.out.println("2. 도서 검색");
		System.out.println("3. 도서 추가");
		System.out.println("4. 도서 폐기");
		System.out.println("0. 종료");
		System.out.println("----------------");
	}
 
	private static void printbook() throws FileNotFoundException {
		System.out.println("");
		System.out.println("----- 도서 목록 -----");
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
		System.out.println("------- 검색 -------");
		System.out.println("- 1. 이름 검색");
		System.out.println("- 2. 저자 검색");
		System.out.println("- 3. 통합 검색");
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
			System.out.println("다시 입력해주세요.");
		}
 
	}
 
	private static void search1() throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		System.out.println("찾고자 하는 책의 이름를 입력하시오 : ");
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
			System.out.println("  " + i + "개의 검색 데이터가 발견되었습니다. ");
			System.out.println("");
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
 
	}
 
	private static void search2() throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		System.out.println("찾고자 하는 책의 저자를 입력하시오 : ");
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
			System.out.println("  " + i + "개의 검색 데이터가 발견되었습니다. ");
			System.out.println("");
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
 
	}
 
	private static void search3() throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(filePath));
 
		System.out.println("찾고자 하는 책의 정보를 입력하시오 : ");
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
			System.out.println("  " + i + "개의 검색 데이터가 발견되었습니다. ");
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
			System.out.print("책 이름 : ");
			b.setName(scan.nextLine());
 
			System.out.print("책 저자 : ");
			b.setMaker(scan.nextLine());
 
			System.out.print("책 출판사 : ");
			b.setPublisher(scan.nextLine());
 
			System.out.print("책 가격 : ");
			b.setCost(scan.nextInt());
		} catch (Exception e) {
			System.out.println(" 잘못된 값을 입력하셨습니다.  종료합니다. ");
			System.exit(0);
		}
 
		System.out.println();
		System.out.println("입력값 확인");
 
		System.out.println(b.getName() + "\t" + b.getMaker() + "\t" + b.getPublisher() + "\t" + b.getCost());
		bw.write(b.getName() + "\t" + b.getMaker() + "\t" + b.getPublisher() + "\t" + b.getCost());
		bw.newLine();
		bw.close();
	}
 
	private static void deletebook() throws IOException {
 
		System.out.println("책의 번호를 통해 삭제하시려면 1번,\n" + "책의 이름을 통해 삭제하시려면 2번 을 입력해주세요. : ");
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
			System.out.println("다시 입력해주세요.");
		}
 
	}
 
	public static void delete1() throws IOException {
		String tmpfilePath = filePath + ".tmp";
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		BufferedWriter bw = new BufferedWriter(new FileWriter(tmpfilePath));
		System.out.println("삭제하려는 책의 번호를 입력해주세요 : ");
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
		System.out.println("삭제하려는 책의 이름을 입력해주세요 : ");
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