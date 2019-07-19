package com.yandex.mobile.ads.video;

import android.content.Context;
import com.yandex.mobile.ads.impl.fm;
import com.yandex.mobile.ads.impl.pw;
import com.yandex.mobile.ads.video.models.ad.VideoAd;
import com.yandex.mobile.ads.video.models.blocksinfo.BlocksInfo;
import java.util.List;

public final class VideoAdRequest
{
  private final Context a;
  private final BlocksInfo b;
  private final String c;
  private final String d;
  private final String e;
  private final Charset f;
  private final RequestListener<List<VideoAd>> g;
  private final int h;
  private final int i;
  private final int j;
  private final String k;
  private final String l;
  private final String m;
  private final String n;
  private final String o;
  private final String p;
  private final String q;
  private final String r;

  private VideoAdRequest(Builder paramBuilder)
  {
    this.a = Builder.a(paramBuilder);
    this.g = Builder.b(paramBuilder);
    this.b = Builder.c(paramBuilder);
    this.c = Builder.d(paramBuilder);
    this.d = Builder.e(paramBuilder);
    this.e = Builder.f(paramBuilder);
    if (Builder.g(paramBuilder) != null);
    for (Charset localCharset = Builder.g(paramBuilder); ; localCharset = Charset.UTF_8)
    {
      this.f = localCharset;
      this.i = Builder.h(paramBuilder);
      this.j = Builder.i(paramBuilder);
      this.k = Builder.j(paramBuilder);
      this.l = Builder.k(paramBuilder);
      this.m = Builder.l(paramBuilder);
      this.n = Builder.m(paramBuilder);
      this.h = Builder.n(paramBuilder);
      this.o = Builder.o(paramBuilder);
      this.p = Builder.p(paramBuilder);
      this.q = Builder.q(paramBuilder);
      this.r = Builder.r(paramBuilder);
      return;
    }
  }

  private static String a(int paramInt)
  {
    if (paramInt >= 0)
      return Integer.toString(paramInt);
    return null;
  }

  public final String getBlockId()
  {
    return this.c;
  }

  public final BlocksInfo getBlocksInfo()
  {
    return this.b;
  }

  public final Charset getCharset()
  {
    return this.f;
  }

  public final Context getContext()
  {
    return this.a;
  }

  public final String getExtParams()
  {
    return this.r;
  }

  public final String getGenreId()
  {
    return this.o;
  }

  public final String getGenreName()
  {
    return this.p;
  }

  public final String getMaxBitrate()
  {
    return a(this.h);
  }

  public final String getPageRef()
  {
    return this.e;
  }

  public final String getPlayerHeightPix()
  {
    return a(this.j);
  }

  public final String getPlayerWidthPix()
  {
    return a(this.i);
  }

  public final String getPublisherId()
  {
    return this.m;
  }

  public final String getPublisherName()
  {
    return this.n;
  }

  public final RequestListener<List<VideoAd>> getRequestListener()
  {
    return this.g;
  }

  public final String getTagsList()
  {
    return this.q;
  }

  public final String getTargetRef()
  {
    return this.d;
  }

  public final String getVideoContentId()
  {
    return this.k;
  }

  public final String getVideoContentName()
  {
    return this.l;
  }

  public static final class Builder
  {
    private final Context a;
    private final BlocksInfo b;
    private final String c;
    private final String d;
    private final String e;
    private final RequestListener<List<VideoAd>> f;
    private int g = -1;
    private int h = -1;
    private int i = -1;
    private VideoAdRequest.Charset j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;

    public Builder(Context paramContext, BlocksInfo paramBlocksInfo, RequestListener<List<VideoAd>> paramRequestListener, String paramString1, String paramString2, String paramString3)
    {
      this.a = paramContext.getApplicationContext();
      this.b = paramBlocksInfo;
      this.f = paramRequestListener;
      this.c = paramString1;
      this.d = paramString2;
      this.e = paramString3;
      pw.a(this.b, "BlocksInfo");
      pw.a(this.e, "BlockId");
      pw.a(this.c, "TargetRef");
      pw.a(this.d, "PageRef");
    }

    public final VideoAdRequest build()
    {
      return new VideoAdRequest(this, (byte)0);
    }

    public final Builder setCharset(VideoAdRequest.Charset paramCharset)
    {
      this.j = paramCharset;
      return this;
    }

    public final Builder setContentId(String paramString)
    {
      this.k = paramString;
      return this;
    }

    public final Builder setContentName(String paramString)
    {
      this.l = paramString;
      return this;
    }

    public final Builder setExtendedParams(String paramString)
    {
      this.r = paramString;
      return this;
    }

    public final Builder setGenreIds(List<String> paramList)
    {
      this.o = fm.a(paramList);
      return this;
    }

    public final Builder setGenreNames(List<String> paramList)
    {
      this.p = fm.a(paramList);
      return this;
    }

    public final Builder setMaxBitrate(int paramInt)
    {
      this.g = paramInt;
      return this;
    }

    public final Builder setPlayerSize(int paramInt1, int paramInt2)
    {
      this.h = paramInt1;
      this.i = paramInt2;
      return this;
    }

    public final Builder setPublisherId(String paramString)
    {
      this.m = paramString;
      return this;
    }

    public final Builder setPublisherName(String paramString)
    {
      this.n = paramString;
      return this;
    }

    public final Builder setTagsList(List<String> paramList)
    {
      this.q = fm.a(paramList);
      return this;
    }
  }

  public static enum Charset
  {
    private final String a;

    static
    {
      CP_1251 = new Charset("CP_1251", 1, "cp1251");
      KOI_8R = new Charset("KOI_8R", 2, "koi8r");
      KOI_8U = new Charset("KOI_8U", 3, "koi8u");
      Charset[] arrayOfCharset = new Charset[4];
      arrayOfCharset[0] = UTF_8;
      arrayOfCharset[1] = CP_1251;
      arrayOfCharset[2] = KOI_8R;
      arrayOfCharset[3] = KOI_8U;
    }

    private Charset(String paramString)
    {
      this.a = paramString;
    }

    public final String getValue()
    {
      return this.a;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.video.VideoAdRequest
 * JD-Core Version:    0.6.2
 */