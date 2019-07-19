package com.viber.voip.j.a.a;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.Contacts;
import com.viber.provider.contacts.a.c;
import com.viber.voip.util.af;
import com.viber.voip.util.y;
import java.io.Closeable;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public final class a
{
  private final ContentResolver a;
  private final d.d.a.b<String, Boolean> b;

  public a(@NotNull ContentResolver paramContentResolver, @NotNull d.d.a.b<? super String, Boolean> paramb)
  {
    this.a = paramContentResolver;
    this.b = paramb;
  }

  private final int a(Set<Long> paramSet)
  {
    ContentResolver localContentResolver = this.a;
    Uri localUri = a.c.a;
    d.d.b.h.a(localUri, "ViberContactsContract.Contacts.CONTENT_URI");
    return y.a(localContentResolver, localUri, "_id IN (" + com.viber.voip.s.a.e((Collection)paramSet) + ") AND " + "viber= true", null, null, 24, null);
  }

  private final int a(boolean paramBoolean)
  {
    ContentResolver localContentResolver = this.a;
    Uri localUri = ContactsContract.CommonDataKinds.Email.CONTENT_URI;
    d.d.b.h.a(localUri, "ContactsContract.CommonDataKinds.Email.CONTENT_URI");
    String[] arrayOfString1 = { "contact_id" };
    String[] arrayOfString2 = new String[1];
    if (paramBoolean);
    for (String str = "1"; ; str = "0")
    {
      arrayOfString2[0] = str;
      return y.a(localContentResolver, localUri, arrayOfString1, "has_phone_number =?", arrayOfString2, null, 32, null);
    }
  }

  @SuppressLint({"Recycle"})
  private final Set<Long> a(d.d.a.b<? super String, Boolean> paramb)
  {
    Cursor localCursor = this.a.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, new String[] { "contact_id", "data1" }, "mimetype=? AND has_phone_number=?", new String[] { "vnd.android.cursor.item/email_v2", "1" }, null);
    Closeable localCloseable;
    Object localObject1;
    if (localCursor != null)
    {
      localCloseable = (Closeable)localCursor;
      localObject1 = (Throwable)null;
    }
    try
    {
      ((Cursor)localCloseable);
      int i = localCursor.getColumnIndex("data1");
      int j = localCursor.getColumnIndex("contact_id");
      Set localSet = (Set)new LinkedHashSet();
      if (af.c(localCursor))
      {
        boolean bool;
        do
        {
          if (((Boolean)paramb.a(localCursor.getString(i))).booleanValue())
            localSet.add(Long.valueOf(localCursor.getLong(j)));
          bool = localCursor.moveToNext();
        }
        while (bool);
      }
      d.c.a.a(localCloseable, (Throwable)localObject1);
      return localSet;
      return d.a.h.a();
    }
    catch (Throwable localThrowable)
    {
      Object localObject2;
      try
      {
        throw localThrowable;
      }
      finally
      {
        localObject1 = localThrowable;
      }
      label184: d.c.a.a(localCloseable, (Throwable)localObject1);
      throw localObject2;
    }
    finally
    {
      break label184;
    }
  }

  private final int b()
  {
    ContentResolver localContentResolver = this.a;
    Uri localUri = ContactsContract.Contacts.CONTENT_URI;
    d.d.b.h.a(localUri, "ContactsContract.Contacts.CONTENT_URI");
    return y.a(localContentResolver, localUri, new String[] { "_id" }, null, null, null, 56, null);
  }

  private final int c()
  {
    ContentResolver localContentResolver = this.a;
    Uri localUri = a.c.a;
    d.d.b.h.a(localUri, "ViberContactsContract.Contacts.CONTENT_URI");
    return y.a(localContentResolver, localUri, "viber= true", null, null, 24, null);
  }

  @NotNull
  public final b a()
  {
    Set localSet = a(this.b);
    return new b(b(), c(), localSet.size(), a(localSet), a(false));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.j.a.a.a
 * JD-Core Version:    0.6.2
 */