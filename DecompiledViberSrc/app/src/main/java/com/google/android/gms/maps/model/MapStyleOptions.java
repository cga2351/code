package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;

@SafeParcelable.Class(creator="MapStyleOptionsCreator")
@SafeParcelable.Reserved({1})
public final class MapStyleOptions extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<MapStyleOptions> CREATOR = new zzg();
  private static final String TAG = MapStyleOptions.class.getSimpleName();

  @SafeParcelable.Field(getter="getJson", id=2)
  private String zzdl;

  @SafeParcelable.Constructor
  public MapStyleOptions(@SafeParcelable.Param(id=2) String paramString)
  {
    this.zzdl = paramString;
  }

  public static MapStyleOptions loadRawResourceStyle(Context paramContext, int paramInt)
    throws Resources.NotFoundException
  {
    InputStream localInputStream = paramContext.getResources().openRawResource(paramInt);
    try
    {
      MapStyleOptions localMapStyleOptions = new MapStyleOptions(new String(IOUtils.readInputStreamFully(localInputStream), "UTF-8"));
      return localMapStyleOptions;
    }
    catch (IOException localIOException)
    {
      String str = String.valueOf(localIOException);
      throw new Resources.NotFoundException(37 + String.valueOf(str).length() + "Failed to read resource " + paramInt + ": " + str);
    }
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.zzdl, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.MapStyleOptions
 * JD-Core Version:    0.6.2
 */