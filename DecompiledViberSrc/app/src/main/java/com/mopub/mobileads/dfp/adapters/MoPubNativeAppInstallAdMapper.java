package com.mopub.mobileads.dfp.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.UrlHandler.Builder;
import com.mopub.common.util.Drawables;
import com.mopub.nativeads.NativeImageHelper;
import com.mopub.nativeads.StaticNativeAd;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MoPubNativeAppInstallAdMapper extends NativeAppInstallAdMapper
{
  private static final Logger a = ViberEnv.getLogger();
  private StaticNativeAd b;
  private int c;
  private ImageView d;
  private int e;

  public MoPubNativeAppInstallAdMapper(StaticNativeAd paramStaticNativeAd, HashMap<String, Drawable> paramHashMap, int paramInt1, int paramInt2)
  {
    this.b = paramStaticNativeAd;
    setHeadline(this.b.getTitle());
    setBody(this.b.getText());
    setCallToAction(this.b.getCallToAction());
    this.c = paramInt1;
    this.e = paramInt2;
    if (paramHashMap != null)
    {
      setIcon(new MoPubNativeMappedImage((Drawable)paramHashMap.get("icon_key"), this.b.getIconImageUrl(), 1.0D));
      ArrayList localArrayList2 = new ArrayList();
      localArrayList2.add(new MoPubNativeMappedImage((Drawable)paramHashMap.get("image_key"), this.b.getMainImageUrl(), 1.0D));
      setImages(localArrayList2);
    }
    while (true)
    {
      setOverrideClickHandling(true);
      setOverrideImpressionRecording(true);
      return;
      setIcon(new MoPubNativeMappedImage(null, this.b.getIconImageUrl(), 1.0D));
      ArrayList localArrayList1 = new ArrayList();
      localArrayList1.add(new MoPubNativeMappedImage(null, this.b.getMainImageUrl(), 1.0D));
      setImages(localArrayList1);
    }
  }

  public void handleClick(View paramView)
  {
  }

  public void recordImpression()
  {
  }

  public void trackView(View paramView)
  {
    this.b.prepare(paramView);
    if (!(paramView instanceof ViewGroup));
    ViewGroup localViewGroup;
    View localView;
    final Context localContext;
    do
    {
      return;
      localViewGroup = (ViewGroup)paramView;
      localView = localViewGroup.getChildAt(-1 + localViewGroup.getChildCount());
      if (!(localView instanceof FrameLayout))
        break;
      localContext = paramView.getContext();
    }
    while (localContext == null);
    this.d = new ImageView(localContext);
    String str1 = this.b.getPrivacyInformationIconImageUrl();
    final String str2 = this.b.getPrivacyInformationIconClickThroughUrl();
    FrameLayout.LayoutParams localLayoutParams;
    if (str1 == null)
    {
      this.d.setImageDrawable(Drawables.NATIVE_PRIVACY_INFORMATION_ICON.createDrawable(localContext));
      this.d.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          UrlHandler.Builder localBuilder = new UrlHandler.Builder();
          UrlAction localUrlAction = UrlAction.IGNORE_ABOUT_SCHEME;
          UrlAction[] arrayOfUrlAction = new UrlAction[5];
          arrayOfUrlAction[0] = UrlAction.OPEN_NATIVE_BROWSER;
          arrayOfUrlAction[1] = UrlAction.OPEN_IN_APP_BROWSER;
          arrayOfUrlAction[2] = UrlAction.HANDLE_SHARE_TWEET;
          arrayOfUrlAction[3] = UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK;
          arrayOfUrlAction[4] = UrlAction.FOLLOW_DEEP_LINK;
          localBuilder.withSupportedUrlActions(localUrlAction, arrayOfUrlAction).build().handleUrl(localContext, str2);
        }
      });
      this.d.setVisibility(0);
      ((ViewGroup)localView).addView(this.d);
      int i = (int)(0.5D + localContext.getResources().getDisplayMetrics().density * this.e);
      localLayoutParams = new FrameLayout.LayoutParams(i, i);
      switch (this.c)
      {
      default:
        localLayoutParams.gravity = 8388661;
      case 0:
      case 2:
      case 3:
      case 1:
      }
    }
    while (true)
    {
      this.d.setLayoutParams(localLayoutParams);
      localViewGroup.requestLayout();
      return;
      NativeImageHelper.loadImageView(str1, this.d);
      break;
      localLayoutParams.gravity = 8388659;
      continue;
      localLayoutParams.gravity = 8388693;
      continue;
      localLayoutParams.gravity = 8388691;
      continue;
      localLayoutParams.gravity = 8388661;
    }
    a.e("Failed to show AdChoices icon.", new Object[0]);
  }

  public void untrackView(View paramView)
  {
    super.untrackView(paramView);
    this.b.clear(paramView);
    if ((this.d != null) && ((ViewGroup)this.d.getParent() != null))
      ((ViewGroup)this.d.getParent()).removeView(this.d);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.dfp.adapters.MoPubNativeAppInstallAdMapper
 * JD-Core Version:    0.6.2
 */