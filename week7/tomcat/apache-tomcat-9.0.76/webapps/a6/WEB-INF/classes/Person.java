class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void print() {

        System.out.println(name + " " + age);
    }

}