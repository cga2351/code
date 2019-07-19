package com.viber.voip.contacts.c.f.a.a;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentProviderResult;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.text.TextUtils;
import com.viber.common.b.d;
import com.viber.provider.contacts.a.c;
import com.viber.provider.contacts.a.e;
import com.viber.service.contacts.a.a;
import com.viber.voip.messages.d.c;
import com.viber.voip.settings.d.ak;
import com.viber.voip.util.af;
import com.viber.voip.util.bq;
import com.viber.voip.util.bq.a;
import com.viber.voip.util.bq.g;
import java.util.ArrayList;
import java.util.List;

public class b
{
  private static final String[] a = { "_id", "photo_id" };
  private static final String[] b = { "_id", "low_display_name" };
  private static final String[] c = { "_id", "data2", "data3" };
  private boolean d;
  private int e;
  private int f;
  private Context g;
  private bq h;

  public b(Context paramContext)
  {
    this.g = paramContext;
    this.h = com.viber.voip.contacts.c.e.b.a(this.g);
    this.d = d.ak.a.d();
    this.e = d.ak.b.d();
    this.f = d.ak.c.d();
  }

  private void a(final int paramInt, final b paramb)
  {
    a local1 = new a()
    {
      public void a()
      {
        b.a(b.this, 1 + paramInt, paramb);
      }
    };
    if (paramInt > this.f)
    {
      b(paramb);
      return;
    }
    if (paramInt == 39)
    {
      a(local1);
      return;
    }
    if (paramInt == 43)
    {
      c(local1);
      return;
    }
    if (paramInt == 49)
    {
      d(local1);
      return;
    }
    if (paramInt == 52)
    {
      a.a(this.g);
      local1.a();
      return;
    }
    if (paramInt == 56)
    {
      a.b(this.g);
      local1.a();
      return;
    }
    if (paramInt == 60)
    {
      a.b(this.g);
      local1.a();
      return;
    }
    local1.a();
  }

  private void b(b paramb)
  {
    this.d = false;
    d.ak.a.e();
    d.ak.b.e();
    d.ak.c.e();
    paramb.a();
  }

  public void a(final a parama)
  {
    this.h.a(1584, null, a.c.a, b, null, null, null, new bq.g()
    {
      public void onQueryComplete(int paramAnonymousInt, Object paramAnonymousObject, Cursor paramAnonymousCursor)
      {
        ArrayList localArrayList = new ArrayList();
        String str2;
        if ((paramAnonymousCursor != null) && (paramAnonymousCursor.moveToFirst()))
        {
          int i = paramAnonymousCursor.getColumnIndex("_id");
          int j = paramAnonymousCursor.getColumnIndex("low_display_name");
          do
          {
            long l = paramAnonymousCursor.getLong(i);
            String str1 = paramAnonymousCursor.getString(j);
            ContentProviderOperation.Builder localBuilder = ContentProviderOperation.newUpdate(a.c.a);
            if (str1 == null)
              break;
            str2 = str1.toLowerCase();
            localArrayList.add(localBuilder.withValue("low_display_name", str2).withSelection("_id=" + l, null).withYieldAllowed(true).build());
          }
          while (paramAnonymousCursor.moveToNext());
          b.a(b.this).a(0, "com.viber.voip.provider.vibercontacts", null, localArrayList, new bq.a()
          {
            public void a(int paramAnonymous2Int, Object paramAnonymous2Object, List<ContentProviderOperation> paramAnonymous2List, ContentProviderResult[] paramAnonymous2ArrayOfContentProviderResult, Exception paramAnonymous2Exception)
            {
              b.this.b(b.2.this.a);
            }
          }
          , false, false);
        }
        while (true)
        {
          af.a(paramAnonymousCursor);
          return;
          str2 = null;
          break;
          b.this.b(parama);
        }
      }
    }
    , false, false);
  }

  public void a(b paramb)
  {
    a(1 + this.e, paramb);
  }

  public boolean a()
  {
    return this.d;
  }

