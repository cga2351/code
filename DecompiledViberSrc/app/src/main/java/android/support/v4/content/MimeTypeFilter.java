package android.support.v4.content;

import java.util.ArrayList;

public final class MimeTypeFilter
{
  public static String matches(String paramString, String[] paramArrayOfString)
  {
    if (paramString == null);
    while (true)
    {
      return null;
      String[] arrayOfString = paramString.split("/");
      int i = paramArrayOfString.length;
      for (int j = 0; j < i; j++)
      {
        String str = paramArrayOfString[j];
        if (mimeTypeAgainstFilter(arrayOfString, str.split("/")))
          return str;
      }
    }
  }

  public static String matches(String[] paramArrayOfString, String paramString)
  {
    if (paramArrayOfString == null);
    while (true)
    {
      return null;
      String[] arrayOfString = paramString.split("/");
      int i = paramArrayOfString.length;
      for (int j = 0; j < i; j++)
      {
        String str = paramArrayOfString[j];
        if (mimeTypeAgainstFilter(str.split("/"), arrayOfString))
          return str;
      }
    }
  }

  public static boolean matches(String paramString1, String paramString2)
  {
    if (paramString1 == null)
      return false;
    return mimeTypeAgainstFilter(paramString1.split("/"), paramString2.split("/"));
  }

  public static String[] matchesMany(String[] paramArrayOfString, String paramString)
  {
    int i = 0;
    if (paramArrayOfString == null)
      return new String[0];
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = paramString.split("/");
    int j = paramArrayOfString.length;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if (mimeTypeAgainstFilter(str.split("/"), arrayOfString))
        localArrayList.add(str);
      i++;
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }

  private static boolean mimeTypeAgainstFilter(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if (paramArrayOfString2.length != 2)
      throw new IllegalArgumentException("Ill-formatted MIME type filter. Must be type/subtype.");
    if ((paramArrayOfString2[0].isEmpty()) || (paramArrayOfString2[1].isEmpty()))
      throw new IllegalArgumentException("Ill-formatted MIME type filter. Type or subtype empty.");
    if (paramArrayOfString1.length != 2);
    while (((!"*".equals(paramArrayOfString2[0])) && (!paramArrayOfString2[0].equals(paramArrayOfString1[0]))) || ((!"*".equals(paramArrayOfString2[1])) && (!paramArrayOfString2[1].equals(paramArrayOfString1[1]))))
      return false;
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.content.MimeTypeFilter
 * JD-Core Version:    0.6.2
 */