import java.util.Stack;

public class CatDogStack {
    private Stack<Pet> catSrack=new Stack<>();
    private Stack<Pet> dogSrack=new Stack<>();

    public void add(Pet pet){
        if(pet.getType().equals("dog")){
            dogSrack.push(pet);
        }else {
            catSrack.push(pet);
        }
    }

    public Pet pollDog(){
        if(!isDogEmpty()){
           return dogSrack.pop();
        }
        return null;
    }

    public boolean isDogEmpty(){
        return dogSrack.isEmpty();
    }
    public boolean isCatEmpty(){
        return catSrack.isEmpty();
    }
}