  public void b(final a parama)
  {
    this.h.a(1584, null, ContactsContract.CommonDataKinds.Phone.CONTENT_URI, c, null, null, null, new bq.g()
    {
      public void onQueryComplete(int paramAnonymousInt, Object paramAnonymousObject, Cursor paramAnonymousCursor)
      {
        ArrayList localArrayList = new ArrayList();
        if ((paramAnonymousCursor != null) && (paramAnonymousCursor.moveToFirst()))
        {
          int i = paramAnonymousCursor.getColumnIndex("_id");
          int j = paramAnonymousCursor.getColumnIndex("data2");
          int k = paramAnonymousCursor.getColumnIndex("data3");
          do
          {
            long l = paramAnonymousCursor.getLong(i);
            String str1 = paramAnonymousCursor.getString(k);
            String str2 = paramAnonymousCursor.getString(j);
            localArrayList.add(ContentProviderOperation.newUpdate(a.e.a).withValue("data5", str1).withValue("data4", str2).withSelection("_id=" + l, null).withYieldAllowed(true).build());
          }
          while (paramAnonymousCursor.moveToNext());
          b.a(b.this).a(0, "com.viber.voip.provider.vibercontacts", null, localArrayList, new bq.a()
          {
            public void a(int paramAnonymous2Int, Object paramAnonymous2Object, List<ContentProviderOperation> paramAnonymous2List, ContentProviderResult[] paramAnonymous2ArrayOfContentProviderResult, Exception paramAnonymous2Exception)
            {
              b.3.this.a.a();
            }
          }
          , false, false);
        }
        while (true)
        {
          af.a(paramAnonymousCursor);
          return;
          parama.a();
        }
      }
    }
    , false, false);
  }

  public void c(final a parama)
  {
    this.h.a(1584, null, a.c.a, b, null, null, null, new bq.g()
    {
      public void onQueryComplete(int paramAnonymousInt, Object paramAnonymousObject, Cursor paramAnonymousCursor)
      {
        ArrayList localArrayList = new ArrayList();
        if ((paramAnonymousCursor != null) && (paramAnonymousCursor.moveToFirst()))
        {
          int i = paramAnonymousCursor.getColumnIndex("_id");
          int j = paramAnonymousCursor.getColumnIndex("low_display_name");
          do
          {
            long l = paramAnonymousCursor.getLong(i);
            String str1 = paramAnonymousCursor.getString(j);
            if ((!TextUtils.isEmpty(str1)) && (!Character.isDigit(str1.charAt(0))) && (!Character.isLetter(str1.charAt(0))))
            {
              String str2 = " " + str1;
              localArrayList.add(ContentProviderOperation.newUpdate(a.c.a).withValue("low_display_name", str2).withSelection("_id=" + l, null).withYieldAllowed(true).build());
            }
          }
          while (paramAnonymousCursor.moveToNext());
          b.a(b.this).a(0, "com.viber.voip.provider.vibercontacts", null, localArrayList, new bq.a()
          {
            public void a(int paramAnonymous2Int, Object paramAnonymous2Object, List<ContentProviderOperation> paramAnonymous2List, ContentProviderResult[] paramAnonymous2ArrayOfContentProviderResult, Exception paramAnonymous2Exception)
            {
              b.4.this.a.a();
            }
          }
          , false, false);
        }
        while (true)
        {
          af.a(paramAnonymousCursor);
          return;
          parama.a();
        }
      }
    }
    , false, false);
  }

  public void d(final a parama)
  {
    this.h.a(0, null, ContactsContract.Contacts.CONTENT_URI, a, "photo_id>0", null, null, new bq.g()
    {
      public void onQueryComplete(int paramAnonymousInt, Object paramAnonymousObject, Cursor paramAnonymousCursor)
      {
        if ((paramAnonymousCursor != null) && (paramAnonymousCursor.moveToFirst()))
        {
          int i = paramAnonymousCursor.getColumnIndex("_id");
          int j = paramAnonymousCursor.getColumnIndex("photo_id");
          ArrayList localArrayList = new ArrayList();
          do
          {
            long l1 = paramAnonymousCursor.getLong(i);
            long l2 = paramAnonymousCursor.getLong(j);
            localArrayList.add(ContentProviderOperation.newUpdate(a.c.a).withValue("native_photo_id", Long.valueOf(l2)).withSelection("_id=" + l1, null).build());
          }
          while (paramAnonymousCursor.moveToNext());
          b.a(b.this).a(0, "com.viber.voip.provider.vibercontacts", null, localArrayList, new bq.a()
          {
            public void a(int paramAnonymous2Int, Object paramAnonymous2Object, List<ContentProviderOperation> paramAnonymous2List, ContentProviderResult[] paramAnonymous2ArrayOfContentProviderResult, Exception paramAnonymous2Exception)
            {
              c.c().b();
              b.5.this.a.a();
            }
          }
          , false, false);
        }
        while (true)
        {
          af.a(paramAnonymousCursor);
          return;
          parama.a();
        }
      }
    }
    , false, false);
  }

  private static abstract interface a
  {
    public abstract void a();
  }

  public static abstract interface b
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.f.a.a.b
 * JD-Core Version:    0.6.2
 */