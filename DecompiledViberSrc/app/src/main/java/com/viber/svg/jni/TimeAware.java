package com.viber.svg.jni;

public abstract interface TimeAware
{
  public static final Clock fallbackClock = new Clock()
  {
    private final long refTime = System.currentTimeMillis();

    public double getCurrentTime()
    {
      return (System.currentTimeMillis() - this.refTime) / 1000.0D;
    }

    public boolean isTimeFrozen()
    {
      return false;
    }
  };

  public abstract void setClock(Clock paramClock);

  public static abstract interface Clock
  {
    public abstract double getCurrentTime();

    public abstract boolean isTimeFrozen();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.TimeAware
 * JD-Core Version:    0.6.2
 */