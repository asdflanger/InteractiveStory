package slanger.interactivestory.Model;

/**
 * Created by slanger on 9/15/2016.
 */
public class Choice {
    private String mText;
    private int mNextPage;

    public Choice(String text, int nextPage){
        mText = text;
        mNextPage = nextPage;

    }
    public String getText() {
        return mText;
    }

    public void setText(String mtext) {
        this.mText = mtext;
    }

    public int getNextPage() {
        return mNextPage;
    }

    public void setNextPage(int mNextPage) {
        this.mNextPage = mNextPage;
    }
}
