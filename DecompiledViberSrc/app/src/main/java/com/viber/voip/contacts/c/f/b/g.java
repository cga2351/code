package com.viber.voip.contacts.c.f.b;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentValues;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.provider.contacts.a.e;
import com.viber.provider.contacts.a.g;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.memberid.Member;
import com.viber.voip.model.entity.e;
import com.viber.voip.model.entity.k;
import com.viber.voip.model.entity.s;
import com.viber.voip.model.entity.t;
import com.viber.voip.model.entity.x;
import com.viber.voip.model.i;
import com.viber.voip.s.a;
import com.viber.voip.util.cd;
import com.viber.voip.util.ce;
import com.viber.voip.util.dx;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class g
{
  private static final Logger a = ViberEnv.getLogger();
  private f b;

  public g(f paramf)
  {
    this.b = paramf;
  }

  private void a(ArrayList<ContentProviderOperation> paramArrayList)
  {
    try
    {
      this.b.a(paramArrayList);
      return;
    }
    catch (Exception localException)
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        ContentProviderOperation localContentProviderOperation = (ContentProviderOperation)localIterator.next();
        String str = ce.l.matcher(localContentProviderOperation.toString()).replaceAll("xxx");
        ViberApplication.getInstance().logToCrashlytics(str);
      }
      throw localException;
    }
  }

  private void a(Map<String, Set<a.a>> paramMap, a.a parama)
  {
    Object localObject = (Set)paramMap.get(parama.a());
    if (localObject == null)
    {
      localObject = new HashSet();
      paramMap.put(parama.a(), localObject);
    }
    ((Set)localObject).add(parama);
  }

  private void b(Set<Member> paramSet)
  {
    Iterator localIterator = this.b.a().iterator();
    while (localIterator.hasNext())
      paramSet.add(Member.from((x)localIterator.next()));
    a();
  }

  public b a(a.b paramb)
  {
    ArrayList localArrayList1 = new ArrayList();
    if (paramb.g())
      localArrayList1.add(ContentProviderOperation.newUpdate(a.e.a).withValue("clear", Integer.valueOf(1)).build());
    localArrayList1.add(ContentProviderOperation.newUpdate(a.e.a).withValue("clear", Integer.valueOf(0)).withSelection("data2 IN (" + a.b(paramb.c()) + ")", null).build());
    this.b.a(localArrayList1);
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    HashSet localHashSet3 = new HashSet();
    Object localObject;
    ArrayList localArrayList2;
    HashMap localHashMap;
    Map localMap1;
    Map localMap2;
    Iterator localIterator1;
    if (paramb.j())
    {
      localObject = this.b.b();
      localArrayList2 = new ArrayList();
      localHashMap = new HashMap();
      localMap1 = this.b.b(paramb.c());
      localMap2 = this.b.c(paramb.d());
      localIterator1 = paramb.b().values().iterator();
    }
    while (true)
    {
      label207: if (!localIterator1.hasNext())
        break label742;
      a.a locala = (a.a)localIterator1.next();
      f.c localc = (f.c)localMap1.get(locala.b().b);
      f.b localb = (f.b)localMap2.get(locala.a());
      int k;
      label274: int m;
      if (localb == null)
      {
        k = 1;
        if (localc != null)
          break label400;
        m = 1;
        label282: if ((localc == null) || (localc.c == null) || (localc.c.equals(locala.a())))
          break label406;
      }
      label400: label406: for (int n = 1; ; n = 0)
      {
        if (m != 0)
          localHashSet2.add(locala.b().b);
        if ((n != 0) && (m == 0))
          localHashSet3.add(locala.b().b);
        if ((k == 0) || (m == 0))
          break label412;
        a(localHashMap, locala);
        break label207;
        localObject = new HashSet();
        break;
        k = 0;
        break label274;
        m = 0;
        break label282;
      }
      label412: if ((k != 0) && (m == 0))
      {
        a(localHashMap, locala);
        localArrayList2.add(ContentProviderOperation.newDelete(a.e.a).withSelection("_id=" + localc.a, null).build());
      }
      else if ((n != 0) && (k == 0))
      {
        localArrayList2.add(ContentProviderOperation.newUpdate(a.e.a).withValue("contact_id", Long.valueOf(localb.a)).withValue("raw_id", Long.valueOf(localb.c)).withSelection("_id=" + localc.a, null).build());
        localArrayList2.add(ContentProviderOperation.newUpdate(com.viber.provider.contacts.a.c.a).withValue("version", Integer.valueOf(1 + localb.b)).withSelection("_id=" + localb.a, null).build());
      }
      else if ((m != 0) && (k == 0))
      {
        k localk = new k(locala.b());
        localk.a(localb.a);
        localk.b(localb.c);
        localArrayList2.add(ContentProviderOperation.newInsert(a.e.a).withValues(localk.getContentValues()).build());
        localArrayList2.add(ContentProviderOperation.newUpdate(com.viber.provider.contacts.a.c.a).withValue("version", Integer.valueOf(1 + localb.b)).withSelection("_id=" + localb.a, null).build());
      }
    }
    label742: Iterator localIterator2 = localHashMap.entrySet().iterator();
    while (localIterator2.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator2.next();
      int i = localArrayList2.size();
      String str = (String)localEntry.getKey();
      com.viber.voip.model.entity.f localf = new com.viber.voip.model.entity.f(str, (String)paramb.a().get(str), (Set)localEntry.getValue());
      localArrayList2.add(ContentProviderOperation.newInsert(com.viber.provider.contacts.a.c.a).withValues(localf.getContentValues()).build());
      localHashSet1.add(str);
      int j = localArrayList2.size();
      s locals = localf.b();
      localArrayList2.add(ContentProviderOperation.newInsert(com.viber.provider.contacts.a.d.a).withValues(locals.getContentValues()).withValueBackReference("contact_id", i).build());
      Iterator localIterator3 = locals.b().iterator();
      while (localIterator3.hasNext())
      {
        t localt = (t)localIterator3.next();
        localArrayList2.add(ContentProviderOperation.newInsert(a.e.a).withValues(localt.getContentValues()).withValueBackReference("raw_id", j).withValueBackReference("contact_id", i).build());
      }
    }
    if (paramb.j())
    {
      this.b.d();
      localArrayList2.add(ContentProviderOperation.newDelete(a.e.a).withSelection("clear=1", null).build());
    }
    localArrayList2.add(ContentProviderOperation.newDelete(com.viber.provider.contacts.a.c.a).withSelection("_id NOT IN (SELECT contact_id FROM phonebookdata)", null).build());
    localArrayList2.add(ContentProviderOperation.newDelete(com.viber.provider.contacts.a.d.a).withSelection("_id NOT IN (SELECT contact_id FROM phonebookdata)", null).build());
    this.b.a(localArrayList2);
    return new b(localHashSet1, localHashSet2, (Set)localObject, localHashSet3, null);
  }

  public b a(a.b paramb, String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(ContentProviderOperation.newUpdate(a.e.a).withValue("clear", Integer.valueOf(1)).withSelection("data2 IN (" + a.a(paramArrayOfString) + ")", null).build());
      this.b.a(localArrayList);
    }
    return a(paramb);
  }

  public c a(a.d paramd)
  {
    while (true)
    {
      Map localMap;
      HashSet localHashSet1;
      HashSet localHashSet2;
      HashSet localHashSet3;
      HashMap localHashMap;
      ArrayList localArrayList;
      String str9;
      String str10;
      String str14;
      String str15;
      try
      {
        localMap = paramd.f();
        localHashSet1 = new HashSet();
        localHashSet2 = new HashSet();
        localHashSet3 = new HashSet();
        localHashMap = new HashMap();
        List localList = this.b.a(localMap.keySet());
        localArrayList = new ArrayList();
        if (paramd.g())
          localArrayList.add(ContentProviderOperation.newUpdate(a.g.a).withValue("clear", Integer.valueOf(1)).build());
        localArrayList.add(ContentProviderOperation.newUpdate(a.g.a).withValue("clear", Integer.valueOf(0)).withSelection("member_id IN (" + a.b(localMap.keySet()) + ")", null).build());
        Iterator localIterator1 = localList.iterator();
        if (localIterator1.hasNext())
        {
          x localx2 = (x)localIterator1.next();
          String str6 = localx2.d();
          String str7 = localx2.a();
          String str8 = localx2.c();
          str9 = localx2.f();
          str10 = localx2.b();
          a.c localc2 = (a.c)localMap.remove(str7);
          if (localc2 == null)
            continue;
          String str11 = localc2.b;
          String str12 = localc2.c;
          String str13 = localc2.a;
          str14 = localc2.d;
          str15 = localc2.e;
          ContentValues localContentValues = new ContentValues();
          if (!str6.equals(str12))
          {
            localContentValues.put("photo", str12);
            cd.a(str12, str15, "ServerSyncUpdateMananger [handleViberMembers]", dx.a(str12));
          }
          if ((!str8.equals(str11)) && (!TextUtils.isEmpty(str11)))
            localContentValues.put("canonized_number", str11);
          if ((str9 == null) || (str9.equals(str14)))
            break label782;
          localContentValues.put("viber_id", str14);
          if ((str10 == null) || (str10.equals(str15)))
            break label795;
          localContentValues.put("encrypted_member_id", str15);
          if (localContentValues.size() <= 0)
            continue;
          localHashSet2.add(localc2.a(localx2.e()));
          if (localContentValues.containsKey("canonized_number"))
            localHashMap.put(new Member(str13, str11), new a(str8, localc2.f, paramd.i()));
          localArrayList.add(ContentProviderOperation.newUpdate(a.g.a).withValues(localContentValues).withSelection("member_id=?", new String[] { str7 }).build());
          continue;
        }
      }
      finally
      {
      }
      ArrayMap localArrayMap = new ArrayMap(localMap.size());
      Iterator localIterator2 = localMap.entrySet().iterator();
      while (localIterator2.hasNext())
      {
        a.c localc1 = (a.c)((Map.Entry)localIterator2.next()).getValue();
        String str1 = localc1.b;
        String str2 = localc1.c;
        String str3 = localc1.a;
        String str4 = localc1.d;
        String str5 = localc1.e;
        if (!TextUtils.isEmpty(str3))
        {
          localHashSet3.add(localc1.a(null));
          x localx1 = new x(str3, str1, str2, str4, str5);
          localArrayList.add(ContentProviderOperation.newInsert(a.g.a).withValues(localx1.getContentValues()).build());
        }
      }
      Iterator localIterator3 = localArrayMap.values().iterator();
      while (localIterator3.hasNext())
        localArrayList.add(((ContentProviderOperation.Builder)localIterator3.next()).build());
      a(localArrayList);
      if (paramd.j())
        b(localHashSet1);
      for (boolean bool = true; ; bool = false)
      {
        c localc = new c(bool, localHashSet1, localHashSet2, localHashSet3, localHashMap, null);
        return localc;
      }
      label782: if ((str9 == null) && (str14 != null))
      {
        continue;
        label795: if ((str10 != null) || (str15 == null));
      }
    }
  }

  public c a(Member paramMember, long paramLong)
  {
    int j;
    int k;
    try
    {
      HashSet localHashSet1 = new HashSet();
      HashSet localHashSet2 = new HashSet();
      localHashSet2.add(paramMember);
      a(paramMember);
      ArrayList localArrayList = new ArrayList();
      List localList1 = this.b.c();
      List localList2 = this.b.b(paramMember.getPhoneNumber());
      for (int i = 0; (i < 5) && (i < localList2.size()); i++)
      {
        e locale2 = (e)localList2.get(i);
        ContentProviderOperation.Builder localBuilder2 = ContentProviderOperation.newUpdate(com.viber.provider.contacts.a.c.a).withValue("recently_joined_date", Long.valueOf(paramLong));
        String[] arrayOfString2 = new String[1];
        arrayOfString2[0] = String.valueOf(locale2.getId());
        localArrayList.add(localBuilder2.withSelection("_id=?", arrayOfString2).build());
        localHashSet1.add(locale2);
      }
      j = 5 - localArrayList.size();
      if (j > 0)
      {
        break label321;
        while (k < localList1.size())
        {
          e locale1 = (e)localList1.get(k);
          ContentProviderOperation.Builder localBuilder1 = ContentProviderOperation.newUpdate(com.viber.provider.contacts.a.c.a).withValue("recently_joined_date", Integer.valueOf(0));
          String[] arrayOfString1 = new String[1];
          arrayOfString1[0] = String.valueOf(locale1.getId());
          localArrayList.add(localBuilder1.withSelection("_id=?", arrayOfString1).build());
          k++;
        }
        this.b.a(localArrayList);
        c localc = new c(true, Collections.emptySet(), Collections.emptySet(), localHashSet2, Collections.emptyMap(), localHashSet1, null);
        return localc;
      }
    }
    finally
    {
    }
    while (true)
    {
      label321: k = j;
      break;
      j = 0;
    }
  }

  public c a(String paramString)
  {
    try
    {
      x localx = this.b.a(paramString);
      if (localx != null)
      {
        this.b.c(paramString);
        a();
      }
      c localc;
      for (Object localObject2 = new c(true, Collections.singleton(Member.from(localx)), Collections.emptySet(), Collections.emptySet(), Collections.emptyMap(), null); ; localObject2 = localc)
      {
        return localObject2;
        localc = c.a();
      }
    }
    finally
    {
    }
  }

  void a()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(ContentProviderOperation.newDelete(a.g.a).withSelection("clear=1", null).build());
      localArrayList.add(ContentProviderOperation.newUpdate(com.viber.provider.contacts.a.c.a).withValue("viber", Boolean.valueOf(false)).withValue("recently_joined_date", Integer.valueOf(0)).withSelection(this.b.a(false), null).build());
      localArrayList.add(ContentProviderOperation.newUpdate(com.viber.provider.contacts.a.c.a).withValue("viber", Boolean.valueOf(true)).withSelection(this.b.a(true), null).build());
      localArrayList.add(ContentProviderOperation.newUpdate(com.viber.provider.contacts.a.c.a).withValue("viber", Boolean.valueOf(true)).withValue("joined_date", Long.valueOf(System.currentTimeMillis())).withSelection("viber=1 AND joined_date=0", null).build());
      this.b.a(localArrayList);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(Member paramMember)
  {
    try
    {
      this.b.a(paramMember);
      a();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void a(Set<x> paramSet)
  {
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList(paramSet.size());
      Iterator localIterator = paramSet.iterator();
      while (localIterator.hasNext())
      {
        x localx = (x)localIterator.next();
        localArrayList.add(ContentProviderOperation.newUpdate(a.g.a).withValues(localx.getContentValues()).withSelection("_id=" + localx.getId(), null).build());
      }
    }
    finally
    {
    }
    a(localArrayList);
  }

  public void b(Member paramMember)
  {
    try
    {
      this.b.b(paramMember);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static class a
  {
    public final String a;
    public final int b;
    public final long c;

    public a(String paramString, int paramInt, long paramLong)
    {
      this.a = paramString;
      this.b = paramInt;
      this.c = paramLong;
    }

    public boolean a()
    {
      return 1 == this.b;
    }

    public String toString()
    {
      return "PreviousNumberInfo{number='" + this.a + '\'' + ", serverFlag=" + this.b + ", notificationToken=" + this.c + '}';
    }
  }

  public static class b
  {
    public final Set<String> a;
    public final Set<String> b;
    public final Set<String> c;
    public final Set<String> d;
    public final Set<String> e;

    private b(Set<String> paramSet1, Set<String> paramSet2, Set<String> paramSet3, Set<String> paramSet4)
    {
      this.a = paramSet1;
      this.b = paramSet2;
      this.c = paramSet3;
      this.e = paramSet4;
      this.d = new HashSet();
      this.d.addAll(paramSet2);
      this.d.addAll(paramSet3);
    }

    public boolean a()
    {
      return (this.b.size() > 0) || (this.c.size() > 0) || (this.a.size() > 0);
    }

    public String toString()
    {
      return "UpdateAddressbookResult [newNames=" + this.a + ", newNumbers=" + this.b + ", removedNumbers=" + this.c + ", changedNumbers=" + this.d + "]";
    }
  }

  public static class c
  {
    public final boolean a;
    public final Set<Member> b;
    public final Set<Member> c;
    public final Set<Member> d;
    public final Map<Member, g.a> e;
    public final Set<i> f;

    private c(boolean paramBoolean, Set<Member> paramSet1, Set<Member> paramSet2, Set<Member> paramSet3, Map<Member, g.a> paramMap)
    {
      this(paramBoolean, paramSet1, paramSet2, paramSet3, paramMap, Collections.emptySet());
    }

    private c(boolean paramBoolean, Set<Member> paramSet1, Set<Member> paramSet2, Set<Member> paramSet3, Map<Member, g.a> paramMap, Set<i> paramSet)
    {
      this.a = paramBoolean;
      this.b = paramSet1;
      this.c = paramSet2;
      this.d = paramSet3;
      this.e = paramMap;
      this.f = paramSet;
    }

    public static c a()
    {
      return new c(false, Collections.emptySet(), Collections.emptySet(), Collections.emptySet(), Collections.emptyMap());
    }

    public boolean b()
    {
      return (this.d.size() > 0) || (this.b.size() > 0) || (this.c.size() > 0);
    }

    public String toString()
    {
      return "UpdateResult [viberContactsChanged=" + this.a + ", removedMembers=" + this.b + ", newMembers=" + this.d + ", updatedMembers=" + this.c + ", newPhoneMembers=" + this.e + "]";
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.f.b.g
 * JD-Core Version:    0.6.2
 */