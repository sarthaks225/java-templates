import utils.*;
class Main
{
public static void main(String gg[])
{
TMLinkedList<String> list1=new TMLinkedList();
list1.add("100");
list1.add("110");
list1.add("car");

TMArrayList list4=new TMArrayList();
list4.copyFrom(list1);

list4.forEach((p)->{
System.out.println("list4 : "+p);});


for(int i=0; i<list1.getSize(); ++i) System.out.printf("list1 %d) %s\n",i,list1.get(i));
list1.add(0,"50");
for(int i=0; i<list1.getSize(); ++i) System.out.printf("%d) %s\n",i,list1.get(i));

System.out.println("Now using iterator");
TMIterator i1;
i1=list1.iterator();
while(i1.hasNext())
{
System.out.println(i1.get());
}


list1.add(1,"Jaguar");

TMLinkedList<String> list2=new TMLinkedList();
list1.copyTo(list2);


for(int i=0; i<list2.getSize(); ++i) System.out.printf("list2 %d) %s\n",i,list2.get(i));

System.out.println("...test for append From");
list1.appendTo(list2);
for(int i=0; i<list1.getSize(); ++i) System.out.printf("list1 %d) %s\n",i,list1.get(i));
list2.add("Benz");
list2.add("Ducati");
for(int i=0; i<list2.getSize(); ++i) System.out.printf("list2 %d) %s\n",i,list2.get(i));

System.out.println("TMArrayList");
TMArrayList list3=new TMArrayList();

list3.appendFrom(list2);
list2.update(1,"Maruti ");
for(int i=0; i<list3.getSize(); ++i) System.out.printf("list3 %d) %s\n",i,list3.get(i));

}

}
