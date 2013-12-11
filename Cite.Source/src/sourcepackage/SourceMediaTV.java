package sourcepackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.gsm.cite.source.R;

public class SourceMediaTV extends Activity {
ImageButton btnDone;
EditText contributorName;
EditText yearAired;
EditText titleOfTheEpisode;
Spinner mediumSpn;
EditText producerName;
EditText programName;
EditText broadcastCity;
EditText broadcastCompany;
EditText webURL;
Spinner contributionSpn;
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.source_media_tv);
        
        btnDone = (ImageButton) findViewById(R.id.imdoneBtn);
        btnDone.setOnClickListener(new btnDoneListener());
        
        contributorName = (EditText) findViewById(R.id.contributorNameTxt);
        yearAired = (EditText) findViewById(R.id.yearAiredTxt);
        titleOfTheEpisode = (EditText) findViewById(R.id.titleTxt);
        mediumSpn = (Spinner) findViewById(R.id.mediumSpn);
        producerName = (EditText) findViewById(R.id.producerNameTxt);
        programName = (EditText) findViewById(R.id.programNameTxt);
        broadcastCity = (EditText) findViewById(R.id.broadcastCityTxt);
        broadcastCompany = (EditText) findViewById(R.id.broadcastCompanyTxt);
        webURL = (EditText) findViewById(R.id.urlTxt);
        contributionSpn = (Spinner) findViewById(R.id.contributionSpn);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start_screen, menu);
        return true;
    }
    
    // THESE ARE THE LISTENERS FOR THE BUTTONS
    
    private boolean isEmpty(String text) {
        // return text.getText().toString().trim().length() == 0;
        return text.length() == 0;

    }
    
    class btnDoneListener implements OnClickListener {

		@Override
		public void onClick(View a) {
			Intent intent = new Intent(SourceMediaTV.this, SourceFinalCitation.class);
			
			String citationTxt;
			String mode = "";
			
			String contName = contributorName.getText().toString();
			String year = yearAired.getText().toString();
			String episode = titleOfTheEpisode.getText().toString();
			String medium = mediumSpn.getSelectedItem().toString();
			String producer = producerName.getText().toString();
			String program = programName.getText().toString();
			String city = broadcastCity.getText().toString();
			String company = broadcastCompany.getText().toString();
			String url = webURL.getText().toString();
			String contribution = contributionSpn.getSelectedItem().toString();
			
			if (medium.equals("Television")) {
			    mode = "Television series episode";
			} else if (medium.equals("Radio")) {
			    mode = "Radio series episode";
			} else if (medium.equals("Web")) {
			    mode = "Web series episode";
			}
			
			if (isEmpty(contName)) {
			    if (isEmpty(year)) {
			        citationTxt = episode+" ["+mode+"]. In "+producer+" (Executive Producer), "+program+". "+city+": "+company+". Retrieved from "+url;
			        intent.putExtra("citationTxt", citationTxt);
			    } else if (isEmpty(episode)) {
			        citationTxt = "("+year+"). In "+producer+" (Executive Producer), "+program+". "+city+": "+company+". Retrieved from "+url;
			        intent.putExtra("citationTxt", citationTxt);
			    } else if (isEmpty(producer)) {
			        citationTxt = episode+" ["+mode+"]. ("+year+"). In "+program+". "+city+": "+company+". Retrieved from "+url;
			        intent.putExtra("citationTxt", citationTxt);
			    } else if (isEmpty(program)) {
			        citationTxt = episode+" ["+mode+"]. ("+year+"). "+city+": "+company+". Retrieved from "+url;
			        intent.putExtra("citationTxt", citationTxt);
			    } else if (isEmpty(city)) {
			        citationTxt = episode+" ["+mode+"]. ("+year+"). In "+producer+" (Executive Producer), "+program+". "+company+". Retrieved from "+url;
			        intent.putExtra("citationTxt", citationTxt);
			    } else if (isEmpty(company)) {
			        citationTxt = episode+" ["+mode+"]. ("+year+"). In "+producer+" (Executive Producer), "+program+". "+city+": Retrieved from "+url;
			        intent.putExtra("citationTxt", citationTxt);
			    } else if (isEmpty(url)) {
			        citationTxt = episode+" ["+mode+"]. ("+year+"). In "+producer+" (Executive Producer), "+program+". "+city+": "+company+".";
			        intent.putExtra("citationTxt", citationTxt);
			    } else {
			        citationTxt = episode+" ["+mode+"]. ("+year+"). In "+producer+" (Executive Producer), "+program+". "+city+"; "+company+". Retrieved from "+url;
			        intent.putExtra("citationTxt", citationTxt);
			    }
			} else if (isEmpty(year)) {
			    if (isEmpty(episode)) {
			        citationTxt = contName+" ("+contribution+") (n.d.). In "+producer+" (Executive Producer), "+program+". "+city+": "+company+". Retrieved from "+url;
			        intent.putExtra("citationTxt", citationTxt);
			    } else if (isEmpty(producer)) {
			        citationTxt = contName+" ("+contribution+") (n.d.). "+episode+" ["+mode+"]. In "+program+". "+city+": "+company+". Retrieved from "+url;
			        intent.putExtra("citationTxt", citationTxt);
			    } else if (isEmpty(program)) {
			        citationTxt = contName+" ("+contribution+") (n.d.). "+episode+" ["+mode+"]. "+city+": "+company+". Retrieved from "+url;
			        intent.putExtra("citationTxt", citationTxt);
			    } else if (isEmpty(city)) {
			        citationTxt = contName+" ("+contribution+") (n.d.). "+episode+" ["+mode+"]. In "+producer+" (Executive Producer), "+program+". "+company+". Retrieved from "+url;
			        intent.putExtra("citationTxt", citationTxt);
			    } else if (isEmpty(company)) {
			        citationTxt = contName+" ("+contribution+") (n.d.). "+episode+" ["+mode+"]. In "+producer+" (Executive Producer), "+program+". "+city+": Retrieved from "+url;
			        intent.putExtra("citationTxt", citationTxt);
			    } else if (isEmpty(url)) {
			        citationTxt = contName+" ("+contribution+") (n.d.). "+episode+" ["+mode+"]. In "+producer+" (Executive Producer), "+program+". "+city+": "+company+".";
			        intent.putExtra("citationTxt", citationTxt);
			    } else {
			        citationTxt = contName+" ("+contribution+") (n.d.). "+episode+" ["+mode+"]. In "+producer+" (Executive Producer), "+program+". "+city+": "+company+". Retrieved from "+url;
			        intent.putExtra("citationTxt", citationTxt);
			    }
			} else if (isEmpty(episode)) {
			    if (isEmpty(producer)) {
			        citationTxt = contName+" ("+contribution+") ("+year+"). In "+program+". "+city+": "+company+". Retrieved from "+url;
			        intent.putExtra("citationTxt", citationTxt);
			    } else if (isEmpty(program)) {
			        citationTxt = contName+" ("+contribution+") ("+year+"). "+city+": "+company+". Retrieved from "+url;
			        intent.putExtra("citationTxt", citationTxt);
			    } else if (isEmpty(city)) {
			        citationTxt = contName+" ("+contribution+") ("+year+"). In "+producer+" (Executive Producer), "+program+". "+company+". Retrieved from "+url;
			        intent.putExtra("citationTxt", citationTxt);
			    } else if (isEmpty(company)) {
			        citationTxt = contName+" ("+contribution+") ("+year+"). In "+producer+" (Executive Producer), "+program+". "+city+": Retrieved from "+url;
			        intent.putExtra("citationTxt", citationTxt);
			    } else if (isEmpty(url)) {
			        citationTxt = contName+" ("+contribution+") ("+year+"). In "+producer+" (Executive Producer), "+program+". "+city+": "+company+".";
			        intent.putExtra("citationTxt", citationTxt);
			    } else {
			        citationTxt = contName+" ("+contribution+") ("+year+"). In "+producer+" (Executive Producer), "+program+". "+city+": "+company+". Retrieved from "+url;
			        intent.putExtra("citationTxt", citationTxt);
			    }
			} else if (isEmpty(producer)) {
			    if (isEmpty(program)) {
			        citationTxt = contName+" ("+contribution+") ("+year+"). "+episode+" ["+mode+"]. "+city+": "+company+". Retrieved from "+url;
			        intent.putExtra("citationTxt", citationTxt);
			    } else if (isEmpty(city)) {
			        citationTxt = contName+" ("+contribution+") ("+year+"). "+episode+" ["+mode+"]. In "+program+". "+company+". Retrieved from "+url;
			        intent.putExtra("citationTxt", citationTxt);
			    } else if (isEmpty(company)) {
			        citationTxt = contName+" ("+contribution+") ("+year+"). "+episode+" ["+mode+"]. In "+program+". "+city+": Retrieved from "+url;
			        intent.putExtra("citationTxt", citationTxt);
			    } else if (isEmpty(url)) {
			        citationTxt = contName+" ("+contribution+") ("+year+"). "+episode+" ["+mode+"]. In "+program+". "+city+": "+company+".";
			        intent.putExtra("citationTxt", citationTxt);
			    } else {
			        citationTxt = contName+" ("+contribution+") ("+year+"). "+episode+" ["+mode+"]. In "+program+". "+city+": "+company+". Retrieved from "+url;
			        intent.putExtra("citationTxt", citationTxt);
			    }
			} else if (isEmpty(program)) {
			    if (isEmpty(city)) {
			        citationTxt = contName+" ("+contribution+") ("+year+"). "+episode+" ["+mode+"]. "+company+". Retrieved from "+url;
			        intent.putExtra("citationTxt", citationTxt);
			    } else if (isEmpty(company)) {
			        citationTxt = contName+" ("+contribution+") ("+year+"). "+episode+" ["+mode+"]. "+city+": Retrieved from "+url;
			        intent.putExtra("citationTxt", citationTxt);
			    } else if (isEmpty(url)) {
			        citationTxt = contName+" ("+contribution+") ("+year+"). "+episode+" ["+mode+"]. "+city+": "+company+".";
                    intent.putExtra("citationTxt", citationTxt);
			    } else {
			        citationTxt = contName+" ("+contribution+") ("+year+"). "+episode+" ["+mode+"]. "+city+": "+company+". Retrieved from "+url;
                    intent.putExtra("citationTxt", citationTxt);
			    }
			} else if (isEmpty(city)) {
			    if (isEmpty(company)) {
			        citationTxt = contName+" ("+contribution+") ("+year+"). "+episode+" ["+mode+"]. In "+producer+" (Executive Producer), "+program+". Retrieved from "+url;
                    intent.putExtra("citationTxt", citationTxt);
			    } else if (isEmpty(url)) {
			        citationTxt = contName+" ("+contribution+") ("+year+"). "+episode+" ["+mode+"]. In "+producer+" (Executive Producer), "+program+". "+company+".";
                    intent.putExtra("citationTxt", citationTxt);
			    } else {
			        citationTxt = contName+" ("+contribution+") ("+year+"). "+episode+" ["+mode+"]. In "+producer+" (Executive Producer), "+program+". "+company+". Retrieved from "+url;
                    intent.putExtra("citationTxt", citationTxt);
			    }
			} else {
			    citationTxt = contName+" ("+contribution+") ("+year+"). "+episode+" ["+mode+"]. In "+producer+" (Executive Producer), "+program+". "+city+": "+company+". Retrieved from "+url;
			    intent.putExtra("citationTxt", citationTxt);
			}
			
			if (isEmpty(contName) && isEmpty(year) && isEmpty(episode) && isEmpty(producer) && isEmpty(program) && isEmpty(city) && isEmpty(company) && isEmpty(url)) {
			    Toast toast;
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                CharSequence text;

                text = "Please fill in the needed data.";

                toast = Toast.makeText(context, text, duration);
                toast.show();
			} else {
			    startActivity(intent);
			}
		}
    	
    }

}
