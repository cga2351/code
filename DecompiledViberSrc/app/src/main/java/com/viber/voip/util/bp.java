package com.viber.voip.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import com.viber.common.b.h;
import com.viber.common.d.a;
import com.viber.voip.settings.d.ad.a;
import java.util.Locale;

public abstract class bp
{
  static final b[] a = arrayOfb;

  static
  {
    b[] arrayOfb = new b[78];
    arrayOfb[0] = new b(a.a)
    {
    };
    arrayOfb[1] = new b(a.b)
    {
    };
    arrayOfb[2] = new b(a.c)
    {
    };
    arrayOfb[3] = new b(a.d)
    {
    };
    arrayOfb[4] = new b(a.e)
    {
    };
    arrayOfb[5] = new b(a.f)
    {
    };
    arrayOfb[6] = new b(a.g)
    {
    };
    arrayOfb[7] = new b(a.h)
    {
    };
    arrayOfb[8] = new b(a.i)
    {
    };
    arrayOfb[9] = new b(a.j)
    {
    };
    arrayOfb[10] = new b(a.k)
    {
    };
    arrayOfb[11] = new b(a.l)
    {
    };
    arrayOfb[12] = new b(a.m)
    {
    };
    arrayOfb[13] = new b(a.n)
    {
    };
    arrayOfb[14] = new b(a.o)
    {
    };
    arrayOfb[15] = new b(a.p)
    {
    };
    arrayOfb[16] = new b(a.q)
    {
    };
    arrayOfb[17] = new b(a.r)
    {
    };
    arrayOfb[18] = new b(a.s)
    {
    };
    arrayOfb[19] = new b(a.t)
    {
    };
    arrayOfb[20] = new b(a.u)
    {
    };
    arrayOfb[21] = new b(a.v)
    {
    };
    arrayOfb[22] = new b(a.w)
    {
    };
    arrayOfb[23] = new b(a.x)
    {
    };
    arrayOfb[24] = new b(a.y)
    {
    };
    arrayOfb[25] = new b(a.z)
    {
    };
    arrayOfb[26] = new b(a.A)
    {
    };
    arrayOfb[27] = new b(a.B)
    {
    };
    arrayOfb[28] = new b(a.C)
    {
    };
    arrayOfb[29] = new b(a.D)
    {
    };
    arrayOfb[30] = new b(a.E)
    {
    };
    arrayOfb[31] = new b(a.F)
    {
    };
    arrayOfb[32] = new b(a.G)
    {
    };
    arrayOfb[33] = new b(a.H)
    {
    };
    arrayOfb[34] = new b(a.I)
    {
    };
    arrayOfb[35] = new b(a.J)
    {
    };
    arrayOfb[36] = new b(a.K)
    {
    };
    arrayOfb[37] = new b(a.L)
    {
    };
    arrayOfb[38] = new b(a.M)
    {
    };
    arrayOfb[39] = new b(a.N)
    {
    };
    arrayOfb[40] = new b(a.O)
    {
    };
    arrayOfb[41] = new b(a.P)
    {
    };
    arrayOfb[42] = new b(a.Q)
    {
    };
    arrayOfb[43] = new b(a.R)
    {
    };
    arrayOfb[44] = new b(a.S)
    {
    };
    arrayOfb[45] = new b(a.T)
    {
    };
    arrayOfb[46] = new b(a.U)
    {
    };
    arrayOfb[47] = new b(a.V)
    {
    };
    arrayOfb[48] = new b(a.W)
    {
    };
    arrayOfb[49] = new b(a.X)
    {
    };
    arrayOfb[50] = new b(a.Y)
    {
    };
    arrayOfb[51] = new b(a.Z)
    {
    };
    arrayOfb[52] = new b(a.aa)
    {
    };
    arrayOfb[53] = new b(a.ab)
    {
    };
    arrayOfb[54] = new b(a.ac)
    {
    };
    arrayOfb[55] = new b(a.ad)
    {
    };
    arrayOfb[56] = new b(a.ae)
    {
    };
    arrayOfb[57] = new b(a.af)
    {
    };
    arrayOfb[58] = new b(a.ag)
    {
    };
    arrayOfb[59] = new b(a.ah)
    {
    };
    arrayOfb[60] = new b(a.ai)
    {
    };
    arrayOfb[61] = new b(a.aj)
    {
    };
    arrayOfb[62] = new b(a.ak)
    {
    };
    arrayOfb[63] = new b(a.al)
    {
    };
    arrayOfb[64] = new b(a.am)
    {
    };
    arrayOfb[65] = new b(a.an)
    {
    };
    arrayOfb[66] = new b(a.ao)
    {
    };
    arrayOfb[67] = new b(a.ap)
    {
    };
    arrayOfb[68] = new b(a.aq)
    {
    };
    arrayOfb[69] = new b(a.ar)
    {
    };
    arrayOfb[70] = new b(a.as)
    {
    };
    arrayOfb[71] = new b(a.at)
    {
    };
    arrayOfb[72] = new b(a.au)
    {
    };
    arrayOfb[73] = new b(a.av)
    {
    };
    arrayOfb[74] = new b(a.aw)
    {
    };
    arrayOfb[75] = new b(a.ax)
    {
    };
    arrayOfb[76] = new b(a.ay)
    {
    };
    arrayOfb[77] = new b(a.az)
    {
    };
  }

