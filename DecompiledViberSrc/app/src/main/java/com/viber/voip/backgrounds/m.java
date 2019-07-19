package com.viber.voip.backgrounds;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.ColorUtils;
import android.text.TextUtils;
import android.util.Pair;
import com.viber.common.b.b;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.R.color;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.settings.d.i;
import com.viber.voip.util.as;
import com.viber.voip.util.at;
import com.viber.voip.util.bu;
import com.viber.voip.util.dc;
import com.viber.voip.util.dq;
import com.viber.voip.util.e.j;
import com.viber.voip.util.upload.o;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class m
{
  public static final String a = "r" + g.a + "_";
  private static final Logger b = ViberEnv.getLogger();
  private static final Pattern c = Pattern.compile("\\B1([0-9a-f]{7})(_tail(_color#[0-9A-F]{6})?)*", 2);
  private static final Pattern d = Pattern.compile("([0-9]{8})\\.jpg$", 2);
  private static final Pattern e = Pattern.compile(".*_([0-9]{8})_.*\\.jpg$", 2);
  private static final Pattern f = Pattern.compile("^[tc]?(\\d+)$", 2);
  private static final Pattern g = Pattern.compile("_color#[0-9A-F]{6}", 2);
  private static int h;

  public static int a(Context paramContext)
  {
    if (h == 0)
      h = ContextCompat.getColor(paramContext, R.color.solid_30);
    return h;
  }

  public static int a(Context paramContext, int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      if (!d.i.f.d())
        paramString = d.i.d.d();
    while (!c(paramString))
    {
      File localFile = new File(Uri.parse(paramString).getPath());
      if (!localFile.exists())
        break;
      Bitmap localBitmap = dq.a(localFile.getAbsolutePath());
      float f1 = j.f(localBitmap);
      if (localBitmap != null)
        localBitmap.recycle();
      if (f1 <= 0.8F)
        break;
      return a(paramContext);
      if ((com.viber.voip.messages.m.a(paramInt)) || (dc.b()))
        return a(paramContext);
      return ContextCompat.getColor(paramContext, R.color.negative);
    }
    if ((com.viber.voip.messages.m.a(paramInt)) || (dc.b()))
      return a(paramContext);
    return ContextCompat.getColor(paramContext, R.color.negative);
    return ContextCompat.getColor(paramContext, R.color.negative);
  }

  public static int a(String paramString)
  {
    return a(paramString, d, 1);
  }

  private static int a(String paramString, Pattern paramPattern, int paramInt)
  {
    Matcher localMatcher = paramPattern.matcher(paramString);
    if (localMatcher.find())
      try
      {
        int i = Integer.parseInt(localMatcher.group(paramInt), 10);
        return i;
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
    return -1;
  }

  public static p a(int paramInt, List<p> paramList)
  {
    String str1 = d.i.g.d();
    boolean bool = str1.startsWith("c");
    Pair localPair = e(str1);
    p localp;
    if (bool)
    {
      Iterator localIterator = paramList.iterator();
      do
      {
        if (!localIterator.hasNext())
          break;
        localp = (p)localIterator.next();
      }
      while (localp.a != ((Integer)localPair.first).intValue());
    }
    for (String str2 = localp.c; ; str2 = null)
      return new p(((Integer)localPair.first).intValue(), paramInt, ((Boolean)localPair.second).booleanValue(), str2);
  }

  public static p a(String paramString, int paramInt)
  {
    if (paramString.contains("IMG"));
    Matcher localMatcher1;
    do
    {
      return null;
      localMatcher1 = c.matcher(paramString);
    }
    while (!localMatcher1.find());
    String str1 = localMatcher1.group(0);
    boolean bool = paramString.contains("_tail");
    Matcher localMatcher2;
    if (paramString.contains("_color"))
    {
      localMatcher2 = g.matcher(paramString);
      if (!localMatcher2.find());
    }
    for (String str2 = localMatcher2.group(0).replace("_color", ""); ; str2 = null)
      try
      {
        p localp = new p(Integer.parseInt(str1.substring(0, 8), 10), paramInt, bool, str2);
        return localp;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        return null;
      }
  }

  public static File a(int paramInt, Context paramContext)
  {
    if (paramInt < 0)
      throw new IllegalArgumentException("Background package id must be a non negative int");
    return new File(b(paramContext), String.valueOf(paramInt));
  }

  public static File a(l paraml, Context paramContext)
  {
    return b(paraml.a, paramContext);
  }

  public static File a(String paramString, Context paramContext)
  {
    return new File(b(paramContext), as.k.a(bu.a(paramString)));
  }

  public static String a()
  {
    return ap.c().E;
  }

  public static String a(int paramInt1, int paramInt2, String paramString)
  {
    return ap.c().G.replaceAll("%RES%", Integer.toString(paramInt2)).replaceAll("%ID%", paramString + d(paramInt1));
  }

  public static void a(int paramInt, p paramp, boolean paramBoolean)
  {
    File localFile1;
    if (o.c())
    {
      localFile1 = b(paramInt, ViberApplication.getApplication());
      if (paramBoolean)
        break label24;
      at.h(localFile1);
    }
    label24: File[] arrayOfFile;
    do
    {
      return;
      arrayOfFile = localFile1.listFiles();
    }
    while (arrayOfFile == null);
    String str = paramp.i.getPath();
    int i = arrayOfFile.length;
    int j = 0;
    label52: File localFile2;
    if (j < i)
    {
      localFile2 = arrayOfFile[j];
      if (!localFile2.getAbsolutePath().equals(str))
        break label85;
    }
    while (true)
    {
      j++;
      break label52;
      break;
      label85: at.f(localFile2);
    }
  }

  public static boolean a(int paramInt)
  {
    String str = d.i.g.d();
    return (!TextUtils.isEmpty(str)) && (str.contains(Integer.toString(paramInt)));
  }

  public static boolean a(Context paramContext, int paramInt)
  {
    return paramInt != a(paramContext);
  }

  public static int b(String paramString)
  {
    return a(paramString, e, 1);
  }

  public static File b(int paramInt, Context paramContext)
  {
    return new File(a(paramInt, paramContext), ".thumbnails");
  }

  public static File b(Context paramContext)
  {
    return at.b(paramContext, ".backgrounds");
  }

  public static String b()
  {
    return ap.c().F;
  }

  public static void b(int paramInt)
  {
    int j;
    File localFile;
    if (o.c())
    {
      File[] arrayOfFile = b(ViberApplication.getApplication()).listFiles();
      if (arrayOfFile != null)
      {
        int i = arrayOfFile.length;
        j = 0;
        if (j < i)
        {
          localFile = arrayOfFile[j];
          if ((new File(localFile.getAbsolutePath()).isDirectory()) && (TextUtils.isDigitsOnly(localFile.getName())));
        }
      }
    }
    while (true)
    {
      j++;
      break;
      try
      {
        int k = Integer.parseInt(localFile.getName());
        if (k != paramInt)
        {
          at.h(localFile);
          continue;
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
    }
  }

  public static boolean b(Context paramContext, int paramInt)
  {
    return paramInt == a(paramContext);
  }

  public static boolean c(int paramInt)
  {
    return -16777216 == ColorUtils.setAlphaComponent(paramInt, 255);
  }

  public static boolean c(String paramString)
  {
    return (paramString != null) && (a(b(paramString)));
  }

  private static String d(int paramInt)
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    return String.format(localLocale, "%08d", arrayOfObject);
  }

  public static boolean d(String paramString)
  {
    return (dc.a()) && (c(paramString));
  }

  public static Pair<Integer, Boolean> e(String paramString)
  {
    if ((paramString.startsWith("t")) || (paramString.startsWith("c")));
    for (boolean bool = true; ; bool = false)
    {
      Boolean localBoolean = Boolean.valueOf(bool);
      return new Pair(Integer.valueOf(a(paramString, f, 1)), localBoolean);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backgrounds.m
 * JD-Core Version:    0.6.2
 */