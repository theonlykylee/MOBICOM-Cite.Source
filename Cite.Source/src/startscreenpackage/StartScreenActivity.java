package startscreenpackage;

import newcitationprojectpackage.NewCitationProjectActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import citenowpackage.CiteNowSelectFormatActivity;

import com.gsm.cite.source.R;

import editcitationproject.EditCitationMyCitationProjects;

public class StartScreenActivity extends Activity {

	ImageButton btnCiteNow;
	ImageButton btnNewCitationProject;
	ImageButton btnEditCitationProject;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startscreen_activity_start_screen);
        
        btnCiteNow = (ImageButton) findViewById(R.id.citeNowBtn);
        btnNewCitationProject = (ImageButton) findViewById(R.id.newProjectBtn);
        btnEditCitationProject = (ImageButton) findViewById(R.id.editCitationBtn);
        
        btnCiteNow.setOnClickListener(new btnCiteNowListener());
        btnNewCitationProject.setOnClickListener(new btnNewCitationProjectListener());
        btnEditCitationProject.setOnClickListener(new btnEditCitationProjectListener());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start_screen, menu);
        return true;
    }
    
    // THESE ARE THE LISTENERS FOR THE BUTTONS
    
    class btnCiteNowListener implements OnClickListener {

		@Override
		public void onClick(View a) {
			Intent intent = new Intent(StartScreenActivity.this, CiteNowSelectFormatActivity.class);
			startActivity(intent);
		}
    	
    }
    
    class btnNewCitationProjectListener implements OnClickListener {

		@Override
		public void onClick(View b) {
			Intent intent = new Intent(StartScreenActivity.this, NewCitationProjectActivity.class);
			startActivity(intent);
		}
    	
    }
    
    class btnEditCitationProjectListener implements OnClickListener {

		@Override
		public void onClick(View c) {
			Intent intent = new Intent(StartScreenActivity.this, EditCitationMyCitationProjects.class);
			startActivity(intent);
		}
    	
    }
    
}
