package entity;

public class Guitar {
	private int id;
	private String make;
	private String model;
	
	public Guitar(int id, String make, String model) {
		this.setId(id);
		this.setMake(make);
		this.setModel(model);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
}
