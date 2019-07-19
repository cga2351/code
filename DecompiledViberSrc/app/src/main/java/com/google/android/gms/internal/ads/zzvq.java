package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.io.InputStream;
import javax.annotation.concurrent.GuardedBy;

@zzare
@SafeParcelable.Class(creator="CacheEntryParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzvq extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzvq> CREATOR = new zzvr();

  @SafeParcelable.Field(getter="getContentFileDescriptor", id=2)
  @GuardedBy("this")
  private ParcelFileDescriptor zzbws;

  public zzvq()
  {
    this(null);
  }

  @SafeParcelable.Constructor
  public zzvq(@SafeParcelable.Param(id=2) ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.zzbws = paramParcelFileDescriptor;
  }

  private final ParcelFileDescriptor zznj()
  {
    try
    {
      ParcelFileDescriptor localParcelFileDescriptor = this.zzbws;
      return localParcelFileDescriptor;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 2, zznj(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }

  public final boolean zznh()
  {
    try
    {
      ParcelFileDescriptor localParcelFileDescriptor = this.zzbws;
      if (localParcelFileDescriptor != null)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  public final InputStream zzni()
  {
    try
    {
      ParcelFileDescriptor localParcelFileDescriptor = this.zzbws;
      Object localObject2 = null;
      if (localParcelFileDescriptor == null);
      while (true)
      {
        return localObject2;
        localObject2 = new ParcelFileDescriptor.AutoCloseInputStream(this.zzbws);
        this.zzbws = null;
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzvq
 * JD-Core Version:    0.6.2
 */