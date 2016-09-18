package slanger.interactivestory.UI;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import slanger.interactivestory.Model.Page;
import slanger.interactivestory.Model.Story;
import slanger.interactivestory.R;

public class StoryActivity extends AppCompatActivity {
    public static final String TAG = StoryActivity.class.getSimpleName();
    private Story mStory = new Story();
    private ImageView mImageView;
    private TextView mTextView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private String mName;
    private Page mCurrentPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        Intent intent = getIntent();
        mName = intent.getStringExtra(getString(R.string.key_name));

        if(mName == null){
            mName = "Friend";
        }
        //Toast.makeText(StoryActivity.this, name, Toast.LENGTH_LONG).show();
        mImageView = (ImageView)findViewById(R.id.storyImageView);
        mTextView = (TextView) findViewById(R.id.storyTextView);
        mButtonChoice1 = (Button) findViewById(R.id.choiceButton1);
        mButtonChoice2 = (Button) findViewById(R.id.choiceButton2);
        LoadPage(0);
    }
    private void LoadPage(int choice){
        mCurrentPage = mStory.getPage(choice);

        //Drawable drawable = getResources().getDrawable(page.getImageId()); deprecated API 22.
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), mCurrentPage.getImageId(), null);
        mImageView.setImageDrawable(drawable);

        String pageText = mCurrentPage.getText();

        pageText = String.format(pageText, mName);
        mTextView.setText(pageText);
        if(mCurrentPage.ismIsFinal()){
            mButtonChoice1.setVisibility(View.INVISIBLE);
            mButtonChoice2.setText("PLAY AGAIN");
            mButtonChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }else {
            mButtonChoice1.setText(mCurrentPage.getChoice1().getText());
            mButtonChoice2.setText(mCurrentPage.getChoice2().getText());

            mButtonChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mCurrentPage.getChoice1().getNextPage();
                    LoadPage(nextPage);
                }
            });
            mButtonChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mCurrentPage.getChoice2().getNextPage();
                    LoadPage(nextPage);
                }
            });
        }
    }

}
