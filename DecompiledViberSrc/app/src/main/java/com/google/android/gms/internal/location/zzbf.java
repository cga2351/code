package com.google.android.gms.internal.location;

import android.app.PendingIntent;
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
import com.google.android.gms.location.zzu;
import com.google.android.gms.location.zzv;
import com.google.android.gms.location.zzx;
import com.google.android.gms.location.zzy;

@SafeParcelable.Class(creator="LocationRequestUpdateDataCreator")
@SafeParcelable.Reserved({1000})
public final class zzbf extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzbf> CREATOR = new zzbg();

  @SafeParcelable.Field(defaultValueUnchecked="null", id=4)
  private PendingIntent zzbv;

  @SafeParcelable.Field(defaultValueUnchecked="LocationRequestUpdateData.OPERATION_ADD", id=1)
  private int zzcg;

  @SafeParcelable.Field(defaultValueUnchecked="null", getter="getFusedLocationProviderCallbackBinder", id=6, type="android.os.IBinder")
  private zzaj zzcj;

  @SafeParcelable.Field(defaultValueUnchecked="null", id=2)
  private zzbd zzdl;

  @SafeParcelable.Field(defaultValueUnchecked="null", getter="getLocationListenerBinder", id=3, type="android.os.IBinder")
  private zzx zzdm;

  @SafeParcelable.Field(defaultValueUnchecked="null", getter="getLocationCallbackBinder", id=5, type="android.os.IBinder")
  private zzu zzdn;

  @SafeParcelable.Constructor
  zzbf(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) zzbd paramzzbd, @SafeParcelable.Param(id=3) IBinder paramIBinder1, @SafeParcelable.Param(id=4) PendingIntent paramPendingIntent, @SafeParcelable.Param(id=5) IBinder paramIBinder2, @SafeParcelable.Param(id=6) IBinder paramIBinder3)
  {
    this.zzcg = paramInt;
    this.zzdl = paramzzbd;
    zzx localzzx;
    zzu localzzu;
    label41: Object localObject;
    if (paramIBinder1 == null)
    {
      localzzx = null;
      this.zzdm = localzzx;
      this.zzbv = paramPendingIntent;
      if (paramIBinder2 != null)
        break label71;
      localzzu = null;
      this.zzdn = localzzu;
      localObject = null;
      if (paramIBinder3 != null)
        break label81;
    }
    while (true)
    {
      this.zzcj = ((zzaj)localObject);
      return;
      localzzx = zzy.zzc(paramIBinder1);
      break;
      label71: localzzu = zzv.zzb(paramIBinder2);
      break label41;
      label81: localObject = null;
      if (paramIBinder3 != null)
      {
        IInterface localIInterface = paramIBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
        if ((localIInterface instanceof zzaj))
          localObject = (zzaj)localIInterface;
        else
          localObject = new zzal(paramIBinder3);
      }
    }
  }

  public static zzbf zza(zzu paramzzu, zzaj paramzzaj)
  {
    IBinder localIBinder1 = paramzzu.asBinder();
    if (paramzzaj != null);
    for (IBinder localIBinder2 = paramzzaj.asBinder(); ; localIBinder2 = null)
      return new zzbf(2, null, null, null, localIBinder1, localIBinder2);
  }

  public static zzbf zza(zzx paramzzx, zzaj paramzzaj)
  {
    IBinder localIBinder1 = paramzzx.asBinder();
    if (paramzzaj != null);
    for (IBinder localIBinder2 = paramzzaj.asBinder(); ; localIBinder2 = null)
      return new zzbf(2, null, localIBinder1, null, null, localIBinder2);
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzcg);
    SafeParcelWriter.writeParcelable(paramParcel, 2, this.zzdl, paramInt, false);
    IBinder localIBinder1;
    IBinder localIBinder2;
    label64: IBinder localIBinder3;
    if (this.zzdm == null)
    {
      localIBinder1 = null;
      SafeParcelWriter.writeIBinder(paramParcel, 3, localIBinder1, false);
      SafeParcelWriter.writeParcelable(paramParcel, 4, this.zzbv, paramInt, false);
      if (this.zzdn != null)
        break label115;
      localIBinder2 = null;
      SafeParcelWriter.writeIBinder(paramParcel, 5, localIBinder2, false);
      zzaj localzzaj = this.zzcj;
      localIBinder3 = null;
      if (localzzaj != null)
        break label129;
    }
    while (true)
    {
      SafeParcelWriter.writeIBinder(paramParcel, 6, localIBinder3, false);
      SafeParcelWriter.finishObjectHeader(paramParcel, i);
      return;
      localIBinder1 = this.zzdm.asBinder();
      break;
      label115: localIBinder2 = this.zzdn.asBinder();
      break label64;
      label129: localIBinder3 = this.zzcj.asBinder();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.location.zzbf
 * JD-Core Version:    0.6.2
 */