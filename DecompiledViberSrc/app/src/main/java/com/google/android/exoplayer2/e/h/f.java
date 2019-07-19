package com.google.android.exoplayer2.e.h;

import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan.Standard;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.r;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f
{
  public static final Pattern a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
  private static final Pattern b = Pattern.compile("(\\S+?):(\\S+)");
  private final StringBuilder c = new StringBuilder();

  private static int a(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case 109757538:
    case -1364013995:
    case -1074341483:
    case 100571:
    }
    while (true)
    {
      int j = 0;
      switch (i)
      {
      default:
        l.c("WebvttCueParser", "Invalid anchor value: " + paramString);
        j = -2147483648;
      case 0:
        return j;
        if (paramString.equals("start"))
        {
          i = 0;
          continue;
          if (paramString.equals("center"))
          {
            i = 1;
            continue;
            if (paramString.equals("middle"))
            {
              i = 2;
              continue;
              if (paramString.equals("end"))
                i = 3;
            }
          }
        }
        break;
      case 1:
      case 2:
      case 3:
      }
    }
    return 1;
    return 2;
  }

  private static int a(String paramString, int paramInt)
  {
    int i = paramString.indexOf('>', paramInt);
    if (i == -1)
      return paramString.length();
    return i + 1;
  }

  private static void a(SpannableStringBuilder paramSpannableStringBuilder, d paramd, int paramInt1, int paramInt2)
  {
    if (paramd == null)
      return;
    if (paramd.b() != -1)
      paramSpannableStringBuilder.setSpan(new StyleSpan(paramd.b()), paramInt1, paramInt2, 33);
    if (paramd.c())
      paramSpannableStringBuilder.setSpan(new StrikethroughSpan(), paramInt1, paramInt2, 33);
    if (paramd.d())
      paramSpannableStringBuilder.setSpan(new UnderlineSpan(), paramInt1, paramInt2, 33);
    if (paramd.g())
      paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(paramd.f()), paramInt1, paramInt2, 33);
    if (paramd.i())
      paramSpannableStringBuilder.setSpan(new BackgroundColorSpan(paramd.h()), paramInt1, paramInt2, 33);
    if (paramd.e() != null)
      paramSpannableStringBuilder.setSpan(new TypefaceSpan(paramd.e()), paramInt1, paramInt2, 33);
    if (paramd.j() != null)
      paramSpannableStringBuilder.setSpan(new AlignmentSpan.Standard(paramd.j()), paramInt1, paramInt2, 33);
    switch (paramd.k())
    {
    default:
      return;
    case 1:
      paramSpannableStringBuilder.setSpan(new AbsoluteSizeSpan((int)paramd.l(), true), paramInt1, paramInt2, 33);
      return;
    case 2:
      paramSpannableStringBuilder.setSpan(new RelativeSizeSpan(paramd.l()), paramInt1, paramInt2, 33);
      return;
    case 3:
    }
    paramSpannableStringBuilder.setSpan(new RelativeSizeSpan(paramd.l() / 100.0F), paramInt1, paramInt2, 33);
  }

  private static void a(String paramString, SpannableStringBuilder paramSpannableStringBuilder)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case 3464:
    case 3309:
    case 3374865:
    case 96708:
    }
    while (true)
      switch (i)
      {
      default:
        l.c("WebvttCueParser", "ignoring unsupported entity: '&" + paramString + ";'");
        return;
        if (paramString.equals("lt"))
        {
          i = 0;
          continue;
          if (paramString.equals("gt"))
          {
            i = 1;
            continue;
            if (paramString.equals("nbsp"))
            {
              i = 2;
              continue;
              if (paramString.equals("amp"))
                i = 3;
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    paramSpannableStringBuilder.append('<');
    return;
    paramSpannableStringBuilder.append('>');
    return;
    paramSpannableStringBuilder.append(' ');
    return;
    paramSpannableStringBuilder.append('&');
  }

  static void a(String paramString, e.a parama)
  {
    Matcher localMatcher = b.matcher(paramString);
    while (localMatcher.find())
    {
      String str1 = localMatcher.group(1);
      String str2 = localMatcher.group(2);
      try
      {
        if (!"line".equals(str1))
          break label78;
        b(str2, parama);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        l.c("WebvttCueParser", "Skipping bad cue setting: " + localMatcher.group());
      }
      continue;
      label78: if ("align".equals(str1))
        parama.a(b(str2));
      else if ("position".equals(str1))
        c(str2, parama);
      else if ("size".equals(str1))
        parama.c(h.b(str2));
      else
        l.c("WebvttCueParser", "Unknown cue setting " + str1 + ":" + str2);
    }
  }

  private static void a(String paramString, a parama, SpannableStringBuilder paramSpannableStringBuilder, List<d> paramList, List<b> paramList1)
  {
    int i = parama.b;
    int j = paramSpannableStringBuilder.length();
    String str = parama.a;
    int k = -1;
    switch (str.hashCode())
    {
    default:
    case 98:
    case 105:
    case 117:
    case 99:
    case 3314158:
    case 118:
    case 0:
    }
    while (true)
      switch (k)
      {
      default:
        return;
        if (str.equals("b"))
        {
          k = 0;
          continue;
          if (str.equals("i"))
          {
            k = 1;
            continue;
            if (str.equals("u"))
            {
              k = 2;
              continue;
              if (str.equals("c"))
              {
                k = 3;
                continue;
                if (str.equals("lang"))
                {
                  k = 4;
                  continue;
                  if (str.equals("v"))
                  {
                    k = 5;
                    continue;
                    if (str.equals(""))
                      k = 6;
                  }
                }
              }
            }
          }
        }
        break;
      case 0:
      case 3:
      case 4:
      case 5:
      case 6:
      case 1:
      case 2:
      }
    paramSpannableStringBuilder.setSpan(new StyleSpan(1), i, j, 33);
    while (true)
    {
      paramList1.clear();
      a(paramList, paramString, parama, paramList1);
      int m = paramList1.size();
      for (int n = 0; n < m; n++)
        a(paramSpannableStringBuilder, ((b)paramList1.get(n)).b, i, j);
      paramSpannableStringBuilder.setSpan(new StyleSpan(2), i, j, 33);
      continue;
      paramSpannableStringBuilder.setSpan(new UnderlineSpan(), i, j, 33);
    }
  }

  static void a(String paramString1, String paramString2, e.a parama, List<d> paramList)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    ArrayDeque localArrayDeque = new ArrayDeque();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (true)
    {
      label123: int n;
      if (i < paramString2.length())
      {
        char c1 = paramString2.charAt(i);
        switch (c1)
        {
        default:
          localSpannableStringBuilder.append(c1);
          i++;
          break;
        case '<':
          if (i + 1 >= paramString2.length())
          {
            i++;
            continue;
          }
          int m;
          int i1;
          int i2;
          int i3;
          if (paramString2.charAt(i + 1) == '/')
          {
            m = 1;
            n = a(paramString2, i + 1);
            if (paramString2.charAt(n - 2) != '/')
              break label218;
            i1 = 1;
            if (m == 0)
              break label224;
            i2 = 2;
            i3 = i2 + i;
            if (i1 == 0)
              break label230;
          }
          String str1;
          String str2;
          for (int i4 = n - 2; ; i4 = n - 1)
          {
            str1 = paramString2.substring(i3, i4);
            str2 = d(str1);
            if (str2 == null)
              break label483;
            if (c(str2))
              break label239;
            i = n;
            break;
            m = 0;
            break label123;
            i1 = 0;
            break label149;
            i2 = 1;
            break label157;
          }
          if (m != 0)
          {
            if (localArrayDeque.isEmpty());
            while (true)
            {
              i = n;
              break;
              a locala = (a)localArrayDeque.pop();
              a(paramString1, locala, localSpannableStringBuilder, paramList, localArrayList);
              if (!locala.a.equals(str2))
                break label244;
            }
          }
          if (i1 != 0)
            break label483;
          localArrayDeque.push(a.a(str1, localSpannableStringBuilder.length()));
          i = n;
          break;
        case '&':
          label149: label157: label218: label224: label230: label239: label244: int j = paramString2.indexOf(';', i + 1);
          int k = paramString2.indexOf(' ', i + 1);
          if (j == -1)
            j = k;
          while (true)
          {
            if (j == -1)
              break label421;
            a(paramString2.substring(i + 1, j), localSpannableStringBuilder);
            if (j == k)
              localSpannableStringBuilder.append(" ");
            i = j + 1;
            break;
            if (k != -1)
              j = Math.min(j, k);
          }
          label421: localSpannableStringBuilder.append(c1);
          i++;
          break;
        }
      }
      else
      {
        while (!localArrayDeque.isEmpty())
          a(paramString1, (a)localArrayDeque.pop(), localSpannableStringBuilder, paramList, localArrayList);
        a(paramString1, a.a(), localSpannableStringBuilder, paramList, localArrayList);
        parama.a(localSpannableStringBuilder);
        return;
        label483: i = n;
      }
    }
  }

  private static void a(List<d> paramList, String paramString, a parama, List<b> paramList1)
  {
    int i = paramList.size();
    for (int j = 0; j < i; j++)
    {
      d locald = (d)paramList.get(j);
      int k = locald.a(paramString, parama.a, parama.d, parama.c);
      if (k > 0)
        paramList1.add(new b(k, locald));
    }
    Collections.sort(paramList1);
  }

  private static boolean a(String paramString, Matcher paramMatcher, r paramr, e.a parama, StringBuilder paramStringBuilder, List<d> paramList)
  {
    try
    {
      parama.a(h.a(paramMatcher.group(1))).b(h.a(paramMatcher.group(2)));
      a(paramMatcher.group(3), parama);
      paramStringBuilder.setLength(0);
      while (true)
      {
        String str = paramr.B();
        if (TextUtils.isEmpty(str))
          break;
        if (paramStringBuilder.length() > 0)
          paramStringBuilder.append("\n");
        paramStringBuilder.append(str.trim());
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      l.c("WebvttCueParser", "Skipping cue with bad header: " + paramMatcher.group());
      return false;
    }
    a(paramString, paramStringBuilder.toString(), parama, paramList);
    return true;
  }

  private static Layout.Alignment b(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case 109757538:
    case 3317767:
    case -1364013995:
    case -1074341483:
    case 100571:
    case 108511772:
    }
    while (true)
      switch (i)
      {
      default:
        l.c("WebvttCueParser", "Invalid alignment value: " + paramString);
        return null;
        if (paramString.equals("start"))
        {
          i = 0;
          continue;
          if (paramString.equals("left"))
          {
            i = 1;
            continue;
            if (paramString.equals("center"))
            {
              i = 2;
              continue;
              if (paramString.equals("middle"))
              {
                i = 3;
                continue;
                if (paramString.equals("end"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("right"))
                    i = 5;
                }
              }
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      }
    return Layout.Alignment.ALIGN_NORMAL;
    return Layout.Alignment.ALIGN_CENTER;
    return Layout.Alignment.ALIGN_OPPOSITE;
  }

  private static void b(String paramString, e.a parama)
    throws NumberFormatException
  {
    int i = paramString.indexOf(',');
    if (i != -1)
    {
      parama.b(a(paramString.substring(i + 1)));
      paramString = paramString.substring(0, i);
    }
    while (paramString.endsWith("%"))
    {
      parama.a(h.b(paramString)).a(0);
      return;
      parama.b(-2147483648);
    }
    int j = Integer.parseInt(paramString);
    if (j < 0)
      j--;
    parama.a(j).a(1);
  }

  private static void c(String paramString, e.a parama)
    throws NumberFormatException
  {
    int i = paramString.indexOf(',');
    if (i != -1)
    {
      parama.c(a(paramString.substring(i + 1)));
      paramString = paramString.substring(0, i);
    }
    while (true)
    {
      parama.b(h.b(paramString));
      return;
      parama.c(-2147483648);
    }
  }

  private static boolean c(String paramString)
  {
    int i = 1;
    int j = -1;
    switch (paramString.hashCode())
    {
    default:
    case 98:
    case 99:
    case 105:
    case 3314158:
    case 117:
    case 118:
    }
    while (true)
    {
      switch (j)
      {
      default:
        i = 0;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      }
      return i;
      if (paramString.equals("b"))
      {
        j = 0;
        continue;
        if (paramString.equals("c"))
        {
          j = i;
          continue;
          if (paramString.equals("i"))
          {
            j = 2;
            continue;
            if (paramString.equals("lang"))
            {
              j = 3;
              continue;
              if (paramString.equals("u"))
              {
                j = 4;
                continue;
                if (paramString.equals("v"))
                  j = 5;
              }
            }
          }
        }
      }
    }
  }

  private static String d(String paramString)
  {
    String str = paramString.trim();
    if (str.isEmpty())
      return null;
    return ag.b(str, "[ \\.]")[0];
  }

  public boolean a(r paramr, e.a parama, List<d> paramList)
  {
    String str1 = paramr.B();
    if (str1 == null);
    Matcher localMatcher2;
    do
    {
      String str2;
      do
      {
        return false;
        Matcher localMatcher1 = a.matcher(str1);
        if (localMatcher1.matches())
          return a(null, localMatcher1, paramr, parama, this.c, paramList);
        str2 = paramr.B();
      }
      while (str2 == null);
      localMatcher2 = a.matcher(str2);
    }
    while (!localMatcher2.matches());
    return a(str1.trim(), localMatcher2, paramr, parama, this.c, paramList);
  }

  private static final class a
  {
    private static final String[] e = new String[0];
    public final String a;
    public final int b;
    public final String c;
    public final String[] d;

    private a(String paramString1, int paramInt, String paramString2, String[] paramArrayOfString)
    {
      this.b = paramInt;
      this.a = paramString1;
      this.c = paramString2;
      this.d = paramArrayOfString;
    }

    public static a a()
    {
      return new a("", 0, "", new String[0]);
    }

    public static a a(String paramString, int paramInt)
    {
      String str1 = paramString.trim();
      if (str1.isEmpty())
        return null;
      int i = str1.indexOf(" ");
      String str3;
      Object localObject;
      String[] arrayOfString1;
      String str4;
      if (i == -1)
      {
        str3 = str1;
        localObject = "";
        arrayOfString1 = ag.a(str3, "\\.");
        str4 = arrayOfString1[0];
        if (arrayOfString1.length <= 1)
          break label109;
      }
      label109: for (String[] arrayOfString2 = (String[])Arrays.copyOfRange(arrayOfString1, 1, arrayOfString1.length); ; arrayOfString2 = e)
      {
        return new a(str4, paramInt, (String)localObject, arrayOfString2);
        String str2 = str1.substring(i).trim();
        str3 = str1.substring(0, i);
        localObject = str2;
        break;
      }
    }
  }

  private static final class b
    implements Comparable<b>
  {
    public final int a;
    public final d b;

    public b(int paramInt, d paramd)
    {
      this.a = paramInt;
      this.b = paramd;
    }

    public int a(b paramb)
    {
      return this.a - paramb.a;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.e.h.f
 * JD-Core Version:    0.6.2
 */