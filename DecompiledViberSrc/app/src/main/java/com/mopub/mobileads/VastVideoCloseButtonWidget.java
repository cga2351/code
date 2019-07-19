package com.mopub.mobileads;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils.TruncateAt;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.resource.CloseButtonDrawable;
import com.mopub.mobileads.resource.DrawableConstants.CloseButton;
import com.mopub.network.Networking;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader;
import com.mopub.volley.toolbox.ImageLoader.ImageContainer;
import com.mopub.volley.toolbox.ImageLoader.ImageListener;

public class VastVideoCloseButtonWidget extends RelativeLayout
{
  private TextView a;
  private ImageView b;
  private final ImageLoader c;
  private CloseButtonDrawable d;
  private final int e;
  private final int f;
  private final int g;
  private final int h;

  public VastVideoCloseButtonWidget(Context paramContext)
  {
    super(paramContext);
    setId((int)Utils.generateUniqueId());
    this.e = Dips.dipsToIntPixels(6.0F, paramContext);
    this.g = Dips.dipsToIntPixels(15.0F, paramContext);
    this.h = Dips.dipsToIntPixels(56.0F, paramContext);
    this.f = Dips.dipsToIntPixels(0.0F, paramContext);
    this.d = new CloseButtonDrawable();
    this.c = Networking.getImageLoader(paramContext);
    a();
    b();
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, this.h);
    localLayoutParams.addRule(11);
    setLayoutParams(localLayoutParams);
  }

  private void a()
  {
    this.b = new ImageView(getContext());
    this.b.setId((int)Utils.generateUniqueId());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.h, this.h);
    localLayoutParams.addRule(11);
    this.b.setImageDrawable(this.d);
    this.b.setPadding(this.g, this.g + this.e, this.g + this.e, this.g);
    addView(this.b, localLayoutParams);
  }

  private void b()
  {
    this.a = new TextView(getContext());
    this.a.setSingleLine();
    this.a.setEllipsize(TextUtils.TruncateAt.END);
    this.a.setTextColor(-1);
    this.a.setTextSize(20.0F);
    this.a.setTypeface(DrawableConstants.CloseButton.TEXT_TYPEFACE);
    this.a.setText("");
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(15);
    localLayoutParams.addRule(0, this.b.getId());
    this.a.setPadding(0, this.e, 0, 0);
    localLayoutParams.setMargins(0, 0, this.f, 0);
    addView(this.a, localLayoutParams);
  }

  void a(String paramString)
  {
    if (this.a != null)
      this.a.setText(paramString);
  }

  void b(final String paramString)
  {
    this.c.get(paramString, new ImageLoader.ImageListener()
    {
      public void onErrorResponse(VolleyError paramAnonymousVolleyError)
      {
        MoPubLog.log(MoPubLog.SdkLogEvent.ERROR, new Object[] { "Failed to load image.", paramAnonymousVolleyError });
      }

      public void onResponse(ImageLoader.ImageContainer paramAnonymousImageContainer, boolean paramAnonymousBoolean)
      {
        Bitmap localBitmap = paramAnonymousImageContainer.getBitmap();
        if (localBitmap != null)
        {
          VastVideoCloseButtonWidget.a(VastVideoCloseButtonWidget.this).setImageBitmap(localBitmap);
          return;
        }
        MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
        Object[] arrayOfObject1 = new Object[1];
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = paramString;
        arrayOfObject1[0] = String.format("%s returned null bitmap", arrayOfObject2);
        MoPubLog.log(localSdkLogEvent, arrayOfObject1);
      }
    });
  }

  @Deprecated
  @VisibleForTesting
  ImageView getImageView()
  {
    return this.b;
  }

  @Deprecated
  @VisibleForTesting
  TextView getTextView()
  {
    return this.a;
  }

  @Deprecated
  @VisibleForTesting
  void setImageView(ImageView paramImageView)
  {
    this.b = paramImageView;
  }

  void setOnTouchListenerToContent(View.OnTouchListener paramOnTouchListener)
  {
    this.b.setOnTouchListener(paramOnTouchListener);
    this.a.setOnTouchListener(paramOnTouchListener);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.VastVideoCloseButtonWidget
 * JD-Core Version:    0.6.2
 */