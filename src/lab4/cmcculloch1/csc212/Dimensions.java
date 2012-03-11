package lab4.cmcculloch1.csc212;

public class Dimensions {
	// This class is used for holding onto the strings used for setting up
	// the GUI state. This eliminates duplicated code and makes easier
	// maintenance.
	private String[] dimensions = {"2D", "3D"};
	public Dimensions(){
		
	}
	
	public String getDimension(int i){
		return dimensions[i];
	}

	public String[] getAll(){
		return dimensions;
	}
}
