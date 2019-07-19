package a.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.appboy.f.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class db
  implements cy
{
  private static final String a = c.a(db.class);
  private static final String[] b = { "session_id", "user_id", "event_type", "event_data", "event_guid", "timestamp" };
  private SQLiteDatabase c;
  private boolean d = false;
  private final cr e;

  public db(cr paramcr)
  {
    this.e = paramcr;
  }

  private Collection<be> a(Cursor paramCursor)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramCursor.getColumnIndex("session_id");
    int j = paramCursor.getColumnIndex("user_id");
    int k = paramCursor.getColumnIndex("event_type");
    int m = paramCursor.getColumnIndex("event_data");
    int n = paramCursor.getColumnIndex("event_guid");
    int i1 = paramCursor.getColumnIndex("timestamp");
    while (paramCursor.moveToNext())
    {
      String str1 = paramCursor.getString(k);
      String str2 = paramCursor.getString(m);
      double d1 = paramCursor.getDouble(i1);
      String str3 = paramCursor.getString(n);
      String str4 = paramCursor.getString(j);
      String str5 = paramCursor.getString(i);
      try
      {
        localArrayList.add(bp.a(str1, str2, d1, str3, str4, str5));
      }
      catch (JSONException localJSONException)
      {
        c.e(a, "Could not create AppboyEvent from [type=" + str1 + ", data=" + str2 + ", timestamp=" + d1 + ", uniqueId=" + str3 + ", userId=" + str4 + ", sessionId=" + str5 + "] ... Skipping");
      }
    }
    return localArrayList;
  }

  private ContentValues b(be parambe)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("event_type", parambe.b().a());
    localContentValues.put("event_data", parambe.c().toString());
    localContentValues.put("timestamp", Double.valueOf(parambe.a()));
    if (parambe.g() != null)
      localContentValues.put("session_id", parambe.g().toString());
    if (parambe.f() != null)
      localContentValues.put("user_id", parambe.f());
    if (parambe.d() != null)
      localContentValues.put("event_guid", parambe.d());
    return localContentValues;
  }

  public Collection<be> a()
  {
    Cursor localCursor = null;
    Object localObject2;
    if (this.d)
    {
      c.d(a, "Storage provider is closed. Not getting all events.");
      localObject2 = null;
    }
    while (true)
    {
      return localObject2;
      try
      {
        localCursor = c().query("ab_events", b, null, null, null, null, null);
        Collection localCollection = a(localCursor);
        localObject2 = localCollection;
        return localObject2;
      }
      finally
      {
        if (localCursor != null)
          localCursor.close();
      }
    }
  }

  public void a(be parambe)
  {
    if (this.d)
      c.d(a, "Storage provider is closed. Not adding event: " + parambe);
    ContentValues localContentValues;
    do
    {
      return;
      localContentValues = b(parambe);
    }
    while (c().insert("ab_events", null, localContentValues) != -1L);
    c.d(a, "Failed to add event [" + parambe.toString() + "] to storage");
  }

  public void a(List<be> paramList)
  {
    throw new UnsupportedOperationException("Batch SQL event add is not supported");
  }

  public void b()
  {
    c.d(a, "Closing SQL database and setting this provider to closed.");
    this.d = true;
    c().close();
  }

  public void b(List<be> paramList)
  {
    if (this.d)
    {
      c.d(a, "Storage provider is closed. Not deleting events: " + paramList);
      return;
    }
    c.b(a, "Running batch deletion for SQL table.");
    c().beginTransaction();
    while (true)
    {
      int i;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder("event_guid");
        localStringBuilder.append(" in (");
        String[] arrayOfString = new String[paramList.size()];
        i = 0;
        if (i < paramList.size())
        {
          arrayOfString[i] = ((be)paramList.get(i)).d();
          localStringBuilder.append('?');
          if (i < -1 + paramList.size())
            localStringBuilder.append(',');
        }
        else
        {
          localStringBuilder.append(')');
          int j = c().delete("ab_events", localStringBuilder.toString(), arrayOfString);
          c.a(a, "Deleting events removed " + j + " row(s).", false);
          c().setTransactionSuccessful();
          return;
        }
      }
      finally
      {
        c().endTransaction();
      }
      i++;
    }
  }

  public SQLiteDatabase c()
  {
    try
    {
      if ((this.c == null) || (!this.c.isOpen()))
        this.c = this.e.getWritableDatabase();
      SQLiteDatabase localSQLiteDatabase = this.c;
      return localSQLiteDatabase;
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.db
 * JD-Core Version:    0.6.2
 */