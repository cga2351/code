package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.Iterator;

@SafeParcelable.Class(creator="EventParamsCreator")
@SafeParcelable.Reserved({1})
public final class zzad extends AbstractSafeParcelable
  implements Iterable<String>
{
  public static final Parcelable.Creator<zzad> CREATOR = new zzaf();

  @SafeParcelable.Field(getter="z", id=2)
  private final Bundle zzaid;

  @SafeParcelable.Constructor
  zzad(@SafeParcelable.Param(id=2) Bundle paramBundle)
  {
    this.zzaid = paramBundle;
  }

  final Object get(String paramString)
  {
    return this.zzaid.get(paramString);
  }

  final Long getLong(String paramString)
  {
    return Long.valueOf(this.zzaid.getLong(paramString));
  }

  final String getString(String paramString)
  {
    return this.zzaid.getString(paramString);
  }

  public final Iterator<String> iterator()
  {
    return new zzae(this);
  }

  public final int size()
  {
    return this.zzaid.size();
  }

  public final String toString()
  {
    return this.zzaid.toString();
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBundle(paramParcel, 2, zziy(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }

  final Double zzbr(String paramString)
  {
    return Double.valueOf(this.zzaid.getDouble(paramString));
  }

  public final Bundle zziy()
  {
    return new Bundle(this.zzaid);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzad
 * JD-Core Version:    0.6.2
 */