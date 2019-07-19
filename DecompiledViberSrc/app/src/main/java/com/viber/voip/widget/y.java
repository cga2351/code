package com.viber.voip.widget;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.widget.ProgressBar;
import com.viber.voip.R.drawable;
import com.viber.voip.ViberApplication;

public class y
{
  public static void a(ProgressBar paramProgressBar, int paramInt)
  {
    Resources localResources = ViberApplication.getApplication().getResources();
    int i = localResources.getDimensionPixelSize(paramInt);
    Drawable localDrawable = localResources.getDrawable(R.drawable.viber_indeterminate_progress);
    localDrawable.setBounds(new Rect(0, 0, i, i));
    paramProgressBar.setIndeterminate(true);
    paramProgressBar.setIndeterminateDrawable(localDrawable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.y
 * JD-Core Version:    0.6.2
 */