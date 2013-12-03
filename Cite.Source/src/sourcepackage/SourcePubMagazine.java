package sourcepackage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.gsm.cite.source.R;

public class SourcePubMagazine extends Activity {
ImageButton btnDone;
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.source_pub_magazine);
        
        btnDone = (ImageButton) findViewById(R.id.imdoneBtn);
        btnDone.setOnClickListener(new btnDoneListener());
        
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
			Intent intent = new Intent(SourcePubMagazine.this, SourceFinalCitation.class);
			startActivity(intent);
		}
    	
    }

}
