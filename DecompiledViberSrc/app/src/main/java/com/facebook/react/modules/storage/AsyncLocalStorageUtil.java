package com.facebook.react.modules.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.facebook.react.bridge.ReadableArray;
import java.util.Arrays;
import java.util.Iterator;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class AsyncLocalStorageUtil
{
  static String buildKeySelection(int paramInt)
  {
    String[] arrayOfString = new String[paramInt];
    Arrays.fill(arrayOfString, "?");
    return "key IN (" + TextUtils.join(", ", arrayOfString) + ")";
  }

  static String[] buildKeySelectionArgs(ReadableArray paramReadableArray, int paramInt1, int paramInt2)
  {
    String[] arrayOfString = new String[paramInt2];
    for (int i = 0; i < paramInt2; i++)
      arrayOfString[i] = paramReadableArray.getString(paramInt1 + i);
    return arrayOfString;
  }

  private static void deepMergeInto(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
    throws JSONException
  {
    Iterator localIterator = paramJSONObject2.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      JSONObject localJSONObject1 = paramJSONObject2.optJSONObject(str);
      JSONObject localJSONObject2 = paramJSONObject1.optJSONObject(str);
      if ((localJSONObject1 != null) && (localJSONObject2 != null))
      {
        deepMergeInto(localJSONObject2, localJSONObject1);
        paramJSONObject1.put(str, localJSONObject2);
      }
      else
      {
        paramJSONObject1.put(str, paramJSONObject2.get(str));
      }
    }
  }

  @Nullable
  public static String getItemImpl(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    Cursor localCursor = paramSQLiteDatabase.query("catalystLocalStorage", new String[] { "value" }, "key=?", new String[] { paramString }, null, null, null);
    try
    {
      boolean bool = localCursor.moveToFirst();
      if (!bool)
        return null;
      String str = localCursor.getString(0);
      return str;
    }
    finally
    {
      localCursor.close();
    }
  }

  static boolean mergeImpl(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
    throws JSONException
  {
    String str = getItemImpl(paramSQLiteDatabase, paramString1);
    if (str == null);
    while (true)
    {
      return setItemImpl(paramSQLiteDatabase, paramString1, paramString2);
      JSONObject localJSONObject = new JSONObject(str);
      deepMergeInto(localJSONObject, new JSONObject(paramString2));
      paramString2 = localJSONObject.toString();
    }
  }

  static boolean setItemImpl(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("key", paramString1);
    localContentValues.put("value", paramString2);
    return -1L != paramSQLiteDatabase.insertWithOnConflict("catalystLocalStorage", null, localContentValues, 5);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.storage.AsyncLocalStorageUtil
 * JD-Core Version:    0.6.2
 */