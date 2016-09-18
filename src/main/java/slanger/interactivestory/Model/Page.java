package slanger.interactivestory.Model;

/**
 * Created by slanger on 9/15/2016.
 */
public class Page {
    private int mImageId;
    private String mText;
    private Choice mChoice1;
    private Choice mChoice2;
    private boolean mIsFinal;

    public Page(int imageId, String text, Choice choice1, Choice choice2){
        mImageId = imageId;
        mText = text;
        mChoice1 = choice1;
        mChoice2 = choice2;
    }
    public Page(int imageId, String text){
        mImageId = imageId;
        mText = text;
        mChoice1 = null;
        mChoice2 = null;
        mIsFinal = true;
    }
    public int getImageId(){
        return mImageId;
    }
    public void setImageId(int id){
        mImageId = id;
    }

    public String getText() {
        return mText;
    }

    public void setText(String mText) {
        this.mText = mText;
    }

    public Choice getChoice1() {
        return mChoice1;
    }

    public void setChoice1(Choice mChoice1) {
        this.mChoice1 = mChoice1;
    }

    public Choice getChoice2() {
        return mChoice2;
    }

    public void setChoice2(Choice mChoice2) {
        this.mChoice2 = mChoice2;
    }
    public boolean ismIsFinal() {
        return mIsFinal;
    }

    public void setmIsFinal(boolean mIsFinal) {
        this.mIsFinal = mIsFinal;
    }
}
