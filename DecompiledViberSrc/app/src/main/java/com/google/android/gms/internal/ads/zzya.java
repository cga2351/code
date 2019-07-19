package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

@zzare
public final class zzya
{
  public static final zzya zzchf = new zzya();

  public static zzxx zza(Context paramContext, zzaax paramzzaax)
  {
    Date localDate = paramzzaax.getBirthday();
    long l;
    String str1;
    int i;
    List localList;
    label56: boolean bool1;
    int j;
    Location localLocation;
    Bundle localBundle;
    boolean bool2;
    String str2;
    SearchAdRequest localSearchAdRequest;
    if (localDate != null)
    {
      l = localDate.getTime();
      str1 = paramzzaax.getContentUrl();
      i = paramzzaax.getGender();
      Set localSet = paramzzaax.getKeywords();
      if (localSet.isEmpty())
        break label246;
      localList = Collections.unmodifiableList(new ArrayList(localSet));
      bool1 = paramzzaax.isTestDevice(paramContext);
      j = paramzzaax.zzqc();
      localLocation = paramzzaax.getLocation();
      localBundle = paramzzaax.getNetworkExtrasBundle(AdMobAdapter.class);
      bool2 = paramzzaax.getManualImpressionsEnabled();
      str2 = paramzzaax.getPublisherProvidedId();
      localSearchAdRequest = paramzzaax.zzpz();
      if (localSearchAdRequest == null)
        break label252;
    }
    label246: label252: for (zzabz localzzabz = new zzabz(localSearchAdRequest); ; localzzabz = null)
    {
      Context localContext = paramContext.getApplicationContext();
      String str3 = null;
      if (localContext != null)
      {
        String str5 = localContext.getPackageName();
        zzyr.zzpa();
        str3 = zzazu.zza(Thread.currentThread().getStackTrace(), str5);
      }
      boolean bool3 = paramzzaax.isDesignedForFamilies();
      int k = paramzzaax.zzqe();
      String str4 = paramzzaax.getMaxAdContentRating();
      return new zzxx(8, l, localBundle, i, localList, bool1, j, bool2, str2, localzzabz, localLocation, str1, paramzzaax.zzqb(), paramzzaax.getCustomTargeting(), Collections.unmodifiableList(new ArrayList(paramzzaax.zzqd())), paramzzaax.zzpy(), str3, bool3, null, k, str4);
      l = -1L;
      break;
      localList = null;
      break label56;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzya
 * JD-Core Version:    0.6.2
 */