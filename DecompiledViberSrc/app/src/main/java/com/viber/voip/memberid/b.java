package com.viber.voip.memberid;

import android.content.Context;
import android.database.Cursor;
import com.viber.dexshared.Logger;
import com.viber.jni.memberid.PhoneNumberToMidInfo;
import com.viber.provider.messages.b.d;
import com.viber.voip.ViberEnv;
import com.viber.voip.model.a.d.a;
import com.viber.voip.model.e;
import com.viber.voip.util.af;
import com.viber.voip.util.ce;
import com.viber.voip.util.ci;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;
import org.sqlite.database.sqlite.SQLiteStatement;

class b
{
  public static final Logger a = ViberEnv.getLogger();
  private static final String[] b = { "+%", "%=" };
  private static final String c = " SELECT " + "DISTINCT " + "messages" + "." + "user_id" + " FROM " + "messages" + " WHERE " + String.format("%s LIKE ? AND %s NOT LIKE ?", new Object[] { "user_id", "user_id" }) + " AND " + "user_id" + " NOT IN(%s)" + " UNION ALL " + " SELECT " + "DISTINCT " + "messages_likes" + "." + "participant_number" + " FROM " + "messages_likes" + " WHERE " + String.format("%s LIKE ? AND %s NOT LIKE ?", new Object[] { "participant_number", "participant_number" }) + " AND " + "participant_number" + " NOT IN(%s)" + " UNION ALL " + " SELECT " + "participants_info" + "." + "number" + " FROM " + "participants_info" + " WHERE " + String.format("%s LIKE ? AND %s NOT LIKE ?", new Object[] { "number", "number" }) + " AND " + "number" + " NOT IN(%s)";
  private static final String g = " SELECT " + "vibernumbers" + "." + "canonized_number" + " FROM " + "vibernumbers" + " WHERE " + String.format("%s LIKE ? AND %s NOT LIKE ?", new Object[] { "canonized_number", "canonized_number" }) + " AND " + "canonized_number" + " NOT IN(%s)" + " UNION ALL " + " SELECT " + "DISTINCT " + "blockednumbers" + "." + "canonized_number" + " FROM " + "blockednumbers" + " WHERE " + String.format("%s LIKE ? AND %s NOT LIKE ?", new Object[] { "canonized_number", "canonized_number" }) + " AND " + "canonized_number" + " NOT IN(%s)";
  private String d = " UPDATE " + "messages" + " SET " + "user_id" + "=?" + " WHERE " + "user_id" + "=?";
  private String e = " UPDATE " + "messages_likes" + " SET " + "participant_number" + "=?" + " WHERE " + "participant_number" + "=?";
  private String f = " UPDATE " + "participants_info" + " SET " + "member_id" + "=?" + " , " + "viber_id" + "=?" + " WHERE " + "number" + "=?";
  private String h = " UPDATE " + "vibernumbers" + " SET " + "member_id" + "=?" + " , " + "viber_id" + "=?" + " WHERE " + "canonized_number" + "=?";
  private String i = " UPDATE " + "blockednumbers" + " SET " + "canonized_number" + "=?" + " WHERE " + "canonized_number" + "=?";
  private final String j = "idx_MESSAGES_number";
  private final String k = " CREATE INDEX IF NOT EXISTS " + "idx_MESSAGES_number" + " ON " + "messages" + " (" + "user_id" + ")";
  private final String l = " DROP INDEX IF EXISTS " + "idx_MESSAGES_number";
  private final String m = "idx_MESSAGES_LIKES_participant_number";
  private final String n = " CREATE INDEX IF NOT EXISTS " + "idx_MESSAGES_LIKES_participant_number" + " ON " + "messages_likes" + " (" + "participant_number" + ")";
  private final String o = " DROP INDEX IF EXISTS " + "idx_MESSAGES_LIKES_participant_number";
  private SQLiteStatement p;
  private SQLiteStatement q;
  private SQLiteStatement r;
  private SQLiteStatement s;
  private SQLiteStatement t;
  private Context u;

