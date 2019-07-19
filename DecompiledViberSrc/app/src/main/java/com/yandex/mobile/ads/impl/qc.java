package com.yandex.mobile.ads.impl;

import android.net.Uri;
import android.net.Uri.Builder;
import com.yandex.mobile.ads.video.BlocksInfoRequest;
import com.yandex.mobile.ads.video.VideoAdRequest;
import com.yandex.mobile.ads.video.tracking.Tracker.ErrorListener;

public final class qc
{
  public static final oj.a a = new oj.a()
  {
    public final boolean a(oi<?> paramAnonymousoi)
    {
      return true;
    }
  };
  private final oj b;

  public qc(oj paramoj)
  {
    this.b = paramoj;
  }

  public final void a(BlocksInfoRequest paramBlocksInfoRequest)
  {
    String str1 = paramBlocksInfoRequest.getPartnerId();
    String str2 = paramBlocksInfoRequest.getCategoryId();
    qe localqe = new qe(paramBlocksInfoRequest, new Uri.Builder().scheme("https").encodedAuthority("mobile.yandexadexchange.net").appendPath("v1").appendPath("vcset").appendPath(str1).appendQueryParameter("video-category-id", str2).appendQueryParameter("uuid", qd.b().a()).build().toString(), new qd.b(paramBlocksInfoRequest.getRequestListener()), new qj());
    this.b.a(localqe);
  }

  public final void a(VideoAdRequest paramVideoAdRequest)
  {
    qh localqh = qd.c.a(paramVideoAdRequest);
    this.b.a(localqh);
  }

  public final void a(String paramString, Tracker.ErrorListener paramErrorListener)
  {
    qf localqf = new qf(paramString, new qd.a(paramErrorListener));
    this.b.a(localqf);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.qc
 * JD-Core Version:    0.6.2
 */