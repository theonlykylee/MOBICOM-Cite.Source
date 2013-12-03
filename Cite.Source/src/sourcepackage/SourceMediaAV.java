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

public class SourceMediaAV extends Activity {
    ImageButton btnDone;
    EditText contributorName;
    EditText yearReleased;
    EditText productionTitle;
    Spinner lol;
    EditText webUrl;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.source_media_av);

        btnDone = (ImageButton) findViewById(R.id.imdoneBtn);
        btnDone.setOnClickListener(new btnDoneListener());
        
        contributorName = (EditText) findViewById(R.id.contributorNameTxt);
        yearReleased = (EditText) findViewById(R.id.yearReleaseTxt);
        productionTitle = (EditText) findViewById(R.id.titleTxt);
        lol = (Spinner) findViewById(R.id.mediumSpn);
        webUrl = (EditText) findViewById(R.id.urlTxt);

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
            Intent intent = new Intent(SourceMediaAV.this,
                    SourceFinalCitation.class);
            
            String citationTxt;
            
            String name = contributorName.getText().toString();
            String year = yearReleased.getText().toString();
            String title = productionTitle.getText().toString();
            String media = lol.getSelectedItem().toString();
            String url = webUrl.getText().toString();
            
            if (isEmpty(name)) {
                citationTxt = "("+year+"). "+title+". "+media+". Retrieved from "+url;
                intent.putExtra("citationTxt", citationTxt);
            } else if (isEmpty(year)){
                citationTxt = name+ " (n.d.). "+title+". "+media+". Retrieved from "+url;
                intent.putExtra("citationTxt", citationTxt);
            } else {
                citationTxt = name+" ("+year+"). "+title+". "+media+". Retrieved from "+url;
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
