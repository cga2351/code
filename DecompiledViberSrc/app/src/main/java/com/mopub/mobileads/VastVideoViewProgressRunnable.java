package com.mopub.mobileads;

import android.os.Handler;
import com.mopub.common.ExternalViewabilitySession.VideoEvent;
import com.mopub.common.Preconditions;
import com.mopub.network.TrackingRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VastVideoViewProgressRunnable extends RepeatingHandlerRunnable
{
  private final VastVideoViewController c;
  private final VastVideoConfig d;

  public VastVideoViewProgressRunnable(VastVideoViewController paramVastVideoViewController, VastVideoConfig paramVastVideoConfig, Handler paramHandler)
  {
    super(paramHandler);
    Preconditions.checkNotNull(paramVastVideoViewController);
    Preconditions.checkNotNull(paramVastVideoConfig);
    this.c = paramVastVideoViewController;
    this.d = paramVastVideoConfig;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new VastFractionalProgressTracker(VastTracker.a.QUARTILE_EVENT, ExternalViewabilitySession.VideoEvent.AD_STARTED.name(), 0.0F));
    localArrayList.add(new VastFractionalProgressTracker(VastTracker.a.QUARTILE_EVENT, ExternalViewabilitySession.VideoEvent.AD_IMPRESSED.name(), 0.0F));
    localArrayList.add(new VastFractionalProgressTracker(VastTracker.a.QUARTILE_EVENT, ExternalViewabilitySession.VideoEvent.AD_VIDEO_FIRST_QUARTILE.name(), 0.25F));
    localArrayList.add(new VastFractionalProgressTracker(VastTracker.a.QUARTILE_EVENT, ExternalViewabilitySession.VideoEvent.AD_VIDEO_MIDPOINT.name(), 0.5F));
    localArrayList.add(new VastFractionalProgressTracker(VastTracker.a.QUARTILE_EVENT, ExternalViewabilitySession.VideoEvent.AD_VIDEO_THIRD_QUARTILE.name(), 0.75F));
    this.d.addFractionalTrackers(localArrayList);
  }

  public void doWork()
  {
    int i = this.c.i();
    int j = this.c.j();
    this.c.n();
    if (i > 0)
    {
      List localList = this.d.getUntriggeredTrackersBefore(j, i);
      if (!localList.isEmpty())
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = localList.iterator();
        if (localIterator.hasNext())
        {
          VastTracker localVastTracker = (VastTracker)localIterator.next();
          if (localVastTracker.getMessageType() == VastTracker.a.TRACKING_URL)
            localArrayList.add(localVastTracker.getContent());
          while (true)
          {
            localVastTracker.setTracked();
            break;
            if (localVastTracker.getMessageType() == VastTracker.a.QUARTILE_EVENT)
              this.c.b(localVastTracker.getContent());
          }
        }
        TrackingRequest.makeTrackingHttpRequest(new VastMacroHelper(localArrayList).withAssetUri(this.c.o()).withContentPlayHead(Integer.valueOf(j)).getUris(), this.c.h());
      }
      this.c.a(j);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.VastVideoViewProgressRunnable
 * JD-Core Version:    0.6.2
 */