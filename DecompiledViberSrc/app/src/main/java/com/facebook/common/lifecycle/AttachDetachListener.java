package com.facebook.common.lifecycle;

import android.view.View;

public abstract interface AttachDetachListener
{
  public abstract void onAttachToView(View paramView);

  public abstract void onDetachFromView(View paramView);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.lifecycle.AttachDetachListener
 * JD-Core Version:    0.6.2
 */