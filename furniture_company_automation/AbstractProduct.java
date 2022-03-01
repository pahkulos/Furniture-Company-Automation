/**
 * An abstract AbstractProduct class extends Product.
 * @author UgurER
 */
public  abstract class AbstractProduct implements Product {

	private int model;
	private int color;
	private String name;
	private int maxModelNum, maxColorNum;
	
	/**
	 * 
	 * @param maxModelNum maximum model number
	 * @param maxColorNum maximum color number
	 */
	AbstractProduct(int maxModelNum, int maxColorNum){
		setMaxColorNum(maxColorNum);
		setMaxModelNum(maxModelNum);
	}
	
	/**
     * Getter function for max model number.
     * @return maximum model number.
     */
	@Override
	public int getMaxModelNum() {return maxModelNum;}
	
	/**
     * Getter function for max color number.
     * @return maximum color number.
     */
	@Override
	public int getMaxColorNum() {return maxColorNum;}
	
	/**
     * Getter function for model number.
     * @return model.
     */
	protected int getModel() {
		return model;
	}
	
	/**
	 * Setter function for model number.
	 * @param model
	 */
	protected void setModel(int model) {
		this.model = model;
	}
	
	/**
	 * Getter function for color number.
	 * @return color
	 */
	protected int getColor() {
		return color;
	}
	
	/**
	 * Setter function for color number.
	 * @param color
	 */
	protected void setColor(int color) {
		this.color = color;
	}
	
	/**
	 * Setter function for max model number.
	 * @param maximum model number
	 */
	protected void setMaxModelNum(int maxModelNum) {
		this.maxModelNum = maxModelNum;
	}
	
	/**
	 * Setter function for max color number.
	 * @param maximum color number
	 */
	protected void setMaxColorNum(int maxColorNum) {
		this.maxColorNum = maxColorNum;
	}
	
	/**
	 * Getter function for product name.
	 * @param product name
	 */
	protected String getName() {
		return name;
	}
	
	/**
	 * Setter function for product name.
	 * @param product name
	 */
	protected void setName(String name) {
		this.name = name;
	}
	
	/** if model and color number grater than maximum's return false else return true
	 * @param model number
	 * @param color number
	 * @return boolean
	 */
	@Override 
	public boolean isValid(int modelNum, int colorNum) {
		if((modelNum>maxModelNum || modelNum<=0) || (colorNum>maxColorNum || colorNum<=0) )
			return false;
		else
			return true;
	}
	@Override
	public String toString() {
		return String.format("%s   model: %d	color: %d \n",getName(),getModel(),getColor());
	}
}
