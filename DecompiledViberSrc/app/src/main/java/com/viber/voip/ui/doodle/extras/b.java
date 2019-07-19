package com.viber.voip.ui.doodle.extras;

public abstract interface b
{
  public abstract void addPoint(float paramFloat1, float paramFloat2);

  public abstract int getLength();

  public abstract float getX(int paramInt);

  public abstract float getY(int paramInt);

  public static abstract interface a<T extends b>
  {
    public abstract T a(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.extras.b
 * JD-Core Version:    0.6.2
 */