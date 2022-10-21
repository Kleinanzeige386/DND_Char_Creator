public class AbilityScore{
    public int amount;
    public int modifier;
    public Ability name;


    public AbilityScore(int a , Ability n) {
        amount=a;
        name=n;
        modifier= (amount/2)-5;

    }

    @Override
    public String toString(){
       return String.format("%s \n  Amount: %d   \n  Modifier: %d",name,amount,modifier);
    }

}
