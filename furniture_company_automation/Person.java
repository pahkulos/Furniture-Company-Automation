/**
 * Person class. implement comparable interface.
 * @author UğurER_1901042262
 */
public abstract class Person implements Comparable<Person>
{
    private String name;
    private String surname;

    /*/**
     * Person's constructor.
     * @param name person's name.
     * @param surname person's surname.
     */
    public Person(String name, String surname)
    {
        setName(name);
        setSurname(surname);
    }

    /**
     * Getter function for name variable of person.
     * @return name of person.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Getter function for surname variable of person.
     * @return surname of person.
     */
    public String getSurname()
    {
        return surname;
    }

    /**
     * Setter function for name variable of person.
     * @param name of person.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Setter function for surname variable of person.
     * @param surname of person.
     */
    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    /**
     * Compare the other person.
     * @param other person to compare them
     * @return -1 if argument is null or not equal. return 0 if parameter and this are equal
     */
    @Override
    public int compareTo(Person other)
    {
        if(other == null)
            return -1;

        if(getName().equals(other.getName()) && getSurname().equals(other.getName()))
            return 0;

        return -1;
    }

    /**
     * Check whether the person and other person are the same.
     * @param o other person to compare this person.
     * @return true if other person and this person are same name,surname and id. Otherwise returns false.
     */
    @Override
    public boolean equals(Object o)
    {
        if(o == null)
            return false;
        if(!(o instanceof Person))
            return false;

        return getName().equals(((Person)o).getName()) && getSurname().equals(((Person)o).getSurname());
    }

    /**
     * Create a string representation of the container.
     * @return a string representation of the container.
     */
    @Override
    public String toString()
    {
        return String.format("Name: %s\nSurname: %s\n",getName(),getSurname());
    }
    
}