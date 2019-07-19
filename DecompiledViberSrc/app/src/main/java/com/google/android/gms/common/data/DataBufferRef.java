package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public class DataBufferRef
{

  @KeepForSdk
  protected final DataHolder mDataHolder;

  @KeepForSdk
  protected int mDataRow;
  private int zalm;

  @KeepForSdk
  public DataBufferRef(DataHolder paramDataHolder, int paramInt)
  {
    this.mDataHolder = ((DataHolder)Preconditions.checkNotNull(paramDataHolder));
    zag(paramInt);
  }

  @KeepForSdk
  protected void copyToBuffer(String paramString, CharArrayBuffer paramCharArrayBuffer)
  {
    this.mDataHolder.zaa(paramString, this.mDataRow, this.zalm, paramCharArrayBuffer);
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof DataBufferRef;
    boolean bool2 = false;
    if (bool1)
    {
      DataBufferRef localDataBufferRef = (DataBufferRef)paramObject;
      boolean bool3 = Objects.equal(Integer.valueOf(localDataBufferRef.mDataRow), Integer.valueOf(this.mDataRow));
      bool2 = false;
      if (bool3)
      {
        boolean bool4 = Objects.equal(Integer.valueOf(localDataBufferRef.zalm), Integer.valueOf(this.zalm));
        bool2 = false;
        if (bool4)
        {
          DataHolder localDataHolder1 = localDataBufferRef.mDataHolder;
          DataHolder localDataHolder2 = this.mDataHolder;
          bool2 = false;
          if (localDataHolder1 == localDataHolder2)
            bool2 = true;
        }
      }
    }
    return bool2;
  }

  @KeepForSdk
  protected boolean getBoolean(String paramString)
  {
    return this.mDataHolder.getBoolean(paramString, this.mDataRow, this.zalm);
  }

  @KeepForSdk
  protected byte[] getByteArray(String paramString)
  {
    return this.mDataHolder.getByteArray(paramString, this.mDataRow, this.zalm);
  }

  @KeepForSdk
  protected int getDataRow()
  {
    return this.mDataRow;
  }

  @KeepForSdk
  protected double getDouble(String paramString)
  {
    return this.mDataHolder.zab(paramString, this.mDataRow, this.zalm);
  }

  @KeepForSdk
  protected float getFloat(String paramString)
  {
    return this.mDataHolder.zaa(paramString, this.mDataRow, this.zalm);
  }

  @KeepForSdk
  protected int getInteger(String paramString)
  {
    return this.mDataHolder.getInteger(paramString, this.mDataRow, this.zalm);
  }

  @KeepForSdk
  protected long getLong(String paramString)
  {
    return this.mDataHolder.getLong(paramString, this.mDataRow, this.zalm);
  }

  @KeepForSdk
  protected String getString(String paramString)
  {
    return this.mDataHolder.getString(paramString, this.mDataRow, this.zalm);
  }

  @KeepForSdk
  public boolean hasColumn(String paramString)
  {
    return this.mDataHolder.hasColumn(paramString);
  }

  @KeepForSdk
  protected boolean hasNull(String paramString)
  {
    return this.mDataHolder.hasNull(paramString, this.mDataRow, this.zalm);
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(this.mDataRow);
    arrayOfObject[1] = Integer.valueOf(this.zalm);
    arrayOfObject[2] = this.mDataHolder;
    return Objects.hashCode(arrayOfObject);
  }

  @KeepForSdk
  public boolean isDataValid()
  {
    return !this.mDataHolder.isClosed();
  }

  @KeepForSdk
  protected Uri parseUri(String paramString)
  {
    String str = this.mDataHolder.getString(paramString, this.mDataRow, this.zalm);
    if (str == null)
      return null;
    return Uri.parse(str);
  }

  protected final void zag(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.mDataHolder.getCount()));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool);
      this.mDataRow = paramInt;
      this.zalm = this.mDataHolder.getWindowIndex(this.mDataRow);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.DataBufferRef
 * JD-Core Version:    0.6.2
 */