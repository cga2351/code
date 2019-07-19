package com.mixpanel.android.takeoverinapp;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.mixpanel.android.R.anim;
import com.mixpanel.android.R.id;
import com.mixpanel.android.R.layout;
import com.mixpanel.android.b.f;
import com.mixpanel.android.b.j;
import com.mixpanel.android.mpmetrics.InAppButton;
import com.mixpanel.android.mpmetrics.InAppNotification;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.mixpanel.android.mpmetrics.TakeoverInAppNotification;
import com.mixpanel.android.mpmetrics.UpdateDisplayState;
import com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.InAppNotificationState;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressLint({"ClickableViewAccessibility"})
@TargetApi(16)
public class TakeoverInAppActivity extends Activity
{
  private MixpanelAPI a;
  private UpdateDisplayState b;
  private int c = -1;

  private void a()
  {
    setContentView(R.layout.com_mixpanel_android_activity_notification_full);
    ImageView localImageView1 = (ImageView)findViewById(R.id.com_mixpanel_android_notification_gradient);
    FadingImageView localFadingImageView = (FadingImageView)findViewById(R.id.com_mixpanel_android_notification_image);
    TextView localTextView1 = (TextView)findViewById(R.id.com_mixpanel_android_notification_title);
    TextView localTextView2 = (TextView)findViewById(R.id.com_mixpanel_android_notification_subtext);
    ArrayList localArrayList = new ArrayList();
    Button localButton = (Button)findViewById(R.id.com_mixpanel_android_notification_button);
    localArrayList.add(localButton);
    localArrayList.add((Button)findViewById(R.id.com_mixpanel_android_notification_second_button));
    LinearLayout localLinearLayout = (LinearLayout)findViewById(R.id.com_mixpanel_android_button_exit_wrapper);
    ImageView localImageView2 = (ImageView)findViewById(R.id.com_mixpanel_android_image_close);
    TakeoverInAppNotification localTakeoverInAppNotification = (TakeoverInAppNotification)((UpdateDisplayState.DisplayState.InAppNotificationState)this.b.getDisplayState()).getInAppNotification();
    Display localDisplay = getWindowManager().getDefaultDisplay();
    Point localPoint = new Point();
    localDisplay.getSize(localPoint);
    if (getResources().getConfiguration().orientation == 1)
    {
      RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)localLinearLayout.getLayoutParams();
      localLayoutParams1.setMargins(0, 0, 0, (int)(0.06F * localPoint.y));
      localLinearLayout.setLayoutParams(localLayoutParams1);
    }
    localFadingImageView.a(localTakeoverInAppNotification.setShouldShowShadow());
    localImageView1.setBackgroundColor(localTakeoverInAppNotification.getBackgroundColor());
    if (localTakeoverInAppNotification.hasTitle())
    {
      localTextView1.setVisibility(0);
      localTextView1.setText(localTakeoverInAppNotification.getTitle());
      localTextView1.setTextColor(localTakeoverInAppNotification.getTitleColor());
      if (!localTakeoverInAppNotification.hasBody())
        break label364;
      localTextView2.setVisibility(0);
      localTextView2.setText(localTakeoverInAppNotification.getBody());
      localTextView2.setTextColor(localTakeoverInAppNotification.getBodyColor());
    }
    while (true)
    {
      localFadingImageView.setImageBitmap(localTakeoverInAppNotification.getImage());
      for (int i = 0; i < localArrayList.size(); i++)
      {
        InAppButton localInAppButton = localTakeoverInAppNotification.getButton(i);
        a((Button)localArrayList.get(i), localInAppButton, localTakeoverInAppNotification, i);
      }
      localTextView1.setVisibility(8);
      break;
      label364: localTextView2.setVisibility(8);
    }
    if (localTakeoverInAppNotification.getNumButtons() == 1)
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localButton.getLayoutParams();
      localLayoutParams.weight = 0.0F;
      localLayoutParams.width = -2;
      localButton.setLayoutParams(localLayoutParams);
    }
    localImageView2.setColorFilter(localTakeoverInAppNotification.getCloseColor());
    localLinearLayout.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        TakeoverInAppActivity.this.finish();
        UpdateDisplayState.releaseDisplayState(TakeoverInAppActivity.a(TakeoverInAppActivity.this));
      }
    });
    a(localFadingImageView, localTextView1, localTextView2, localArrayList, localLinearLayout);
  }

  private void a(Button paramButton, final InAppButton paramInAppButton, final InAppNotification paramInAppNotification, final int paramInt)
  {
    final int i = 864454278;
    if (paramInAppButton != null)
    {
      paramButton.setVisibility(0);
      paramButton.setText(paramInAppButton.getText());
      paramButton.setTextColor(paramInAppButton.getTextColor());
      paramButton.setTransformationMethod(null);
      final GradientDrawable localGradientDrawable = new GradientDrawable();
      if (paramInAppButton.getBackgroundColor() != 0)
        i = j.a(paramInAppButton.getBackgroundColor(), i);
      paramButton.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            int i = i;
            localGradientDrawable.setColor(i);
          }
          while (true)
          {
            return false;
            localGradientDrawable.setColor(paramInAppButton.getBackgroundColor());
          }
        }
      });
      localGradientDrawable.setColor(paramInAppButton.getBackgroundColor());
      localGradientDrawable.setStroke((int)j.a(2.0F, this), paramInAppButton.getBorderColor());
      localGradientDrawable.setCornerRadius((int)j.a(5.0F, this));
      if (Build.VERSION.SDK_INT < 16)
        paramButton.setBackgroundDrawable(localGradientDrawable);
      while (true)
      {
        paramButton.setOnClickListener(new View.OnClickListener()
        {
          // ERROR //
          public void onClick(View paramAnonymousView)
          {
            // Byte code:
            //   0: aload_0
            //   1: getfield 24	com/mixpanel/android/takeoverinapp/TakeoverInAppActivity$3:a	Lcom/mixpanel/android/mpmetrics/InAppButton;
            //   4: invokevirtual 45	com/mixpanel/android/mpmetrics/InAppButton:getCtaUrl	()Ljava/lang/String;
            //   7: astore_2
            //   8: aconst_null
            //   9: astore_3
            //   10: aload_2
            //   11: ifnull +65 -> 76
            //   14: aload_2
            //   15: invokevirtual 51	java/lang/String:length	()I
            //   18: istore 10
            //   20: aconst_null
            //   21: astore_3
            //   22: iload 10
            //   24: ifle +52 -> 76
            //   27: aload_2
            //   28: invokestatic 57	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
            //   31: astore 12
            //   33: new 59	android/content/Intent
            //   36: dup
            //   37: ldc 61
            //   39: aload 12
            //   41: invokespecial 64	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
            //   44: astore 13
            //   46: aload_0
            //   47: getfield 22	com/mixpanel/android/takeoverinapp/TakeoverInAppActivity$3:d	Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;
            //   50: aload 13
            //   52: invokevirtual 68	com/mixpanel/android/takeoverinapp/TakeoverInAppActivity:startActivity	(Landroid/content/Intent;)V
            //   55: new 70	org/json/JSONObject
            //   58: dup
            //   59: invokespecial 71	org/json/JSONObject:<init>	()V
            //   62: astore 15
            //   64: aload 15
            //   66: ldc 73
            //   68: aload_2
            //   69: invokevirtual 77	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
            //   72: pop
            //   73: aload 15
            //   75: astore_3
            //   76: ldc 79
            //   78: astore 4
            //   80: aload_0
            //   81: getfield 26	com/mixpanel/android/takeoverinapp/TakeoverInAppActivity$3:b	Lcom/mixpanel/android/mpmetrics/InAppNotification;
            //   84: checkcast 81	com/mixpanel/android/mpmetrics/TakeoverInAppNotification
            //   87: invokevirtual 84	com/mixpanel/android/mpmetrics/TakeoverInAppNotification:getNumButtons	()I
            //   90: iconst_2
            //   91: if_icmpne +18 -> 109
            //   94: aload_0
            //   95: getfield 28	com/mixpanel/android/takeoverinapp/TakeoverInAppActivity$3:c	I
            //   98: ifne +117 -> 215
            //   101: ldc 86
            //   103: astore 9
            //   105: aload 9
            //   107: astore 4
            //   109: aload_3
            //   110: ifnonnull +137 -> 247
            //   113: new 70	org/json/JSONObject
            //   116: dup
            //   117: invokespecial 71	org/json/JSONObject:<init>	()V
            //   120: astore 5
            //   122: aload 5
            //   124: ldc 88
            //   126: aload 4
            //   128: invokevirtual 77	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
            //   131: pop
            //   132: aload_0
            //   133: getfield 22	com/mixpanel/android/takeoverinapp/TakeoverInAppActivity$3:d	Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;
            //   136: invokestatic 91	com/mixpanel/android/takeoverinapp/TakeoverInAppActivity:b	(Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;)Lcom/mixpanel/android/mpmetrics/MixpanelAPI;
            //   139: invokevirtual 97	com/mixpanel/android/mpmetrics/MixpanelAPI:getPeople	()Lcom/mixpanel/android/mpmetrics/MixpanelAPI$c;
            //   142: ldc 99
            //   144: aload_0
            //   145: getfield 26	com/mixpanel/android/takeoverinapp/TakeoverInAppActivity$3:b	Lcom/mixpanel/android/mpmetrics/InAppNotification;
            //   148: aload 5
            //   150: invokeinterface 104 4 0
            //   155: aload_0
            //   156: getfield 22	com/mixpanel/android/takeoverinapp/TakeoverInAppActivity$3:d	Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;
            //   159: invokevirtual 107	com/mixpanel/android/takeoverinapp/TakeoverInAppActivity:finish	()V
            //   162: aload_0
            //   163: getfield 22	com/mixpanel/android/takeoverinapp/TakeoverInAppActivity$3:d	Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;
            //   166: invokestatic 110	com/mixpanel/android/takeoverinapp/TakeoverInAppActivity:a	(Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;)I
            //   169: invokestatic 116	com/mixpanel/android/mpmetrics/UpdateDisplayState:releaseDisplayState	(I)V
            //   172: return
            //   173: astore 11
            //   175: ldc 118
            //   177: ldc 120
            //   179: aload 11
            //   181: invokestatic 125	com/mixpanel/android/b/f:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
            //   184: return
            //   185: astore 14
            //   187: ldc 118
            //   189: ldc 127
            //   191: invokestatic 130	com/mixpanel/android/b/f:c	(Ljava/lang/String;Ljava/lang/String;)V
            //   194: goto -139 -> 55
            //   197: astore 18
            //   199: aconst_null
            //   200: astore 15
            //   202: ldc 118
            //   204: ldc 132
            //   206: invokestatic 135	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;)V
            //   209: aload 15
            //   211: astore_3
            //   212: goto -136 -> 76
            //   215: ldc 79
            //   217: astore 9
            //   219: goto -114 -> 105
            //   222: astore 8
            //   224: aload_3
            //   225: astore 5
            //   227: ldc 118
            //   229: ldc 137
            //   231: invokestatic 135	com/mixpanel/android/b/f:e	(Ljava/lang/String;Ljava/lang/String;)V
            //   234: goto -102 -> 132
            //   237: astore 6
            //   239: goto -12 -> 227
            //   242: astore 16
            //   244: goto -42 -> 202
            //   247: aload_3
            //   248: astore 5
            //   250: goto -128 -> 122
            //
            // Exception table:
            //   from	to	target	type
            //   27	33	173	java/lang/IllegalArgumentException
            //   33	55	185	android/content/ActivityNotFoundException
            //   55	64	197	org/json/JSONException
            //   113	122	222	org/json/JSONException
            //   122	132	237	org/json/JSONException
            //   64	73	242	org/json/JSONException
          }
        });
        return;
        paramButton.setBackground(localGradientDrawable);
      }
    }
    paramButton.setVisibility(8);
  }

  private void a(ImageView paramImageView, TextView paramTextView1, TextView paramTextView2, ArrayList<Button> paramArrayList, LinearLayout paramLinearLayout)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.95F, 1.0F, 0.95F, 1.0F, 1, 0.5F, 1, 1.0F);
    localScaleAnimation.setDuration(200L);
    paramImageView.startAnimation(localScaleAnimation);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.5F, 1, 0.0F);
    localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
    localTranslateAnimation.setDuration(200L);
    paramTextView1.startAnimation(localTranslateAnimation);
    paramTextView2.startAnimation(localTranslateAnimation);
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
      ((Button)localIterator.next()).startAnimation(localTranslateAnimation);
    paramLinearLayout.startAnimation(AnimationUtils.loadAnimation(this, R.anim.com_mixpanel_android_fade_in));
  }

  public void onBackPressed()
  {
    UpdateDisplayState.releaseDisplayState(this.c);
    super.onBackPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.c = getIntent().getIntExtra("com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.INTENT_ID_KEY", 2147483647);
    this.b = UpdateDisplayState.claimDisplayState(this.c);
    if (this.b == null)
    {
      f.e("MixpanelAPI.TakeoverInAppActivity", "TakeoverInAppActivity intent received, but nothing was found to show.");
      finish();
      return;
    }
    this.a = MixpanelAPI.getInstance(this, this.b.getToken());
    a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.takeoverinapp.TakeoverInAppActivity
 * JD-Core Version:    0.6.2
 */