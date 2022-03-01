/**
 * A generic array class.
 * @author UgurER
 * @param <E> the type of elements stored by this array.
 */
public class array<E> implements Cloneable {
	
	private E array[];
	private int capacity;
	private int usedSize;
	/**
     * Getter function for array capacity.
     * @return the capacity of the array.
     */
	public int getCapacity() {	return capacity;}
	
	private void setCapacity(int capacity) {this.capacity=capacity;}
	
	/**
     * Returns the number of elements in the array.
     * @return the number of elements in the array.
     */
	public int size() {return usedSize;}
	
	
	private void setUsed(int index) {
		this.usedSize = index;
	}
	/**
     * No parameter constructor. Capacity and usedSize are set to 0 and array is set to null.
     */
	public array() {
		array=null;
		setCapacity(0);
		setUsed(0);
	};
	/**
     * Removes from the array a single element.
     * @param o The element to be deleted.
     * @return true if remove operation is successful. Otherwise return false.
     */
	public boolean remove(E o) {
		int index=contains(o);
		
		if(index < 0)
            return false;
		
		@SuppressWarnings("unchecked")
		E[] temp = (E[])new Object[--capacity];
		
		for(int i=0,j=0;j<size();i++,j++) {
			if(j==index) {
				if(j+1!=size())
					temp[i]=array[++j];
				continue;
			}
			temp[i]=array[j];
		}
		array=null;
		array=temp;
		setUsed(size()-1);
		return true;
	}
	/**
     * Add element. 'equals' function must be override.
     * @param o new content to add the array.
     * @return true if the add operation is successful. Otherwise return false.
     */
	public boolean add(E o)
    {
		if(o == null)
			throw new NullPointerException();
		
		if(o instanceof AbstractProduct)
			if(((AbstractProduct) o).getName()==null)
				return false;
		
		if(!(o instanceof AbstractProduct)) 
			if(contains(o) >=0) 
				return false;
			
        if(getCapacity()==size()) 
        	increaseCapacity(getCapacity()*2); 
       
        array[size()] = o;
        
        setUsed(size()+1);

        return true;
    }
	/**
     * Add elements. 'equals' function must be override.
     * @param c new contents to add the array.
     * @return true if the add operation is successful. Otherwise return false.
     */
	public void addAll(array<E> c) {
		for(int i=0;i<c.size();i++)
			add(c.get(i));
	}
	/**
     * Makes indexing process.
     * @param index of array.
     * @return the data if index is valid. Otherwise returns false.
     * @throws ArrayIndexOutOfBoundsException if index is invalid, throws exception.
     */
	public E get(int index) throws ArrayIndexOutOfBoundsException
    {
		
        if(index < 0 || index >= size()) 
        	throw new ArrayIndexOutOfBoundsException("Invalid index!!!");
        
        return array[index];
    }
	
	@SuppressWarnings("unchecked")
	private void increaseCapacity(int capacity)
    {
        if(capacity <= 0) {
            capacity = 2;
            array=(E[])new Object[capacity];
            setCapacity(capacity);
        }
        else {
	        E[] temp = (E[])new Object[capacity];
	
	        for(int i=0 ; i < size(); ++i)
	            temp[i] = get(i);
	        
	        array = temp;
	        setCapacity(capacity);
        }
    }
	/**
     * Check if there is object in the container.
     * @param o element whose presence in this collection is to be tested.
     * @return index if this collection contains the specified element. Otherwise return -1.
     */
    public int contains(Object o)
    {
        if(o == null||array==null)
            return -1;

        for(int i=0 ; i < size() ; ++i)
            if(array[i].equals(o))
                return i;
        
        return -1;
    }
    /**
     * Makes a copy of itself.
     * @return returns clone of this.
     */
    @Override
    public Object clone()throws CloneNotSupportedException
    {
        return new array<E>();
    }

}
