package com.facebook.react.modules.vibration;

import android.annotation.SuppressLint;
import android.os.Vibrator;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name="Vibration")
@SuppressLint({"MissingPermission"})
public class VibrationModule extends ReactContextBaseJavaModule
{
  public static final String NAME = "Vibration";

  public VibrationModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  @ReactMethod
  public void cancel()
  {
    Vibrator localVibrator = (Vibrator)getReactApplicationContext().getSystemService("vibrator");
    if (localVibrator != null)
      localVibrator.cancel();
  }

  public String getName()
  {
    return "Vibration";
  }

  @ReactMethod
  public void vibrate(int paramInt)
  {
    Vibrator localVibrator = (Vibrator)getReactApplicationContext().getSystemService("vibrator");
    if (localVibrator != null)
      localVibrator.vibrate(paramInt);
  }

  @ReactMethod
  public void vibrateByPattern(ReadableArray paramReadableArray, int paramInt)
  {
    long[] arrayOfLong = new long[paramReadableArray.size()];
    for (int i = 0; i < paramReadableArray.size(); i++)
      arrayOfLong[i] = paramReadableArray.getInt(i);
    Vibrator localVibrator = (Vibrator)getReactApplicationContext().getSystemService("vibrator");
    if (localVibrator != null)
      localVibrator.vibrate(arrayOfLong, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.vibration.VibrationModule
 * JD-Core Version:    0.6.2
 */