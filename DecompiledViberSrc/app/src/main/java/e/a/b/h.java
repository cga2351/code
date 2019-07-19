package e.a.b;

import e.a.a.j;
import e.a.b.a.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class h
{
  public static final a a = new a();

  public static String a(String paramString)
  {
    int i = paramString.length();
    char[] arrayOfChar = new char[i + 3];
    arrayOfChar[0] = 'g';
    arrayOfChar[1] = 'e';
    arrayOfChar[2] = 't';
    int j = paramString.charAt(0);
    if ((j >= 97) && (j <= 122))
      j = (char)(j - 32);
    arrayOfChar[3] = j;
    for (int k = 1; ; k++)
    {
      if (k >= i)
        return new String(arrayOfChar);
      arrayOfChar[(k + 3)] = paramString.charAt(k);
    }
  }

  public static String b(String paramString)
  {
    int i = paramString.length();
    char[] arrayOfChar = new char[i + 2];
    arrayOfChar[0] = 'i';
    arrayOfChar[1] = 's';
    int j = paramString.charAt(0);
    if ((j >= 97) && (j <= 122))
      j = (char)(j - 32);
    arrayOfChar[2] = j;
    for (int k = 1; ; k++)
    {
      if (k >= i)
        return new String(arrayOfChar);
      arrayOfChar[(k + 2)] = paramString.charAt(k);
    }
  }

  public static class a
    implements j
  {
    public boolean a(Field paramField, Method paramMethod)
    {
      a locala = (a)paramMethod.getAnnotation(a.class);
      return (locala == null) || (!locala.a());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     e.a.b.h
 * JD-Core Version:    0.6.2
 */