package com.viber.voip.block;

import android.content.ContentValues;
import android.database.Cursor;
import com.viber.provider.b;
import com.viber.provider.messages.b.d;
import com.viber.voip.ViberApplication;
import com.viber.voip.util.af;
import com.viber.voip.util.da;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a
{
  private void a(int paramInt1, Object paramObject1, Object paramObject2, int paramInt2)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramObject1);
    ContentValues localContentValues = new ContentValues(3);
    localContentValues.put("seq", Integer.valueOf(paramInt2));
    localContentValues.put("status", Integer.valueOf(2));
    if (1 == paramInt1)
      localContentValues.put("data_3", String.valueOf(paramObject2));
    c().a("blocked_data", localContentValues, "data_1=?", arrayOfString);
  }

  private void a(int paramInt1, Object paramObject1, Object paramObject2, Object paramObject3, int paramInt2)
  {
    ContentValues localContentValues = new ContentValues(5);
    localContentValues.put("type", Integer.valueOf(paramInt1));
    if (paramInt1 == 0)
    {
      localContentValues.put("data_1", String.valueOf(paramObject1));
      localContentValues.put("data_2", (String)paramObject2);
      localContentValues.put("data_3", (String)paramObject3);
    }
    while (true)
    {
      localContentValues.put("seq", Integer.valueOf(paramInt2));
      c().a("blocked_data", null, localContentValues);
      return;
      if (1 == paramInt1)
      {
        localContentValues.put("data_1", String.valueOf(paramObject1));
        localContentValues.put("data_2", (String)paramObject2);
        localContentValues.put("data_3", String.valueOf(paramObject3));
      }
    }
  }

  private boolean a(Object paramObject)
  {
    String[] arrayOfString = new String[3];
    arrayOfString[0] = String.valueOf(paramObject);
    arrayOfString[1] = String.valueOf(1);
    arrayOfString[2] = String.valueOf(2);
    Cursor localCursor = c().a("blocked_data", null, "data_1=? AND (status=? OR status=?)", arrayOfString, null, null, null);
    if (localCursor != null)
    {
      boolean bool = localCursor.moveToFirst();
      localCursor.close();
      return bool;
    }
    return false;
  }

  private b c()
  {
    return d.a(ViberApplication.getApplication());
  }

  public b a(int paramInt)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramInt);
    Cursor localCursor = c().a("blocked_data", null, "seq=?", arrayOfString, null, null, null);
    Object localObject1 = null;
    int i;
    int j;
    Object localObject2;
    if (localCursor != null)
    {
      boolean bool = localCursor.moveToFirst();
      localObject1 = null;
      if (bool)
      {
        i = localCursor.getInt(localCursor.getColumnIndex("type"));
        j = localCursor.getInt(localCursor.getColumnIndex("status"));
        if (j != 0)
          break label258;
        ContentValues localContentValues = new ContentValues(1);
        localContentValues.put("status", Integer.valueOf(1));
        c().a("blocked_data", localContentValues, "seq=?", arrayOfString);
        if (i != 0)
          break label205;
        localObject2 = new c(Long.valueOf(localCursor.getString(localCursor.getColumnIndex("data_1"))).longValue(), localCursor.getString(localCursor.getColumnIndex("data_2")), localCursor.getString(localCursor.getColumnIndex("data_3")), true);
      }
    }
    while (true)
    {
      localObject1 = localObject2;
      while (true)
      {
        localCursor.close();
        return localObject1;
        label205: if (1 != i)
          break label404;
        localObject2 = new a(Integer.valueOf(localCursor.getString(localCursor.getColumnIndex("data_1"))).intValue(), localCursor.getString(localCursor.getColumnIndex("data_2")), true);
        break;
        label258: localObject1 = null;
        if (2 == j)
        {
          c().a("blocked_data", "seq=?", arrayOfString);
          if (i == 0)
          {
            localObject1 = new c(Long.valueOf(localCursor.getString(localCursor.getColumnIndex("data_1"))).longValue(), localCursor.getString(localCursor.getColumnIndex("data_2")), localCursor.getString(localCursor.getColumnIndex("data_3")), false);
          }
          else
          {
            localObject1 = null;
            if (1 == i)
              localObject1 = new a(Integer.valueOf(localCursor.getString(localCursor.getColumnIndex("data_1"))).intValue(), localCursor.getString(localCursor.getColumnIndex("data_2")), false);
          }
        }
      }
      label404: localObject2 = null;
    }
  }

  public void a()
  {
    c().a("blocked_data", null, null);
  }

  public void a(int paramInt1, int paramInt2)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = Integer.toString(paramInt2);
    arrayOfString[1] = Integer.toString(paramInt1);
    ContentValues localContentValues = new ContentValues(3);
    localContentValues.put("seq", Integer.valueOf(0));
    localContentValues.put("data_3", Integer.toString(0));
    localContentValues.put("status", Integer.toString(1));
    c().a("blocked_data", localContentValues, "type=1 AND seq=? AND data_1= ?", arrayOfString);
  }

  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    a(1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramInt3);
  }

  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    a(1, Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), paramInt3);
  }

  public void a(long paramLong, int paramInt)
  {
    a(0, Long.valueOf(paramLong), null, paramInt);
  }

  public void a(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    a(0, Long.valueOf(paramLong), paramString1, paramString2, paramInt);
  }

  public boolean a(long paramLong)
  {
    return a(Long.valueOf(paramLong));
  }

  public List<d> b()
  {
    List localList = Collections.emptyList();
    String[] arrayOfString = new String[3];
    arrayOfString[0] = String.valueOf(1);
    arrayOfString[1] = String.valueOf(0);
    arrayOfString[2] = String.valueOf(2);
    Cursor localCursor = c().a("blocked_data", null, "type=? AND (status=? OR status=?)", arrayOfString, null, null, null);
    while (true)
    {
      try
      {
        if (af.c(localCursor))
        {
          int i = localCursor.getCount();
          if (i > 0)
          {
            localObject2 = new ArrayList(i);
            int j = localCursor.getColumnIndex("data_1");
            int k = localCursor.getColumnIndex("data_3");
            int m = localCursor.getColumnIndex("status");
            int n = Integer.valueOf(localCursor.getString(j)).intValue();
            String str;
            if (Integer.valueOf(localCursor.getString(m)).intValue() == 0)
            {
              bool1 = true;
              str = localCursor.getString(k);
              if (!da.a(str))
                continue;
              i1 = 0;
              ((List)localObject2).add(new d(n, bool1, i1));
              boolean bool2 = localCursor.moveToNext();
              if (bool2)
                continue;
              return localObject2;
            }
            boolean bool1 = false;
            continue;
            int i2 = Integer.valueOf(str).intValue();
            int i1 = i2;
            continue;
          }
        }
      }
      finally
      {
        af.a(localCursor);
      }
      Object localObject2 = localList;
    }
  }

  public void b(int paramInt1, int paramInt2)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = Integer.toString(paramInt1);
    arrayOfString[1] = Integer.toString(paramInt2);
    c().a("blocked_data", "type=1 AND seq=? AND data_1= ?", arrayOfString);
  }

  public boolean b(int paramInt)
  {
    return a(Integer.valueOf(paramInt));
  }

  public static class a extends a.b
  {
    public int a;
    public String b;

    public a(int paramInt, String paramString, boolean paramBoolean)
    {
      super();
      this.a = paramInt;
      this.b = paramString;
    }
  }

  public static class b
  {
    public boolean c;

    public b(boolean paramBoolean)
    {
      this.c = paramBoolean;
    }
  }

  public static class c extends a.b
  {
    public long a;
    public String b;
    public String d;

    public c(long paramLong, String paramString1, String paramString2, boolean paramBoolean)
    {
      super();
      this.a = paramLong;
      this.b = paramString1;
      this.d = paramString2;
    }
  }

  public static final class d
  {
    public final int a;
    public final boolean b;
    public final int c;

    public d(int paramInt1, boolean paramBoolean, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramBoolean;
      this.c = paramInt2;
    }

    public String toString()
    {
      return "NotSyncedAppBlocks{appId=" + this.a + ", isBlocked=" + this.b + ", sourceFlag=" + this.c + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.block.a
 * JD-Core Version:    0.6.2
 */