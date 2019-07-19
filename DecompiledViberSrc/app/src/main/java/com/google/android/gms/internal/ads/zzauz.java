package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@zzare
@SafeParcelable.Class(creator="SafeBrowsingConfigParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzauz extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzauz> CREATOR = new zzava();

  @SafeParcelable.Field(id=2)
  public final String zzdrt;

  @SafeParcelable.Field(id=3)
  public final String zzdru;

  @SafeParcelable.Field(id=4)
  public final boolean zzdrv;

  @SafeParcelable.Field(id=5)
  public final boolean zzdrw;

  @SafeParcelable.Field(id=6)
  public final List<String> zzdrx;

  @SafeParcelable.Field(id=7)
  public final boolean zzdry;

  @SafeParcelable.Field(id=8)
  public final boolean zzdrz;

  @SafeParcelable.Field(id=9)
  public final List<String> zzdsa;

  @SafeParcelable.Constructor
  public zzauz(@SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) String paramString2, @SafeParcelable.Param(id=4) boolean paramBoolean1, @SafeParcelable.Param(id=5) boolean paramBoolean2, @SafeParcelable.Param(id=6) List<String> paramList1, @SafeParcelable.Param(id=7) boolean paramBoolean3, @SafeParcelable.Param(id=8) boolean paramBoolean4, @SafeParcelable.Param(id=9) List<String> paramList2)
  {
    this.zzdrt = paramString1;
    this.zzdru = paramString2;
    this.zzdrv = paramBoolean1;
    this.zzdrw = paramBoolean2;
    this.zzdrx = paramList1;
    this.zzdry = paramBoolean3;
    this.zzdrz = paramBoolean4;
    if (paramList2 == null)
      paramList2 = new ArrayList();
    this.zzdsa = paramList2;
  }

  public static zzauz zzg(JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramJSONObject == null)
      return null;
    String str1 = paramJSONObject.optString("click_string", "");
    String str2 = paramJSONObject.optString("report_url", "");
    boolean bool1 = paramJSONObject.optBoolean("rendered_ad_enabled", false);
    boolean bool2 = paramJSONObject.optBoolean("non_malicious_reporting_enabled", false);
    List localList1 = zzazd.zza(paramJSONObject.optJSONArray("allowed_headers"), null);
    List localList2 = zzazd.zza(paramJSONObject.optJSONArray("webview_permissions"), null);
    return new zzauz(str1, str2, bool1, bool2, localList1, paramJSONObject.optBoolean("protection_enabled", false), paramJSONObject.optBoolean("malicious_reporting_enabled", false), localList2);
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.zzdrt, false);
    SafeParcelWriter.writeString(paramParcel, 3, this.zzdru, false);
    SafeParcelWriter.writeBoolean(paramParcel, 4, this.zzdrv);
    SafeParcelWriter.writeBoolean(paramParcel, 5, this.zzdrw);
    SafeParcelWriter.writeStringList(paramParcel, 6, this.zzdrx, false);
    SafeParcelWriter.writeBoolean(paramParcel, 7, this.zzdry);
    SafeParcelWriter.writeBoolean(paramParcel, 8, this.zzdrz);
    SafeParcelWriter.writeStringList(paramParcel, 9, this.zzdsa, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzauz
 * JD-Core Version:    0.6.2
 */