package com.viber.voip.phone.viber;

import com.viber.dexshared.Logger;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.ViberEnv;
import com.viber.voip.i.f;

public class UiDisplayedDuringCallAnalyticManager
{
  private static final Logger L = ViberEnv.getLogger();
  private static final long REPORT_THRESHOLD_IN_SEC = 5L;
  private long mCallToken;
  private final ICdrController mCdrController;
  private final f mFeatureSwitcher;
  private boolean mIsUiVisible;
  private long mUiVisibleStartInCallTimeSec;

  public UiDisplayedDuringCallAnalyticManager(ICdrController paramICdrController, f paramf)
  {
    this.mCdrController = paramICdrController;
    this.mFeatureSwitcher = paramf;
  }

  public void onCallUiGone(long paramLong)
  {
    if (!this.mFeatureSwitcher.e());
    while (!this.mIsUiVisible)
      return;
    long l = paramLong - this.mUiVisibleStartInCallTimeSec;
    if (l >= 5L)
      this.mCdrController.handleReportUiDisplayedDuringCall(this.mCallToken, l, this.mUiVisibleStartInCallTimeSec);
    this.mIsUiVisible = false;
  }

  public void onCallUiVisible(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.mFeatureSwitcher.e());
    while ((paramBoolean1) || (paramBoolean2))
      return;
    this.mCallToken = paramLong1;
    this.mUiVisibleStartInCallTimeSec = paramLong2;
    this.mIsUiVisible = true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.UiDisplayedDuringCallAnalyticManager
 * JD-Core Version:    0.6.2
 */