package com.appboy.ui.inappmessage.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.appboy.b.a.i;
import com.appboy.e.n;
import com.appboy.f.b;
import com.appboy.f.c;
import com.appboy.ui.R.color;
import com.appboy.ui.inappmessage.AppboyInAppMessageManager;
import java.util.List;

public class InAppMessageViewUtils
{
  private static final String TAG = c.a(InAppMessageViewUtils.class);

  public static void closeInAppMessageOnKeycodeBack()
  {
    c.b(TAG, "Back button intercepted by in-app message view, closing in-app message.");
    AppboyInAppMessageManager.getInstance().hideCurrentlyDisplayingInAppMessage(true);
  }

  public static boolean isValidIcon(String paramString)
  {
    return paramString != null;
  }

  protected static void resetMessageMarginsIfNecessary(TextView paramTextView1, TextView paramTextView2)
  {
    if ((paramTextView2 == null) && (paramTextView1 != null))
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramTextView1.getLayoutParams().width, paramTextView1.getLayoutParams().height);
      localLayoutParams.setMargins(0, 0, 0, 0);
      paramTextView1.setLayoutParams(localLayoutParams);
    }
  }

  @TargetApi(21)
  private static void safeSetLayerDrawableBackground(Button paramButton)
  {
    RippleDrawable localRippleDrawable = new RippleDrawable(ColorStateList.valueOf(paramButton.getContext().getResources().getColor(R.color.com_appboy_inappmessage_button_ripple)), null, paramButton.getBackground());
    Drawable[] arrayOfDrawable = new Drawable[2];
    arrayOfDrawable[0] = paramButton.getBackground();
    arrayOfDrawable[1] = localRippleDrawable;
    paramButton.setBackground(new LayerDrawable(arrayOfDrawable));
  }

  public static void setButtons(List<View> paramList, List<n> paramList1)
  {
    int i = 0;
    if (i < paramList.size())
    {
      if (paramList1.size() <= i)
        ((View)paramList.get(i)).setVisibility(8);
      while (true)
      {
        i++;
        break;
        if ((paramList.get(i) instanceof Button))
        {
          Button localButton = (Button)paramList.get(i);
          n localn = (n)paramList1.get(i);
          localButton.setText(localn.d());
          Drawable localDrawable = localButton.getBackground();
          if ((localDrawable instanceof GradientDrawable))
          {
            GradientDrawable localGradientDrawable = (GradientDrawable)localDrawable;
            localGradientDrawable.setStroke(b.a(localButton.getContext(), 1), localn.g());
            localGradientDrawable.setColor(localn.e());
          }
          if (Build.VERSION.SDK_INT >= 21)
          {
            safeSetLayerDrawableBackground(localButton);
            localButton.setStateListAnimator(null);
          }
          setTextViewColor(localButton, localn.f());
        }
      }
    }
  }

  public static void setDrawableColor(Drawable paramDrawable, int paramInt)
  {
    if ((Build.VERSION.SDK_INT >= 21) && ((paramDrawable instanceof LayerDrawable)))
    {
      LayerDrawable localLayerDrawable = (LayerDrawable)paramDrawable;
      if ((localLayerDrawable.getNumberOfLayers() <= 0) || (!(localLayerDrawable.getDrawable(0) instanceof GradientDrawable)))
        break label63;
      setDrawableColor(localLayerDrawable.getDrawable(0), paramInt);
    }
    while ((paramDrawable instanceof GradientDrawable))
    {
      setDrawableColor((GradientDrawable)paramDrawable, paramInt);
      return;
      label63: c.b(TAG, "LayerDrawable for button background did not have the expected number of layers or the 0th layer was not a GradientDrawable.");
    }
    paramDrawable.setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
  }

  private static void setDrawableColor(GradientDrawable paramGradientDrawable, int paramInt)
  {
    paramGradientDrawable.setColor(paramInt);
  }

  public static void setFrameColor(View paramView, Integer paramInteger)
  {
    if (paramInteger != null)
      paramView.setBackgroundColor(paramInteger.intValue());
  }

  public static void setIcon(Context paramContext, String paramString, int paramInt1, int paramInt2, TextView paramTextView)
  {
    if (isValidIcon(paramString));
    try
    {
      paramTextView.setTypeface(Typeface.createFromAsset(paramContext.getAssets(), "fontawesome-webfont.ttf"));
      paramTextView.setText(paramString);
      setTextViewColor(paramTextView, paramInt1);
      if (paramTextView.getBackground() != null)
      {
        setDrawableColor(paramTextView.getBackground(), paramInt2);
        return;
      }
    }
    catch (Exception localException)
    {
      c.d(TAG, "Caught exception setting icon typeface. Not rendering icon.", localException);
      return;
    }
    setViewBackgroundColor(paramTextView, paramInt2);
  }

  public static void setImage(Bitmap paramBitmap, ImageView paramImageView)
  {
    if (paramBitmap != null)
      paramImageView.setImageBitmap(paramBitmap);
  }

  public static void setTextAlignment(TextView paramTextView, i parami)
  {
    if (parami.equals(i.a))
      paramTextView.setGravity(8388611);
    do
    {
      return;
      if (parami.equals(i.c))
      {
        paramTextView.setGravity(8388613);
        return;
      }
    }
    while (!parami.equals(i.b));
    paramTextView.setGravity(17);
  }

  public static void setTextViewColor(TextView paramTextView, int paramInt)
  {
    paramTextView.setTextColor(paramInt);
  }

  public static void setViewBackgroundColor(View paramView, int paramInt)
  {
    paramView.setBackgroundColor(paramInt);
  }

  public static void setViewBackgroundColorFilter(View paramView, int paramInt)
  {
    paramView.getBackground().setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    paramView.getBackground().setAlpha(Color.alpha(paramInt));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.inappmessage.views.InAppMessageViewUtils
 * JD-Core Version:    0.6.2
 */