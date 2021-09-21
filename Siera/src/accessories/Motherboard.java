package accessories;


public class Motherboard extends Accessories{
	
	
	private String socket;
	private String memory;
	private Integer manyMemory;
	
	public Motherboard(String brand, String model, String socket, String memory, Integer manyMemory, Double price) {
		super();
		this.brand = brand;
		this.model = model;
		this.socket = socket;
		this.memory = memory;
		this.manyMemory = manyMemory;
		this.price = price;
	}
	
	public String getSocket() {
		return socket;
	}
	public void setSocket(String socket) {
		this.socket = socket;
	}
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	public Integer getManyMemory() {
		return manyMemory;
	}
	public void setManyMemory(Integer manyMemory) {
		this.manyMemory = manyMemory;
	}
	
	@Override
	public String toString() {
		return "Motherboard [brand=" + brand + ", model=" + model + ", socket=" + socket + ", memory=" + memory
				+ ", manyMemory=" + manyMemory + ", price=" + price + "]";
	}

}
