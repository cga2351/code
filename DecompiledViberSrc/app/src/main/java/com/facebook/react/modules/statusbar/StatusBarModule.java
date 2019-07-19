package com.facebook.react.modules.statusbar;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.Window;
import android.view.WindowInsets;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import java.util.Map;
import javax.annotation.Nullable;

@ReactModule(name="StatusBarManager")
public class StatusBarModule extends ReactContextBaseJavaModule
{
  private static final String DEFAULT_BACKGROUND_COLOR_KEY = "DEFAULT_BACKGROUND_COLOR";
  private static final String HEIGHT_KEY = "HEIGHT";
  public static final String NAME = "StatusBarManager";

  public StatusBarModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  @Nullable
  public Map<String, Object> getConstants()
  {
    ReactApplicationContext localReactApplicationContext = getReactApplicationContext();
    Activity localActivity = getCurrentActivity();
    int i = localReactApplicationContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (i > 0);
    for (float f = PixelUtil.toDIPFromPixel(localReactApplicationContext.getResources().getDimensionPixelSize(i)); ; f = 0.0F)
    {
      String str = "black";
      if ((localActivity != null) && (Build.VERSION.SDK_INT >= 21))
      {
        int j = localActivity.getWindow().getStatusBarColor();
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(j & 0xFFFFFF);
        str = String.format("#%06X", arrayOfObject);
      }
      return MapBuilder.of("HEIGHT", Float.valueOf(f), "DEFAULT_BACKGROUND_COLOR", str);
    }
  }

  public String getName()
  {
    return "StatusBarManager";
  }

  @ReactMethod
  public void setColor(final int paramInt, final boolean paramBoolean)
  {
    final Activity localActivity = getCurrentActivity();
    if (localActivity == null)
      FLog.w("ReactNative", "StatusBarModule: Ignored status bar change, current activity is null.");
    while (Build.VERSION.SDK_INT < 21)
      return;
    UiThreadUtil.runOnUiThread(new GuardedRunnable(getReactApplicationContext())
    {
      @TargetApi(21)
      public void runGuarded()
      {
        localActivity.getWindow().addFlags(-2147483648);
        if (paramBoolean)
        {
          int i = localActivity.getWindow().getStatusBarColor();
          ArgbEvaluator localArgbEvaluator = new ArgbEvaluator();
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = Integer.valueOf(i);
          arrayOfObject[1] = Integer.valueOf(paramInt);
          ValueAnimator localValueAnimator = ValueAnimator.ofObject(localArgbEvaluator, arrayOfObject);
          localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
          {
            public void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
            {
              StatusBarModule.1.this.val$activity.getWindow().setStatusBarColor(((Integer)paramAnonymous2ValueAnimator.getAnimatedValue()).intValue());
            }
          });
          localValueAnimator.setDuration(300L).setStartDelay(0L);
          localValueAnimator.start();
          return;
        }
        localActivity.getWindow().setStatusBarColor(paramInt);
      }
    });
  }

  @ReactMethod
  public void setHidden(final boolean paramBoolean)
  {
    final Activity localActivity = getCurrentActivity();
    if (localActivity == null)
    {
      FLog.w("ReactNative", "StatusBarModule: Ignored status bar change, current activity is null.");
      return;
    }
    UiThreadUtil.runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (paramBoolean)
        {
          localActivity.getWindow().addFlags(1024);
          localActivity.getWindow().clearFlags(2048);
          return;
        }
        localActivity.getWindow().addFlags(2048);
        localActivity.getWindow().clearFlags(1024);
      }
    });
  }

  @ReactMethod
  public void setStyle(@Nullable final String paramString)
  {
    final Activity localActivity = getCurrentActivity();
    if (localActivity == null)
      FLog.w("ReactNative", "StatusBarModule: Ignored status bar change, current activity is null.");
    while (Build.VERSION.SDK_INT < 23)
      return;
    UiThreadUtil.runOnUiThread(new Runnable()
    {
      @TargetApi(23)
      public void run()
      {
        View localView = localActivity.getWindow().getDecorView();
        int i = localView.getSystemUiVisibility();
        if ("dark-content".equals(paramString));
        for (int j = i | 0x2000; ; j = i & 0xFFFFDFFF)
        {
          localView.setSystemUiVisibility(j);
          return;
        }
      }
    });
  }

  @ReactMethod
  public void setTranslucent(final boolean paramBoolean)
  {
    final Activity localActivity = getCurrentActivity();
    if (localActivity == null)
      FLog.w("ReactNative", "StatusBarModule: Ignored status bar change, current activity is null.");
    while (Build.VERSION.SDK_INT < 21)
      return;
    UiThreadUtil.runOnUiThread(new GuardedRunnable(getReactApplicationContext())
    {
      @TargetApi(21)
      public void runGuarded()
      {
        View localView = localActivity.getWindow().getDecorView();
        if (paramBoolean)
          localView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener()
          {
            public WindowInsets onApplyWindowInsets(View paramAnonymous2View, WindowInsets paramAnonymous2WindowInsets)
            {
              WindowInsets localWindowInsets = paramAnonymous2View.onApplyWindowInsets(paramAnonymous2WindowInsets);
              return localWindowInsets.replaceSystemWindowInsets(localWindowInsets.getSystemWindowInsetLeft(), 0, localWindowInsets.getSystemWindowInsetRight(), localWindowInsets.getSystemWindowInsetBottom());
            }
          });
        while (true)
        {
          ViewCompat.requestApplyInsets(localView);
          return;
          localView.setOnApplyWindowInsetsListener(null);
        }
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.statusbar.StatusBarModule
 * JD-Core Version:    0.6.2
 */