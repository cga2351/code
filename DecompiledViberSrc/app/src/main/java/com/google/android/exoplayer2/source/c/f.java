package com.google.android.exoplayer2.source.c;

import android.net.Uri;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.g.ad;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public abstract interface f
{
  public static final f a = new c();

  public abstract Pair<g, Boolean> a(g paramg, Uri paramUri, Format paramFormat, List<Format> paramList, DrmInitData paramDrmInitData, ad paramad, Map<String, List<String>> paramMap, h paramh)
    throws InterruptedException, IOException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c.f
 * JD-Core Version:    0.6.2
 */