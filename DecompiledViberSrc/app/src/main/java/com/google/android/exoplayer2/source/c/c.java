package com.google.android.exoplayer2.source.c;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.a;
import com.google.android.exoplayer2.extractor.f.ac;
import com.google.android.exoplayer2.extractor.f.d;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.mp4.e;
import com.google.android.exoplayer2.g.ad;
import com.google.android.exoplayer2.g.o;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class c
  implements f
{
  private final int b;

  public c()
  {
    this(0);
  }

  public c(int paramInt)
  {
    this.b = paramInt;
  }

  private static Pair<com.google.android.exoplayer2.extractor.g, Boolean> a(com.google.android.exoplayer2.extractor.g paramg)
  {
    if (((paramg instanceof d)) || ((paramg instanceof a)) || ((paramg instanceof com.google.android.exoplayer2.extractor.d.c)));
    for (boolean bool = true; ; bool = false)
      return new Pair(paramg, Boolean.valueOf(bool));
  }

  private static ac a(int paramInt, Format paramFormat, List<Format> paramList, ad paramad)
  {
    int i = paramInt | 0x10;
    if (paramList != null)
      i |= 32;
    while (true)
    {
      String str = paramFormat.codecs;
      if (!TextUtils.isEmpty(str))
      {
        if (!"audio/mp4a-latm".equals(o.e(str)))
          i |= 2;
        if (!"video/avc".equals(o.d(str)))
          i |= 4;
      }
      return new ac(2, paramad, new com.google.android.exoplayer2.extractor.f.g(i, paramList));
      paramList = Collections.singletonList(Format.createTextSampleFormat(null, "application/cea-608", 0, null));
    }
  }

  private com.google.android.exoplayer2.extractor.g a(Uri paramUri, Format paramFormat, List<Format> paramList, DrmInitData paramDrmInitData, ad paramad)
  {
    String str = paramUri.getLastPathSegment();
    if (str == null)
      str = "";
    if (("text/vtt".equals(paramFormat.sampleMimeType)) || (str.endsWith(".webvtt")) || (str.endsWith(".vtt")))
      return new q(paramFormat.language, paramad);
    if (str.endsWith(".aac"))
      return new d();
    if ((str.endsWith(".ac3")) || (str.endsWith(".ec3")))
      return new a();
    if (str.endsWith(".mp3"))
      return new com.google.android.exoplayer2.extractor.d.c(0, 0L);
    if ((str.endsWith(".mp4")) || (str.startsWith(".m4", -4 + str.length())) || (str.startsWith(".mp4", -5 + str.length())) || (str.startsWith(".cmf", -5 + str.length())))
    {
      if (paramList != null);
      for (Object localObject = paramList; ; localObject = Collections.emptyList())
        return new e(0, paramad, null, paramDrmInitData, (List)localObject);
    }
    return a(this.b, paramFormat, paramList, paramad);
  }

  // ERROR //
  private static boolean a(com.google.android.exoplayer2.extractor.g paramg, h paramh)
    throws InterruptedException, IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokeinterface 170 2 0
    //   7: istore 4
    //   9: aload_1
    //   10: invokeinterface 174 1 0
    //   15: iload 4
    //   17: ireturn
    //   18: astore_3
    //   19: aload_1
    //   20: invokeinterface 174 1 0
    //   25: iconst_0
    //   26: ireturn
    //   27: astore_2
    //   28: aload_1
    //   29: invokeinterface 174 1 0
    //   34: aload_2
    //   35: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	9	18	java/io/EOFException
    //   0	9	27	finally
  }

  public Pair<com.google.android.exoplayer2.extractor.g, Boolean> a(com.google.android.exoplayer2.extractor.g paramg, Uri paramUri, Format paramFormat, List<Format> paramList, DrmInitData paramDrmInitData, ad paramad, Map<String, List<String>> paramMap, h paramh)
    throws InterruptedException, IOException
  {
    if (paramg != null)
    {
      if (((paramg instanceof ac)) || ((paramg instanceof e)))
        return a(paramg);
      if ((paramg instanceof q))
        return a(new q(paramFormat.language, paramad));
      if ((paramg instanceof d))
        return a(new d());
      if ((paramg instanceof a))
        return a(new a());
      if ((paramg instanceof com.google.android.exoplayer2.extractor.d.c))
        return a(new com.google.android.exoplayer2.extractor.d.c());
      throw new IllegalArgumentException("Unexpected previousExtractor type: " + paramg.getClass().getSimpleName());
    }
    com.google.android.exoplayer2.extractor.g localg = a(paramUri, paramFormat, paramList, paramDrmInitData, paramad);
    paramh.a();
    if (a(localg, paramh))
      return a(localg);
    if (!(localg instanceof q))
    {
      q localq = new q(paramFormat.language, paramad);
      if (a(localq, paramh))
        return a(localq);
    }
    if (!(localg instanceof d))
    {
      d locald = new d();
      if (a(locald, paramh))
        return a(locald);
    }
    if (!(localg instanceof a))
    {
      a locala = new a();
      if (a(locala, paramh))
        return a(locala);
    }
    if (!(localg instanceof com.google.android.exoplayer2.extractor.d.c))
    {
      com.google.android.exoplayer2.extractor.d.c localc = new com.google.android.exoplayer2.extractor.d.c(0, 0L);
      if (a(localc, paramh))
        return a(localc);
    }
    if (!(localg instanceof e))
    {
      if (paramList != null);
      for (Object localObject = paramList; ; localObject = Collections.emptyList())
      {
        e locale = new e(0, paramad, null, paramDrmInitData, (List)localObject);
        if (!a(locale, paramh))
          break;
        return a(locale);
      }
    }
    if (!(localg instanceof ac))
    {
      ac localac = a(this.b, paramFormat, paramList, paramad);
      if (a(localac, paramh))
        return a(localac);
    }
    return a(localg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c.c
 * JD-Core Version:    0.6.2
 */