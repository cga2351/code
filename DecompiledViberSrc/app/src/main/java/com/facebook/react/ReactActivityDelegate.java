package com.facebook.react;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Callback;
import com.facebook.react.devsupport.DoubleTapReloadRecognizer;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.PermissionListener;
import javax.annotation.Nullable;

public class ReactActivityDelegate
{

  @Nullable
  private final Activity mActivity;

  @Nullable
  private DoubleTapReloadRecognizer mDoubleTapReloadRecognizer;

  @Nullable
  private final String mMainComponentName;

  @Nullable
  private PermissionListener mPermissionListener;

  @Nullable
  private Callback mPermissionsCallback;

  @Nullable
  private ReactRootView mReactRootView;

  @Deprecated
  public ReactActivityDelegate(Activity paramActivity, @Nullable String paramString)
  {
    this.mActivity = paramActivity;
    this.mMainComponentName = paramString;
  }

  public ReactActivityDelegate(ReactActivity paramReactActivity, @Nullable String paramString)
  {
    this.mActivity = paramReactActivity;
    this.mMainComponentName = paramString;
  }

  protected ReactRootView createRootView()
  {
    return new ReactRootView(getContext());
  }

  protected Context getContext()
  {
    return (Context)Assertions.assertNotNull(this.mActivity);
  }

  @Nullable
  protected Bundle getLaunchOptions()
  {
    return null;
  }

  protected Activity getPlainActivity()
  {
    return (Activity)getContext();
  }

  public ReactInstanceManager getReactInstanceManager()
  {
    return getReactNativeHost().getReactInstanceManager();
  }

  protected ReactNativeHost getReactNativeHost()
  {
    return ((ReactApplication)getPlainActivity().getApplication()).getReactNativeHost();
  }

  protected void loadApp(String paramString)
  {
    if (this.mReactRootView != null)
      throw new IllegalStateException("Cannot loadApp while app is already running.");
    this.mReactRootView = createRootView();
    this.mReactRootView.startReactApplication(getReactNativeHost().getReactInstanceManager(), paramString, getLaunchOptions());
    getPlainActivity().setContentView(this.mReactRootView);
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (getReactNativeHost().hasInstance())
      getReactNativeHost().getReactInstanceManager().onActivityResult(getPlainActivity(), paramInt1, paramInt2, paramIntent);
  }

  public boolean onBackPressed()
  {
    if (getReactNativeHost().hasInstance())
    {
      getReactNativeHost().getReactInstanceManager().onBackPressed();
      return true;
    }
    return false;
  }

  protected void onCreate(Bundle paramBundle)
  {
    if (this.mMainComponentName != null)
      loadApp(this.mMainComponentName);
    this.mDoubleTapReloadRecognizer = new DoubleTapReloadRecognizer();
  }

  protected void onDestroy()
  {
    if (this.mReactRootView != null)
    {
      this.mReactRootView.unmountReactApplication();
      this.mReactRootView = null;
    }
    if (getReactNativeHost().hasInstance())
      getReactNativeHost().getReactInstanceManager().onHostDestroy(getPlainActivity());
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((getReactNativeHost().hasInstance()) && (getReactNativeHost().getUseDeveloperSupport()) && (paramInt == 90))
    {
      paramKeyEvent.startTracking();
      return true;
    }
    return false;
  }

  public boolean onKeyLongPress(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((getReactNativeHost().hasInstance()) && (getReactNativeHost().getUseDeveloperSupport()) && (paramInt == 90))
    {
      getReactNativeHost().getReactInstanceManager().showDevOptionsDialog();
      return true;
    }
    return false;
  }

  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((getReactNativeHost().hasInstance()) && (getReactNativeHost().getUseDeveloperSupport()))
    {
      if (paramInt == 82)
      {
        getReactNativeHost().getReactInstanceManager().showDevOptionsDialog();
        return true;
      }
      if (((DoubleTapReloadRecognizer)Assertions.assertNotNull(this.mDoubleTapReloadRecognizer)).didDoubleTapR(paramInt, getPlainActivity().getCurrentFocus()))
      {
        getReactNativeHost().getReactInstanceManager().getDevSupportManager().handleReloadJS();
        return true;
      }
    }
    return false;
  }

  public boolean onNewIntent(Intent paramIntent)
  {
    if (getReactNativeHost().hasInstance())
    {
      getReactNativeHost().getReactInstanceManager().onNewIntent(paramIntent);
      return true;
    }
    return false;
  }

  protected void onPause()
  {
    if (getReactNativeHost().hasInstance())
      getReactNativeHost().getReactInstanceManager().onHostPause(getPlainActivity());
  }

  public void onRequestPermissionsResult(final int paramInt, final String[] paramArrayOfString, final int[] paramArrayOfInt)
  {
    this.mPermissionsCallback = new Callback()
    {
      public void invoke(Object[] paramAnonymousArrayOfObject)
      {
        if ((ReactActivityDelegate.this.mPermissionListener != null) && (ReactActivityDelegate.this.mPermissionListener.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt)))
          ReactActivityDelegate.access$002(ReactActivityDelegate.this, null);
      }
    };
  }

  protected void onResume()
  {
    if (getReactNativeHost().hasInstance())
      getReactNativeHost().getReactInstanceManager().onHostResume(getPlainActivity(), (DefaultHardwareBackBtnHandler)getPlainActivity());
    if (this.mPermissionsCallback != null)
    {
      this.mPermissionsCallback.invoke(new Object[0]);
      this.mPermissionsCallback = null;
    }
  }

  @TargetApi(23)
  public void requestPermissions(String[] paramArrayOfString, int paramInt, PermissionListener paramPermissionListener)
  {
    this.mPermissionListener = paramPermissionListener;
    getPlainActivity().requestPermissions(paramArrayOfString, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.ReactActivityDelegate
 * JD-Core Version:    0.6.2
 */