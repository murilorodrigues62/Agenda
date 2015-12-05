package br.edu.ifspsaocarlos.agenda.data;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class SQLiteHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "agenda.db";
    public static final String DATABASE_TABLE = "contatos";
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "nome";
    public static final String KEY_FONE = "fone";
    public static final String KEY_FONE2 = "fone2";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_NIVER = "niver";
    public static final int DATABASE_VERSION = 3;

    public static final String DATABASE_CREATE_1 = "CREATE TABLE "+ DATABASE_TABLE +" (" +
            KEY_ID    + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            KEY_NAME  + " TEXT NOT NULL, " +
            KEY_FONE  + " TEXT, "  +
            KEY_EMAIL + " TEXT);";

    public static final String DATABASE_CREATE_2 = "CREATE TABLE "+ DATABASE_TABLE +" (" +
            KEY_ID    + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            KEY_NAME  + " TEXT NOT NULL, " +
            KEY_FONE  + " TEXT, "  +
            KEY_FONE2 + " TEXT, "  +
            KEY_EMAIL + " TEXT);";

    public static final String DATABASE_CREATE_3 = "CREATE TABLE "+ DATABASE_TABLE +" (" +
            KEY_ID    + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            KEY_NAME  + " TEXT NOT NULL, " +
            KEY_FONE  + " TEXT, "  +
            KEY_FONE2 + " TEXT, " +
            KEY_EMAIL + " TEXT, " +
            KEY_NIVER + " TEXT);";

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE_3);
    }
    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {

        switch (oldVersion){
            case 1: updateVersion1To2(database);
            case 2: updateVersion2To3(database);
        }
    }

    public void updateVersion1To2(SQLiteDatabase database){
        String sql;
        String DATABASE_TABLE_BKP = DATABASE_TABLE + "_1";


        sql = " ALTER TABLE " + DATABASE_TABLE + " RENAME TO " + DATABASE_TABLE_BKP;

        database.execSQL(sql);

        database.execSQL(DATABASE_CREATE_2);

        sql = " INSERT INTO " + DATABASE_TABLE + " ( " +
                          KEY_ID    + "," +
                          KEY_NAME  + "," +
                          KEY_FONE  + "," +
                          KEY_EMAIL + ") "+
              " SELECT "+ KEY_ID    + "," +
                          KEY_NAME  + "," +
                          KEY_FONE  + "," +
                          KEY_EMAIL +
                " FROM " + DATABASE_TABLE_BKP;

        database.execSQL(sql);

        sql = " DROP TABLE " + DATABASE_TABLE_BKP;

        database.execSQL(sql);

    }

    public void updateVersion2To3(SQLiteDatabase database){
        String sql;
        String DATABASE_TABLE_BKP = DATABASE_TABLE + "_2";


        sql = " ALTER TABLE " + DATABASE_TABLE + " RENAME TO " + DATABASE_TABLE_BKP;

        database.execSQL(sql);

        database.execSQL(DATABASE_CREATE_3);

        sql = " INSERT INTO " + DATABASE_TABLE + " ( " +
                            KEY_ID      + "," +
                            KEY_NAME    + "," +
                            KEY_FONE    + "," +
                            KEY_FONE2   + "," +
                            KEY_EMAIL   + ") "+
                " SELECT "+ KEY_ID      + "," +
                            KEY_NAME    + "," +
                            KEY_FONE    + "," +
                            KEY_FONE2   + "," +
                            KEY_EMAIL   +
                " FROM " + DATABASE_TABLE_BKP;

        database.execSQL(sql);

        sql = " DROP TABLE " + DATABASE_TABLE_BKP;

        database.execSQL(sql);

    }
}