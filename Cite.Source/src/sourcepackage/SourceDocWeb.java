package sourcepackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.gsm.cite.source.R;

public class SourceDocWeb extends Activity {
	ImageButton btnDone;
	
	// The TextViews in the UI
	TextView authorNameTxt;
	TextView datePublishedTxt;
	TextView titleTxt;
	TextView urlTxt;
	
	Intent intent;
	String project;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.source_doc_web);
        
        btnDone = (ImageButton) findViewById(R.id.imdoneBtn);
        btnDone.setOnClickListener(new btnDoneListener());
        
        // THE TEXTFIELDS
        authorNameTxt = (TextView) findViewById(R.id.authorNameTxt);
        datePublishedTxt = (TextView) findViewById(R.id.datePublishedTxt);
        titleTxt = (TextView) findViewById(R.id.titleTxt);
        urlTxt = (TextView) findViewById(R.id.urlTxt);
        
        intent = getIntent();
        project = intent.getStringExtra("projectName");
        System.out.println("SourceDocWeb");
        System.out.println(project);
    }

    private boolean isEmpty (String text) {
        //return text.getText().toString().trim().length() == 0;
        return text.length() == 0;
    
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
			Intent intent = new Intent(SourceDocWeb.this, SourceFinalCitation.class);
			
			String citationTxt;
			
			String authorName = authorNameTxt.getText().toString();
			String datePublished = datePublishedTxt.getText().toString();
			String title = titleTxt.getText().toString();
			String url = urlTxt.getText().toString();
			
			//CHECKING OF INPUTS AND PASSING THEM TO THE NEXT ACTIVITY :>
			if (isEmpty(authorName)) {
			    if (isEmpty(datePublished)) {
			        if (isEmpty(title)){
			            citationTxt = "(n.d.). Retrieved from "+url;
			            intent.putExtra("citationTxt", citationTxt);
			        } else if (isEmpty(url)) {
			            citationTxt = title+". (n.d.).";
			            intent.putExtra("citationTxt", citationTxt);
			        } else {
			            citationTxt = title+". (n.d.). Retrieved from "+url;
			            intent.putExtra("citationTxt", citationTxt);
			        }
			    } else if (isEmpty(title)){
			        if (isEmpty(url)) {
			            citationTxt = "("+datePublished+").";
			            intent.putExtra("citationTxt", citationTxt);
			        } else {
    			        citationTxt = "("+datePublished+"). Retrieved from "+url;
    			        intent.putExtra("citationTxt", citationTxt);
			        }
			    } else if (isEmpty(url)){
			        citationTxt = title+". ("+datePublished+").";
			        intent.putExtra("citationTxt", citationTxt);
			    } else {
			        citationTxt = "("+datePublished+"). "+titleTxt+". Retrieved from "+url;
			        intent.putExtra("citationTxt", citationTxt);
			    }
			} else if (isEmpty(datePublished)) {
			    if (isEmpty(title)) {
			        if (isEmpty(url)) {
			            citationTxt = authorName+" (n.d.).";
			            intent.putExtra("citationTxt", citationTxt);
			        } else {
    			        citationTxt = authorName+" (n.d.). Retrieved from "+url;
    			        intent.putExtra("citationTxt", citationTxt);
			        }
			    } else if (isEmpty(url)) {
			        citationTxt = authorName+" (n.d.). "+title+".";
			        intent.putExtra("citationTxt", citationTxt);
			    } else {
			        citationTxt = authorName+" (n.d.). "+title+". Retrieved from "+url;
			        intent.putExtra("citationTxt", citationTxt);
			    }
			} else {
                citationTxt = authorName+" ("+datePublished+"). "+title+". Retrieved from "+url;
                intent.putExtra("citationTxt", citationTxt);
            }
			
			//CHECKING IF THERE ARE INPUTS IN ALL THE FIELDS
			//IF NOT THEN IT WILL SHOW A TOAST NOTIFYING THE UZER
			if(isEmpty(authorName) && isEmpty(datePublished) && isEmpty(title) && isEmpty(url)){
			    Toast toast;
			    Context context = getApplicationContext();
			    int duration = Toast.LENGTH_SHORT;
			    CharSequence text;
			    
			    text = "Please fill in the needed data.";
			    
			    toast = Toast.makeText(context, text, duration);
			    toast.show();
			} else {
			    intent.putExtra("projectName", project);
			    startActivity(intent);
			}
			
		}
    	
    }

}
