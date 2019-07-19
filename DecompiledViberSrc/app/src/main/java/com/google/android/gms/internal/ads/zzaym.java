package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;
import java.util.regex.Pattern;

@zzare
public final class zzaym extends zzak
{
  private final Context zzlj;

  private zzaym(Context paramContext, zzas paramzzas)
  {
    super(paramzzas);
    this.zzlj = paramContext;
  }

  public static zzv zzbc(Context paramContext)
  {
    zzaym localzzaym = new zzaym(paramContext, new zzat());
    zzv localzzv = new zzv(new zzan(new File(paramContext.getCacheDir(), "admob_volley"), 20971520), localzzaym);
    localzzv.start();
    return localzzv;
  }

  public final zzp zzc(zzr<?> paramzzr)
    throws zzaf
  {
    String str2;
    if ((paramzzr.zzh()) && (paramzzr.getMethod() == 0))
    {
      String str1 = paramzzr.getUrl();
      zzaci localzzaci = zzact.zzctx;
      if (Pattern.matches((String)zzyr.zzpe().zzd(localzzaci), str1))
      {
        zzyr.zzpa();
        if (zzazu.zzc(this.zzlj, 13400000))
        {
          zzp localzzp = new zzaih(this.zzlj).zzc(paramzzr);
          if (localzzp != null)
          {
            String str4 = String.valueOf(paramzzr.getUrl());
            if (str4.length() != 0);
            for (String str5 = "Got gmscore asset response: ".concat(str4); ; str5 = new String("Got gmscore asset response: "))
            {
              zzaxa.zzds(str5);
              return localzzp;
            }
          }
          str2 = String.valueOf(paramzzr.getUrl());
          if (str2.length() == 0)
            break label163;
        }
      }
    }
    label163: for (String str3 = "Failed to get gmscore asset response: ".concat(str2); ; str3 = new String("Failed to get gmscore asset response: "))
    {
      zzaxa.zzds(str3);
      return super.zzc(paramzzr);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaym
 * JD-Core Version:    0.6.2
 */