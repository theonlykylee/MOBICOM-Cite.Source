package editcitationproject;

import java.util.ArrayList;
import java.util.List;

import sqlitePackage.DatabaseCitations;
import sqlitePackage.DatabaseCitations_DAO;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
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
    
    //Added
    ArrayAdapter<String> adapter;
    String[] citations;
    
    DatabaseCitations_DAO citationsDB;
    
    //Added
    String citationProjectName;
    
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.editproject_activity_citationproject);
		
		projectName = (TextView) findViewById(R.id.citationListName);
		newcitationLst = (ListView) findViewById(R.id.newcitationLst);
		markCitationBtn = (ImageButton) findViewById(R.id.markCitationBtn);
		addCitationBtn = (ImageButton) findViewById(R.id.addCitationBtn);
		deleteCitationBtn = (ImageButton) findViewById(R.id.deleteCitationBtn);
		
		intent = getIntent();
		citationsDB = new DatabaseCitations_DAO(this); //Added
		
		citationProjectName = intent.getStringExtra("citationProjectName");
		projectName.setText(citationProjectName);
		
		//Added
		/*List<DatabaseCitations> theCites = new ArrayList<DatabaseCitations>();
        theCites = citationsDB.getCitations();
        citations = new String[theCites.size()];
        
        for (int i = 0; i < theCites.size(); i++) {
            citations[i] = citationsDB.getCitations().get(i).getCitation(); //theCites.get(i).getCitation();
        }
		
		
		
		//Added
		//citations = intent.getStringArrayExtra("citationList");
		//Added
		adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, citations);
		newcitationLst.setAdapter(adapter);*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start_screen, menu);
		return true;
	}

}
