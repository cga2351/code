package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.internal.maps.zzaf;
import com.google.android.gms.internal.maps.zzag;

@SafeParcelable.Class(creator="TileOverlayOptionsCreator")
@SafeParcelable.Reserved({1})
public final class TileOverlayOptions extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<TileOverlayOptions> CREATOR = new zzu();

  @SafeParcelable.Field(getter="getZIndex", id=4)
  private float zzcs;

  @SafeParcelable.Field(getter="isVisible", id=3)
  private boolean zzct = true;

  @SafeParcelable.Field(getter="getTransparency", id=6)
  private float zzda = 0.0F;

  @SafeParcelable.Field(getter="getTileProviderDelegate", id=2, type="android.os.IBinder")
  private zzaf zzei;
  private TileProvider zzej;

  @SafeParcelable.Field(defaultValue="true", getter="getFadeIn", id=5)
  private boolean zzek = true;

  public TileOverlayOptions()
  {
  }

  @SafeParcelable.Constructor
  TileOverlayOptions(@SafeParcelable.Param(id=2) IBinder paramIBinder, @SafeParcelable.Param(id=3) boolean paramBoolean1, @SafeParcelable.Param(id=4) float paramFloat1, @SafeParcelable.Param(id=5) boolean paramBoolean2, @SafeParcelable.Param(id=6) float paramFloat2)
  {
    this.zzei = zzag.zzk(paramIBinder);
    if (this.zzei == null);
    for (zzs localzzs = null; ; localzzs = new zzs(this))
    {
      this.zzej = localzzs;
      this.zzct = paramBoolean1;
      this.zzcs = paramFloat1;
      this.zzek = paramBoolean2;
      this.zzda = paramFloat2;
      return;
    }
  }

  public final TileOverlayOptions fadeIn(boolean paramBoolean)
  {
    this.zzek = paramBoolean;
    return this;
  }

  public final boolean getFadeIn()
  {
    return this.zzek;
  }

  public final TileProvider getTileProvider()
  {
    return this.zzej;
  }

  public final float getTransparency()
  {
    return this.zzda;
  }

  public final float getZIndex()
  {
    return this.zzcs;
  }

  public final boolean isVisible()
  {
    return this.zzct;
  }

  public final TileOverlayOptions tileProvider(TileProvider paramTileProvider)
  {
    this.zzej = paramTileProvider;
    if (this.zzej == null);
    for (zzt localzzt = null; ; localzzt = new zzt(this, paramTileProvider))
    {
      this.zzei = localzzt;
      return this;
    }
  }

  public final TileOverlayOptions transparency(float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "Transparency must be in the range [0..1]");
      this.zzda = paramFloat;
      return this;
    }
  }

  public final TileOverlayOptions visible(boolean paramBoolean)
  {
    this.zzct = paramBoolean;
    return this;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeIBinder(paramParcel, 2, this.zzei.asBinder(), false);
    SafeParcelWriter.writeBoolean(paramParcel, 3, isVisible());
    SafeParcelWriter.writeFloat(paramParcel, 4, getZIndex());
    SafeParcelWriter.writeBoolean(paramParcel, 5, getFadeIn());
    SafeParcelWriter.writeFloat(paramParcel, 6, getTransparency());
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }

  public final TileOverlayOptions zIndex(float paramFloat)
  {
    this.zzcs = paramFloat;
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.TileOverlayOptions
 * JD-Core Version:    0.6.2
 */