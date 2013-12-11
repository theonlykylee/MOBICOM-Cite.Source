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

public class SourceOthersBlog extends Activity {
ImageButton btnDone;
EditText authorName;
EditText yearPublished;
EditText titleOfBlog;
EditText webUrl;
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.source_others_blog);
        
        btnDone = (ImageButton) findViewById(R.id.imdoneBtn);
        btnDone.setOnClickListener(new btnDoneListener());
        
        authorName = (EditText) findViewById(R.id.authorNameTxt);
        yearPublished = (EditText) findViewById(R.id.datePublishedTxt);
        titleOfBlog = (EditText) findViewById(R.id.titleTxt);
        webUrl = (EditText) findViewById(R.id.urlTxt);
        
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
			Intent intent = new Intent(SourceOthersBlog.this, SourceFinalCitation.class);
			
			String citationTxt;
			
			String name = authorName.getText().toString();
			String year = yearPublished.getText().toString();
			String title = titleOfBlog.getText().toString();
			String url = webUrl.getText().toString();
			
			if (isEmpty(name)) {
			    if (isEmpty(year)){
			        citationTxt = "[Web log message]. Retrieved from "+url;
			        intent.putExtra("citationTxt", citationTxt);
			    } else if (isEmpty(title)) {
			        citationTxt = "[Web log message]. ("+year+"). Retrieved from "+url;
			        intent.putExtra("citationTxt", citationTxt);
			    } else if (isEmpty(url)) {
			        citationTxt = "[Web log message]. ("+year+").";
			        intent.putExtra("citationTxt", citationTxt);
			    } else {
    			    citationTxt = "[Web log message]. ("+year+"). "+title+". Retrieved from "+url;
    			    intent.putExtra("citationTxt", citationTxt);
			    }
			} else if (isEmpty(year)) {
			    if (isEmpty(title)) {
			        citationTxt = name+" [Web log message]. Retrieved from "+url;
			        intent.putExtra("citationTxt", citationTxt);
			    } else if (isEmpty(url)) {
			        citationTxt = name+" [Web log message].";
			        intent.putExtra("citationTxt", citationTxt);
			    } else {
    			    citationTxt = name+" [Web log message]. "+title+". Retrieved from "+url;
    			    intent.putExtra("citationTxt", citationTxt);
			    }
			} else if (isEmpty(title)) {
			    if (isEmpty(url)) {
			        citationTxt = name+" ("+year+"). [Web log message].";
			        intent.putExtra("citationTxt", citationTxt);
			    } else {
    			    citationTxt = name+" ("+year+"). [Web log message]. Retrieved from "+url;
    			    intent.putExtra("citationTxt", citationTxt);
			    }
			} else if (isEmpty(url)) {
			    citationTxt = name+" ("+year+"). [Web log message].";
			    intent.putExtra("citationTxt", citationTxt);
			} else {
			    citationTxt = name+" ("+year+"). [Web log message]. Retrieved from "+url;
			    intent.putExtra("citationTxt", citationTxt);
			}
			
			if (isEmpty(name) && isEmpty(year) && isEmpty(title) && isEmpty(url)) {
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
