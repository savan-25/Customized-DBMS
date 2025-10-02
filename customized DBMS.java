import java.util.*;
class Employee {
    public int Eno;
    public String Ename;
    public int Eage;
    public String Eaddress;
    public int Esalary;

    public static int Counter;

    static {
        Counter = 1;
    }

    public Employee(String B, int C, String D, int E) {
        Eno = Counter++;
        Ename = B;
        Eage = C;
        Eaddress = D;
        Esalary = E;
    }

    public void DisplayInformation() {
        System.out.println(Eno + "\t" + Ename + "\t" + Eaddress + "\t\t  " + Eage + "\t" + Esalary);
    }
}

class MarvellousDBMS {
    public LinkedList<Employee> lobj;
    private HashMap<Integer, Employee> indexById; // Auxiliary index for ID
    private HashMap<String, Employee> indexByName; // Auxiliary index for Name

    public MarvellousDBMS() {
        System.out.println("Marvellous DBMS started succesfully..");
        lobj = new LinkedList<Employee>();
        indexById = new HashMap<>();
        indexByName = new HashMap<>();
    }

    // insert into employee values("Piyush",34,"Pune",11000);
    public void InsertIntoTable(String name, int age, String address, int salary) {
        Employee eobj = new Employee(name, age, address, salary);
        lobj.addLast(eobj);

        // Update indexes
        indexById.put(eobj.Eno, eobj);
        indexByName.put(eobj.Ename, eobj);

        System.out.println("Record inserted succesfully into the table");
    }

    // select * from Emplyee;
    public void SelectStarFrom() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("No\t Name \t Address \t Age \t Salary ");
        System.out.println("----------------------------------------------------------------");
        for (Employee eref : lobj) {
            eref.DisplayInformation();
        }
        System.out.println("----------------------------------------------------------------");
    }

    // Select * from employee where Eno = 3
    public void SelectSpecific(int id) {
        Employee eref = indexById.get(id);
        if (eref != null) {
            eref.DisplayInformation();
        } else {
            System.out.println("No record found with ID: " + id);
        }
    }

    // Select * from employee where Ename = "Amit"
    public void SelectSpecific(String str) {
        Employee eref = indexByName.get(str);
        if (eref != null) {
            eref.DisplayInformation();
        } else {
            System.out.println("No record found with Name: " + str);
        }
    }

    // delete from Emplyee where Eno = 2
    public void DeleteData(int no) {
        Employee eref = indexById.remove(no);
        if (eref != null) {
            lobj.remove(eref);
            indexByName.remove(eref.Ename);
            System.out.println("Record deleted successfully with ID: " + no);
        } else {
            System.out.println("Unable to remove, record not found");
        }
    }

    // delete from Employee where Enmae = "Sagar"
    public void DeleteData(String str) {
        Employee eref = indexByName.remove(str);
        if (eref != null) {
            lobj.remove(eref);
            indexById.remove(eref.Eno);
            System.out.println("Record deleted successfully with Name: " + str);
        } else {
            System.out.println("Unable to remove, record not found");
        }
    }

    // select Count(Eno) from Employee
    public void AggregateCount() {
        System.out.println("Number of records in the Employee table : " + lobj.size());
    }

    // select Count(ESalary) from Employee
    public void AggregateSum() {
        int iSum = 0;

        for (Employee eref : lobj) {
            iSum = iSum + eref.Esalary;
        }

        System.out.println("Summation of records in the Employee table : " + iSum);
    }

    // select Avg(ESalary) from Employee
    public void AggregateAvg() {
        int iSum = 0;

        for (Employee eref : lobj) {
            iSum = iSum + eref.Esalary;
        }

        System.out.println("Average of records in the Employee table : " + (iSum / lobj.size()));
    }

    // select Max(ESalary) from Employee
    public void AggregateMax() {
        int iMax = lobj.get(0).Esalary;

        for (Employee eref : lobj) {
            if (eref.Esalary > iMax) {
                iMax = eref.Esalary;
            }
        }

        System.out.println("Maximum of records in the Employee table : " + iMax);
    }

    // select Min(ESalary) from Employee
    public void AggregateMin() {
        int iMin = lobj.get(0).Esalary;

        for (Employee eref : lobj) {
            if (eref.Esalary < iMin) {
                iMin = eref.Esalary;
            }
        }

        System.out.println("Minimum of records in the Employee table : " + iMin);
    }

    // Update Employee Set Address = "Sangli" where Eno = 3;
    public void UpdateRecord(int no, String address) {
        // int index = 0;

        // for(Employee eref : lobj)
        // {
        // if(eref.Eno == no)
        // {
        // eref.Eaddress = address;
        // lobj.set(index,eref);
        // break;
        // }
        // index++;
        // }
        Employee eref = indexById.get(no);
        if (eref != null) {
            eref.Eaddress = address;
            System.out.println("Record updated successfully for ID: " + no);
        } else {
            System.out.println("Record not found with ID: " + no);
        }

    }
}

