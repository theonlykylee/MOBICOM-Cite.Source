package editcitationproject;

import java.util.ArrayList;
import java.util.List;

import sqlitePackage.DatabaseCitations;
import sqlitePackage.DatabaseCitations_DAO;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.gsm.cite.source.R;

public class EditCitationMyCitationProjects extends Activity {
    ListView citationProjectList;
    Intent intent;
    ArrayAdapter<String> adapter;
    String[] projects;
    DatabaseCitations_DAO citationsDB;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editproject_activity_citationprojects);

        citationsDB = new DatabaseCitations_DAO(this);
        
        citationProjectList = (ListView) findViewById(R.id.newcitationLst);
        intent = getIntent();

        projects = intent.getStringArrayExtra("theSList");

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, projects);
        
        /*
         * System.out.println("getSelectedItem(): "+citationProjectList.getSelectedItem());
         * System.out.println("toString(): "+citationProjectList.getSelectedItem().toString());
         */
        
        citationProjectList.setAdapter(adapter);
        citationProjectList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position,
                    long id) {
                // TODO Auto-generated method stub
                String selectedItem = parent.getItemAtPosition(position).toString();
                
                System.out.println("selectedItem = "+selectedItem);
                
                Intent intent = new Intent(EditCitationMyCitationProjects.this, EditCitationCitationProject.class);
                
                /*List<DatabaseCitations> theCites = new ArrayList<DatabaseCitations>();
                theCites = citationsDB.getCitations();
                String[] theS = new String[theCites.size()];
                //String projectName;
                
                for (int i = 0; i < theCites.size(); i++) {
                    theS[i] = theCites.get(i).getCitation();
                }
                */
                intent.putExtra("citationProjectName", selectedItem);
                //intent.putExtra("citationList", theS);
                startActivity(intent);
                
            }
        });
        

            
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start_screen, menu);
        return true;
    }

}
