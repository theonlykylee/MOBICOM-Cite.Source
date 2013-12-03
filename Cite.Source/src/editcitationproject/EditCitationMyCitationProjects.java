package editcitationproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.gsm.cite.source.R;

public class EditCitationMyCitationProjects extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.editproject_activity_citationprojects);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start_screen, menu);
		return true;
	}

}
