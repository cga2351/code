package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.media.MediaCodecList;
import android.os.Build.VERSION;
import android.util.Range;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@zzare
public final class zzazs
{
  private static Map<String, List<Map<String, Object>>> zzdyj = new HashMap();
  private static List<MediaCodecInfo> zzdyk;
  private static final Object zzdyl = new Object();

  @TargetApi(21)
  private static Integer[] zza(Range<Integer> paramRange)
  {
    Integer[] arrayOfInteger = new Integer[2];
    arrayOfInteger[0] = ((Integer)paramRange.getLower());
    arrayOfInteger[1] = ((Integer)paramRange.getUpper());
    return arrayOfInteger;
  }

  @TargetApi(16)
  public static List<Map<String, Object>> zzeh(String paramString)
  {
    synchronized (zzdyl)
    {
      if (zzdyj.containsKey(paramString))
      {
        List localList = (List)zzdyj.get(paramString);
        return localList;
      }
    }
    try
    {
      synchronized (zzdyl)
      {
        if (zzdyk != null)
        {
          localArrayList2 = new ArrayList();
          Iterator localIterator = zzdyk.iterator();
          MediaCodecInfo localMediaCodecInfo1;
          do
          {
            if (!localIterator.hasNext())
              break;
            localMediaCodecInfo1 = (MediaCodecInfo)localIterator.next();
          }
          while ((localMediaCodecInfo1.isEncoder()) || (!Arrays.asList(localMediaCodecInfo1.getSupportedTypes()).contains(paramString)));
          localHashMap2 = new HashMap();
          localHashMap2.put("codecName", localMediaCodecInfo1.getName());
          localCodecCapabilities = localMediaCodecInfo1.getCapabilitiesForType(paramString);
          localArrayList3 = new ArrayList();
          for (MediaCodecInfo.CodecProfileLevel localCodecProfileLevel : localCodecCapabilities.profileLevels)
          {
            Integer[] arrayOfInteger = new Integer[2];
            arrayOfInteger[0] = Integer.valueOf(localCodecProfileLevel.profile);
            arrayOfInteger[1] = Integer.valueOf(localCodecProfileLevel.level);
            localArrayList3.add(arrayOfInteger);
          }
        }
        if (Build.VERSION.SDK_INT >= 21)
          zzdyk = Arrays.asList(new MediaCodecList(0).getCodecInfos());
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      ArrayList localArrayList2;
      while (true)
      {
        HashMap localHashMap2;
        MediaCodecInfo.CodecCapabilities localCodecCapabilities;
        ArrayList localArrayList3;
        HashMap localHashMap1 = new HashMap();
        localHashMap1.put("error", localRuntimeException.getClass().getSimpleName());
        ArrayList localArrayList1 = new ArrayList();
        localArrayList1.add(localHashMap1);
        zzdyj.put(paramString, localArrayList1);
        return localArrayList1;
        localObject2 = finally;
        throw localObject2;
        if (Build.VERSION.SDK_INT >= 16)
        {
          int k = MediaCodecList.getCodecCount();
          zzdyk = new ArrayList(k);
          for (int m = 0; m < k; m++)
          {
            MediaCodecInfo localMediaCodecInfo2 = MediaCodecList.getCodecInfoAt(m);
            zzdyk.add(localMediaCodecInfo2);
          }
        }
        zzdyk = Collections.emptyList();
        continue;
        localHashMap2.put("profileLevels", localArrayList3);
        if (Build.VERSION.SDK_INT >= 21)
        {
          MediaCodecInfo.VideoCapabilities localVideoCapabilities = localCodecCapabilities.getVideoCapabilities();
          localHashMap2.put("bitRatesBps", zza(localVideoCapabilities.getBitrateRange()));
          localHashMap2.put("widthAlignment", Integer.valueOf(localVideoCapabilities.getWidthAlignment()));
          localHashMap2.put("heightAlignment", Integer.valueOf(localVideoCapabilities.getHeightAlignment()));
          localHashMap2.put("frameRates", zza(localVideoCapabilities.getSupportedFrameRates()));
          localHashMap2.put("widths", zza(localVideoCapabilities.getSupportedWidths()));
          localHashMap2.put("heights", zza(localVideoCapabilities.getSupportedHeights()));
        }
        if (Build.VERSION.SDK_INT >= 23)
          localHashMap2.put("instancesLimit", Integer.valueOf(localCodecCapabilities.getMaxSupportedInstances()));
        localArrayList2.add(localHashMap2);
      }
      zzdyj.put(paramString, localArrayList2);
      return localArrayList2;
    }
    catch (LinkageError localLinkageError)
    {
      label274: break label274;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzazs
 * JD-Core Version:    0.6.2
 */