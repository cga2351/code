package com.mopub.mobileads;

import android.content.Context;
import android.graphics.Point;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Dips;
import com.mopub.network.Networking;
import com.mopub.network.TrackingRequest;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class VastXmlManagerAggregator extends AsyncTask<String, Void, VastVideoConfig>
{
  public static final String ADS_BY_AD_SLOT_ID = "adsBy";
  public static final String SOCIAL_ACTIONS_AD_SLOT_ID = "socialActions";
  private static final List<String> a = Arrays.asList(new String[] { "video/mp4", "video/3gpp" });
  private final WeakReference<b> b;
  private final double c;
  private final int d;
  private final Context e;
  private int f;

  VastXmlManagerAggregator(b paramb, double paramDouble, int paramInt, Context paramContext)
  {
    Preconditions.checkNotNull(paramb);
    Preconditions.checkNotNull(paramContext);
    this.b = new WeakReference(paramb);
    this.c = paramDouble;
    this.d = paramInt;
    this.e = paramContext.getApplicationContext();
  }

  private double a(int paramInt1, int paramInt2)
  {
    double d1 = paramInt1 / paramInt2;
    int i = paramInt1 * paramInt2;
    double d2 = d1 / this.c;
    double d3 = i / this.d;
    return 70.0D * Math.abs(Math.log(d2)) + 30.0D * Math.abs(Math.log(d3));
  }

  private VastVideoConfig a(j paramj, List<VastTracker> paramList)
  {
    Preconditions.checkNotNull(paramj);
    Preconditions.checkNotNull(paramList);
    Iterator localIterator = paramj.c().iterator();
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      String str = a(localk.k());
      if (str != null)
      {
        VastVideoConfig localVastVideoConfig = new VastVideoConfig();
        localVastVideoConfig.addImpressionTrackers(paramj.a());
        a(localk, localVastVideoConfig);
        localVastVideoConfig.setClickThroughUrl(localk.h());
        localVastVideoConfig.setNetworkMediaFileUrl(str);
        List localList = paramj.d();
        localVastVideoConfig.setVastCompanionAd(a(localList, a.LANDSCAPE), a(localList, a.PORTRAIT));
        localVastVideoConfig.setSocialActionsCompanionAds(b(localList));
        paramList.addAll(paramj.b());
        localVastVideoConfig.addErrorTrackers(paramList);
        a(paramj, localVastVideoConfig);
        b(paramj, localVastVideoConfig);
        return localVastVideoConfig;
      }
    }
    return null;
  }

  private String a(p paramp, List<VastTracker> paramList)
  {
    String str1 = paramp.f();
    if (str1 == null);
    do
    {
      return null;
      try
      {
        String str2 = b(str1);
        return str2;
      }
      catch (Exception localException)
      {
        MoPubLog.log(MoPubLog.SdkLogEvent.ERROR, new Object[] { "Failed to follow VAST redirect", localException });
      }
    }
    while (paramList.isEmpty());
    TrackingRequest.makeVastTrackingHttpRequest(paramList, VastErrorCode.WRAPPER_TIMEOUT, null, null, this.e);
    return null;
  }

  private void a(g paramg, VastVideoConfig paramVastVideoConfig)
  {
    Preconditions.checkNotNull(paramg);
    Preconditions.checkNotNull(paramVastVideoConfig);
    if (paramVastVideoConfig.getVideoViewabilityTracker() != null);
    VastExtensionXmlManager localVastExtensionXmlManager;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        VastExtensionParentXmlManager localVastExtensionParentXmlManager;
        do
          localVastExtensionParentXmlManager = paramg.e();
        while (localVastExtensionParentXmlManager == null);
        localIterator = localVastExtensionParentXmlManager.a().iterator();
      }
      localVastExtensionXmlManager = (VastExtensionXmlManager)localIterator.next();
    }
    while (!"MoPub".equals(localVastExtensionXmlManager.d()));
    paramVastVideoConfig.setVideoViewabilityTracker(localVastExtensionXmlManager.a());
  }

  private void a(k paramk, VastVideoConfig paramVastVideoConfig)
  {
    Preconditions.checkNotNull(paramk, "linearXmlManager cannot be null");
    Preconditions.checkNotNull(paramVastVideoConfig, "vastVideoConfig cannot be null");
    paramVastVideoConfig.addAbsoluteTrackers(paramk.b());
    paramVastVideoConfig.addFractionalTrackers(paramk.a());
    paramVastVideoConfig.addPauseTrackers(paramk.d());
    paramVastVideoConfig.addResumeTrackers(paramk.e());
    paramVastVideoConfig.addCompleteTrackers(paramk.c());
    paramVastVideoConfig.addCloseTrackers(paramk.f());
    paramVastVideoConfig.addSkipTrackers(paramk.g());
    paramVastVideoConfig.addClickTrackers(paramk.i());
    if (paramVastVideoConfig.getSkipOffsetString() == null)
      paramVastVideoConfig.setSkipOffset(paramk.j());
    if (paramVastVideoConfig.getVastIconConfig() == null)
      paramVastVideoConfig.setVastIconConfig(c(paramk.l()));
  }

  private void a(q paramq, VastVideoConfig paramVastVideoConfig)
  {
    Preconditions.checkNotNull(paramq, "xmlManager cannot be null");
    Preconditions.checkNotNull(paramVastVideoConfig, "vastVideoConfig cannot be null");
    paramVastVideoConfig.addImpressionTrackers(paramq.c());
    if (paramVastVideoConfig.getCustomCtaText() == null)
      paramVastVideoConfig.setCustomCtaText(paramq.d());
    if (paramVastVideoConfig.getCustomSkipText() == null)
      paramVastVideoConfig.setCustomSkipText(paramq.e());
    if (paramVastVideoConfig.getCustomCloseIconUrl() == null)
      paramVastVideoConfig.setCustomCloseIconUrl(paramq.f());
    if (!paramVastVideoConfig.isCustomForceOrientationSet())
      paramVastVideoConfig.setCustomForceOrientation(paramq.g());
  }

  static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    while (true)
    {
      return true;
      try
      {
        int i = Integer.parseInt(paramString);
        if (i >= 2)
          return false;
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
    }
    return true;
  }

  private boolean a(List<f> paramList, q paramq, Context paramContext)
  {
    if ((paramList.isEmpty()) && (paramq.b() != null))
    {
      List localList = Collections.singletonList(paramq.b());
      if (this.f > 0);
      for (VastErrorCode localVastErrorCode = VastErrorCode.NO_ADS_VAST_RESPONSE; ; localVastErrorCode = VastErrorCode.UNDEFINED_ERROR)
      {
        TrackingRequest.makeVastTrackingHttpRequest(localList, localVastErrorCode, null, null, paramContext);
        return true;
      }
    }
    return false;
  }

  // ERROR //
  private String b(String paramString)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 51	com/mopub/common/Preconditions:checkNotNull	(Ljava/lang/Object;)V
    //   4: aload_0
    //   5: getfield 375	com/mopub/mobileads/VastXmlManagerAggregator:f	I
    //   8: istore_2
    //   9: aconst_null
    //   10: astore_3
    //   11: iload_2
    //   12: bipush 10
    //   14: if_icmpge +62 -> 76
    //   17: aload_0
    //   18: iconst_1
    //   19: aload_0
    //   20: getfield 375	com/mopub/mobileads/VastXmlManagerAggregator:f	I
    //   23: iadd
    //   24: putfield 375	com/mopub/mobileads/VastXmlManagerAggregator:f	I
    //   27: aload_1
    //   28: invokestatic 389	com/mopub/common/MoPubHttpUrlConnection:getHttpUrlConnection	(Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   31: astore 8
    //   33: aload 8
    //   35: astore 5
    //   37: new 391	java/io/BufferedInputStream
    //   40: dup
    //   41: aload 5
    //   43: invokevirtual 397	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   46: invokespecial 400	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   49: astore 7
    //   51: aload 7
    //   53: invokestatic 406	com/mopub/common/util/Strings:fromStream	(Ljava/io/InputStream;)Ljava/lang/String;
    //   56: astore 9
    //   58: aload 9
    //   60: astore_3
    //   61: aload 7
    //   63: invokestatic 412	com/mopub/common/util/Streams:closeStream	(Ljava/io/Closeable;)V
    //   66: aload 5
    //   68: ifnull +8 -> 76
    //   71: aload 5
    //   73: invokevirtual 415	java/net/HttpURLConnection:disconnect	()V
    //   76: aload_3
    //   77: areturn
    //   78: astore 4
    //   80: aconst_null
    //   81: astore 5
    //   83: aload 4
    //   85: astore 6
    //   87: aconst_null
    //   88: astore 7
    //   90: aload 7
    //   92: invokestatic 412	com/mopub/common/util/Streams:closeStream	(Ljava/io/Closeable;)V
    //   95: aload 5
    //   97: ifnull +8 -> 105
    //   100: aload 5
    //   102: invokevirtual 415	java/net/HttpURLConnection:disconnect	()V
    //   105: aload 6
    //   107: athrow
    //   108: astore 10
    //   110: aload 10
    //   112: astore 6
    //   114: aconst_null
    //   115: astore 7
    //   117: goto -27 -> 90
    //   120: astore 6
    //   122: goto -32 -> 90
    //
    // Exception table:
    //   from	to	target	type
    //   27	33	78	finally
    //   37	51	108	finally
    //   51	58	120	finally
  }

  private void b(g paramg, VastVideoConfig paramVastVideoConfig)
  {
    VastExtensionParentXmlManager localVastExtensionParentXmlManager = paramg.e();
    if (localVastExtensionParentXmlManager != null)
    {
      Iterator localIterator = localVastExtensionParentXmlManager.a().iterator();
      while (localIterator.hasNext())
      {
        VastExtensionXmlManager localVastExtensionXmlManager = (VastExtensionXmlManager)localIterator.next();
        if (localVastExtensionXmlManager != null)
        {
          paramVastVideoConfig.addAvidJavascriptResources(localVastExtensionXmlManager.b());
          paramVastVideoConfig.addMoatImpressionPixels(localVastExtensionXmlManager.c());
        }
      }
    }
  }

  @VisibleForTesting
  Point a(int paramInt1, int paramInt2, n.b paramb, a parama)
  {
    Point localPoint1 = new Point(paramInt1, paramInt2);
    Display localDisplay = ((WindowManager)this.e.getSystemService("window")).getDefaultDisplay();
    int i = localDisplay.getWidth();
    int j = localDisplay.getHeight();
    int k = Dips.dipsToIntPixels(paramInt1, this.e);
    int m = Dips.dipsToIntPixels(paramInt2, this.e);
    int i5;
    int i2;
    if (a.LANDSCAPE == parama)
    {
      int i4 = Math.max(i, j);
      i5 = Math.min(i, j);
      i2 = i4;
    }
    int i1;
    for (int i3 = i5; (k <= i2 - 16) && (m <= i3 - 16); i3 = i1)
    {
      return localPoint1;
      int n = Math.min(i, j);
      i1 = Math.max(i, j);
      i2 = n;
    }
    Point localPoint2 = new Point();
    if (n.b.HTML_RESOURCE == paramb)
    {
      localPoint2.x = Math.min(i2, k);
      localPoint2.y = Math.min(i3, m);
    }
    while (true)
    {
      localPoint2.x = (-16 + localPoint2.x);
      localPoint2.y = (-16 + localPoint2.y);
      if ((localPoint2.x >= 0) && (localPoint2.y >= 0))
        break;
      return localPoint1;
      float f1 = k / i2;
      float f2 = m / i3;
      if (f1 >= f2)
      {
        localPoint2.x = i2;
        localPoint2.y = ((int)(m / f1));
      }
      else
      {
        localPoint2.x = ((int)(k / f2));
        localPoint2.y = i3;
      }
    }
    localPoint2.x = Dips.pixelsToIntDips(localPoint2.x, this.e);
    localPoint2.y = Dips.pixelsToIntDips(localPoint2.y, this.e);
    return localPoint2;
  }

  @VisibleForTesting
  VastCompanionAdConfig a(List<h> paramList, a parama)
  {
    Preconditions.checkNotNull(paramList, "managers cannot be null");
    Preconditions.checkNotNull(parama, "orientation cannot be null");
    ArrayList localArrayList = new ArrayList(paramList);
    double d1 = (1.0D / 0.0D);
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    n.b[] arrayOfb = n.b.values();
    int i = arrayOfb.length;
    int j = 0;
    label72: Integer localInteger1;
    Integer localInteger2;
    double d2;
    label209: Object localObject8;
    double d3;
    Object localObject6;
    Object localObject7;
    if (j < i)
    {
      n.b localb = arrayOfb[j];
      Iterator localIterator = localArrayList.iterator();
      while (true)
        if (localIterator.hasNext())
        {
          h localh = (h)localIterator.next();
          localInteger1 = localh.a();
          localInteger2 = localh.b();
          if ((localInteger1 != null) && (localInteger1.intValue() >= 300) && (localInteger2 != null) && (localInteger2.intValue() >= 250))
          {
            Point localPoint = a(localInteger1.intValue(), localInteger2.intValue(), localb, parama);
            n localn = n.a(localh.d(), localb, localPoint.x, localPoint.y);
            if (localn != null)
              if (a.PORTRAIT == parama)
              {
                d2 = a(localInteger2.intValue(), localInteger1.intValue());
                if (d2 >= d1)
                  break label343;
                localObject8 = localh;
                d3 = d2;
                localObject6 = localPoint;
                localObject7 = localn;
              }
          }
        }
    }
    while (true)
    {
      d1 = d3;
      localObject2 = localObject7;
      localObject1 = localObject8;
      localObject3 = localObject6;
      break label72;
      d2 = a(localInteger1.intValue(), localInteger2.intValue());
      break label209;
      Object localObject4;
      if (localObject1 != null)
        localObject4 = localObject2;
      for (Object localObject5 = localObject1; ; localObject5 = localObject1)
      {
        if (localObject5 != null)
        {
          return new VastCompanionAdConfig(localObject3.x, localObject3.y, localObject4, localObject5.e(), localObject5.f(), localObject5.g());
          j++;
          break;
        }
        return null;
        localObject4 = localObject2;
      }
      label343: localObject6 = localObject3;
      localObject7 = localObject2;
      localObject8 = localObject1;
      d3 = d1;
    }
  }

  @VisibleForTesting
  VastVideoConfig a(String paramString, List<VastTracker> paramList)
  {
    Preconditions.checkNotNull(paramString, "vastXml cannot be null");
    Preconditions.checkNotNull(paramList, "errorTrackers cannot be null");
    q localq = new q();
    List localList1;
    try
    {
      localq.a(paramString);
      localList1 = localq.a();
      if (a(localList1, localq, this.e))
        return null;
    }
    catch (Exception localException)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.ERROR, new Object[] { "Failed to parse VAST XML", localException });
      TrackingRequest.makeVastTrackingHttpRequest(paramList, VastErrorCode.XML_PARSING_ERROR, null, null, this.e);
      return null;
    }
    Iterator localIterator1 = localList1.iterator();
    while (localIterator1.hasNext())
    {
      f localf = (f)localIterator1.next();
      if (a(localf.c()))
      {
        j localj = localf.a();
        if (localj != null)
        {
          VastVideoConfig localVastVideoConfig2 = a(localj, paramList);
          if (localVastVideoConfig2 != null)
          {
            a(localq, localVastVideoConfig2);
            return localVastVideoConfig2;
          }
        }
        p localp = localf.b();
        if (localp != null)
        {
          ArrayList localArrayList = new ArrayList(paramList);
          localArrayList.addAll(localp.b());
          String str = a(localp, localArrayList);
          if (str != null)
          {
            VastVideoConfig localVastVideoConfig1 = a(str, localArrayList);
            if (localVastVideoConfig1 != null)
            {
              localVastVideoConfig1.addImpressionTrackers(localp.a());
              Iterator localIterator2 = localp.c().iterator();
              while (localIterator2.hasNext())
                a((k)localIterator2.next(), localVastVideoConfig1);
              a(localp, localVastVideoConfig1);
              b(localp, localVastVideoConfig1);
              List localList2 = localp.d();
              if (!localVastVideoConfig1.hasCompanionAd())
                localVastVideoConfig1.setVastCompanionAd(a(localList2, a.LANDSCAPE), a(localList2, a.PORTRAIT));
              while (true)
              {
                if (localVastVideoConfig1.getSocialActionsCompanionAds().isEmpty())
                  localVastVideoConfig1.setSocialActionsCompanionAds(b(localList2));
                a(localq, localVastVideoConfig1);
                return localVastVideoConfig1;
                VastCompanionAdConfig localVastCompanionAdConfig1 = localVastVideoConfig1.getVastCompanionAd(2);
                VastCompanionAdConfig localVastCompanionAdConfig2 = localVastVideoConfig1.getVastCompanionAd(1);
                if ((localVastCompanionAdConfig1 != null) && (localVastCompanionAdConfig2 != null))
                {
                  Iterator localIterator3 = localList2.iterator();
                  while (localIterator3.hasNext())
                  {
                    h localh = (h)localIterator3.next();
                    if (!localh.h())
                    {
                      localVastCompanionAdConfig1.addClickTrackers(localh.f());
                      localVastCompanionAdConfig1.addCreativeViewTrackers(localh.g());
                      localVastCompanionAdConfig2.addClickTrackers(localh.f());
                      localVastCompanionAdConfig2.addCreativeViewTrackers(localh.g());
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return null;
  }

  protected VastVideoConfig a(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0) || (paramArrayOfString[0] == null))
      return null;
    try
    {
      VastVideoConfig localVastVideoConfig = a(paramArrayOfString[0], new ArrayList());
      return localVastVideoConfig;
    }
    catch (Exception localException)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.ERROR, new Object[] { "Unable to generate VastVideoConfig.", localException });
    }
    return null;
  }

  @VisibleForTesting
  String a(List<m> paramList)
  {
    Preconditions.checkNotNull(paramList, "managers cannot be null");
    ArrayList localArrayList = new ArrayList(paramList);
    double d1 = (1.0D / 0.0D);
    Object localObject1 = null;
    Iterator localIterator = localArrayList.iterator();
    double d2;
    Object localObject2;
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      String str1 = localm.c();
      String str2 = localm.d();
      if ((!a.contains(str1)) || (str2 == null))
      {
        localIterator.remove();
      }
      else
      {
        Integer localInteger1 = localm.a();
        Integer localInteger2 = localm.b();
        if ((localInteger1 != null) && (localInteger1.intValue() > 0) && (localInteger2 != null) && (localInteger2.intValue() > 0))
        {
          d2 = a(localInteger1.intValue(), localInteger2.intValue());
          if (d2 >= d1)
            break label179;
          localObject2 = str2;
        }
      }
    }
    for (double d3 = d2; ; d3 = d1)
    {
      d1 = d3;
      localObject1 = localObject2;
      break;
      return localObject1;
      label179: localObject2 = localObject1;
    }
  }

  protected void a(VastVideoConfig paramVastVideoConfig)
  {
    b localb = (b)this.b.get();
    if (localb != null)
      localb.onAggregationComplete(paramVastVideoConfig);
  }

  @VisibleForTesting
  Map<String, VastCompanionAdConfig> b(List<h> paramList)
  {
    Preconditions.checkNotNull(paramList, "managers cannot be null");
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      h localh = (h)localIterator.next();
      Integer localInteger1 = localh.a();
      Integer localInteger2 = localh.b();
      if ((localInteger1 != null) && (localInteger2 != null))
      {
        String str = localh.c();
        if ("adsBy".equals(str))
        {
          if ((localInteger1.intValue() < 25) || (localInteger1.intValue() > 75) || (localInteger2.intValue() < 10) || (localInteger2.intValue() > 50));
        }
        else
          do
          {
            n localn = n.a(localh.d(), n.b.HTML_RESOURCE, localInteger1.intValue(), localInteger2.intValue());
            if (localn == null)
              break;
            localHashMap.put(str, new VastCompanionAdConfig(localInteger1.intValue(), localInteger2.intValue(), localn, localh.e(), localh.f(), localh.g()));
            break;
            if ((!"socialActions".equals(str)) || (localInteger1.intValue() < 50) || (localInteger1.intValue() > 150) || (localInteger2.intValue() < 10))
              break;
          }
          while (localInteger2.intValue() <= 50);
      }
    }
    return localHashMap;
  }

  @VisibleForTesting
  i c(List<VastIconXmlManager> paramList)
  {
    Preconditions.checkNotNull(paramList, "managers cannot be null");
    ArrayList localArrayList = new ArrayList(paramList);
    for (n.b localb : n.b.values())
    {
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        VastIconXmlManager localVastIconXmlManager = (VastIconXmlManager)localIterator.next();
        Integer localInteger1 = localVastIconXmlManager.a();
        Integer localInteger2 = localVastIconXmlManager.b();
        if ((localInteger1 != null) && (localInteger1.intValue() > 0) && (localInteger1.intValue() <= 300) && (localInteger2 != null) && (localInteger2.intValue() > 0) && (localInteger2.intValue() <= 300))
        {
          n localn = n.a(localVastIconXmlManager.e(), localb, localInteger1.intValue(), localInteger2.intValue());
          if (localn != null)
            return new i(localVastIconXmlManager.a().intValue(), localVastIconXmlManager.b().intValue(), localVastIconXmlManager.c(), localVastIconXmlManager.d(), localn, localVastIconXmlManager.f(), localVastIconXmlManager.g(), localVastIconXmlManager.h());
        }
      }
    }
    return null;
  }

  protected void onCancelled()
  {
    b localb = (b)this.b.get();
    if (localb != null)
      localb.onAggregationComplete(null);
  }

  protected void onPreExecute()
  {
    Networking.getUserAgent(this.e);
  }

  static enum a
  {
    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = LANDSCAPE;
      arrayOfa[1] = PORTRAIT;
    }
  }

  static abstract interface b
  {
    public abstract void onAggregationComplete(VastVideoConfig paramVastVideoConfig);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.VastXmlManagerAggregator
 * JD-Core Version:    0.6.2
 */