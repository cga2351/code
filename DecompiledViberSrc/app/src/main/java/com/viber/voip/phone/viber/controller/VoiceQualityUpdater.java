package com.viber.voip.phone.viber.controller;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.jni.QualityScore;
import com.viber.jni.QualityScore.IQualityScoreClient;
import com.viber.jni.QualityScore.IQualityScoreClient..CC;
import com.viber.jni.dialer.DialerController;
import com.viber.voip.R.color;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.InCallState;

public class VoiceQualityUpdater
  implements QualityScore.IQualityScoreClient
{
  private static final Logger L = ViberEnv.getLogger();
  private static int[] QUALITY_COLORS;
  private static int[] QUALITY_TITLES = arrayOfInt2;
  private static final int UPDATE_INTERVAL_MS = 1000;
  private CallHandler mCallHandler;
  private volatile int mCallQuality;
  private DialerController mDialerController;
  private boolean mShowCallStats = false;
  private TextView mView;
  private QualityScore qualityScore = null;
  private Handler uiThreadHandler;

  static
  {
    int[] arrayOfInt1 = new int[4];
    arrayOfInt1[0] = R.color.excelent;
    arrayOfInt1[1] = R.color.average;
    arrayOfInt1[2] = R.color.poor;
    arrayOfInt1[3] = R.color.poor;
    QUALITY_COLORS = arrayOfInt1;
    int[] arrayOfInt2 = new int[4];
    arrayOfInt2[0] = R.string.excellent;
    arrayOfInt2[1] = R.string.average;
    arrayOfInt2[2] = R.string.poor;
    arrayOfInt2[3] = R.string.connection_lost;
  }

  public VoiceQualityUpdater(CallHandler paramCallHandler, DialerController paramDialerController)
  {
    this.mCallHandler = paramCallHandler;
    this.mDialerController = paramDialerController;
    this.mShowCallStats = false;
    this.uiThreadHandler = av.a(av.e.a);
  }

  private static void forwardActionTo(Handler paramHandler, Runnable paramRunnable)
  {
    if (Thread.currentThread() == paramHandler.getLooper().getThread())
    {
      paramRunnable.run();
      return;
    }
    paramHandler.post(paramRunnable);
  }

  private int getFormattedQuality(int paramInt)
  {
    CallInfo localCallInfo = this.mCallHandler.getCallInfo();
    if ((localCallInfo != null) && (localCallInfo.getInCallState().isDataInterrupted()))
      return 3;
    if (paramInt < 4)
      return 2;
    if (paramInt < 7)
      return 1;
    return 0;
  }

  private void updateQuality(final TextView paramTextView)
  {
    if (paramTextView != null)
    {
      final String str = paramTextView.getResources().getString(QUALITY_TITLES[this.mCallQuality]);
      forwardActionTo(this.uiThreadHandler, new Runnable()
      {
        public void run()
        {
          paramTextView.setText(str);
          paramTextView.setTextColor(paramTextView.getResources().getColor(VoiceQualityUpdater.QUALITY_COLORS[VoiceQualityUpdater.this.mCallQuality]));
        }
      });
    }
  }

  protected void finalize()
    throws Throwable
  {
    if (this.qualityScore != null)
    {
      this.qualityScore.dispose();
      this.qualityScore = null;
    }
    super.finalize();
  }

  public void onQualityScoreUpdated(int paramInt1, int paramInt2)
  {
    this.mCallQuality = getFormattedQuality(paramInt2);
    this.mDialerController.setupVoiceQuality(paramInt2);
    updateQuality(this.mView);
  }

  public void onRawQualityScore(int paramInt)
  {
    QualityScore.IQualityScoreClient..CC.onRawQualityScore(this, paramInt);
  }

  public void setQualityTextView(TextView paramTextView)
  {
    this.mView = paramTextView;
    updateQuality(this.mView);
  }

  public void start()
  {
    try
    {
      if (this.qualityScore == null)
        this.qualityScore = new QualityScore(this, 1000);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void stop()
  {
    try
    {
      QualityScore localQualityScore = this.qualityScore;
      if (localQualityScore == null);
      while (true)
      {
        return;
        this.qualityScore.removeNotifier(this);
        this.qualityScore.dispose();
        this.qualityScore = null;
      }
    }
    finally
    {
    }
  }

  public void updateQuality()
  {
    if (this.qualityScore != null)
    {
      this.mCallQuality = getFormattedQuality(this.qualityScore.getLastQuality());
      updateQuality(this.mView);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.controller.VoiceQualityUpdater
 * JD-Core Version:    0.6.2
 */