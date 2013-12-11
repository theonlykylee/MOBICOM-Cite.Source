package sourcepackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.gsm.cite.source.R;

public class SourcePubMagazine extends Activity {
    ImageButton btnDone;
    EditText nameOfAuthor;
    EditText yearPublished;
    EditText articleTitle;
    EditText magazineTitle;
    EditText issueNumber;
    EditText volumeNumber;
    EditText pageNumber;
    EditText webURL;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.source_pub_magazine);

        btnDone = (ImageButton) findViewById(R.id.imdoneBtn);
        btnDone.setOnClickListener(new btnDoneListener());
        
        nameOfAuthor = (EditText) findViewById(R.id.authorNameTxt);
        yearPublished = (EditText) findViewById(R.id.yearPublishedTxt);
        articleTitle = (EditText) findViewById(R.id.titleArticleTxt);
        magazineTitle = (EditText) findViewById(R.id.titlePeriodicalTxt);
        issueNumber = (EditText) findViewById(R.id.issueTxt);
        volumeNumber = (EditText) findViewById(R.id.volumeTxt);
        pageNumber = (EditText) findViewById(R.id.pageNumberTxt);
        webURL = (EditText) findViewById(R.id.urlTxt);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start_screen, menu);
        return true;
    }

    // THESE ARE THE LISTENERS FOR THE BUTTONS
    
    private boolean isEmpty(String text) {
        // return text.getText().toString().trim().length() == 0;
        return text.length() == 0;

    }

    class btnDoneListener implements OnClickListener {

        @Override
        public void onClick(View a) {
            Intent intent = new Intent(SourcePubMagazine.this,
                    SourceFinalCitation.class);
            
            String citationTxt;
            
            String name = nameOfAuthor.getText().toString();
            String year = yearPublished.getText().toString();
            String title = articleTitle.getText().toString();
            String magazine = magazineTitle.getText().toString();
            String issueNo = issueNumber.getText().toString();
            String volNo = volumeNumber.getText().toString();
            String pageNo = pageNumber.getText().toString();
            String url = webURL.getText().toString();
            
            if (isEmpty(name)) {
                if (isEmpty(year)) {
                    citationTxt = "(n.d.). "+title+". "+magazine+", "+volNo+" ("+issueNo+"), "+pageNo+". Retrieved from "+url;
                    intent.putExtra("citationTxt", citationTxt);
                } 
            } else if (isEmpty(year)) {
                
            } else if (isEmpty(title)) {
                
            } else if (isEmpty(magazine)) {
                
            } else if (isEmpty(issueNo)) {
                
            } else if (isEmpty(volNo)) {
                
            } else if (isEmpty(pageNo)) {
                
            } else if (isEmpty(url)) {
                
            } else {
                citationTxt = name+" ("+year+"). "+title+". "+magazine+", "+volNo+" ("+issueNo+"), "+pageNo+". Retrieved from "+url;
                intent.putExtra("citationTxt", citationTxt);
            }
            
            
            if (isEmpty(name) && isEmpty(year) && isEmpty(title) && isEmpty(magazine) && isEmpty(issueNo) && isEmpty(volNo) && isEmpty(pageNo) && isEmpty(url)) {
                Toast toast;
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                CharSequence text;
                
                text = "Please fill in the needed data.";
                
                toast = Toast.makeText(context, text, duration);
                toast.show();
            } else {
                startActivity(intent);
            }
            
        }

    }

}
