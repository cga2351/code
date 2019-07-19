package android.arch.persistence.room.b;

import android.database.Cursor;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class b
{
  public final String a;
  public final Map<String, a> b;
  public final Set<b> c;
  public final Set<d> d;

  public b(String paramString, Map<String, a> paramMap, Set<b> paramSet, Set<d> paramSet1)
  {
    this.a = paramString;
    this.b = Collections.unmodifiableMap(paramMap);
    this.c = Collections.unmodifiableSet(paramSet);
    if (paramSet1 == null);
    for (Set localSet = null; ; localSet = Collections.unmodifiableSet(paramSet1))
    {
      this.d = localSet;
      return;
    }
  }

  private static d a(android.arch.persistence.a.b paramb, String paramString, boolean paramBoolean)
  {
    Cursor localCursor = paramb.b("PRAGMA index_xinfo(`" + paramString + "`)");
    TreeMap localTreeMap;
    try
    {
      int i = localCursor.getColumnIndex("seqno");
      int j = localCursor.getColumnIndex("cid");
      int k = localCursor.getColumnIndex("name");
      if ((i == -1) || (j == -1) || (k == -1))
        return null;
      localTreeMap = new TreeMap();
      while (localCursor.moveToNext())
        if (localCursor.getInt(j) >= 0)
        {
          int m = localCursor.getInt(i);
          String str = localCursor.getString(k);
          localTreeMap.put(Integer.valueOf(m), str);
        }
    }
    finally
    {
      localCursor.close();
    }
    ArrayList localArrayList = new ArrayList(localTreeMap.size());
    localArrayList.addAll(localTreeMap.values());
    d locald = new d(paramString, paramBoolean, localArrayList);
    localCursor.close();
    return locald;
  }

  public static b a(android.arch.persistence.a.b paramb, String paramString)
  {
    return new b(paramString, c(paramb, paramString), b(paramb, paramString), d(paramb, paramString));
  }

  private static List<c> a(Cursor paramCursor)
  {
    int i = paramCursor.getColumnIndex("id");
    int j = paramCursor.getColumnIndex("seq");
    int k = paramCursor.getColumnIndex("from");
    int m = paramCursor.getColumnIndex("to");
    int n = paramCursor.getCount();
    ArrayList localArrayList = new ArrayList();
    for (int i1 = 0; i1 < n; i1++)
    {
      paramCursor.moveToPosition(i1);
      localArrayList.add(new c(paramCursor.getInt(i), paramCursor.getInt(j), paramCursor.getString(k), paramCursor.getString(m)));
    }
    Collections.sort(localArrayList);
    return localArrayList;
  }

  private static Set<b> b(android.arch.persistence.a.b paramb, String paramString)
  {
    HashSet localHashSet = new HashSet();
    Cursor localCursor = paramb.b("PRAGMA foreign_key_list(`" + paramString + "`)");
    while (true)
    {
      int k;
      int m;
      int n;
      int i2;
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      try
      {
        int i = localCursor.getColumnIndex("id");
        int j = localCursor.getColumnIndex("seq");
        k = localCursor.getColumnIndex("table");
        m = localCursor.getColumnIndex("on_delete");
        n = localCursor.getColumnIndex("on_update");
        List localList = a(localCursor);
        int i1 = localCursor.getCount();
        i2 = 0;
        if (i2 >= i1)
          break label290;
        localCursor.moveToPosition(i2);
        if (localCursor.getInt(j) != 0)
          break label298;
        int i3 = localCursor.getInt(i);
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        Iterator localIterator = localList.iterator();
        if (localIterator.hasNext())
        {
          c localc = (c)localIterator.next();
          if (localc.a != i3)
            continue;
          localArrayList1.add(localc.c);
          localArrayList2.add(localc.d);
          continue;
        }
      }
      finally
      {
        localCursor.close();
      }
      localHashSet.add(new b(localCursor.getString(k), localCursor.getString(m), localCursor.getString(n), localArrayList1, localArrayList2));
      break label298;
      label290: localCursor.close();
      return localHashSet;
      label298: i2++;
    }
  }

  private static Map<String, a> c(android.arch.persistence.a.b paramb, String paramString)
  {
    Cursor localCursor = paramb.b("PRAGMA table_info(`" + paramString + "`)");
    HashMap localHashMap = new HashMap();
    while (true)
    {
      try
      {
        if (localCursor.getColumnCount() <= 0)
          break;
        int i = localCursor.getColumnIndex("name");
        int j = localCursor.getColumnIndex("type");
        int k = localCursor.getColumnIndex("notnull");
        int m = localCursor.getColumnIndex("pk");
        if (!localCursor.moveToNext())
          break;
        String str1 = localCursor.getString(i);
        String str2 = localCursor.getString(j);
        if (localCursor.getInt(k) != 0)
        {
          bool = true;
          localHashMap.put(str1, new a(str1, str2, bool, localCursor.getInt(m)));
          continue;
        }
      }
      finally
      {
        localCursor.close();
      }
      boolean bool = false;
    }
    localCursor.close();
    return localHashMap;
  }

  private static Set<d> d(android.arch.persistence.a.b paramb, String paramString)
  {
    Cursor localCursor = paramb.b("PRAGMA index_list(`" + paramString + "`)");
    HashSet localHashSet;
    try
    {
      int i = localCursor.getColumnIndex("name");
      int j = localCursor.getColumnIndex("origin");
      int k = localCursor.getColumnIndex("unique");
      if ((i == -1) || (j == -1) || (k == -1))
        return null;
      localHashSet = new HashSet();
      while (localCursor.moveToNext())
        if ("c".equals(localCursor.getString(j)))
        {
          String str = localCursor.getString(i);
          if (localCursor.getInt(k) == 1);
          d locald;
          for (boolean bool = true; ; bool = false)
          {
            locald = a(paramb, str, bool);
            if (locald != null)
              break;
            return null;
          }
          localHashSet.add(locald);
        }
    }
    finally
    {
      localCursor.close();
    }
    localCursor.close();
    return localHashSet;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    b localb;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localb = (b)paramObject;
      if (this.a != null)
      {
        if (this.a.equals(localb.a));
      }
      else
        while (localb.a != null)
          return false;
      if (this.b != null)
      {
        if (this.b.equals(localb.b));
      }
      else
        while (localb.b != null)
          return false;
      if (this.c != null)
      {
        if (this.c.equals(localb.c));
      }
      else
        while (localb.c != null)
          return false;
    }
    while ((this.d == null) || (localb.d == null));
    return this.d.equals(localb.d);
  }

  public int hashCode()
  {
    int i;
    int j;
    if (this.a != null)
    {
      i = this.a.hashCode();
      j = i * 31;
      if (this.b == null)
        break label81;
    }
    label81: for (int k = this.b.hashCode(); ; k = 0)
    {
      int m = 31 * (k + j);
      Set localSet = this.c;
      int n = 0;
      if (localSet != null)
        n = this.c.hashCode();
      return m + n;
      i = 0;
      break;
    }
  }

  public String toString()
  {
    return "TableInfo{name='" + this.a + '\'' + ", columns=" + this.b + ", foreignKeys=" + this.c + ", indices=" + this.d + '}';
  }

  public static class a
  {
    public final String a;
    public final String b;
    public final int c;
    public final boolean d;
    public final int e;

    public a(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.d = paramBoolean;
      this.e = paramInt;
      this.c = a(paramString2);
    }

    private static int a(String paramString)
    {
      if (paramString == null);
      String str;
      do
      {
        return 5;
        str = paramString.toUpperCase(Locale.US);
        if (str.contains("INT"))
          return 3;
        if ((str.contains("CHAR")) || (str.contains("CLOB")) || (str.contains("TEXT")))
          return 2;
      }
      while (str.contains("BLOB"));
      if ((str.contains("REAL")) || (str.contains("FLOA")) || (str.contains("DOUB")))
        return 4;
      return 1;
    }

    public boolean a()
    {
      return this.e > 0;
    }

    public boolean equals(Object paramObject)
    {
      boolean bool1 = true;
      boolean bool2;
      if (this == paramObject)
        bool2 = bool1;
      a locala;
      boolean bool4;
      boolean bool5;
      do
      {
        boolean bool3;
        do
        {
          int i;
          int j;
          do
          {
            Class localClass1;
            Class localClass2;
            do
            {
              do
              {
                return bool2;
                bool2 = false;
              }
              while (paramObject == null);
              localClass1 = getClass();
              localClass2 = paramObject.getClass();
              bool2 = false;
            }
            while (localClass1 != localClass2);
            locala = (a)paramObject;
            if (Build.VERSION.SDK_INT < 20)
              break;
            i = this.e;
            j = locala.e;
            bool2 = false;
          }
          while (i != j);
          bool3 = this.a.equals(locala.a);
          bool2 = false;
        }
        while (!bool3);
        bool4 = this.d;
        bool5 = locala.d;
        bool2 = false;
      }
      while (bool4 != bool5);
      if (this.c == locala.c);
      while (true)
      {
        return bool1;
        if (a() == locala.a())
          break;
        return false;
        bool1 = false;
      }
    }

    public int hashCode()
    {
      int i = 31 * (31 * this.a.hashCode() + this.c);
      if (this.d);
      for (int j = 1231; ; j = 1237)
        return 31 * (j + i) + this.e;
    }

    public String toString()
    {
      return "Column{name='" + this.a + '\'' + ", type='" + this.b + '\'' + ", affinity='" + this.c + '\'' + ", notNull=" + this.d + ", primaryKeyPosition=" + this.e + '}';
    }
  }

  public static class b
  {
    public final String a;
    public final String b;
    public final String c;
    public final List<String> d;
    public final List<String> e;

    public b(String paramString1, String paramString2, String paramString3, List<String> paramList1, List<String> paramList2)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramString3;
      this.d = Collections.unmodifiableList(paramList1);
      this.e = Collections.unmodifiableList(paramList2);
    }

    public boolean equals(Object paramObject)
    {
      boolean bool1;
      if (this == paramObject)
        bool1 = true;
      b localb;
      boolean bool5;
      do
      {
        boolean bool4;
        do
        {
          boolean bool3;
          do
          {
            boolean bool2;
            do
            {
              Class localClass1;
              Class localClass2;
              do
              {
                do
                {
                  return bool1;
                  bool1 = false;
                }
                while (paramObject == null);
                localClass1 = getClass();
                localClass2 = paramObject.getClass();
                bool1 = false;
              }
              while (localClass1 != localClass2);
              localb = (b)paramObject;
              bool2 = this.a.equals(localb.a);
              bool1 = false;
            }
            while (!bool2);
            bool3 = this.b.equals(localb.b);
            bool1 = false;
          }
          while (!bool3);
          bool4 = this.c.equals(localb.c);
          bool1 = false;
        }
        while (!bool4);
        bool5 = this.d.equals(localb.d);
        bool1 = false;
      }
      while (!bool5);
      return this.e.equals(localb.e);
    }

    public int hashCode()
    {
      return 31 * (31 * (31 * (31 * this.a.hashCode() + this.b.hashCode()) + this.c.hashCode()) + this.d.hashCode()) + this.e.hashCode();
    }

    public String toString()
    {
      return "ForeignKey{referenceTable='" + this.a + '\'' + ", onDelete='" + this.b + '\'' + ", onUpdate='" + this.c + '\'' + ", columnNames=" + this.d + ", referenceColumnNames=" + this.e + '}';
    }
  }

  static class c
    implements Comparable<c>
  {
    final int a;
    final int b;
    final String c;
    final String d;

    c(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramString1;
      this.d = paramString2;
    }

    public int a(c paramc)
    {
      int i = this.a - paramc.a;
      if (i == 0)
        i = this.b - paramc.b;
      return i;
    }
  }

  public static class d
  {
    public final String a;
    public final boolean b;
    public final List<String> c;

    public d(String paramString, boolean paramBoolean, List<String> paramList)
    {
      this.a = paramString;
      this.b = paramBoolean;
      this.c = paramList;
    }

    public boolean equals(Object paramObject)
    {
      boolean bool1;
      if (this == paramObject)
        bool1 = true;
      d locald;
      boolean bool4;
      do
      {
        boolean bool2;
        boolean bool3;
        do
        {
          Class localClass1;
          Class localClass2;
          do
          {
            do
            {
              return bool1;
              bool1 = false;
            }
            while (paramObject == null);
            localClass1 = getClass();
            localClass2 = paramObject.getClass();
            bool1 = false;
          }
          while (localClass1 != localClass2);
          locald = (d)paramObject;
          bool2 = this.b;
          bool3 = locald.b;
          bool1 = false;
        }
        while (bool2 != bool3);
        bool4 = this.c.equals(locald.c);
        bool1 = false;
      }
      while (!bool4);
      if (this.a.startsWith("index_"))
        return locald.a.startsWith("index_");
      return this.a.equals(locald.a);
    }

    public int hashCode()
    {
      int i;
      int j;
      if (this.a.startsWith("index_"))
      {
        i = "index_".hashCode();
        j = i * 31;
        if (!this.b)
          break label60;
      }
      label60: for (int k = 1; ; k = 0)
      {
        return 31 * (k + j) + this.c.hashCode();
        i = this.a.hashCode();
        break;
      }
    }

    public String toString()
    {
      return "Index{name='" + this.a + '\'' + ", unique=" + this.b + ", columns=" + this.c + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.arch.persistence.room.b.b
 * JD-Core Version:    0.6.2
 */