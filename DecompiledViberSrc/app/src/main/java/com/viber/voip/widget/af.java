package com.viber.voip.widget;

import com.viber.svg.jni.TimeAware.Clock;

public class af
  implements TimeAware.Clock
{
  protected double a;

  public af(double paramDouble)
  {
    this.a = paramDouble;
  }

  public double getCurrentTime()
  {
    return this.a;
  }

  public boolean isTimeFrozen()
  {
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.af
 * JD-Core Version:    0.6.2
 */