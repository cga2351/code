package com.mopub.common;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.network.TrackingRequest;
import java.util.EnumSet;
import java.util.Iterator;

public class UrlHandler
{
  private static final ResultActions a = new ResultActions()
  {
    public void urlHandlingFailed(String paramAnonymousString, UrlAction paramAnonymousUrlAction)
    {
    }

    public void urlHandlingSucceeded(String paramAnonymousString, UrlAction paramAnonymousUrlAction)
    {
    }
  };
  private static final MoPubSchemeListener b = new MoPubSchemeListener()
  {
    public void onClose()
    {
    }

    public void onCrash()
    {
    }

    public void onFailLoad()
    {
    }

    public void onFinishLoad()
    {
    }
  };
  private EnumSet<UrlAction> c;
  private ResultActions d;
  private MoPubSchemeListener e;
  private String f;
  private boolean g;
  private boolean h;
  private boolean i;

  private UrlHandler(EnumSet<UrlAction> paramEnumSet, ResultActions paramResultActions, MoPubSchemeListener paramMoPubSchemeListener, boolean paramBoolean, String paramString)
  {
    this.c = EnumSet.copyOf(paramEnumSet);
    this.d = paramResultActions;
    this.e = paramMoPubSchemeListener;
    this.g = paramBoolean;
    this.f = paramString;
    this.h = false;
    this.i = false;
  }

  private void a(String paramString1, UrlAction paramUrlAction, String paramString2, Throwable paramThrowable)
  {
    Preconditions.checkNotNull(paramString2);
    if (paramUrlAction == null)
      paramUrlAction = UrlAction.NOOP;
    MoPubLog.log(MoPubLog.SdkLogEvent.ERROR, new Object[] { paramString2, paramThrowable });
    this.d.urlHandlingFailed(paramString1, paramUrlAction);
  }

  MoPubSchemeListener a()
  {
    return this.e;
  }

  boolean b()
  {
    return this.g;
  }

  public boolean handleResolvedUrl(Context paramContext, String paramString, boolean paramBoolean, Iterable<String> paramIterable)
  {
    if (TextUtils.isEmpty(paramString))
    {
      a(paramString, null, "Attempted to handle empty url.", null);
      return false;
    }
    UrlAction localUrlAction = UrlAction.NOOP;
    Uri localUri = Uri.parse(paramString);
    Iterator localIterator = this.c.iterator();
    Object localObject1 = localUrlAction;
    Object localObject2;
    if (localIterator.hasNext())
    {
      localObject2 = (UrlAction)localIterator.next();
      if (!((UrlAction)localObject2).shouldTryHandlingUrl(localUri))
        break label224;
      try
      {
        ((UrlAction)localObject2).handleUrl(this, paramContext, localUri, paramBoolean, this.f);
        if ((!this.h) && (!this.i) && (!UrlAction.IGNORE_ABOUT_SCHEME.equals(localObject2)) && (!UrlAction.HANDLE_MOPUB_SCHEME.equals(localObject2)))
        {
          TrackingRequest.makeTrackingHttpRequest(paramIterable, paramContext);
          this.d.urlHandlingSucceeded(localUri.toString(), (UrlAction)localObject2);
          this.h = true;
        }
        return true;
      }
      catch (IntentNotResolvableException localIntentNotResolvableException)
      {
        MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.ERROR;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = localIntentNotResolvableException.getMessage();
        arrayOfObject[1] = localIntentNotResolvableException;
        MoPubLog.log(localSdkLogEvent, arrayOfObject);
      }
    }
    while (true)
    {
      localObject1 = localObject2;
      break;
      a(paramString, (UrlAction)localObject1, "Link ignored. Unable to handle url: " + paramString, null);
      return false;
      label224: localObject2 = localObject1;
    }
  }

  public void handleUrl(Context paramContext, String paramString)
  {
    Preconditions.checkNotNull(paramContext);
    handleUrl(paramContext, paramString, true);
  }

  public void handleUrl(Context paramContext, String paramString, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramContext);
    handleUrl(paramContext, paramString, paramBoolean, null);
  }

  public void handleUrl(final Context paramContext, final String paramString, final boolean paramBoolean, final Iterable<String> paramIterable)
  {
    Preconditions.checkNotNull(paramContext);
    if (TextUtils.isEmpty(paramString))
    {
      a(paramString, null, "Attempted to handle empty url.", null);
      return;
    }
    UrlResolutionTask.getResolvedUrl(paramString, new UrlResolutionTask.a()
    {
      public void onFailure(String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        UrlHandler.a(UrlHandler.this, false);
        UrlHandler.a(UrlHandler.this, paramString, null, paramAnonymousString, paramAnonymousThrowable);
      }

      public void onSuccess(String paramAnonymousString)
      {
        UrlHandler.a(UrlHandler.this, false);
        UrlHandler.this.handleResolvedUrl(paramContext, paramAnonymousString, paramBoolean, paramIterable);
      }
    });
    this.i = true;
  }

  public static class Builder
  {
    private EnumSet<UrlAction> a = EnumSet.of(UrlAction.NOOP);
    private UrlHandler.ResultActions b = UrlHandler.c();
    private UrlHandler.MoPubSchemeListener c = UrlHandler.d();
    private boolean d = false;
    private String e;

    public UrlHandler build()
    {
      return new UrlHandler(this.a, this.b, this.c, this.d, this.e, null);
    }

    public Builder withDspCreativeId(String paramString)
    {
      this.e = paramString;
      return this;
    }

    public Builder withMoPubSchemeListener(UrlHandler.MoPubSchemeListener paramMoPubSchemeListener)
    {
      this.c = paramMoPubSchemeListener;
      return this;
    }

    public Builder withResultActions(UrlHandler.ResultActions paramResultActions)
    {
      this.b = paramResultActions;
      return this;
    }

    public Builder withSupportedUrlActions(UrlAction paramUrlAction, UrlAction[] paramArrayOfUrlAction)
    {
      this.a = EnumSet.of(paramUrlAction, paramArrayOfUrlAction);
      return this;
    }

    public Builder withSupportedUrlActions(EnumSet<UrlAction> paramEnumSet)
    {
      this.a = EnumSet.copyOf(paramEnumSet);
      return this;
    }

    public Builder withoutMoPubBrowser()
    {
      this.d = true;
      return this;
    }
  }

  public static abstract interface MoPubSchemeListener
  {
    public abstract void onClose();

    public abstract void onCrash();

    public abstract void onFailLoad();

    public abstract void onFinishLoad();
  }

  public static abstract interface ResultActions
  {
    public abstract void urlHandlingFailed(String paramString, UrlAction paramUrlAction);

    public abstract void urlHandlingSucceeded(String paramString, UrlAction paramUrlAction);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.UrlHandler
 * JD-Core Version:    0.6.2
 */