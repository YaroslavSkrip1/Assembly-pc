
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import accessories.Memory;
import accessories.Motherboard;
import accessories.Processor;
import accessories.VideoCard;

public class Main {

	public static void main(String[] args) throws Exception {
		while (true) {
			System.out.println("Складаєм системний блок.");

			List<Processor> processor = Arrays.asList(addProcessor());
			List<Motherboard> motherboard = Arrays.asList(addMotherboard());
			List<Memory> memory = Arrays.asList(addMemory());
			List<VideoCard> videoCard = Arrays.asList(addVideoCard());

			Processor processorM = processor(processor);
			Motherboard motherboardM = motherboard(motherboard, processorM);
			List<Memory> memoryM = memory(memory, motherboardM);
			VideoCard videoCardM = videoCard(videoCard);

			sum(processorM, motherboardM, memoryM, videoCardM);

			System.out.println("Повторити? <<<0.Ні>>>");
			Scanner scanner = new Scanner(System.in);
			if ("0".equals(scanner.nextLine()))
				break;
		}
	}

	public static Processor[] addProcessor() throws Exception{
		Processor[] processor = { new Processor("AMD", "Bristol Ridge A6 2C/2T 9400", "AM4", 3500, 4, 2, 61.05),
				new Processor("AMD", "FX-Series X4 4350", "AM3", 4200, 4, 12, 56.06),
				new Processor("AMD", "FX-Series X8 8320", "AM3", 3500, 8, 16, 66.00),
				new Processor("Intel", "Core i5-9400", "s1151", 2900, 6, 9, 226.50),
				new Processor("Intel", "Core i3-10100F", "s1200", 3600, 4, 6, 128.76),
				new Processor("Intel", "Core i5-9600К", "s1151", 3700, 6, 9, 291.00) };
//		try(DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("processor.txt"))){
//			for (int i=0;i<processor.length;i++) {
//		dataOutputStream.writeUTF(processor[i].getBrand());	
//		dataOutputStream.writeUTF(processor[i].getModel());
//		dataOutputStream.writeUTF(processor[i].getSocket());
//		dataOutputStream.writeInt(processor[i].getFrequency());
//		dataOutputStream.writeInt(processor[i].getManyCore());
//		dataOutputStream.writeInt(processor[i].getCache());
//		dataOutputStream.writeDouble(processor[i].getPrice());
//			}
//		}
		
		try(DataInputStream dataInputStream = new DataInputStream(new FileInputStream("processor.txt"))){
			List <Processor> procc;
			Processor proc=new Processor(dataInputStream.readUTF(),dataInputStream.readUTF(),dataInputStream.readUTF(),dataInputStream.readInt(),dataInputStream.readInt(),dataInputStream.readInt(),dataInputStream.readDouble());
//			proc.setBrand(dataInputStream.readUTF());
//			proc.setModel(dataInputStream.readUTF());
//			proc.setSocket(dataInputStream.readUTF());
//			proc.setFrequency(dataInputStream.readInt());
//			proc.setManyCore(dataInputStream.readInt());
//			proc.setCache(dataInputStream.readInt());
//			proc.setPrice(dataInputStream.readDouble());
//		processor.add(proc);	
			
		}
		
//		Processor[] processor= new Processor() ;
		return processor;
	}

	public static Motherboard[] addMotherboard() {
		Motherboard[] motherboard = { new Motherboard("Asus", "PRIME H410M-E", "s1200", "DDR4", 2, 84.36),
				new Motherboard("Asus", "PRIME B360M-C", "s1151", "DDR4", 4, 113.40),
				new Motherboard("GigaByte", "H310M A 2.0", "s1151", "DDR4", 2, 78.50),
				new Motherboard("Asus", "M5A78L-M LX3", "AM3", "DDR3", 2, 59.62),
				new Motherboard("ASRock", "H470M-ITX/AC", "s1200", "DDR4", 4, 160.26),
				new Motherboard("AsRock", "B450 PRO4", "AM4", "DDR4", 4, 98.49) };
		return motherboard;
	}

	public static Memory[] addMemory() {
		Memory[] memory = { new Memory("Goodram", "DDR3", 2, 1333, 18.20), new Memory("AMD", "DDR3", 4, 1600, 20.00),
				new Memory("Goodram", "DDR3", 8, 1600, 35.96), new Memory("Apacer", "DDR4", 4, 2666, 21.84),
				new Memory("Apacer", "DDR4", 8, 2400, 54.05), new Memory("Apacer", "DDR4", 16, 2400, 91.87) };
		return memory;
	}

	public static VideoCard[] addVideoCard() {
		VideoCard[] videoCard = { new VideoCard("GigaByte", "GeForce GT 730", 64, 2, 76.31),
				new VideoCard("Sapphire", "Radeon RX 550 PULSE", 128, 4, 107.84) };
		return videoCard;
	}

