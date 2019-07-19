package com.google.android.gms.internal.ads;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzcxe
  implements zzdth<zzcva<JSONObject>>
{
  public static zzcva<JSONObject> zza(Object paramObject, zzcvt paramzzcvt, zzcwm paramzzcwm, zzdtd<zzcvn> paramzzdtd, zzdtd<zzcvx> paramzzdtd1, zzdtd<zzcwb> paramzzdtd2, zzdtd<zzcwi> paramzzdtd3, zzdtd<zzcwp> paramzzdtd4, zzdtd<zzcwt> paramzzdtd5, zzdtd<zzcxg> paramzzdtd6, Executor paramExecutor)
  {
    zzcwe localzzcwe = (zzcwe)paramObject;
    HashSet localHashSet = new HashSet();
    localHashSet.add(localzzcwe);
    localHashSet.add(paramzzcvt);
    localHashSet.add(paramzzcwm);
    zzaci localzzaci1 = zzact.zzcvt;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci1)).booleanValue())
      localHashSet.add((zzcuz)paramzzdtd.get());
    zzaci localzzaci2 = zzact.zzcvu;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci2)).booleanValue())
      localHashSet.add((zzcuz)paramzzdtd1.get());
    zzaci localzzaci3 = zzact.zzcvv;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci3)).booleanValue())
      localHashSet.add((zzcuz)paramzzdtd2.get());
    zzaci localzzaci4 = zzact.zzcvw;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci4)).booleanValue())
      localHashSet.add((zzcuz)paramzzdtd3.get());
    zzaci localzzaci5 = zzact.zzcvz;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci5)).booleanValue())
      localHashSet.add((zzcuz)paramzzdtd4.get());
    zzaci localzzaci6 = zzact.zzcwb;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci6)).booleanValue())
      localHashSet.add((zzcuz)paramzzdtd5.get());
    zzaci localzzaci7 = zzact.zzcwc;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci7)).booleanValue())
      localHashSet.add((zzcuz)paramzzdtd6.get());
    return (zzcva)zzdtn.zza(new zzcva(paramExecutor, localHashSet), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcxe
 * JD-Core Version:    0.6.2
 */