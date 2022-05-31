import utils.*;
class psp
{
public static void main(String gg[])
{
TMArrayList<String> list1=new TMArrayList();
list1.add("Mercedes");
list1.add("Scorpio");
list1.add("Tesla x200");
list1.add("Bugatti veron");

list1.forEach((p)->{
System.out.println("list1 : "+p);
});


TMLinkedList list2=new TMLinkedList();
list2.appendFrom(list1);
list2.add(0,"Tata Neo");

list2.forEach((p)->{
System.out.println("list2 : "+p);
});



}

}