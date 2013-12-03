package sourcepackage;

import startscreenpackage.StartScreenActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

import com.gsm.cite.source.R;

public class SourceFinalCitation extends Activity {
ImageButton btnHome;
TextView citationTextView;
Intent intent;

	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.source_final);
        
        btnHome = (ImageButton) findViewById(R.id.homeBtn);
        citationTextView = (TextView) findViewById(R.id.citationTxt);
        intent = getIntent();

        String citation = intent.getStringExtra("citationTxt");
        
        citationTextView.setText(citation);
        btnHome.setOnClickListener(new btnHomeListener());
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start_screen, menu);
        return true;
    }
    
    // THESE ARE THE LISTENERS FOR THE BUTTONS
    
    class btnHomeListener implements OnClickListener {

		@Override
		public void onClick(View a) {
			Intent intent = new Intent(SourceFinalCitation.this, StartScreenActivity.class);
			startActivity(intent);
		}
    	
    }

}
