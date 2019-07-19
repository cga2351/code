package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.internal.ads.zzare;
import java.util.Map;

@zzare
@Deprecated
public class NativeAdMapper
{
  protected View mAdChoicesContent;
  protected Bundle mExtras = new Bundle();
  protected boolean mOverrideClickHandling;
  protected boolean mOverrideImpressionRecording;
  private VideoController zzcjf;
  private View zzenc;
  private boolean zzend;

  public View getAdChoicesContent()
  {
    return this.mAdChoicesContent;
  }

  public final Bundle getExtras()
  {
    return this.mExtras;
  }

  public final boolean getOverrideClickHandling()
  {
    return this.mOverrideClickHandling;
  }

  public final boolean getOverrideImpressionRecording()
  {
    return this.mOverrideImpressionRecording;
  }

  public final VideoController getVideoController()
  {
    return this.zzcjf;
  }

  public void handleClick(View paramView)
  {
  }

  public boolean hasVideoContent()
  {
    return this.zzend;
  }

  public void recordImpression()
  {
  }

  public void setAdChoicesContent(View paramView)
  {
    this.mAdChoicesContent = paramView;
  }

  public final void setExtras(Bundle paramBundle)
  {
    this.mExtras = paramBundle;
  }

  public void setHasVideoContent(boolean paramBoolean)
  {
    this.zzend = paramBoolean;
  }

  public void setMediaView(View paramView)
  {
    this.zzenc = paramView;
  }

  public final void setOverrideClickHandling(boolean paramBoolean)
  {
    this.mOverrideClickHandling = paramBoolean;
  }

  public final void setOverrideImpressionRecording(boolean paramBoolean)
  {
    this.mOverrideImpressionRecording = paramBoolean;
  }

  @Deprecated
  public void trackView(View paramView)
  {
  }

  public void trackViews(View paramView, Map<String, View> paramMap1, Map<String, View> paramMap2)
  {
  }

  public void untrackView(View paramView)
  {
  }

  public final void zza(VideoController paramVideoController)
  {
    this.zzcjf = paramVideoController;
  }

  public final View zzacd()
  {
    return this.zzenc;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.NativeAdMapper
 * JD-Core Version:    0.6.2
 */