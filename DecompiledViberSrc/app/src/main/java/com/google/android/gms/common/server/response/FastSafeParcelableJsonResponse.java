package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

@KeepForSdk
@ShowFirstParty
public abstract class FastSafeParcelableJsonResponse extends FastJsonResponse
  implements SafeParcelable
{
  public final int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!getClass().isInstance(paramObject))
      return false;
    FastJsonResponse localFastJsonResponse = (FastJsonResponse)paramObject;
    Iterator localIterator = getFieldMappings().values().iterator();
    while (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (isFieldSet(localField))
      {
        if (localFastJsonResponse.isFieldSet(localField))
        {
          if (!getFieldValue(localField).equals(localFastJsonResponse.getFieldValue(localField)))
            return false;
        }
        else
          return false;
      }
      else if (localFastJsonResponse.isFieldSet(localField))
        return false;
    }
    return true;
  }

  @VisibleForTesting
  public Object getValueObject(String paramString)
  {
    return null;
  }

  public int hashCode()
  {
    Iterator localIterator = getFieldMappings().values().iterator();
    int i = 0;
    FastJsonResponse.Field localField;
    if (localIterator.hasNext())
    {
      localField = (FastJsonResponse.Field)localIterator.next();
      if (!isFieldSet(localField))
        break label67;
    }
    label67: for (int j = i * 31 + getFieldValue(localField).hashCode(); ; j = i)
    {
      i = j;
      break;
      return i;
    }
  }

  @VisibleForTesting
  public boolean isPrimitiveFieldSet(String paramString)
  {
    return false;
  }

  @KeepForSdk
  public byte[] toByteArray()
  {
    Parcel localParcel = Parcel.obtain();
    writeToParcel(localParcel, 0);
    byte[] arrayOfByte = localParcel.marshall();
    localParcel.recycle();
    return arrayOfByte;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
 * JD-Core Version:    0.6.2
 */