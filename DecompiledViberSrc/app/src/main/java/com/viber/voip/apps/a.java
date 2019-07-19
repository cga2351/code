package com.viber.voip.apps;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import com.viber.provider.messages.b.d;
import com.viber.voip.ViberApplication;
import com.viber.voip.util.av;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a
{
  private static final String[] a = { "_id", "name", "package_name", "type", "store_id", "url_scheme", "status", "flags", "last_modified" };
  private static final String b = "flags & " + av.a(0, 0) + " > 0";
  private static final String c = "flags & " + av.a(0, 1) + " > 0";

  private static b a(Cursor paramCursor)
  {
    if ((paramCursor.isClosed()) || (paramCursor.isAfterLast()) || (paramCursor.isBeforeFirst()))
      return null;
    int i = paramCursor.getInt(0);
    String str1;
    int j;
    String str2;
    label70: String str3;
    label83: String str4;
    if (paramCursor.isNull(1))
    {
      str1 = null;
      j = paramCursor.getInt(3);
      if (!paramCursor.isNull(2))
        break label152;
      str2 = null;
      if (!paramCursor.isNull(4))
        break label164;
      str3 = null;
      boolean bool = paramCursor.isNull(5);
      str4 = null;
      if (!bool)
        break label176;
    }
    while (true)
    {
      return new b(i, str1, j, str2, str3, str4, paramCursor.getInt(6), paramCursor.getLong(8), paramCursor.getInt(7));
      str1 = paramCursor.getString(1);
      break;
      label152: str2 = paramCursor.getString(2);
      break label70;
      label164: str3 = paramCursor.getString(4);
      break label83;
      label176: str4 = paramCursor.getString(5);
    }
  }

  private List<b> a(String paramString)
  {
    Cursor localCursor = a().a("applications", a, paramString, null, null, null, null);
    boolean bool = localCursor.moveToFirst();
    ArrayList localArrayList = null;
    if (bool)
    {
      localArrayList = new ArrayList(localCursor.getCount());
      do
        localArrayList.add(a(localCursor));
      while (localCursor.moveToNext());
    }
    localCursor.close();
    Log.d("AppDetails", "getApps: " + localArrayList);
    return b(localArrayList);
  }

  private <T> List<T> b(List<T> paramList)
  {
    if (paramList != null)
      return paramList;
    return Collections.emptyList();
  }

  protected com.viber.provider.b a()
  {
    return d.a(ViberApplication.getApplication());
  }

  public b a(int paramInt)
  {
    com.viber.provider.b localb = a();
    String[] arrayOfString1 = a;
    String[] arrayOfString2 = new String[1];
    arrayOfString2[0] = String.valueOf(paramInt);
    Cursor localCursor = localb.a("applications", arrayOfString1, "_id=?", arrayOfString2, null, null, null);
    boolean bool = localCursor.moveToFirst();
    b localb1 = null;
    if (bool)
      localb1 = a(localCursor);
    localCursor.close();
    Log.d("AppDetails", "getAppByAppId: " + localb1);
    return localb1;
  }

  public List<b> a(List<Integer> paramList)
  {
    return a("_id IN (" + TextUtils.join(", ", paramList) + ")");
  }

  public void a(b paramb)
  {
    ContentValues localContentValues = new ContentValues(7);
    localContentValues.put("name", paramb.c());
    localContentValues.put("package_name", paramb.f());
    localContentValues.put("type", Integer.valueOf(paramb.b()));
    localContentValues.put("store_id", paramb.d());
    localContentValues.put("url_scheme", paramb.e());
    localContentValues.put("status", Integer.valueOf(paramb.g()));
    localContentValues.put("flags", Integer.valueOf(paramb.j()));
    com.viber.provider.b localb = a();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramb.a());
    if (localb.a("applications", localContentValues, "_id=?", arrayOfString) == 0L)
    {
      localContentValues.put("_id", Integer.valueOf(paramb.a()));
      localb.a("applications", null, localContentValues);
    }
  }

  public List<b> b()
  {
    return a(b);
  }

  public void b(b paramb)
  {
    b localb = a(paramb.a());
    if (localb != null)
    {
      localb.a(paramb);
      a(localb);
      return;
    }
    a(paramb);
  }

  public List<Integer> c()
  {
    Cursor localCursor = a().a("applications", a, null, null, null, null, null);
    boolean bool = localCursor.moveToFirst();
    ArrayList localArrayList = null;
    if (bool)
    {
      localArrayList = new ArrayList(localCursor.getCount());
      do
        localArrayList.add(Integer.valueOf(localCursor.getInt(0)));
      while (localCursor.moveToNext());
    }
    localCursor.close();
    return b(localArrayList);
  }

  public void d()
  {
    a().a("applications", null, null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.apps.a
 * JD-Core Version:    0.6.2
 */