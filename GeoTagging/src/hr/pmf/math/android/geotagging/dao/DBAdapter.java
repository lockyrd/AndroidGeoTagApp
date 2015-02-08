package hr.pmf.math.android.geotagging.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter {
	static final String KEY_ROWID = "_id";
    static final String KEY_TITLE = "title";
    static final String KEY_DESCR = "descr";
    static final String KEY_PATH = "path";
    static final String TAG = "DBAdapter";

    static final String DATABASE_NAME = "GeoTagDB";
    static final String DATABASE_TABLE = "contacts";
    static final int DATABASE_VERSION = 1;

    static final String DATABASE_CREATE =
        "create table " + DATABASE_TABLE + " (_id integer primary key autoincrement, "
        + "title text , descr text , path text not null);";

    final Context context;

    DatabaseHelper DBHelper;
    SQLiteDatabase db;
    
    public DBAdapter(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }
    
    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            try {
                db.execSQL(DATABASE_CREATE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS contacts");
            onCreate(db);
        }
    }
    
  //---opens the database---
    public DBAdapter open() throws SQLException 
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //---closes the database---
    public void close() 
    {
        DBHelper.close();
    }



	public TagEntry getEntry(String id) {
		this.open();
		Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[] {KEY_ROWID,
                KEY_TITLE, KEY_DESCR, KEY_PATH}, KEY_ROWID + "=" + id, null,
                null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        } else {
        	this.close();
        	return null;
        }
        int _id = mCursor.getInt(0);
        String t = mCursor.getString(1);
        String d = mCursor.getString(2);
        String p = mCursor.getString(3);
        this.close();
        return new TagEntry(Integer.toString(_id), t, d, p);
	}

	public List<TagEntry> getEntries() {
		List<TagEntry> entries = new ArrayList<TagEntry>();
		String i,t,d,p;
		this.open();
		Cursor c = db.query(DATABASE_TABLE, new String[] {KEY_ROWID,
                KEY_TITLE, KEY_DESCR, KEY_PATH}, null, null, null, null, null);
		
		if(c.moveToFirst()){
			do{
				i = Integer.toString(c.getInt(0));
				t = c.getString(1);
				d = c.getString(2);
				p = c.getString(3);
				entries.add(new TagEntry(i, t, d, p));
			}while(c.moveToNext());
		}
		this.close();
		return entries;
	}

	public void deleteEntry(String id) {
		this.open();
		db.delete(DATABASE_TABLE, KEY_ROWID + "=" + id, null);
		this.close();
	}

	public void addEntry(String title, String description, String path) {
		this.open();
		ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_TITLE, title);
        initialValues.put(KEY_DESCR, description);
        initialValues.put(KEY_PATH,path);
        db.insert(DATABASE_TABLE, null, initialValues);
        this.close();
	}
    
}
