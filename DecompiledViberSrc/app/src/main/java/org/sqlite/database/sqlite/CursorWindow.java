package org.sqlite.database.sqlite;

import android.database.CharArrayBuffer;
import android.database.sqlite.SQLiteClosable;
import android.os.Binder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Process;
import android.support.v4.util.LongSparseArray;
import android.util.SparseIntArray;

public class CursorWindow extends SQLiteClosable
  implements Parcelable
{
  public static final Parcelable.Creator<CursorWindow> CREATOR = new Parcelable.Creator()
  {
    public CursorWindow createFromParcel(Parcel paramAnonymousParcel)
    {
      return new CursorWindow(paramAnonymousParcel, null);
    }

    public CursorWindow[] newArray(int paramAnonymousInt)
    {
      return new CursorWindow[paramAnonymousInt];
    }
  };
  private static final int CURSOR_WINDOW_SIZE = 524288;
  private static final String NAME = "org.CW";
  private static final LongSparseArray<Integer> sWindowToPidMap = new LongSparseArray();
  private final CloseGuard mCloseGuard = CloseGuard.get();
  private int mStartPos;
  public long mWindowPtr;

  public CursorWindow()
  {
    this.mStartPos = 0;
    this.mWindowPtr = nativeCreate("org.CW", 524288);
    if (this.mWindowPtr == 0L)
      throw new RuntimeException("Cursor window allocation of 512 kb failed. " + printStats());
    this.mCloseGuard.open("close");
    recordNewWindow(Binder.getCallingPid(), this.mWindowPtr);
  }

  public CursorWindow(int paramInt)
  {
    this.mStartPos = 0;
    this.mWindowPtr = nativeCreate("org.CW", paramInt);
    if (this.mWindowPtr == 0L)
      throw new RuntimeException("Cursor window allocation of " + paramInt / 1024 + " kb failed. " + printStats());
    this.mCloseGuard.open("close");
    recordNewWindow(Binder.getCallingPid(), this.mWindowPtr);
  }

  private CursorWindow(Parcel paramParcel)
  {
    this.mStartPos = paramParcel.readInt();
    this.mWindowPtr = nativeCreateFromParcel(paramParcel);
    if (this.mWindowPtr == 0L)
      throw new RuntimeException("Cursor window could not be created from binder.");
    this.mCloseGuard.open("close");
  }

  private void dispose()
  {
    if (this.mCloseGuard != null)
      this.mCloseGuard.close();
    if (this.mWindowPtr != 0L)
    {
      recordClosingOfWindow(this.mWindowPtr);
      nativeDispose(this.mWindowPtr);
      this.mWindowPtr = 0L;
    }
  }

  private static native boolean nativeAllocRow(long paramLong);

  private static native void nativeClear(long paramLong);

  private static native void nativeCopyStringToBuffer(long paramLong, int paramInt1, int paramInt2, CharArrayBuffer paramCharArrayBuffer);

  private static native long nativeCreate(String paramString, int paramInt);

  private static native long nativeCreateFromParcel(Parcel paramParcel);

  private static native void nativeDispose(long paramLong);

  private static native void nativeFreeLastRow(long paramLong);

  private static native byte[] nativeGetBlob(long paramLong, int paramInt1, int paramInt2);

  private static native double nativeGetDouble(long paramLong, int paramInt1, int paramInt2);

  private static native long nativeGetLong(long paramLong, int paramInt1, int paramInt2);

  private static native String nativeGetName(long paramLong);

  private static native int nativeGetNumRows(long paramLong);

  private static native String nativeGetString(long paramLong, int paramInt1, int paramInt2);

  private static native int nativeGetType(long paramLong, int paramInt1, int paramInt2);

  private static native boolean nativePutBlob(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2);

  private static native boolean nativePutDouble(long paramLong, double paramDouble, int paramInt1, int paramInt2);

  private static native boolean nativePutLong(long paramLong1, long paramLong2, int paramInt1, int paramInt2);

  private static native boolean nativePutNull(long paramLong, int paramInt1, int paramInt2);

  private static native boolean nativePutString(long paramLong, String paramString, int paramInt1, int paramInt2);

  private static native boolean nativeSetNumColumns(long paramLong, int paramInt);

  private static native void nativeWriteToParcel(long paramLong, Parcel paramParcel);

  public static CursorWindow newFromParcel(Parcel paramParcel)
  {
    return (CursorWindow)CREATOR.createFromParcel(paramParcel);
  }

  private String printStats()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = Process.myPid();
    SparseIntArray localSparseIntArray = new SparseIntArray();
    while (true)
    {
      int i2;
      int i3;
      synchronized (sWindowToPidMap)
      {
        int j = sWindowToPidMap.size();
        if (j != 0)
          break label256;
        return "";
        if (k < j)
        {
          int m = ((Integer)sWindowToPidMap.valueAt(k)).intValue();
          localSparseIntArray.put(m, 1 + localSparseIntArray.get(m));
          k++;
          continue;
        }
        int n = localSparseIntArray.size();
        int i1 = 0;
        i2 = 0;
        if (i1 >= n)
          break label201;
        localStringBuilder.append(" (# cursors opened by ");
        i3 = localSparseIntArray.keyAt(i1);
        if (i3 == i)
        {
          localStringBuilder.append("this proc=");
          int i4 = localSparseIntArray.get(i3);
          localStringBuilder.append(i4).append(')');
          i2 += i4;
          i1++;
        }
      }
      localStringBuilder.append("pid ").append(i3).append("=");
      continue;
      label201: if (localStringBuilder.length() > 980);
      for (String str = localStringBuilder.substring(0, 980); ; str = localStringBuilder.toString())
        return "# Open Cursors=" + i2 + str;
      label256: int k = 0;
    }
  }

  private void recordClosingOfWindow(long paramLong)
  {
    synchronized (sWindowToPidMap)
    {
      if (sWindowToPidMap.size() == 0)
        return;
      sWindowToPidMap.delete(paramLong);
      return;
    }
  }

  private void recordNewWindow(int paramInt, long paramLong)
  {
    synchronized (sWindowToPidMap)
    {
      sWindowToPidMap.put(paramLong, Integer.valueOf(paramInt));
      return;
    }
  }

  public boolean allocRow()
  {
    acquireReference();
    try
    {
      boolean bool = nativeAllocRow(this.mWindowPtr);
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }

  public void clear()
  {
    acquireReference();
    try
    {
      this.mStartPos = 0;
      nativeClear(this.mWindowPtr);
      return;
    }
    finally
    {
      releaseReference();
    }
  }

  public void copyStringToBuffer(int paramInt1, int paramInt2, CharArrayBuffer paramCharArrayBuffer)
  {
    if (paramCharArrayBuffer == null)
      throw new IllegalArgumentException("CharArrayBuffer should not be null");
    acquireReference();
    try
    {
      nativeCopyStringToBuffer(this.mWindowPtr, paramInt1 - this.mStartPos, paramInt2, paramCharArrayBuffer);
      return;
    }
    finally
    {
      releaseReference();
    }
  }

  public int describeContents()
  {
    return 0;
  }

  protected void finalize()
    throws Throwable
  {
    try
    {
      if (this.mCloseGuard != null)
        this.mCloseGuard.warnIfOpen();
      dispose();
      return;
    }
    finally
    {
      super.finalize();
    }
  }

  public void freeLastRow()
  {
    acquireReference();
    try
    {
      nativeFreeLastRow(this.mWindowPtr);
      return;
    }
    finally
    {
      releaseReference();
    }
  }

  public byte[] getBlob(int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      byte[] arrayOfByte = nativeGetBlob(this.mWindowPtr, paramInt1 - this.mStartPos, paramInt2);
      return arrayOfByte;
    }
    finally
    {
      releaseReference();
    }
  }

  public double getDouble(int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      double d = nativeGetDouble(this.mWindowPtr, paramInt1 - this.mStartPos, paramInt2);
      return d;
    }
    finally
    {
      releaseReference();
    }
  }

  public float getFloat(int paramInt1, int paramInt2)
  {
    return (float)getDouble(paramInt1, paramInt2);
  }

  public int getInt(int paramInt1, int paramInt2)
  {
    return (int)getLong(paramInt1, paramInt2);
  }

  public long getLong(int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      long l = nativeGetLong(this.mWindowPtr, paramInt1 - this.mStartPos, paramInt2);
      return l;
    }
    finally
    {
      releaseReference();
    }
  }

  public int getNumRows()
  {
    acquireReference();
    try
    {
      int i = nativeGetNumRows(this.mWindowPtr);
      return i;
    }
    finally
    {
      releaseReference();
    }
  }

  public short getShort(int paramInt1, int paramInt2)
  {
    return (short)(int)getLong(paramInt1, paramInt2);
  }

  public int getStartPosition()
  {
    return this.mStartPos;
  }

  public String getString(int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      String str = nativeGetString(this.mWindowPtr, paramInt1 - this.mStartPos, paramInt2);
      return str;
    }
    finally
    {
      releaseReference();
    }
  }

  public int getType(int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      int i = nativeGetType(this.mWindowPtr, paramInt1 - this.mStartPos, paramInt2);
      return i;
    }
    finally
    {
      releaseReference();
    }
  }

  @Deprecated
  public boolean isBlob(int paramInt1, int paramInt2)
  {
    int i = getType(paramInt1, paramInt2);
    return (i == 4) || (i == 0);
  }

  @Deprecated
  public boolean isFloat(int paramInt1, int paramInt2)
  {
    return getType(paramInt1, paramInt2) == 2;
  }

  @Deprecated
  public boolean isLong(int paramInt1, int paramInt2)
  {
    return getType(paramInt1, paramInt2) == 1;
  }

  @Deprecated
  public boolean isNull(int paramInt1, int paramInt2)
  {
    return getType(paramInt1, paramInt2) == 0;
  }

  @Deprecated
  public boolean isString(int paramInt1, int paramInt2)
  {
    int i = getType(paramInt1, paramInt2);
    return (i == 3) || (i == 0);
  }

  protected void onAllReferencesReleased()
  {
    dispose();
  }

  public boolean putBlob(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      boolean bool = nativePutBlob(this.mWindowPtr, paramArrayOfByte, paramInt1 - this.mStartPos, paramInt2);
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }

  public boolean putDouble(double paramDouble, int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      boolean bool = nativePutDouble(this.mWindowPtr, paramDouble, paramInt1 - this.mStartPos, paramInt2);
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }

  public boolean putLong(long paramLong, int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      boolean bool = nativePutLong(this.mWindowPtr, paramLong, paramInt1 - this.mStartPos, paramInt2);
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }

  public boolean putNull(int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      boolean bool = nativePutNull(this.mWindowPtr, paramInt1 - this.mStartPos, paramInt2);
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }

  public boolean putString(String paramString, int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      boolean bool = nativePutString(this.mWindowPtr, paramString, paramInt1 - this.mStartPos, paramInt2);
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }

  public boolean setNumColumns(int paramInt)
  {
    acquireReference();
    try
    {
      boolean bool = nativeSetNumColumns(this.mWindowPtr, paramInt);
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }

  public void setStartPosition(int paramInt)
  {
    this.mStartPos = paramInt;
  }

  public String toString()
  {
    return "org.CW {" + Long.toHexString(this.mWindowPtr) + "}";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    acquireReference();
    try
    {
      paramParcel.writeInt(this.mStartPos);
      nativeWriteToParcel(this.mWindowPtr, paramParcel);
      releaseReference();
      if ((paramInt & 0x1) != 0);
      return;
    }
    finally
    {
      releaseReference();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.sqlite.database.sqlite.CursorWindow
 * JD-Core Version:    0.6.2
 */