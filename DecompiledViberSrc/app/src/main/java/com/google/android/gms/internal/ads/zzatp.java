package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzare
@SafeParcelable.Class(creator="RewardItemParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzatp extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzatp> CREATOR = new zzatq();

  @SafeParcelable.Field(id=2)
  public final String type;

  @SafeParcelable.Field(id=3)
  public final int zzdqo;

  public zzatp(RewardItem paramRewardItem)
  {
    this(paramRewardItem.getType(), paramRewardItem.getAmount());
  }

  @SafeParcelable.Constructor
  public zzatp(@SafeParcelable.Param(id=2) String paramString, @SafeParcelable.Param(id=3) int paramInt)
  {
    this.type = paramString;
    this.zzdqo = paramInt;
  }

  public static zzatp zza(JSONArray paramJSONArray)
    throws JSONException
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
      return null;
    return new zzatp(paramJSONArray.getJSONObject(0).optString("rb_type"), paramJSONArray.getJSONObject(0).optInt("rb_amount"));
  }

  public final boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof zzatp)));
    zzatp localzzatp;
    do
    {
      return false;
      localzzatp = (zzatp)paramObject;
    }
    while ((!Objects.equal(this.type, localzzatp.type)) || (!Objects.equal(Integer.valueOf(this.zzdqo), Integer.valueOf(localzzatp.zzdqo))));
    return true;
  }

  public final int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.type;
    arrayOfObject[1] = Integer.valueOf(this.zzdqo);
    return Objects.hashCode(arrayOfObject);
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.type, false);
    SafeParcelWriter.writeInt(paramParcel, 3, this.zzdqo);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzatp
 * JD-Core Version:    0.6.2
 */