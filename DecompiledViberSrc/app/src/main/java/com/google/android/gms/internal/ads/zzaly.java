package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

final class zzaly
  implements zzahv
{
  private final zzakx zzddw;
  private final zzbbs zzddx;

  public zzaly(zzalv paramzzalv, zzakx paramzzakx, zzbbs paramzzbbs)
  {
    this.zzddw = paramzzakx;
    this.zzddx = paramzzbbs;
  }

  public final void onFailure(@Nullable String paramString)
  {
    if (paramString == null);
    try
    {
      this.zzddx.setException(new zzalj());
      while (true)
      {
        return;
        this.zzddx.setException(new zzalj(paramString));
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
    }
    finally
    {
      this.zzddw.release();
    }
  }

  public final void zzc(JSONObject paramJSONObject)
  {
    try
    {
      this.zzddx.set(zzalv.zza(this.zzddv).zzd(paramJSONObject));
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
    }
    catch (JSONException localJSONException)
    {
      this.zzddx.set(localJSONException);
      return;
    }
    finally
    {
      this.zzddw.release();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaly
 * JD-Core Version:    0.6.2
 */