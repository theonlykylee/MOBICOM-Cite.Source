package sqlitePackage;

import java.util.ArrayList;
import java.util.List;

//import com.example.funwithdatabasesmobicomstyle.Student;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseCitations_DAO extends SQLiteOpenHelper{

	
	final static String DATABASE_NAME = "citationsDatabase.db";
	final static int DATABASE_VERSION = 1;

	public static final String TABLE_NAME = "citationsDatabase";
	private Cursor cursor;
//	
//	public static final String COLUMN_ID = "_id";
//	public static final String COLUMN_AUTHORLNAME = "authorLName";
//	public static final String COLUMN_AUTHORINITIALS = "authorInitials";
//	public static final String COLUMN_DATEPUBLISHED = "datePublished";
//	public static final String COLUMN_TITLE = "title";
//	public static final String COLUMN_WEBADDRESS = "webAddress";
//	
	
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_SOURCETYPE = "sourceType";
	public static final String COLUMN_PROJECTNAME = "projectName";
	public static final String COLUMN_DATECREATED = "dateCreated";
	public static final String COLUMN_SOURCETITLE = "sourceTitle";
	public static final String COLUMN_CITATION = "citation";
	
//	
//	public static String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" 
//			+ COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " 
//			+ COLUMN_AUTHORLNAME + " TEXT NOT NULL, " 
//			+ COLUMN_DATEPUBLISHED + " TEXT NOT NULL, "
//			+ COLUMN_TITLE + " TEXT NOT NULL, " 
//			+ COLUMN_WEBADDRESS + " TEXT NOT NULL);";
//	
	

	public static String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" 
			+ COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " 
			+ COLUMN_SOURCETYPE + " TEXT, " 
			+ COLUMN_PROJECTNAME + " TEXT, "
			+ COLUMN_DATECREATED + " TEXT, " 
			+ COLUMN_SOURCETITLE + " TEXT, "
			+ COLUMN_CITATION + " TEXT);";
	
	
	
	public DatabaseCitations_DAO(Context context) {
		// TODO Auto-generated constructor stub
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_TABLE);
		
	}
	
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		
		onCreate(db);
	}
	
	//public long addCitation(String name, int idNum, int year) {
	public long addCitation(String sourceType, String projectName, String dateCreated, 
			String sourceTitle, String citation) {
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues cv = new ContentValues();
		
		cv.put(COLUMN_SOURCETYPE, sourceType);
		cv.put(COLUMN_PROJECTNAME, projectName);
		cv.put(COLUMN_DATECREATED, dateCreated);
		cv.put(COLUMN_SOURCETITLE, sourceTitle);
		cv.put(COLUMN_CITATION, citation);
		
		long success = db.insert(TABLE_NAME, null, cv);
		
		db.close();
		
		System.out.println("Returning " + success);
		
		return success;
	}
	
	public List<DatabaseCitations> getCitations() {

		List<DatabaseCitations> citations = new ArrayList<DatabaseCitations>();
		SQLiteDatabase db = this.getWritableDatabase();
		
		cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
		
		Log.d("DB: getCitations()", "Cursor count = " + cursor.getCount());
		
		cursor.moveToFirst();
		
		Log.d("DB: getCitations()", "Cursor position = " + cursor.getPosition());
		
		while(cursor.isAfterLast() == false) {
			citations.add(cursorToStudent(cursor));
			cursor.moveToNext();
		}
		
		Log.d("DB: List<DatabaseCitations>", "The size of the List is " + citations.size());
		
		db.close();
		
		return citations;
	}

	private DatabaseCitations cursorToStudent(Cursor cursor) {
		DatabaseCitations cite = new DatabaseCitations();
		
		
		cite.setSourceType(cursor.getString(1));
		cite.setProjectName(cursor.getString(2));
		cite.setDateCreated(cursor.getString(3));
		cite.setSourceTitle(cursor.getString(4));
		cite.setCitation(cursor.getString(5));
		
		
		return cite;
	}

}
