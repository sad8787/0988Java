
public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Григорий","Петров", 68, null, null);
        Person p2 = new Person("Ольга", "Иванова", 45, null, p1);
        Person p3 = new Person("Алексей","Иванов", 45, null, null);
        Person p4 = new Person("Николай","Иванов", 20, p2, p3);
        p4.info();
        p3.info();
    }
}

class Person{ // Описание того, как должен выглядить человек
    String name;
    String lastname;
    int age;
    Person mother;
    Person father;
    Person(String name, String lastname, int age, Person mother, Person father){
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.mother = mother;
        this.father = father;
    }
    void info(){
        String info = "Привет меня зовут "+this.name+" "+this.lastname+"\n" +
                "Мне "+this.age+" лет \n";

        if(this.mother != null){ // Проверка существования матери
            info += "Мою маму зовут "+this.mother.name+"\n";
            if(this.mother.father != null){ // Проверка существования отца матери (дедушки по маминой линии)
                info += "Дедушку по маминой линии зовут "+this.mother.father.name+"\n";
            }
            if(this.mother.mother != null){ // Проверка существования отца матери (дедушки по маминой линии)
                info += "Бабушка по маминой линии зовут "+this.mother.father.name+"\n";
            }
        }
        if(this.father != null){
            info += "Моего папу зовут "+this.father.name+"\n";
            if(this.father.father != null){ // Проверка существования отца матери (дедушки по маминой линии)
                info += "Дедушку по папой линии зовут "+this.father.father.name+"\n";
            }
            if(this.father.mother != null){ // Проверка существования отца матери (дедушки по маминой линии)
                info += "Бабушка по папой линии зовут "+this.father.father.name+"\n";
            }
        }
        System.out.println(info);
    }
    void sayHi(String name){
        System.out.println("Привет "+name);
    }
}
