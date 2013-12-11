package newcitationprojectpackage;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

//import com.example.funwithdatabasesmobicomstyle.Citations;
import com.gsm.cite.source.R;

import sqlitePackage.DatabaseCitations;
import sqlitePackage.DatabaseCitations_DAO;

public class NewCitationProjectActivity extends Activity {

    ImageButton btnMakeNewProject;
    EditText citationProjectName;
    Spinner format;
    
    DatabaseCitations_DAO theCitations;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newproject_activity_new_citation_project);
        
        btnMakeNewProject = (ImageButton) findViewById(R.id.confirmNewProjectBtn);
        btnMakeNewProject.setOnClickListener(new btnMakeNewProjectListener());
        
        citationProjectName = (EditText) findViewById(R.id.citationProjectName);
        format = (Spinner) findViewById(R.id.formatSelectorSpn);
        theCitations = new DatabaseCitations_DAO(this);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start_screen, menu);
        return true;
    }
    /*
    private boolean isEmpty (String text) {
        //return text.getText().toString().trim().length() == 0;
        return text.length() == 0;
    
    }
    */
    
    class btnMakeNewProjectListener implements OnClickListener {

		@Override
		public void onClick(View a) {
			Intent intent = new Intent(NewCitationProjectActivity.this,
					NewCitationProjectListActivity.class);
			
			/*String sourceType = "document";
			String projectName = "englres";
			String dateCreated = "Dec";
			String sourceTitle = "my Life";
			String citation = "afnalnflananlanfanlanlanfla";
			*/
			
			String citationprojName = "";
			
			System.out.println("NewCitationProjectActivity------");
			System.out.println("getText(): "+citationProjectName.getText());
			System.out.println("toString(): "+citationProjectName.getText().toString());
			String projectName = citationProjectName.getText().toString();
			System.out.println("projectName: "+projectName);
			
			Toast toast;
			Context context = getApplicationContext();
			int duration = Toast.LENGTH_SHORT;
			CharSequence text;
			
			if (projectName.isEmpty()) {
			    System.out.println("projectName is empty huehuehue");
			    text = "Please fill in the needed data.";
			    
			    toast = Toast.makeText(context, text, duration);
			    toast.show();
			} else {
			    System.out.println("projectName is NOT empty huehuehue");
			    
			    try {
	                
	                long success = theCitations.addCitation(null, projectName, null, null, null);

	                System.out.println(success);

	                if (success != -1) {
	                    text = "Project "+projectName+" was successfully created and saved.";

	                    toast = Toast.makeText(context, text, duration);
	                    toast.show();
	                }

	            } catch (SQLiteException e) {
	                System.out.println("error error");

	                text = "Sorry! An error occurred while creating the project.";

	                toast = Toast.makeText(context, text, duration);
	                toast.show();

	            }
			    
			    List<DatabaseCitations> theCites = new ArrayList<DatabaseCitations>();

	            //theCites = theCitations.getCitations();
	            theCites = theCitations.getCitations();
	            
	            String[] theS = new String[theCites.size()];

	            for (int i = 0; i < theCites.size(); i++) {
	                theS[i] = theCites.get(i).toString();
	                citationprojName = theCites.get(i).getProjectName();
	            }

	            //intent.putExtra("theSList", theS);
	            intent.putExtra("citationProjectName", citationprojName);
	            startActivity(intent);
			}

			/*try {
				
				long success = theCitations.addCitation(sourceType, projectName, dateCreated, sourceTitle, citation);

				System.out.println(success);

				if (success != -1) {
					text = "Student successfully saved!";

					toast = Toast.makeText(context, text, duration);
					toast.show();
				}

			} catch (SQLiteException e) {
				System.out.println("error error");

				text = "Sorry! An error occurred while saving the Student.";

				toast = Toast.makeText(context, text, duration);
				toast.show();

			}
			
			List<DatabaseCitations> theCites = new ArrayList<DatabaseCitations>();

			//theCites = theCitations.getCitations();
			theCites = theCitations.getCitations();
			
			String[] theS = new String[theCites.size()];

			for (int i = 0; i < theCites.size(); i++) {
				theS[i] = theCites.get(i).toString();
			}

			intent.putExtra("theSList", theS);
			
			startActivity(intent);
			*/
		}
		
		

	}
    
}
