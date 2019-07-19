package com.yandex.mobile.ads.nativeads;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.yandex.mobile.ads.impl.in;
import com.yandex.mobile.ads.impl.iv;
import com.yandex.mobile.ads.impl.le;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class af<T extends View>
{
  private final f a;
  private final i b;
  private final aj c;
  private final Map<String, in> d;
  private final NativeAdViewBinder e;

  public af(T paramT, ai<T> paramai, i parami, f paramf)
  {
    this.a = paramf;
    this.b = parami;
    this.c = paramai.a(paramT);
    this.d = new iv(this.c, this.b).a();
    this.e = a(paramT);
  }

  private NativeAdViewBinder a(T paramT)
  {
    NativeAdViewBinder.Builder localBuilder1 = new NativeAdViewBinder.Builder(paramT);
    try
    {
      NativeAdViewBinder.Builder localBuilder2 = localBuilder1.setAgeView(this.c.b()).setBodyView(this.c.c());
      TextView localTextView = this.c.d();
      if ((localTextView instanceof Button));
      for (Button localButton = (Button)localTextView; ; localButton = null)
      {
        localBuilder2.setCallToActionView(localButton).setDomainView(this.c.f()).setFaviconView(this.c.g()).setFeedbackView(this.c.h()).setIconView(this.c.i()).setImageView(this.c.j()).setMediaView(this.c.k()).setPriceView(this.c.l()).setRatingView(this.c.m()).setReviewCountView(this.c.n()).setSponsoredView(this.c.o()).setTitleView(this.c.p()).setWarningView(this.c.q());
        label184: return localBuilder1.build();
      }
    }
    catch (Exception localException)
    {
      break label184;
    }
  }

  final in a(le paramle)
  {
    if (paramle != null)
      return (in)this.d.get(paramle.a());
    return null;
  }

  final void a()
  {
    Iterator localIterator = this.d.values().iterator();
    while (localIterator.hasNext())
    {
      in localin = (in)localIterator.next();
      if (localin != null)
        localin.a();
    }
  }

  public final View b()
  {
    return this.c.a();
  }

  public final aj c()
  {
    return this.c;
  }

  public final f d()
  {
    return this.a;
  }

  public final i e()
  {
    return this.b;
  }

  public final NativeAdViewBinder f()
  {
    return this.e;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.af
 * JD-Core Version:    0.6.2
 */