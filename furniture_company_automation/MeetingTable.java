
public class MeetingTable extends AbstractProduct{
	
	MeetingTable(int model,int color) throws IsNotValidException {
		super(10,4);
		if(isValid(model,color)) {
		setModel(model);
		setColor(color);
		setName("meetingTable");
		}
		else
			throw new IsNotValidException("max model number of chair and max color number of chair: 10 and 4");
	}

	/**
     * Check if the aray are same.
     * @param o other object to compare them.
     * @return true if they are same. Otherwise return false.
     */
	@Override
    public boolean equals(Object o)
    {
		if(o instanceof MeetingTable)
			return toString().equals(o.toString());
		
		return false;
    }
}
