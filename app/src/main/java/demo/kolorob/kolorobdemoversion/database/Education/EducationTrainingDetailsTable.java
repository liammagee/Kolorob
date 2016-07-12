package demo.kolorob.kolorobdemoversion.database.Education;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import demo.kolorob.kolorobdemoversion.database.DatabaseHelper;
import demo.kolorob.kolorobdemoversion.database.DatabaseManager;
import demo.kolorob.kolorobdemoversion.model.Education.EducationTrainingDetailsItem;
import demo.kolorob.kolorobdemoversion.utils.Lg;

/**
 * Created by israt.jahan on 6/27/2016.
 */
public class EducationTrainingDetailsTable {
    private static final String TAG = EducationTrainingDetailsTable.class.getSimpleName();
    private static final String TABLE_NAME = DatabaseHelper.EDU_TRAINING_TABLE;
    private static final String KEY_NODE_ID = "_eduId";
    private static final String KEY_COURSE_DURATION = "_courseduration"; // 1 - text
    private static final String KEY_AD_MONTH= "_admissionmonth"; //
    private static final String KEY_AD_COST = "_cost"; // 0 -integer
    private static final String KEY_TRAININGTYPE = "_trainingnametype"; // 1 - text
    private static final String KEY_TRAININGSUBTYPE = "_trainingnamesubtype"; //


    private Context tContext;

    public EducationTrainingDetailsTable(Context context) {
        tContext = context;
        createTable();
    }
    private void createTable() {
        SQLiteDatabase db = openDB();

        String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
                + "( "
                + KEY_NODE_ID + " INTEGER , "
                + KEY_COURSE_DURATION + "  TEXT  , " // 0 - int "
                + KEY_AD_MONTH + "  TEXT , "
                + KEY_AD_COST   + "  TEXT , "
                + KEY_TRAININGTYPE + "  TEXT  , " // 0 - int "
                + KEY_TRAININGSUBTYPE + "  TEXT , PRIMARY KEY(" + KEY_NODE_ID + "))";

        db.execSQL(CREATE_TABLE_SQL);
        closeDB();
    }
    private SQLiteDatabase openDB() {
        return DatabaseManager.getInstance(tContext).openDatabase();
    }

    private void closeDB() {
        DatabaseManager.getInstance(tContext).closeDatabase();
    }

    public long insertItem(EducationTrainingDetailsItem educationTrainingDetailsItem) {
        return insertItem(
                educationTrainingDetailsItem.getEduId(),educationTrainingDetailsItem.getCourseduration(),educationTrainingDetailsItem.getAdmissionmonth(),
                educationTrainingDetailsItem.getCost(),educationTrainingDetailsItem.getTrainingnametype(),educationTrainingDetailsItem.getTrainingnamesubtype()
        );
    }
    public long insertItem(int eduId, String courseduration, String admissionmonth, String cost, String trainingnametype, String trainingnamesubtype) {
        if (isFieldExist(eduId)) {
            return updateItem(
                    eduId,
                    courseduration,
                    admissionmonth,
                    cost,
                    trainingnametype,trainingnamesubtype);

        }
        ContentValues rowValue = new ContentValues();
        rowValue.put(KEY_NODE_ID , eduId);
        rowValue.put(KEY_COURSE_DURATION, courseduration);
        rowValue.put(KEY_AD_MONTH, admissionmonth);
        rowValue.put(KEY_AD_COST, cost);
        rowValue.put(KEY_TRAININGTYPE, trainingnametype);

        rowValue.put(KEY_TRAININGSUBTYPE , trainingnamesubtype);


        SQLiteDatabase db = openDB();
        long ret = db.insert(TABLE_NAME, null, rowValue);
        closeDB();
        return ret;}


    private long updateItem(int eduId, String courseduration, String admissionmonth, String cost, String trainingnametype, String trainingnamesubtype) {

        ContentValues rowValue = new ContentValues();
        rowValue.put(KEY_NODE_ID , eduId);
        rowValue.put(KEY_COURSE_DURATION, courseduration);
        rowValue.put(KEY_AD_MONTH, admissionmonth);
        rowValue.put(KEY_AD_COST, cost);
        rowValue.put(KEY_TRAININGTYPE, trainingnametype);

        rowValue.put(KEY_TRAININGSUBTYPE , trainingnamesubtype);



        SQLiteDatabase db = openDB();
        long ret = db.update(TABLE_NAME, rowValue, KEY_NODE_ID + " = ?  ",
                new String[]{eduId + ""});
        closeDB();
        return ret;

    }



    public boolean isFieldExist(int nodeid) {
        //Lg.d(TAG, "isFieldExist : inside, id=" + id);
        SQLiteDatabase db = openDB();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        int s=cursor.getCount();
        if (cursor.moveToFirst()) {
            do {
                if (cursor.getInt(0) == nodeid ) {
                    cursor.close();
                    closeDB();
                    return true;
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        closeDB();
        return false;
    }

    private EducationTrainingDetailsItem cursorToSubCatList(Cursor cursor) {
        int _eduId = cursor.getInt(0);
        String _courseduration= cursor.getString(1);
        String _admissionmonth = cursor.getString(2);
        String _cost = cursor.getString(3);
        String _trainingnametype = cursor.getString(4);
        String _trainingnamesubtype= cursor.getString(5);





        return new EducationTrainingDetailsItem(_eduId,
                _courseduration,_admissionmonth,_cost,_trainingnametype,_trainingnamesubtype);
    }




    public void dropTable() {
        SQLiteDatabase db = openDB();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        createTable();
        Lg.d(TAG, "Table dropped and recreated.");
        closeDB();
    }

}
