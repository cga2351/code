package com.viber.voip.contacts.c.f.a.a;

import android.accounts.Account;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Handler;
import android.os.RemoteException;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.support.v4.util.CircularArray;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.c.e.b;
import com.viber.voip.messages.orm.manager.AsyncEntityManager;
import com.viber.voip.messages.orm.manager.AsyncEntityManager.FillCursorCompleteCallback;
import com.viber.voip.messages.orm.manager.EntityManager;
import com.viber.voip.model.entity.f;
import com.viber.voip.model.entity.n;
import com.viber.voip.model.entity.o;
import com.viber.voip.model.entity.p;
import com.viber.voip.s.a;
import com.viber.voip.util.af;
import com.viber.voip.util.bq.g;
import com.viber.voip.util.dq;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class c
  implements AsyncEntityManager.FillCursorCompleteCallback
{
  private static final Logger a = ViberEnv.getLogger();
  private Handler b;
  private final Handler c;
  private f d;
  private a e;
  private b f;
  private final ContentResolver g;

  public c(Context paramContext, f paramf, Handler paramHandler1, Handler paramHandler2, ContentResolver paramContentResolver)
  {
    this.f = b.a(paramContext);
    this.b = paramHandler1;
    this.d = paramf;
    this.c = paramHandler2;
    this.g = paramContentResolver;
  }

  private void a(ArrayList<ContentProviderOperation> paramArrayList, Account paramAccount, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap)
  {
    Object localObject = null;
    ContentProviderOperation.Builder localBuilder1 = ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI);
    String str1;
    String str2;
    label42: String[] arrayOfString;
    int i;
    String str4;
    String str3;
    if (paramAccount != null)
    {
      str1 = paramAccount.type;
      ContentProviderOperation.Builder localBuilder2 = localBuilder1.withValue("account_type", str1);
      if (paramAccount == null)
        break label262;
      str2 = paramAccount.name;
      paramArrayList.add(localBuilder2.withValue("account_name", str2).build());
      arrayOfString = paramString3.replaceAll("　", " ").trim().split("\\s+", 3);
      i = arrayOfString.length;
      if (i <= 0)
        break label298;
      str4 = arrayOfString[0];
      if (i != 2)
        break label268;
      str3 = arrayOfString[1];
    }
    while (true)
    {
      paramArrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/name").withValue("data1", paramString2).withValue("data9", str4).withValue("data8", localObject).withValue("data7", str3).build());
      paramArrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/phone_v2").withValue("data1", paramString1).withValue("data2", Integer.valueOf(2)).build());
      if (paramBitmap != null)
      {
        byte[] arrayOfByte = dq.a(paramBitmap, Bitmap.CompressFormat.JPEG, 90);
        paramArrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/photo").withValue("data15", arrayOfByte).build());
      }
      return;
      str1 = null;
      break;
      label262: str2 = null;
      break label42;
      label268: if (i == 3)
      {
        localObject = arrayOfString[1];
        str3 = arrayOfString[2];
      }
      else
      {
        str3 = null;
        localObject = null;
        continue;
        label298: str3 = null;
        localObject = null;
        str4 = null;
      }
    }
  }

  private void a(boolean paramBoolean, a parama, long paramLong, int paramInt)
  {
    this.e = parama;
    this.c.post(new d(this, parama, paramLong, paramInt, paramBoolean));
  }

  public void a(a parama)
  {
    this.e = parama;
    StringBuilder localStringBuilder = new StringBuilder(9 + parama.c.length());
    localStringBuilder.append("_id IN (").append(parama.c).append(")");
    new AsyncEntityManager(p.a, this).fillCursor(2, null, localStringBuilder.toString(), new String[0]);
  }

  public void a(final h paramh)
  {
    this.f.a(1, null, ContactsContract.Contacts.CONTENT_URI, new String[] { "_id" }, "in_visible_group=1", null, null, new bq.g()
    {
      public void onQueryComplete(int paramAnonymousInt, Object paramAnonymousObject, Cursor paramAnonymousCursor)
      {
        int i = 0;
        if (paramAnonymousCursor != null)
        {
          boolean bool = paramAnonymousCursor.moveToFirst();
          i = 0;
          if (bool)
            i = paramAnonymousCursor.getCount();
        }
        af.a(paramAnonymousCursor);
        if (paramh != null)
          paramh.a(i);
      }
    }
    , false, false);
  }

  public void a(boolean paramBoolean, a parama, long paramLong)
  {
    a(paramBoolean, parama, paramLong, 800);
  }

  public void a(boolean paramBoolean, Set<String> paramSet)
  {
    StringBuilder localStringBuilder = new StringBuilder(512);
    if (!paramBoolean)
      localStringBuilder.append("in_visible_group=1 AND ");
    localStringBuilder.append("display_name IS NOT NULL AND mimetype IN ('vnd.android.cursor.item/phone_v2','vnd.android.cursor.item/name') AND contact_id>=? AND (account_type<>'com.viber.voip' OR account_type IS NULL)").append(" AND ").append("data1").append(" IN (").append(a.b(paramSet)).append(")");
    new AsyncEntityManager(o.a, this).fillCursor(5, null, localStringBuilder.toString(), new String[] { "0" });
  }

  ContentProviderResult[] a(Account paramAccount, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap)
    throws RemoteException, OperationApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    a(localArrayList, paramAccount, paramString1, paramString2, paramString3, paramBitmap);
    return this.g.applyBatch("com.android.contacts", localArrayList);
  }

  public void b(a parama)
  {
    this.e = parama;
    StringBuilder localStringBuilder = new StringBuilder(23 + parama.c.length());
    localStringBuilder.append("_id IN (").append(parama.c).append(") AND deleted=1");
    new AsyncEntityManager(p.a, this).fillCursor(3, null, localStringBuilder.toString(), new String[0]);
  }

  public void c(a parama)
  {
    this.e = parama;
    StringBuilder localStringBuilder = new StringBuilder(32 + parama.b.length());
    localStringBuilder.append("_id IN (").append(parama.b).append(") AND in_visible_group=0");
    new AsyncEntityManager(n.a, this).fillCursor(4, null, localStringBuilder.toString(), new String[0]);
  }

  public void onDataReady(final EntityManager paramEntityManager, final int paramInt)
  {
    if (this.d != null)
    {
      this.b.post(new Runnable()
      {
        public void run()
        {
          if (paramInt == 5)
            c.a(c.this).a(new c.b(c.this, paramEntityManager));
          while (true)
          {
            paramEntityManager.closeCursor();
            return;
            if (paramInt == 1)
              c.a(c.this).b(new c.b(c.this, paramEntityManager));
            else if (paramInt == 2)
              c.a(c.this).a(new c.d(c.this, paramEntityManager));
            else if (paramInt == 3)
              c.a(c.this).a(new c.c(paramEntityManager, null));
            else if (paramInt == 4)
              c.a(c.this).a(new c.e(c.this, paramEntityManager));
          }
        }
      });
      return;
    }
    paramEntityManager.closeCursor();
  }

  public static class a
  {
    public final CircularArray<c.g> a;
    public final String b;
    public final String c;
    public final int d;

    a(int paramInt, CircularArray<c.g> paramCircularArray, String paramString1, String paramString2)
    {
      this.a = paramCircularArray;
      if (paramString1 != null)
      {
        this.c = paramString1;
        if (paramString2 == null)
          break label41;
      }
      while (true)
      {
        this.b = paramString2;
        this.d = paramInt;
        return;
        paramString1 = "";
        break;
        label41: paramString2 = "";
      }
    }
  }

  class b
  {
    final boolean a;
    final Set<f> b;
    final long c;

    b(EntityManager arg2)
    {
      Object localObject;
      boolean bool;
      HashSet localHashSet;
      int i;
      long l;
      if (localObject.getCount() < 800)
      {
        bool = true;
        this.a = bool;
        this.b = new HashSet();
        localHashSet = new HashSet();
        i = 0;
        l = -1L;
        label54: if (i >= localObject.getCount())
          break label255;
        o localo = (o)localObject.getEntity(i);
        if (localo != null)
        {
          if ((l != -1L) && (l != localo.e()))
          {
            this.b.add(new f(localHashSet));
            localHashSet.clear();
          }
          l = localo.e();
          localHashSet.add(localo);
          if (i == -1 + localObject.getCount())
          {
            if (!this.a)
              break label197;
            this.b.add(new f(localHashSet));
            localHashSet.clear();
          }
        }
      }
      while (true)
      {
        i++;
        break label54;
        bool = false;
        break;
        label197: if (this.b.size() == 0)
        {
          this.b.add(new f().a(localHashSet));
          l += 1L;
          for (int j = 0; j < localObject.getCount(); j++);
        }
      }
      label255: this.c = l;
      localObject.closeCursor();
    }
  }

  public static class c
  {
    public final boolean a;
    public final String b;

    private c(EntityManager paramEntityManager)
    {
      if (paramEntityManager.getCount() > 0);
      for (boolean bool = true; ; bool = false)
      {
        this.a = bool;
        if (this.a)
          break;
        this.b = "";
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      while (i < paramEntityManager.getCount())
      {
        p localp = (p)paramEntityManager.getEntity(i);
        if (localStringBuilder.length() > 0)
          localStringBuilder.append(',');
        localStringBuilder.append(localp.getId());
        i++;
      }
      this.b = localStringBuilder.toString();
    }
  }

  public class d
  {
    public final boolean a;
    public final String b;

    public d(EntityManager arg2)
    {
      Object localObject;
      if (c.b(c.this).d != localObject.getCount());
      StringBuilder localStringBuilder;
      for (boolean bool = true; ; bool = false)
      {
        this.a = bool;
        if (!this.a)
          break label122;
        localStringBuilder = new StringBuilder();
        while (i < localObject.getCount())
        {
          p localp = (p)localObject.getEntity(i);
          if (localStringBuilder.length() > 0)
            localStringBuilder.append(',');
          localStringBuilder.append(localp.getId());
          i++;
        }
      }
      label122: for (this.b = localStringBuilder.toString(); ; this.b = null)
      {
        localObject.closeCursor();
        return;
      }
    }
  }

  public class e
  {
    public final boolean a;
    public final String b;

    public e(EntityManager arg2)
    {
      Object localObject;
      if (localObject.getCount() > 0);
      StringBuilder localStringBuilder;
      for (boolean bool = true; ; bool = false)
      {
        this.a = bool;
        if (!this.a)
          break label115;
        localStringBuilder = new StringBuilder();
        while (i < localObject.getCount())
        {
          n localn = (n)localObject.getEntity(i);
          if (localStringBuilder.length() > 0)
            localStringBuilder.append(',');
          localStringBuilder.append(localn.getId());
          i++;
        }
      }
      label115: for (this.b = localStringBuilder.toString(); ; this.b = null)
      {
        localObject.closeCursor();
        return;
      }
    }
  }

  public static abstract interface f
  {
    public abstract void a(c.b paramb);

    public abstract void a(c.c paramc);

    public abstract void a(c.d paramd);

    public abstract void a(c.e parame);

    public abstract void b(c.b paramb);
  }

  public static class g
  {
    public final String a;
    public final long b;
    public final long c;
    public final int d;
    public final boolean e;

    public g(String paramString, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean)
    {
      this.a = paramString;
      this.b = paramLong1;
      this.c = paramLong2;
      this.d = paramInt;
      this.e = paramBoolean;
    }

    public String toString()
    {
      return "VersionSyncPortion{, firsContactId=" + this.b + ", lastContactId=" + this.c + ", count=" + this.d + ", isLast=" + this.e + '}';
    }
  }

  public static abstract interface h
  {
    public abstract void a(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.f.a.a.c
 * JD-Core Version:    0.6.2
 */