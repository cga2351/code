package com.facebook.react.devsupport;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.common.logging.FLog;
import com.facebook.react.R.id;
import com.facebook.react.R.layout;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.debug.FpsDebugFrameCallback;
import java.util.Locale;

public class FpsView extends FrameLayout
{
  private static final int UPDATE_INTERVAL_MS = 500;
  private final FPSMonitorRunnable mFPSMonitorRunnable;
  private final FpsDebugFrameCallback mFrameCallback;
  private final TextView mTextView;

  public FpsView(ReactContext paramReactContext)
  {
    super(paramReactContext);
    inflate(paramReactContext, R.layout.fps_view, this);
    this.mTextView = ((TextView)findViewById(R.id.fps_text));
    this.mFrameCallback = new FpsDebugFrameCallback(paramReactContext);
    this.mFPSMonitorRunnable = new FPSMonitorRunnable(null);
    setCurrentFPS(0.0D, 0.0D, 0, 0);
  }

  private void setCurrentFPS(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2)
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Double.valueOf(paramDouble1);
    arrayOfObject[1] = Integer.valueOf(paramInt1);
    arrayOfObject[2] = Integer.valueOf(paramInt2);
    arrayOfObject[3] = Double.valueOf(paramDouble2);
    String str = String.format(localLocale, "UI: %.1f fps\n%d dropped so far\n%d stutters (4+) so far\nJS: %.1f fps", arrayOfObject);
    this.mTextView.setText(str);
    FLog.d("ReactNative", str);
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mFrameCallback.reset();
    this.mFrameCallback.start();
    this.mFPSMonitorRunnable.start();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mFrameCallback.stop();
    this.mFPSMonitorRunnable.stop();
  }

  private class FPSMonitorRunnable
    implements Runnable
  {
    private boolean mShouldStop = false;
    private int mTotal4PlusFrameStutters = 0;
    private int mTotalFramesDropped = 0;

    private FPSMonitorRunnable()
    {
    }

    public void run()
    {
      if (this.mShouldStop)
        return;
      this.mTotalFramesDropped += FpsView.this.mFrameCallback.getExpectedNumFrames() - FpsView.this.mFrameCallback.getNumFrames();
      this.mTotal4PlusFrameStutters += FpsView.this.mFrameCallback.get4PlusFrameStutters();
      FpsView.this.setCurrentFPS(FpsView.this.mFrameCallback.getFPS(), FpsView.this.mFrameCallback.getJSFPS(), this.mTotalFramesDropped, this.mTotal4PlusFrameStutters);
      FpsView.this.mFrameCallback.reset();
      FpsView.this.postDelayed(this, 500L);
    }

    public void start()
    {
      this.mShouldStop = false;
      FpsView.this.post(this);
    }

    public void stop()
    {
      this.mShouldStop = true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.FpsView
 * JD-Core Version:    0.6.2
 */