package accessories;


public class Processor extends Accessories{
	@Override
	public String toString() {
		return "Processor [brand=" + brand + ", model=" + model + ", socket=" + socket + ", frequency=" + frequency
				+ ", manyCore=" + manyCore + ", cache=" + cache + ", price=" + price + "]";
	}
	
	private String socket;
	private Integer frequency;
	private Integer manyCore;
	private Integer cache;
	
	
	
	public String getSocket() {
		return socket;
	}
	public void setSocket(String socket) {
		this.socket = socket;
	}
	public Integer getFrequency() {
		return frequency;
	}
	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}
	public Integer getManyCore() {
		return manyCore;
	}
	public void setManyCore(Integer manyCore) {
		this.manyCore = manyCore;
	}
	public Integer getCache() {
		return cache;
	}
	public void setCache(Integer cache) {
		this.cache = cache;
	}
	public Processor(String brand, String model, String socket, Integer frequency, Integer manyCore, Integer cache,
			Double price) {
		super();
		this.brand = brand;
		this.model = model;
		this.socket = socket;
		this.frequency = frequency;
		this.manyCore = manyCore;
		this.cache = cache;
		this.price = price;
	}
//	public Processor() {
//		// TODO Auto-generated constructor stub
//	}
	

}
