package com.mopub.nativeads;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.mopub.common.Preconditions;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.UrlHandler.Builder;
import com.mopub.common.UrlHandler.ResultActions;
import com.mopub.common.VisibleForTesting;

public class NativeClickHandler
{
  private final Context a;
  private final String b;
  private boolean c;

  public NativeClickHandler(Context paramContext)
  {
    this(paramContext, null);
  }

  public NativeClickHandler(Context paramContext, String paramString)
  {
    Preconditions.checkNotNull(paramContext);
    this.a = paramContext.getApplicationContext();
    this.b = paramString;
  }

  private void a(View paramView, View.OnClickListener paramOnClickListener)
  {
    paramView.setOnClickListener(paramOnClickListener);
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      for (int i = 0; i < localViewGroup.getChildCount(); i++)
        a(localViewGroup.getChildAt(i), paramOnClickListener);
    }
  }

  @VisibleForTesting
  void a(String paramString, final View paramView, final i parami)
  {
    if (!Preconditions.NoThrow.checkNotNull(paramString, "Cannot open a null click destination url"));
    do
    {
      return;
      Preconditions.checkNotNull(parami);
    }
    while (this.c);
    this.c = true;
    if (paramView != null)
      parami.a(paramView);
    UrlHandler.Builder localBuilder = new UrlHandler.Builder();
    if (!TextUtils.isEmpty(this.b))
      localBuilder.withDspCreativeId(this.b);
    UrlAction localUrlAction = UrlAction.IGNORE_ABOUT_SCHEME;
    UrlAction[] arrayOfUrlAction = new UrlAction[6];
    arrayOfUrlAction[0] = UrlAction.OPEN_NATIVE_BROWSER;
    arrayOfUrlAction[1] = UrlAction.OPEN_APP_MARKET;
    arrayOfUrlAction[2] = UrlAction.OPEN_IN_APP_BROWSER;
    arrayOfUrlAction[3] = UrlAction.HANDLE_SHARE_TWEET;
    arrayOfUrlAction[4] = UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK;
    arrayOfUrlAction[5] = UrlAction.FOLLOW_DEEP_LINK;
    localBuilder.withSupportedUrlActions(localUrlAction, arrayOfUrlAction).withResultActions(new UrlHandler.ResultActions()
    {
      private void a()
      {
        if (paramView != null)
          parami.a();
      }

      public void urlHandlingFailed(String paramAnonymousString, UrlAction paramAnonymousUrlAction)
      {
        a();
        NativeClickHandler.a(NativeClickHandler.this, false);
      }

      public void urlHandlingSucceeded(String paramAnonymousString, UrlAction paramAnonymousUrlAction)
      {
        a();
        NativeClickHandler.a(NativeClickHandler.this, false);
      }
    }).build().handleUrl(this.a, paramString);
  }

  public void clearOnClickListener(View paramView)
  {
    if (!Preconditions.NoThrow.checkNotNull(paramView, "Cannot clear click listener from a null view"))
      return;
    a(paramView, (View.OnClickListener)null);
  }

  public void openClickDestinationUrl(String paramString, View paramView)
  {
    a(paramString, paramView, new i(this.a));
  }

  public void setOnClickListener(View paramView, final ClickInterface paramClickInterface)
  {
    if (!Preconditions.NoThrow.checkNotNull(paramView, "Cannot set click listener on a null view"));
    while (!Preconditions.NoThrow.checkNotNull(paramClickInterface, "Cannot set click listener with a null ClickInterface"))
      return;
    a(paramView, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramClickInterface.handleClick(paramAnonymousView);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.NativeClickHandler
 * JD-Core Version:    0.6.2
 */