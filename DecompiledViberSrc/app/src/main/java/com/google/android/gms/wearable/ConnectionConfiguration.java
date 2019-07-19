package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@SafeParcelable.Class(creator="ConnectionConfigurationCreator")
@SafeParcelable.Reserved({1})
public class ConnectionConfiguration extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<ConnectionConfiguration> CREATOR = new zzg();

  @SafeParcelable.Field(getter="getName", id=2)
  private final String name;

  @SafeParcelable.Field(getter="getType", id=4)
  private final int type;

  @SafeParcelable.Field(getter="getAddress", id=3)
  private final String zzi;

  @SafeParcelable.Field(getter="getRole", id=5)
  private final int zzj;

  @SafeParcelable.Field(getter="isEnabled", id=6)
  private final boolean zzk;

  @SafeParcelable.Field(getter="isConnected", id=7)
  private volatile boolean zzl;

  @SafeParcelable.Field(getter="getPeerNodeId", id=8)
  private volatile String zzm;

  @SafeParcelable.Field(getter="getBtlePriority", id=9)
  private boolean zzn;

  @SafeParcelable.Field(getter="getNodeId", id=10)
  private String zzo;

  @SafeParcelable.Constructor
  ConnectionConfiguration(@SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) String paramString2, @SafeParcelable.Param(id=4) int paramInt1, @SafeParcelable.Param(id=5) int paramInt2, @SafeParcelable.Param(id=6) boolean paramBoolean1, @SafeParcelable.Param(id=7) boolean paramBoolean2, @SafeParcelable.Param(id=8) String paramString3, @SafeParcelable.Param(id=9) boolean paramBoolean3, @SafeParcelable.Param(id=10) String paramString4)
  {
    this.name = paramString1;
    this.zzi = paramString2;
    this.type = paramInt1;
    this.zzj = paramInt2;
    this.zzk = paramBoolean1;
    this.zzl = paramBoolean2;
    this.zzm = paramString3;
    this.zzn = paramBoolean3;
    this.zzo = paramString4;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ConnectionConfiguration));
    ConnectionConfiguration localConnectionConfiguration;
    do
    {
      return false;
      localConnectionConfiguration = (ConnectionConfiguration)paramObject;
    }
    while ((!Objects.equal(this.name, localConnectionConfiguration.name)) || (!Objects.equal(this.zzi, localConnectionConfiguration.zzi)) || (!Objects.equal(Integer.valueOf(this.type), Integer.valueOf(localConnectionConfiguration.type))) || (!Objects.equal(Integer.valueOf(this.zzj), Integer.valueOf(localConnectionConfiguration.zzj))) || (!Objects.equal(Boolean.valueOf(this.zzk), Boolean.valueOf(localConnectionConfiguration.zzk))) || (!Objects.equal(Boolean.valueOf(this.zzn), Boolean.valueOf(localConnectionConfiguration.zzn))));
    return true;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = this.name;
    arrayOfObject[1] = this.zzi;
    arrayOfObject[2] = Integer.valueOf(this.type);
    arrayOfObject[3] = Integer.valueOf(this.zzj);
    arrayOfObject[4] = Boolean.valueOf(this.zzk);
    arrayOfObject[5] = Boolean.valueOf(this.zzn);
    return Objects.hashCode(arrayOfObject);
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ConnectionConfiguration[ ");
    String str1 = String.valueOf(this.name);
    String str2;
    String str4;
    label64: String str6;
    label229: String str7;
    if (str1.length() != 0)
    {
      str2 = "mName=".concat(str1);
      localStringBuilder.append(str2);
      String str3 = String.valueOf(this.zzi);
      if (str3.length() == 0)
        break label327;
      str4 = ", mAddress=".concat(str3);
      localStringBuilder.append(str4);
      int i = this.type;
      localStringBuilder.append(19 + ", mType=" + i);
      int j = this.zzj;
      localStringBuilder.append(19 + ", mRole=" + j);
      boolean bool1 = this.zzk;
      localStringBuilder.append(16 + ", mEnabled=" + bool1);
      boolean bool2 = this.zzl;
      localStringBuilder.append(20 + ", mIsConnected=" + bool2);
      String str5 = String.valueOf(this.zzm);
      if (str5.length() == 0)
        break label341;
      str6 = ", mPeerNodeId=".concat(str5);
      localStringBuilder.append(str6);
      boolean bool3 = this.zzn;
      localStringBuilder.append(21 + ", mBtlePriority=" + bool3);
      str7 = String.valueOf(this.zzo);
      if (str7.length() == 0)
        break label355;
    }
    label327: label341: label355: for (String str8 = ", mNodeId=".concat(str7); ; str8 = new String(", mNodeId="))
    {
      localStringBuilder.append(str8);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      str2 = new String("mName=");
      break;
      str4 = new String(", mAddress=");
      break label64;
      str6 = new String(", mPeerNodeId=");
      break label229;
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.name, false);
    SafeParcelWriter.writeString(paramParcel, 3, this.zzi, false);
    SafeParcelWriter.writeInt(paramParcel, 4, this.type);
    SafeParcelWriter.writeInt(paramParcel, 5, this.zzj);
    SafeParcelWriter.writeBoolean(paramParcel, 6, this.zzk);
    SafeParcelWriter.writeBoolean(paramParcel, 7, this.zzl);
    SafeParcelWriter.writeString(paramParcel, 8, this.zzm, false);
    SafeParcelWriter.writeBoolean(paramParcel, 9, this.zzn);
    SafeParcelWriter.writeString(paramParcel, 10, this.zzo, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.ConnectionConfiguration
 * JD-Core Version:    0.6.2
 */