  b(Context paramContext)
  {
    this.u = paramContext;
  }

  private Map<String, String> a(String paramString, a parama)
  {
    Set localSet = e.b(paramString);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = localSet.iterator();
    while (localIterator.hasNext())
    {
      d.a locala = (d.a)localIterator.next();
      if ((parama == null) || (parama.a(locala)))
        localHashMap.put(locala.b(), (String)locala.c());
    }
    return localHashMap;
  }

  private void a(Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    if (paramMap1.size() > 0)
    {
      SQLiteStatement localSQLiteStatement1 = g();
      SQLiteStatement localSQLiteStatement2 = h();
      SQLiteStatement localSQLiteStatement3 = i();
      com.viber.provider.b localb = e();
      localb.a();
      localb.a(this.k);
      localb.a(this.n);
      while (true)
      {
        try
        {
          Iterator localIterator = paramMap1.entrySet().iterator();
          if (!localIterator.hasNext())
            break;
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          String[] arrayOfString1 = new String[2];
          arrayOfString1[0] = ((String)localEntry.getValue());
          arrayOfString1[1] = ((String)localEntry.getKey());
          str = (String)paramMap2.get(localEntry.getKey());
          String[] arrayOfString2 = new String[3];
          arrayOfString2[0] = ((String)localEntry.getValue());
          if (str != null)
          {
            arrayOfString2[1] = str;
            arrayOfString2[2] = ((String)localEntry.getKey());
            localSQLiteStatement1.bindAllArgsAsStrings(arrayOfString1);
            localSQLiteStatement1.executeUpdateDelete();
            localSQLiteStatement2.bindAllArgsAsStrings(arrayOfString1);
            localSQLiteStatement2.executeUpdateDelete();
            localSQLiteStatement3.bindAllArgsAsStrings(arrayOfString2);
            localSQLiteStatement3.executeUpdateDelete();
            continue;
          }
        }
        finally
        {
          localb.b();
        }
        String str = "";
      }
      localb.a(this.l);
      localb.a(this.o);
      localb.c();
      localb.b();
    }
  }

  private void a(Set<String> paramSet, com.viber.provider.b paramb, String paramString, String[] paramArrayOfString, ci<String> paramci)
  {
    Cursor localCursor = null;
    try
    {
      localCursor = paramb.a(paramString, paramArrayOfString);
      if ((localCursor != null) && (localCursor.moveToFirst()))
      {
        boolean bool;
        do
        {
          String str = localCursor.getString(0);
          if (paramci.apply(str))
            paramSet.add(str);
          bool = localCursor.moveToNext();
        }
        while (bool);
      }
      return;
    }
    finally
    {
      af.a(localCursor);
    }
  }

  private void b(Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    if (paramMap1.size() > 0)
    {
      Set localSet = paramMap1.entrySet();
      SQLiteStatement localSQLiteStatement1 = j();
      SQLiteStatement localSQLiteStatement2 = k();
      com.viber.provider.b localb = f();
      localb.a();
      while (true)
      {
        try
        {
          Iterator localIterator = localSet.iterator();
          if (!localIterator.hasNext())
            break;
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          String[] arrayOfString1 = new String[2];
          arrayOfString1[0] = ((String)localEntry.getValue());
          arrayOfString1[1] = ((String)localEntry.getKey());
          str = (String)paramMap2.get(localEntry.getKey());
          String[] arrayOfString2 = new String[3];
          arrayOfString2[0] = ((String)localEntry.getValue());
          if (str != null)
          {
            arrayOfString2[1] = str;
            arrayOfString2[2] = ((String)localEntry.getKey());
            localSQLiteStatement1.bindAllArgsAsStrings(arrayOfString2);
            localSQLiteStatement1.executeUpdateDelete();
            localSQLiteStatement2.bindAllArgsAsStrings(arrayOfString1);
            localSQLiteStatement2.executeUpdateDelete();
            continue;
          }
        }
        finally
        {
          localb.b();
        }
        String str = "";
      }
      localb.c();
      localb.b();
    }
  }

