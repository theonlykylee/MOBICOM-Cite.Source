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

public class Citation_Document_WebPage_DAO extends SQLiteOpenHelper{

	
	final static String DATABASE_NAME = "citations.db";
	final static int DATABASE_VERSION = 1;

	public static final String TABLE_NAME = "citations";
	
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_AUTHORLNAME = "authorLName";
	public static final String COLUMN_AUTHORINITIALS = "authorInitials";
	public static final String COLUMN_DATEPUBLISHED = "datePublished";
	public static final String COLUMN_TITLE = "title";
	public static final String COLUMN_WEBADDRESS = "webAddress";
	
	public static String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" 
			+ COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " 
			+ COLUMN_AUTHORLNAME + " TEXT NOT NULL, " 
			+ COLUMN_DATEPUBLISHED + " TEXT NOT NULL, "
			+ COLUMN_TITLE + " TEXT NOT NULL, " 
			+ COLUMN_WEBADDRESS + " TEXT NOT NULL);";
	
	
	public Citation_Document_WebPage_DAO(Context context) {
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
	
	//public long addStudent(String name, int idNum, int year) {
	public long addStudent(String authorLName, String authorInitials, String datePublished, 
			String title, String webAddress) {
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues cv = new ContentValues();
		
		cv.put(COLUMN_AUTHORLNAME, authorLName);
		cv.put(COLUMN_AUTHORINITIALS, authorInitials);
		cv.put(COLUMN_DATEPUBLISHED, datePublished);
		cv.put(COLUMN_TITLE, title);
		cv.put(COLUMN_WEBADDRESS, webAddress);
		
		long success = db.insert(TABLE_NAME, null, cv);
		
		db.close();
		
		System.out.println("Returning " + success);
		
		return success;
	}
	
	public List<Citations_Docu_WebPage> getStudents() {

		List<Citations_Docu_WebPage> students = new ArrayList<Citations_Docu_WebPage>();
		SQLiteDatabase db = this.getWritableDatabase();
		
		Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
		
		Log.d("DB: getStudents()", "Cursor count = " + cursor.getCount());
		
		cursor.moveToFirst();
		
		Log.d("DB: getStudents()", "Cursor position = " + cursor.getPosition());
		
		while(cursor.isAfterLast() == false) {
			students.add(cursorToStudent(cursor));
			cursor.moveToNext();
		}
		
		Log.d("DB: List<Students>", "The size of the List is " + students.size());
		
		db.close();
		
		return students;
	}

	private Citations_Docu_WebPage cursorToStudent(Cursor cursor) {
		Citations_Docu_WebPage stud = new Citations_Docu_WebPage();
		
		stud.setAuthorLName(cursor.getString(1));
		stud.setAuthorInitials(cursor.getString(2));
		stud.setDatePublication(cursor.getString(3));
		stud.setTitle(cursor.getString(4));
		stud.setUrlWebAddress(cursor.getString(5));
		
		
		return stud;
	}

}
