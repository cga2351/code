package com.viber.voip.registration;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class RegistrationScrollView extends ScrollView
{
  private a a;

  public RegistrationScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.a != null)
      this.a.a();
  }

  public void setOnResizeViewListener(a parama)
  {
    this.a = parama;
  }

  public static abstract interface a
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.RegistrationScrollView
 * JD-Core Version:    0.6.2
 */