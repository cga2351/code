package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public final class NativeContentAdView extends ae<as>
{
  private TextView a;
  private TextView b;
  private Button c;
  private TextView d;
  private Button e;
  private ImageView f;
  private ImageView g;
  private MediaView h;
  private TextView i;
  private TextView j;
  private TextView k;

  public NativeContentAdView(Context paramContext)
  {
    super(paramContext);
  }

  public NativeContentAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public NativeContentAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  final TextView a()
  {
    return this.a;
  }

  final TextView b()
  {
    return this.b;
  }

  final Button c()
  {
    return this.c;
  }

  final TextView d()
  {
    return this.d;
  }

  final Button e()
  {
    return this.e;
  }

  final ImageView f()
  {
    return this.f;
  }

  final ImageView g()
  {
    return this.g;
  }

  public final as getNativeAd()
  {
    return (as)super.getNativeAd();
  }

  final MediaView h()
  {
    return this.h;
  }

  final TextView i()
  {
    return this.i;
  }

  final TextView j()
  {
    return this.j;
  }

  final TextView k()
  {
    return this.k;
  }

  public final void setAgeView(TextView paramTextView)
  {
    this.a = paramTextView;
  }

  public final void setBodyView(TextView paramTextView)
  {
    this.b = paramTextView;
  }

  public final void setCallToActionView(Button paramButton)
  {
    this.c = paramButton;
  }

  public final void setDomainView(TextView paramTextView)
  {
    this.d = paramTextView;
  }

  public final void setFeedbackView(Button paramButton)
  {
    this.e = paramButton;
  }

  public final void setIconView(ImageView paramImageView)
  {
    this.f = paramImageView;
  }

  public final void setImageView(ImageView paramImageView)
  {
    this.g = paramImageView;
  }

  public final void setMediaView(MediaView paramMediaView)
  {
    this.h = paramMediaView;
  }

  public final void setSponsoredView(TextView paramTextView)
  {
    this.i = paramTextView;
  }

  public final void setTitleView(TextView paramTextView)
  {
    this.j = paramTextView;
  }

  public final void setWarningView(TextView paramTextView)
  {
    this.k = paramTextView;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.NativeContentAdView
 * JD-Core Version:    0.6.2
 */