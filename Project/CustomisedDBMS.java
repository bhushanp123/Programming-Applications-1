import java.util.*;

class Student
{
    public int RID;
    public String Name;
    public int Salary;
    public int Age;

    public static int Generator;

    static
    {
        Generator = 0;
    }

    public Student(String str, int value, int No)
    {
        this.RID = ++Generator;
        this.Name = str;
        this.Salary = value;
        this.Age = No;
    }

    public void DisplayData()
    {
        System.out.println(this.RID + "\t" + this.Name + "\t" + this.Salary + "\t" + this.Age);
    }
}

class DBMS
{
    public LinkedList <Student>lobj;

    public DBMS()
    {
        lobj = new LinkedList<>();
    }

    public void StartDBMS()
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Customised DBMS started succesfully....");
        String Query = "";

        while(true)
        {
            System.out.print("DBMS console >");
            Query = sobj.nextLine();

            String tokens[] = Query.split(" ");
            int QuerySize = tokens.length;

            if(QuerySize == 1)
            {
                if("Help".equals(tokens[0]))
                {
                    System.out.println("This application is used to demonstrates the customised DBMS");
                    System.out.println("Exit : Terminate DBMS");
                    System.out.println("Display all data : select * from student");
                    System.out.println("Insert data : Insert into student Name Salary Age");
                    System.out.println("Display students count : Display Count");
                    System.out.println("Display by RID : Display rid Student_RID");
                    System.out.println("Display by Name : Display student Student_Name");
                    System.out.println("Display by Age : Display age Student_Age");
                    System.out.println("Display maximum salary : Display max salary");
                    System.out.println("Display minimum salary : Display min salary");
                    System.out.println("Display total salary : Display total salary");
                    System.out.println("Display average salary : Display avg salary");
                    System.out.println("Display average age : Display average age");
                    System.out.println("Delete by RID : Delete rid Student_RID");
                    System.out.println("Delete by Name : Delete student Student_Name");
                    System.out.println("Delete by Age : Delete age Student_Age");
                    System.out.println("Delete maximum salary : Delete max salary");
                    System.out.println("Delete minimum salary : Delete min salary");
                }
                else if("Exit".equals(tokens[0]))
                {
                    System.out.println("Thank you for using DBMS");
                    return;
                }
            }
            else if(QuerySize == 2)
            {
                if("Count".equals(tokens[1]))
                {
                    Display_Count();
                }
            }
            else if(QuerySize == 3)
            {
                if("Display".equals(tokens[0]))
                {
                    if("rid".equals(tokens[1]))
                    {
                        Display_By_RID(Integer.parseInt(tokens[2]));
                    }
                    else if("student".equals(tokens[1]))
                    {
                        Display_By_Name(tokens[2]);
                    }
                    else if("age".equals(tokens[1]))
                    {
                        Display_By_Age(Integer.parseInt(tokens[2]));
                    }
                    else if("max".equals(tokens[1]))
                    {
                        Display_Max_Salary();
                    }
                    else if("min".equals(tokens[1]))
                    {
                        Display_Min_Salary();
                    }
                    else if("total".equals(tokens[1]))
                    {
                        Display_Total_Salary();
                    }
                    else if("avg".equals(tokens[1]))
                    {
                        Display_Average_Salary();
                    }
                    else if("average".equals(tokens[1]))
                    {
                        Display_Average_Age();
                    }
                }
                else if("Delete".equals(tokens[0]))
                {
                    if("rid".equals(tokens[1]))
                    {
                        Delete_By_RID(Integer.parseInt(tokens[2]));
                    }
                    else if("student".equals(tokens[1]))
                    {
                        Delete_By_Name(tokens[2]);
                    }
                    else if("age".equals(tokens[1]))
                    {
                        Delete_By_Age(Integer.parseInt(tokens[2]));
                    }
                    else if("max".equals(tokens[1]))
                    {
                        Delete_Max_Salary();
                    }
                    else if("min".equals(tokens[1]))
                    {
                        Delete_Min_Salary();
                    }
                }
            }
            else if(QuerySize == 4)
            {
                if("Select".equals(tokens[0]))
                {
                    if("*".equals(tokens[1]))
                    {
                        DisplayAll();
                    }
                }               
                
            }
            else if(QuerySize == 5)
            {

            }
            else if(QuerySize == 6)
            {
                if("Insert".equals(tokens[0]))
                {
                    InsertData(tokens[3], Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]));
                }
            }
        }
        
    }


    public void InsertData(String str, int value, int No)
    {
        Student sobj = new Student(str,value,No);

        lobj.add(sobj);
    }

    public void DisplayAll()
    {
        System.out.println("RID" + "\t" + "Name" + "\t" + "Salary" + "\t" + "Age");

        for(Student sref : lobj)
        {
            sref.DisplayData();
        }
    }

    public void Display_By_RID(int rid)
    {
        System.out.println("RID" + "\t" + "Name" + "\t" + "Salary" + "\t" + "Age");

        for(Student sref : lobj)
        {
            if(sref.RID == rid)
            {
                sref.DisplayData();
                break;
            }
        }
    }

    public void Display_By_Name(String str)
    {
        System.out.println("RID" + "\t" + "Name" + "\t" + "Salary" + "\t" + "Age");

        for(Student sref : lobj)
        {
            if(str.equals(sref.Name))
            {
                sref.DisplayData();
                break;
            }
        }
    }

    public void Display_By_Age(int No)
    {
        System.out.println("RID" + "\t" + "Name" + "\t" + "Salary" + "\t" + "Age");

        for(Student sref : lobj)
        {
            if(sref.Age == No)
            {
                sref.DisplayData();
                break;
            }
        }
    }

    public void Delete_By_RID(int rid)
    {
        for(Student sref : lobj)
        {
            if(sref.RID == rid)
            {
                lobj.remove(sref);
                break;
            }
        }
    }

    public void Delete_By_Name(String str)
    {  
        for(Student sref : lobj)
        {
            if(str.equals(sref.Name))
            {
                lobj.remove(sref);
                break;
            }
        }
    }

    public void Delete_By_Age(int No)
    {
        for(Student sref : lobj)
        {
            if(sref.Age == No)
            {
                lobj.remove(sref);
                break;
            }
        }
    }

    public void Display_Max_Salary()
    {
        int iMax = 0;
        Student temp = null;

        for(Student sref : lobj)
        {
            if(sref.Salary > iMax)
            {
                iMax = sref.Salary;
                temp = sref;
            }
        }
        System.out.println("Information of student having maximum salary : ");
        System.out.println("RID" + "\t" + "Name" + "\t" + "Salary" + "\t" + "Age");
        temp.DisplayData();
    }

    public void Display_Min_Salary()
    {
        int iMin = (lobj.getFirst()).Salary;
        Student temp = lobj.getFirst();

        for(Student sref : lobj)
        {
            if(sref.Salary < iMin)
            {
                iMin = sref.Salary;
                temp = sref;
            }
        }

        System.out.println("Information of student having minimum salary : ");
        System.out.println("RID" + "\t" + "Name" + "\t" + "Salary" + "\t" + "Age");
        temp.DisplayData();
    }

    public void Display_Total_Salary()
    {
        long iSum = 0;

        for(Student sref : lobj)
        {
            iSum = iSum + sref.Salary;
        }

        System.out.println("Summation of salaries is : "+ iSum);
    }

    public void Display_Average_Salary()
    {
        long iSum = 0;

        for(Student sref : lobj)
        {
            iSum = iSum + sref.Salary;
        }

        System.out.println("Average salary is : "+ iSum / (lobj.size()));
    }

    public void Display_Average_Age()
    {
        int iSum = 0;

        for(Student sref : lobj)
        {
            iSum = iSum + sref.Age;
        }
        System.out.println("Average age is : "+ iSum / (lobj.size()));
    }

    public void Delete_Max_Salary()
    {
        int iMax = 0;
        Student temp = null;

        for(Student sref : lobj)
        {
            if(sref.Salary > iMax)
            {
                iMax = sref.Salary;
                temp = sref;
            }
        }

        lobj.remove(temp);
    }

    public void Delete_Min_Salary()
    {
        int iMin = (lobj.getFirst()).Salary;
        Student temp = lobj.getFirst();

        for(Student sref : lobj)
        {
            if(sref.Salary < iMin)
            {
                iMin = sref.Salary;
                temp = sref;
            }
        }

        lobj.remove(temp);
    }

    public void Display_Count()
    {
        System.out.println("Count is : "+lobj.size());
    }

}

class CustomisedDBMS
{
    public static void main(String[] args) 
    {
        DBMS dobj = new DBMS();

        dobj.StartDBMS();

    }
}
