package com.viber.voip.messages.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.a;
import android.support.v7.widget.ActionBarContextView;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.viber.dexshared.Logger;
import com.viber.voip.R.dimen;
import com.viber.voip.ViberEnv;

public class ActionModeContentLayout extends LinearLayout
{
  private static final Logger a = ViberEnv.getLogger();
  private int b;
  private boolean c = false;

  public ActionModeContentLayout(Context paramContext)
  {
    super(paramContext);
  }

  public ActionModeContentLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ActionModeContentLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    try
    {
      this.b = 0;
      a locala = ((AppCompatActivity)getContext()).getSupportActionBar();
      if (locala != null)
        this.b = locala.e();
      if (this.b == 0)
        this.b = getResources().getDimensionPixelSize(R.dimen.conversations_action_mode_height);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.c = false;
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    try
    {
      ActionBarContextView localActionBarContextView = (ActionBarContextView)getParent();
      if ((!this.c) && (localActionBarContextView.getContentHeight() != this.b))
      {
        localActionBarContextView.setContentHeight(this.b);
        requestLayout();
        this.c = true;
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.view.ActionModeContentLayout
 * JD-Core Version:    0.6.2
 */