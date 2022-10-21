package br.edu.uniritter.mobile.atividadesqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelperClass extends SQLiteOpenHelper {

    //Database version
    private static final int DATABASE_VERSION = 1;
    //Database Name
    private static final String DATABASE_NAME ="customer_database";
    //Database Table name
    private static final String TABLE_NAME = "CUSTOMER";
    //Table columns
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    private SQLiteDatabase sqLiteDatabase;

    //Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "("+ID+
            " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " TEXT NOT NULL," +EMAIL+ " TEXT NOT NULL);";

    public DatabaseHelperClass (Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public  void onCreate (SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //Add Customer Data
    public void addCustomer(CustomerModelClass customerModelClass) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperClass.NAME, customerModelClass.getName());
        contentValues.put(DatabaseHelperClass.EMAIL, customerModelClass.getEmail());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DatabaseHelperClass.TABLE_NAME, null, contentValues);
    }
}
