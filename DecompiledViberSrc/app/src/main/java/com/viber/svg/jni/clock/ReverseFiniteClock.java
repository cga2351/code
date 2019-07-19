package com.viber.svg.jni.clock;

public class ReverseFiniteClock extends FiniteClock
{
  public ReverseFiniteClock(double paramDouble)
  {
    super(paramDouble);
  }

  public ReverseFiniteClock(double paramDouble1, double paramDouble2)
  {
    super(paramDouble1, paramDouble2);
  }

  public double getCurrentTime()
  {
    return this.mOffsetTime + getDuration() - (super.getCurrentTime() - this.mOffsetTime);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.clock.ReverseFiniteClock
 * JD-Core Version:    0.6.2
 */