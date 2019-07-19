package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.ArrayList;

@KeepForSdk
public abstract class EntityBuffer<T> extends AbstractDataBuffer<T>
{
  private boolean zamd = false;
  private ArrayList<Integer> zame;

  @KeepForSdk
  protected EntityBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }

  private final void zacb()
  {
    while (true)
    {
      int k;
      Object localObject3;
      try
      {
        if (this.zamd)
          break label209;
        int i = this.mDataHolder.getCount();
        this.zame = new ArrayList();
        if (i <= 0)
          break label204;
        this.zame.add(Integer.valueOf(0));
        String str = getPrimaryDataMarkerColumn();
        int j = this.mDataHolder.getWindowIndex(0);
        localObject2 = this.mDataHolder.getString(str, 0, j);
        k = 1;
        if (k >= i)
          break label204;
        int m = this.mDataHolder.getWindowIndex(k);
        localObject3 = this.mDataHolder.getString(str, k, m);
        if (localObject3 == null)
          throw new NullPointerException(78 + String.valueOf(str).length() + "Missing value for markerColumn: " + str + ", at row: " + k + ", for window: " + m);
      }
      finally
      {
      }
      if (!((String)localObject3).equals(localObject2))
      {
        this.zame.add(Integer.valueOf(k));
        break label216;
        label204: this.zamd = true;
      }
      else
      {
        label209: localObject3 = localObject2;
      }
      label216: k++;
      Object localObject2 = localObject3;
    }
  }

  private final int zah(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.zame.size()))
      throw new IllegalArgumentException(53 + "Position " + paramInt + " is out of bounds for this buffer");
    return ((Integer)this.zame.get(paramInt)).intValue();
  }

  @KeepForSdk
  public final T get(int paramInt)
  {
    zacb();
    int i = zah(paramInt);
    int j;
    if ((paramInt < 0) || (paramInt == this.zame.size()))
      j = 0;
    label158: 
    while (true)
    {
      return getEntry(i, j);
      if (paramInt == -1 + this.zame.size());
      for (j = this.mDataHolder.getCount() - ((Integer)this.zame.get(paramInt)).intValue(); ; j = ((Integer)this.zame.get(paramInt + 1)).intValue() - ((Integer)this.zame.get(paramInt)).intValue())
      {
        if (j != 1)
          break label158;
        int k = zah(paramInt);
        int m = this.mDataHolder.getWindowIndex(k);
        String str = getChildDataMarkerColumn();
        if ((str == null) || (this.mDataHolder.getString(str, k, m) != null))
          break;
        j = 0;
        break;
      }
    }
  }

  @KeepForSdk
  protected String getChildDataMarkerColumn()
  {
    return null;
  }

  @KeepForSdk
  public int getCount()
  {
    zacb();
    return this.zame.size();
  }

  @KeepForSdk
  protected abstract T getEntry(int paramInt1, int paramInt2);

  @KeepForSdk
  protected abstract String getPrimaryDataMarkerColumn();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.EntityBuffer
 * JD-Core Version:    0.6.2
 */