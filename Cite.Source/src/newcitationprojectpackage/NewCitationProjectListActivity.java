package newcitationprojectpackage;

import sourcepackage.SelectSourceType;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

import com.gsm.cite.source.R;

public class NewCitationProjectListActivity extends Activity {

	ImageButton btnAdd;
	TextView txtvwListName;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newproject_activity_newcitationlist);

		txtvwListName = (TextView) findViewById(R.id.citationListName);
		btnAdd = (ImageButton) findViewById(R.id.addCitationBtn);
		btnAdd.setOnClickListener(new btnAddListener());

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start_screen, menu);
		return true;
	}

	// THESE ARE THE LISTENERS FOR THE BUTTONS

	class btnAddListener implements OnClickListener {

		@Override
		public void onClick(View a) {
			Intent intent = new Intent(NewCitationProjectListActivity.this,
					SelectSourceType.class);
			startActivity(intent);
		}

	}

}