  private com.viber.provider.b e()
  {
    return d.a(this.u);
  }

  private com.viber.provider.b f()
  {
    return com.viber.provider.contacts.a.a.a(this.u);
  }

  private SQLiteStatement g()
  {
    if (this.p == null)
      this.p = e().b(this.d);
    return this.p;
  }

  private SQLiteStatement h()
  {
    if (this.q == null)
      this.q = e().b(this.e);
    return this.q;
  }

  private SQLiteStatement i()
  {
    if (this.r == null)
      this.r = e().b(this.f);
    return this.r;
  }

  private SQLiteStatement j()
  {
    if (this.s == null)
      this.s = f().b(this.h);
    return this.s;
  }

  private SQLiteStatement k()
  {
    if (this.t == null)
      this.t = f().b(this.i);
    return this.t;
  }

  void a()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator1 = e.a("member_id_migration").iterator();
    while (localIterator1.hasNext())
      localHashSet.add((String)localIterator1.next());
    String str = com.viber.voip.s.a.b(localHashSet);
    localHashSet.clear();
    c localc = new c(ce.l.matcher(""));
    a(localHashSet, e(), String.format(c, new Object[] { str, str, str }), com.viber.voip.s.a.a(b, 3), localc);
    a(localHashSet, f(), String.format(g, new Object[] { str, str }), com.viber.voip.s.a.a(b, 2), localc);
    if (localHashSet.size() > 0)
    {
      ArrayList localArrayList = new ArrayList(localHashSet.size());
      Iterator localIterator2 = localHashSet.iterator();
      while (localIterator2.hasNext())
        localArrayList.add(d.a.a("member_id_migration", (String)localIterator2.next(), null));
      e.a(localArrayList);
    }
  }

  void a(PhoneNumberToMidInfo[] paramArrayOfPhoneNumberToMidInfo)
  {
    if (paramArrayOfPhoneNumberToMidInfo.length > 0)
    {
      ArrayList localArrayList = new ArrayList(2 * paramArrayOfPhoneNumberToMidInfo.length);
      int i1 = paramArrayOfPhoneNumberToMidInfo.length;
      int i2 = 0;
      if (i2 < i1)
      {
        PhoneNumberToMidInfo localPhoneNumberToMidInfo = paramArrayOfPhoneNumberToMidInfo[i2];
        String str1 = localPhoneNumberToMidInfo.getPhoneNumber();
        String str2;
        if (localPhoneNumberToMidInfo.getViberId() == null)
        {
          str2 = "";
          label54: if (1 != localPhoneNumberToMidInfo.getStatus())
            break label120;
        }
        label120: for (String str3 = localPhoneNumberToMidInfo.getMemberId(); ; str3 = str1)
        {
          localArrayList.add(d.a.a("member_id_migration", str1, str3));
          localArrayList.add(d.a.a("viber_id_migration", str1, str2));
          i2++;
          break;
          str2 = localPhoneNumberToMidInfo.getViberId();
          break label54;
        }
      }
      e.a(localArrayList);
    }
  }

  String[] b()
  {
    Set localSet = a("member_id_migration", new a()
    {
      public boolean a(d.a paramAnonymousa)
      {
        return (paramAnonymousa.c() == null) || ("null".equals(paramAnonymousa.c()));
      }
    }).keySet();
    return (String[])localSet.toArray(new String[localSet.size()]);
  }

  void c()
  {
    Map localMap1 = a("member_id_migration", new a()
    {
      public boolean a(d.a paramAnonymousa)
      {
        return (paramAnonymousa.c() != null) && (!"null".equals(paramAnonymousa.c()));
      }
    });
    Map localMap2 = a("viber_id_migration", null);
    a(localMap1, localMap2);
    b(localMap1, localMap2);
  }

  void d()
  {
    e.e("spam_unknown_number");
    e.e("viber_id_migration");
    e.e("member_id_migration");
  }

  private static abstract interface a
  {
    public abstract boolean a(d.a parama);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.memberid.b
 * JD-Core Version:    0.6.2
 */