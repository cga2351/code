package com.google.android.exoplayer2.e.d;

import android.text.TextUtils;
import com.google.android.exoplayer2.e.c;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.m;
import com.google.android.exoplayer2.g.r;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a extends c
{
  private static final Pattern a = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)(?::|\\.)(\\d+)");
  private final boolean b;
  private int c;
  private int d;
  private int e;
  private int f;

  public a()
  {
    this(null);
  }

  public a(List<byte[]> paramList)
  {
    super("SsaDecoder");
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.b = true;
      String str = ag.a((byte[])paramList.get(0));
      com.google.android.exoplayer2.g.a.a(str.startsWith("Format: "));
      b(str);
      a(new r((byte[])paramList.get(1)));
      return;
    }
    this.b = false;
  }

  public static long a(String paramString)
  {
    Matcher localMatcher = a.matcher(paramString);
    if (!localMatcher.matches())
      return -9223372036854775807L;
    return 1000000L * (60L * (60L * Long.parseLong(localMatcher.group(1)))) + 1000000L * (60L * Long.parseLong(localMatcher.group(2))) + 1000000L * Long.parseLong(localMatcher.group(3)) + 10000L * Long.parseLong(localMatcher.group(4));
  }

  private void a(r paramr)
  {
    String str;
    do
      str = paramr.B();
    while ((str != null) && (!str.startsWith("[Events]")));
  }

  private void a(r paramr, List<com.google.android.exoplayer2.e.b> paramList, m paramm)
  {
    while (true)
    {
      String str = paramr.B();
      if (str == null)
        break;
      if ((!this.b) && (str.startsWith("Format: ")))
        b(str);
      else if (str.startsWith("Dialogue: "))
        a(str, paramList, paramm);
    }
  }

  private void a(String paramString, List<com.google.android.exoplayer2.e.b> paramList, m paramm)
  {
    if (this.c == 0)
      l.c("SsaDecoder", "Skipping dialogue line before complete format: " + paramString);
    long l2;
    do
    {
      return;
      String[] arrayOfString = paramString.substring("Dialogue: ".length()).split(",", this.c);
      if (arrayOfString.length != this.c)
      {
        l.c("SsaDecoder", "Skipping dialogue line with fewer columns than format: " + paramString);
        return;
      }
      long l1 = a(arrayOfString[this.d]);
      if (l1 == -9223372036854775807L)
      {
        l.c("SsaDecoder", "Skipping invalid timing: " + paramString);
        return;
      }
      String str = arrayOfString[this.e];
      if (!str.trim().isEmpty())
      {
        l2 = a(str);
        if (l2 == -9223372036854775807L)
          l.c("SsaDecoder", "Skipping invalid timing: " + paramString);
      }
      else
      {
        l2 = -9223372036854775807L;
      }
      paramList.add(new com.google.android.exoplayer2.e.b(arrayOfString[this.f].replaceAll("\\{.*?\\}", "").replaceAll("\\\\N", "\n").replaceAll("\\\\n", "\n")));
      paramm.a(l1);
    }
    while (l2 == -9223372036854775807L);
    paramList.add(null);
    paramm.a(l2);
  }

  private void b(String paramString)
  {
    String[] arrayOfString = TextUtils.split(paramString.substring("Format: ".length()), ",");
    this.c = arrayOfString.length;
    this.d = -1;
    this.e = -1;
    this.f = -1;
    int i = 0;
    if (i < this.c)
    {
      String str = ag.d(arrayOfString[i].trim());
      label96: int j;
      switch (str.hashCode())
      {
      default:
        j = -1;
        label99: switch (j)
        {
        default:
        case 0:
        case 1:
        case 2:
        }
        break;
      case 109757538:
      case 100571:
      case 3556653:
      }
      while (true)
      {
        i++;
        break;
        if (!str.equals("start"))
          break label96;
        j = 0;
        break label99;
        if (!str.equals("end"))
          break label96;
        j = 1;
        break label99;
        if (!str.equals("text"))
          break label96;
        j = 2;
        break label99;
        this.d = i;
        continue;
        this.e = i;
        continue;
        this.f = i;
      }
    }
    if ((this.d == -1) || (this.e == -1) || (this.f == -1))
      this.c = 0;
  }

  protected b b(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    m localm = new m();
    r localr = new r(paramArrayOfByte, paramInt);
    if (!this.b)
      a(localr);
    a(localr, localArrayList, localm);
    com.google.android.exoplayer2.e.b[] arrayOfb = new com.google.android.exoplayer2.e.b[localArrayList.size()];
    localArrayList.toArray(arrayOfb);
    return new b(arrayOfb, localm.b());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.e.d.a
 * JD-Core Version:    0.6.2
 */