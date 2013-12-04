package sourcepackage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import citenowpackage.CiteNowSelectFormatActivity;

import com.gsm.cite.source.R;

public class SourceDocAcademic extends Activity {
	ImageButton btnDone;
	
	// The TextViews in the UI
	TextView authorNameTxt;
	TextView yearPublishedTxt;
	TextView titleTxt;
	Spinner natureSpn;
	TextView universityDeptTxt;
	TextView databaseNameTxt;
	TextView databaseNumberTxt;
	TextView universityNameTxt;
	TextView universityCountryTxt;
	TextView universityCityTxt;
	
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.source_doc_academic);
        
        btnDone = (ImageButton) findViewById(R.id.imdoneBtn);
        btnDone.setOnClickListener(new btnDoneListener());
        
        // THE TEXTFIELDS
        authorNameTxt = (TextView) findViewById(R.id.authorNameTxt);
        yearPublishedTxt = (TextView) findViewById(R.id.yearPublishedTxt);
        titleTxt = (TextView) findViewById(R.id.titleTxt);
        
        natureSpn = (Spinner) findViewById(R.id.natureSpn);
        
        universityDeptTxt = (TextView) findViewById(R.id.universitydeptTxt);
        databaseNameTxt = (TextView) findViewById(R.id.databasenameTxt);
        databaseNumberTxt = (TextView) findViewById(R.id.databasenumberTxt);
        universityNameTxt = (TextView) findViewById(R.id.universitynameTxt);
        universityCountryTxt = (TextView) findViewById(R.id.universitycountryTxt);
        universityCityTxt = (TextView) findViewById(R.id.universitycityTxt);
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
			Intent intent = new Intent(SourceDocAcademic.this, SourceFinalCitation.class);
			startActivity(intent);
		}
    	
    }

}
