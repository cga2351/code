package com.viber.voip.sound.ptt;

import android.media.AudioTrack;
import android.media.AudioTrack.OnPlaybackPositionUpdateListener;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.audioptt.a;
import com.viber.voip.q.e;
import com.viber.voip.q.g;
import java.io.File;
import java.io.IOException;
import org.greenrobot.eventbus.EventBus;

public class AudioPttPlayer
  implements AudioTrack.OnPlaybackPositionUpdateListener, AudioPlayer
{
  private static final Logger L = ViberEnv.getLogger();
  private final int PROGRESS_REPORT_PERIOD_IN_FRAMES = 3200;
  private final int PROGRESS_REPORT_PERIOD_IN_MS = 200;
  private final File mAudioPttFile;
  private final Object mControlFlagsGuard = new Object();
  private final String mCurrentPttId;
  private final int mDefaultAudioStream;
  private boolean mInterruptionOccured = false;
  private final Thread mPlayThread;
  private boolean mPlayToSpeaker = true;
  private final EventBus mPlayerBus;
  private a mPttPlayer;
  private long mStartPositionMs = 0L;
  private int mStopReason = 0;
  private AudioTrack mTrack;

  public AudioPttPlayer(EventBus paramEventBus, String paramString, File paramFile, int paramInt)
  {
    this.mPlayerBus = paramEventBus;
    this.mCurrentPttId = paramString;
    this.mAudioPttFile = paramFile;
    this.mPlayToSpeaker = true;
    this.mDefaultAudioStream = paramInt;
    this.mPlayThread = new Thread(new Runnable()
    {
      public void run()
      {
        AudioPttPlayer.this.doReadPttDataFromFile();
      }
    }
    , "PttPlayThread");
  }

  // ERROR //
  private void doReadPttDataFromFile()
  {
    // Byte code:
    //   0: new 98	java/io/BufferedInputStream
    //   3: dup
    //   4: new 100	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: getfield 68	com/viber/voip/sound/ptt/AudioPttPlayer:mAudioPttFile	Ljava/io/File;
    //   12: invokespecial 103	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: invokespecial 106	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: astore_1
    //   19: aload_0
    //   20: aload_0
    //   21: getfield 70	com/viber/voip/sound/ptt/AudioPttPlayer:mDefaultAudioStream	I
    //   24: invokestatic 112	com/viber/voip/audioptt/a:c	(I)Landroid/media/AudioTrack;
    //   27: putfield 114	com/viber/voip/sound/ptt/AudioPttPlayer:mTrack	Landroid/media/AudioTrack;
    //   30: aload_0
    //   31: getfield 114	com/viber/voip/sound/ptt/AudioPttPlayer:mTrack	Landroid/media/AudioTrack;
    //   34: invokevirtual 120	android/media/AudioTrack:getState	()I
    //   37: iconst_1
    //   38: if_icmpeq +56 -> 94
    //   41: aload_0
    //   42: getfield 64	com/viber/voip/sound/ptt/AudioPttPlayer:mPlayerBus	Lorg/greenrobot/eventbus/EventBus;
    //   45: aload_0
    //   46: getfield 66	com/viber/voip/sound/ptt/AudioPttPlayer:mCurrentPttId	Ljava/lang/String;
    //   49: bipush 6
    //   51: invokestatic 126	com/viber/voip/q/g:a	(Ljava/lang/String;I)Lcom/viber/voip/q/g;
    //   54: invokevirtual 132	org/greenrobot/eventbus/EventBus:post	(Ljava/lang/Object;)V
    //   57: return
    //   58: astore 12
    //   60: aload_0
    //   61: getfield 64	com/viber/voip/sound/ptt/AudioPttPlayer:mPlayerBus	Lorg/greenrobot/eventbus/EventBus;
    //   64: aload_0
    //   65: getfield 66	com/viber/voip/sound/ptt/AudioPttPlayer:mCurrentPttId	Ljava/lang/String;
    //   68: iconst_3
    //   69: invokestatic 126	com/viber/voip/q/g:a	(Ljava/lang/String;I)Lcom/viber/voip/q/g;
    //   72: invokevirtual 132	org/greenrobot/eventbus/EventBus:post	(Ljava/lang/Object;)V
    //   75: return
    //   76: astore_2
    //   77: aload_0
    //   78: getfield 64	com/viber/voip/sound/ptt/AudioPttPlayer:mPlayerBus	Lorg/greenrobot/eventbus/EventBus;
    //   81: aload_0
    //   82: getfield 66	com/viber/voip/sound/ptt/AudioPttPlayer:mCurrentPttId	Ljava/lang/String;
    //   85: bipush 6
    //   87: invokestatic 126	com/viber/voip/q/g:a	(Ljava/lang/String;I)Lcom/viber/voip/q/g;
    //   90: invokevirtual 132	org/greenrobot/eventbus/EventBus:post	(Ljava/lang/Object;)V
    //   93: return
    //   94: aload_0
    //   95: new 108	com/viber/voip/audioptt/a
    //   98: dup
    //   99: invokespecial 133	com/viber/voip/audioptt/a:<init>	()V
    //   102: putfield 135	com/viber/voip/sound/ptt/AudioPttPlayer:mPttPlayer	Lcom/viber/voip/audioptt/a;
    //   105: aload_0
    //   106: getfield 54	com/viber/voip/sound/ptt/AudioPttPlayer:mStartPositionMs	J
    //   109: lconst_0
    //   110: lcmp
    //   111: ifne +140 -> 251
    //   114: aload_0
    //   115: getfield 135	com/viber/voip/sound/ptt/AudioPttPlayer:mPttPlayer	Lcom/viber/voip/audioptt/a;
    //   118: aload_1
    //   119: iconst_1
    //   120: invokevirtual 138	com/viber/voip/audioptt/a:a	(Ljava/io/InputStream;Z)V
    //   123: aload_0
    //   124: getfield 135	com/viber/voip/sound/ptt/AudioPttPlayer:mPttPlayer	Lcom/viber/voip/audioptt/a;
    //   127: aload_0
    //   128: getfield 114	com/viber/voip/sound/ptt/AudioPttPlayer:mTrack	Landroid/media/AudioTrack;
    //   131: invokevirtual 141	com/viber/voip/audioptt/a:a	(Landroid/media/AudioTrack;)V
    //   134: aload_0
    //   135: getfield 114	com/viber/voip/sound/ptt/AudioPttPlayer:mTrack	Landroid/media/AudioTrack;
    //   138: sipush 3200
    //   141: invokevirtual 145	android/media/AudioTrack:setPositionNotificationPeriod	(I)I
    //   144: pop
    //   145: aload_0
    //   146: getfield 114	com/viber/voip/sound/ptt/AudioPttPlayer:mTrack	Landroid/media/AudioTrack;
    //   149: aload_0
    //   150: invokevirtual 149	android/media/AudioTrack:setPlaybackPositionUpdateListener	(Landroid/media/AudioTrack$OnPlaybackPositionUpdateListener;)V
    //   153: aload_0
    //   154: getfield 114	com/viber/voip/sound/ptt/AudioPttPlayer:mTrack	Landroid/media/AudioTrack;
    //   157: invokevirtual 152	android/media/AudioTrack:play	()V
    //   160: aload_0
    //   161: getfield 64	com/viber/voip/sound/ptt/AudioPttPlayer:mPlayerBus	Lorg/greenrobot/eventbus/EventBus;
    //   164: aload_0
    //   165: getfield 66	com/viber/voip/sound/ptt/AudioPttPlayer:mCurrentPttId	Ljava/lang/String;
    //   168: aload_0
    //   169: getfield 54	com/viber/voip/sound/ptt/AudioPttPlayer:mStartPositionMs	J
    //   172: invokestatic 155	com/viber/voip/q/g:a	(Ljava/lang/String;J)Lcom/viber/voip/q/g;
    //   175: invokevirtual 132	org/greenrobot/eventbus/EventBus:post	(Ljava/lang/Object;)V
    //   178: aload_0
    //   179: getfield 135	com/viber/voip/sound/ptt/AudioPttPlayer:mPttPlayer	Lcom/viber/voip/audioptt/a;
    //   182: invokevirtual 158	com/viber/voip/audioptt/a:h	()V
    //   185: aload_1
    //   186: invokestatic 163	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   189: aload_0
    //   190: getfield 62	com/viber/voip/sound/ptt/AudioPttPlayer:mControlFlagsGuard	Ljava/lang/Object;
    //   193: astore 6
    //   195: aload 6
    //   197: monitorenter
    //   198: aload_0
    //   199: getfield 58	com/viber/voip/sound/ptt/AudioPttPlayer:mInterruptionOccured	Z
    //   202: ifne +8 -> 210
    //   205: aload_0
    //   206: iconst_2
    //   207: putfield 60	com/viber/voip/sound/ptt/AudioPttPlayer:mStopReason	I
    //   210: aload_0
    //   211: getfield 64	com/viber/voip/sound/ptt/AudioPttPlayer:mPlayerBus	Lorg/greenrobot/eventbus/EventBus;
    //   214: aload_0
    //   215: getfield 66	com/viber/voip/sound/ptt/AudioPttPlayer:mCurrentPttId	Ljava/lang/String;
    //   218: aload_0
    //   219: getfield 60	com/viber/voip/sound/ptt/AudioPttPlayer:mStopReason	I
    //   222: invokestatic 126	com/viber/voip/q/g:a	(Ljava/lang/String;I)Lcom/viber/voip/q/g;
    //   225: invokevirtual 132	org/greenrobot/eventbus/EventBus:post	(Ljava/lang/Object;)V
    //   228: aload 6
    //   230: monitorexit
    //   231: aload_0
    //   232: getfield 114	com/viber/voip/sound/ptt/AudioPttPlayer:mTrack	Landroid/media/AudioTrack;
    //   235: ifnull -178 -> 57
    //   238: aload_0
    //   239: getfield 114	com/viber/voip/sound/ptt/AudioPttPlayer:mTrack	Landroid/media/AudioTrack;
    //   242: invokevirtual 166	android/media/AudioTrack:release	()V
    //   245: aload_0
    //   246: aconst_null
    //   247: putfield 114	com/viber/voip/sound/ptt/AudioPttPlayer:mTrack	Landroid/media/AudioTrack;
    //   250: return
    //   251: aload_0
    //   252: getfield 135	com/viber/voip/sound/ptt/AudioPttPlayer:mPttPlayer	Lcom/viber/voip/audioptt/a;
    //   255: aload_1
    //   256: aload_0
    //   257: getfield 54	com/viber/voip/sound/ptt/AudioPttPlayer:mStartPositionMs	J
    //   260: invokevirtual 169	com/viber/voip/audioptt/a:a	(Ljava/io/InputStream;J)V
    //   263: goto -140 -> 123
    //   266: astore 8
    //   268: aload_0
    //   269: getfield 62	com/viber/voip/sound/ptt/AudioPttPlayer:mControlFlagsGuard	Ljava/lang/Object;
    //   272: astore 9
    //   274: aload 9
    //   276: monitorenter
    //   277: aload_0
    //   278: iconst_1
    //   279: putfield 58	com/viber/voip/sound/ptt/AudioPttPlayer:mInterruptionOccured	Z
    //   282: aload_0
    //   283: iconst_1
    //   284: putfield 60	com/viber/voip/sound/ptt/AudioPttPlayer:mStopReason	I
    //   287: aload 9
    //   289: monitorexit
    //   290: goto -105 -> 185
    //   293: astore 10
    //   295: aload 9
    //   297: monitorexit
    //   298: aload 10
    //   300: athrow
    //   301: astore 5
    //   303: aload_0
    //   304: getfield 64	com/viber/voip/sound/ptt/AudioPttPlayer:mPlayerBus	Lorg/greenrobot/eventbus/EventBus;
    //   307: aload_0
    //   308: getfield 66	com/viber/voip/sound/ptt/AudioPttPlayer:mCurrentPttId	Ljava/lang/String;
    //   311: iconst_1
    //   312: invokestatic 126	com/viber/voip/q/g:a	(Ljava/lang/String;I)Lcom/viber/voip/q/g;
    //   315: invokevirtual 132	org/greenrobot/eventbus/EventBus:post	(Ljava/lang/Object;)V
    //   318: aload_0
    //   319: getfield 114	com/viber/voip/sound/ptt/AudioPttPlayer:mTrack	Landroid/media/AudioTrack;
    //   322: ifnull -265 -> 57
    //   325: aload_0
    //   326: getfield 114	com/viber/voip/sound/ptt/AudioPttPlayer:mTrack	Landroid/media/AudioTrack;
    //   329: invokevirtual 166	android/media/AudioTrack:release	()V
    //   332: aload_0
    //   333: aconst_null
    //   334: putfield 114	com/viber/voip/sound/ptt/AudioPttPlayer:mTrack	Landroid/media/AudioTrack;
    //   337: return
    //   338: astore 7
    //   340: aload 6
    //   342: monitorexit
    //   343: aload 7
    //   345: athrow
    //   346: astore 4
    //   348: aload_0
    //   349: getfield 114	com/viber/voip/sound/ptt/AudioPttPlayer:mTrack	Landroid/media/AudioTrack;
    //   352: ifnull +15 -> 367
    //   355: aload_0
    //   356: getfield 114	com/viber/voip/sound/ptt/AudioPttPlayer:mTrack	Landroid/media/AudioTrack;
    //   359: invokevirtual 166	android/media/AudioTrack:release	()V
    //   362: aload_0
    //   363: aconst_null
    //   364: putfield 114	com/viber/voip/sound/ptt/AudioPttPlayer:mTrack	Landroid/media/AudioTrack;
    //   367: aload 4
    //   369: athrow
    //   370: astore_3
    //   371: goto -186 -> 185
    //
    // Exception table:
    //   from	to	target	type
    //   0	19	58	java/io/IOException
    //   19	30	76	java/lang/IllegalArgumentException
    //   94	123	266	java/io/IOException
    //   123	185	266	java/io/IOException
    //   251	263	266	java/io/IOException
    //   277	290	293	finally
    //   295	298	293	finally
    //   94	123	301	java/lang/IllegalStateException
    //   123	185	301	java/lang/IllegalStateException
    //   185	198	301	java/lang/IllegalStateException
    //   251	263	301	java/lang/IllegalStateException
    //   268	277	301	java/lang/IllegalStateException
    //   298	301	301	java/lang/IllegalStateException
    //   343	346	301	java/lang/IllegalStateException
    //   198	210	338	finally
    //   210	231	338	finally
    //   340	343	338	finally
    //   94	123	346	finally
    //   123	185	346	finally
    //   185	198	346	finally
    //   251	263	346	finally
    //   268	277	346	finally
    //   298	301	346	finally
    //   303	318	346	finally
    //   343	346	346	finally
    //   94	123	370	java/lang/RuntimeException
    //   123	185	370	java/lang/RuntimeException
    //   251	263	370	java/lang/RuntimeException
  }

  public long getPlayingPositionInMillis()
  {
    if (this.mPttPlayer != null)
      return this.mPttPlayer.c();
    return 0L;
  }

  public void interruptPlay(int paramInt)
  {
    synchronized (this.mControlFlagsGuard)
    {
      if ((!this.mInterruptionOccured) && (this.mPttPlayer != null))
      {
        this.mInterruptionOccured = true;
        this.mStopReason = paramInt;
        this.mPttPlayer.e();
      }
      return;
    }
  }

  public boolean isPaused()
  {
    synchronized (this.mControlFlagsGuard)
    {
      AudioTrack localAudioTrack = this.mTrack;
      boolean bool = false;
      if (localAudioTrack != null)
      {
        a locala = this.mPttPlayer;
        bool = false;
        if (locala != null)
        {
          int i = this.mTrack.getPlayState();
          bool = false;
          if (i == 2)
            bool = true;
        }
      }
      return bool;
    }
  }

  public boolean isPlaying()
  {
    synchronized (this.mControlFlagsGuard)
    {
      AudioTrack localAudioTrack = this.mTrack;
      boolean bool = false;
      if (localAudioTrack != null)
      {
        a locala = this.mPttPlayer;
        bool = false;
        if (locala != null)
        {
          int i = this.mTrack.getPlayState();
          bool = false;
          if (i == 3)
            bool = true;
        }
      }
      return bool;
    }
  }

  public boolean isStopped()
  {
    int i = 1;
    boolean bool;
    synchronized (this.mControlFlagsGuard)
    {
      AudioTrack localAudioTrack = this.mTrack;
      bool = false;
      if (localAudioTrack != null)
      {
        a locala = this.mPttPlayer;
        bool = false;
        if (locala != null)
        {
          if (this.mTrack.getPlayState() != i)
            break label67;
          break label61;
        }
      }
      return bool;
    }
    while (true)
    {
      label61: bool = i;
      break;
      label67: i = 0;
    }
  }

  public void onMarkerReached(AudioTrack paramAudioTrack)
  {
  }

  public void onPeriodicNotification(AudioTrack paramAudioTrack)
  {
    if (this.mPttPlayer != null)
    {
      long l = this.mPttPlayer.c();
      this.mPlayerBus.post(new e(this.mCurrentPttId, l));
    }
  }

  public void pause()
  {
    synchronized (this.mControlFlagsGuard)
    {
      if ((this.mTrack != null) && (this.mPttPlayer != null) && (!this.mInterruptionOccured))
      {
        this.mPttPlayer.f();
        this.mPlayerBus.post(g.b(this.mCurrentPttId, this.mPttPlayer.c()));
      }
      return;
    }
  }

  public void resume(long paramLong)
  {
    synchronized (this.mControlFlagsGuard)
    {
      if ((this.mTrack != null) && (this.mPttPlayer != null) && (!this.mInterruptionOccured))
      {
        this.mPttPlayer.g();
        if (paramLong > 0L)
          seek(paramLong);
        this.mPlayerBus.post(g.c(this.mCurrentPttId, this.mPttPlayer.c()));
      }
      return;
    }
  }

  public void seek(long paramLong)
  {
    synchronized (this.mControlFlagsGuard)
    {
      if ((this.mTrack != null) && (this.mPttPlayer != null))
      {
        boolean bool = this.mInterruptionOccured;
        if (bool);
      }
    }
    try
    {
      this.mTrack.setPlaybackPositionUpdateListener(null);
      this.mPttPlayer.a(paramLong);
      this.mTrack.setPositionNotificationPeriod(3200);
      this.mTrack.setPlaybackPositionUpdateListener(this);
      label68: return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (IOException localIOException)
    {
      break label68;
    }
  }

  public void startPlay()
  {
    synchronized (this.mControlFlagsGuard)
    {
      if ((this.mPlayThread != null) && (this.mPlayThread.getState() == Thread.State.NEW))
        this.mPlayThread.start();
      return;
    }
  }

  public void startPlay(long paramLong)
  {
    synchronized (this.mControlFlagsGuard)
    {
      if ((this.mPlayThread != null) && (this.mPlayThread.getState() == Thread.State.NEW))
      {
        this.mStartPositionMs = paramLong;
        this.mPlayThread.start();
      }
      return;
    }
  }

  public void stopPlay()
  {
    synchronized (this.mControlFlagsGuard)
    {
      if (this.mPttPlayer != null)
      {
        this.mInterruptionOccured = true;
        this.mStopReason = 0;
        if (this.mTrack != null)
          this.mTrack.setPlaybackPositionUpdateListener(null);
        this.mPttPlayer.e();
      }
      return;
    }
  }

  public void switchStreams(boolean paramBoolean)
  {
    synchronized (this.mControlFlagsGuard)
    {
      if (this.mPlayToSpeaker != paramBoolean)
      {
        this.mPlayToSpeaker = paramBoolean;
        if ((this.mTrack != null) && (this.mPttPlayer != null))
        {
          this.mTrack.setPlaybackPositionUpdateListener(null);
          int i;
          if (this.mPlayToSpeaker)
          {
            i = this.mDefaultAudioStream;
            this.mTrack = a.c(i);
            if (this.mTrack.getState() != 1)
            {
              this.mTrack.release();
              this.mTrack = null;
            }
          }
          else
          {
            i = 0;
          }
        }
      }
    }
    try
    {
      this.mPttPlayer.a(this.mTrack);
      this.mTrack.setPositionNotificationPeriod(3200);
      this.mTrack.setPlaybackPositionUpdateListener(this);
      this.mTrack.play();
      label133: return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      break label133;
    }
    catch (IOException localIOException)
    {
      break label133;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.ptt.AudioPttPlayer
 * JD-Core Version:    0.6.2
 */