package com.appnexus.opensdk;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.appnexus.opensdk.utils.Clog;
import java.lang.ref.WeakReference;
import java.util.List;

public class NativeAdSDK
{
  static boolean a(NativeAdResponse paramNativeAdResponse)
  {
    if ((paramNativeAdResponse != null) && (!paramNativeAdResponse.hasExpired()))
      return true;
    Clog.d(Clog.nativeLogTag, "NativeAdResponse is not valid");
    return false;
  }

  public static void registerTracking(final NativeAdResponse paramNativeAdResponse, View paramView, final NativeAdEventListener paramNativeAdEventListener)
  {
    if (a(paramNativeAdResponse))
    {
      if (paramView == null)
        Clog.e(Clog.nativeLogTag, "View is not valid for registering");
    }
    else
      return;
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        if (this.a.getTag(R.string.native_tag) != null)
        {
          Clog.e(Clog.nativeLogTag, "View has already been registered, please unregister before reuse");
          return;
        }
        if (paramNativeAdResponse.registerView(this.a, paramNativeAdEventListener))
        {
          WeakReference localWeakReference = new WeakReference(paramNativeAdResponse);
          this.a.setTag(R.string.native_tag, localWeakReference);
          return;
        }
        Clog.e(Clog.nativeLogTag, "failed at registering the View");
      }
    });
  }

  public static void registerTracking(final NativeAdResponse paramNativeAdResponse, View paramView, final List<View> paramList, final NativeAdEventListener paramNativeAdEventListener)
  {
    if (a(paramNativeAdResponse))
    {
      if ((paramView == null) || (paramList == null) || (paramList.isEmpty()))
        Clog.e(Clog.nativeLogTag, "Views are not valid for registering");
    }
    else
      return;
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        if (this.a.getTag(R.string.native_tag) != null)
        {
          Clog.e(Clog.nativeLogTag, "View has already been registered, please unregister before reuse");
          return;
        }
        if (paramNativeAdResponse.registerViewList(this.a, paramList, paramNativeAdEventListener))
        {
          WeakReference localWeakReference = new WeakReference(paramNativeAdResponse);
          this.a.setTag(R.string.native_tag, localWeakReference);
          Clog.d(Clog.nativeLogTag, "View has been registered.");
          return;
        }
        Clog.e(Clog.nativeLogTag, "failed at registering the View");
      }
    });
  }

  public static void unRegisterTracking(View paramView)
  {
    if (paramView == null)
      return;
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        if (this.a.getTag(R.string.native_tag) != null)
        {
          NativeAdResponse localNativeAdResponse = (NativeAdResponse)((WeakReference)this.a.getTag(R.string.native_tag)).get();
          if (localNativeAdResponse != null)
          {
            Clog.d(Clog.nativeLogTag, "Unregister native ad response, assets will be destroyed.");
            localNativeAdResponse.unregisterViews();
          }
          this.a.setTag(R.string.native_tag, null);
        }
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.NativeAdSDK
 * JD-Core Version:    0.6.2
 */