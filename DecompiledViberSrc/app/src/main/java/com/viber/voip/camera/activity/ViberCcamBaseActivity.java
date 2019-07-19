package com.viber.voip.camera.activity;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.viber.voip.camera.e.b.a;
import com.viber.voip.camera.e.b.a.b;

public abstract class ViberCcamBaseActivity extends AppCompatActivity
{
  protected a C;
  private boolean a;

  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (z() != null))
    {
      if (paramBoolean2)
        z().a(1500L);
    }
    else
      return;
    z().a();
  }

  public <T extends View> T a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    return a(paramInt, paramOnClickListener, null);
  }

  public <T extends View> T a(int paramInt, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    return a(paramInt, paramOnClickListener, paramOnLongClickListener, null);
  }

  public <T extends View> T a(int paramInt, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, View.OnTouchListener paramOnTouchListener)
  {
    View localView = super.findViewById(paramInt);
    if ((localView != null) && (paramOnClickListener != null))
      localView.setOnClickListener(paramOnClickListener);
    if ((localView != null) && (paramOnLongClickListener != null))
      localView.setOnLongClickListener(paramOnLongClickListener);
    if ((localView != null) && (paramOnTouchListener != null))
      localView.setOnTouchListener(paramOnTouchListener);
    return localView;
  }

  public <T extends View> T g(int paramInt)
  {
    return a(paramInt, null);
  }

  public final boolean isDestroyed()
  {
    return this.a;
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(true, false);
  }

  protected void onDestroy()
  {
    super.onDestroy();
    this.a = true;
  }

  protected void onResume()
  {
    super.onResume();
    a(true, false);
  }

  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    a(paramBoolean, false);
  }

  public final Activity y()
  {
    return this;
  }

  protected a z()
  {
    int i;
    if (this.C == null)
    {
      if (Build.VERSION.SDK_INT < 19)
        break label54;
      i = 3;
      if (Build.VERSION.SDK_INT < 19)
        break label59;
    }
    label54: label59: for (int j = 2; ; j = 0)
    {
      this.C = new a(this, i, j, new a.b()
      {
        public void a(boolean paramAnonymousBoolean)
        {
          ViberCcamBaseActivity.a(ViberCcamBaseActivity.this, paramAnonymousBoolean, true);
        }
      });
      return this.C;
      i = 1;
      break;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camera.activity.ViberCcamBaseActivity
 * JD-Core Version:    0.6.2
 */