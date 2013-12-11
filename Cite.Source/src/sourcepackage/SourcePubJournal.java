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

public class SourcePubJournal extends Activity {
    ImageButton btnDone;
    EditText nameOfAuthor;
    EditText yearPublished;
    EditText articleTitle;
    EditText periodicalTitle;
    EditText issueNumber;
    EditText volumeNumber;
    EditText pageNumber;
    EditText doiNumber;
    EditText webUrl;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.source_pub_journal);

        // Text Fields
        nameOfAuthor = (EditText) findViewById(R.id.authorNameTxt);
        yearPublished = (EditText) findViewById(R.id.yearPublishedTxt);
        articleTitle = (EditText) findViewById(R.id.titleArticleTxt);
        periodicalTitle = (EditText) findViewById(R.id.titlePeriodicalTxt);
        issueNumber = (EditText) findViewById(R.id.issueTxt);
        volumeNumber = (EditText) findViewById(R.id.volumeTxt);
        pageNumber = (EditText) findViewById(R.id.pageNumberTxt);
        doiNumber = (EditText) findViewById(R.id.doiTxt);
        webUrl = (EditText) findViewById(R.id.webUrlTxt);

        btnDone = (ImageButton) findViewById(R.id.imdoneBtn);
        btnDone.setOnClickListener(new btnDoneListener());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start_screen, menu);
        return true;
    }

    private boolean isEmpty(String text) {
        // return text.getText().toString().trim().length() == 0;
        return text.length() == 0;

    }

    // THESE ARE THE LISTENERS FOR THE BUTTONS

    class btnDoneListener implements OnClickListener {

        @Override
        public void onClick(View a) {
            Intent intent = new Intent(SourcePubJournal.this,
                    SourceFinalCitation.class);

            String citationTxt;

            String name = nameOfAuthor.getText().toString();
            String year = yearPublished.getText().toString();
            String titleOfArticle = articleTitle.getText().toString();
            String titleOfPeriodical = periodicalTitle.getText().toString();
            String issueNo = issueNumber.getText().toString();
            String volNo = volumeNumber.getText().toString();
            String pageNo = pageNumber.getText().toString();
            String doiNo = doiNumber.getText().toString();
            // String url = webUrl.getText().toString();

            /*if (isEmpty(name)) {
                citationTxt = "("+year+"). "+titleOfArticle+". "+titleOfPeriodical+", "+volNo+"("+issueNo+"), "+pageNo+". doi: "+doiNo;
                intent.putExtra("citationTxt", citationTxt);
            }*/

            if (isEmpty(name)) {
                if (isEmpty(year)) {
                    citationTxt = "(n.d.). "+titleOfArticle+". "+titleOfPeriodical+", "+volNo+" ("+issueNo+"), "+pageNo+". doi: "+doiNo;
                    intent.putExtra("citationTxt", citationTxt);
                } else {
                    citationTxt = "(" + year + "). " + titleOfArticle + ". "
                            + titleOfPeriodical + ", " + volNo + "(" + issueNo
                            + "), " + pageNo + ". doi: " + doiNo;
                    intent.putExtra("citationTxt", citationTxt);
                }
            } else if (isEmpty(year)) {
                citationTxt = name + " (n.d.). " + titleOfArticle + ". "
                        + titleOfPeriodical + ", " + volNo + "(" + issueNo
                        + "), " + pageNo + ". doi: " + doiNo;
                intent.putExtra("citationTxt", citationTxt);
            } else if (isEmpty(titleOfArticle)) {
                citationTxt = name + " (" + year + "). " + titleOfPeriodical
                        + ", " + volNo + "(" + issueNo + "), " + pageNo
                        + ". doi: " + doiNo;
                intent.putExtra("citationTxt", citationTxt);
            } else if (isEmpty(titleOfPeriodical)) {
                citationTxt = name + " (" + year + "). " + titleOfArticle
                        + ". " + volNo + "(" + issueNo + "), " + pageNo
                        + ". doi: " + doiNo;
                intent.putExtra("citationTxt", citationTxt);
            } else if (isEmpty(issueNo)) {
                citationTxt = name + " (" + year + "). " + titleOfArticle
                        + ". " + titleOfPeriodical + ", " + volNo + ", "
                        + pageNo + ". doi: " + doiNo;
                intent.putExtra("citationTxt", citationTxt);
            } else if (isEmpty(volNo)) {
                citationTxt = name + " (" + year + "). " + titleOfArticle
                        + ". " + titleOfPeriodical + ", (" + issueNo + "), "
                        + pageNo + ". doi: " + doiNo;
                intent.putExtra("citationTxt", citationTxt);
            } else if (isEmpty(pageNo)) {
                citationTxt = name + "(" + year + "). " + titleOfArticle + ". "
                        + titleOfPeriodical + ", " + volNo + "(" + issueNo
                        + "), doi:" + doiNo;
                intent.putExtra("citationTxt", citationTxt);
            } /*else if (isEmpty(doiNo)) {
                citationTxt = name+"("+year+"). "+titleOfArticle+". "+titleOfPeriodical+", "+volNo+"("+issueNo+"), "+pageNo+". Retrieved from "+url;
                intent.putExtra("citationTxt", citationTxt);
              }*/else {
                citationTxt = name + " (" + year + "). " + titleOfArticle
                        + ". " + titleOfPeriodical + ", " + volNo + "("
                        + issueNo + "), " + pageNo + ". doi: " + doiNo;
                intent.putExtra("citationTxt", citationTxt);
            }

            if (isEmpty(name) && isEmpty(year) && isEmpty(titleOfArticle)
                    && isEmpty(titleOfPeriodical) && isEmpty(issueNo)
                    && isEmpty(volNo) && isEmpty(pageNo) && isEmpty(doiNo)) {
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
