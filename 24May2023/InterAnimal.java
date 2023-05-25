package mypack;

interface AnimalEat {
	   void eat();
}
	
interface AnimalTravel extends AnimalEat {
	   void travel();
}

abstract class AnimalAbs implements AnimalEat{
	abstract public void hunt() ;
	public void drinking() {
		System.out.println("Animal is drinking water");
	}
}

class Animal extends AnimalAbs {
   public void eat() {
      System.out.println("Animal is eating");
   }
   public void travel() {
      System.out.println("Animal is travelling");
   }
   public void hunt() {
	   System.out.println("Animal is hunting");
   }
   
}
