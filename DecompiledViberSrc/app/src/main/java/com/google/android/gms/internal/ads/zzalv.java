package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@zzare
@ParametersAreNonnullByDefault
public final class zzalv<I, O>
  implements zzalk<I, O>
{
  private final zzaki zzddp;
  private final zzalm<O> zzddq;
  private final zzaln<I> zzddr;
  private final String zzdds;

  zzalv(zzaki paramzzaki, String paramString, zzaln<I> paramzzaln, zzalm<O> paramzzalm)
  {
    this.zzddp = paramzzaki;
    this.zzdds = paramString;
    this.zzddr = paramzzaln;
    this.zzddq = paramzzalm;
  }

  private final void zza(zzakx paramzzakx, zzalg paramzzalg, I paramI, zzbbs<O> paramzzbbs)
  {
    try
    {
      zzk.zzlg();
      String str = zzaxj.zzwb();
      zzagy.zzdae.zza(str, new zzaly(this, paramzzakx, paramzzbbs));
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", str);
      localJSONObject.put("args", this.zzddr.zzj(paramI));
      paramzzalg.zzb(this.zzdds, localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      try
      {
        paramzzbbs.setException(localException);
        zzaxa.zzc("Unable to invokeJavascript", localException);
        return;
      }
      finally
      {
        paramzzakx.release();
      }
    }
  }

  public final zzbbi<O> zzf(@Nullable I paramI)
    throws Exception
  {
    return zzi(paramI);
  }

  public final zzbbi<O> zzi(I paramI)
  {
    zzbbs localzzbbs = new zzbbs();
    zzakx localzzakx = this.zzddp.zzb(null);
    localzzakx.zza(new zzalw(this, localzzakx, paramI, localzzbbs), new zzalx(this, localzzbbs, localzzakx));
    return localzzbbs;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzalv
 * JD-Core Version:    0.6.2
 */