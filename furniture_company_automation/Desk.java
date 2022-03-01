
public class Desk extends AbstractProduct{

	Desk(int model,int color) throws IsNotValidException {
		super(5,4);
		if(isValid(model,color)) {
		setModel(model);
		setColor(color);
		setName("desk");
		}
		else
			throw new IsNotValidException("max model number of chair and max color number of chair: 5 and 4");
	}
	
	/**
     * Check if the aray are same.
     * @param o other object to compare them.
     * @return true if they are same. Otherwise return false.
     */
	@Override
    public boolean equals(Object o)
    {
		if(o instanceof Desk)
			return toString().equals(o.toString());
		
		return false;
    }
}
