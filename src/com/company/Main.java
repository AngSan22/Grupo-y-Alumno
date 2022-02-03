package com.company;

class Student {
    private String name;
    private String lastName;
    private String code;

    Student(String name, String lastName, String code){
        this.name = name;
        this.lastName = lastName;
        this.code = code;
    }

    public String getName(){
        return name;
    }

    public String getLastName(){
        return lastName;
    }

    public String getCode(){
        return code;
    }
}

class Group {
    private String code;
    private Student[] alumnos;
    private int enrolled;
    private int rejected;

    Group(String code, int capacity){
        this.code = code;
        alumnos = new Student[capacity];
    }

    public void addStudent(Student alumno){
        if(enrolled < alumnos.length){
            alumnos[enrolled] = alumno;
            enrolled++;
            acceptedStudent(alumno);
        }else{
            rejectedStudent(alumno);
            rejected++;
        }
    }

    public void acceptedStudent(Student alumno){
        System.out.println("Estudiante fue añadido: " + alumno.getName() + " " + alumno.getLastName());
    }

    public void rejectedStudent(Student alumno){
        System.out.println("Estudiante NO fue añadido: " + alumno.getName() + " " + alumno.getLastName());
    }

    public void getGroup(){
        System.out.println();
        System.out.println("Alumnos del grupo: " + code);

        for (int i = 0; i < enrolled; i++){
            Student student = alumnos[i];
            System.out.println(student.getCode() + ": " + student.getName() + " " + student.getLastName());
        }
    }

    public void removeStudent(String code){
        for (int i = 0; i < enrolled; i++){
            if(code == alumnos[i].getCode()){
                alumnos[i] = alumnos[enrolled-1];
                alumnos[enrolled-1] = null;
                enrolled--;
            }
        }
    }

    public String getCode(){
        return code;
    }

    public int getEnrolled(){
        return enrolled;
    }

    public int getRejected(){
        return rejected;
    }
}

public class Main {

    public static void main(String[] args) {
        Student student1; // Referencia a un Alumno
        Student student2 = new Student("Ivan", "Uresti", "972196");
        student1 = new Student("José", "González", "456789"); // Creando un objeto alumno

        Group group = new Group("230401", 8);
        Group group2 = new Group("230402", 6);

        group.addStudent(student1);

        group.addStudent(student2);

        group.addStudent(new Student("Jorge", "Acosta", "1"));
        group.addStudent(new Student("Arturo", "Aleman", "2"));
        group.addStudent(new Student("Antonio", "Angel", "3"));
        group.addStudent(new Student("Francisco", "Arreguin", "4"));
        group2.addStudent(new Student("Misael", "Cabrera", "5"));
        group2.addStudent(new Student("Roberto", "Cisneros", "6"));
        group.addStudent(new Student("Juan", "Coronado", "7"));
        group.addStudent(new Student("José", "González", "8"));
        group.addStudent(new Student("Jesús", "Lara", "9"));
        group.addStudent(new Student("José", "Limón", "10"));


        System.out.println();
        System.out.println("Grupo: " + group.getCode() + ", inscritos: " + group.getEnrolled() + ", rechazados: " + group.getRejected());
        System.out.printf("Grupo: %s, inscritos: %d, rechazados: %d%n", group2.getCode(), group2.getEnrolled(), group2.getRejected());

        group.removeStudent("4");
        group2.removeStudent("6");
        group2.removeStudent("12");

        System.out.println("Grupo: " + group.getCode() + ", inscritos: " + group.getEnrolled() + ", rechazados: " + group.getRejected());
        System.out.printf("Grupo: %s, inscritos: %d, rechazados: %d%n", group2.getCode(), group2.getEnrolled(), group2.getRejected());

        group.getGroup();
        group2.getGroup();


    }
}
