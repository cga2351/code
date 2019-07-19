package com.google.android.gms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;

@KeepForSdk
@VisibleForTesting
public final class SafeParcelableSerializer
{
  @KeepForSdk
  public static <T extends SafeParcelable> T deserializeFromBytes(byte[] paramArrayOfByte, Parcelable.Creator<T> paramCreator)
  {
    Preconditions.checkNotNull(paramCreator);
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    SafeParcelable localSafeParcelable = (SafeParcelable)paramCreator.createFromParcel(localParcel);
    localParcel.recycle();
    return localSafeParcelable;
  }

  @KeepForSdk
  public static <T extends SafeParcelable> T deserializeFromIntentExtra(Intent paramIntent, String paramString, Parcelable.Creator<T> paramCreator)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra(paramString);
    if (arrayOfByte == null)
      return null;
    return deserializeFromBytes(arrayOfByte, paramCreator);
  }

  public static <T extends SafeParcelable> T deserializeFromString(String paramString, Parcelable.Creator<T> paramCreator)
  {
    return deserializeFromBytes(Base64Utils.decodeUrlSafe(paramString), paramCreator);
  }

  public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromBundle(Bundle paramBundle, String paramString, Parcelable.Creator<T> paramCreator)
  {
    ArrayList localArrayList1 = (ArrayList)paramBundle.getSerializable(paramString);
    if (localArrayList1 == null)
      return null;
    ArrayList localArrayList2 = new ArrayList(localArrayList1.size());
    ArrayList localArrayList3 = (ArrayList)localArrayList1;
    int i = localArrayList3.size();
    int j = 0;
    while (j < i)
    {
      Object localObject = localArrayList3.get(j);
      j++;
      localArrayList2.add(deserializeFromBytes((byte[])localObject, paramCreator));
    }
    return localArrayList2;
  }

  @KeepForSdk
  public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromIntentExtra(Intent paramIntent, String paramString, Parcelable.Creator<T> paramCreator)
  {
    ArrayList localArrayList1 = (ArrayList)paramIntent.getSerializableExtra(paramString);
    if (localArrayList1 == null)
      return null;
    ArrayList localArrayList2 = new ArrayList(localArrayList1.size());
    ArrayList localArrayList3 = (ArrayList)localArrayList1;
    int i = localArrayList3.size();
    int j = 0;
    while (j < i)
    {
      Object localObject = localArrayList3.get(j);
      j++;
      localArrayList2.add(deserializeFromBytes((byte[])localObject, paramCreator));
    }
    return localArrayList2;
  }

  public static <T extends SafeParcelable> void serializeIterableToBundle(Iterable<T> paramIterable, Bundle paramBundle, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
      localArrayList.add(serializeToBytes((SafeParcelable)localIterator.next()));
    paramBundle.putSerializable(paramString, localArrayList);
  }

  @KeepForSdk
  public static <T extends SafeParcelable> void serializeIterableToIntentExtra(Iterable<T> paramIterable, Intent paramIntent, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
      localArrayList.add(serializeToBytes((SafeParcelable)localIterator.next()));
    paramIntent.putExtra(paramString, localArrayList);
  }

  @KeepForSdk
  public static <T extends SafeParcelable> byte[] serializeToBytes(T paramT)
  {
    Parcel localParcel = Parcel.obtain();
    paramT.writeToParcel(localParcel, 0);
    byte[] arrayOfByte = localParcel.marshall();
    localParcel.recycle();
    return arrayOfByte;
  }

  @KeepForSdk
  public static <T extends SafeParcelable> void serializeToIntentExtra(T paramT, Intent paramIntent, String paramString)
  {
    paramIntent.putExtra(paramString, serializeToBytes(paramT));
  }

  public static <T extends SafeParcelable> String serializeToString(T paramT)
  {
    return Base64Utils.encodeUrlSafe(serializeToBytes(paramT));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer
 * JD-Core Version:    0.6.2
 */