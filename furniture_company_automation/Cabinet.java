
public class Cabinet extends AbstractProduct {
	
	Cabinet(int model) throws IsNotValidException {
		super(12,1);
		if(isValid(model,1)) {
		setModel(model);
		setColor(1);
		setName("cabinet");
		}
		else
			throw new IsNotValidException("max model number of chair and max color number of chair: 12 and 1");
	}
	
	/**
     * Check if the array are same.
     * @param o other object to compare them.
     * @return true if they are same. Otherwise return false.
     */
	@Override
    public boolean equals(Object o)
    {
		if(o instanceof Cabinet)
			return toString().equals(o.toString());
		
		return false;
    }

}
