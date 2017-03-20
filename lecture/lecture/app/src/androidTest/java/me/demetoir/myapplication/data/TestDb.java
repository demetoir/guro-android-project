package me.demetoir.myapplication.data;

/**
 * Created by yujun on 2017-01-24.
 */

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import java.util.HashSet;

public class TestDb extends AndroidTestCase {

    public static final String LOG_TAG = TestDb.class.getSimpleName();

    void deleteTheDatabase() {
        mContext.deleteDatabase(WeatherDbHelper.DATABASE_NAME);
    }

    public void setUp() {
        deleteTheDatabase();
    }

    public void testCreateDb() throws Throwable {
        final HashSet<String> tableNameHashSet = new HashSet<String>();
        tableNameHashSet.add(WeatherContract.LocationEntry.TABLE_NAME);
        tableNameHashSet.add(WeatherContract.WeatherEntry.TABLE_NAME);

        mContext.deleteDatabase(WeatherDbHelper.DATABASE_NAME);
        SQLiteDatabase db = new WeatherDbHelper(
                this.mContext).getWritableDatabase();
        assertEquals(true, db.isOpen());

        Cursor c = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);

        assertTrue("Error: This means that the database has not been created correctly",
                c.moveToFirst());

        do {
            tableNameHashSet.remove(c.getString(0));
        } while (c.moveToNext());

        assertTrue("Error: Your database was created without both the location entry and weather entry tables",
                tableNameHashSet.isEmpty());

        c = db.rawQuery("PRAGMA table_info(" + WeatherContract.LocationEntry.TABLE_NAME + ")",
                null);

        assertTrue("Error: This means that we were unable to query the database for table information.",
                c.moveToFirst());

        final HashSet<String> locationColumnHashSet = new HashSet<String>();
        locationColumnHashSet.add(WeatherContract.LocationEntry._ID);
        locationColumnHashSet.add(WeatherContract.LocationEntry.COLUMN_CITY_NAME);
        locationColumnHashSet.add(WeatherContract.LocationEntry.COLUMN_COORD_LAT);
        locationColumnHashSet.add(WeatherContract.LocationEntry.COLUMN_COORD_LONG);
        locationColumnHashSet.add(WeatherContract.LocationEntry.COLUMN_LOCATION_SETTING);

        int columnNameIndex = c.getColumnIndex("name");
        do {
            String columnName = c.getString(columnNameIndex);
            locationColumnHashSet.remove(columnName);
        } while (c.moveToNext());

        assertTrue("Error: The database doesn't contain all of the required location entry columns",
                locationColumnHashSet.isEmpty());
        db.close();
    }

    //여기 다시 코드 써보면서 정리하기
    public void testLocationTable() {
        //insert
        WeatherDbHelper dbHelper = new WeatherDbHelper(mContext);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = TestUtilities.createNorthPoleLocationValues();

        long locationRowId;
        locationRowId = db.insert(
                WeatherContract.LocationEntry.TABLE_NAME, //table name
                null,  // ??
                contentValues); //ContentValues

        //insert validation Verify we got a row back.
        assertTrue("Error: Failure to insert North Pole Location Values", locationRowId != -1);

        //db write로 열었으니 따로 read로 만들필요없음...
        //raw query를 안쓰는게 좋음 공격에 취약함 보안병신 쓰지마 쓰지마
        //7개짜리 로 보통 많이 함 문서봐
        Cursor cursor = db.query(
                WeatherContract.LocationEntry.TABLE_NAME, //table name
                null, //leaving columns null just return all the columns
                null, //where 조건 (selection)
                null, //(selectionArgs)
                null, //groupBy
                null, //having
                null);//orderBy

        //데이터가 안들어갔는지 확인
        assertTrue("error : no record", cursor.moveToFirst());

        //넣은값으로 들어갔는지 검사한다
        TestUtilities.validateCurrentRecord("error", cursor, contentValues);

        //하나만 넣었으니 다음으로 넘어가지 말아야한다
        assertFalse("error :", cursor.moveToNext());

        cursor.close();
        db.close();
    }

    public void testWeatherTable() {
        //insertLocation 로 이용한다
        //locationLocation하고 전에했던거는 지워지니까
        //이거가지고 유틸에 있는 거가지고 만들어본다

        //make db
        WeatherDbHelper dbHelper = new WeatherDbHelper(mContext);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        //insert
        long locationRowId = insertLocation();
        assertTrue("error : insert location fail", locationRowId != -1);

        ContentValues weather = TestUtilities.createWeatherValues(locationRowId);
        long weatherRowId = db.insert(
                WeatherContract.WeatherEntry.TABLE_NAME,
                null,
                weather);

        //insert validation
        assertTrue("error : insert fail in weather table ", weatherRowId != -1);

        //query
        Cursor cursor = db.query(
                WeatherContract.WeatherEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null);

        //리턴값이 있는지 들어간게 없다
        assertTrue("error cursor return nothing", cursor.moveToFirst());

        //query validation 여기 잘못됨
        TestUtilities.validateCurrentRecord("error : cursor invalidate", cursor, weather);

        //하나만 넣었으니 다음으로 넘어가지 말아야한다 여러개 가 들어가면 안됨
        assertFalse("error : data inserted more than one ", cursor.moveToNext());

        db.close();
    }

    public long insertLocation() {
//        ContentValues location = TestUtilities.createNorthPoleLocationValues();
//        long locationRowId  = db.insert(
//                WeatherContract.LocationEntry.TABLE_NAME,
//                null,
//                location);
//
//        assertTrue("error: insert fail at location table", locationRowId != -1);
//
//        //여기서도 쿼리 테스트
//
//        return locationRowId;

        SQLiteDatabase db = new WeatherDbHelper(mContext).getWritableDatabase();
        ContentValues contentValues = TestUtilities.createNorthPoleLocationValues();

        long locationRowId;
        locationRowId = db.insert(
                WeatherContract.LocationEntry.TABLE_NAME, //table name
                null,  // ??
                contentValues); //ContentValues

        //insert validation
        // Verify we got a row back.
        assertTrue("Error: Failure to insert North Pole Location Values", locationRowId != -1);

        //db write로 열었으니 따로 read로 만들필요없음...
        //raw query를 안쓰는게 좋음 공격에 취약함 보안병신 쓰지마 쓰지마
        //7개짜리 로 보통 많이 함
        Cursor cursor = db.query(
                WeatherContract.LocationEntry.TABLE_NAME, //table name
                null, //leaving columns null just return all the columns
                null, //where 조건
                null, //
                null,
                null,
                null);//

        //데이터가 안들어갔는지 확인
        assertTrue("error : no record", cursor.moveToFirst());

        //넣은값으로 들어갔는지 검사한다
        TestUtilities.validateCurrentRecord("error", cursor, contentValues);

        //하나만 넣었으니 다음으로 넘어가지 말아야한다
        assertFalse("error :", cursor.moveToNext());

        cursor.close();
        db.close();
        return locationRowId;
    }
}