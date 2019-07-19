package com.viber.voip.sound.ptt;

import android.media.AudioRecord;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.audioptt.b;
import com.viber.voip.audioptt.c;
import java.io.File;

public class AudioPttRecorder
  implements AudioRecorder
{
  private static final Logger L = ViberEnv.getLogger();
  private final Object mControlFlagsGuard = new Object();
  private final AudioPttRecordDelegate mDelegate;
  private int mError = 0;
  private final File mFile;
  private short[] mFrameVolumes;
  private int mFramesCount;
  private short mMaxVolume;
  private b mPttRecWrapper;
  private final Thread mRecThread;
  private AudioRecord mRecorder;
  private boolean mStopCalled;

  public AudioPttRecorder(AudioPttRecordDelegate paramAudioPttRecordDelegate, File paramFile)
  {
    this.mDelegate = paramAudioPttRecordDelegate;
    this.mFile = paramFile;
    this.mFrameVolumes = new short[PttUtils.MAX_PTT_FRAMES_COUNT];
    this.mFramesCount = 0;
    this.mMaxVolume = 0;
    this.mRecThread = new Thread(new Runnable()
    {
      public void run()
      {
        AudioPttRecorder.this.doWritePttDataToFile();
      }
    }
    , "PttRecordThread");
  }

  // ERROR //
  private void doWritePttDataToFile()
  {
    // Byte code:
    //   0: new 97	java/io/BufferedOutputStream
    //   3: dup
    //   4: new 99	java/io/FileOutputStream
    //   7: dup
    //   8: aload_0
    //   9: getfield 51	com/viber/voip/sound/ptt/AudioPttRecorder:mFile	Ljava/io/File;
    //   12: invokespecial 102	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   15: invokespecial 105	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_1
    //   19: aload_0
    //   20: iconst_1
    //   21: invokestatic 111	com/viber/voip/audioptt/b:a	(I)Landroid/media/AudioRecord;
    //   24: putfield 113	com/viber/voip/sound/ptt/AudioPttRecorder:mRecorder	Landroid/media/AudioRecord;
    //   27: aload_0
    //   28: getfield 113	com/viber/voip/sound/ptt/AudioPttRecorder:mRecorder	Landroid/media/AudioRecord;
    //   31: invokevirtual 119	android/media/AudioRecord:getState	()I
    //   34: iconst_1
    //   35: if_icmpeq +39 -> 74
    //   38: aload_0
    //   39: getfield 49	com/viber/voip/sound/ptt/AudioPttRecorder:mDelegate	Lcom/viber/voip/sound/ptt/AudioPttRecordDelegate;
    //   42: iconst_3
    //   43: invokeinterface 125 2 0
    //   48: return
    //   49: astore 7
    //   51: aload_0
    //   52: getfield 49	com/viber/voip/sound/ptt/AudioPttRecorder:mDelegate	Lcom/viber/voip/sound/ptt/AudioPttRecordDelegate;
    //   55: iconst_1
    //   56: invokeinterface 125 2 0
    //   61: return
    //   62: astore_2
    //   63: aload_0
    //   64: getfield 49	com/viber/voip/sound/ptt/AudioPttRecorder:mDelegate	Lcom/viber/voip/sound/ptt/AudioPttRecordDelegate;
    //   67: iconst_3
    //   68: invokeinterface 125 2 0
    //   73: return
    //   74: aload_0
    //   75: new 107	com/viber/voip/audioptt/b
    //   78: dup
    //   79: invokespecial 126	com/viber/voip/audioptt/b:<init>	()V
    //   82: putfield 128	com/viber/voip/sound/ptt/AudioPttRecorder:mPttRecWrapper	Lcom/viber/voip/audioptt/b;
    //   85: aload_0
    //   86: getfield 128	com/viber/voip/sound/ptt/AudioPttRecorder:mPttRecWrapper	Lcom/viber/voip/audioptt/b;
    //   89: new 130	com/viber/voip/sound/ptt/AudioPttRecorder$2
    //   92: dup
    //   93: aload_0
    //   94: invokespecial 131	com/viber/voip/sound/ptt/AudioPttRecorder$2:<init>	(Lcom/viber/voip/sound/ptt/AudioPttRecorder;)V
    //   97: invokevirtual 134	com/viber/voip/audioptt/b:a	(Lcom/viber/voip/audioptt/c;)V
    //   100: aload_0
    //   101: getfield 128	com/viber/voip/sound/ptt/AudioPttRecorder:mPttRecWrapper	Lcom/viber/voip/audioptt/b;
    //   104: aload_0
    //   105: getfield 113	com/viber/voip/sound/ptt/AudioPttRecorder:mRecorder	Landroid/media/AudioRecord;
    //   108: invokevirtual 137	com/viber/voip/audioptt/b:a	(Landroid/media/AudioRecord;)V
    //   111: aload_0
    //   112: getfield 128	com/viber/voip/sound/ptt/AudioPttRecorder:mPttRecWrapper	Lcom/viber/voip/audioptt/b;
    //   115: getstatic 141	com/viber/voip/sound/ptt/PttUtils:MAX_PTT_DURATION_IN_MS	J
    //   118: invokevirtual 144	com/viber/voip/audioptt/b:a	(J)V
    //   121: aload_0
    //   122: getfield 128	com/viber/voip/sound/ptt/AudioPttRecorder:mPttRecWrapper	Lcom/viber/voip/audioptt/b;
    //   125: aload_1
    //   126: invokevirtual 147	com/viber/voip/audioptt/b:a	(Ljava/io/BufferedOutputStream;)V
    //   129: aload_0
    //   130: getfield 113	com/viber/voip/sound/ptt/AudioPttRecorder:mRecorder	Landroid/media/AudioRecord;
    //   133: invokevirtual 150	android/media/AudioRecord:startRecording	()V
    //   136: aload_0
    //   137: getfield 49	com/viber/voip/sound/ptt/AudioPttRecorder:mDelegate	Lcom/viber/voip/sound/ptt/AudioPttRecordDelegate;
    //   140: iconst_0
    //   141: invokeinterface 125 2 0
    //   146: aload_0
    //   147: getfield 128	com/viber/voip/sound/ptt/AudioPttRecorder:mPttRecWrapper	Lcom/viber/voip/audioptt/b;
    //   150: invokevirtual 152	com/viber/voip/audioptt/b:a	()V
    //   153: aload_0
    //   154: getfield 45	com/viber/voip/sound/ptt/AudioPttRecorder:mError	I
    //   157: ifeq +40 -> 197
    //   160: aload_0
    //   161: getfield 49	com/viber/voip/sound/ptt/AudioPttRecorder:mDelegate	Lcom/viber/voip/sound/ptt/AudioPttRecordDelegate;
    //   164: aload_0
    //   165: getfield 45	com/viber/voip/sound/ptt/AudioPttRecorder:mError	I
    //   168: invokeinterface 155 2 0
    //   173: aload_0
    //   174: getfield 113	com/viber/voip/sound/ptt/AudioPttRecorder:mRecorder	Landroid/media/AudioRecord;
    //   177: ifnull +15 -> 192
    //   180: aload_0
    //   181: getfield 113	com/viber/voip/sound/ptt/AudioPttRecorder:mRecorder	Landroid/media/AudioRecord;
    //   184: invokevirtual 158	android/media/AudioRecord:release	()V
    //   187: aload_0
    //   188: aconst_null
    //   189: putfield 113	com/viber/voip/sound/ptt/AudioPttRecorder:mRecorder	Landroid/media/AudioRecord;
    //   192: aload_1
    //   193: invokestatic 163	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   196: return
    //   197: aload_0
    //   198: getfield 165	com/viber/voip/sound/ptt/AudioPttRecorder:mStopCalled	Z
    //   201: istore 5
    //   203: iconst_0
    //   204: istore 6
    //   206: iload 5
    //   208: ifeq +72 -> 280
    //   211: aload_0
    //   212: getfield 49	com/viber/voip/sound/ptt/AudioPttRecorder:mDelegate	Lcom/viber/voip/sound/ptt/AudioPttRecordDelegate;
    //   215: iload 6
    //   217: bipush 20
    //   219: aload_0
    //   220: getfield 60	com/viber/voip/sound/ptt/AudioPttRecorder:mFramesCount	I
    //   223: imul
    //   224: aload_0
    //   225: getfield 58	com/viber/voip/sound/ptt/AudioPttRecorder:mFrameVolumes	[S
    //   228: aload_0
    //   229: getfield 60	com/viber/voip/sound/ptt/AudioPttRecorder:mFramesCount	I
    //   232: aload_0
    //   233: getfield 62	com/viber/voip/sound/ptt/AudioPttRecorder:mMaxVolume	S
    //   236: invokeinterface 169 6 0
    //   241: goto -68 -> 173
    //   244: astore 4
    //   246: aload_0
    //   247: getfield 49	com/viber/voip/sound/ptt/AudioPttRecorder:mDelegate	Lcom/viber/voip/sound/ptt/AudioPttRecordDelegate;
    //   250: iconst_2
    //   251: invokeinterface 155 2 0
    //   256: aload_0
    //   257: getfield 113	com/viber/voip/sound/ptt/AudioPttRecorder:mRecorder	Landroid/media/AudioRecord;
    //   260: ifnull +15 -> 275
    //   263: aload_0
    //   264: getfield 113	com/viber/voip/sound/ptt/AudioPttRecorder:mRecorder	Landroid/media/AudioRecord;
    //   267: invokevirtual 158	android/media/AudioRecord:release	()V
    //   270: aload_0
    //   271: aconst_null
    //   272: putfield 113	com/viber/voip/sound/ptt/AudioPttRecorder:mRecorder	Landroid/media/AudioRecord;
    //   275: aload_1
    //   276: invokestatic 163	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   279: return
    //   280: iconst_1
    //   281: istore 6
    //   283: goto -72 -> 211
    //   286: astore_3
    //   287: aload_0
    //   288: getfield 113	com/viber/voip/sound/ptt/AudioPttRecorder:mRecorder	Landroid/media/AudioRecord;
    //   291: ifnull +15 -> 306
    //   294: aload_0
    //   295: getfield 113	com/viber/voip/sound/ptt/AudioPttRecorder:mRecorder	Landroid/media/AudioRecord;
    //   298: invokevirtual 158	android/media/AudioRecord:release	()V
    //   301: aload_0
    //   302: aconst_null
    //   303: putfield 113	com/viber/voip/sound/ptt/AudioPttRecorder:mRecorder	Landroid/media/AudioRecord;
    //   306: aload_1
    //   307: invokestatic 163	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   310: aload_3
    //   311: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	19	49	java/io/FileNotFoundException
    //   19	27	62	java/lang/IllegalArgumentException
    //   74	173	244	java/lang/Throwable
    //   197	203	244	java/lang/Throwable
    //   211	241	244	java/lang/Throwable
    //   74	173	286	finally
    //   197	203	286	finally
    //   211	241	286	finally
    //   246	256	286	finally
  }

  public void interruptRecord(int paramInt)
  {
    synchronized (this.mControlFlagsGuard)
    {
      if ((this.mPttRecWrapper != null) && (this.mRecorder != null))
      {
        this.mError = paramInt;
        this.mRecorder.stop();
      }
      return;
    }
  }

  public boolean isRecording()
  {
    while (true)
    {
      synchronized (this.mControlFlagsGuard)
      {
        if (this.mRecorder != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }

  public void startRecord()
  {
    synchronized (this.mControlFlagsGuard)
    {
      if ((this.mRecThread != null) && (this.mRecThread.getState() == Thread.State.NEW))
        this.mRecThread.start();
      return;
    }
  }

  public void stopRecord()
  {
    synchronized (this.mControlFlagsGuard)
    {
      if ((this.mPttRecWrapper != null) && (this.mRecorder != null))
        this.mStopCalled = true;
    }
    try
    {
      this.mRecorder.stop();
      label33: return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      break label33;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.ptt.AudioPttRecorder
 * JD-Core Version:    0.6.2
 */