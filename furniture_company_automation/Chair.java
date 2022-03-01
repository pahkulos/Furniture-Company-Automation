
public class Chair extends AbstractProduct {
	

	Chair(int model,int color) throws IsNotValidException{
		super(7,5);
		if(isValid(model,color)) {
			setModel(model);
			setColor(color);
			setName("chair");
		}
		else
			throw new IsNotValidException("max model number of chair and max color number of chair: 7 and 5");
	
	}
	
	
	/**
     * Check if the aray are same.
     * @param o other object to compare them.
     * @return true if they are same. Otherwise return false.
     */
	@Override
    public boolean equals(Object o)
    {
		if(o instanceof Chair)
			return toString().equals(o.toString());
		
		return false;
    }
}