	public static Processor processor(List<Processor> processor) {
		Processor processorM = null;
		Set<String> brand = new HashSet<String>();
		for (int i = 0; i < processor.size(); i++)
			brand.add(processor.get(i).getBrand());
		ArrayList<String> list = new ArrayList<>();
		list.addAll(brand);
		String proc = list.get(0);
		boolean ch = true;
		while (ch) {
			ch = false;
			System.out.println("На базі якого процесора буде складенно комп’ютер");
			for (int i = 0; i < list.size(); i++)
				System.out.println((i + 1) + ". " + list.get(i));

			try {
				Scanner scanner = new Scanner(System.in);
				proc = list.get(scanner.nextInt() - 1);
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Невірний вибір");
				ch = true;
			} catch (InputMismatchException e) {
				System.out.println("Некоректний ввід");
				ch = true;
			}

		}

		List<Processor> processor2 = new ArrayList<>();

		for (int i = 0; i < processor.size(); i++)
			if (processor.get(i).getBrand().equals(proc))
				processor2.add(processor.get(i));
		ch = true;
		while (ch) {
			ch = false;
			System.out.println("Оберіть процесор");
			for (int i = 0; i < processor2.size(); i++)
				System.out.println((i + 1) + ". " + processor2.get(i).toString());

			try {
				Scanner scanner = new Scanner(System.in);
				processorM = processor2.get(scanner.nextInt() - 1);
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Невірний вибір");
				ch = true;
			} catch (InputMismatchException e) {
				System.out.println("Некоректний ввід");
				ch = true;
			}
		}
		return processorM;
	}

	public static Motherboard motherboard(List<Motherboard> motherboard, Processor processorM) {
		Motherboard motherboardM = null;
		List<Motherboard> motherboard2 = new ArrayList<>();
		for (int i = 0; i < motherboard.size(); i++)
			if (motherboard.get(i).getSocket().equals(processorM.getSocket()))
				motherboard2.add(motherboard.get(i));
		boolean ch = true;
		while (ch) {
			ch = false;

			System.out.println("Оберіть материнську плату");
			for (int i = 0; i < motherboard2.size(); i++)
				System.out.println((i + 1) + ". " + motherboard2.get(i).toString());
			try {
				Scanner scanner = new Scanner(System.in);
				motherboardM = motherboard2.get(scanner.nextInt() - 1);
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Невірний вибір");
				ch = true;
			} catch (InputMismatchException e) {
				System.out.println("Некоректний ввід");
				ch = true;
			}
		}
		return motherboardM;
	}

	public static List<Memory> memory(List<Memory> memory, Motherboard motherboardM) {
		System.out.println("Оберіть оперативну пам’ять:");
		List<Memory> memory2 = new ArrayList<>();
		List<Memory> memoryM = new ArrayList<>();
		for (int i = 0; i < memory.size(); i++)
			if (memory.get(i).getModel().equals(motherboardM.getMemory()))
				memory2.add(memory.get(i));
		boolean ch = true;
		while (ch) {
			ch = false;
			for (int i = 0; i < memory2.size(); i++)
				System.out.println((i + 1) + ". " + memory2.get(i).toString());

			try {
				Scanner scanner = new Scanner(System.in);
				memoryM.add(memory2.get(scanner.nextInt() - 1));
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Невірний вибір");
				ch = true;
			} catch (InputMismatchException e) {
				System.out.println("Некоректний ввід");
				ch = true;
			}
		}

		Boolean ddr = true;
		while (ddr) {
			ch = true;
			Integer m = 0;
			while (ch) {
				ch = false;
				System.out.println("Додати ще оперативної пам’яті 1.Так/ 0.Ні: ");
				try {
					Scanner scanner = new Scanner(System.in);
					m = scanner.nextInt();
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Невірний вибір");
					ch = true;
				} catch (InputMismatchException e) {
					System.out.println("Некоректний ввід");
					ch = true;
				}
			}
			if (m == 1) {
				ch = true;

				while (ch) {
					ch = false;
					System.out.println("Оберіть оперативну пам’ять:");
					for (int i = 0; i < memory2.size(); i++)
						System.out.println((i + 1) + ". " + memory2.get(i).toString());
					try {
						Scanner scanner = new Scanner(System.in);
						memoryM.add(memory2.get(scanner.nextInt() - 1));
					} catch (IndexOutOfBoundsException e) {
						System.out.println("Невірний вибір");
						ch = true;
					} catch (InputMismatchException e) {
						System.out.println("Некоректний ввід");
						ch = true;
					}
				}
			}
			if (memoryM.size() == motherboardM.getManyMemory() || m == 0)
				ddr = false;
		}
		return memoryM;
	}

	public static VideoCard videoCard(List<VideoCard> videoCard) {
		VideoCard videoCardM = null;
		boolean ch = true;
		while (ch) {
			ch = false;
			System.out.println("Виберіть відеокарту:");
			for (int i = 0; i < videoCard.size(); i++)
				System.out.println((i + 1) + ". " + videoCard.get(i).toString());
			try {
				Scanner scanner = new Scanner(System.in);
				videoCardM = videoCard.get(scanner.nextInt() - 1);
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Невірний вибір");
				ch = true;
			} catch (InputMismatchException e) {
				System.out.println("Некоректний ввід");
				ch = true;
			}

		}
		return videoCardM;
	}

	public static void sum(Processor processorM, Motherboard motherboardM, List<Memory> memoryM, VideoCard videoCardM) {
		Double sum = 0.0;
		System.out.println("Ви склали комп’ютер:");
		System.out.println(processorM + "\n" + motherboardM);
		sum = sum + processorM.getPrice() + motherboardM.getPrice();
		for (int i = 0; i < memoryM.size(); i++) {
			System.out.println(memoryM.get(i));
			sum = sum + memoryM.get(i).getPrice();
		}
		System.out.println(videoCardM);
		sum = sum + videoCardM.getPrice();
		System.out.println("Загальна вартість: " + sum + "$");

	}
}