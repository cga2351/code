package com.viber.voip.contacts.c.d;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentValues;
import android.content.Context;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.ArraySet;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.provider.contacts.a.b;
import com.viber.provider.contacts.a.c;
import com.viber.provider.contacts.a.d;
import com.viber.provider.contacts.a.e;
import com.viber.provider.contacts.a.f;
import com.viber.provider.contacts.a.g;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.adapters.c;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.orm.creator.Creator;
import com.viber.voip.messages.orm.creator.CreatorHelper;
import com.viber.voip.messages.orm.manager.AsyncEntityManager;
import com.viber.voip.messages.orm.manager.AsyncEntityManager.FillCursorCompleteCallback;
import com.viber.voip.messages.orm.manager.EntityManager;
import com.viber.voip.model.entity.d;
import com.viber.voip.model.entity.f;
import com.viber.voip.model.entity.g;
import com.viber.voip.model.entity.x;
import com.viber.voip.shareviber.invitescreen.b.i;
import com.viber.voip.util.af;
import com.viber.voip.util.bq.g;
import com.viber.voip.util.bq.i;
import com.viber.voip.util.dd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class j
  implements m
{
  private static final Logger a = ViberEnv.getLogger();
  private Context b;
  private com.viber.voip.contacts.c.e.b c;
  private AsyncEntityManager d;
  private dagger.a<AsyncEntityManager> e;
  private dagger.a<AsyncEntityManager> f;
  private dagger.a<AsyncEntityManager> g;

  public j(Context paramContext)
  {
    dd.b();
    this.b = paramContext.getApplicationContext();
    this.c = com.viber.voip.contacts.c.e.b.a(this.b);
    this.d = new AsyncEntityManager(d.b);
    this.f = new com.viber.voip.g.b.b()
    {
      protected AsyncEntityManager a()
      {
        return new AsyncEntityManager(x.a);
      }
    };
    this.e = new com.viber.voip.g.b.b()
    {
      protected AsyncEntityManager a()
      {
        return new AsyncEntityManager(d.c);
      }
    };
    this.g = new com.viber.voip.g.b.b()
    {
      protected AsyncEntityManager a()
      {
        return new AsyncEntityManager(f.a);
      }
    };
  }

  private Set<com.viber.voip.model.a> a(String paramString, ArrayMap<String, String> paramArrayMap)
  {
    AsyncEntityManager localAsyncEntityManager = new AsyncEntityManager(d.b);
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = com.viber.voip.s.a.b(paramArrayMap.keySet());
    arrayOfObject[1] = com.viber.voip.s.a.b(paramArrayMap.values());
    localAsyncEntityManager.fillCursorSync(null, String.format(paramString, arrayOfObject), new String[0]);
    HashSet localHashSet = new HashSet(localAsyncEntityManager.getCount());
    for (int i = 0; i < localAsyncEntityManager.getCount(); i++)
      localHashSet.add((d)localAsyncEntityManager.getEntity(i));
    localAsyncEntityManager.closeCursor();
    return localHashSet;
  }

  private Uri b(long paramLong, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
      return ContactsContract.Contacts.getLookupUri(paramLong, paramString);
    return Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, String.valueOf(paramLong));
  }

  public g a(String paramString)
  {
    String str = PhoneNumberUtils.stripSeparators(paramString);
    if ((str == null) || (TextUtils.isEmpty(str.trim())))
      return null;
    Cursor localCursor = af.a(this.b, a.c.i, g.a.getProjections(), "phonebookdata.mime_type=0 AND (phonebookdata.data1=? OR phonebookdata.data2=?)", null, new String[] { str, str });
    if ((localCursor != null) && (localCursor.moveToFirst()));
    for (g localg = (g)g.a.createInstance(localCursor); ; localg = null)
    {
      af.a(localCursor);
      return localg;
    }
  }

  public Set<String> a()
  {
    AsyncEntityManager localAsyncEntityManager = new AsyncEntityManager(com.viber.voip.model.entity.k.j);
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(0);
    localAsyncEntityManager.fillCursorSync(null, "mime_type=?", arrayOfString);
    int i = localAsyncEntityManager.getCount();
    HashSet localHashSet = new HashSet(i);
    int j = 0;
    if (j < i)
    {
      com.viber.voip.model.entity.k localk = (com.viber.voip.model.entity.k)localAsyncEntityManager.getEntity(j);
      if (localk == null)
        localAsyncEntityManager.getDataCursor();
      while (true)
      {
        j++;
        break;
        localHashSet.add(localk.b());
      }
    }
    localAsyncEntityManager.closeCursor();
    return localHashSet;
  }

  public Set<com.viber.voip.model.a> a(Member paramMember)
  {
    return a(Collections.singleton(paramMember));
  }

  public Set<com.viber.voip.model.a> a(Set<Member> paramSet)
  {
    if (paramSet.size() == 0)
      return Collections.emptySet();
    ArrayMap localArrayMap = new ArrayMap(paramSet.size());
    Iterator localIterator = paramSet.iterator();
    if (localIterator.hasNext())
    {
      Member localMember = (Member)localIterator.next();
      String str1 = localMember.getId();
      if (TextUtils.isEmpty(localMember.getPhoneNumber()));
      for (String str2 = localMember.getId(); ; str2 = localMember.getPhoneNumber())
      {
        localArrayMap.put(str1, str2);
        break;
      }
    }
    return a("phonebookcontact._id IN ( SELECT phonebookdata.contact_id FROM phonebookdata WHERE phonebookdata.data2 IN (SELECT vibernumbers.canonized_number FROM vibernumbers WHERE member_id IN(%s)) OR phonebookdata.data2 IN(%s))", localArrayMap);
  }

  public void a(final int paramInt, final m.d paramd)
  {
    this.d.fillCursor(this.c, new AsyncEntityManager.FillCursorCompleteCallback()
    {
      public void onDataReady(EntityManager paramAnonymousEntityManager, int paramAnonymousInt)
      {
        if (paramAnonymousEntityManager.getCount() < paramInt);
        HashSet localHashSet;
        for (int i = paramAnonymousEntityManager.getCount(); ; i = paramInt)
        {
          localHashSet = new HashSet(i);
          for (int j = 0; j < i; j++)
            localHashSet.add((com.viber.voip.model.a)paramAnonymousEntityManager.getEntity(j));
        }
        paramAnonymousEntityManager.closeCursor();
        paramd.a(localHashSet);
      }
    }
    , "phonebookcontact._id ASC LIMIT " + String.valueOf(paramInt), 0, "phonebookcontact.viber=0 AND native_photo_id>0", new String[0]);
  }

  public void a(long paramLong, final a parama)
  {
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("recently_joined_date", Integer.valueOf(0));
    this.c.a(0, null, a.c.a, localContentValues, "_id=" + paramLong, null, new bq.i()
    {
      public void onUpdateComplete(int paramAnonymousInt1, Object paramAnonymousObject, Uri paramAnonymousUri, Exception paramAnonymousException, int paramAnonymousInt2)
      {
        if (parama != null)
          parama.a();
      }
    });
  }

  public void a(long paramLong, final m.a parama)
  {
    AsyncEntityManager localAsyncEntityManager = this.d;
    com.viber.voip.contacts.c.e.b localb = this.c;
    AsyncEntityManager.FillCursorCompleteCallback local12 = new AsyncEntityManager.FillCursorCompleteCallback()
    {
      public void onDataReady(EntityManager paramAnonymousEntityManager, int paramAnonymousInt)
      {
        com.viber.voip.model.a locala = (com.viber.voip.model.a)paramAnonymousEntityManager.getEntity(0);
        paramAnonymousEntityManager.closeCursor();
        parama.a(false, locala);
      }
    };
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramLong);
    localAsyncEntityManager.fillCursor(localb, local12, 0, "phonebookcontact._id=?", arrayOfString);
  }

  public void a(long paramLong, String paramString)
  {
    Uri localUri = b(paramLong, paramString);
    this.c.a(1589, paramString, localUri, null, null, null, false, true);
  }

  public void a(final long paramLong, String paramString, final c paramc)
  {
    this.c.post(new Runnable()
    {
      public void run()
      {
        Uri localUri1 = j.a(j.this, paramLong, paramc);
        Uri localUri2 = ContactsContract.Contacts.lookupContact(j.b(j.this).getContentResolver(), localUri1);
        this.c.a(localUri2);
      }
    });
  }

  public void a(final long paramLong, String paramString, final boolean paramBoolean, final a parama)
  {
    ContentValues localContentValues = new ContentValues(1);
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      localContentValues.put("starred", Integer.valueOf(i));
      this.c.a(1584, paramString, a.c.a, localContentValues, "_id=" + paramLong, null, new bq.i()
      {
        public void onUpdateComplete(int paramAnonymousInt1, Object paramAnonymousObject, Uri paramAnonymousUri, Exception paramAnonymousException, int paramAnonymousInt2)
        {
          if (parama != null)
            parama.a();
          ContentValues localContentValues = new ContentValues(1);
          if (paramBoolean);
          for (int i = 1; ; i = 0)
          {
            localContentValues.put("starred", Integer.valueOf(i));
            Uri localUri = j.a(j.this, paramLong, this.d);
            j.a(j.this).a(1584, this.d, localUri, localContentValues, null, null, null, false, true);
            return;
          }
        }
      }
      , false, true);
      return;
    }
  }

  public void a(final b paramb)
  {
    this.c.a(0, null, a.c.a, new String[] { "DISTINCT phone_label" }, null, null, null, new bq.g()
    {
      public void onQueryComplete(int paramAnonymousInt, Object paramAnonymousObject, Cursor paramAnonymousCursor)
      {
        HashSet localHashSet = new HashSet();
        if ((paramAnonymousCursor != null) && (paramAnonymousCursor.moveToFirst()))
        {
          CharArrayBuffer localCharArrayBuffer = new CharArrayBuffer(100);
          do
          {
            paramAnonymousCursor.copyStringToBuffer(0, localCharArrayBuffer);
            localHashSet.add(c.a(localCharArrayBuffer.data[0]));
          }
          while (paramAnonymousCursor.moveToNext());
        }
        af.a(paramAnonymousCursor);
        if (paramb != null)
          paramb.a(localHashSet);
      }
    }
    , false, false, true);
  }

  public void a(m.a parama)
  {
    if (parama != null);
  }

  public void a(final String paramString, long paramLong, final m.a parama)
  {
    String str = PhoneNumberUtils.stripSeparators(paramString);
    if (TextUtils.isEmpty(str))
    {
      if (parama != null)
        parama.a(false, null);
      return;
    }
    AsyncEntityManager localAsyncEntityManager = this.d;
    com.viber.voip.contacts.c.e.b localb = this.c;
    AsyncEntityManager.FillCursorCompleteCallback local2 = new AsyncEntityManager.FillCursorCompleteCallback()
    {
      public void onDataReady(EntityManager paramAnonymousEntityManager, int paramAnonymousInt)
      {
        com.viber.voip.model.a locala = (com.viber.voip.model.a)paramAnonymousEntityManager.getEntity(0);
        paramAnonymousEntityManager.closeCursor();
        if (locala == null)
          j.this.a(paramString, new m.b()
          {
            public void a(String paramAnonymous2String, Set<com.viber.voip.model.a> paramAnonymous2Set)
            {
              int i = paramAnonymous2Set.size();
              com.viber.voip.model.a locala = null;
              if (i > 0)
                locala = (com.viber.voip.model.a)paramAnonymous2Set.iterator().next();
              j.2.this.b.a(true, locala);
            }
          });
        while (parama == null)
          return;
        parama.a(false, locala);
      }
    };
    String[] arrayOfString = new String[3];
    arrayOfString[0] = str;
    arrayOfString[1] = str;
    arrayOfString[2] = String.valueOf(paramLong);
    localAsyncEntityManager.fillCursor(localb, local2, 0, "phonebookcontact._id IN (SELECT phonebookdata.contact_id FROM phonebookdata WHERE phonebookdata.mime_type=0 AND (phonebookdata.data1=? OR phonebookdata.data2=?)) AND phonebookcontact._id=?", arrayOfString);
  }

  public void a(final String paramString, final m.b paramb)
  {
    String str = PhoneNumberUtils.stripSeparators(paramString);
    if (TextUtils.isEmpty(str))
    {
      if (paramb != null)
        paramb.a(paramString, new HashSet());
      return;
    }
    this.d.fillCursor(this.c, new AsyncEntityManager.FillCursorCompleteCallback()
    {
      public void onDataReady(EntityManager paramAnonymousEntityManager, int paramAnonymousInt)
      {
        HashSet localHashSet = new HashSet();
        for (int i = 0; i < paramAnonymousEntityManager.getCount(); i++)
          localHashSet.add((d)paramAnonymousEntityManager.getEntity(i));
        paramAnonymousEntityManager.closeCursor();
        if (paramb != null)
          paramb.a(paramString, localHashSet);
      }
    }
    , 0, "phonebookcontact._id IN (SELECT phonebookdata.contact_id FROM phonebookdata WHERE phonebookdata.mime_type=0 AND (phonebookdata.data1=? OR phonebookdata.data2=?))", new String[] { str, str });
  }

  public void a(String paramString1, String paramString2, d paramd)
  {
    String str = PhoneNumberUtils.stripSeparators(paramString1);
    if (TextUtils.isEmpty(str))
    {
      if (paramd != null)
        paramd.a(new ArrayList(0));
      return;
    }
    this.c.post(new k(this, str, paramString2, paramd));
  }

  public void a(Set<String> paramSet, final m.c paramc)
  {
    if ((paramSet == null) || (paramSet.size() == 0))
    {
      if (paramc != null)
        paramc.a(new HashMap(), new HashMap());
      return;
    }
    AsyncEntityManager localAsyncEntityManager = (AsyncEntityManager)this.e.get();
    com.viber.voip.contacts.c.e.b localb = this.c;
    AsyncEntityManager.FillCursorCompleteCallback local13 = new AsyncEntityManager.FillCursorCompleteCallback()
    {
      public void onDataReady(EntityManager paramAnonymousEntityManager, int paramAnonymousInt)
      {
        int i = paramAnonymousEntityManager.getCount();
        HashMap localHashMap1 = new HashMap(i);
        HashMap localHashMap2 = new HashMap();
        for (int j = 0; j < i; j++)
        {
          com.viber.voip.model.a locala = (com.viber.voip.model.a)paramAnonymousEntityManager.getEntity(j);
          localHashMap1.put(Long.valueOf(locala.getId()), locala);
          Iterator localIterator = locala.h().iterator();
          if (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            ArrayList localArrayList;
            if (!localHashMap2.containsKey(str))
            {
              localArrayList = new ArrayList();
              localHashMap2.put(str, localArrayList);
            }
            for (Object localObject = localArrayList; ; localObject = (List)localHashMap2.get(str))
            {
              ((List)localObject).add(locala);
              break;
            }
          }
        }
        paramAnonymousEntityManager.closeCursor();
        if (paramc != null)
          paramc.a(localHashMap2, localHashMap1);
      }
    };
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = com.viber.voip.s.a.b(paramSet);
    localAsyncEntityManager.fillCursor(localb, local13, 0, String.format("phonebookcontact._id IN (SELECT phonebookdata.contact_id FROM phonebookdata WHERE phonebookdata.mime_type=0 AND (phonebookdata.data2 IN (%s)))", arrayOfObject), new String[0]);
  }

  public void a(Set<String> paramSet1, Set<String> paramSet2, final m.e parame)
  {
    ((AsyncEntityManager)this.f.get()).fillCursor(this.c, new AsyncEntityManager.FillCursorCompleteCallback()
    {
      public void onDataReady(EntityManager paramAnonymousEntityManager, int paramAnonymousInt)
      {
        HashSet localHashSet = new HashSet();
        Iterator localIterator = paramAnonymousEntityManager.iterator();
        while (localIterator.hasNext())
          localHashSet.add((com.viber.voip.model.j)localIterator.next());
        paramAnonymousEntityManager.closeCursor();
        if (parame != null)
          parame.a(localHashSet);
      }
    }
    , 0, "member_id IN (" + com.viber.voip.s.a.b(paramSet1) + ") OR " + "canonized_number" + " IN (" + com.viber.voip.s.a.b(paramSet2) + ")", new String[0]);
  }

  public com.viber.voip.model.a b(String paramString)
  {
    String str = PhoneNumberUtils.stripSeparators(paramString);
    if (TextUtils.isEmpty(str))
      return null;
    AsyncEntityManager localAsyncEntityManager = new AsyncEntityManager(d.b);
    localAsyncEntityManager.fillCursorSync(null, "phonebookcontact._id IN (SELECT phonebookdata.contact_id FROM phonebookdata WHERE phonebookdata.mime_type=0 AND (phonebookdata.data1=? OR phonebookdata.data2=?))", new String[] { str, str });
    com.viber.voip.model.a locala = (com.viber.voip.model.a)localAsyncEntityManager.getEntity(0);
    localAsyncEntityManager.closeCursor();
    return locala;
  }

  public Collection<com.viber.voip.model.a> b(Member paramMember)
  {
    return b(Collections.singleton(paramMember)).values();
  }

  public Map<String, com.viber.voip.model.a> b(Set<Member> paramSet)
  {
    if (paramSet.size() == 0)
      return Collections.emptyMap();
    ArrayMap localArrayMap1 = new ArrayMap(paramSet.size());
    Iterator localIterator1 = paramSet.iterator();
    while (localIterator1.hasNext())
    {
      Member localMember = (Member)localIterator1.next();
      String str1 = localMember.getEncryptedMemberId();
      if (!TextUtils.isEmpty(str1))
      {
        if (TextUtils.isEmpty(localMember.getPhoneNumber()));
        for (String str2 = str1; ; str2 = localMember.getPhoneNumber())
        {
          localArrayMap1.put(str1, str2);
          break;
        }
      }
    }
    Set localSet = a("phonebookcontact._id IN ( SELECT phonebookdata.contact_id FROM phonebookdata WHERE phonebookdata.data2 IN (SELECT vibernumbers.canonized_number FROM vibernumbers WHERE encrypted_member_id IN(%s)) OR phonebookdata.data2 IN(%s))", localArrayMap1);
    ArrayMap localArrayMap2 = new ArrayMap(localSet.size());
    Iterator localIterator2 = localSet.iterator();
    while (localIterator2.hasNext())
    {
      com.viber.voip.model.a locala = (com.viber.voip.model.a)localIterator2.next();
      if (locala.p())
      {
        Iterator localIterator3 = locala.s().iterator();
        while (localIterator3.hasNext())
        {
          com.viber.voip.model.j localj = (com.viber.voip.model.j)localIterator3.next();
          if (!TextUtils.isEmpty(localj.b()))
            localArrayMap2.put(localj.b(), locala);
        }
      }
    }
    return localArrayMap2;
  }

  public Set<x> b()
  {
    AsyncEntityManager localAsyncEntityManager = new AsyncEntityManager(x.a);
    localAsyncEntityManager.fillCursorSync(null, null, new String[0]);
    int i = localAsyncEntityManager.getCount();
    ArraySet localArraySet = new ArraySet(i);
    int j = 0;
    if (j < i)
    {
      x localx = (x)localAsyncEntityManager.getEntity(j);
      if (localx == null);
      while (true)
      {
        j++;
        break;
        localArraySet.add(localx);
      }
    }
    localAsyncEntityManager.closeCursor();
    return localArraySet;
  }

  public g c(Member paramMember)
  {
    if (paramMember == null)
      return null;
    String[] arrayOfString1 = new String[1];
    arrayOfString1[0] = paramMember.getId();
    String str1 = com.viber.voip.s.a.a(arrayOfString1);
    String[] arrayOfString2 = new String[1];
    String str2;
    Cursor localCursor;
    if (TextUtils.isEmpty(paramMember.getPhoneNumber()))
    {
      str2 = paramMember.getId();
      arrayOfString2[0] = str2;
      String str3 = com.viber.voip.s.a.a(arrayOfString2);
      localCursor = af.a(this.b, a.c.i, g.a.getProjections(), String.format("phonebookcontact._id IN ( SELECT phonebookdata.contact_id FROM phonebookdata WHERE phonebookdata.data2 IN (SELECT vibernumbers.canonized_number FROM vibernumbers WHERE member_id IN(%s)) OR phonebookdata.data2 IN(%s))", new Object[] { str1, str3 }), null, null);
      if ((localCursor == null) || (!localCursor.moveToFirst()))
        break label142;
    }
    label142: for (g localg = (g)g.a.createInstance(localCursor); ; localg = null)
    {
      af.a(localCursor);
      return localg;
      str2 = paramMember.getPhoneNumber();
      break;
    }
  }

  public List<com.viber.voip.engagement.d.m> c()
  {
    AsyncEntityManager localAsyncEntityManager = new AsyncEntityManager(com.viber.voip.engagement.d.m.a);
    localAsyncEntityManager.fillCursorSync(null, "phonebookcontact._id IN (SELECT phonebookdata.contact_id FROM phonebookdata WHERE phonebookdata.mime_type=0) AND phonebookcontact.viber=1", new String[0]);
    int i = localAsyncEntityManager.getCount();
    ArrayList localArrayList = new ArrayList(i);
    for (int j = 0; j < i; j++)
      localArrayList.add((com.viber.voip.engagement.d.m)localAsyncEntityManager.getEntity(j));
    localAsyncEntityManager.closeCursor();
    return localArrayList;
  }

  public Set<com.viber.voip.model.a> c(String paramString)
  {
    String str = PhoneNumberUtils.stripSeparators(paramString);
    HashSet localHashSet = new HashSet();
    if (TextUtils.isEmpty(str))
      return localHashSet;
    AsyncEntityManager localAsyncEntityManager = new AsyncEntityManager(d.b);
    localAsyncEntityManager.fillCursorSync(null, "phonebookcontact._id IN (SELECT phonebookdata.contact_id FROM phonebookdata WHERE phonebookdata.mime_type=0 AND (phonebookdata.data1=? OR phonebookdata.data2=?))", new String[] { str, str });
    for (int i = 0; i < localAsyncEntityManager.getCount(); i++)
      localHashSet.add((d)localAsyncEntityManager.getEntity(i));
    localAsyncEntityManager.closeCursor();
    return localHashSet;
  }

  public List<i> d()
  {
    AsyncEntityManager localAsyncEntityManager = new AsyncEntityManager(i.a);
    localAsyncEntityManager.fillCursorSync(null, "phonebookdata.mime_type=0 AND phonebookcontact.viber=0", new String[0]);
    int i = localAsyncEntityManager.getCount();
    ArrayList localArrayList = new ArrayList(i);
    for (int j = 0; j < i; j++)
      localArrayList.add((i)localAsyncEntityManager.getEntity(j));
    localAsyncEntityManager.closeCursor();
    return localArrayList;
  }

  public int e()
  {
    Cursor localCursor = af.a(this.b, x.a.getContentUri(), new String[] { "COUNT(*)" }, null, null, null);
    if ((localCursor != null) && (localCursor.moveToFirst()))
    {
      int i = localCursor.getInt(0);
      af.a(localCursor);
      return i;
    }
    af.a(localCursor);
    return 0;
  }

  public void f()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ContentProviderOperation.newDelete(a.g.a).build());
    localArrayList.add(ContentProviderOperation.newDelete(a.c.a).build());
    localArrayList.add(ContentProviderOperation.newDelete(a.e.a).build());
    localArrayList.add(ContentProviderOperation.newDelete(a.d.a).build());
    localArrayList.add(ContentProviderOperation.newDelete(a.f.a).build());
    localArrayList.add(ContentProviderOperation.newDelete(a.b.a).build());
    this.c.a(0, "com.viber.voip.provider.vibercontacts", null, localArrayList);
  }

  public static abstract interface a
  {
    public abstract void a();
  }

  public static abstract interface b
  {
    public abstract void a(Set<Character> paramSet);
  }

  public static abstract interface c
  {
    public abstract void a(Uri paramUri);
  }

  public static abstract interface d
  {
    public abstract void a(Collection<com.viber.voip.model.entity.k> paramCollection);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.d.j
 * JD-Core Version:    0.6.2
 */