package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.sqlite.CursorWrapper;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@KeepForSdk
@KeepName
@SafeParcelable.Class(creator="DataHolderCreator", validate=true)
public final class DataHolder extends AbstractSafeParcelable
  implements Closeable
{

  @KeepForSdk
  public static final Parcelable.Creator<DataHolder> CREATOR = new zac();
  private static final Builder zalx = new zab(new String[0], null);
  private boolean mClosed = false;

  @SafeParcelable.VersionField(id=1000)
  private final int zale;

  @SafeParcelable.Field(getter="getColumns", id=1)
  private final String[] zalp;
  private Bundle zalq;

  @SafeParcelable.Field(getter="getWindows", id=2)
  private final CursorWindow[] zalr;

  @SafeParcelable.Field(getter="getStatusCode", id=3)
  private final int zals;

  @SafeParcelable.Field(getter="getMetadata", id=4)
  private final Bundle zalt;
  private int[] zalu;
  private int zalv;
  private boolean zalw = true;

  @SafeParcelable.Constructor
  DataHolder(@SafeParcelable.Param(id=1000) int paramInt1, @SafeParcelable.Param(id=1) String[] paramArrayOfString, @SafeParcelable.Param(id=2) CursorWindow[] paramArrayOfCursorWindow, @SafeParcelable.Param(id=3) int paramInt2, @SafeParcelable.Param(id=4) Bundle paramBundle)
  {
    this.zale = paramInt1;
    this.zalp = paramArrayOfString;
    this.zalr = paramArrayOfCursorWindow;
    this.zals = paramInt2;
    this.zalt = paramBundle;
  }

  @KeepForSdk
  public DataHolder(Cursor paramCursor, int paramInt, Bundle paramBundle)
  {
    this(new CursorWrapper(paramCursor), paramInt, paramBundle);
  }

  private DataHolder(Builder paramBuilder, int paramInt, Bundle paramBundle)
  {
    this(Builder.zaa(paramBuilder), zaa(paramBuilder, -1), paramInt, null);
  }

  private DataHolder(Builder paramBuilder, int paramInt1, Bundle paramBundle, int paramInt2)
  {
    this(Builder.zaa(paramBuilder), zaa(paramBuilder, -1), paramInt1, paramBundle);
  }

  private DataHolder(CursorWrapper paramCursorWrapper, int paramInt, Bundle paramBundle)
  {
    this(paramCursorWrapper.getColumnNames(), zaa(paramCursorWrapper), paramInt, paramBundle);
  }

  @KeepForSdk
  public DataHolder(String[] paramArrayOfString, CursorWindow[] paramArrayOfCursorWindow, int paramInt, Bundle paramBundle)
  {
    this.zale = 1;
    this.zalp = ((String[])Preconditions.checkNotNull(paramArrayOfString));
    this.zalr = ((CursorWindow[])Preconditions.checkNotNull(paramArrayOfCursorWindow));
    this.zals = paramInt;
    this.zalt = paramBundle;
    zaca();
  }

  @KeepForSdk
  public static Builder builder(String[] paramArrayOfString)
  {
    return new Builder(paramArrayOfString, null, null);
  }

  @KeepForSdk
  public static DataHolder empty(int paramInt)
  {
    return new DataHolder(zalx, paramInt, null);
  }

  private final void zaa(String paramString, int paramInt)
  {
    if ((this.zalq == null) || (!this.zalq.containsKey(paramString)))
    {
      String str1 = String.valueOf(paramString);
      if (str1.length() != 0);
      for (String str2 = "No such column: ".concat(str1); ; str2 = new String("No such column: "))
        throw new IllegalArgumentException(str2);
    }
    if (isClosed())
      throw new IllegalArgumentException("Buffer is closed.");
    if ((paramInt < 0) || (paramInt >= this.zalv))
      throw new CursorIndexOutOfBoundsException(paramInt, this.zalv);
  }

  private static CursorWindow[] zaa(Builder paramBuilder, int paramInt)
  {
    int i = 0;
    if (Builder.zaa(paramBuilder).length == 0)
      return new CursorWindow[0];
    Object localObject1;
    Object localObject2;
    ArrayList localArrayList;
    int k;
    int m;
    if ((paramInt < 0) || (paramInt >= Builder.zab(paramBuilder).size()))
    {
      localObject1 = Builder.zab(paramBuilder);
      int j = ((List)localObject1).size();
      localObject2 = new CursorWindow(false);
      localArrayList = new ArrayList();
      localArrayList.add(localObject2);
      ((CursorWindow)localObject2).setNumColumns(Builder.zaa(paramBuilder).length);
      k = 0;
      m = 0;
      label87: if (k >= j)
        break label764;
    }
    while (true)
    {
      int i1;
      try
      {
        if (!((CursorWindow)localObject2).allocRow())
        {
          Log.d("DataHolder", 72 + "Allocating additional cursor window for large data set (row " + k + ")");
          localObject2 = new CursorWindow(false);
          ((CursorWindow)localObject2).setStartPosition(k);
          ((CursorWindow)localObject2).setNumColumns(Builder.zaa(paramBuilder).length);
          localArrayList.add(localObject2);
          if (!((CursorWindow)localObject2).allocRow())
          {
            Log.e("DataHolder", "Unable to allocate row to hold data.");
            localArrayList.remove(localObject2);
            CursorWindow[] arrayOfCursorWindow = (CursorWindow[])localArrayList.toArray(new CursorWindow[localArrayList.size()]);
            return arrayOfCursorWindow;
            localObject1 = Builder.zab(paramBuilder).subList(0, paramInt);
            break;
          }
        }
        Map localMap = (Map)((List)localObject1).get(k);
        i1 = 0;
        bool = true;
        if ((i1 < Builder.zaa(paramBuilder).length) && (bool))
        {
          String str1 = Builder.zaa(paramBuilder)[i1];
          Object localObject3 = localMap.get(str1);
          if (localObject3 == null)
          {
            bool = ((CursorWindow)localObject2).putNull(k, i1);
            break label781;
          }
          if ((localObject3 instanceof String))
          {
            bool = ((CursorWindow)localObject2).putString((String)localObject3, k, i1);
            break label781;
          }
          if ((localObject3 instanceof Long))
          {
            bool = ((CursorWindow)localObject2).putLong(((Long)localObject3).longValue(), k, i1);
            break label781;
          }
          if ((localObject3 instanceof Integer))
          {
            bool = ((CursorWindow)localObject2).putLong(((Integer)localObject3).intValue(), k, i1);
            break label781;
          }
          if ((localObject3 instanceof Boolean))
          {
            if (!((Boolean)localObject3).booleanValue())
              break label787;
            l = 1L;
            bool = ((CursorWindow)localObject2).putLong(l, k, i1);
            break label781;
          }
          if ((localObject3 instanceof byte[]))
          {
            bool = ((CursorWindow)localObject2).putBlob((byte[])localObject3, k, i1);
            break label781;
          }
          if ((localObject3 instanceof Double))
          {
            bool = ((CursorWindow)localObject2).putDouble(((Double)localObject3).doubleValue(), k, i1);
            break label781;
          }
          if ((localObject3 instanceof Float))
          {
            bool = ((CursorWindow)localObject2).putDouble(((Float)localObject3).floatValue(), k, i1);
            break label781;
          }
          String str2 = String.valueOf(localObject3);
          throw new IllegalArgumentException(32 + String.valueOf(str1).length() + String.valueOf(str2).length() + "Unsupported object for column " + str1 + ": " + str2);
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        boolean bool;
        int n = localArrayList.size();
        if (i < n)
        {
          ((CursorWindow)localArrayList.get(i)).close();
          i++;
          continue;
          if (!bool)
          {
            if (m != 0)
              throw new zaa("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
            Log.d("DataHolder", 74 + "Couldn't populate window data for row " + k + " - allocating new window.");
            ((CursorWindow)localObject2).freeLastRow();
            CursorWindow localCursorWindow = new CursorWindow(false);
            localCursorWindow.setStartPosition(k);
            localCursorWindow.setNumColumns(Builder.zaa(paramBuilder).length);
            localArrayList.add(localCursorWindow);
            i2 = k - 1;
            localObject4 = localCursorWindow;
            i3 = 1;
            int i4 = i2 + 1;
            m = i3;
            localObject2 = localObject4;
            k = i4;
            break label87;
          }
          int i2 = k;
          Object localObject4 = localObject2;
          int i3 = 0;
          continue;
        }
        throw localRuntimeException;
      }
      label764: return (CursorWindow[])localArrayList.toArray(new CursorWindow[localArrayList.size()]);
      label781: i1++;
      continue;
      label787: long l = 0L;
    }
  }

  private static CursorWindow[] zaa(CursorWrapper paramCursorWrapper)
  {
    ArrayList localArrayList = new ArrayList();
    while (true)
    {
      try
      {
        int i = paramCursorWrapper.getCount();
        CursorWindow localCursorWindow1 = paramCursorWrapper.getWindow();
        if ((localCursorWindow1 == null) || (localCursorWindow1.getStartPosition() != 0))
          break label177;
        localCursorWindow1.acquireReference();
        paramCursorWrapper.setWindow(null);
        localArrayList.add(localCursorWindow1);
        j = localCursorWindow1.getNumRows();
        if ((j < i) && (paramCursorWrapper.moveToPosition(j)))
        {
          CursorWindow localCursorWindow2 = paramCursorWrapper.getWindow();
          if (localCursorWindow2 != null)
          {
            localCursorWindow2.acquireReference();
            paramCursorWrapper.setWindow(null);
            if (localCursorWindow2.getNumRows() == 0)
              break label158;
            localArrayList.add(localCursorWindow2);
            j = localCursorWindow2.getStartPosition() + localCursorWindow2.getNumRows();
            continue;
          }
          localCursorWindow2 = new CursorWindow(false);
          localCursorWindow2.setStartPosition(j);
          paramCursorWrapper.fillWindow(j, localCursorWindow2);
          continue;
        }
      }
      finally
      {
        paramCursorWrapper.close();
      }
      label158: paramCursorWrapper.close();
      return (CursorWindow[])localArrayList.toArray(new CursorWindow[localArrayList.size()]);
      label177: int j = 0;
    }
  }

  @KeepForSdk
  public final void close()
  {
    try
    {
      if (!this.mClosed)
      {
        this.mClosed = true;
        for (int i = 0; i < this.zalr.length; i++)
          this.zalr[i].close();
      }
      return;
    }
    finally
    {
    }
  }

  protected final void finalize()
    throws Throwable
  {
    try
    {
      if ((this.zalw) && (this.zalr.length > 0) && (!isClosed()))
      {
        close();
        String str = toString();
        Log.e("DataBuffer", 178 + String.valueOf(str).length() + "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: " + str + ")");
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }

  @KeepForSdk
  public final boolean getBoolean(String paramString, int paramInt1, int paramInt2)
  {
    zaa(paramString, paramInt1);
    return Long.valueOf(this.zalr[paramInt2].getLong(paramInt1, this.zalq.getInt(paramString))).longValue() == 1L;
  }

  @KeepForSdk
  public final byte[] getByteArray(String paramString, int paramInt1, int paramInt2)
  {
    zaa(paramString, paramInt1);
    return this.zalr[paramInt2].getBlob(paramInt1, this.zalq.getInt(paramString));
  }

  @KeepForSdk
  public final int getCount()
  {
    return this.zalv;
  }

  @KeepForSdk
  public final int getInteger(String paramString, int paramInt1, int paramInt2)
  {
    zaa(paramString, paramInt1);
    return this.zalr[paramInt2].getInt(paramInt1, this.zalq.getInt(paramString));
  }

  @KeepForSdk
  public final long getLong(String paramString, int paramInt1, int paramInt2)
  {
    zaa(paramString, paramInt1);
    return this.zalr[paramInt2].getLong(paramInt1, this.zalq.getInt(paramString));
  }

  @KeepForSdk
  public final Bundle getMetadata()
  {
    return this.zalt;
  }

  @KeepForSdk
  public final int getStatusCode()
  {
    return this.zals;
  }

  @KeepForSdk
  public final String getString(String paramString, int paramInt1, int paramInt2)
  {
    zaa(paramString, paramInt1);
    return this.zalr[paramInt2].getString(paramInt1, this.zalq.getInt(paramString));
  }

  @KeepForSdk
  public final int getWindowIndex(int paramInt)
  {
    int i = 0;
    boolean bool;
    if ((paramInt >= 0) && (paramInt < this.zalv))
    {
      bool = true;
      Preconditions.checkState(bool);
    }
    while (true)
    {
      if (i < this.zalu.length)
      {
        if (paramInt < this.zalu[i])
          i--;
      }
      else
      {
        if (i == this.zalu.length)
          i--;
        return i;
        bool = false;
        break;
      }
      i++;
    }
  }

  @KeepForSdk
  public final boolean hasColumn(String paramString)
  {
    return this.zalq.containsKey(paramString);
  }

  @KeepForSdk
  public final boolean hasNull(String paramString, int paramInt1, int paramInt2)
  {
    zaa(paramString, paramInt1);
    return this.zalr[paramInt2].isNull(paramInt1, this.zalq.getInt(paramString));
  }

  @KeepForSdk
  public final boolean isClosed()
  {
    try
    {
      boolean bool = this.mClosed;
      return bool;
    }
    finally
    {
    }
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeStringArray(paramParcel, 1, this.zalp, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 2, this.zalr, paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 3, getStatusCode());
    SafeParcelWriter.writeBundle(paramParcel, 4, getMetadata(), false);
    SafeParcelWriter.writeInt(paramParcel, 1000, this.zale);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    if ((paramInt & 0x1) != 0)
      close();
  }

  public final float zaa(String paramString, int paramInt1, int paramInt2)
  {
    zaa(paramString, paramInt1);
    return this.zalr[paramInt2].getFloat(paramInt1, this.zalq.getInt(paramString));
  }

  public final void zaa(String paramString, int paramInt1, int paramInt2, CharArrayBuffer paramCharArrayBuffer)
  {
    zaa(paramString, paramInt1);
    this.zalr[paramInt2].copyStringToBuffer(paramInt1, this.zalq.getInt(paramString), paramCharArrayBuffer);
  }

  public final double zab(String paramString, int paramInt1, int paramInt2)
  {
    zaa(paramString, paramInt1);
    return this.zalr[paramInt2].getDouble(paramInt1, this.zalq.getInt(paramString));
  }

  public final void zaca()
  {
    int i = 0;
    this.zalq = new Bundle();
    for (int j = 0; j < this.zalp.length; j++)
      this.zalq.putInt(this.zalp[j], j);
    this.zalu = new int[this.zalr.length];
    int k = 0;
    while (i < this.zalr.length)
    {
      this.zalu[i] = k;
      int m = k - this.zalr[i].getStartPosition();
      k += this.zalr[i].getNumRows() - m;
      i++;
    }
    this.zalv = k;
  }

  @KeepForSdk
  public static class Builder
  {
    private final String[] zalp;
    private final ArrayList<HashMap<String, Object>> zaly;
    private final String zalz;
    private final HashMap<Object, Integer> zama;
    private boolean zamb;
    private String zamc;

    private Builder(String[] paramArrayOfString, String paramString)
    {
      this.zalp = ((String[])Preconditions.checkNotNull(paramArrayOfString));
      this.zaly = new ArrayList();
      this.zalz = paramString;
      this.zama = new HashMap();
      this.zamb = false;
      this.zamc = null;
    }

    @KeepForSdk
    public DataHolder build(int paramInt)
    {
      return new DataHolder(this, paramInt, null, null);
    }

    @KeepForSdk
    public DataHolder build(int paramInt, Bundle paramBundle)
    {
      return new DataHolder(this, paramInt, paramBundle, -1, null);
    }

    @KeepForSdk
    public Builder withRow(ContentValues paramContentValues)
    {
      Asserts.checkNotNull(paramContentValues);
      HashMap localHashMap = new HashMap(paramContentValues.size());
      Iterator localIterator = paramContentValues.valueSet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localHashMap.put((String)localEntry.getKey(), localEntry.getValue());
      }
      return zaa(localHashMap);
    }

    public Builder zaa(HashMap<String, Object> paramHashMap)
    {
      Asserts.checkNotNull(paramHashMap);
      int i;
      if (this.zalz == null)
      {
        i = -1;
        if (i != -1)
          break label105;
        this.zaly.add(paramHashMap);
      }
      while (true)
      {
        this.zamb = false;
        return this;
        Object localObject = paramHashMap.get(this.zalz);
        if (localObject == null)
        {
          i = -1;
          break;
        }
        Integer localInteger = (Integer)this.zama.get(localObject);
        if (localInteger == null)
        {
          this.zama.put(localObject, Integer.valueOf(this.zaly.size()));
          i = -1;
          break;
        }
        i = localInteger.intValue();
        break;
        label105: this.zaly.remove(i);
        this.zaly.add(i, paramHashMap);
      }
    }
  }

  public static final class zaa extends RuntimeException
  {
    public zaa(String paramString)
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.DataHolder
 * JD-Core Version:    0.6.2
 */