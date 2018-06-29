package swaypharmacy.clip.seven.com.swaypharmacy;

public class Drug {
    String term;

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    int count;
    public Drug(String name, int count){
        term = name;
        this.count = count;
    }


}
