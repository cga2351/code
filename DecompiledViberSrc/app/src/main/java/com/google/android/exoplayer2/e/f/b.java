package com.google.android.exoplayer2.e.f;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import com.google.android.exoplayer2.g.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

final class b
{
  public final String a;
  public final String b;
  public final boolean c;
  public final long d;
  public final long e;
  public final e f;
  public final String g;
  public final String h;
  private final String[] i;
  private final HashMap<String, Integer> j;
  private final HashMap<String, Integer> k;
  private List<b> l;

  private b(String paramString1, String paramString2, long paramLong1, long paramLong2, e parame, String[] paramArrayOfString, String paramString3, String paramString4)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.h = paramString4;
    this.f = parame;
    this.i = paramArrayOfString;
    if (paramString2 != null);
    for (boolean bool = true; ; bool = false)
    {
      this.c = bool;
      this.d = paramLong1;
      this.e = paramLong2;
      this.g = ((String)a.a(paramString3));
      this.j = new HashMap();
      this.k = new HashMap();
      return;
    }
  }

  private SpannableStringBuilder a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    int m = paramSpannableStringBuilder.length();
    int n = 0;
    int i6;
    if (n < m)
    {
      if (paramSpannableStringBuilder.charAt(n) != ' ')
        break label295;
      for (int i5 = n + 1; (i5 < paramSpannableStringBuilder.length()) && (paramSpannableStringBuilder.charAt(i5) == ' '); i5++);
      i6 = i5 - (n + 1);
      if (i6 <= 0)
        break label295;
      paramSpannableStringBuilder.delete(n, n + i6);
    }
    label295: for (int i4 = m - i6; ; i4 = m)
    {
      n++;
      m = i4;
      break;
      if ((m > 0) && (paramSpannableStringBuilder.charAt(0) == ' '))
      {
        paramSpannableStringBuilder.delete(0, 1);
        m--;
      }
      int i1 = m;
      for (int i2 = 0; i2 < i1 - 1; i2++)
        if ((paramSpannableStringBuilder.charAt(i2) == '\n') && (paramSpannableStringBuilder.charAt(i2 + 1) == ' '))
        {
          paramSpannableStringBuilder.delete(i2 + 1, i2 + 2);
          i1--;
        }
      if ((i1 > 0) && (paramSpannableStringBuilder.charAt(i1 - 1) == ' '))
      {
        paramSpannableStringBuilder.delete(i1 - 1, i1);
        i1--;
      }
      for (int i3 = 0; i3 < i1 - 1; i3++)
        if ((paramSpannableStringBuilder.charAt(i3) == ' ') && (paramSpannableStringBuilder.charAt(i3 + 1) == '\n'))
        {
          paramSpannableStringBuilder.delete(i3, i3 + 1);
          i1--;
        }
      if ((i1 > 0) && (paramSpannableStringBuilder.charAt(i1 - 1) == '\n'))
        paramSpannableStringBuilder.delete(i1 - 1, i1);
      return paramSpannableStringBuilder;
    }
  }

  private static SpannableStringBuilder a(String paramString, Map<String, SpannableStringBuilder> paramMap)
  {
    if (!paramMap.containsKey(paramString))
      paramMap.put(paramString, new SpannableStringBuilder());
    return (SpannableStringBuilder)paramMap.get(paramString);
  }

  public static b a(String paramString)
  {
    return new b(null, d.a(paramString), -9223372036854775807L, -9223372036854775807L, null, null, "", null);
  }

  public static b a(String paramString1, long paramLong1, long paramLong2, e parame, String[] paramArrayOfString, String paramString2, String paramString3)
  {
    return new b(paramString1, null, paramLong1, paramLong2, parame, paramArrayOfString, paramString2, paramString3);
  }

  private void a(long paramLong, String paramString, List<Pair<String, String>> paramList)
  {
    if ("".equals(this.g))
    {
      if ((!a(paramLong)) || (!"div".equals(this.a)) || (this.h == null))
        break label68;
      paramList.add(new Pair(paramString, this.h));
    }
    while (true)
    {
      return;
      paramString = this.g;
      break;
      label68: for (int m = 0; m < a(); m++)
        a(m).a(paramLong, paramString, paramList);
    }
  }

  private void a(long paramLong, Map<String, e> paramMap, Map<String, SpannableStringBuilder> paramMap1)
  {
    if (!a(paramLong));
    while (true)
    {
      return;
      Iterator localIterator = this.k.entrySet().iterator();
      boolean bool = localIterator.hasNext();
      int m = 0;
      if (bool)
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str = (String)localEntry.getKey();
        if (this.j.containsKey(str));
        for (int n = ((Integer)this.j.get(str)).intValue(); ; n = 0)
        {
          int i1 = ((Integer)localEntry.getValue()).intValue();
          if (n == i1)
            break;
          a(paramMap, (SpannableStringBuilder)paramMap1.get(str), n, i1);
          break;
        }
      }
      while (m < a())
      {
        a(m).a(paramLong, paramMap, paramMap1);
        m++;
      }
    }
  }

  private void a(long paramLong, boolean paramBoolean, String paramString, Map<String, SpannableStringBuilder> paramMap)
  {
    this.j.clear();
    this.k.clear();
    if ("metadata".equals(this.a));
    while (true)
    {
      return;
      if ("".equals(this.g));
      for (String str = paramString; (this.c) && (paramBoolean); str = this.g)
      {
        a(str, paramMap).append(this.b);
        return;
      }
      if (("br".equals(this.a)) && (paramBoolean))
      {
        a(str, paramMap).append('\n');
        return;
      }
      if (a(paramLong))
      {
        Iterator localIterator1 = paramMap.entrySet().iterator();
        while (localIterator1.hasNext())
        {
          Map.Entry localEntry2 = (Map.Entry)localIterator1.next();
          this.j.put(localEntry2.getKey(), Integer.valueOf(((SpannableStringBuilder)localEntry2.getValue()).length()));
        }
        boolean bool1 = "p".equals(this.a);
        int m = 0;
        if (m < a())
        {
          b localb = a(m);
          if ((paramBoolean) || (bool1));
          for (boolean bool2 = true; ; bool2 = false)
          {
            localb.a(paramLong, bool2, str, paramMap);
            m++;
            break;
          }
        }
        if (bool1)
          d.a(a(str, paramMap));
        Iterator localIterator2 = paramMap.entrySet().iterator();
        while (localIterator2.hasNext())
        {
          Map.Entry localEntry1 = (Map.Entry)localIterator2.next();
          this.k.put(localEntry1.getKey(), Integer.valueOf(((SpannableStringBuilder)localEntry1.getValue()).length()));
        }
      }
    }
  }

  private void a(Map<String, e> paramMap, SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2)
  {
    e locale = d.a(this.f, this.i, paramMap);
    if (locale != null)
      d.a(paramSpannableStringBuilder, paramInt1, paramInt2, locale);
  }

  private void a(TreeSet<Long> paramTreeSet, boolean paramBoolean)
  {
    boolean bool1 = "p".equals(this.a);
    boolean bool2 = "div".equals(this.a);
    if ((paramBoolean) || (bool1) || ((bool2) && (this.h != null)))
    {
      if (this.d != -9223372036854775807L)
        paramTreeSet.add(Long.valueOf(this.d));
      if (this.e != -9223372036854775807L)
        paramTreeSet.add(Long.valueOf(this.e));
    }
    if (this.l == null)
      return;
    int m = 0;
    label98: b localb;
    if (m < this.l.size())
    {
      localb = (b)this.l.get(m);
      if ((!paramBoolean) && (!bool1))
        break label153;
    }
    label153: for (boolean bool3 = true; ; bool3 = false)
    {
      localb.a(paramTreeSet, bool3);
      m++;
      break label98;
      break;
    }
  }

  public int a()
  {
    if (this.l == null)
      return 0;
    return this.l.size();
  }

  public b a(int paramInt)
  {
    if (this.l == null)
      throw new IndexOutOfBoundsException();
    return (b)this.l.get(paramInt);
  }

  public List<com.google.android.exoplayer2.e.b> a(long paramLong, Map<String, e> paramMap, Map<String, c> paramMap1, Map<String, String> paramMap2)
  {
    ArrayList localArrayList1 = new ArrayList();
    a(paramLong, this.g, localArrayList1);
    TreeMap localTreeMap = new TreeMap();
    a(paramLong, false, this.g, localTreeMap);
    a(paramLong, paramMap, localTreeMap);
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator1 = localArrayList1.iterator();
    while (localIterator1.hasNext())
    {
      Pair localPair = (Pair)localIterator1.next();
      String str = (String)paramMap2.get(localPair.second);
      if (str != null)
      {
        byte[] arrayOfByte = Base64.decode(str, 0);
        Bitmap localBitmap = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length);
        c localc2 = (c)paramMap1.get(localPair.first);
        localArrayList2.add(new com.google.android.exoplayer2.e.b(localBitmap, localc2.b, 1, localc2.c, localc2.e, localc2.f, 1.4E-45F));
      }
    }
    Iterator localIterator2 = localTreeMap.entrySet().iterator();
    while (localIterator2.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator2.next();
      c localc1 = (c)paramMap1.get(localEntry.getKey());
      localArrayList2.add(new com.google.android.exoplayer2.e.b(a((SpannableStringBuilder)localEntry.getValue()), null, localc1.c, localc1.d, localc1.e, localc1.b, -2147483648, localc1.f, localc1.g, localc1.h));
    }
    return localArrayList2;
  }

  public void a(b paramb)
  {
    if (this.l == null)
      this.l = new ArrayList();
    this.l.add(paramb);
  }

  public boolean a(long paramLong)
  {
    return ((this.d == -9223372036854775807L) && (this.e == -9223372036854775807L)) || ((this.d <= paramLong) && (this.e == -9223372036854775807L)) || ((this.d == -9223372036854775807L) && (paramLong < this.e)) || ((this.d <= paramLong) && (paramLong < this.e));
  }

  public long[] b()
  {
    TreeSet localTreeSet = new TreeSet();
    a(localTreeSet, false);
    long[] arrayOfLong = new long[localTreeSet.size()];
    Iterator localIterator = localTreeSet.iterator();
    int n;
    for (int m = 0; localIterator.hasNext(); m = n)
    {
      long l1 = ((Long)localIterator.next()).longValue();
      n = m + 1;
      arrayOfLong[m] = l1;
    }
    return arrayOfLong;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.e.f.b
 * JD-Core Version:    0.6.2
 */