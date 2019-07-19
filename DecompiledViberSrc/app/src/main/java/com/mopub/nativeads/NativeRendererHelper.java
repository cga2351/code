package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.UrlHandler.Builder;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Drawables;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class NativeRendererHelper
{
  public static void addCtaButton(TextView paramTextView, View paramView, String paramString)
  {
    addTextView(paramTextView, paramString);
    if ((paramTextView == null) || (paramView == null))
      return;
    paramTextView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.a.performClick();
      }
    });
  }

  public static void addPrivacyInformationIcon(ImageView paramImageView, String paramString1, final String paramString2)
  {
    if (paramImageView == null);
    Context localContext;
    do
    {
      return;
      if (paramString2 == null)
      {
        paramImageView.setImageDrawable(null);
        paramImageView.setOnClickListener(null);
        paramImageView.setVisibility(4);
        return;
      }
      localContext = paramImageView.getContext();
    }
    while (localContext == null);
    if (paramString1 == null)
      paramImageView.setImageDrawable(Drawables.NATIVE_PRIVACY_INFORMATION_ICON.createDrawable(localContext));
    while (true)
    {
      paramImageView.setOnClickListener(new View.OnClickListener()
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
          localBuilder.withSupportedUrlActions(localUrlAction, arrayOfUrlAction).build().handleUrl(this.a, paramString2);
        }
      });
      paramImageView.setVisibility(0);
      return;
      NativeImageHelper.loadImageView(paramString1, paramImageView);
    }
  }

  public static void addTextView(TextView paramTextView, String paramString)
  {
    if (paramTextView == null)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = ("Attempted to add text (" + paramString + ") to null TextView.");
      MoPubLog.log(localSdkLogEvent, arrayOfObject);
      return;
    }
    paramTextView.setText(null);
    if (paramString == null)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Attempted to set TextView contents to null." });
      return;
    }
    paramTextView.setText(paramString);
  }

  public static void updateExtras(View paramView, Map<String, Integer> paramMap, Map<String, Object> paramMap1)
  {
    if (paramView == null)
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Attempted to bind extras on a null main view." });
    while (true)
    {
      return;
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        View localView = paramView.findViewById(((Integer)paramMap.get(str)).intValue());
        Object localObject1 = paramMap1.get(str);
        if ((localView instanceof ImageView))
        {
          ((ImageView)localView).setImageDrawable(null);
          Object localObject2 = paramMap1.get(str);
          if ((localObject2 != null) && ((localObject2 instanceof String)))
            NativeImageHelper.loadImageView((String)localObject2, (ImageView)localView);
        }
        else if ((localView instanceof TextView))
        {
          ((TextView)localView).setText(null);
          if ((localObject1 instanceof String))
            addTextView((TextView)localView, (String)localObject1);
        }
        else
        {
          MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = ("View bound to " + str + " should be an instance of TextView or ImageView.");
          MoPubLog.log(localSdkLogEvent, arrayOfObject);
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.NativeRendererHelper
 * JD-Core Version:    0.6.2
 */