package com.viber.voip.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.Chronometer;
import android.widget.Chronometer.OnChronometerTickListener;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.d.a;
import java.util.Formatter;
import java.util.Locale;

public class PausableChronometer extends Chronometer
{
  private static final Logger L = ViberEnv.getLogger();
  private static final int TICK_WHAT = 2;
  private long mBase;
  private String mFormat;
  private StringBuilder mFormatBuilder;
  private Formatter mFormatter;
  private Object[] mFormatterArgs = new Object[1];
  private Locale mFormatterLocale;
  private Handler mHandler = new a(this, null);
  private boolean mRunning;
  private boolean mStarted;
  private boolean mVisible;
  private Long pausedTime;

  public PausableChronometer(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public PausableChronometer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public PausableChronometer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setFormat(paramContext.getString(R.string.chronometer_initial_format));
    init();
  }

  private static long syncDelay()
  {
    long l = SystemClock.elapsedRealtime();
    return 1000L + l - l;
  }

  private void updateRunning()
  {
    boolean bool;
    if ((this.mVisible) && (this.mStarted))
    {
      bool = true;
      if (bool != this.mRunning)
      {
        if (!bool)
          break label69;
        updateText(SystemClock.elapsedRealtime());
        dispatchChronometerTick();
        this.mHandler.sendMessageDelayed(Message.obtain(this.mHandler, 2), syncDelay());
      }
    }
    while (true)
    {
      this.mRunning = bool;
      return;
      bool = false;
      break;
      label69: this.mHandler.removeMessages(2);
    }
  }

  // ERROR //
  private void updateText(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: lload_1
    //   3: aload_0
    //   4: invokevirtual 126	com/viber/voip/widget/PausableChronometer:getBase	()J
    //   7: lsub
    //   8: ldc2_w 96
    //   11: ldiv
    //   12: invokestatic 132	com/viber/voip/util/ae:g	(J)Ljava/lang/String;
    //   15: astore 4
    //   17: aload_0
    //   18: getfield 134	com/viber/voip/widget/PausableChronometer:mFormat	Ljava/lang/String;
    //   21: ifnull +95 -> 116
    //   24: invokestatic 140	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   27: astore 5
    //   29: aload_0
    //   30: getfield 142	com/viber/voip/widget/PausableChronometer:mFormatter	Ljava/util/Formatter;
    //   33: ifnull +15 -> 48
    //   36: aload 5
    //   38: aload_0
    //   39: getfield 144	com/viber/voip/widget/PausableChronometer:mFormatterLocale	Ljava/util/Locale;
    //   42: invokevirtual 148	java/util/Locale:equals	(Ljava/lang/Object;)Z
    //   45: ifne +26 -> 71
    //   48: aload_0
    //   49: aload 5
    //   51: putfield 144	com/viber/voip/widget/PausableChronometer:mFormatterLocale	Ljava/util/Locale;
    //   54: aload_0
    //   55: new 150	java/util/Formatter
    //   58: dup
    //   59: aload_0
    //   60: getfield 152	com/viber/voip/widget/PausableChronometer:mFormatBuilder	Ljava/lang/StringBuilder;
    //   63: aload 5
    //   65: invokespecial 155	java/util/Formatter:<init>	(Ljava/lang/Appendable;Ljava/util/Locale;)V
    //   68: putfield 142	com/viber/voip/widget/PausableChronometer:mFormatter	Ljava/util/Formatter;
    //   71: aload_0
    //   72: getfield 152	com/viber/voip/widget/PausableChronometer:mFormatBuilder	Ljava/lang/StringBuilder;
    //   75: iconst_0
    //   76: invokevirtual 160	java/lang/StringBuilder:setLength	(I)V
    //   79: aload_0
    //   80: getfield 50	com/viber/voip/widget/PausableChronometer:mFormatterArgs	[Ljava/lang/Object;
    //   83: iconst_0
    //   84: aload 4
    //   86: aastore
    //   87: aload_0
    //   88: getfield 142	com/viber/voip/widget/PausableChronometer:mFormatter	Ljava/util/Formatter;
    //   91: aload_0
    //   92: getfield 134	com/viber/voip/widget/PausableChronometer:mFormat	Ljava/lang/String;
    //   95: aload_0
    //   96: getfield 50	com/viber/voip/widget/PausableChronometer:mFormatterArgs	[Ljava/lang/Object;
    //   99: invokevirtual 164	java/util/Formatter:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/util/Formatter;
    //   102: pop
    //   103: aload_0
    //   104: getfield 152	com/viber/voip/widget/PausableChronometer:mFormatBuilder	Ljava/lang/StringBuilder;
    //   107: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: astore 8
    //   112: aload 8
    //   114: astore 4
    //   116: aload_0
    //   117: aload 4
    //   119: invokevirtual 172	com/viber/voip/widget/PausableChronometer:setText	(Ljava/lang/CharSequence;)V
    //   122: aload_0
    //   123: monitorexit
    //   124: return
    //   125: astore_3
    //   126: aload_0
    //   127: monitorexit
    //   128: aload_3
    //   129: athrow
    //   130: astore 6
    //   132: goto -16 -> 116
    //
    // Exception table:
    //   from	to	target	type
    //   2	48	125	finally
    //   48	71	125	finally
    //   71	87	125	finally
    //   87	112	125	finally
    //   116	122	125	finally
    //   87	112	130	java/util/IllegalFormatException
  }

  void dispatchChronometerTick()
  {
    if (getOnChronometerTickListener() != null)
      getOnChronometerTickListener().onChronometerTick(this);
  }

  public long getBase()
  {
    return this.mBase;
  }

  public long getTime()
  {
    return SystemClock.elapsedRealtime() - getBase();
  }

  public void init()
  {
    this.mBase = SystemClock.elapsedRealtime();
    updateText(this.mBase);
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mVisible = false;
    updateRunning();
  }

  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    if (paramInt == 0);
    for (boolean bool = true; ; bool = false)
    {
      this.mVisible = bool;
      updateRunning();
      return;
    }
  }

  public void pause()
  {
    if (this.pausedTime == null)
    {
      this.pausedTime = Long.valueOf(SystemClock.elapsedRealtime() - getBase());
      stop();
    }
  }

  public void resume()
  {
    if (this.pausedTime != null)
    {
      start();
      this.pausedTime = null;
    }
  }

  public void setBase(long paramLong)
  {
    this.mBase = paramLong;
    dispatchChronometerTick();
    updateText(SystemClock.elapsedRealtime());
  }

  public void setFormat(String paramString)
  {
    this.mFormat = paramString;
    if ((paramString != null) && (this.mFormatBuilder == null))
      this.mFormatBuilder = new StringBuilder(2 * paramString.length());
  }

  public void setStarted(boolean paramBoolean)
  {
    this.mStarted = paramBoolean;
    updateRunning();
  }

  public void start()
  {
    this.mStarted = true;
    updateRunning();
  }

  public void stop()
  {
    this.mStarted = false;
    updateRunning();
  }

  private static class a extends a<PausableChronometer>
  {
    private a(PausableChronometer paramPausableChronometer)
    {
      super();
    }

    public void a(PausableChronometer paramPausableChronometer, Message paramMessage)
    {
      if (paramPausableChronometer.mRunning)
      {
        paramPausableChronometer.updateText(SystemClock.elapsedRealtime());
        paramPausableChronometer.dispatchChronometerTick();
        sendMessageDelayed(Message.obtain(this, 2), PausableChronometer.access$300());
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.PausableChronometer
 * JD-Core Version:    0.6.2
 */