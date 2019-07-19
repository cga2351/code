package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.wearable.MessageEvent;

@SafeParcelable.Class(creator="MessageEventParcelableCreator")
@SafeParcelable.Reserved({1})
public final class zzfe extends AbstractSafeParcelable
  implements MessageEvent
{
  public static final Parcelable.Creator<zzfe> CREATOR = new zzff();

  @SafeParcelable.Field(getter="getData", id=4)
  private final byte[] data;

  @SafeParcelable.Field(getter="getPath", id=3)
  private final String zzcl;

  @SafeParcelable.Field(getter="getRequestId", id=2)
  private final int zzeh;

  @SafeParcelable.Field(getter="getSourceNodeId", id=5)
  private final String zzek;

  @SafeParcelable.Constructor
  public zzfe(@SafeParcelable.Param(id=2) int paramInt, @SafeParcelable.Param(id=3) String paramString1, @SafeParcelable.Param(id=4) byte[] paramArrayOfByte, @SafeParcelable.Param(id=5) String paramString2)
  {
    this.zzeh = paramInt;
    this.zzcl = paramString1;
    this.data = paramArrayOfByte;
    this.zzek = paramString2;
  }

  public final byte[] getData()
  {
    return this.data;
  }

  public final String getPath()
  {
    return this.zzcl;
  }

  public final int getRequestId()
  {
    return this.zzeh;
  }

  public final String getSourceNodeId()
  {
    return this.zzek;
  }

  public final String toString()
  {
    int i = this.zzeh;
    String str1 = this.zzcl;
    if (this.data == null);
    for (Object localObject = "null"; ; localObject = Integer.valueOf(this.data.length))
    {
      String str2 = String.valueOf(localObject);
      return 43 + String.valueOf(str1).length() + String.valueOf(str2).length() + "MessageEventParcelable[" + i + "," + str1 + ", size=" + str2 + "]";
    }
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, getRequestId());
    SafeParcelWriter.writeString(paramParcel, 3, getPath(), false);
    SafeParcelWriter.writeByteArray(paramParcel, 4, getData(), false);
    SafeParcelWriter.writeString(paramParcel, 5, getSourceNodeId(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzfe
 * JD-Core Version:    0.6.2
 */