public class Program569 {

    public static int readInt(Scanner sc, String message) {
    while (true) {
        System.out.print(message + ": ");
        try {
            // int value = sc.nextInt();   // expects number
            // sc.nextLine();              // consumes newline
            return sc.nextInt();               // ✅ if input is a number → return immediately
        } 
        catch (InputMismatchException e) {
            System.out.println("nvalid input! Please enter a number.");
            sc.nextLine(); // clear wrong input
        }
    }
}
    public static String readLine(Scanner sc, String message) {
    while (true) {
        System.out.print(message + ": ");
        try{

          return sc.nextLine();   // expects number
            //sc.nextLine();              // consumes newline
                       // ✅ if input is a number → return immediately
        } 
        catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a number.");
            sc.nextLine(); // clear wrong input
        }
    }


}

    public static void main(String Arg[]) {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Welcome to Marvellous DBMS");

        MarvellousDBMS mobj = new MarvellousDBMS();

        int iOption = 0;
        // String name = "";
        // int age = 0, salary = 0;
        // String address = "";
        // int id = 0;

        while (true) {
            System.out.println("-----------------------------------------------------");
            System.out.println("Please select your option based on your requirement");

            System.out.println("1 : Insert new record in the table");
            System.out.println("2 : Display all records from the table");
            System.out.println("3 : Display specific record from the table with ID");
            System.out.println("4 : Display specific record from the table with Name");
            System.out.println("5 : Delete the record from table with Name");
            System.out.println("6 : Count number of records from the table");
            System.out.println("7 : Summation of all records salaray");
            System.out.println("8 : Average of all records salaray");
            System.out.println("9 : Maximum of all records salaray");
            System.out.println("10 : Minimum of all records salaray");
            System.out.println("11 : Update the existing record");
            System.out.println("12 : Delete the table");
            System.out.println("13 : Terminate the Marvellous DBMS");

            System.out.println("-----------------------------------------------------");
            iOption = sobj.nextInt();

            if (iOption == 1) {
                // System.out.println("Enter the name of emplyee");
                // name = sobj.next();

                // System.out.println("Enter the age of emplyee");
                // age = sobj.nextInt();

                // System.out.println("Enter the salary of emplyee");
                // salary = sobj.nextInt();

                // System.out.println("Enter the address of emplyee");
                // address = sobj.next();
                sobj.nextLine(); // clear buffer
                String name = readLine(sobj, "Enter employee name");
                int age = readInt(sobj, "Enter employee age");
                int salary = readInt(sobj, "Enter employee salary");
                sobj.nextLine(); // clear buffer
                String address = readLine(sobj, "Enter employee address");
                mobj.InsertIntoTable(name, age, address, salary);
            } else if (iOption == 2) {
                mobj.SelectStarFrom();
            } else if (iOption == 3) {
                System.out.println("Enter the employee ID whose data you want to display");
                int id = sobj.nextInt();

                mobj.SelectSpecific(id);
            } else if (iOption == 4) {
                System.out.println("Enter the employee name whose data you want to display");
                String name = sobj.next();

                mobj.SelectSpecific(name);
            } else if (iOption == 5) {
                System.out.println("Enter the employee name that you want to delete");
                String name = sobj.next();

                mobj.DeleteData(name);
            } else if (iOption == 6) {
                mobj.AggregateCount();
            } else if (iOption == 7) {
                mobj.AggregateSum();
            } else if (iOption == 8) {
                mobj.AggregateAvg();
            } else if (iOption == 9) {
                mobj.AggregateMax();
            } else if (iOption == 10) {
                mobj.AggregateMin();
            } else if (iOption == 11) {
                System.out.println("Enter the ID of emplyee that you want to update");
                int id = sobj.nextInt();

                System.out.println("Enter the new address");
                String address = sobj.next();

                mobj.UpdateRecord(id, address);
            } else if (iOption == 12) {
                mobj = null;
                System.gc();
                System.out.println("Database deleted succesfully");
            } else if (iOption == 13) {
                System.out.println("Thank you for using Marvellous DBMS");
                break;
            } else {
                System.out.println("Invalid option");
            }
        }
    }

}
