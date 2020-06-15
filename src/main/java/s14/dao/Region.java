package s14.dao;

public class Region {
	private long id;
    private String name;

    public Region() {
    }
    
	public Region(String name) {
    	this(0, name);
    }

    public Region(long id, String name) {
        this.id = id;
        this.name = name;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Region [id=" + id + ", region name=" + name + "]";
	}
    
}