  public static String a(Locale paramLocale)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return paramLocale.toLanguageTag();
    String str1 = paramLocale.getLanguage();
    String str2 = paramLocale.getCountry();
    String str3 = paramLocale.getVariant();
    if ((str1.equals("no")) && (str2.equals("NO")) && (str3.equals("NY")))
    {
      str1 = "nn";
      str2 = "NO";
      str3 = "";
    }
    if ((str1.isEmpty()) || (!str1.matches("\\p{Alpha}{2,8}")))
      str1 = "und";
    while (true)
    {
      if (!str2.matches("\\p{Alpha}{2}|\\p{Digit}{3}"))
        str2 = "";
      if (!str3.matches("\\p{Alnum}{5,8}|\\p{Digit}\\p{Alnum}{3}"))
        str3 = "";
      StringBuilder localStringBuilder = new StringBuilder(str1);
      if (!str2.isEmpty())
        localStringBuilder.append('-').append(str2);
      if (!str3.isEmpty())
        localStringBuilder.append('-').append(str3);
      return localStringBuilder.toString();
      if (str1.equals("iw"))
        str1 = "he";
      else if (str1.equals("in"))
        str1 = "id";
      else if (str1.equals("ji"))
        str1 = "yi";
    }
  }

  public static Locale a(Resources paramResources)
  {
    if (a.k())
      return paramResources.getConfiguration().getLocales().get(0);
    return paramResources.getConfiguration().locale;
  }

  public static void a(Activity paramActivity, String paramString)
  {
    if (!d.ad.a.c.d().equals(paramString))
      paramActivity.recreate();
  }

  public static boolean a(Context paramContext)
  {
    return a(paramContext.getResources()).getLanguage().startsWith("en");
  }

  public static final boolean a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0));
    label76: 
    while (true)
    {
      return false;
      for (int i = 0; ; i++)
      {
        if (i >= paramString.length())
          break label76;
        int j = Character.getDirectionality(paramString.charAt(i));
        if ((1 == j) || (2 == j) || (16 == j) || (17 == j))
          return true;
        if ((j == 0) || (14 == j) || (15 == j))
          break;
      }
    }
  }

  public static String[] a(Configuration paramConfiguration)
  {
    LocaleList localLocaleList = paramConfiguration.getLocales();
    int i = localLocaleList.size();
    String[] arrayOfString = new String[i];
    for (int j = 0; j < i; j++)
      arrayOfString[j] = localLocaleList.get(j).getCountry();
    return arrayOfString;
  }

  public static Locale b(Context paramContext)
  {
    InputMethodSubtype localInputMethodSubtype = ((InputMethodManager)paramContext.getSystemService("input_method")).getCurrentInputMethodSubtype();
    Locale localLocale = null;
    if (localInputMethodSubtype != null)
      localLocale = b(localInputMethodSubtype.getLocale());
    if (localLocale == null)
      localLocale = Locale.getDefault();
    return localLocale;
  }

  public static Locale b(String paramString)
  {
    if (da.a(paramString));
    String[] arrayOfString;
    do
    {
      return null;
      arrayOfString = paramString.split("_", 3);
      if (1 == arrayOfString.length)
        return new Locale(arrayOfString[0]);
      if (2 == arrayOfString.length)
        return new Locale(arrayOfString[0], arrayOfString[1]);
    }
    while (3 != arrayOfString.length);
    return new Locale(arrayOfString[0], arrayOfString[1], arrayOfString[2]);
  }

  public static Context c(Context paramContext)
  {
    if ((a.k()) && (!da.a(d.ad.a.c.d())))
    {
      Locale localLocale = c(d.ad.a.c.d());
      Configuration localConfiguration = paramContext.getResources().getConfiguration();
      localConfiguration.setLocale(localLocale);
      LocaleList localLocaleList = new LocaleList(new Locale[] { localLocale });
      LocaleList.setDefault(localLocaleList);
      localConfiguration.setLocales(localLocaleList);
      paramContext = paramContext.createConfigurationContext(localConfiguration);
    }
    return paramContext;
  }

  public static Locale c(String paramString)
  {
    if (paramString.contains("-"))
    {
      String[] arrayOfString2 = paramString.split("-");
      if (arrayOfString2.length > 2)
        return new Locale(arrayOfString2[0], arrayOfString2[1], arrayOfString2[2]);
      if (arrayOfString2.length > 1)
        return new Locale(arrayOfString2[0], arrayOfString2[1]);
      if (arrayOfString2.length == 1)
        return new Locale(arrayOfString2[0]);
    }
    else if (paramString.contains("_"))
    {
      String[] arrayOfString1 = paramString.split("_");
      if (arrayOfString1.length > 2)
        return new Locale(arrayOfString1[0], arrayOfString1[1], arrayOfString1[2]);
      if (arrayOfString1.length > 1)
        return new Locale(arrayOfString1[0], arrayOfString1[1]);
      if (arrayOfString1.length == 1)
        return new Locale(arrayOfString1[0]);
    }
    else
    {
      return new Locale(paramString);
    }
    throw new IllegalArgumentException("Can not parse language tag: [" + paramString + "]");
  }

  public static enum a
  {
    static
    {
      A = new a("Cherokee", 26);
      B = new a("Canadian_Aboriginal", 27);
      C = new a("Ogham", 28);
      D = new a("Runic", 29);
      E = new a("Khmer", 30);
      F = new a("Mongolian", 31);
      G = new a("Hiragana", 32);
      H = new a("Katakana", 33);
      I = new a("Bopomofo", 34);
      J = new a("Han", 35);
      K = new a("Yi", 36);
      L = new a("Old_Italic", 37);
      M = new a("Gothic", 38);
      N = new a("Deseret", 39);
      O = new a("Inherited", 40);
      P = new a("Tagalog", 41);
      Q = new a("Hanunoo", 42);
      R = new a("Buhid", 43);
      S = new a("Tagbanwa", 44);
      T = new a("Limbu", 45);
      U = new a("Tai_Le", 46);
      V = new a("Linear_B", 47);
      W = new a("Ugaritic", 48);
      X = new a("Shavian", 49);
      Y = new a("Osmanya", 50);
      Z = new a("Cypriot", 51);
      aa = new a("Braille", 52);
      ab = new a("Buginese", 53);
      ac = new a("Coptic", 54);
      ad = new a("New_Tai_Lue", 55);
      ae = new a("Glagolitic", 56);
      af = new a("Tifinagh", 57);
      ag = new a("Syloti_Nagri", 58);
      ah = new a("Old_Persian", 59);
      ai = new a("Kharoshthi", 60);
      aj = new a("Balinese", 61);
      ak = new a("Cuneiform", 62);
      al = new a("Phoenician", 63);
      am = new a("Phags_Pa", 64);
      an = new a("N_ko", 65);
      ao = new a("Sundanese", 66);
      ap = new a("Lepcha", 67);
      aq = new a("Ol_Chiki", 68);
      ar = new a("Vai", 69);
      as = new a("Saurashtra", 70);
      at = new a("Kayah_Li", 71);
      au = new a("Rejang", 72);
      av = new a("Lycian", 73);
      aw = new a("Carian", 74);
      ax = new a("Lydian", 75);
      ay = new a("Cham", 76);
      az = new a("Unknown", 77);
      a[] arrayOfa = new a[78];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
      arrayOfa[6] = g;
      arrayOfa[7] = h;
      arrayOfa[8] = i;
      arrayOfa[9] = j;
      arrayOfa[10] = k;
      arrayOfa[11] = l;
      arrayOfa[12] = m;
      arrayOfa[13] = n;
      arrayOfa[14] = o;
      arrayOfa[15] = p;
      arrayOfa[16] = q;
      arrayOfa[17] = r;
      arrayOfa[18] = s;
      arrayOfa[19] = t;
      arrayOfa[20] = u;
      arrayOfa[21] = v;
      arrayOfa[22] = w;
      arrayOfa[23] = x;
      arrayOfa[24] = y;
      arrayOfa[25] = z;
      arrayOfa[26] = A;
      arrayOfa[27] = B;
      arrayOfa[28] = C;
      arrayOfa[29] = D;
      arrayOfa[30] = E;
      arrayOfa[31] = F;
      arrayOfa[32] = G;
      arrayOfa[33] = H;
      arrayOfa[34] = I;
      arrayOfa[35] = J;
      arrayOfa[36] = K;
      arrayOfa[37] = L;
      arrayOfa[38] = M;
      arrayOfa[39] = N;
      arrayOfa[40] = O;
      arrayOfa[41] = P;
      arrayOfa[42] = Q;
      arrayOfa[43] = R;
      arrayOfa[44] = S;
      arrayOfa[45] = T;
      arrayOfa[46] = U;
      arrayOfa[47] = V;
      arrayOfa[48] = W;
      arrayOfa[49] = X;
      arrayOfa[50] = Y;
      arrayOfa[51] = Z;
      arrayOfa[52] = aa;
      arrayOfa[53] = ab;
      arrayOfa[54] = ac;
      arrayOfa[55] = ad;
      arrayOfa[56] = ae;
      arrayOfa[57] = af;
      arrayOfa[58] = ag;
      arrayOfa[59] = ah;
      arrayOfa[60] = ai;
      arrayOfa[61] = aj;
      arrayOfa[62] = ak;
      arrayOfa[63] = al;
      arrayOfa[64] = am;
      arrayOfa[65] = an;
      arrayOfa[66] = ao;
      arrayOfa[67] = ap;
      arrayOfa[68] = aq;
      arrayOfa[69] = ar;
      arrayOfa[70] = as;
      arrayOfa[71] = at;
      arrayOfa[72] = au;
      arrayOfa[73] = av;
      arrayOfa[74] = aw;
      arrayOfa[75] = ax;
      arrayOfa[76] = ay;
      arrayOfa[77] = az;
    }
  }

  public static abstract class b
  {
    final bp.a a;

    b(bp.a parama)
    {
      this.a = parama;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.bp
 * JD-Core Version:    0.6.2
 */