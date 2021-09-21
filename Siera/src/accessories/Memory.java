package accessories;

public class Memory extends Accessories{
	
	
	
	private Integer memory;
	private Integer frequency;
	
	public Memory(String brand, String model, Integer memory, Integer frequency, Double price) {
		super();
		this.brand = brand;
		this.model = model;
		this.memory = memory;
		this.frequency = frequency;
		this.price = price;
	}
	
	public Integer getMemory() {
		return memory;
	}
	public void setMemory(Integer memory) {
		this.memory = memory;
	}
	public Integer getFrequency() {
		return frequency;
	}
	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}
	
	@Override
	public String toString() {
		return "Memory [brand=" + brand + ", model=" + model + ", memory=" + memory + ", frequency=" + frequency
				+ ", price=" + price + "]";
	}

}
