package demo.kolorob.kolorobdemoversion.database.Health;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import demo.kolorob.kolorobdemoversion.database.DatabaseHelper;
import demo.kolorob.kolorobdemoversion.database.DatabaseManager;
import demo.kolorob.kolorobdemoversion.model.Health.HealthPharmacyItem;

/**
 * Created by Mazhaul Islam on 4/2/2016.
 */
public class HealthPharmacyTable {

    private static final String TAG = HealthPharmacyTable.class.getSimpleName();
    private static final String TABLE_NAME = DatabaseHelper.HEALTH_PHARMACY_TABLE;

    private static final String KEY_NODE_ID = "_node_id"; // 0 -integer
    private static final String KEY_DOC_ID = "_doc_id"; // 1 - text
    private static final String KEY_PHARMACY_FEE = "_pharmacy_fee"; // 2 - text*/
    private static final String KEY_DOCTOR_NAME = "_pharmacy_doctorName";
    private static final String KEY_PHARMACY_TIME = "_pharmacy_time"; //
    private static final String KEY_PHARMACY_NO_DEGREE = "_pharmacy_no_degree"; //
    private static final String KEY_PHARMACY_LMAF = "_pharmacy_LMAF"; //
    private static final String KEY_PHARMACY_MBBS = "_pharmacy_MBBS"; //

    private static final String KEY_PHARMACY_SPECILIST = "_pharmacy_specialist"; //
    private static final String KEY_PHARMACY_REMARKS = "_remarks"; //
    private static final String KEY_PHARMACY_DOC_REMARKS = "_pharmacy_doc_remarks"; //

    private static final String KEY_REF_NUM = "_ref_number"; //



    private Context tContext;


    public HealthPharmacyTable(Context context) {
        tContext = context;
        createTable();
    }

    private void createTable() {
        SQLiteDatabase db = openDB();

        String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
                + "( "
                + KEY_NODE_ID + "  INTEGER, " // 0 - int
                + KEY_DOC_ID + "  INTEGER, "              // 1 - text
                + KEY_PHARMACY_FEE + " INTEGER, "
                + KEY_DOCTOR_NAME + " TEXT, "// 2 - text
                + KEY_PHARMACY_TIME + " TEXT, "
                + KEY_PHARMACY_NO_DEGREE + " TEXT, "
                + KEY_PHARMACY_LMAF + " TEXT, "
                + KEY_PHARMACY_MBBS + " TEXT, "

                + KEY_PHARMACY_SPECILIST + " TEXT, "
                + KEY_PHARMACY_REMARKS + " TEXT, "
                + KEY_PHARMACY_DOC_REMARKS + " TEXT, "

                + KEY_REF_NUM + " INTEGER, PRIMARY KEY(" + KEY_NODE_ID + ", " + KEY_DOC_ID + "," + KEY_REF_NUM + "))";

        db.execSQL(CREATE_TABLE_SQL);
        closeDB();
    }

    private SQLiteDatabase openDB() {
        return DatabaseManager.getInstance(tContext).openDatabase();
    }

    private void closeDB() {
        DatabaseManager.getInstance(tContext).closeDatabase();
    }


    public long insertItemHealthPharmacy(HealthPharmacyItem healthPharmacyItem) {
        return insertItemHealthPharmacy(
                healthPharmacyItem.getNodeId(),
                healthPharmacyItem.getDocId(),
                healthPharmacyItem.getPharmacyFee(),
                healthPharmacyItem.getPharmacyDoctorName(),
                healthPharmacyItem.getPharmacyTime(),
                healthPharmacyItem.getPharmacyNoDegree(),
                healthPharmacyItem.getPharmacyLMAF(),
                healthPharmacyItem.getPharmacyMBBS(),

                healthPharmacyItem.getPharmacySpecialist(),
                healthPharmacyItem.getRemarks(),
                healthPharmacyItem.getpharmacyDocRemarks(),

                healthPharmacyItem.getRefNumber()

        );
    }

