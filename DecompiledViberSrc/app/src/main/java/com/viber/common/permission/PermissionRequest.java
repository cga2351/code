package com.viber.common.permission;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;
import java.util.Arrays;

class PermissionRequest
  implements Parcelable
{
  public static final Parcelable.Creator<PermissionRequest> CREATOR = new Parcelable.Creator()
  {
    public PermissionRequest a(Parcel paramAnonymousParcel)
    {
      return new PermissionRequest(paramAnonymousParcel);
    }

    public PermissionRequest[] a(int paramAnonymousInt)
    {
      return new PermissionRequest[paramAnonymousInt];
    }
  };
  private static final String KEY_FOR_EXTRA = "extra_object";
  final Object mExtra;
  final String[] mPermissions;
  final boolean mRational;
  final int mRequestCode;

  PermissionRequest(int paramInt, boolean paramBoolean, String[] paramArrayOfString)
  {
    this(paramInt, paramBoolean, paramArrayOfString, null);
  }

  PermissionRequest(int paramInt, boolean paramBoolean, String[] paramArrayOfString, Object paramObject)
  {
    validateExtra(paramObject);
    this.mRequestCode = paramInt;
    this.mRational = paramBoolean;
    this.mPermissions = paramArrayOfString;
    this.mExtra = paramObject;
  }

  PermissionRequest(Parcel paramParcel)
  {
    this.mRequestCode = paramParcel.readInt();
    if (paramParcel.readInt() == i);
    while (true)
    {
      this.mRational = i;
      this.mPermissions = paramParcel.createStringArray();
      Bundle localBundle = paramParcel.readBundle(getClass().getClassLoader());
      if (localBundle == null)
        break;
      this.mExtra = localBundle.get("extra_object");
      return;
      i = 0;
    }
    this.mExtra = null;
  }

  private static Bundle packageExtra(Object paramObject)
  {
    Bundle localBundle;
    if (paramObject == null)
      localBundle = null;
    do
    {
      return localBundle;
      localBundle = new Bundle();
      if ((paramObject instanceof Bundle))
      {
        localBundle.putBundle("extra_object", (Bundle)paramObject);
        return localBundle;
      }
      if ((paramObject instanceof Parcelable))
      {
        localBundle.putParcelable("extra_object", (Parcelable)paramObject);
        return localBundle;
      }
    }
    while (!(paramObject instanceof Serializable));
    localBundle.putSerializable("extra_object", (Serializable)paramObject);
    return localBundle;
  }

  private static void validateExtra(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof Bundle)) && (!(paramObject instanceof Parcelable)) && (!(paramObject instanceof Serializable)))
      throw new IllegalArgumentException("Permission request extra argument must be either Parcelable or Servializable or Bundle");
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return "PermissionRequest{requestCode=" + this.mRequestCode + ", rational=" + this.mRational + ", permissions=" + Arrays.toString(this.mPermissions) + ", extra=" + this.mExtra + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mRequestCode);
    if (this.mRational);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeStringArray(this.mPermissions);
      paramParcel.writeBundle(packageExtra(this.mExtra));
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.permission.PermissionRequest
 * JD-Core Version:    0.6.2
 */