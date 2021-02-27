public class Student<T> {
    
    private String name;
    private int age;

    Student()
    {
        name = null;
        age = 0;
    }
    Student(String nameInput, int ageInput)
    {
        name = nameInput;
        age = ageInput;
    }

    public String getName()
    {
        return name;
    }

}
