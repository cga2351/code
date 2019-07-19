package com.facebook.react.modules.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import java.util.Map;
import javax.annotation.Nullable;

@ReactModule(name="DialogManagerAndroid")
public class DialogModule extends ReactContextBaseJavaModule
  implements LifecycleEventListener
{
  static final String ACTION_BUTTON_CLICKED = "buttonClicked";
  static final String ACTION_DISMISSED = "dismissed";
  static final Map<String, Object> CONSTANTS = MapBuilder.of("buttonClicked", "buttonClicked", "dismissed", "dismissed", "buttonPositive", Integer.valueOf(-1), "buttonNegative", Integer.valueOf(-2), "buttonNeutral", Integer.valueOf(-3));
  static final String FRAGMENT_TAG = "com.facebook.catalyst.react.dialog.DialogModule";
  static final String KEY_BUTTON_NEGATIVE = "buttonNegative";
  static final String KEY_BUTTON_NEUTRAL = "buttonNeutral";
  static final String KEY_BUTTON_POSITIVE = "buttonPositive";
  static final String KEY_CANCELABLE = "cancelable";
  static final String KEY_ITEMS = "items";
  static final String KEY_MESSAGE = "message";
  static final String KEY_TITLE = "title";
  public static final String NAME = "DialogManagerAndroid";
  private boolean mIsInForeground;

  public DialogModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  @Nullable
  private FragmentManagerHelper getFragmentManagerHelper()
  {
    Activity localActivity = getCurrentActivity();
    if (localActivity == null)
      return null;
    if ((localActivity instanceof FragmentActivity))
      return new FragmentManagerHelper(((FragmentActivity)localActivity).getSupportFragmentManager());
    return new FragmentManagerHelper(localActivity.getFragmentManager());
  }

  public Map<String, Object> getConstants()
  {
    return CONSTANTS;
  }

  public String getName()
  {
    return "DialogManagerAndroid";
  }

  public void initialize()
  {
    getReactApplicationContext().addLifecycleEventListener(this);
  }

  public void onHostDestroy()
  {
  }

  public void onHostPause()
  {
    this.mIsInForeground = false;
  }

  public void onHostResume()
  {
    this.mIsInForeground = true;
    FragmentManagerHelper localFragmentManagerHelper = getFragmentManagerHelper();
    if (localFragmentManagerHelper != null)
    {
      localFragmentManagerHelper.showPendingAlert();
      return;
    }
    FLog.w(DialogModule.class, "onHostResume called but no FragmentManager found");
  }

  @ReactMethod
  public void showAlert(ReadableMap paramReadableMap, Callback paramCallback1, final Callback paramCallback2)
  {
    int i = 0;
    final FragmentManagerHelper localFragmentManagerHelper = getFragmentManagerHelper();
    if (localFragmentManagerHelper == null)
    {
      paramCallback1.invoke(new Object[] { "Tried to show an alert while not attached to an Activity" });
      return;
    }
    final Bundle localBundle = new Bundle();
    if (paramReadableMap.hasKey("title"))
      localBundle.putString("title", paramReadableMap.getString("title"));
    if (paramReadableMap.hasKey("message"))
      localBundle.putString("message", paramReadableMap.getString("message"));
    if (paramReadableMap.hasKey("buttonPositive"))
      localBundle.putString("button_positive", paramReadableMap.getString("buttonPositive"));
    if (paramReadableMap.hasKey("buttonNegative"))
      localBundle.putString("button_negative", paramReadableMap.getString("buttonNegative"));
    if (paramReadableMap.hasKey("buttonNeutral"))
      localBundle.putString("button_neutral", paramReadableMap.getString("buttonNeutral"));
    if (paramReadableMap.hasKey("items"))
    {
      ReadableArray localReadableArray = paramReadableMap.getArray("items");
      CharSequence[] arrayOfCharSequence = new CharSequence[localReadableArray.size()];
      while (i < localReadableArray.size())
      {
        arrayOfCharSequence[i] = localReadableArray.getString(i);
        i++;
      }
      localBundle.putCharSequenceArray("items", arrayOfCharSequence);
    }
    if (paramReadableMap.hasKey("cancelable"))
      localBundle.putBoolean("cancelable", paramReadableMap.getBoolean("cancelable"));
    UiThreadUtil.runOnUiThread(new Runnable()
    {
      public void run()
      {
        localFragmentManagerHelper.showNewAlert(DialogModule.this.mIsInForeground, localBundle, paramCallback2);
      }
    });
  }

  class AlertFragmentListener
    implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener
  {
    private final Callback mCallback;
    private boolean mCallbackConsumed = false;

    public AlertFragmentListener(Callback arg2)
    {
      Object localObject;
      this.mCallback = localObject;
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      if ((!this.mCallbackConsumed) && (DialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()))
      {
        Callback localCallback = this.mCallback;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = "buttonClicked";
        arrayOfObject[1] = Integer.valueOf(paramInt);
        localCallback.invoke(arrayOfObject);
        this.mCallbackConsumed = true;
      }
    }

    public void onDismiss(DialogInterface paramDialogInterface)
    {
      if ((!this.mCallbackConsumed) && (DialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()))
      {
        this.mCallback.invoke(new Object[] { "dismissed" });
        this.mCallbackConsumed = true;
      }
    }
  }

  private class FragmentManagerHelper
  {

    @Nullable
    private final android.app.FragmentManager mFragmentManager;

    @Nullable
    private Object mFragmentToShow;

    @Nullable
    private final android.support.v4.app.FragmentManager mSupportFragmentManager;

    public FragmentManagerHelper(android.app.FragmentManager arg2)
    {
      Object localObject;
      this.mFragmentManager = localObject;
      this.mSupportFragmentManager = null;
    }

    public FragmentManagerHelper(android.support.v4.app.FragmentManager arg2)
    {
      this.mFragmentManager = null;
      Object localObject;
      this.mSupportFragmentManager = localObject;
    }

    private void dismissExisting()
    {
      if (isUsingSupportLibrary())
      {
        SupportAlertFragment localSupportAlertFragment = (SupportAlertFragment)this.mSupportFragmentManager.findFragmentByTag("com.facebook.catalyst.react.dialog.DialogModule");
        if ((localSupportAlertFragment != null) && (localSupportAlertFragment.isResumed()))
          localSupportAlertFragment.dismiss();
      }
      AlertFragment localAlertFragment;
      do
      {
        return;
        localAlertFragment = (AlertFragment)this.mFragmentManager.findFragmentByTag("com.facebook.catalyst.react.dialog.DialogModule");
      }
      while ((localAlertFragment == null) || (!localAlertFragment.isResumed()));
      localAlertFragment.dismiss();
    }

    private boolean isUsingSupportLibrary()
    {
      return this.mSupportFragmentManager != null;
    }

    public void showNewAlert(boolean paramBoolean, Bundle paramBundle, Callback paramCallback)
    {
      UiThreadUtil.assertOnUiThread();
      dismissExisting();
      DialogModule.AlertFragmentListener localAlertFragmentListener;
      if (paramCallback != null)
        localAlertFragmentListener = new DialogModule.AlertFragmentListener(DialogModule.this, paramCallback);
      while (isUsingSupportLibrary())
      {
        SupportAlertFragment localSupportAlertFragment = new SupportAlertFragment(localAlertFragmentListener, paramBundle);
        if ((paramBoolean) && (!this.mSupportFragmentManager.isStateSaved()))
        {
          if (paramBundle.containsKey("cancelable"))
            localSupportAlertFragment.setCancelable(paramBundle.getBoolean("cancelable"));
          localSupportAlertFragment.show(this.mSupportFragmentManager, "com.facebook.catalyst.react.dialog.DialogModule");
          return;
          localAlertFragmentListener = null;
        }
        else
        {
          this.mFragmentToShow = localSupportAlertFragment;
          return;
        }
      }
      AlertFragment localAlertFragment = new AlertFragment(localAlertFragmentListener, paramBundle);
      if (paramBoolean)
      {
        if (paramBundle.containsKey("cancelable"))
          localAlertFragment.setCancelable(paramBundle.getBoolean("cancelable"));
        localAlertFragment.show(this.mFragmentManager, "com.facebook.catalyst.react.dialog.DialogModule");
        return;
      }
      this.mFragmentToShow = localAlertFragment;
    }

    public void showPendingAlert()
    {
      UiThreadUtil.assertOnUiThread();
      if (this.mFragmentToShow == null)
        return;
      if (isUsingSupportLibrary())
        ((SupportAlertFragment)this.mFragmentToShow).show(this.mSupportFragmentManager, "com.facebook.catalyst.react.dialog.DialogModule");
      while (true)
      {
        this.mFragmentToShow = null;
        return;
        ((AlertFragment)this.mFragmentToShow).show(this.mFragmentManager, "com.facebook.catalyst.react.dialog.DialogModule");
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.dialog.DialogModule
 * JD-Core Version:    0.6.2
 */