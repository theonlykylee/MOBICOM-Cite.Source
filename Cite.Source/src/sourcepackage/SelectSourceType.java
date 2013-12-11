package sourcepackage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.gsm.cite.source.R;

public class SelectSourceType extends FragmentActivity {

	SectionsPagerAdapter mSectionsPagerAdapter;

	ViewPager mViewPager;
	Intent intent;
	String projectName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.sourceselect_activity_select_citation_type);

		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
		mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
		
		intent = getIntent();
		projectName = intent.getStringExtra("projectName");
		System.out.println("SelectSourceType----");
		System.out.println(projectName);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start_screen, menu);
		return true;
	}

	public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		public Fragment getItem(int position) {
			Fragment fragment = null;
			Bundle args = null;

			switch (position) {
			case 0:
				fragment = new DocumentsSectionFragment();
				args = new Bundle();
				args.putInt(DocumentsSectionFragment.ARG_SECTION_NUMBER,
						position + 1);
				fragment.setArguments(args);
				break;
			case 1:
				fragment = new PublicationsSectionFragment();
				args = new Bundle();
				args.putInt(PublicationsSectionFragment.ARG_SECTION_NUMBER,
						position + 1);
				fragment.setArguments(args);
				break;
			case 2:
				fragment = new MultimediaSectionFragment();
				args = new Bundle();
				args.putInt(MultimediaSectionFragment.ARG_SECTION_NUMBER,
						position + 1);
				fragment.setArguments(args);
				break;
			case 3:
				fragment = new OthersSectionFragment();
				args = new Bundle();
				args.putInt(OthersSectionFragment.ARG_SECTION_NUMBER,
						position + 1);
				fragment.setArguments(args);
				break;
			}

			return fragment;
		}

		public int getCount() {
			return 4;
		}

		public CharSequence getPageTitle(int position) {
			switch (position) {
			case 0:
				return Html.fromHtml("<b>Documents</b>");
			case 1:
				return Html.fromHtml("<b>Publications</b>");
			case 2:
				return Html.fromHtml("<b>Multimedia</b>");
			case 3:
				return Html.fromHtml("<b>Others</b>");
			}
			return null;
		}
	}

	@SuppressLint("ValidFragment")
	public class DocumentsSectionFragment extends Fragment {
		public static final String ARG_SECTION_NUMBER = "section_number";

		ImageButton btnWeb;
		ImageButton btnBook;
		ImageButton btnAcademic;
		ImageButton btnConference;

		public DocumentsSectionFragment() {
		}

		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(
					R.layout.sourceselect_fragment_documents, container, false);

			btnWeb = (ImageButton) rootView.findViewById(R.id.documents_webBtn);
			btnBook = (ImageButton) rootView
					.findViewById(R.id.documents_bookBtn);
			btnAcademic = (ImageButton) rootView
					.findViewById(R.id.documents_academicBtn);
			btnConference = (ImageButton) rootView
					.findViewById(R.id.documents_conferenceBtn);

			Log.d("KYLE: btnWeb", btnWeb.toString());

			btnWeb.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(getActivity(),
							SourceDocWeb.class);
					intent.putExtra("sourceType", "Document: Web");
					intent.putExtra("projectName", projectName);
					startActivity(intent);
				}

			});

			btnBook.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(getActivity(),
							SourceDocBook.class);
					startActivity(intent);
				}

			});

			btnAcademic.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(SelectSourceType.this,
							SourceDocAcademic.class);
					startActivity(intent);
				}

			});

			btnConference.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(SelectSourceType.this,
							SourceDocConference.class);
					startActivity(intent);
				}

			});

			return rootView;
		}
	}

	@SuppressLint("ValidFragment")
	public class PublicationsSectionFragment extends Fragment {
		public static final String ARG_SECTION_NUMBER = "section_number";

		ImageButton btnJournal;
		ImageButton btnMagazine;
		ImageButton btnNewspaper;

		public PublicationsSectionFragment() {
		}

		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(
					R.layout.sourceselect_fragment_publications, container,
					false);

			btnJournal = (ImageButton) rootView
					.findViewById(R.id.pubs_journalBtn);
			btnMagazine = (ImageButton) rootView
					.findViewById(R.id.pubs_magazineBtn);
			btnNewspaper = (ImageButton) rootView
					.findViewById(R.id.pubs_newspaperBtn);

			btnJournal.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(SelectSourceType.this,
							SourcePubJournal.class);
					startActivity(intent);

				}

			});

			btnMagazine.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(SelectSourceType.this,
							SourcePubMagazine.class);
					startActivity(intent);

				}

			});

			btnNewspaper.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(SelectSourceType.this,
							SourcePubNewspaper.class);
					startActivity(intent);

				}

			});

			return rootView;
		}
	}

	@SuppressLint("ValidFragment")
	public class MultimediaSectionFragment extends Fragment {
		public static final String ARG_SECTION_NUMBER = "section_number";

		ImageButton btnAV;
		ImageButton btnTV;
		ImageButton btnImage;

		public MultimediaSectionFragment() {
		}

		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater
					.inflate(R.layout.sourceselect_fragment_multimedia,
							container, false);

			btnAV = (ImageButton) rootView.findViewById(R.id.media_avBtn);
			btnTV = (ImageButton) rootView.findViewById(R.id.media_tvBtn);
			btnImage = (ImageButton) rootView.findViewById(R.id.media_imageBtn);

			btnAV.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(SelectSourceType.this,
							SourceMediaAV.class);
					startActivity(intent);

				}

			});

			btnTV.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(SelectSourceType.this,
							SourceMediaTV.class);
					startActivity(intent);

				}

			});

			btnImage.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(SelectSourceType.this,
							SourceMediaImage.class);
					startActivity(intent);

				}

			});

			return rootView;
		}
	}

	@SuppressLint("ValidFragment")
	public class OthersSectionFragment extends Fragment {
		public static final String ARG_SECTION_NUMBER = "section_number";

		ImageButton btnBlog;
		ImageButton btnOnlineDisc;
		ImageButton btnPodcast;
		ImageButton btnInterview;

		public OthersSectionFragment() {
		}

		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(
					R.layout.sourceselect_fragment_others, container, false);

			btnBlog = (ImageButton) rootView.findViewById(R.id.others_blogBtn);
			btnOnlineDisc = (ImageButton) rootView
					.findViewById(R.id.others_onlinediscussionBtn);
			btnPodcast = (ImageButton) rootView
					.findViewById(R.id.others_podcastBtn);
			btnInterview = (ImageButton) rootView
					.findViewById(R.id.others_interviewBtn);

			btnBlog.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(SelectSourceType.this,
							SourceOthersBlog.class);
					startActivity(intent);

				}

			});

			btnOnlineDisc.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(SelectSourceType.this,
							SourceOthersOnlineDisc.class);
					startActivity(intent);

				}

			});

			btnPodcast.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(SelectSourceType.this,
							SourceOthersPodcasts.class);
					startActivity(intent);

				}

			});

			btnInterview.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(SelectSourceType.this,
							SourceOthersInterview.class);
					startActivity(intent);

				}

			});

			return rootView;
		}
	}

}
