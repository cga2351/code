package com.facebook.react.devsupport;

import f.c;
import f.e;
import f.f;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MultipartStreamReader
{
  private static final String CRLF = "\r\n";
  private final String mBoundary;
  private long mLastProgressEvent;
  private final e mSource;

  public MultipartStreamReader(e parame, String paramString)
  {
    this.mSource = parame;
    this.mBoundary = paramString;
  }

  private void emitChunk(c paramc, boolean paramBoolean, ChunkListener paramChunkListener)
    throws IOException
  {
    f localf = f.a("\r\n\r\n");
    long l = paramc.b(localf);
    if (l == -1L)
    {
      paramChunkListener.onChunkComplete(null, paramc, paramBoolean);
      return;
    }
    c localc1 = new c();
    c localc2 = new c();
    paramc.read(localc1, l);
    paramc.i(localf.h());
    paramc.a(localc2);
    paramChunkListener.onChunkComplete(parseHeaders(localc1), localc2, paramBoolean);
  }

  private void emitProgress(Map<String, String> paramMap, long paramLong, boolean paramBoolean, ChunkListener paramChunkListener)
    throws IOException
  {
    if ((paramMap == null) || (paramChunkListener == null));
    long l1;
    do
    {
      return;
      l1 = System.currentTimeMillis();
    }
    while ((l1 - this.mLastProgressEvent <= 16L) && (!paramBoolean));
    this.mLastProgressEvent = l1;
    if (paramMap.get("Content-Length") != null);
    for (long l2 = Long.parseLong((String)paramMap.get("Content-Length")); ; l2 = 0L)
    {
      paramChunkListener.onChunkProgress(paramMap, paramLong, l2);
      return;
    }
  }

  private Map<String, String> parseHeaders(c paramc)
  {
    HashMap localHashMap = new HashMap();
    String[] arrayOfString = paramc.r().split("\r\n");
    int i = arrayOfString.length;
    int j = 0;
    if (j < i)
    {
      String str = arrayOfString[j];
      int k = str.indexOf(":");
      if (k == -1);
      while (true)
      {
        j++;
        break;
        localHashMap.put(str.substring(0, k).trim(), str.substring(k + 1).trim());
      }
    }
    return localHashMap;
  }

  public boolean readAllParts(ChunkListener paramChunkListener)
    throws IOException
  {
    f localf1 = f.a("\r\n--" + this.mBoundary + "\r\n");
    f localf2 = f.a("\r\n--" + this.mBoundary + "--" + "\r\n");
    f localf3 = f.a("\r\n\r\n");
    long l1 = 0L;
    c localc1 = new c();
    Map localMap = null;
    long l2 = 0L;
    long l3 = 0L;
    while (true)
    {
      long l4 = Math.max(l1 - localf2.h(), l3);
      long l5 = localc1.a(localf1, l4);
      if (l5 == -1L)
        l5 = localc1.a(localf2, l4);
      long l8;
      long l10;
      for (boolean bool = true; ; bool = false)
      {
        if (l5 == -1L)
        {
          l8 = localc1.a();
          if (localMap == null)
          {
            long l11 = localc1.a(localf3, l4);
            if (l11 < 0L)
              break label283;
            this.mSource.read(localc1, l11);
            c localc3 = new c();
            localc1.a(localc3, l4, l11 - l4);
            l10 = localc3.a() + localf3.h();
            localMap = parseHeaders(localc3);
          }
          while (this.mSource.read(localc1, 4096) <= 0L)
          {
            return false;
            long l9 = localc1.a() - l2;
            emitProgress(localMap, l9, false, paramChunkListener);
            label283: l10 = l2;
          }
        }
        long l6 = l5 - l3;
        if (l3 > 0L)
        {
          c localc2 = new c();
          localc1.i(l3);
          localc1.read(localc2, l6);
          long l7 = localc2.a() - l2;
          emitProgress(localMap, l7, true, paramChunkListener);
          emitChunk(localc2, bool, paramChunkListener);
          localMap = null;
          l2 = 0L;
        }
        while (bool)
        {
          return true;
          localc1.i(l5);
        }
        l1 = localf1.h();
        l3 = l1;
        break;
      }
      l2 = l10;
      l1 = l8;
    }
  }

  public static abstract interface ChunkListener
  {
    public abstract void onChunkComplete(Map<String, String> paramMap, c paramc, boolean paramBoolean)
      throws IOException;

    public abstract void onChunkProgress(Map<String, String> paramMap, long paramLong1, long paramLong2)
      throws IOException;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.MultipartStreamReader
 * JD-Core Version:    0.6.2
 */