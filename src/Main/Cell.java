package Main;

public class Cell {

	private int id;
	private int status;

	public Cell(int id, int status) {
		super();
		this.id = id;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Cell [id=" + id + ", status=" + status + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
