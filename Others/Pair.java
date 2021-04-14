//For customised sorting 
// for numbers
class Sortbyname implements Comparator<Student>
{
    // Used for sorting in ascending order of
    // name
    public int compare(Student a, Student b)
    {
        return a.name.compareTo(b.name);
    }
}
//for strings
class Sortbyroll implements Comparator<Student>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(Student a, Student b)
    {
        return a.rollno - b.rollno;
    }
}
/* ---- How to use ----
Arrays.sort(arr, new Sortbyname());
Collections.sort(arraylist, new Sortbyname());
*/