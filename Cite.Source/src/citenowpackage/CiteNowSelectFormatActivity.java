package citenowpackage;

import sourcepackage.SelectSourceType;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.gsm.cite.source.R;

public class CiteNowSelectFormatActivity extends Activity {

    ImageButton btnAPA;
    ImageButton btnMLA;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.citenow_activity_select_citation_format);
        
        btnAPA = (ImageButton) findViewById(R.id.apaFormatBtn);
        btnMLA = (ImageButton) findViewById(R.id.mlaFormatBtn);
        
        btnAPA.setOnClickListener(new btnAPAListener());
        btnMLA.setOnClickListener(new btnMLAListener());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start_screen, menu);
        return true;
    }
    
    class btnAPAListener implements OnClickListener {

		@Override
		public void onClick(View b) {
			Intent intent = new Intent(CiteNowSelectFormatActivity.this, SelectSourceType.class);
			startActivity(intent);
		}
    	
    }
    
    class btnMLAListener implements OnClickListener {

		@Override
		public void onClick(View b) {
			Intent intent = new Intent(CiteNowSelectFormatActivity.this, SelectSourceType.class);
			startActivity(intent);
		}
    	
    }
    
}
