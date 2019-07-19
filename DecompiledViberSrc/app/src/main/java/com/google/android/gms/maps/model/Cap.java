package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.dynamic.IObjectWrapper;

@SafeParcelable.Class(creator="CapCreator")
@SafeParcelable.Reserved({1})
public class Cap extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<Cap> CREATOR = new zzb();
  private static final String TAG = Cap.class.getSimpleName();

  @SafeParcelable.Field(getter="getWrappedBitmapDescriptorImplBinder", id=3, type="android.os.IBinder")
  private final BitmapDescriptor bitmapDescriptor;

  @SafeParcelable.Field(getter="getType", id=2)
  private final int type;

  @SafeParcelable.Field(getter="getBitmapRefWidth", id=4)
  private final Float zzcn;

  protected Cap(int paramInt)
  {
    this(paramInt, null, null);
  }

  @SafeParcelable.Constructor
  Cap(@SafeParcelable.Param(id=2) int paramInt, @SafeParcelable.Param(id=3) IBinder paramIBinder, @SafeParcelable.Param(id=4) Float paramFloat)
  {
  }

  private Cap(int paramInt, BitmapDescriptor paramBitmapDescriptor, Float paramFloat)
  {
    int i;
    if ((paramFloat != null) && (paramFloat.floatValue() > 0.0F))
    {
      i = 1;
      if ((paramInt == 3) && ((paramBitmapDescriptor == null) || (i == 0)))
        break label95;
    }
    label95: for (boolean bool = true; ; bool = false)
    {
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      arrayOfObject[1] = paramBitmapDescriptor;
      arrayOfObject[2] = paramFloat;
      Preconditions.checkArgument(bool, String.format("Invalid Cap: type=%s bitmapDescriptor=%s bitmapRefWidth=%s", arrayOfObject));
      this.type = paramInt;
      this.bitmapDescriptor = paramBitmapDescriptor;
      this.zzcn = paramFloat;
      return;
      i = 0;
      break;
    }
  }

  protected Cap(BitmapDescriptor paramBitmapDescriptor, float paramFloat)
  {
    this(3, paramBitmapDescriptor, Float.valueOf(paramFloat));
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Cap localCap;
    do
    {
      return true;
      if (!(paramObject instanceof Cap))
        return false;
      localCap = (Cap)paramObject;
    }
    while ((this.type == localCap.type) && (Objects.equal(this.bitmapDescriptor, localCap.bitmapDescriptor)) && (Objects.equal(this.zzcn, localCap.zzcn)));
    return false;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(this.type);
    arrayOfObject[1] = this.bitmapDescriptor;
    arrayOfObject[2] = this.zzcn;
    return Objects.hashCode(arrayOfObject);
  }

  public String toString()
  {
    int i = this.type;
    return 23 + "[Cap: type=" + i + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.type);
    if (this.bitmapDescriptor == null);
    for (IBinder localIBinder = null; ; localIBinder = this.bitmapDescriptor.zzb().asBinder())
    {
      SafeParcelWriter.writeIBinder(paramParcel, 3, localIBinder, false);
      SafeParcelWriter.writeFloatObject(paramParcel, 4, this.zzcn, false);
      SafeParcelWriter.finishObjectHeader(paramParcel, i);
      return;
    }
  }

  final Cap zzh()
  {
    switch (this.type)
    {
    default:
      String str = TAG;
      int i = this.type;
      Log.w(str, 29 + "Unknown Cap type: " + i);
      return this;
    case 0:
      return new ButtCap();
    case 1:
      return new SquareCap();
    case 2:
      return new RoundCap();
    case 3:
    }
    return new CustomCap(this.bitmapDescriptor, this.zzcn.floatValue());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.Cap
 * JD-Core Version:    0.6.2
 */