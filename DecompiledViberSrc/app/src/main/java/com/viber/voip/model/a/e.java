package com.viber.voip.model.a;

import android.content.Context;
import android.text.TextUtils;
import com.esotericsoftware.kryo.Kryo;
import com.snappydb.DB;
import com.snappydb.DBFactory;
import com.snappydb.SnappydbException;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.ay;
import com.viber.voip.util.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class e extends d
{
  private static final Logger a = ViberEnv.getLogger();
  private final DB b;

  e(Context paramContext)
    throws SnappydbException
  {
    try
    {
      this.b = DBFactory.open(paramContext, "KeyStorage", new Kryo[0]);
      return;
    }
    catch (SnappydbException localSnappydbException)
    {
      d.ay.a.a(b.b());
      throw localSnappydbException;
    }
  }

  private void a(SnappydbException paramSnappydbException)
  {
    d.ay.a.a(b.b());
    throw new RuntimeException("SnappyDb error", paramSnappydbException);
  }

  private String b(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
      return "";
    return paramInt + "<=>" + paramString;
  }

  private String c(String paramString, int paramInt)
  {
    String[] arrayOfString = j(paramString);
    if (arrayOfString == null);
    while (Integer.valueOf(arrayOfString[0]).intValue() != paramInt)
      return null;
    return arrayOfString[1];
  }

  private Object d(String paramString, int paramInt)
  {
    switch (paramInt)
    {
    default:
      paramString = null;
    case 0:
      return paramString;
    case 1:
    case 2:
    case 3:
    }
    try
    {
      return Long.valueOf(Long.parseLong(paramString));
      return Integer.valueOf(Integer.parseInt(paramString));
      Boolean localBoolean = Boolean.valueOf(Boolean.parseBoolean(paramString));
      return localBoolean;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return null;
  }

  // ERROR //
  private List<String> d()
  {
    // Byte code:
    //   0: new 132	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 133	java/util/ArrayList:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 36	com/viber/voip/model/a/e:b	Lcom/snappydb/DB;
    //   12: astore_2
    //   13: aload_2
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 36	com/viber/voip/model/a/e:b	Lcom/snappydb/DB;
    //   19: invokeinterface 139 1 0
    //   24: astore 5
    //   26: aload 5
    //   28: invokeinterface 145 1 0
    //   33: ifeq +73 -> 106
    //   36: aload_1
    //   37: aload 5
    //   39: sipush 256
    //   42: invokeinterface 149 2 0
    //   47: invokestatic 155	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   50: invokeinterface 161 2 0
    //   55: pop
    //   56: goto -30 -> 26
    //   59: astore 9
    //   61: aload 9
    //   63: athrow
    //   64: astore 10
    //   66: aload 9
    //   68: astore 7
    //   70: aload 10
    //   72: astore 6
    //   74: aload 5
    //   76: ifnull +15 -> 91
    //   79: aload 7
    //   81: ifnull +82 -> 163
    //   84: aload 5
    //   86: invokeinterface 164 1 0
    //   91: aload 6
    //   93: athrow
    //   94: astore 4
    //   96: aload_0
    //   97: aload 4
    //   99: invokespecial 166	com/viber/voip/model/a/e:a	(Lcom/snappydb/SnappydbException;)V
    //   102: aload_2
    //   103: monitorexit
    //   104: aload_1
    //   105: areturn
    //   106: aload 5
    //   108: ifnull -6 -> 102
    //   111: iconst_0
    //   112: ifeq +29 -> 141
    //   115: aload 5
    //   117: invokeinterface 164 1 0
    //   122: goto -20 -> 102
    //   125: astore 11
    //   127: aconst_null
    //   128: aload 11
    //   130: invokevirtual 170	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   133: goto -31 -> 102
    //   136: astore_3
    //   137: aload_2
    //   138: monitorexit
    //   139: aload_3
    //   140: athrow
    //   141: aload 5
    //   143: invokeinterface 164 1 0
    //   148: goto -46 -> 102
    //   151: astore 8
    //   153: aload 7
    //   155: aload 8
    //   157: invokevirtual 170	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   160: goto -69 -> 91
    //   163: aload 5
    //   165: invokeinterface 164 1 0
    //   170: goto -79 -> 91
    //   173: astore 6
    //   175: aconst_null
    //   176: astore 7
    //   178: goto -104 -> 74
    //
    // Exception table:
    //   from	to	target	type
    //   26	56	59	java/lang/Throwable
    //   61	64	64	finally
    //   15	26	94	com/snappydb/SnappydbException
    //   84	91	94	com/snappydb/SnappydbException
    //   91	94	94	com/snappydb/SnappydbException
    //   115	122	94	com/snappydb/SnappydbException
    //   127	133	94	com/snappydb/SnappydbException
    //   141	148	94	com/snappydb/SnappydbException
    //   153	160	94	com/snappydb/SnappydbException
    //   163	170	94	com/snappydb/SnappydbException
    //   115	122	125	java/lang/Throwable
    //   15	26	136	finally
    //   84	91	136	finally
    //   91	94	136	finally
    //   96	102	136	finally
    //   102	104	136	finally
    //   115	122	136	finally
    //   127	133	136	finally
    //   137	139	136	finally
    //   141	148	136	finally
    //   153	160	136	finally
    //   163	170	136	finally
    //   84	91	151	java/lang/Throwable
    //   26	56	173	finally
  }

  private int e(List<String> paramList)
  {
    int i = 0;
    while (true)
    {
      synchronized (this.b)
      {
        try
        {
          Iterator localIterator = paramList.iterator();
          if (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (!this.b.exists(str))
              break label94;
            this.b.del(str);
            j = i + 1;
            i = j;
            continue;
          }
        }
        catch (SnappydbException localSnappydbException)
        {
          a(localSnappydbException);
          return i;
        }
      }
      label94: int j = i;
    }
  }

  private String g(String paramString1, String paramString2)
  {
    return paramString1 + "<=>" + paramString2;
  }

  private String[] j(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    return paramString.split("<=>");
  }

  private String[] k(String paramString)
  {
    return paramString.split("<=>");
  }

  private String[] l(String paramString)
  {
    try
    {
      synchronized (this.b)
      {
        String[] arrayOfString = this.b.findKeys(paramString);
        return arrayOfString;
      }
    }
    catch (SnappydbException localSnappydbException)
    {
      a(localSnappydbException);
    }
    return null;
  }

  private String m(String paramString)
  {
    String[] arrayOfString = j(n(paramString));
    if (arrayOfString == null)
      return null;
    return arrayOfString[1];
  }

  private String n(String paramString)
  {
    try
    {
      if (!this.b.exists(paramString))
        return null;
      String str = this.b.get(paramString);
      return str;
    }
    catch (SnappydbException localSnappydbException)
    {
      a(localSnappydbException);
    }
    return null;
  }

  private d.a o(String paramString)
  {
    String[] arrayOfString1 = k(paramString);
    String[] arrayOfString2 = j(n(paramString));
    if (arrayOfString2 == null)
      return null;
    int i = Integer.valueOf(arrayOfString2[0]).intValue();
    Object localObject = d(arrayOfString2[1], i);
    return new d.a(arrayOfString1[0], arrayOfString1[1], localObject, i);
  }

  public int a(String paramString, Long[] paramArrayOfLong)
  {
    int i = 0;
    if (n.a(paramArrayOfLong))
      return 0;
    synchronized (this.b)
    {
      ArrayList localArrayList = new ArrayList(paramArrayOfLong.length);
      int j = paramArrayOfLong.length;
      while (i < j)
      {
        localArrayList.add(g(paramArrayOfLong[i].toString(), paramString));
        i++;
      }
      int k = e(localArrayList);
      return k;
    }
  }

  public int a(String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
      return 0;
    synchronized (this.b)
    {
      ArrayList localArrayList = new ArrayList(paramArrayOfString.length);
      int j = paramArrayOfString.length;
      while (i < j)
      {
        localArrayList.add(g(paramString, paramArrayOfString[i]));
        i++;
      }
      int k = e(localArrayList);
      return k;
    }
  }

  Object a(String paramString1, String paramString2, int paramInt)
  {
    String str = c(n(g(paramString1, paramString2)), paramInt);
    if (str == null)
      return null;
    return d(str, paramInt);
  }

  public List<String> a(String paramString1, String paramString2)
  {
    ArrayList localArrayList;
    synchronized (this.b)
    {
      List localList = d();
      localArrayList = new ArrayList(localList.size());
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        String[] arrayOfString = k(str);
        if ((paramString1.equals(arrayOfString[1])) && (paramString2.equals(m(str))))
          localArrayList.add(arrayOfString[0]);
      }
    }
    return localArrayList;
  }

  public Set<String> a(String paramString)
  {
    HashSet localHashSet = new HashSet();
    String[] arrayOfString = l(paramString);
    if (!n.a(arrayOfString))
    {
      int i = arrayOfString.length;
      for (int j = 0; j < i; j++)
        localHashSet.add(k(arrayOfString[j])[1]);
    }
    return localHashSet;
  }

  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    try
    {
      synchronized (this.b)
      {
        this.b.put(g(paramString1, paramString2), b(paramString3, paramInt));
        return;
      }
    }
    catch (SnappydbException localSnappydbException)
    {
      a(localSnappydbException);
    }
  }

  public int b()
  {
    List localList;
    synchronized (this.b)
    {
      localList = d();
      if (localList.size() > 0)
      {
        Iterator localIterator = localList.iterator();
        while (true)
          if (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            try
            {
              this.b.del(str);
            }
            catch (SnappydbException localSnappydbException)
            {
              a(localSnappydbException);
            }
          }
      }
    }
    int i = localList.size();
    return i;
  }

  public Set<d.a> b(String paramString)
  {
    while (true)
    {
      HashSet localHashSet;
      int k;
      synchronized (this.b)
      {
        String[] arrayOfString1 = l(paramString);
        localHashSet = null;
        if (arrayOfString1 != null)
        {
          int i = arrayOfString1.length;
          localHashSet = null;
          if (i > 0)
          {
            localHashSet = new HashSet(arrayOfString1.length);
            int j = arrayOfString1.length;
            k = 0;
            if (k < j)
            {
              String str = arrayOfString1[k];
              String[] arrayOfString2 = k(str);
              String[] arrayOfString3 = j(n(str));
              if (arrayOfString3 == null)
                break label174;
              int m = Integer.valueOf(arrayOfString3[0]).intValue();
              Object localObject2 = d(arrayOfString3[1], m);
              localHashSet.add(new d.a(arrayOfString2[0], arrayOfString2[1], localObject2, m));
            }
          }
        }
      }
      if (localHashSet == null)
        localHashSet = new HashSet(0);
      return localHashSet;
      label174: k++;
    }
  }

  protected void b(List<d.a> paramList)
  {
    synchronized (this.b)
    {
      super.b(paramList);
      return;
    }
  }

  public int c(String paramString)
  {
    String[] arrayOfString = l(paramString);
    int i = 0;
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      i = 0;
      if (j <= 0);
    }
    synchronized (this.b)
    {
      try
      {
        int k = arrayOfString.length;
        while (i < k)
        {
          String str = arrayOfString[i];
          this.b.del(str);
          i++;
        }
      }
      catch (SnappydbException localSnappydbException)
      {
        a(localSnappydbException);
        i = arrayOfString.length;
      }
      return i;
    }
  }

  public List<d.a> d(String paramString)
  {
    String[] arrayOfString1;
    Object localObject;
    int j;
    int k;
    try
    {
      String[] arrayOfString2 = this.b.findKeys(paramString);
      arrayOfString1 = arrayOfString2;
      localObject = null;
      if (arrayOfString1 != null)
      {
        int i = arrayOfString1.length;
        localObject = null;
        if (i != 0);
      }
      else
      {
        return localObject;
      }
    }
    catch (SnappydbException localSnappydbException)
    {
      while (true)
      {
        a(localSnappydbException);
        arrayOfString1 = null;
      }
      localObject = new ArrayList(arrayOfString1.length);
      j = arrayOfString1.length;
      k = 0;
    }
    while (k < j)
    {
      d.a locala = o(arrayOfString1[k]);
      if (locala != null)
        ((List)localObject).add(locala);
      k++;
    }
  }

  protected void d(List<d.a> paramList)
  {
    synchronized (this.b)
    {
      super.d(paramList);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.model.a.e
 * JD-Core Version:    0.6.2
 */