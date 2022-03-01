/**
 * Bookcase class extends AbstractProduct.
 * @author UgurER
 */
public class Bookcase extends AbstractProduct {
	/**
	 * One parameter constructor. takes model 1 to 12
	 * @param model takes model 
	 * @throws IsNotValidException if model number grater than 12 throws exception
	 */
	Bookcase(int model) throws IsNotValidException {
		super(12,1);
		if(isValid(model,1)) {
		setModel(model);
		setColor(1);
		setName("bookcase");
		}
		else
			throw new IsNotValidException("max model number of chair and max color number of chair: 12 and 1");
	}

	/**
     * Check if the array are same.
     * @param o other object to compare them.
     * @return true if they are some. Otherwise return false.
     */
	@Override
    public boolean equals(Object o)
    {
		if(o instanceof Bookcase)
			return toString().equals(o.toString());
		
		return false;
    }

}
