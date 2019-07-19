package com.yandex.mobile.ads.video;

import android.content.Context;
import android.text.TextUtils;
import com.yandex.mobile.ads.impl.pw;
import com.yandex.mobile.ads.video.models.blocksinfo.BlocksInfo;

public final class BlocksInfoRequest
{
  private final Context a;
  private final String b;
  private final String c;
  private final RequestListener<BlocksInfo> d;

  private BlocksInfoRequest(Builder paramBuilder)
  {
    this.a = Builder.a(paramBuilder);
    this.b = Builder.b(paramBuilder);
    this.c = Builder.c(paramBuilder);
    this.d = Builder.d(paramBuilder);
  }

  public final String getCategoryId()
  {
    return this.c;
  }

  public final Context getContext()
  {
    return this.a;
  }

  public final String getPartnerId()
  {
    return this.b;
  }

  public final RequestListener<BlocksInfo> getRequestListener()
  {
    return this.d;
  }

  public static final class Builder
  {
    private final Context a;
    private final String b;
    private final RequestListener<BlocksInfo> c;
    private String d = "0";

    public Builder(Context paramContext, String paramString, RequestListener<BlocksInfo> paramRequestListener)
    {
      this.a = paramContext.getApplicationContext();
      this.b = paramString;
      this.c = paramRequestListener;
      pw.a(this.b, "PageId");
    }

    public final BlocksInfoRequest build()
    {
      return new BlocksInfoRequest(this, (byte)0);
    }

    public final Builder setCategory(String paramString)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        this.d = paramString;
        return this;
      }
      throw new IllegalArgumentException("categoryId is empty");
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.video.BlocksInfoRequest
 * JD-Core Version:    0.6.2
 */