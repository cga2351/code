package com.facebook.react.modules.debug;

import android.widget.Toast;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import java.util.Locale;
import javax.annotation.Nullable;

@ReactModule(name="AnimationsDebugModule")
public class AnimationsDebugModule extends ReactContextBaseJavaModule
{
  protected static final String NAME = "AnimationsDebugModule";

  @Nullable
  private final DeveloperSettings mCatalystSettings;

  @Nullable
  private FpsDebugFrameCallback mFrameCallback;

  public AnimationsDebugModule(ReactApplicationContext paramReactApplicationContext, DeveloperSettings paramDeveloperSettings)
  {
    super(paramReactApplicationContext);
    this.mCatalystSettings = paramDeveloperSettings;
  }

  public String getName()
  {
    return "AnimationsDebugModule";
  }

  public void onCatalystInstanceDestroy()
  {
    if (this.mFrameCallback != null)
    {
      this.mFrameCallback.stop();
      this.mFrameCallback = null;
    }
  }

  @ReactMethod
  public void startRecordingFps()
  {
    if ((this.mCatalystSettings == null) || (!this.mCatalystSettings.isAnimationFpsDebugEnabled()))
      return;
    if (this.mFrameCallback != null)
      throw new JSApplicationCausedNativeException("Already recording FPS!");
    this.mFrameCallback = new FpsDebugFrameCallback(getReactApplicationContext());
    this.mFrameCallback.startAndRecordFpsAtEachFrame();
  }

  @ReactMethod
  public void stopRecordingFps(double paramDouble)
  {
    if (this.mFrameCallback == null)
      return;
    this.mFrameCallback.stop();
    FpsDebugFrameCallback.FpsInfo localFpsInfo = this.mFrameCallback.getFpsInfo(()paramDouble);
    if (localFpsInfo == null)
      Toast.makeText(getReactApplicationContext(), "Unable to get FPS info", 1);
    while (true)
    {
      this.mFrameCallback = null;
      return;
      Locale localLocale1 = Locale.US;
      Object[] arrayOfObject1 = new Object[3];
      arrayOfObject1[0] = Double.valueOf(localFpsInfo.fps);
      arrayOfObject1[1] = Integer.valueOf(localFpsInfo.totalFrames);
      arrayOfObject1[2] = Integer.valueOf(localFpsInfo.totalExpectedFrames);
      String str1 = String.format(localLocale1, "FPS: %.2f, %d frames (%d expected)", arrayOfObject1);
      Locale localLocale2 = Locale.US;
      Object[] arrayOfObject2 = new Object[3];
      arrayOfObject2[0] = Double.valueOf(localFpsInfo.jsFps);
      arrayOfObject2[1] = Integer.valueOf(localFpsInfo.totalJsFrames);
      arrayOfObject2[2] = Integer.valueOf(localFpsInfo.totalExpectedFrames);
      String str2 = String.format(localLocale2, "JS FPS: %.2f, %d frames (%d expected)", arrayOfObject2);
      StringBuilder localStringBuilder = new StringBuilder().append(str1).append("\n").append(str2).append("\nTotal Time MS: ");
      Locale localLocale3 = Locale.US;
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = Integer.valueOf(localFpsInfo.totalTimeMs);
      String str3 = String.format(localLocale3, "%d", arrayOfObject3);
      FLog.d("ReactNative", str3);
      Toast.makeText(getReactApplicationContext(), str3, 1).show();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.debug.AnimationsDebugModule
 * JD-Core Version:    0.6.2
 */