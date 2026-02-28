
public class Student
{
    private String name;
    private int age;
    private String school;
    private int grade;
    private String citizenship;
    private String phone;
   
    public Student(String name, int age, String school, int grade, String citizenship, String phone){
        this.name = name;
        this.age = age;
        this.school = school;
        this.grade = grade;
        this.citizenship = citizenship;
        this.phone = phone;
    }
   
    public String getName(){ return name; }
    public int getAge(){ return age; }
    public int getGrade(){ return grade; }
    public String getSchool(){ return school; }
    public String getCitizenship(){ return citizenship; }
    public String getPhone(){ return phone; }
   
    public String getNameInitials(){
        String[] parts = name.split(" ");
        String initials = "";
        for(String x : parts){
            initials = initials + x.charAt(0) + ".";
        }
        return initials;
    }
   
       public String toString(){
        return String.format("%s | %d | Grade %d | %s", name, age, grade, school);
    }
}

public class CensusProcessor
{
  public static Student[] parseCSV(String[] csvData){
    Student[] students = new Student[csvData.length - 1];
    int index = 0;
    for(int i = 1; i < csvData.length; i++){
      String[] parts = csvData[i].split(",");
      String name = parts[0].trim();
      int age = Integer.parseInt(parts[1].trim());
      String school = parts[2].trim();
      int grade = Integer.parseInt(parts[3].trim());
      String citizenship = parts[4].trim();
      String phone = parts[5].trim();

      students[index++] = new Student(name, age, school, grade, citizenship, phone);
    }
    return students;
  }

  public static boolean isValidCitizenship(String cit){
    if(cit.length() != 10) return false;
    if(cit.charAt(2) != '-') return false;
    return true;
  }

  public static double averageAge(Student[] students){
    double sum = 0;
    for(Student s : students) sum += s.getAge();
    return sum / students.length;
  }

  public static Student findLongestName(Student[] students){
    Student longest = students[0];
    for(Student s : students){
      if(s.getName().length() > longest.getName().length()){
        longest = s;
      }
    }
    return longest;
  }

  public static String generateCensusReport(Student[] students){
    StringBuilder report = new StringBuilder();
    report.append("\n==== Nepal School Census Report ====\n");
    int valid = 0, invalid = 0;
    for(Student s : students){
      if(isValidCitizenship(s.getCitizenship())) valid++;
      else invalid++;
    }
    report.append("Total Students: ").append(students.length);
    report.append("\nValid Citizenship: ").append(valid);
    report.append("\nInvalid Citizenship: ").append(invalid);
    report.append("\n- Student List -\n");
    for(Student s : students){
      boolean ok = isValidCitizenship(s.getCitizenship());
      report.append(String.format("%s %s Age: %d Grade: %d %s\n",
            s.getNameInitials(), s.getName(), s.getAge(), s.getGrade(), ok ? "Valid" : "Invalid"));
    }
    report.append("\nAverage Age: ").append(String.format("%.2f", averageAge(students)));
    report.append("\nLongest Name: ").append(findLongestName(students).getName());
    return report.toString();
  }
}


public class testMain
{
  public static void main(String[] args){
    String[] csvData = {
      "Name,Age,School,Grade,Citizenship,Phone",
      "Ram Bahadur Thapa,18,Itahari Int. College,12,01-0012345,9841234567",
      "Sita Kumari Rai,17,Itahari Int. College,11,01-0054321,9807654321",
      "Hari Prasad Sharma,19,ICK College,12,02-0098765,9812345678",
      "Gita Devi Tamang,16,ICP College,10,03-0011111,9800000000",
      "Bikash Kumar Limbu,18,Itahari Int. College,12,01-0077777,9841111111",
      "Anita Rai,17,ICK College,11,04-002222,981234",
      "Deepak Shah,20,ICP College,12,01-00ABCDE,9867890123"
    };

    Student[] students = CensusProcessor.parseCSV(csvData);
    for(Student s : students){
      System.out.println(s);
    }

    System.out.println(CensusProcessor.generateCensusReport(students));
  }
}
