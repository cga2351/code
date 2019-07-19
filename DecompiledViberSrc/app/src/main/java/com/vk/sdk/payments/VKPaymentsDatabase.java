package com.vk.sdk.payments;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.HashSet;

class VKPaymentsDatabase extends SQLiteOpenHelper
{
  public static final String DATABASE_NAME = "vk_sdk_db";
  public static final String TABLE_PURCHASE_INFO = "vk_sdk_table_purchase_info";
  public static final String TABLE_PURCHASE_INFO_CREATE_SQL = "CREATE TABLE IF NOT EXISTS vk_sdk_table_purchase_info (purchase TEXT);";
  public static final String TABLE_PURCHASE_INFO_PURCHASE = "purchase";
  private static int VERSION = 1;
  private static VKPaymentsDatabase sInstance;

  private VKPaymentsDatabase(Context paramContext)
  {
    super(paramContext.getApplicationContext(), "vk_sdk_db", null, VERSION);
  }

  public static VKPaymentsDatabase getInstance(Context paramContext)
  {
    if (sInstance == null);
    try
    {
      if (sInstance == null)
        sInstance = new VKPaymentsDatabase(paramContext);
      return sInstance;
    }
    finally
    {
    }
  }

  public void deletePurchase(String paramString)
  {
    getWritableDatabase().delete("vk_sdk_table_purchase_info", "purchase=?", new String[] { paramString });
  }

  public HashSet<String> getPurchases()
  {
    Cursor localCursor = getReadableDatabase().query("vk_sdk_table_purchase_info", new String[] { "purchase" }, null, null, null, null, null);
    HashSet localHashSet = new HashSet();
    if (localCursor.moveToFirst())
      do
        localHashSet.add(localCursor.getString(0));
      while (localCursor.moveToNext());
    localCursor.close();
    return localHashSet;
  }

  public void insertPurchase(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("purchase", paramString);
    localSQLiteDatabase.insert("vk_sdk_table_purchase_info", "purchase", localContentValues);
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS vk_sdk_table_purchase_info (purchase TEXT);");
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.payments.VKPaymentsDatabase
 * JD-Core Version:    0.6.2
 */