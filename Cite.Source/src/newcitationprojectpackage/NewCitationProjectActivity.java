package newcitationprojectpackage;

import newcitationprojectpackage.NewCitationProjectListActivity.btnAddListener;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.gsm.cite.source.R;

public class NewCitationProjectActivity extends Activity {

    ImageButton btnMakeNewProject;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newproject_activity_new_citation_project);
        
        btnMakeNewProject = (ImageButton) findViewById(R.id.confirmNewProjectBtn);
        btnMakeNewProject.setOnClickListener(new btnMakeNewProjectListener());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start_screen, menu);
        return true;
    }
    
    class btnMakeNewProjectListener implements OnClickListener {

		@Override
		public void onClick(View a) {
			Intent intent = new Intent(NewCitationProjectActivity.this,
					NewCitationProjectListActivity.class);
			startActivity(intent);
		}

	}
    
}
