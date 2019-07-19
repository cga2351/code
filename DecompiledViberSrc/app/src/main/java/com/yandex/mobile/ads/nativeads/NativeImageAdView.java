package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;

public class NativeImageAdView extends ae<ax>
{
  private Button a;
  private ImageView b;
  private MediaView c;

  public NativeImageAdView(Context paramContext)
  {
    super(paramContext);
  }

  public NativeImageAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public NativeImageAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  final Button a()
  {
    return this.a;
  }

  final ImageView b()
  {
    return this.b;
  }

  final MediaView c()
  {
    return this.c;
  }

  public void setFeedbackView(Button paramButton)
  {
    this.a = paramButton;
  }

  public void setImageView(ImageView paramImageView)
  {
    this.b = paramImageView;
  }

  public void setMediaView(MediaView paramMediaView)
  {
    this.c = paramMediaView;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.NativeImageAdView
 * JD-Core Version:    0.6.2
 */