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
import android.widget.Spinner;
import android.widget.Toast;

import com.gsm.cite.source.R;

public class SourceMediaImage extends Activity {
ImageButton btnDone;
EditText contributorName;
Spinner contributionSpn;
EditText dateProduced;
EditText imageTitle;
Spinner mediumSpn;
EditText webURL;
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.source_media_image);
        
        btnDone = (ImageButton) findViewById(R.id.imdoneBtn);
        btnDone.setOnClickListener(new btnDoneListener());
        
        contributorName = (EditText) findViewById(R.id.contributorNameTxt);
        contributionSpn = (Spinner) findViewById(R.id.contributionSpn);
        dateProduced = (EditText) findViewById(R.id.dateProducedTxt);
        imageTitle = (EditText) findViewById(R.id.titleTxt);
        mediumSpn = (Spinner) findViewById(R.id.mediumSpn);
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
			Intent intent = new Intent(SourceMediaImage.this, SourceFinalCitation.class);
			
			String citationTxt;
			
			String name = contributorName.getText().toString();
			String contribution = contributionSpn.getSelectedItem().toString();
			String date = dateProduced.getText().toString();
			String title = imageTitle.getText().toString();
			String medium = mediumSpn.getSelectedItem().toString();
			String url = webURL.getText().toString();
			
			if (isEmpty(name)) {
			    if (isEmpty(date)) {
			        citationTxt = title+" ["+medium+"]. Retrieved from "+url;
			        intent.putExtra("citationTxt", citationTxt);
			    } else if (isEmpty(title)) {
			        citationTxt = "("+date+"). ["+medium+"]. Retrieved from "+url;
			        intent.putExtra("citationTxt", citationTxt);
			    } else if (isEmpty(url)) {
			        citationTxt = "("+date+"). "+title+" ["+medium+"].";
			        intent.putExtra("citationTxt", citationTxt);
			    } else {
			        citationTxt = "("+date+"). "+title+" ["+medium+"]. Retrieved from "+url;
			        intent.putExtra("citationTxt", citationTxt);
			    }
			} else if (isEmpty(date)) {
			    if (isEmpty(title)) {
			        citationTxt = name+" ("+contribution+"). ["+medium+"]. Retrieved from "+url;
			        intent.putExtra("citationTxt", citationTxt);
			    } else if (isEmpty(url)) {
			        citationTxt = name+" ("+contribution+"). "+title+" ["+medium+"].";
			        intent.putExtra("citationTxt", citationTxt);
			    } else {
			        citationTxt = name+" ("+contribution+"). "+title+" ["+medium+"]. Retrieved from "+url;
			        intent.putExtra("citationTxt", citationTxt);
			    }
			} else if (isEmpty(title)) {
			    if (isEmpty(url)) {
			        citationTxt = name+" ("+contribution+"). ("+date+"). ["+medium+"].";
			        intent.putExtra("citationTxt", citationTxt);
			    }
			} else {
			    citationTxt = name+" ("+contribution+"). ("+date+"). "+title+" ["+medium+"]. Retrieved from "+url;
			    intent.putExtra("citationTxt", citationTxt);
			}
			
			if (isEmpty(name) && isEmpty(date) && isEmpty(title) && isEmpty(url)) {
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
