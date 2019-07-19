package com.mixpanel.android.mpmetrics;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.mixpanel.android.R.animator;
import com.mixpanel.android.R.id;
import com.mixpanel.android.R.layout;
import com.mixpanel.android.b.j;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"ClickableViewAccessibility"})
@TargetApi(16)
public class h extends Fragment
{
  private MixpanelAPI a;
  private Activity b;
  private GestureDetector c;
  private Handler d;
  private int e;
  private UpdateDisplayState.DisplayState.InAppNotificationState f;
  private Runnable g;
  private Runnable h;
  private View i;
  private AtomicBoolean j = new AtomicBoolean();

  private void a()
  {
    FragmentManager localFragmentManager;
    FragmentTransaction localFragmentTransaction;
    if (!this.j.get())
    {
      this.d.removeCallbacks(this.g);
      this.d.removeCallbacks(this.h);
      UpdateDisplayState.releaseDisplayState(this.e);
      localFragmentManager = this.b.getFragmentManager();
      localFragmentTransaction = localFragmentManager.beginTransaction();
    }
    try
    {
      localFragmentTransaction.remove(this).commit();
      this.j.set(true);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      while (true)
        localFragmentManager.beginTransaction().remove(this).commitAllowingStateLoss();
    }
  }

  private void b()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 17)
      bool = this.b.isDestroyed();
    while (true)
    {
      FragmentManager localFragmentManager;
      FragmentTransaction localFragmentTransaction;
      if ((this.b != null) && (!this.b.isFinishing()) && (!bool) && (!this.j.get()))
      {
        this.d.removeCallbacks(this.g);
        this.d.removeCallbacks(this.h);
        localFragmentManager = this.b.getFragmentManager();
        localFragmentTransaction = localFragmentManager.beginTransaction();
      }
      try
      {
        localFragmentTransaction.setCustomAnimations(0, R.animator.com_mixpanel_android_slide_down).remove(this).commit();
        UpdateDisplayState.releaseDisplayState(this.e);
        this.j.set(true);
        return;
        bool = false;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        while (true)
          localFragmentManager.beginTransaction().setCustomAnimations(0, R.animator.com_mixpanel_android_slide_down).remove(this).commitAllowingStateLoss();
      }
    }
  }

  public void a(MixpanelAPI paramMixpanelAPI, int paramInt, UpdateDisplayState.DisplayState.InAppNotificationState paramInAppNotificationState)
  {
    this.a = paramMixpanelAPI;
    this.e = paramInt;
    this.f = paramInAppNotificationState;
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.b = paramActivity;
    if (this.f == null)
    {
      a();
      return;
    }
    this.d = new Handler();
    this.g = new Runnable()
    {
      public void run()
      {
        h.a(h.this);
      }
    };
    this.h = new Runnable()
    {
      public void run()
      {
        h.b(h.this).setVisibility(0);
        h.b(h.this).setOnTouchListener(new View.OnTouchListener()
        {
          public boolean onTouch(View paramAnonymous2View, MotionEvent paramAnonymous2MotionEvent)
          {
            return h.c(h.this).onTouchEvent(paramAnonymous2MotionEvent);
          }
        });
        ImageView localImageView = (ImageView)h.b(h.this).findViewById(R.id.com_mixpanel_android_notification_image);
        float f = TypedValue.applyDimension(1, 65.0F, h.d(h.this).getResources().getDisplayMetrics());
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, f, 0.0F);
        localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
        localTranslateAnimation.setDuration(200L);
        h.b(h.this).startAnimation(localTranslateAnimation);
        ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, f / 2.0F, f / 2.0F);
        localScaleAnimation.setInterpolator(new h.a(h.this));
        localScaleAnimation.setDuration(400L);
        localScaleAnimation.setStartOffset(200L);
        localImageView.startAnimation(localScaleAnimation);
      }
    };
    this.c = new GestureDetector(paramActivity, new GestureDetector.OnGestureListener()
    {
      public boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }

      public boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        if (paramAnonymousFloat2 > 0.0F)
          h.a(h.this);
        return true;
      }

      public void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
      }

      public boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        return false;
      }

      public void onShowPress(MotionEvent paramAnonymousMotionEvent)
      {
      }

      // ERROR //
      public boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 17	com/mixpanel/android/mpmetrics/h$3:a	Lcom/mixpanel/android/mpmetrics/h;
        //   4: invokestatic 41	com/mixpanel/android/mpmetrics/h:e	(Lcom/mixpanel/android/mpmetrics/h;)Lcom/mixpanel/android/mpmetrics/UpdateDisplayState$DisplayState$InAppNotificationState;
        //   7: invokevirtual 47	com/mixpanel/android/mpmetrics/UpdateDisplayState$DisplayState$InAppNotificationState:getInAppNotification	()Lcom/mixpanel/android/mpmetrics/InAppNotification;
        //   10: checkcast 49	com/mixpanel/android/mpmetrics/MiniInAppNotification
        //   13: astore_2
        //   14: aload_2
        //   15: invokevirtual 53	com/mixpanel/android/mpmetrics/MiniInAppNotification:getCtaUrl	()Ljava/lang/String;
        //   18: astore_3
        //   19: aload_3
        //   20: ifnull +151 -> 171
        //   23: aload_3
        //   24: invokevirtual 59	java/lang/String:length	()I
        //   27: ifle +144 -> 171
        //   30: aload_3
        //   31: invokestatic 65	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
        //   34: astore 6
        //   36: new 67	android/content/Intent
        //   39: dup
        //   40: ldc 69
        //   42: aload 6
        //   44: invokespecial 72	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
        //   47: astore 7
        //   49: aload_0
        //   50: getfield 17	com/mixpanel/android/mpmetrics/h$3:a	Lcom/mixpanel/android/mpmetrics/h;
        //   53: invokestatic 76	com/mixpanel/android/mpmetrics/h:d	(Lcom/mixpanel/android/mpmetrics/h;)Landroid/app/Activity;
        //   56: aload 7
        //   58: invokevirtual 82	android/app/Activity:startActivity	(Landroid/content/Intent;)V
        //   61: new 84	org/json/JSONObject
        //   64: dup
        //   65: invokespecial 85	org/json/JSONObject:<init>	()V
        //   68: astore 4
        //   70: aload 4
        //   72: ldc 87
        //   74: aload_3
        //   75: invokevirtual 91	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   78: pop
        //   79: aload_0
        //   80: getfield 17	com/mixpanel/android/mpmetrics/h$3:a	Lcom/mixpanel/android/mpmetrics/h;
        //   83: invokestatic 95	com/mixpanel/android/mpmetrics/h:f	(Lcom/mixpanel/android/mpmetrics/h;)Lcom/mixpanel/android/mpmetrics/MixpanelAPI;
        //   86: invokevirtual 101	com/mixpanel/android/mpmetrics/MixpanelAPI:getPeople	()Lcom/mixpanel/android/mpmetrics/MixpanelAPI$c;
        //   89: ldc 103
        //   91: aload_2
        //   92: aload 4
        //   94: invokeinterface 108 4 0
        //   99: aload_0
        //   100: getfield 17	com/mixpanel/android/mpmetrics/h$3:a	Lcom/mixpanel/android/mpmetrics/h;
        //   103: invokestatic 26	com/mixpanel/android/mpmetrics/h:a	(Lcom/mixpanel/android/mpmetrics/h;)V
        //   106: iconst_1
        //   107: ireturn
        //   108: astore 5
        //   110: ldc 110
        //   112: ldc 112
        //   114: aload 5
        //   116: invokestatic 118	com/mixpanel/android/b/f:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   119: iconst_1
        //   120: ireturn
        //   121: astore 8
        //   123: ldc 110
        //   125: new 120	java/lang/StringBuilder
        //   128: dup
        //   129: invokespecial 121	java/lang/StringBuilder:<init>	()V
        //   132: ldc 123
        //   134: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   137: aload 6
        //   139: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   142: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   145: invokestatic 136	com/mixpanel/android/b/f:c	(Ljava/lang/String;Ljava/lang/String;)V
        //   148: goto -87 -> 61
        //   151: astore 11
        //   153: aconst_null
        //   154: astore 4
        //   156: ldc 110
        //   158: ldc 138
        //   160: invokestatic 140	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   163: goto -84 -> 79
        //   166: astore 9
        //   168: goto -12 -> 156
        //   171: aconst_null
        //   172: astore 4
        //   174: goto -95 -> 79
        //
        // Exception table:
        //   from	to	target	type
        //   30	36	108	java/lang/IllegalArgumentException
        //   36	61	121	android/content/ActivityNotFoundException
        //   61	70	151	org/json/JSONException
        //   70	79	166	org/json/JSONException
      }
    });
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.j.set(false);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.f == null)
    {
      a();
      return this.i;
    }
    this.i = paramLayoutInflater.inflate(R.layout.com_mixpanel_android_activity_notification_mini, paramViewGroup, false);
    TextView localTextView = (TextView)this.i.findViewById(R.id.com_mixpanel_android_notification_title);
    ImageView localImageView = (ImageView)this.i.findViewById(R.id.com_mixpanel_android_notification_image);
    MiniInAppNotification localMiniInAppNotification = (MiniInAppNotification)this.f.getInAppNotification();
    localTextView.setText(localMiniInAppNotification.getBody());
    localTextView.setTextColor(localMiniInAppNotification.getBodyColor());
    localImageView.setImageBitmap(localMiniInAppNotification.getImage());
    this.d.postDelayed(this.g, 10000L);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(localMiniInAppNotification.getBackgroundColor());
    localGradientDrawable.setCornerRadius(j.a(7.0F, getActivity()));
    localGradientDrawable.setStroke((int)j.a(2.0F, getActivity()), localMiniInAppNotification.getBorderColor());
    if (Build.VERSION.SDK_INT < 16)
      this.i.setBackgroundDrawable(localGradientDrawable);
    while (true)
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(getResources(), this.f.getInAppNotification().getImage());
      localBitmapDrawable.setColorFilter(localMiniInAppNotification.getImageTintColor(), PorterDuff.Mode.SRC_ATOP);
      localImageView.setImageDrawable(localBitmapDrawable);
      break;
      this.i.setBackground(localGradientDrawable);
    }
  }

  public void onPause()
  {
    super.onPause();
    a();
  }

  public void onResume()
  {
    super.onResume();
    this.d.postDelayed(this.h, 500L);
  }

  public void onStart()
  {
    super.onStart();
    if (this.j.get())
      this.b.getFragmentManager().beginTransaction().remove(this).commit();
  }

  private class a
    implements Interpolator
  {
    public a()
    {
    }

    public float getInterpolation(float paramFloat)
    {
      return 1.0F + (float)-(Math.pow(2.718281828459045D, -8.0F * paramFloat) * Math.cos(12.0F * paramFloat));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.mpmetrics.h
 * JD-Core Version:    0.6.2
 */