import java.util.ArrayList;

public class Heroes {
    private String mName;
    private int mAge;
    private int id;
    private String mSpecialPower;
    private String mWeakness;
    private String mSquadMembership;
    private boolean isAdded;

    public static ArrayList<Heroes> mInstances = new ArrayList<Heroes>();


    public Heroes(String mName, int mAge, String mSpecialPower, String mWeakness, String mSquadMembership) {
        this.mName = mName;
        this.mAge = mAge;
        this.mSpecialPower = mSpecialPower;
        this.mWeakness = mWeakness;
        this.mSquadMembership = mSquadMembership;
        this.isAdded= false;

        mInstances.add(this);
        this.id = mInstances.size();
    }

    public Heroes(String name, String age, String id, String strength, String weakness) {
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmAge() {
        return mAge;
    }

    public void setmAge(int mAge) {
        this.mAge = mAge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getmSpecialPower() {
        return mSpecialPower;
    }

    public void setmSpecialPower(String mSpecialPower) {
        this.mSpecialPower = mSpecialPower;
    }

    public String getmWeakness() {
        return mWeakness;
    }

    public void setmWeakness(String mWeakness) {
        this.mWeakness = mWeakness;
    }

    public String getmSquadMembership() {
        return mSquadMembership;
    }

    public void setmSquadMembership(String mSquadMembership) {
        this.mSquadMembership = mSquadMembership;
    }

    public static ArrayList<Heroes> getAll() {
        return mInstances;
    }
    public boolean getAdded(){
        return this.isAdded;
    }
    public static Heroes findById(int id){

        return mInstances.get(id - 1);
    }

    public void deleteHero(){
        mInstances.remove(id - 1);
    }

}
