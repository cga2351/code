package com.viber.voip.util.a;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.br;
import java.util.Locale;
import java.util.Map;

public class b
{
  private static final Logger a = ViberEnv.getLogger();
  private static final boolean b = br.d.a();

  public static a a(String paramString1, String paramString2, String paramString3)
  {
    return a(paramString1, paramString2, paramString3, true);
  }

  public static a a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    boolean bool = b();
    char c2;
    String str4;
    label48: int i;
    label78: Object localObject2;
    label115: char c3;
    Object localObject1;
    Object localObject3;
    if (!TextUtils.isEmpty(paramString2))
    {
      c2 = paramString2.charAt(0);
      if (!paramBoolean)
        break label293;
      if (c.d(c2))
        c2 = c.i(c2);
      if (paramString3 == null)
        break label196;
      str4 = paramString3.toLowerCase();
      if ((c2 == 0) || (!c.j(c2)) || ((!TextUtils.isEmpty(paramString2)) && (e.b(paramString2))))
        break label203;
      i = 1;
      if (!d.a.containsKey(Character.valueOf(c2)))
        break label209;
      localObject2 = ((Character)d.a.get(Character.valueOf(c2))).toString();
      c3 = c2;
      localObject1 = str4;
      if (c3 == 0)
        break label417;
      if (!Character.isDigit(c3))
        break label355;
      localObject2 = com.viber.voip.contacts.adapters.b.h;
      if (!b)
        break label417;
      localObject3 = "";
    }
    while (true)
    {
      return new a(paramString1, paramString2, (String)localObject3, (String)localObject2);
      if ((paramString1 != null) && (paramString1.length() > 0));
      for (char c1 = paramString1.charAt(0); ; c1 = '\000')
      {
        c2 = c1;
        break;
      }
      label196: str4 = "";
      break label48;
      label203: i = 0;
      break label78;
      label209: if ((i != 0) && (!bool) && (c.f(c2)) && (paramString1 != null) && (paramString1.equals(str4)))
      {
        localObject2 = com.viber.voip.contacts.adapters.b.d;
        break label115;
      }
      if ((i != 0) && (bool))
      {
        localObject2 = com.viber.voip.contacts.adapters.b.b;
        break label115;
      }
      if (!TextUtils.isEmpty(str4))
      {
        localObject2 = str4.substring(0, 1);
        break label115;
      }
      localObject2 = "";
      break label115;
      label293: paramString2 = "";
      String str1;
      if (!TextUtils.isEmpty(paramString1))
      {
        str1 = paramString1.toLowerCase();
        label309: if (TextUtils.isEmpty(str1))
          break label348;
      }
      label348: for (String str2 = str1.substring(0, 1); ; str2 = "")
      {
        localObject1 = str1;
        localObject2 = str2;
        c3 = c2;
        break;
        str1 = "";
        break label309;
      }
      label355: if ((!Character.isDigit(c3)) && (!Character.isLetter(c3)))
      {
        if (b);
        for (String str3 = ""; ; str3 = " " + (String)localObject1)
        {
          localObject3 = str3;
          localObject2 = "";
          break;
        }
      }
      label417: localObject3 = localObject1;
    }
  }

  public static b a(String paramString)
  {
    return new b(paramString);
  }

  public static boolean a()
  {
    return b;
  }

  public static boolean b()
  {
    return Resources.getSystem().getConfiguration().locale.getLanguage().equals(Locale.JAPANESE.getLanguage());
  }

  public static class a
  {
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    a(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramString3;
      this.d = paramString4;
    }

    public String toString()
    {
      return "ContactSortInfo [displayName=" + this.a + ", phoneticName=" + this.b + ", sortKey=" + this.c + ", phoneLabel=" + this.d + "]";
    }
  }

  public static class b
  {
    public final String a;
    public final String b;
    public final boolean c;

    b(String paramString)
    {
      if (TextUtils.isEmpty(paramString))
      {
        this.a = paramString;
        this.b = paramString;
        this.c = true;
        return;
      }
      int i = e.c(paramString);
      if ((i == 1) || (i == 2))
      {
        String str;
        if (i == 2)
        {
          str = paramString;
          this.b = str;
          if (i != 1)
            break label78;
        }
        while (true)
        {
          this.a = paramString;
          this.c = false;
          return;
          str = e.j(paramString);
          break;
          label78: paramString = e.k(paramString);
        }
      }
      this.a = paramString;
      this.b = paramString;
      this.c = true;
    }

    public String toString()
    {
      return "JapaneseNamesInfo [hiraganaName=" + this.a + ", katakanaName=" + this.b + "]";
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.a.b
 * JD-Core Version:    0.6.2
 */