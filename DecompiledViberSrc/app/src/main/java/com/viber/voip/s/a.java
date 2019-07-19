package com.viber.voip.s;

import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.model.d;
import com.viber.voip.model.entity.f;
import com.viber.voip.model.entity.s;
import com.viber.voip.util.LongSparseSet;
import com.viber.voip.util.n;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class a
{
  private static final Logger a = ViberEnv.getLogger();

  public static String a(LongSparseSet paramLongSparseSet)
  {
    if ((paramLongSparseSet == null) || (paramLongSparseSet.size() == 0))
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int j = paramLongSparseSet.size();
    while (i < j)
    {
      if (localStringBuilder.length() > 0)
        localStringBuilder.append(',');
      localStringBuilder.append(paramLongSparseSet.get(i));
      i++;
    }
    return localStringBuilder.toString();
  }

  public static String a(String paramString, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
      return " * ";
    String str1 = paramString + ".";
    String str2 = ", " + paramString + ".";
    StringBuilder localStringBuilder = new StringBuilder(str1.length() + 30 * paramArrayOfString.length);
    int i = 0;
    int j = paramArrayOfString.length;
    if (i < j)
    {
      if (localStringBuilder.length() > 0)
        localStringBuilder.append(str2);
      while (true)
      {
        localStringBuilder.append(paramArrayOfString[i]);
        i++;
        break;
        localStringBuilder.append(str1);
      }
    }
    return localStringBuilder.toString();
  }

  public static String a(Collection<Long> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.size() == 0))
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      if (localStringBuilder.length() > 0)
        localStringBuilder.append(',');
      localStringBuilder.append('\'').append(l).append('\'');
    }
    return localStringBuilder.toString();
  }

  public static String a(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
      return "";
    return TextUtils.join(",", n.a(paramArrayOfInt));
  }

  public static String a(long[] paramArrayOfLong)
  {
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length == 0))
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int j = paramArrayOfLong.length;
    while (i < j)
    {
      Long localLong = Long.valueOf(paramArrayOfLong[i]);
      if (localStringBuilder.length() > 0)
        localStringBuilder.append(',');
      localStringBuilder.append(localLong);
      i++;
    }
    return localStringBuilder.toString();
  }

  public static String a(d[] paramArrayOfd)
  {
    if ((paramArrayOfd == null) || (paramArrayOfd.length == 0))
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int j = paramArrayOfd.length;
    if (i < j)
    {
      if (paramArrayOfd[i] == null);
      while (true)
      {
        i++;
        break;
        Long localLong = Long.valueOf(paramArrayOfd[i].getId());
        if (localStringBuilder.length() > 0)
          localStringBuilder.append(',');
        localStringBuilder.append(localLong);
      }
    }
    return localStringBuilder.toString();
  }

  public static String a(Long[] paramArrayOfLong)
  {
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length == 0))
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int j = paramArrayOfLong.length;
    while (i < j)
    {
      Long localLong = paramArrayOfLong[i];
      if (localStringBuilder.length() > 0)
        localStringBuilder.append(',');
      localStringBuilder.append(localLong);
      i++;
    }
    return localStringBuilder.toString();
  }

  public static String a(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
      return "";
    StringBuilder localStringBuilder = new StringBuilder(36 * paramArrayOfString.length);
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      String str = paramArrayOfString[j];
      if (localStringBuilder.length() > 0)
        localStringBuilder.append(',');
      a(localStringBuilder, str);
    }
    return localStringBuilder.toString();
  }

  public static StringBuilder a(String paramString, String[] paramArrayOfString, StringBuilder paramStringBuilder)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      paramStringBuilder.append(" * ");
      return paramStringBuilder;
    }
    String str1 = paramString + ".";
    String str2 = ", " + paramString + ".";
    int j = paramArrayOfString.length;
    int k = 0;
    label74: if (k < j)
    {
      if (i == 0)
        break label107;
      paramStringBuilder.append(str2);
    }
    while (true)
    {
      paramStringBuilder.append(paramArrayOfString[k]);
      k++;
      break label74;
      break;
      label107: i = 1;
      paramStringBuilder.append(str1);
    }
  }

  public static StringBuilder a(StringBuilder paramStringBuilder, Collection<String> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.size() == 0))
      return paramStringBuilder;
    Iterator localIterator = paramCollection.iterator();
    int i = 0;
    label24: String str;
    if (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (i == 0)
        break label64;
      paramStringBuilder.append(',');
    }
    while (true)
    {
      a(paramStringBuilder, str);
      break label24;
      break;
      label64: i = 1;
    }
  }

  public static StringBuilder a(StringBuilder paramStringBuilder, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
      return paramStringBuilder;
    int j = paramArrayOfString.length;
    int k = 0;
    label19: String str;
    if (k < j)
    {
      str = paramArrayOfString[k];
      if (i == 0)
        break label54;
      paramStringBuilder.append(',');
    }
    while (true)
    {
      a(paramStringBuilder, str);
      k++;
      break label19;
      break;
      label54: i = 1;
    }
  }

  public static StringBuilder a(Collection<Long> paramCollection, StringBuilder paramStringBuilder)
  {
    if ((paramCollection == null) || (paramCollection.size() == 0))
      return paramStringBuilder;
    Iterator localIterator = paramCollection.iterator();
    int i = 0;
    label24: Long localLong;
    if (localIterator.hasNext())
    {
      localLong = (Long)localIterator.next();
      if (i == 0)
        break label65;
      paramStringBuilder.append(',');
    }
    while (true)
    {
      paramStringBuilder.append(localLong);
      break label24;
      break;
      label65: i = 1;
    }
  }

  public static void a(StringBuilder paramStringBuilder, String paramString)
  {
    if (paramString == null)
      paramString = "";
    paramStringBuilder.append('\'');
    if (paramString.indexOf('\'') != -1)
    {
      int i = paramString.length();
      for (int j = 0; j < i; j++)
      {
        char c = paramString.charAt(j);
        if (c == '\'')
          paramStringBuilder.append('\'');
        paramStringBuilder.append(c);
      }
    }
    paramStringBuilder.append(paramString);
    paramStringBuilder.append('\'');
  }

  public static void a(String[] paramArrayOfString, StringBuilder paramStringBuilder)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      paramStringBuilder.append(" * ");
      return;
    }
    int j = paramArrayOfString.length;
    int k = 0;
    label26: if (k < j)
    {
      if (i == 0)
        break label59;
      paramStringBuilder.append(", ");
    }
    while (true)
    {
      paramStringBuilder.append(paramArrayOfString[k]);
      k++;
      break label26;
      break;
      label59: i = 1;
    }
  }

  public static String[] a(String[] paramArrayOfString, int paramInt)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
      return paramArrayOfString;
    int i = paramArrayOfString.length;
    String[] arrayOfString = new String[i * paramInt];
    for (int j = 0; j < paramInt; j++)
      System.arraycopy(paramArrayOfString, 0, arrayOfString, j * i, paramArrayOfString.length);
    return arrayOfString;
  }

  private static String b(String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    if (paramArrayOfString.length == 1)
      return paramArrayOfString[0];
    StringBuilder localStringBuilder = new StringBuilder();
    while (i < paramArrayOfString.length)
    {
      if (i > 0)
        localStringBuilder.append(' ').append(paramString).append(' ');
      localStringBuilder.append('(').append(paramArrayOfString[i]).append(')');
      i++;
    }
    return localStringBuilder.toString();
  }

  public static String b(Collection<String> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.size() == 0))
      return "";
    StringBuilder localStringBuilder = new StringBuilder(16 * paramCollection.size());
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (localStringBuilder.length() > 0)
        localStringBuilder.append(',');
      a(localStringBuilder, str);
    }
    return localStringBuilder.toString();
  }

  public static String b(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int j = paramArrayOfInt.length;
    while (i < j)
    {
      Integer localInteger = Integer.valueOf(paramArrayOfInt[i]);
      if (localStringBuilder.length() > 0)
        localStringBuilder.append(',');
      localStringBuilder.append(localInteger);
      i++;
    }
    return localStringBuilder.toString();
  }

  public static String b(String[] paramArrayOfString)
  {
    return b("OR", paramArrayOfString);
  }

  public static StringBuilder b(StringBuilder paramStringBuilder, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0));
    while (true)
    {
      return paramStringBuilder;
      int i = 0;
      int j = paramArrayOfString.length;
      while (i < j)
      {
        String str = paramArrayOfString[i];
        if (i > 0)
          paramStringBuilder.append(',');
        paramStringBuilder.append(str);
        i++;
      }
    }
  }

  public static a c(Collection<f> paramCollection)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet(1 + paramCollection.size(), 1.0F);
    Iterator localIterator1 = paramCollection.iterator();
    while (localIterator1.hasNext())
    {
      f localf = (f)localIterator1.next();
      if (localStringBuilder2.length() > 0)
        localStringBuilder2.append(',');
      localStringBuilder2.append(localf.getId());
      localHashSet2.add(Long.valueOf(localf.getId()));
      String str1 = localf.q();
      if (!TextUtils.isEmpty(str1))
        for (String str2 : str1.split("\\."))
          if (!TextUtils.isEmpty(str2))
            localHashSet1.add(str2);
      Iterator localIterator2 = localf.a().iterator();
      while (localIterator2.hasNext())
      {
        s locals = (s)localIterator2.next();
        if (localStringBuilder1.length() > 0)
          localStringBuilder1.append(',');
        localStringBuilder1.append(locals.getId());
      }
    }
    return new a(localStringBuilder2.toString(), localStringBuilder1.toString(), localHashSet1, localHashSet2);
  }

  public static String c(String[] paramArrayOfString)
  {
    return b("AND", paramArrayOfString);
  }

  public static String d(Collection<Integer> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.size() == 0))
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if (localStringBuilder.length() > 0)
        localStringBuilder.append(',');
      localStringBuilder.append(localInteger);
    }
    return localStringBuilder.toString();
  }

  public static String d(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
      return " * ";
    StringBuilder localStringBuilder = new StringBuilder(28 * paramArrayOfString.length);
    int i = 0;
    int j = paramArrayOfString.length;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if (localStringBuilder.length() > 0)
        localStringBuilder.append(", ");
      localStringBuilder.append(str);
      i++;
    }
    return localStringBuilder.toString();
  }

  public static String e(Collection<Long> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.size() == 0))
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      if (localStringBuilder.length() > 0)
        localStringBuilder.append(',');
      localStringBuilder.append(localLong);
    }
    return localStringBuilder.toString();
  }

  public static String f(Collection<String> paramCollection)
  {
    return b((String[])paramCollection.toArray(new String[paramCollection.size()]));
  }

  public static class a
  {
    public final String a;
    public final String b;
    public final Set<String> c;
    public final Set<Long> d;

    public a(String paramString1, String paramString2, Set<String> paramSet, Set<Long> paramSet1)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramSet;
      this.d = paramSet1;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.s.a
 * JD-Core Version:    0.6.2
 */