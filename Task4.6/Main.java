public class Main {
    public static void main(String[] args) {
        Person valera=new Person("Валера","Иванов",69,null,null);
        Person olga = new Person("Ольга","Иванова",67,null,null);
        Person oleg = new Person("Олег","Петров",65,null,null);
        Person jula = new Person("Юля","Петрова",67,null,null);
        Person alex = new Person("Алексей","Иванов",37,olga,valera);
        Person eva  = new Person("Ева","Иванова",37,jula,oleg);
        Person gosha= new Person("Гоша","Иванов",10,eva,alex);
        System.out.println("Мама Алексея: "+alex.getMother().getName());
        System.out.println("Бабушка Гоши: "+gosha.getMother().getMother().getName());
        jula.Allinformation();
        alex.Allinformation();
        eva.Allinformation();
        gosha.Allinformation();

    }
}

class Person{
    private String name;
    private String lastname;
    private int age;
    private int hp = 100;
    private Person mother;
    private Person father;
    public Person(String name, String lastname, int age, Person mother, Person father){
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.mother = mother;
        this.father = father;
    }
    public String getName() {
        return this.name;
    }
    public int getHp(){
        return this.hp;
    }
    public Person getMother(){
        return this.mother;
    }
    public Person getFather(){
        return this.father;
    }
    public void setHp(int hp){
        if (this.hp+hp>100) this.hp = 100;
        else this.hp = this.hp + hp;
    }
    public void Fathers(){
        String s="У меня het Папа";
        if (father!=null){
            s="Имя моего папы: "+getName()+" "+father.getName();
        }
        System.out.println(s);
    }
    public void Mothers(){
        String s="У меня het Мама";
        if (mother!=null){
            s="Имя моей мамы: "+mother.getName();
        }
        System.out.println(s);
    }
    public void grantFathers(){
        String s="У меня het деда";
        if (father!=null && mother!=null) {
            if (father.getFather()!=null && mother.getFather()!=null)
                s="У меня два деда, деда "+father.getFather().getName()+" и "+mother.getFather().getName();
           else{
               if (father.getFather()!=null ){
                   s="У меня  деда "+father.getFather().getName();}
               if(mother.getFather()!=null){
                   s="У меня  деда "+mother.getFather().getName();
               }
            }
        }
        if (mother!=null && father==null){
                    if(mother.getFather()!=null){
                        s="У меня  деда "+mother.getFather().getName();
                    }
        }
        if (father!=null && mother==null){
            if(father.getFather()!=null){
                s="У меня  деда "+father.getFather().getName();
            }
        }
        System.out.println(s);
    }
    public void grantMothers(){
        String s="У меня het бабушки";
        if (father!=null && mother!=null) {
            if (father.getMother()!=null && mother.getMother()!=null)
                s="У меня две  бабушки, бабушка "+father.getMother().getName()+" и "+mother.getMother().getName();
            else{
                if (father.getMother()!=null ){
                    s="У меня  бабушка "+father.getMother().getName();}
                if(mother.getMother()!=null){
                    s="У меня  бабушка "+mother.getMother().getName();
                }
            }
        }
       else if (mother!=null && father==null){
            if(mother.getMother()!=null){
                s="У меня  бабушка "+mother.getMother().getName();
            }
        }
        else if (father!=null && mother==null){
            if(father.getMother()!=null){
                s="У меня  бабушка "+father.getMother().getName();
            }
        }
        System.out.println(s);
    }
    public void Allinformation(){
        System.out.println("Меня зовут "+getName());
        Mothers();
        Fathers();
        grantMothers();
        grantFathers();
    }

}
