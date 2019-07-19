package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
@TargetApi(21)
final class zzavf
{
  private static final Map<String, String> zzdsb = localHashMap;
  private final List<String> zzdsc;
  private final zzaur zzdsd;
  private final Context zzlj;

  static
  {
    HashMap localHashMap = new HashMap();
    if (PlatformVersion.isAtLeastLollipop())
    {
      localHashMap.put("android.webkit.resource.AUDIO_CAPTURE", "android.permission.RECORD_AUDIO");
      localHashMap.put("android.webkit.resource.VIDEO_CAPTURE", "android.permission.CAMERA");
    }
  }

  zzavf(Context paramContext, List<String> paramList, zzaur paramzzaur)
  {
    this.zzlj = paramContext;
    this.zzdsc = paramList;
    this.zzdsd = paramzzaur;
  }

  final List<String> zzb(String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfString.length;
    int j = 0;
    if (j < i)
    {
      String str1 = paramArrayOfString[j];
      Iterator localIterator = this.zzdsc.iterator();
      label37: String str2;
      int k;
      label72: int m;
      if (localIterator.hasNext())
      {
        str2 = (String)localIterator.next();
        if (str2.equals(str1))
        {
          k = 1;
          if (k == 0)
            break label225;
          if (zzdsb.containsKey(str1))
          {
            zzk.zzlg();
            if (!zzaxj.zzp(this.zzlj, (String)zzdsb.get(str1)))
              break label207;
          }
          m = 1;
          label120: if (m == 0)
            break label213;
          localArrayList.add(str1);
        }
      }
      while (true)
      {
        j++;
        break;
        String str3 = String.valueOf("android.webkit.resource.");
        String str4 = String.valueOf(str2);
        if (str4.length() != 0);
        for (String str5 = str3.concat(str4); ; str5 = new String(str3))
        {
          if (!str5.equals(str1))
            break label199;
          k = 1;
          break;
        }
        label199: break label37;
        k = 0;
        break label72;
        label207: m = 0;
        break label120;
        label213: this.zzdsd.zzdm(str1);
        continue;
        label225: this.zzdsd.zzdl(str1);
      }
    }
    return localArrayList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzavf
 * JD-Core Version:    0.6.2
 */