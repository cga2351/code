package com.viber.voip.phone.viber.conference.ui.controls;

public abstract class ControlStateResolver
{
  OnControlStateChangeListener mOnControlStateChangeListener;

  public abstract void activate(boolean paramBoolean);

  public abstract void disable();

  public abstract void enable();

  public void setOnControlStateChangeListener(OnControlStateChangeListener paramOnControlStateChangeListener)
  {
    this.mOnControlStateChangeListener = paramOnControlStateChangeListener;
  }

  public static abstract interface OnControlStateChangeListener
  {
    public abstract void onControlStateChanged(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.conference.ui.controls.ControlStateResolver
 * JD-Core Version:    0.6.2
 */