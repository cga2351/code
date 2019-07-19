package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.text.TextUtils;
import com.yandex.metrica.impl.bu;
import com.yandex.metrica.impl.i;
import com.yandex.metrica.impl.s;
import com.yandex.metrica.impl.s.a;
import java.util.Locale;

public class of extends nt
{
  private static final int[] a = { 3, 6, 4 };
  private static final of b = new of();
  private static String c = "";
  private final String d;

  public of()
  {
    this("");
  }

  public of(String paramString)
  {
    super(false);
    Object[] arrayOfObject = new Object[1];
    String str = "";
    if ((!TextUtils.isEmpty(paramString)) && (paramString.length() == 36))
    {
      StringBuilder localStringBuilder = new StringBuilder(paramString);
      localStringBuilder.replace(8, -4 + paramString.length(), "-xxxx-xxxx-xxxx-xxxxxxxx");
      str = localStringBuilder.toString();
    }
    arrayOfObject[0] = str;
    this.d = String.format("[%s] ", arrayOfObject);
  }

  public static void a(Context paramContext)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramContext.getPackageName();
    c = String.format("[%s] : ", arrayOfObject);
  }

  public static of g()
  {
    return b;
  }

  public void a(i parami, String paramString)
  {
    if (s.b(parami.e()))
    {
      StringBuilder localStringBuilder = new StringBuilder(paramString);
      localStringBuilder.append(": ");
      localStringBuilder.append(parami.b());
      if ((s.c(parami.e())) && (!TextUtils.isEmpty(parami.c())))
      {
        localStringBuilder.append(" with value ");
        localStringBuilder.append(parami.c());
      }
      a(localStringBuilder.toString());
    }
  }

  public void a(kk.c.e.a parama, String paramString)
  {
    int[] arrayOfInt = a;
    int i = arrayOfInt.length;
    int j = 0;
    int k = 0;
    StringBuilder localStringBuilder1;
    String str2;
    if (j < i)
    {
      int m = arrayOfInt[j];
      if (parama.d == m)
        k = 1;
    }
    else if (k != 0)
    {
      localStringBuilder1 = new StringBuilder().append(paramString).append(": ");
      if ((parama.d != 3) || (!TextUtils.isEmpty(parama.e)))
        break label109;
      str2 = s.a.n.b();
    }
    while (true)
    {
      a(str2);
      return;
      j++;
      break;
      label109: if (parama.d == 4)
      {
        StringBuilder localStringBuilder2 = new StringBuilder(parama.e);
        if (parama.f != null)
        {
          String str1 = new String(parama.f);
          if (!TextUtils.isEmpty(str1))
          {
            localStringBuilder2.append(" with value ");
            localStringBuilder2.append(str1);
          }
        }
        str2 = localStringBuilder2.toString();
      }
      else
      {
        str2 = parama.e;
      }
    }
  }

  public void a(kk.c.e parame, String paramString)
  {
    kk.c.e.a[] arrayOfa = parame.d;
    int i = arrayOfa.length;
    for (int j = 0; j < i; j++)
      a(arrayOfa[j], paramString);
  }

  String c(String paramString, Object[] paramArrayOfObject)
  {
    return String.format(Locale.US, paramString, paramArrayOfObject);
  }

  public String e()
  {
    return "AppMetrica";
  }

  public String f()
  {
    String str1 = bu.b(c, "");
    String str2 = bu.b(this.d, "");
    return str1 + str2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.of
 * JD-Core Version:    0.6.2
 */