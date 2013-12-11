package editcitationproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.gsm.cite.source.R;

public class EditCitationCitationProject extends Activity {
    Intent intent;
    
    TextView projectName;
    ListView newcitationLst;
    ImageButton markCitationBtn;
    ImageButton addCitationBtn;
    ImageButton deleteCitationBtn;
    
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.editproject_activity_citationproject);
		
		projectName = (TextView) findViewById(R.id.citationListName);
		newcitationLst = (ListView) findViewById(R.id.newcitationLst);
		markCitationBtn = (ImageButton) findViewById(R.id.markCitationBtn);
		addCitationBtn = (ImageButton) findViewById(R.id.addCitationBtn);
		deleteCitationBtn = (ImageButton) findViewById(R.id.deleteCitationBtn);
		
		intent = getIntent();
		String citationProjectName = intent.getStringExtra("citationProjectName");
		
		projectName.setText(citationProjectName);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start_screen, menu);
		return true;
	}

}