    public long insertItemHealthPharmacy(
            String nodeId,
            int docId,
            int pharmacyFee,
            String pharmacyDoctorName,
            String pharmacyTime,
            String pharmacyNoDegree,
            String pharmacyLMAF,
            String pharmacyMBBS,

            String pharmacySpecialist,
            String remarks,
            String pharmacyDocRemarks,

            int refNumber
    ) {
        if (isFieldExist(nodeId,docId, refNumber)) {
            return updateItem(
                    nodeId,
                    docId,
                    pharmacyFee,
                    pharmacyDoctorName,
                    pharmacyTime,
                    pharmacyNoDegree,
                    pharmacyLMAF,
                    pharmacyMBBS,
                    pharmacySpecialist,
                    remarks,
                    pharmacyDocRemarks,
                    refNumber);
        }

        ContentValues rowValue = new ContentValues();
        rowValue.put(KEY_NODE_ID , nodeId);
        rowValue.put(KEY_DOC_ID  , docId);
        rowValue.put(KEY_PHARMACY_FEE   , pharmacyFee);
        rowValue.put(KEY_DOCTOR_NAME , pharmacyDoctorName );
        rowValue.put(KEY_PHARMACY_TIME  , pharmacyTime );
        rowValue.put(KEY_PHARMACY_NO_DEGREE  ,pharmacyNoDegree  );
        rowValue.put(KEY_PHARMACY_LMAF   , pharmacyLMAF );
        rowValue.put(KEY_PHARMACY_MBBS   , pharmacyMBBS );
        rowValue.put(KEY_PHARMACY_SPECILIST  , pharmacySpecialist );
        rowValue.put(KEY_PHARMACY_REMARKS ,remarks );
        rowValue.put(KEY_PHARMACY_DOC_REMARKS ,pharmacyDocRemarks );
        rowValue.put(KEY_REF_NUM , refNumber );



        SQLiteDatabase db = openDB();
        long ret = db.insert(TABLE_NAME, null, rowValue);
        closeDB();
        return ret;
    }

    public boolean isFieldExist(String id,int doc_id,int refnum) {
        //Lg.d(TAG, "isFieldExist : inside, id=" + id);
        SQLiteDatabase db = openDB();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (cursor.moveToFirst()) {
            do {
                if (id.equals(cursor.getString(0))&&Integer.parseInt(cursor.getString(1))==doc_id&&Integer.parseInt(cursor.getString(11))==refnum) {
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

    private long updateItem(String nodeId,
                            int docId,
                            int pharmacyFee,
                            String pharmacyDoctorName,
                            String pharmacyTime,
                            String pharmacyNoDegree,
                            String pharmacyLMAF,
                            String pharmacyMBBS,

                            String pharmacySpecialist,
                            String remarks,
                            String pharmacyDocRemarks,

                            int refNumber)
                             {
        ContentValues rowValue = new ContentValues();
        rowValue.put(KEY_NODE_ID , nodeId);
        rowValue.put(KEY_DOC_ID  , docId);
        rowValue.put(KEY_PHARMACY_FEE   , pharmacyFee);
        rowValue.put(KEY_DOCTOR_NAME , pharmacyDoctorName );
        rowValue.put(KEY_PHARMACY_TIME  , pharmacyTime );
        rowValue.put(KEY_PHARMACY_NO_DEGREE  ,pharmacyNoDegree  );
        rowValue.put(KEY_PHARMACY_LMAF   , pharmacyLMAF );

                                 rowValue.put(KEY_PHARMACY_MBBS  , pharmacyMBBS );
        rowValue.put(KEY_PHARMACY_SPECILIST  , pharmacySpecialist );
        rowValue.put(KEY_PHARMACY_REMARKS ,remarks );
                                 rowValue.put(KEY_PHARMACY_DOC_REMARKS ,pharmacyDocRemarks );
        rowValue.put(KEY_REF_NUM , refNumber );


        SQLiteDatabase db = openDB();
                                 long ret = db.update(TABLE_NAME, rowValue, KEY_NODE_ID + " = ? AND" + KEY_DOC_ID + " = ? AND " + KEY_REF_NUM + " = ?",
                                         new String[]{nodeId + "", docId + "", refNumber + ""});
        closeDB();
        return ret;
    }





    public ArrayList<HealthPharmacyItem> getSpecialistforNode(String nodeId) {
        ArrayList<HealthPharmacyItem> specialistList = new ArrayList<>();
        //System.out.println(cat_id+"  "+sub_cat_id);
        SQLiteDatabase db = openDB();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                //System.out.println("abc="+cursor.getString(4));
                specialistList.add(healthPharmacyItem(cursor));
            } while (cursor.moveToNext());
        }
        cursor.close();
        closeDB();
        return specialistList;
    }



    private HealthPharmacyItem healthPharmacyItem(Cursor cursor) {
        String _nodeId=cursor.getString(0);
        int _docId=cursor.getInt(1);
        int _pharmacyFee=cursor.getInt(2);
        String _pharmacyDoctorName=cursor.getString(3);
        String _pharmacyTime=cursor.getString(4);
        String _pharmacyNoDegree=cursor.getString(5);
        String _pharmacyLMAF=cursor.getString(6);
        String _pharmacyMBBS=cursor.getString(7);
        String _pharmacySpecialist=cursor.getString(8);
        String _remarks=cursor.getString(9);
        String _pharmacyDocRemarks=cursor.getString(10);
        int _refNumber=cursor.getInt(11);




        return new HealthPharmacyItem(
                _nodeId,
                _docId,
                _pharmacyFee,
                _pharmacyDoctorName,
                _pharmacyTime,
                _pharmacyNoDegree,
                _pharmacyLMAF,
                _pharmacyMBBS,

                _pharmacySpecialist,
                _remarks,
                _pharmacyDocRemarks,

                _refNumber);
    }

}