package com.google.android.exoplayer2.ui;

public abstract interface g
{
  public abstract void a(a parama);

  public abstract void a(long[] paramArrayOfLong, boolean[] paramArrayOfBoolean, int paramInt);

  public abstract void setBufferedPosition(long paramLong);

  public abstract void setDuration(long paramLong);

  public abstract void setEnabled(boolean paramBoolean);

  public abstract void setPosition(long paramLong);

  public static abstract interface a
  {
    public abstract void a(g paramg, long paramLong);

    public abstract void a(g paramg, long paramLong, boolean paramBoolean);

    public abstract void b(g paramg, long paramLong);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.ui.g
 * JD-Core Version:    0.6.2
 */