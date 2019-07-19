package twitter4j.internal.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class z_T4JInternalStringUtil
{
  private z_T4JInternalStringUtil()
  {
    throw new AssertionError();
  }

  public static String join(List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder(11 * paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (localStringBuilder.length() != 0)
        localStringBuilder.append(",");
      localStringBuilder.append(str);
    }
    return localStringBuilder.toString();
  }

  public static String join(int[] paramArrayOfInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(11 * paramArrayOfInt.length);
    int i = paramArrayOfInt.length;
    for (int j = 0; j < i; j++)
    {
      int k = paramArrayOfInt[j];
      if (localStringBuilder.length() != 0)
        localStringBuilder.append(",");
      localStringBuilder.append(k);
    }
    return localStringBuilder.toString();
  }

  public static String join(long[] paramArrayOfLong)
  {
    StringBuilder localStringBuilder = new StringBuilder(11 * paramArrayOfLong.length);
    int i = paramArrayOfLong.length;
    for (int j = 0; j < i; j++)
    {
      long l = paramArrayOfLong[j];
      if (localStringBuilder.length() != 0)
        localStringBuilder.append(",");
      localStringBuilder.append(l);
    }
    return localStringBuilder.toString();
  }

  public static String join(String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder(11 * paramArrayOfString.length);
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      String str = paramArrayOfString[j];
      if (localStringBuilder.length() != 0)
        localStringBuilder.append(",");
      localStringBuilder.append(str);
    }
    return localStringBuilder.toString();
  }

  public static String maskString(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    for (int i = 0; i < paramString.length(); i++)
      localStringBuilder.append("*");
    return localStringBuilder.toString();
  }

  public static String[] split(String paramString1, String paramString2)
  {
    int i = paramString1.indexOf(paramString2);
    if (i == -1)
      return new String[] { paramString1 };
    ArrayList localArrayList = new ArrayList();
    int j = i;
    int k = 0;
    while (j != -1)
    {
      localArrayList.add(paramString1.substring(k, j));
      k = j + paramString2.length();
      j = paramString1.indexOf(paramString2, k);
    }
    if (k != paramString1.length())
      localArrayList.add(paramString1.substring(k));
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.util.z_T4JInternalStringUtil
 * JD-Core Version:    0.6.2
 */