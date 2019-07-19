package com.viber.voip.audioptt;

import android.media.AudioTrack;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;

public class a
{
  BufferedInputStream a;
  byte[] b;
  AudioTrack c;
  c d;
  int e;
  boolean f = false;
  int g = 0;
  ArrayList<Long> h;
  private final Object i = new Object();

  public a()
  {
    Log.d("AudioPttPlayer", "constructor");
  }

  private void b(InputStream paramInputStream, boolean paramBoolean)
    throws StreamCorruptedException, IOException
  {
    boolean bool1 = true;
    if (this.b == null)
      this.b = new byte[65536];
    if (this.a != null);
    try
    {
      this.a.close();
      this.h = null;
      this.a = new BufferedInputStream(paramInputStream);
      d();
      Log.d("AudioPttPlayer", "checked the header");
      if (paramBoolean)
      {
        Log.d("AudioPttPlayer", "seekable mode");
        this.a.mark(2097152);
        this.e = 0;
        if (this.c != null)
        {
          if (this.c.getPlayState() != 2)
            break label151;
          bool2 = bool1;
          if (!bool2)
            this.c.pause();
          if (bool2)
            break label157;
          a(bool1);
        }
      }
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        localIOException.printStackTrace();
        continue;
        Log.d("AudioPttPlayer", "not seekable mode");
        continue;
        label151: boolean bool2 = false;
        continue;
        label157: bool1 = false;
      }
    }
  }

  public static AudioTrack c(int paramInt)
  {
    return new AudioTrack(paramInt, 16000, 4, 2, 16000, 1);
  }

  private void i()
  {
    this.c.play();
    Log.d("AudioPttPlayer", "playbackHeadPosition after unpause = " + Long.toString(a(this.c.getPlaybackHeadPosition())));
    synchronized (this.i)
    {
      this.i.notifyAll();
      return;
    }
  }

  long a(int paramInt)
  {
    return 1000L * paramInt / 16000L;
  }

  public void a(AudioTrack paramAudioTrack)
    throws StreamCorruptedException, IOException
  {
    while (true)
    {
      try
      {
        Log.d("AudioPttPlayer", "setAudioTrack");
        AudioTrack localAudioTrack = this.c;
        if (paramAudioTrack == localAudioTrack)
          return;
        long l1 = b();
        if (this.c != null)
        {
          Log.i("AudioPttPlayer", "switching audio track");
          int k = this.c.getState();
          j = 0;
          if (k != 0)
          {
            int m = this.c.getPlayState();
            j = 0;
            if (m == 2)
              j = 1;
            this.c.stop();
            this.c.release();
          }
          this.c = paramAudioTrack;
          if (this.c == null)
            continue;
          this.c.play();
          if (j != 0)
          {
            Log.d("AudioPttPlayer", "pre-paused");
            this.c.pause();
          }
          if (l1 != 0L)
          {
            long l2 = l1 / 20L;
            Log.d("AudioPttPlayer", "seeking back " + Long.toString(l2) + " frames");
            b(this.e - l2);
          }
          a(false);
          continue;
        }
      }
      finally
      {
      }
      Log.i("AudioPttPlayer", "setting audio track");
      int j = 0;
    }
  }

  public void a(c paramc)
  {
    this.d = paramc;
  }

  public void a(InputStream paramInputStream, long paramLong)
    throws StreamCorruptedException, IOException
  {
    try
    {
      Log.i("AudioPttPlayer", "reopen and seek to " + Long.toString(paramLong));
      b(paramInputStream, true);
      if (!b(paramLong / 20L))
        Log.e("AudioPttPlayer", "reopen and seek failed");
      while (true)
      {
        return;
        Log.d("AudioPttPlayer", "reopen and seek done");
      }
    }
    finally
    {
    }
  }

  public void a(InputStream paramInputStream, boolean paramBoolean)
    throws StreamCorruptedException, IOException
  {
    try
    {
      Log.i("AudioPttPlayer", "setting the new source");
      b(paramInputStream, paramBoolean);
      Log.d("AudioPttPlayer", "setting the new source done");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void a(boolean paramBoolean)
  {
    this.c.flush();
    if (paramBoolean)
      i();
    this.g = this.c.getPlaybackHeadPosition();
    int j = 20 * this.e;
    this.g = ((int)(this.g - b(j)));
    if (this.g != 0)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(j);
      arrayOfObject[1] = Long.valueOf(a(this.c.getPlaybackHeadPosition()));
      Log.d("AudioPttPlayer", String.format("decoded_ms=%d playbackHeadPosition=%d", arrayOfObject));
      Log.d("AudioPttPlayer", "setting playhead base to " + Long.toString(a(this.g)));
    }
  }

  boolean a()
  {
    return (this.c != null) && (this.c.getState() != 0);
  }

  public boolean a(long paramLong)
    throws IOException, StreamCorruptedException
  {
    while (true)
    {
      int j;
      try
      {
        Log.i("AudioPttPlayer", "seek to " + Long.toString(paramLong));
        boolean bool1 = b(paramLong / 20L);
        boolean bool2 = false;
        if (!bool1)
          return bool2;
        if (a())
        {
          if (this.c.getPlayState() == 2)
          {
            j = 1;
            if (j != 0)
              break label121;
            this.c.pause();
            break label121;
            a(bool3);
          }
        }
        else
        {
          Log.d("AudioPttPlayer", "seek finished");
          bool2 = true;
          continue;
        }
        j = 0;
        continue;
      }
      finally
      {
      }
      label121: boolean bool3 = false;
      if (j == 0)
        bool3 = true;
    }
  }

  long b()
  {
    if (!a())
      return 0L;
    try
    {
      int k = this.c.getPlaybackHeadPosition();
      int m = this.g;
      j = k - m;
      return 20 * this.e - a(j);
    }
    catch (IllegalStateException localIllegalStateException)
    {
      while (true)
      {
        Log.e("AudioPttPlayer", localIllegalStateException.toString());
        int j = 0;
      }
    }
  }

  long b(int paramInt)
  {
    return 16000L * paramInt / 1000L;
  }

  boolean b(long paramLong)
    throws IOException, StreamCorruptedException
  {
    if (!b(false))
      return false;
    if (this.h == null)
      throw new RuntimeException("Internal AudioPttPlayer error");
    if (this.h.size() == 0)
      return true;
    if (this.a == null)
      return true;
    if (paramLong >= this.h.size());
    for (long l = -1 + this.h.size(); ; l = paramLong)
    {
      if (l < 0L)
        l = 0L;
      this.a.reset();
      this.a.skip(((Long)this.h.get((int)l)).longValue());
      this.e = ((int)l);
      return true;
    }
  }

  // ERROR //
  boolean b(boolean paramBoolean)
    throws StreamCorruptedException, IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 58	com/viber/voip/audioptt/a:h	Ljava/util/ArrayList;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +11 -> 19
    //   11: iconst_1
    //   12: istore 5
    //   14: aload_0
    //   15: monitorexit
    //   16: iload 5
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 51	com/viber/voip/audioptt/a:a	Ljava/io/BufferedInputStream;
    //   23: astore 4
    //   25: aload 4
    //   27: ifnonnull +9 -> 36
    //   30: iconst_0
    //   31: istore 5
    //   33: goto -19 -> 14
    //   36: aload_0
    //   37: getfield 51	com/viber/voip/audioptt/a:a	Ljava/io/BufferedInputStream;
    //   40: invokevirtual 235	java/io/BufferedInputStream:reset	()V
    //   43: ldc 34
    //   45: ldc 248
    //   47: invokestatic 141	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   50: pop
    //   51: aload_0
    //   52: new 229	java/util/ArrayList
    //   55: dup
    //   56: sipush 1500
    //   59: invokespecial 250	java/util/ArrayList:<init>	(I)V
    //   62: putfield 58	com/viber/voip/audioptt/a:h	Ljava/util/ArrayList;
    //   65: iconst_2
    //   66: newarray byte
    //   68: astore 11
    //   70: lconst_0
    //   71: lstore 12
    //   73: aload_0
    //   74: getfield 51	com/viber/voip/audioptt/a:a	Ljava/io/BufferedInputStream;
    //   77: aload 11
    //   79: iconst_0
    //   80: iconst_2
    //   81: invokevirtual 254	java/io/BufferedInputStream:read	([BII)I
    //   84: istore 14
    //   86: iload 14
    //   88: i2l
    //   89: lstore 15
    //   91: lload 15
    //   93: lconst_0
    //   94: lcmp
    //   95: ifeq +12 -> 107
    //   98: lload 15
    //   100: ldc2_w 255
    //   103: lcmp
    //   104: ifne +46 -> 150
    //   107: ldc 34
    //   109: ldc_w 258
    //   112: invokestatic 175	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   115: pop
    //   116: iload_1
    //   117: ifeq +175 -> 292
    //   120: aload_0
    //   121: aload_0
    //   122: getfield 74	com/viber/voip/audioptt/a:e	I
    //   125: i2l
    //   126: invokevirtual 161	com/viber/voip/audioptt/a:b	(J)Z
    //   129: pop
    //   130: goto +162 -> 292
    //   133: astore 6
    //   135: ldc 34
    //   137: ldc_w 260
    //   140: invokestatic 175	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   143: pop
    //   144: iconst_0
    //   145: istore 5
    //   147: goto -133 -> 14
    //   150: lload 15
    //   152: ldc2_w 261
    //   155: lcmp
    //   156: ifge +35 -> 191
    //   159: new 44	java/io/StreamCorruptedException
    //   162: dup
    //   163: invokespecial 263	java/io/StreamCorruptedException:<init>	()V
    //   166: athrow
    //   167: astore 9
    //   169: aload_0
    //   170: aconst_null
    //   171: putfield 58	com/viber/voip/audioptt/a:h	Ljava/util/ArrayList;
    //   174: ldc 34
    //   176: ldc_w 265
    //   179: invokestatic 41	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   182: pop
    //   183: aload 9
    //   185: athrow
    //   186: astore_2
    //   187: aload_0
    //   188: monitorexit
    //   189: aload_2
    //   190: athrow
    //   191: aload_0
    //   192: getfield 58	com/viber/voip/audioptt/a:h	Ljava/util/ArrayList;
    //   195: lload 12
    //   197: invokestatic 197	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   200: invokevirtual 269	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   203: pop
    //   204: aload 11
    //   206: iconst_0
    //   207: baload
    //   208: aload 11
    //   210: iconst_1
    //   211: baload
    //   212: bipush 8
    //   214: ishl
    //   215: ior
    //   216: i2l
    //   217: lstore 20
    //   219: lload 20
    //   221: aload_0
    //   222: getfield 48	com/viber/voip/audioptt/a:b	[B
    //   225: arraylength
    //   226: i2l
    //   227: lcmp
    //   228: ifle +70 -> 298
    //   231: new 44	java/io/StreamCorruptedException
    //   234: dup
    //   235: invokespecial 263	java/io/StreamCorruptedException:<init>	()V
    //   238: athrow
    //   239: lload 22
    //   241: lconst_0
    //   242: lcmp
    //   243: ifeq +62 -> 305
    //   246: aload_0
    //   247: getfield 51	com/viber/voip/audioptt/a:a	Ljava/io/BufferedInputStream;
    //   250: lload 22
    //   252: invokevirtual 246	java/io/BufferedInputStream:skip	(J)J
    //   255: lstore 24
    //   257: lload 24
    //   259: lconst_0
    //   260: lcmp
    //   261: ifgt +21 -> 282
    //   264: lload 22
    //   266: lconst_0
    //   267: lcmp
    //   268: ifne +6 -> 274
    //   271: goto +34 -> 305
    //   274: new 44	java/io/StreamCorruptedException
    //   277: dup
    //   278: invokespecial 263	java/io/StreamCorruptedException:<init>	()V
    //   281: athrow
    //   282: lload 22
    //   284: lload 24
    //   286: lsub
    //   287: lstore 22
    //   289: goto -50 -> 239
    //   292: iconst_1
    //   293: istore 5
    //   295: goto -281 -> 14
    //   298: lload 20
    //   300: lstore 22
    //   302: goto -63 -> 239
    //   305: lload 20
    //   307: ldc2_w 261
    //   310: lload 12
    //   312: ladd
    //   313: ladd
    //   314: lstore 12
    //   316: goto -243 -> 73
    //
    // Exception table:
    //   from	to	target	type
    //   36	51	133	java/io/IOException
    //   65	70	167	finally
    //   73	86	167	finally
    //   159	167	167	finally
    //   191	239	167	finally
    //   246	257	167	finally
    //   274	282	167	finally
    //   2	7	186	finally
    //   19	25	186	finally
    //   36	51	186	finally
    //   51	65	186	finally
    //   107	116	186	finally
    //   120	130	186	finally
    //   135	144	186	finally
    //   169	186	186	finally
  }

  public long c()
  {
    try
    {
      long l2;
      if (a())
        l2 = a(this.c.getPlaybackHeadPosition() - this.g);
      int j;
      for (long l1 = l2; ; l1 = j * 20)
      {
        return l1;
        j = this.e;
      }
    }
    finally
    {
    }
  }

  void d()
    throws StreamCorruptedException, IOException
  {
    this.a.read(this.b, 0, 1);
    if (this.b[0] != 26)
      throw new StreamCorruptedException();
  }

  // ERROR //
  public void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 34
    //   4: ldc_w 270
    //   7: invokestatic 41	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   10: pop
    //   11: aload_0
    //   12: getfield 51	com/viber/voip/audioptt/a:a	Ljava/io/BufferedInputStream;
    //   15: astore_3
    //   16: aload_3
    //   17: ifnull +15 -> 32
    //   20: aload_0
    //   21: getfield 51	com/viber/voip/audioptt/a:a	Ljava/io/BufferedInputStream;
    //   24: invokevirtual 56	java/io/BufferedInputStream:close	()V
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 51	com/viber/voip/audioptt/a:a	Ljava/io/BufferedInputStream;
    //   32: aload_0
    //   33: aconst_null
    //   34: putfield 48	com/viber/voip/audioptt/a:b	[B
    //   37: aload_0
    //   38: getfield 76	com/viber/voip/audioptt/a:c	Landroid/media/AudioTrack;
    //   41: ifnull +27 -> 68
    //   44: aload_0
    //   45: getfield 76	com/viber/voip/audioptt/a:c	Landroid/media/AudioTrack;
    //   48: invokevirtual 144	android/media/AudioTrack:getState	()I
    //   51: ifeq +17 -> 68
    //   54: aload_0
    //   55: getfield 76	com/viber/voip/audioptt/a:c	Landroid/media/AudioTrack;
    //   58: invokevirtual 147	android/media/AudioTrack:stop	()V
    //   61: aload_0
    //   62: getfield 76	com/viber/voip/audioptt/a:c	Landroid/media/AudioTrack;
    //   65: invokevirtual 150	android/media/AudioTrack:release	()V
    //   68: aload_0
    //   69: getfield 32	com/viber/voip/audioptt/a:i	Ljava/lang/Object;
    //   72: astore 4
    //   74: aload 4
    //   76: monitorenter
    //   77: aload_0
    //   78: getfield 32	com/viber/voip/audioptt/a:i	Ljava/lang/Object;
    //   81: invokevirtual 127	java/lang/Object:notifyAll	()V
    //   84: aload 4
    //   86: monitorexit
    //   87: aload_0
    //   88: monitorexit
    //   89: return
    //   90: astore 6
    //   92: aload 6
    //   94: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   97: goto -70 -> 27
    //   100: astore_1
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_1
    //   104: athrow
    //   105: astore 5
    //   107: aload 4
    //   109: monitorexit
    //   110: aload 5
    //   112: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   20	27	90	java/io/IOException
    //   2	16	100	finally
    //   20	27	100	finally
    //   27	32	100	finally
    //   32	68	100	finally
    //   68	77	100	finally
    //   92	97	100	finally
    //   110	113	100	finally
    //   77	87	105	finally
    //   107	110	105	finally
  }

  public void f()
  {
    Log.d("AudioPttPlayer", "pause?");
    if ((this.c != null) && (this.c.getState() != 0))
    {
      Log.d("AudioPttPlayer", "pause.");
      this.c.pause();
    }
  }

  public void g()
  {
    Log.d("AudioPttPlayer", "resume?");
    if ((this.c != null) && (this.c.getState() != 0))
    {
      Log.d("AudioPttPlayer", "resume.");
      this.c.play();
    }
    synchronized (this.i)
    {
      this.i.notifyAll();
      return;
    }
  }

  // ERROR //
  public void h()
    throws IOException, StreamCorruptedException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 48	com/viber/voip/audioptt/a:b	[B
    //   4: ifnonnull +14 -> 18
    //   7: new 222	java/lang/RuntimeException
    //   10: dup
    //   11: ldc_w 282
    //   14: invokespecial 227	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   17: athrow
    //   18: invokestatic 287	com/viber/voip/audioptt/LibSpeex:nInitSpxDecoder	()J
    //   21: lstore_1
    //   22: lload_1
    //   23: lconst_0
    //   24: lcmp
    //   25: ifne +14 -> 39
    //   28: new 222	java/lang/RuntimeException
    //   31: dup
    //   32: ldc_w 289
    //   35: invokespecial 227	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   38: athrow
    //   39: lload_1
    //   40: invokestatic 292	com/viber/voip/audioptt/LibSpeex:nGetDecoderFrameSize	(J)J
    //   43: l2i
    //   44: istore_3
    //   45: iload_3
    //   46: newarray short
    //   48: astore 4
    //   50: ldc 34
    //   52: ldc_w 294
    //   55: invokestatic 141	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   58: pop
    //   59: aload_0
    //   60: monitorenter
    //   61: aload_0
    //   62: getfield 76	com/viber/voip/audioptt/a:c	Landroid/media/AudioTrack;
    //   65: astore 9
    //   67: aload_0
    //   68: getfield 51	com/viber/voip/audioptt/a:a	Ljava/io/BufferedInputStream;
    //   71: ifnonnull +23 -> 94
    //   74: aload_0
    //   75: monitorexit
    //   76: lload_1
    //   77: invokestatic 298	com/viber/voip/audioptt/LibSpeex:nDestroySpxDecoder	(J)V
    //   80: ldc 34
    //   82: ldc_w 300
    //   85: invokestatic 141	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   88: pop
    //   89: aload_0
    //   90: invokevirtual 302	com/viber/voip/audioptt/a:e	()V
    //   93: return
    //   94: aload_0
    //   95: getfield 48	com/viber/voip/audioptt/a:b	[B
    //   98: astore 10
    //   100: aload_0
    //   101: getfield 51	com/viber/voip/audioptt/a:a	Ljava/io/BufferedInputStream;
    //   104: aload 10
    //   106: iconst_0
    //   107: iconst_2
    //   108: invokevirtual 254	java/io/BufferedInputStream:read	([BII)I
    //   111: iconst_2
    //   112: if_icmpge +84 -> 196
    //   115: aload_0
    //   116: invokevirtual 137	com/viber/voip/audioptt/a:b	()J
    //   119: lstore 23
    //   121: lload 23
    //   123: lconst_0
    //   124: lcmp
    //   125: ifle +41 -> 166
    //   128: ldc 34
    //   130: new 102	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   137: ldc_w 304
    //   140: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: lload 23
    //   145: invokevirtual 307	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   148: ldc_w 309
    //   151: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 141	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   160: pop
    //   161: lload 23
    //   163: invokestatic 314	java/lang/Thread:sleep	(J)V
    //   166: aload_0
    //   167: monitorexit
    //   168: goto -92 -> 76
    //   171: astore 8
    //   173: aload_0
    //   174: monitorexit
    //   175: aload 8
    //   177: athrow
    //   178: astore 5
    //   180: lload_1
    //   181: invokestatic 298	com/viber/voip/audioptt/LibSpeex:nDestroySpxDecoder	(J)V
    //   184: ldc 34
    //   186: ldc_w 300
    //   189: invokestatic 141	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   192: pop
    //   193: aload 5
    //   195: athrow
    //   196: aload 10
    //   198: iconst_0
    //   199: baload
    //   200: aload 10
    //   202: iconst_1
    //   203: baload
    //   204: bipush 8
    //   206: ishl
    //   207: ior
    //   208: istore 11
    //   210: iload 11
    //   212: aload 10
    //   214: arraylength
    //   215: if_icmple +11 -> 226
    //   218: new 44	java/io/StreamCorruptedException
    //   221: dup
    //   222: invokespecial 263	java/io/StreamCorruptedException:<init>	()V
    //   225: athrow
    //   226: aload_0
    //   227: getfield 51	com/viber/voip/audioptt/a:a	Ljava/io/BufferedInputStream;
    //   230: aload 10
    //   232: iconst_0
    //   233: iload 11
    //   235: invokevirtual 254	java/io/BufferedInputStream:read	([BII)I
    //   238: iload 11
    //   240: if_icmpeq +11 -> 251
    //   243: new 44	java/io/StreamCorruptedException
    //   246: dup
    //   247: invokespecial 263	java/io/StreamCorruptedException:<init>	()V
    //   250: athrow
    //   251: lload_1
    //   252: aload 10
    //   254: iload 11
    //   256: i2l
    //   257: aload 4
    //   259: invokestatic 318	com/viber/voip/audioptt/LibSpeex:nDecodeBuffer	(J[BJ[S)Z
    //   262: ifne +11 -> 273
    //   265: new 44	java/io/StreamCorruptedException
    //   268: dup
    //   269: invokespecial 263	java/io/StreamCorruptedException:<init>	()V
    //   272: athrow
    //   273: aload_0
    //   274: iconst_1
    //   275: aload_0
    //   276: getfield 74	com/viber/voip/audioptt/a:e	I
    //   279: iadd
    //   280: putfield 74	com/viber/voip/audioptt/a:e	I
    //   283: aload_0
    //   284: monitorexit
    //   285: aload_0
    //   286: getfield 166	com/viber/voip/audioptt/a:d	Lcom/viber/voip/audioptt/c;
    //   289: ifnull +165 -> 454
    //   292: iload_3
    //   293: aload 4
    //   295: invokestatic 323	com/viber/voip/audioptt/b:a	(I[S)S
    //   298: istore 22
    //   300: aload_0
    //   301: getfield 166	com/viber/voip/audioptt/a:d	Lcom/viber/voip/audioptt/c;
    //   304: aload_0
    //   305: getfield 74	com/viber/voip/audioptt/a:e	I
    //   308: i2l
    //   309: iload 22
    //   311: invokeinterface 329 4 0
    //   316: goto +138 -> 454
    //   319: aload 12
    //   321: aload 4
    //   323: iconst_0
    //   324: iload_3
    //   325: invokevirtual 333	android/media/AudioTrack:write	([SII)I
    //   328: istore 13
    //   330: iload 13
    //   332: ifne +109 -> 441
    //   335: aload 12
    //   337: invokevirtual 82	android/media/AudioTrack:getPlayState	()I
    //   340: iconst_2
    //   341: if_icmpne +75 -> 416
    //   344: ldc 34
    //   346: ldc_w 335
    //   349: invokestatic 41	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   352: pop
    //   353: aload_0
    //   354: getfield 32	com/viber/voip/audioptt/a:i	Ljava/lang/Object;
    //   357: astore 19
    //   359: aload 19
    //   361: monitorenter
    //   362: aload_0
    //   363: getfield 32	com/viber/voip/audioptt/a:i	Ljava/lang/Object;
    //   366: invokevirtual 338	java/lang/Object:wait	()V
    //   369: aload 19
    //   371: monitorexit
    //   372: ldc 34
    //   374: ldc_w 340
    //   377: invokestatic 41	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   380: pop
    //   381: aload_0
    //   382: monitorenter
    //   383: aload_0
    //   384: getfield 76	com/viber/voip/audioptt/a:c	Landroid/media/AudioTrack;
    //   387: astore 12
    //   389: aload_0
    //   390: monitorexit
    //   391: aload 12
    //   393: ifnonnull -74 -> 319
    //   396: ldc 34
    //   398: ldc_w 342
    //   401: invokestatic 141	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   404: pop
    //   405: goto -346 -> 59
    //   408: astore 20
    //   410: aload 19
    //   412: monitorexit
    //   413: aload 20
    //   415: athrow
    //   416: ldc 34
    //   418: ldc_w 344
    //   421: invokestatic 347	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   424: pop
    //   425: ldc2_w 348
    //   428: invokestatic 314	java/lang/Thread:sleep	(J)V
    //   431: goto -50 -> 381
    //   434: astore 15
    //   436: aload_0
    //   437: monitorexit
    //   438: aload 15
    //   440: athrow
    //   441: iload 13
    //   443: ifge -384 -> 59
    //   446: goto -387 -> 59
    //   449: astore 26
    //   451: goto -285 -> 166
    //   454: aload 9
    //   456: ifnull -397 -> 59
    //   459: aload 9
    //   461: astore 12
    //   463: goto -144 -> 319
    //   466: astore 14
    //   468: goto -87 -> 381
    //
    // Exception table:
    //   from	to	target	type
    //   61	76	171	finally
    //   94	121	171	finally
    //   128	166	171	finally
    //   166	168	171	finally
    //   173	175	171	finally
    //   196	226	171	finally
    //   226	251	171	finally
    //   251	273	171	finally
    //   273	285	171	finally
    //   50	59	178	finally
    //   59	61	178	finally
    //   175	178	178	finally
    //   285	316	178	finally
    //   319	330	178	finally
    //   335	362	178	finally
    //   372	381	178	finally
    //   381	383	178	finally
    //   396	405	178	finally
    //   413	416	178	finally
    //   416	431	178	finally
    //   438	441	178	finally
    //   362	372	408	finally
    //   410	413	408	finally
    //   383	391	434	finally
    //   436	438	434	finally
    //   128	166	449	java/lang/InterruptedException
    //   335	362	466	java/lang/InterruptedException
    //   372	381	466	java/lang/InterruptedException
    //   413	416	466	java/lang/InterruptedException
    //   416	431	466	java/lang/InterruptedException
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.audioptt.a
 * JD-Core Version:    0.6.2
 */