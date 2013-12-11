package sourcepackage;

import java.util.Calendar;

import sqlitePackage.DatabaseCitations_DAO;
import startscreenpackage.StartScreenActivity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.gsm.cite.source.R;

public class SourceFinalCitation extends Activity {
    ImageButton btnHome;
    TextView citationTextView;
    Intent intent;
    
    DatabaseCitations_DAO citationsDB;
    
    String citation;
    String project;
    String sourceType;
    String sourceTitle;
    String dateCreated;
    
    Calendar calendar;
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.source_final);

        btnHome = (ImageButton) findViewById(R.id.homeBtn);
        citationTextView = (TextView) findViewById(R.id.citationTxt);
        
        intent = getIntent();
        citationsDB = new DatabaseCitations_DAO(this);

        citation = intent.getStringExtra("citationTxt");
        project = intent.getStringExtra("projectName");
        sourceType = intent.getStringExtra("sourceType");
        sourceTitle = intent.getStringExtra("sourceTitle");
        
        calendar = Calendar.getInstance();
        int date = calendar.get(Calendar.DATE);
        
        dateCreated = Integer.toString(date);
        
        System.out.println("SourceFinalCitation");
        System.out.println(project);

        citationTextView.setText(citation);
        btnHome.setOnClickListener(new btnHomeListener());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start_screen, menu);
        return true;
    }

    // THESE ARE THE LISTENERS FOR THE BUTTONS

    class btnHomeListener implements OnClickListener {

        @Override
        public void onClick(View a) {
            Intent intent = new Intent(SourceFinalCitation.this,
                    StartScreenActivity.class);
            
            Toast toast;
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            CharSequence text;
            
            if (project.isEmpty()) {
                try {
                    long success = citationsDB.addCitation(sourceType, project, dateCreated, sourceTitle, citation);
                    
                    if (success != -1){
                        /*text = "Citation was successfully saved!";
                        
                        toast = Toast.makeText(context, text, duration);
                        toast.show();*/
                        System.out.println("success");
                    }
                } catch (SQLiteException e) {
                    /*text = "Sorry! There was an error in saving the citation.";
                    
                    toast = Toast.makeText(context, text, duration);
                    toast.show();*/
                    System.out.println("error");
                }
            } else {
                try {
                    long success = citationsDB.addCitation(sourceType, project, dateCreated, sourceTitle, citation);
                    
                    if (success != -1){
                        text = "Citation was successfully saved!";
                        
                        toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                } catch (SQLiteException e) {
                    text = "Sorry! There was an error in saving the citation.";
                    
                    toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
                
                
            /*for (int i = 0; i < citationsDB.getCitations().size(); i++) {
                if (project == citationsDB.getCitations().get(i).getProjectName()) {
                    try {
                        long success = citationsDB.addCitation(sourceType, project, dateCreated, sourceTitle, citation);
                        
                        if (success != -1){
                            text = "Citation was successfully saved!";
                            
                            toast = Toast.makeText(context, text, duration);
                            toast.show();
                        }
                    } catch (SQLiteException e) {
                        text = "Sorry! There was an error in saving the citation.";
                        
                        toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                }
            }*/
            
            startActivity(intent);
        }

    }

}
