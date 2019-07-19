package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator="AddListenerRequestCreator")
@SafeParcelable.Reserved({1})
public final class zzd extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzd> CREATOR = new zze();

  @SafeParcelable.Field(getter="getListenerAsBinder", id=2, type="android.os.IBinder")
  private final zzem zzaz;

  @SafeParcelable.Field(id=3)
  private final IntentFilter[] zzba;

  @Nullable
  @SafeParcelable.Field(id=4)
  private final String zzbb;

  @Nullable
  @SafeParcelable.Field(id=5)
  private final String zzbc;

  @SafeParcelable.Constructor
  zzd(@SafeParcelable.Param(id=2) IBinder paramIBinder, @SafeParcelable.Param(id=3) IntentFilter[] paramArrayOfIntentFilter, @SafeParcelable.Param(id=4) @Nullable String paramString1, @SafeParcelable.Param(id=5) @Nullable String paramString2)
  {
    Object localObject;
    if (paramIBinder != null)
    {
      localObject = null;
      if (paramIBinder != null);
    }
    for (this.zzaz = ((zzem)localObject); ; this.zzaz = null)
    {
      this.zzba = paramArrayOfIntentFilter;
      this.zzbb = paramString1;
      this.zzbc = paramString2;
      return;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
      if ((localIInterface instanceof zzem))
      {
        localObject = (zzem)localIInterface;
        break;
      }
      localObject = new zzeo(paramIBinder);
      break;
    }
  }

  public zzd(zzhk paramzzhk)
  {
    this.zzaz = paramzzhk;
    this.zzba = paramzzhk.zze();
    this.zzbb = paramzzhk.zzf();
    this.zzbc = null;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    if (this.zzaz == null);
    for (IBinder localIBinder = null; ; localIBinder = this.zzaz.asBinder())
    {
      SafeParcelWriter.writeIBinder(paramParcel, 2, localIBinder, false);
      SafeParcelWriter.writeTypedArray(paramParcel, 3, this.zzba, paramInt, false);
      SafeParcelWriter.writeString(paramParcel, 4, this.zzbb, false);
      SafeParcelWriter.writeString(paramParcel, 5, this.zzbc, false);
      SafeParcelWriter.finishObjectHeader(paramParcel, i);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzd
 * JD-Core Version:    0.6.2
 */