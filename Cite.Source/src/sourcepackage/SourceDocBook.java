package sourcepackage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import citenowpackage.CiteNowSelectFormatActivity;

import com.gsm.cite.source.R;

public class SourceDocBook extends Activity {
	ImageButton btnDone;
	
	// The TextViews in the UI
	TextView authorNameTxt;
	TextView yearPublishedTxt;
	TextView titleTxt;
	TextView editionTxt;
	TextView volumeTxt;
	TextView pageNumberTxt;
	TextView publishingCityTxt;
	TextView publishingCompanyTxt;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.source_doc_book);
        
        btnDone = (ImageButton) findViewById(R.id.imdoneBtn);
        btnDone.setOnClickListener(new btnDoneListener());
        
        // THE TEXTFIELDS
        authorNameTxt = (TextView) findViewById(R.id.authorNameTxt);
        yearPublishedTxt = (TextView) findViewById(R.id.yearPublishedTxt);
        titleTxt = (TextView) findViewById(R.id.titleTxt);
        editionTxt = (TextView) findViewById(R.id.editionTxt);
        volumeTxt = (TextView) findViewById(R.id.volumeTxt);
        pageNumberTxt = (TextView) findViewById(R.id.pageNumberTxt);
        publishingCityTxt = (TextView) findViewById(R.id.publishingcityTxt);
        publishingCompanyTxt = (TextView) findViewById(R.id.publishingcompanyTxt);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start_screen, menu);
        return true;
    }
    
    // THESE ARE THE LISTENERS FOR THE BUTTONS
    
    class btnDoneListener implements OnClickListener {

		@Override
		public void onClick(View a) {
			Intent intent = new Intent(SourceDocBook.this, SourceFinalCitation.class);
			startActivity(intent);
		}
    	
    }

}
