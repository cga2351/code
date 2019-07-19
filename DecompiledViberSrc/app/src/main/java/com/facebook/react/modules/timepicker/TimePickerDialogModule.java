package com.facebook.react.modules.timepicker;

import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.TimePicker;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.module.annotations.ReactModule;
import javax.annotation.Nullable;

@ReactModule(name="TimePickerAndroid")
public class TimePickerDialogModule extends ReactContextBaseJavaModule
{
  static final String ACTION_DISMISSED = "dismissedAction";
  static final String ACTION_TIME_SET = "timeSetAction";
  static final String ARG_HOUR = "hour";
  static final String ARG_IS24HOUR = "is24Hour";
  static final String ARG_MINUTE = "minute";
  static final String ARG_MODE = "mode";
  private static final String ERROR_NO_ACTIVITY = "E_NO_ACTIVITY";

  @VisibleForTesting
  public static final String FRAGMENT_TAG = "TimePickerAndroid";

  public TimePickerDialogModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  private Bundle createFragmentArguments(ReadableMap paramReadableMap)
  {
    Bundle localBundle = new Bundle();
    if ((paramReadableMap.hasKey("hour")) && (!paramReadableMap.isNull("hour")))
      localBundle.putInt("hour", paramReadableMap.getInt("hour"));
    if ((paramReadableMap.hasKey("minute")) && (!paramReadableMap.isNull("minute")))
      localBundle.putInt("minute", paramReadableMap.getInt("minute"));
    if ((paramReadableMap.hasKey("is24Hour")) && (!paramReadableMap.isNull("is24Hour")))
      localBundle.putBoolean("is24Hour", paramReadableMap.getBoolean("is24Hour"));
    if ((paramReadableMap.hasKey("mode")) && (!paramReadableMap.isNull("mode")))
      localBundle.putString("mode", paramReadableMap.getString("mode"));
    return localBundle;
  }

  public String getName()
  {
    return "TimePickerAndroid";
  }

  @ReactMethod
  public void open(@Nullable ReadableMap paramReadableMap, Promise paramPromise)
  {
    FragmentActivity localFragmentActivity = (FragmentActivity)getCurrentActivity();
    if (localFragmentActivity == null)
    {
      paramPromise.reject("E_NO_ACTIVITY", "Tried to open a TimePicker dialog while not attached to an Activity");
      return;
    }
    FragmentManager localFragmentManager = localFragmentActivity.getSupportFragmentManager();
    DialogFragment localDialogFragment = (DialogFragment)localFragmentManager.findFragmentByTag("TimePickerAndroid");
    if (localDialogFragment != null)
      localDialogFragment.dismiss();
    TimePickerDialogFragment localTimePickerDialogFragment = new TimePickerDialogFragment();
    if (paramReadableMap != null)
      localTimePickerDialogFragment.setArguments(createFragmentArguments(paramReadableMap));
    TimePickerDialogListener localTimePickerDialogListener = new TimePickerDialogListener(paramPromise);
    localTimePickerDialogFragment.setOnDismissListener(localTimePickerDialogListener);
    localTimePickerDialogFragment.setOnTimeSetListener(localTimePickerDialogListener);
    localTimePickerDialogFragment.show(localFragmentManager, "TimePickerAndroid");
  }

  private class TimePickerDialogListener
    implements TimePickerDialog.OnTimeSetListener, DialogInterface.OnDismissListener
  {
    private final Promise mPromise;
    private boolean mPromiseResolved = false;

    public TimePickerDialogListener(Promise arg2)
    {
      Object localObject;
      this.mPromise = localObject;
    }

    public void onDismiss(DialogInterface paramDialogInterface)
    {
      if ((!this.mPromiseResolved) && (TimePickerDialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()))
      {
        WritableNativeMap localWritableNativeMap = new WritableNativeMap();
        localWritableNativeMap.putString("action", "dismissedAction");
        this.mPromise.resolve(localWritableNativeMap);
        this.mPromiseResolved = true;
      }
    }

    public void onTimeSet(TimePicker paramTimePicker, int paramInt1, int paramInt2)
    {
      if ((!this.mPromiseResolved) && (TimePickerDialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()))
      {
        WritableNativeMap localWritableNativeMap = new WritableNativeMap();
        localWritableNativeMap.putString("action", "timeSetAction");
        localWritableNativeMap.putInt("hour", paramInt1);
        localWritableNativeMap.putInt("minute", paramInt2);
        this.mPromise.resolve(localWritableNativeMap);
        this.mPromiseResolved = true;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.timepicker.TimePickerDialogModule
 * JD-Core Version:    0.6.2
 */