public class AbilityScore{
    public int amount;
    public int modifier;
    public final Ability name;
    public boolean proficient;


    public AbilityScore(int a , Ability n) {
        proficient = false;
        amount=a;
        name=n;
        modifier= (amount/2)-5;

    }

    @Override
    public String toString(){
       return String.format("%s \n  Amount: %d   \n  Modifier: %d",name,amount,modifier);
    }

}
