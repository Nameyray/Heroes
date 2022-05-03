import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Squads{
    private static final ArrayList<Squads> mInstances = new ArrayList<Squads>();
    private static final ArrayList<Heroes> mHeroes = new ArrayList<Heroes>();
    private String mName;
    private String mCause;
    private final int mMaxSize;
    private final boolean mPublished;
    private final int id;
    private final LocalDateTime createdAt;
    private final List<Heroes> squadHeroes = new ArrayList<>();

    public Squads(String mName, String mCause) {
        this.mName = mName;
        this.mCause = mCause;
        this.mMaxSize = 5;
        this.createdAt = LocalDateTime.now();
        this.mPublished = false;
        mInstances.add(this);
        this.id = mInstances.size();
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmCause() {
        return mCause;
    }

    public void setmCause(String mCause) {
        this.mCause = mCause;
    }

    public static ArrayList<Squads> getAll() {
        return mInstances;
    }
    public int getId() {
        return id;
    }
    public List<Heroes> getHeroes() {
        return mHeroes;
    }
    public void setHeroes(Heroes heroes) {
        mHeroes.add(heroes);
    }

    public static Squads findById(int id) {
        return mInstances.get(id - 1);
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public boolean checkForMaximumMembers() {
        return mHeroes.size() <= this.mMaxSize;
    }
}
