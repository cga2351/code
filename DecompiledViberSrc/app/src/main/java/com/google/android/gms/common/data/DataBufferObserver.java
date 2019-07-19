package com.google.android.gms.common.data;

public abstract interface DataBufferObserver
{
  public abstract void onDataChanged();

  public abstract void onDataRangeChanged(int paramInt1, int paramInt2);

  public abstract void onDataRangeInserted(int paramInt1, int paramInt2);

  public abstract void onDataRangeMoved(int paramInt1, int paramInt2, int paramInt3);

  public abstract void onDataRangeRemoved(int paramInt1, int paramInt2);

  public static abstract interface Observable
  {
    public abstract void addObserver(DataBufferObserver paramDataBufferObserver);

    public abstract void removeObserver(DataBufferObserver paramDataBufferObserver);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.DataBufferObserver
 * JD-Core Version:    0.6.2
 */