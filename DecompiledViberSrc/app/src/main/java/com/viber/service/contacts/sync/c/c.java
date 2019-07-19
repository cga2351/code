package com.viber.service.contacts.sync.c;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.Data;
import com.viber.provider.a;
import com.viber.voip.util.af;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class c
  implements b
{
  public void a(Context paramContext, a parama, long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    d locald = new d(paramContext, paramLong2, true, parama);
    if (("vnd.android.cursor.item/vnd.com.viber.voip.viber_number_call".equals(paramString1)) || ("vnd.android.cursor.item/vnd.com.viber.voip.viber_number_message".equals(paramString1)) || ("vnd.android.cursor.item/vnd.com.viber.voip.viber_out_call_viber".equals(paramString1)) || ("vnd.android.cursor.item/vnd.com.viber.voip.google_voice_message".equals(paramString1)))
    {
      locald.c(paramLong1);
      if ("vnd.android.cursor.item/vnd.com.viber.voip.viber_number_call".equals(paramString1))
        b(locald, paramString2);
    }
    while (!"vnd.android.cursor.item/vnd.com.viber.voip.viber_out_call_none_viber".equals(paramString1))
      return;
    locald.c(paramLong1);
    a(locald, paramString2);
    d(locald, paramString2);
  }

  public void a(Context paramContext, a parama, long paramLong, String paramString1, String paramString2, Set<String> paramSet1, Set<String> paramSet2)
  {
    d locald = new d(paramContext, paramLong, true, parama);
    locald.b(paramString2);
    ContentResolver localContentResolver = paramContext.getContentResolver();
    Uri localUri = a.a;
    String[] arrayOfString1 = a.b;
    String[] arrayOfString2 = new String[1];
    arrayOfString2[0] = String.valueOf(paramLong);
    Cursor localCursor = localContentResolver.query(localUri, arrayOfString1, "raw_contact_id=?", arrayOfString2, null);
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    if (localCursor != null);
    while (true)
    {
      long l;
      String str3;
      String str4;
      try
      {
        if (localCursor.moveToFirst())
        {
          l = localCursor.getLong(0);
          str3 = localCursor.getString(1);
          str4 = localCursor.getString(2);
          if ("vnd.android.cursor.item/name".equals(str3))
          {
            if (!paramString1.equals(str4))
              locald.a(l, paramString1);
            boolean bool = localCursor.moveToNext();
            if (bool)
              continue;
          }
        }
        else
        {
          af.a(localCursor);
          Iterator localIterator1 = paramSet1.iterator();
          if (!localIterator1.hasNext())
            break;
          String str2 = (String)localIterator1.next();
          if (!localHashSet1.contains(str2))
          {
            a(locald, str2);
            d(locald, str2);
          }
          if (localHashSet2.contains(str2))
            continue;
          c(locald, str2);
          continue;
        }
        if (!"vnd.android.cursor.item/phone_v2".equals(str3))
          break label328;
        if ((!paramSet1.contains(str4)) && (!paramSet2.contains(str4)))
        {
          locald.c(l);
          continue;
        }
      }
      finally
      {
        af.a(localCursor);
      }
      localHashSet2.add(str4);
      continue;
      label328: if (("vnd.android.cursor.item/vnd.com.viber.voip.viber_number_call".equals(str3)) || ("vnd.android.cursor.item/vnd.com.viber.voip.viber_number_message".equals(str3)) || ("vnd.android.cursor.item/vnd.com.viber.voip.viber_out_call_viber".equals(str3)))
      {
        if (!paramSet1.contains(str4))
          locald.c(l);
        else
          localHashSet1.add(str4);
      }
      else if ("vnd.android.cursor.item/vnd.com.viber.voip.viber_out_call_none_viber".equals(str3))
      {
        if (!paramSet2.contains(str4))
          locald.c(l);
        else
          localHashSet1.add(str4);
      }
      else if ("vnd.android.cursor.item/vnd.com.viber.voip.google_voice_message".equals(str3))
        if (!paramSet1.contains(str4))
          locald.c(l);
        else
          localHashSet1.add(str4);
    }
    Iterator localIterator2 = paramSet2.iterator();
    while (localIterator2.hasNext())
    {
      String str1 = (String)localIterator2.next();
      if (!localHashSet1.contains(str1))
        b(locald, str1);
      if (!localHashSet2.contains(str1))
        c(locald, str1);
    }
  }

  public void a(Context paramContext, a parama, long paramLong1, String paramString1, String paramString2, Set<String> paramSet1, Set<String> paramSet2, long paramLong2, String paramString3)
  {
    d locald = d.a(paramContext, paramLong1, paramString3, paramString2, true, parama);
    locald.a(paramString1);
    a(locald, paramLong1);
    if (paramLong2 != 0L)
      locald.a(paramLong2);
    Iterator localIterator1 = paramSet1.iterator();
    while (localIterator1.hasNext())
    {
      String str2 = (String)localIterator1.next();
      a(locald, str2);
      c(locald, str2);
      d(locald, str2);
    }
    Iterator localIterator2 = paramSet2.iterator();
    while (localIterator2.hasNext())
    {
      String str1 = (String)localIterator2.next();
      b(locald, str1);
      c(locald, str1);
    }
  }

  protected abstract void a(d paramd, long paramLong);

  protected abstract void a(d paramd, String paramString);

  protected abstract void b(d paramd, String paramString);

  protected abstract void c(d paramd, String paramString);

  protected abstract void d(d paramd, String paramString);

  private static abstract interface a
  {
    public static final Uri a = ContactsContract.Data.CONTENT_URI;
    public static final String[] b = { "_id", "mimetype", "data1" };
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.service.contacts.sync.c.c
 * JD-Core Version:    0.6.2
 */