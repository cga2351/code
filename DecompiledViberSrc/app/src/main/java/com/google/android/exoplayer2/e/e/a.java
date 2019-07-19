package com.google.android.exoplayer2.e.e;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import com.google.android.exoplayer2.e.c;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.m;
import com.google.android.exoplayer2.g.r;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a extends c
{
  private static final Pattern a = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))?\\s*");
  private static final Pattern b = Pattern.compile("\\{\\\\.*?\\}");
  private final StringBuilder c = new StringBuilder();
  private final ArrayList<String> d = new ArrayList();

  public a()
  {
    super("SubripDecoder");
  }

  private static long a(Matcher paramMatcher, int paramInt)
  {
    return 1000L * (1000L * (60L * (60L * Long.parseLong(paramMatcher.group(paramInt + 1)))) + 1000L * (60L * Long.parseLong(paramMatcher.group(paramInt + 2))) + 1000L * Long.parseLong(paramMatcher.group(paramInt + 3)) + Long.parseLong(paramMatcher.group(paramInt + 4)));
  }

  private com.google.android.exoplayer2.e.b a(Spanned paramSpanned, String paramString)
  {
    int i = -1;
    if (paramString == null)
      return new com.google.android.exoplayer2.e.b(paramSpanned);
    int j;
    label103: int k;
    label147: label232: int m;
    switch (paramString.hashCode())
    {
    default:
      j = i;
      switch (j)
      {
      default:
        k = 1;
        switch (paramString.hashCode())
        {
        default:
          switch (i)
          {
          default:
            m = 1;
          case 0:
          case 1:
          case 2:
          case 3:
          case 4:
          case 5:
          }
          break;
        case -685620710:
        case -685620679:
        case -685620648:
        case -685620524:
        case -685620493:
        case -685620462:
        case -685620617:
        case -685620586:
        case -685620555:
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      }
      break;
    case -685620710:
    case -685620617:
    case -685620524:
    case -685620648:
    case -685620555:
    case -685620462:
    case -685620679:
    case -685620586:
    case -685620493:
    }
    while (true)
    {
      return new com.google.android.exoplayer2.e.b(paramSpanned, null, b(m), 0, m, b(k), k, 1.4E-45F);
      if (!paramString.equals("{\\an1}"))
        break;
      j = 0;
      break label103;
      if (!paramString.equals("{\\an4}"))
        break;
      j = 1;
      break label103;
      if (!paramString.equals("{\\an7}"))
        break;
      j = 2;
      break label103;
      if (!paramString.equals("{\\an3}"))
        break;
      j = 3;
      break label103;
      if (!paramString.equals("{\\an6}"))
        break;
      j = 4;
      break label103;
      if (!paramString.equals("{\\an9}"))
        break;
      j = 5;
      break label103;
      if (!paramString.equals("{\\an2}"))
        break;
      j = 6;
      break label103;
      if (!paramString.equals("{\\an5}"))
        break;
      j = 7;
      break label103;
      if (!paramString.equals("{\\an8}"))
        break;
      j = 8;
      break label103;
      k = 0;
      break label147;
      k = 2;
      break label147;
      if (!paramString.equals("{\\an1}"))
        break label232;
      i = 0;
      break label232;
      if (!paramString.equals("{\\an2}"))
        break label232;
      i = 1;
      break label232;
      if (!paramString.equals("{\\an3}"))
        break label232;
      i = 2;
      break label232;
      if (!paramString.equals("{\\an7}"))
        break label232;
      i = 3;
      break label232;
      if (!paramString.equals("{\\an8}"))
        break label232;
      i = 4;
      break label232;
      if (!paramString.equals("{\\an9}"))
        break label232;
      i = 5;
      break label232;
      if (!paramString.equals("{\\an4}"))
        break label232;
      i = 6;
      break label232;
      if (!paramString.equals("{\\an5}"))
        break label232;
      i = 7;
      break label232;
      if (!paramString.equals("{\\an6}"))
        break label232;
      i = 8;
      break label232;
      m = 2;
      continue;
      m = 0;
    }
  }

  private String a(String paramString, ArrayList<String> paramArrayList)
  {
    String str1 = paramString.trim();
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder(str1);
    Matcher localMatcher = b.matcher(str1);
    while (localMatcher.find())
    {
      String str2 = localMatcher.group();
      paramArrayList.add(str2);
      int j = localMatcher.start() - i;
      int k = str2.length();
      localStringBuilder.replace(j, j + k, "");
      i += k;
    }
    return localStringBuilder.toString();
  }

  static float b(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return 0.92F;
    case 0:
      return 0.08F;
    case 1:
    }
    return 0.5F;
  }

  protected b b(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    m localm = new m();
    r localr = new r(paramArrayOfByte, paramInt);
    String str2;
    while (true)
    {
      String str1 = localr.B();
      if ((str1 == null) || (str1.length() != 0))
        try
        {
          Integer.parseInt(str1);
          str2 = localr.B();
          if (str2 != null)
            break;
          l.c("SubripDecoder", "Unexpected end");
          com.google.android.exoplayer2.e.b[] arrayOfb = new com.google.android.exoplayer2.e.b[localArrayList.size()];
          localArrayList.toArray(arrayOfb);
          return new b(arrayOfb, localm.b());
        }
        catch (NumberFormatException localNumberFormatException)
        {
          l.c("SubripDecoder", "Skipping invalid index: " + str1);
        }
    }
    Matcher localMatcher = a.matcher(str2);
    if (localMatcher.matches())
    {
      localm.a(a(localMatcher, 1));
      if (TextUtils.isEmpty(localMatcher.group(6)))
        break label385;
      localm.a(a(localMatcher, 6));
    }
    label385: for (int i = 1; ; i = 0)
    {
      this.c.setLength(0);
      this.d.clear();
      while (true)
      {
        String str3 = localr.B();
        if (TextUtils.isEmpty(str3))
          break;
        if (this.c.length() > 0)
          this.c.append("<br>");
        this.c.append(a(str3, this.d));
      }
      l.c("SubripDecoder", "Skipping invalid timing: " + str2);
      break;
      Spanned localSpanned = Html.fromHtml(this.c.toString());
      int j = 0;
      label308: String str4;
      if (j < this.d.size())
      {
        str4 = (String)this.d.get(j);
        if (!str4.matches("\\{\\\\an[1-9]\\}"));
      }
      while (true)
      {
        localArrayList.add(a(localSpanned, str4));
        if (i == 0)
          break;
        localArrayList.add(null);
        break;
        j++;
        break label308;
        str4 = null;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.e.e.a
 * JD-Core Version:    0.6.2
 */