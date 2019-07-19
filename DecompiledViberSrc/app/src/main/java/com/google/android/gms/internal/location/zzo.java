package com.google.android.gms.internal.location;

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
import com.google.android.gms.location.zzr;
import com.google.android.gms.location.zzs;

@SafeParcelable.Class(creator="DeviceOrientationRequestUpdateDataCreator")
public final class zzo extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzo> CREATOR = new zzp();

  @SafeParcelable.Field(defaultValueUnchecked="DeviceOrientationRequestUpdateData.OPERATION_ADD", id=1)
  private int zzcg;

  @SafeParcelable.Field(defaultValueUnchecked="null", id=2)
  private zzm zzch;

  @SafeParcelable.Field(defaultValueUnchecked="null", getter="getDeviceOrientationListenerBinder", id=3, type="android.os.IBinder")
  private zzr zzci;

  @SafeParcelable.Field(defaultValueUnchecked="null", getter="getFusedLocationProviderCallbackBinder", id=4, type="android.os.IBinder")
  private zzaj zzcj;

  @SafeParcelable.Constructor
  zzo(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) zzm paramzzm, @SafeParcelable.Param(id=3) IBinder paramIBinder1, @SafeParcelable.Param(id=4) IBinder paramIBinder2)
  {
    this.zzcg = paramInt;
    this.zzch = paramzzm;
    zzr localzzr;
    Object localObject;
    if (paramIBinder1 == null)
    {
      localzzr = null;
      this.zzci = localzzr;
      localObject = null;
      if (paramIBinder2 != null)
        break label51;
    }
    while (true)
    {
      this.zzcj = ((zzaj)localObject);
      return;
      localzzr = zzs.zza(paramIBinder1);
      break;
      label51: localObject = null;
      if (paramIBinder2 != null)
      {
        IInterface localIInterface = paramIBinder2.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
        if ((localIInterface instanceof zzaj))
          localObject = (zzaj)localIInterface;
        else
          localObject = new zzal(paramIBinder2);
      }
    }
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzcg);
    SafeParcelWriter.writeParcelable(paramParcel, 2, this.zzch, paramInt, false);
    IBinder localIBinder1;
    IBinder localIBinder2;
    if (this.zzci == null)
    {
      localIBinder1 = null;
      SafeParcelWriter.writeIBinder(paramParcel, 3, localIBinder1, false);
      zzaj localzzaj = this.zzcj;
      localIBinder2 = null;
      if (localzzaj != null)
        break label85;
    }
    while (true)
    {
      SafeParcelWriter.writeIBinder(paramParcel, 4, localIBinder2, false);
      SafeParcelWriter.finishObjectHeader(paramParcel, i);
      return;
      localIBinder1 = this.zzci.asBinder();
      break;
      label85: localIBinder2 = this.zzcj.asBinder();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.location.zzo
 * JD-Core Version:    0.6.2
 */