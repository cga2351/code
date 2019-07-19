package com.viber.voip.videoconvert;

import android.net.Uri;
import com.viber.voip.VideoConverterRequest;
import com.viber.voip.videoconvert.gpu.a.d;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class h
  implements c
{
  private static final Pattern a = Pattern.compile(".*[^0-9.]([0-9.]+) fps.*");
  private static final Pattern b = Pattern.compile("\\ *rotate\\ *:\\ *([0-9]*)\\ *");
  private static final Pattern c = Pattern.compile(".*bitrate:.*[^0-9.]([0-9.]+).*");
  private static final Pattern d = Pattern.compile("\\ *Stream.*Audio:.*[^0-9.]([0-9]*)\\ kb\\/s");
  private static final Pattern e = Pattern.compile("^ *major_brand *: *([a-zA-Z0-9_]*) *$");

  static
  {
    d.a("mux", false);
  }

  public static p a(VideoConverterRequest paramVideoConverterRequest)
    throws IOException, InterruptedException
  {
    int i = 0;
    String[] arrayOfString = new String[3];
    arrayOfString[0] = d.a("mux");
    arrayOfString[1] = "-i";
    arrayOfString[2] = paramVideoConverterRequest.source().getPath();
    Process localProcess = Runtime.getRuntime().exec(arrayOfString);
    InputStream localInputStream = localProcess.getErrorStream();
    Scanner localScanner = new Scanner(localInputStream);
    p localp1 = new p();
    while (localScanner.hasNextLine())
    {
      String str = localScanner.nextLine();
      Matcher localMatcher1 = a.matcher(str);
      if (localMatcher1.find())
      {
        localp1.a = Double.parseDouble(localMatcher1.group(1));
        i++;
      }
      Matcher localMatcher2 = b.matcher(str);
      if (localMatcher2.find())
      {
        localp1.b = Integer.parseInt(localMatcher2.group(1));
        i++;
      }
      Matcher localMatcher3 = c.matcher(str);
      if (localMatcher3.matches())
      {
        localp1.c = Integer.parseInt(localMatcher3.group(1));
        i++;
      }
      Matcher localMatcher4 = d.matcher(str);
      if (localMatcher4.find())
      {
        localp1.d = (Integer.parseInt(localMatcher4.group(1)) + localp1.d);
        i++;
      }
      Matcher localMatcher5 = e.matcher(str);
      if (localMatcher5.find())
      {
        localp1.e = localMatcher5.group(1);
        i++;
      }
    }
    if (i == 0);
    for (p localp2 = null; ; localp2 = localp1)
    {
      localProcess.waitFor();
      localScanner.close();
      localInputStream.close();
      return localp2;
    }
  }

  private static <T extends Comparable<T>> T a(T paramT1, T paramT2, T paramT3)
  {
    if (paramT1.compareTo(paramT2) < 0)
      return paramT2;
    if (paramT1.compareTo(paramT3) > 0)
      return paramT3;
    return paramT1;
  }

  public boolean a()
  {
    if (VideoConverterNative.b());
    return false;
  }

  public boolean a(g paramg)
  {
    return a(paramg.a, paramg.c, paramg.d, paramg.e, paramg.f, paramg.g, paramg.h, paramg.i, paramg.j, paramg.k, paramg.l, paramg.m);
  }

  boolean a(String paramString1, double paramDouble, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, VideoConverterNative.IVideoConverterProgressObserver paramIVideoConverterProgressObserver, Integer paramInteger)
  {
    e.a().a("Started Fallback conversion");
    if (paramInteger != null)
      e.a().a("Warning: timeout is not supported in Fallback class");
    String str = d.a("mux");
    String[] arrayOfString = new String[16];
    arrayOfString[0] = str;
    arrayOfString[1] = "-i";
    arrayOfString[2] = paramString1;
    arrayOfString[3] = "-s";
    arrayOfString[4] = (paramInt4 + "x" + paramInt5);
    arrayOfString[5] = "-acodec";
    arrayOfString[6] = "copy";
    arrayOfString[7] = "-vcodec";
    arrayOfString[8] = "h264";
    arrayOfString[9] = "-profile";
    arrayOfString[10] = "baseline";
    arrayOfString[11] = "-preset";
    arrayOfString[12] = "fast";
    arrayOfString[13] = "-f";
    arrayOfString[14] = "mp4";
    arrayOfString[15] = "-y";
    ArrayList localArrayList = new ArrayList(Arrays.asList(arrayOfString));
    if (paramInt6 > 0)
    {
      localArrayList.add("-b");
      localArrayList.add("" + paramInt6);
    }
    if (paramInt1 > 0)
    {
      localArrayList.add("-metadata:s:v:0");
      localArrayList.add("rotate=" + paramInt1);
    }
    if (29.0D <= paramDouble)
    {
      localArrayList.add("-vf");
      localArrayList.add("framestep=" + Math.round(paramDouble / 15.0D));
    }
    double d2;
    int i3;
    int i12;
    int i5;
    int i6;
    if (2 == paramInt7)
    {
      d2 = 1.0D * paramInt2 / paramInt3;
      if (paramInt4 >= paramInt5)
        break label930;
      i3 = paramInt5;
      if (i3 != paramInt4)
        break label937;
      i12 = (int)(0.5D + (i3 + 1) / d2);
      if (i12 <= paramInt5)
        break label1079;
      i5 = (int)(0.5D + d2 * (paramInt5 + 1));
      i6 = paramInt5;
    }
    while (true)
    {
      label387: int i7 = ((Integer)a(Integer.valueOf(1 + (paramInt5 - i6) >> 1), Integer.valueOf(0), Integer.valueOf(paramInt5))).intValue();
      int i8 = ((Integer)a(Integer.valueOf(paramInt5 - i7), Integer.valueOf(0), Integer.valueOf(paramInt5))).intValue();
      int i9 = ((Integer)a(Integer.valueOf(1 + (paramInt4 - i5) >> 1), Integer.valueOf(0), Integer.valueOf(paramInt4))).intValue();
      int i10 = ((Integer)a(Integer.valueOf(paramInt4 - i9), Integer.valueOf(0), Integer.valueOf(paramInt4))).intValue();
      localArrayList.add("-vf");
      localArrayList.add("scale=" + i5 + "x" + i6 + ":flags=fast_bilinear,pad=w=" + i10 + ":h=" + i8 + ":x=" + (i9 >> 1) + ":y=" + (i7 >> 1));
      int j;
      label618: double d1;
      int n;
      int m;
      if (1 == paramInt7)
      {
        if (paramInt4 <= paramInt5)
          break label985;
        j = paramInt5;
        d1 = 1.0D * paramInt2 / paramInt3;
        if (j != paramInt4)
          break label992;
        n = (int)(0.5D + (j + 1) / d1);
        if (n >= paramInt5)
          break label1061;
        m = (int)(0.5D + d1 * (paramInt5 + 1));
        n = paramInt5;
      }
      label930: label937: int i4;
      while (true)
      {
        label985: label992: int k;
        while (true)
        {
          int i1 = ((Integer)a(Integer.valueOf(n - paramInt5 >> 1), Integer.valueOf(0), Integer.valueOf(paramInt5))).intValue();
          int i2 = ((Integer)a(Integer.valueOf(0 + (m - paramInt4) >> 1), Integer.valueOf(0), Integer.valueOf(paramInt4))).intValue();
          localArrayList.add("-vf");
          localArrayList.add("scale=" + paramInt2 + "x" + paramInt3 + ":flags=fast_bilinear,crop=" + paramInt4 + ":" + paramInt5 + ":" + i2 + ":" + i1);
          localArrayList.add(paramString2);
          ProcessBuilder localProcessBuilder = new ProcessBuilder(localArrayList);
          try
          {
            e.a().a("[fallback] cmdline: '" + localProcessBuilder.command().toString().replace(", ", " ") + "'");
            int i = Runtime.getRuntime().exec((String[])localArrayList.toArray(new String[localArrayList.size()])).waitFor();
            if (i == 0)
            {
              return true;
              i3 = paramInt4;
              break;
              i4 = (int)(0.5D + d2 * (i3 + 1));
              if (i4 >= paramInt4)
                break label1068;
              int i11 = (int)(0.5D + (paramInt4 + 1) / d2);
              i5 = paramInt4;
              i6 = i11;
              break label387;
              j = paramInt4;
              break label618;
              k = (int)(0.5D + d1 * (j + 1));
              if (k <= paramInt4)
                break label1050;
              n = (int)(0.5D + (paramInt4 + 1) / d1);
              m = paramInt4;
              continue;
            }
            return false;
          }
          catch (Exception localException)
          {
            e.a().a(localException);
            return false;
          }
        }
        label1050: m = k;
        n = paramInt5;
        continue;
        label1061: m = paramInt4;
      }
      label1068: i5 = i4;
      i6 = paramInt5;
      continue;
      label1079: i5 = paramInt4;
      i6 = i12;
    }
  }

  public String b()
  {
    return "soft";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.h
 * JD-Core Version:    0.6.2
 */