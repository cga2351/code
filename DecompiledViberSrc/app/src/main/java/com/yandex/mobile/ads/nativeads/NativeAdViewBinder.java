package com.yandex.mobile.ads.nativeads;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class NativeAdViewBinder
{
  private final View a;
  private final TextView b;
  private final TextView c;
  private final Button d;
  private final TextView e;
  private final ImageView f;
  private final Button g;
  private final ImageView h;
  private final ImageView i;
  private final MediaView j;
  private final TextView k;
  private final View l;
  private final TextView m;
  private final TextView n;
  private final TextView o;
  private final TextView p;

  private NativeAdViewBinder(Builder paramBuilder)
  {
    this.a = Builder.a(paramBuilder);
    this.b = Builder.b(paramBuilder);
    this.c = Builder.c(paramBuilder);
    this.d = Builder.d(paramBuilder);
    this.e = Builder.e(paramBuilder);
    this.f = Builder.f(paramBuilder);
    this.g = Builder.g(paramBuilder);
    this.h = Builder.h(paramBuilder);
    this.i = Builder.i(paramBuilder);
    this.j = Builder.j(paramBuilder);
    this.k = Builder.k(paramBuilder);
    this.l = Builder.l(paramBuilder);
    this.m = Builder.m(paramBuilder);
    this.n = Builder.n(paramBuilder);
    this.o = Builder.o(paramBuilder);
    this.p = Builder.p(paramBuilder);
  }

  TextView getAgeView()
  {
    return this.b;
  }

  TextView getBodyView()
  {
    return this.c;
  }

  Button getCallToActionView()
  {
    return this.d;
  }

  TextView getDomainView()
  {
    return this.e;
  }

  ImageView getFaviconView()
  {
    return this.f;
  }

  Button getFeedbackView()
  {
    return this.g;
  }

  ImageView getIconView()
  {
    return this.h;
  }

  ImageView getImageView()
  {
    return this.i;
  }

  MediaView getMediaView()
  {
    return this.j;
  }

  View getNativeAdView()
  {
    return this.a;
  }

  TextView getPriceView()
  {
    return this.k;
  }

  View getRatingView()
  {
    return this.l;
  }

  TextView getReviewCountView()
  {
    return this.m;
  }

  TextView getSponsoredView()
  {
    return this.n;
  }

  TextView getTitleView()
  {
    return this.o;
  }

  TextView getWarningView()
  {
    return this.p;
  }

  public static final class Builder
  {
    private final View a;
    private TextView b;
    private TextView c;
    private Button d;
    private TextView e;
    private ImageView f;
    private Button g;
    private ImageView h;
    private ImageView i;
    private MediaView j;
    private TextView k;
    private View l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;

    public Builder(View paramView)
    {
      this.a = paramView;
    }

    public final NativeAdViewBinder build()
    {
      return new NativeAdViewBinder(this, null);
    }

    public final Builder setAgeView(TextView paramTextView)
    {
      this.b = paramTextView;
      return this;
    }

    public final Builder setBodyView(TextView paramTextView)
    {
      this.c = paramTextView;
      return this;
    }

    public final Builder setCallToActionView(Button paramButton)
    {
      this.d = paramButton;
      return this;
    }

    public final Builder setDomainView(TextView paramTextView)
    {
      this.e = paramTextView;
      return this;
    }

    public final Builder setFaviconView(ImageView paramImageView)
    {
      this.f = paramImageView;
      return this;
    }

    public final Builder setFeedbackView(Button paramButton)
    {
      this.g = paramButton;
      return this;
    }

    public final Builder setIconView(ImageView paramImageView)
    {
      this.h = paramImageView;
      return this;
    }

    public final Builder setImageView(ImageView paramImageView)
    {
      this.i = paramImageView;
      return this;
    }

    public final Builder setMediaView(MediaView paramMediaView)
    {
      this.j = paramMediaView;
      return this;
    }

    public final Builder setPriceView(TextView paramTextView)
    {
      this.k = paramTextView;
      return this;
    }

    public final <T extends View,  extends Rating> Builder setRatingView(T paramT)
    {
      this.l = paramT;
      return this;
    }

    public final Builder setReviewCountView(TextView paramTextView)
    {
      this.m = paramTextView;
      return this;
    }

    public final Builder setSponsoredView(TextView paramTextView)
    {
      this.n = paramTextView;
      return this;
    }

    public final Builder setTitleView(TextView paramTextView)
    {
      this.o = paramTextView;
      return this;
    }

    public final Builder setWarningView(TextView paramTextView)
    {
      this.p = paramTextView;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.NativeAdViewBinder
 * JD-Core Version:    0.6.2
 */