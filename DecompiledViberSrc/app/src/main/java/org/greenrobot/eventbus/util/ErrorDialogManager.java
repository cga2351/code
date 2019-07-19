package org.greenrobot.eventbus.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import org.greenrobot.eventbus.EventBus;

public class ErrorDialogManager
{
  public static final String KEY_EVENT_TYPE_ON_CLOSE = "de.greenrobot.eventbus.errordialog.event_type_on_close";
  public static final String KEY_FINISH_AFTER_DIALOG = "de.greenrobot.eventbus.errordialog.finish_after_dialog";
  public static final String KEY_ICON_ID = "de.greenrobot.eventbus.errordialog.icon_id";
  public static final String KEY_MESSAGE = "de.greenrobot.eventbus.errordialog.message";
  public static final String KEY_TITLE = "de.greenrobot.eventbus.errordialog.title";
  protected static final String TAG_ERROR_DIALOG = "de.greenrobot.eventbus.error_dialog";
  protected static final String TAG_ERROR_DIALOG_MANAGER = "de.greenrobot.eventbus.error_dialog_manager";
  public static ErrorDialogFragmentFactory<?> factory;

  public static void attachTo(Activity paramActivity)
  {
    attachTo(paramActivity, false, null);
  }

  public static void attachTo(Activity paramActivity, Object paramObject, boolean paramBoolean, Bundle paramBundle)
  {
    if (factory == null)
      throw new RuntimeException("You must set the static factory field to configure error dialogs for your app.");
    if (isSupportActivity(paramActivity))
    {
      SupportManagerFragment.attachTo(paramActivity, paramObject, paramBoolean, paramBundle);
      return;
    }
    HoneycombManagerFragment.attachTo(paramActivity, paramObject, paramBoolean, paramBundle);
  }

  public static void attachTo(Activity paramActivity, boolean paramBoolean)
  {
    attachTo(paramActivity, paramBoolean, null);
  }

  public static void attachTo(Activity paramActivity, boolean paramBoolean, Bundle paramBundle)
  {
    attachTo(paramActivity, paramActivity.getClass(), paramBoolean, paramBundle);
  }

  protected static void checkLogException(ThrowableFailureEvent paramThrowableFailureEvent)
  {
    if (factory.config.logExceptions)
    {
      String str = factory.config.tagForLoggingExceptions;
      if (str == null)
        str = EventBus.TAG;
      Log.i(str, "Error dialog manager received exception", paramThrowableFailureEvent.throwable);
    }
  }

  private static boolean isInExecutionScope(Object paramObject, ThrowableFailureEvent paramThrowableFailureEvent)
  {
    if (paramThrowableFailureEvent != null)
    {
      Object localObject = paramThrowableFailureEvent.getExecutionScope();
      if ((localObject != null) && (!localObject.equals(paramObject)))
        return false;
    }
    return true;
  }

  private static boolean isSupportActivity(Activity paramActivity)
  {
    for (Class localClass = paramActivity.getClass().getSuperclass(); ; localClass = localClass.getSuperclass())
    {
      if (localClass == null)
        throw new RuntimeException("Illegal activity type: " + paramActivity.getClass());
      String str = localClass.getName();
      boolean bool;
      if (str.equals("android.support.v4.app.FragmentActivity"))
        bool = true;
      int i;
      do
      {
        return bool;
        if ((str.startsWith("com.actionbarsherlock.app")) && ((str.endsWith(".SherlockActivity")) || (str.endsWith(".SherlockListActivity")) || (str.endsWith(".SherlockPreferenceActivity"))))
          throw new RuntimeException("Please use SherlockFragmentActivity. Illegal activity: " + str);
        if (!str.equals("android.app.Activity"))
          break;
        i = Build.VERSION.SDK_INT;
        bool = false;
      }
      while (i >= 11);
      throw new RuntimeException("Illegal activity without fragment support. Either use Android 3.0+ or android.support.v4.app.FragmentActivity.");
    }
  }

  @TargetApi(11)
  public static class HoneycombManagerFragment extends android.app.Fragment
  {
    protected Bundle argumentsForErrorDialog;
    private EventBus eventBus;
    private Object executionScope;
    protected boolean finishAfterDialog;

    public static void attachTo(Activity paramActivity, Object paramObject, boolean paramBoolean, Bundle paramBundle)
    {
      android.app.FragmentManager localFragmentManager = paramActivity.getFragmentManager();
      HoneycombManagerFragment localHoneycombManagerFragment = (HoneycombManagerFragment)localFragmentManager.findFragmentByTag("de.greenrobot.eventbus.error_dialog_manager");
      if (localHoneycombManagerFragment == null)
      {
        localHoneycombManagerFragment = new HoneycombManagerFragment();
        localFragmentManager.beginTransaction().add(localHoneycombManagerFragment, "de.greenrobot.eventbus.error_dialog_manager").commit();
        localFragmentManager.executePendingTransactions();
      }
      localHoneycombManagerFragment.finishAfterDialog = paramBoolean;
      localHoneycombManagerFragment.argumentsForErrorDialog = paramBundle;
      localHoneycombManagerFragment.executionScope = paramObject;
    }

