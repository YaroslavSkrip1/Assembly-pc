package accessories;

public class VideoCard extends  Accessories{
	
	private Integer frequency;
	private Integer memory;
	
	
	
	
	public Integer getFrequency() {
		return frequency;
	}
	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}
	public Integer getMemory() {
		return memory;
	}
	public void setMemory(Integer memory) {
		this.memory = memory;
	}
	
	
	
	public VideoCard(String brand, String model, Integer frequency, Integer memory, Double price) {
		super();
		this.brand = brand;
		this.model = model;
		this.frequency = frequency;
		this.memory = memory;
		this.price = price;
	}
	@Override
	public String toString() {
		return "VideoCard [brand=" + brand + ", model=" + model + ", frequency=" + frequency + ", memory=" + memory
				+ ", price=" + price + "]";
	}

}
