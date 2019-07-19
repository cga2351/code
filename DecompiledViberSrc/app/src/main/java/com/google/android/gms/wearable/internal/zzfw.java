package com.google.android.gms.wearable.internal;

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
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@SafeParcelable.Class(creator="RemoveListenerRequestCreator")
public final class zzfw extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzfw> CREATOR = new zzfx();

  @SafeParcelable.VersionField(id=1)
  private final int versionCode;

  @SafeParcelable.Field(getter="getListenerAsBinder", id=2, type="android.os.IBinder")
  private final zzem zzaz;

  @SafeParcelable.Constructor
  zzfw(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) IBinder paramIBinder)
  {
    this.versionCode = paramInt;
    if (paramIBinder != null)
    {
      Object localObject = null;
      if (paramIBinder == null);
      while (true)
      {
        this.zzaz = ((zzem)localObject);
        return;
        IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
        if ((localIInterface instanceof zzem))
          localObject = (zzem)localIInterface;
        else
          localObject = new zzeo(paramIBinder);
      }
    }
    this.zzaz = null;
  }

  public zzfw(zzem paramzzem)
  {
    this.versionCode = 1;
    this.zzaz = paramzzem;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    if (this.zzaz == null);
    for (IBinder localIBinder = null; ; localIBinder = this.zzaz.asBinder())
    {
      SafeParcelWriter.writeIBinder(paramParcel, 2, localIBinder, false);
      SafeParcelWriter.finishObjectHeader(paramParcel, i);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzfw
 * JD-Core Version:    0.6.2
 */