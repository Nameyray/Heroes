public class Heroes {
    private String mName;
    private int mAge;
    private int id;
    private String mSpecialPower;
    private String mWeakness;
    private String mSquadMembership;
    private boolean isOccupied;

    public Heroes(String mName, int mAge, int id, String mSpecialPower, String mWeakness, String mSquadMembership) {
        this.mName = mName;
        this.mAge = mAge;
        this.id = id;
        this.mSpecialPower = mSpecialPower;
        this.mWeakness = mWeakness;
        this.mSquadMembership = mSquadMembership;
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
}