    public void onEventMainThread(ThrowableFailureEvent paramThrowableFailureEvent)
    {
      if (!ErrorDialogManager.isInExecutionScope(this.executionScope, paramThrowableFailureEvent));
      android.app.FragmentManager localFragmentManager;
      android.app.DialogFragment localDialogFragment2;
      do
      {
        return;
        ErrorDialogManager.checkLogException(paramThrowableFailureEvent);
        localFragmentManager = getFragmentManager();
        localFragmentManager.executePendingTransactions();
        android.app.DialogFragment localDialogFragment1 = (android.app.DialogFragment)localFragmentManager.findFragmentByTag("de.greenrobot.eventbus.error_dialog");
        if (localDialogFragment1 != null)
          localDialogFragment1.dismiss();
        localDialogFragment2 = (android.app.DialogFragment)ErrorDialogManager.factory.prepareErrorFragment(paramThrowableFailureEvent, this.finishAfterDialog, this.argumentsForErrorDialog);
      }
      while (localDialogFragment2 == null);
      localDialogFragment2.show(localFragmentManager, "de.greenrobot.eventbus.error_dialog");
    }

    public void onPause()
    {
      this.eventBus.unregister(this);
      super.onPause();
    }

    public void onResume()
    {
      super.onResume();
      this.eventBus = ErrorDialogManager.factory.config.getEventBus();
      this.eventBus.register(this);
    }
  }

  public static class SupportManagerFragment extends android.support.v4.app.Fragment
  {
    protected Bundle argumentsForErrorDialog;
    private EventBus eventBus;
    private Object executionScope;
    protected boolean finishAfterDialog;
    private boolean skipRegisterOnNextResume;

    public static void attachTo(Activity paramActivity, Object paramObject, boolean paramBoolean, Bundle paramBundle)
    {
      android.support.v4.app.FragmentManager localFragmentManager = ((FragmentActivity)paramActivity).getSupportFragmentManager();
      SupportManagerFragment localSupportManagerFragment = (SupportManagerFragment)localFragmentManager.findFragmentByTag("de.greenrobot.eventbus.error_dialog_manager");
      if (localSupportManagerFragment == null)
      {
        localSupportManagerFragment = new SupportManagerFragment();
        localFragmentManager.beginTransaction().add(localSupportManagerFragment, "de.greenrobot.eventbus.error_dialog_manager").commit();
        localFragmentManager.executePendingTransactions();
      }
      localSupportManagerFragment.finishAfterDialog = paramBoolean;
      localSupportManagerFragment.argumentsForErrorDialog = paramBundle;
      localSupportManagerFragment.executionScope = paramObject;
    }

    public void onCreate(Bundle paramBundle)
    {
      super.onCreate(paramBundle);
      this.eventBus = ErrorDialogManager.factory.config.getEventBus();
      this.eventBus.register(this);
      this.skipRegisterOnNextResume = true;
    }

    public void onEventMainThread(ThrowableFailureEvent paramThrowableFailureEvent)
    {
      if (!ErrorDialogManager.isInExecutionScope(this.executionScope, paramThrowableFailureEvent));
      android.support.v4.app.FragmentManager localFragmentManager;
      android.support.v4.app.DialogFragment localDialogFragment2;
      do
      {
        return;
        ErrorDialogManager.checkLogException(paramThrowableFailureEvent);
        localFragmentManager = getFragmentManager();
        localFragmentManager.executePendingTransactions();
        android.support.v4.app.DialogFragment localDialogFragment1 = (android.support.v4.app.DialogFragment)localFragmentManager.findFragmentByTag("de.greenrobot.eventbus.error_dialog");
        if (localDialogFragment1 != null)
          localDialogFragment1.dismiss();
        localDialogFragment2 = (android.support.v4.app.DialogFragment)ErrorDialogManager.factory.prepareErrorFragment(paramThrowableFailureEvent, this.finishAfterDialog, this.argumentsForErrorDialog);
      }
      while (localDialogFragment2 == null);
      localDialogFragment2.show(localFragmentManager, "de.greenrobot.eventbus.error_dialog");
    }

    public void onPause()
    {
      this.eventBus.unregister(this);
      super.onPause();
    }

    public void onResume()
    {
      super.onResume();
      if (this.skipRegisterOnNextResume)
      {
        this.skipRegisterOnNextResume = false;
        return;
      }
      this.eventBus = ErrorDialogManager.factory.config.getEventBus();
      this.eventBus.register(this);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.greenrobot.eventbus.util.ErrorDialogManager
 * JD-Core Version:    0.6.2
 */