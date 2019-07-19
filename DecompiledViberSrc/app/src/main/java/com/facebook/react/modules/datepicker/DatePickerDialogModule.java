package com.facebook.react.modules.datepicker;

import android.app.DatePickerDialog.OnDateSetListener;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.DatePicker;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.module.annotations.ReactModule;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@ReactModule(name="DatePickerAndroid")
public class DatePickerDialogModule extends ReactContextBaseJavaModule
{
  static final String ACTION_DATE_SET = "dateSetAction";
  static final String ACTION_DISMISSED = "dismissedAction";
  static final String ARG_DATE = "date";
  static final String ARG_MAXDATE = "maxDate";
  static final String ARG_MINDATE = "minDate";
  static final String ARG_MODE = "mode";
  private static final String ERROR_NO_ACTIVITY = "E_NO_ACTIVITY";

  @VisibleForTesting
  public static final String FRAGMENT_TAG = "DatePickerAndroid";

  public DatePickerDialogModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  private Bundle createFragmentArguments(ReadableMap paramReadableMap)
  {
    Bundle localBundle = new Bundle();
    if ((paramReadableMap.hasKey("date")) && (!paramReadableMap.isNull("date")))
      localBundle.putLong("date", ()paramReadableMap.getDouble("date"));
    if ((paramReadableMap.hasKey("minDate")) && (!paramReadableMap.isNull("minDate")))
      localBundle.putLong("minDate", ()paramReadableMap.getDouble("minDate"));
    if ((paramReadableMap.hasKey("maxDate")) && (!paramReadableMap.isNull("maxDate")))
      localBundle.putLong("maxDate", ()paramReadableMap.getDouble("maxDate"));
    if ((paramReadableMap.hasKey("mode")) && (!paramReadableMap.isNull("mode")))
      localBundle.putString("mode", paramReadableMap.getString("mode"));
    return localBundle;
  }

  @Nonnull
  public String getName()
  {
    return "DatePickerAndroid";
  }

  @ReactMethod
  public void open(@Nullable ReadableMap paramReadableMap, Promise paramPromise)
  {
    FragmentActivity localFragmentActivity = (FragmentActivity)getCurrentActivity();
    if (localFragmentActivity == null)
    {
      paramPromise.reject("E_NO_ACTIVITY", "Tried to open a DatePicker dialog while not attached to an Activity");
      return;
    }
    FragmentManager localFragmentManager = localFragmentActivity.getSupportFragmentManager();
    DialogFragment localDialogFragment = (DialogFragment)localFragmentManager.findFragmentByTag("DatePickerAndroid");
    if (localDialogFragment != null)
      localDialogFragment.dismiss();
    DatePickerDialogFragment localDatePickerDialogFragment = new DatePickerDialogFragment();
    if (paramReadableMap != null)
      localDatePickerDialogFragment.setArguments(createFragmentArguments(paramReadableMap));
    DatePickerDialogListener localDatePickerDialogListener = new DatePickerDialogListener(paramPromise);
    localDatePickerDialogFragment.setOnDismissListener(localDatePickerDialogListener);
    localDatePickerDialogFragment.setOnDateSetListener(localDatePickerDialogListener);
    localDatePickerDialogFragment.show(localFragmentManager, "DatePickerAndroid");
  }

  private class DatePickerDialogListener
    implements DatePickerDialog.OnDateSetListener, DialogInterface.OnDismissListener
  {
    private final Promise mPromise;
    private boolean mPromiseResolved = false;

    public DatePickerDialogListener(Promise arg2)
    {
      Object localObject;
      this.mPromise = localObject;
    }

    public void onDateSet(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
    {
      if ((!this.mPromiseResolved) && (DatePickerDialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()))
      {
        WritableNativeMap localWritableNativeMap = new WritableNativeMap();
        localWritableNativeMap.putString("action", "dateSetAction");
        localWritableNativeMap.putInt("year", paramInt1);
        localWritableNativeMap.putInt("month", paramInt2);
        localWritableNativeMap.putInt("day", paramInt3);
        this.mPromise.resolve(localWritableNativeMap);
        this.mPromiseResolved = true;
      }
    }

    public void onDismiss(DialogInterface paramDialogInterface)
    {
      if ((!this.mPromiseResolved) && (DatePickerDialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()))
      {
        WritableNativeMap localWritableNativeMap = new WritableNativeMap();
        localWritableNativeMap.putString("action", "dismissedAction");
        this.mPromise.resolve(localWritableNativeMap);
        this.mPromiseResolved = true;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.datepicker.DatePickerDialogModule
 * JD-Core Version:    0.6.2
 */