package com.viber.voip.phone.vptt.v2;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaRecorder;
import android.media.ThumbnailUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.phone.vptt.VideoPttRecord;
import com.viber.voip.phone.vptt.VideoPttRecord.Completion;
import com.viber.voip.phone.vptt.VideoPttRecord.StopCompletion;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class MrVideoPttRecorder
  implements VideoPttRecord
{
  private static final Logger L = ViberEnv.getLogger();
  public static final String VPTT2_NON_FATAL_TAG = "VPTT2 error";
  com.viber.voip.widget.d.a.a cameraPreview;
  private boolean isRecording = false;
  private MediaRecorder mMediaRecorder;
  private File mOutputFile;
  private int videoBitrate = 2000000;
  VideoPttCamera videoPttCamera;

  public MrVideoPttRecorder(com.viber.voip.widget.d.a parama, VideoPttCamera paramVideoPttCamera)
  {
    this.cameraPreview = ((com.viber.voip.widget.d.a.a)parama.getView());
    this.videoPttCamera = paramVideoPttCamera;
  }

  private void releaseCamera()
  {
    this.videoPttCamera.stop();
  }

  private void releaseMediaRecorder()
  {
    if (this.mMediaRecorder != null)
    {
      this.mMediaRecorder.reset();
      this.mMediaRecorder.release();
      this.mMediaRecorder = null;
      this.videoPttCamera.lock();
    }
  }

  private void releaseRecording()
  {
    try
    {
      releaseMediaRecorder();
      releaseCamera();
      this.isRecording = false;
      return;
    }
    catch (Exception localException)
    {
    }
  }

  // ERROR //
  private boolean startRecord(String paramString, VideoPttRecord.Completion paramCompletion)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 55	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:videoPttCamera	Lcom/viber/voip/phone/vptt/v2/VideoPttCamera;
    //   4: aload_0
    //   5: getfield 53	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:cameraPreview	Lcom/viber/voip/widget/d/a/a;
    //   8: invokevirtual 94	com/viber/voip/widget/d/a/a:getHolder	()Landroid/view/SurfaceHolder;
    //   11: invokevirtual 98	com/viber/voip/phone/vptt/v2/VideoPttCamera:start	(Landroid/view/SurfaceHolder;)V
    //   14: aload_0
    //   15: new 66	android/media/MediaRecorder
    //   18: dup
    //   19: invokespecial 99	android/media/MediaRecorder:<init>	()V
    //   22: putfield 64	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:mMediaRecorder	Landroid/media/MediaRecorder;
    //   25: aload_0
    //   26: getfield 55	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:videoPttCamera	Lcom/viber/voip/phone/vptt/v2/VideoPttCamera;
    //   29: invokevirtual 102	com/viber/voip/phone/vptt/v2/VideoPttCamera:unlock	()V
    //   32: aload_0
    //   33: getfield 64	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:mMediaRecorder	Landroid/media/MediaRecorder;
    //   36: aload_0
    //   37: getfield 55	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:videoPttCamera	Lcom/viber/voip/phone/vptt/v2/VideoPttCamera;
    //   40: invokevirtual 106	com/viber/voip/phone/vptt/v2/VideoPttCamera:getCamera	()Landroid/hardware/Camera;
    //   43: invokevirtual 110	android/media/MediaRecorder:setCamera	(Landroid/hardware/Camera;)V
    //   46: aload_0
    //   47: getfield 55	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:videoPttCamera	Lcom/viber/voip/phone/vptt/v2/VideoPttCamera;
    //   50: invokevirtual 113	com/viber/voip/phone/vptt/v2/VideoPttCamera:disableShutterSound	()V
    //   53: aload_0
    //   54: getfield 64	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:mMediaRecorder	Landroid/media/MediaRecorder;
    //   57: iconst_1
    //   58: invokevirtual 117	android/media/MediaRecorder:setVideoSource	(I)V
    //   61: aload_0
    //   62: getfield 64	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:mMediaRecorder	Landroid/media/MediaRecorder;
    //   65: iconst_1
    //   66: invokevirtual 120	android/media/MediaRecorder:setAudioSource	(I)V
    //   69: aload_0
    //   70: getfield 64	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:mMediaRecorder	Landroid/media/MediaRecorder;
    //   73: iconst_2
    //   74: invokevirtual 123	android/media/MediaRecorder:setOutputFormat	(I)V
    //   77: aload_0
    //   78: getfield 64	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:mMediaRecorder	Landroid/media/MediaRecorder;
    //   81: iconst_3
    //   82: invokevirtual 126	android/media/MediaRecorder:setAudioEncoder	(I)V
    //   85: aload_0
    //   86: getfield 64	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:mMediaRecorder	Landroid/media/MediaRecorder;
    //   89: ldc 127
    //   91: invokevirtual 130	android/media/MediaRecorder:setAudioSamplingRate	(I)V
    //   94: aload_0
    //   95: getfield 64	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:mMediaRecorder	Landroid/media/MediaRecorder;
    //   98: sipush 32000
    //   101: invokevirtual 133	android/media/MediaRecorder:setAudioEncodingBitRate	(I)V
    //   104: aload_0
    //   105: getfield 64	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:mMediaRecorder	Landroid/media/MediaRecorder;
    //   108: iconst_1
    //   109: invokevirtual 136	android/media/MediaRecorder:setAudioChannels	(I)V
    //   112: aload_0
    //   113: getfield 55	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:videoPttCamera	Lcom/viber/voip/phone/vptt/v2/VideoPttCamera;
    //   116: invokevirtual 140	com/viber/voip/phone/vptt/v2/VideoPttCamera:getCameraRotation	()I
    //   119: istore 4
    //   121: aload_0
    //   122: getfield 64	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:mMediaRecorder	Landroid/media/MediaRecorder;
    //   125: iload 4
    //   127: invokevirtual 143	android/media/MediaRecorder:setOrientationHint	(I)V
    //   130: aload_0
    //   131: getfield 64	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:mMediaRecorder	Landroid/media/MediaRecorder;
    //   134: iconst_2
    //   135: invokevirtual 146	android/media/MediaRecorder:setVideoEncoder	(I)V
    //   138: aload_0
    //   139: getfield 64	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:mMediaRecorder	Landroid/media/MediaRecorder;
    //   142: aload_0
    //   143: getfield 55	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:videoPttCamera	Lcom/viber/voip/phone/vptt/v2/VideoPttCamera;
    //   146: invokevirtual 149	com/viber/voip/phone/vptt/v2/VideoPttCamera:getLowVideoFramerate	()I
    //   149: invokevirtual 152	android/media/MediaRecorder:setVideoFrameRate	(I)V
    //   152: aload_0
    //   153: getfield 64	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:mMediaRecorder	Landroid/media/MediaRecorder;
    //   156: aload_0
    //   157: getfield 43	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:videoBitrate	I
    //   160: invokevirtual 155	android/media/MediaRecorder:setVideoEncodingBitRate	(I)V
    //   163: aload_0
    //   164: getfield 55	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:videoPttCamera	Lcom/viber/voip/phone/vptt/v2/VideoPttCamera;
    //   167: invokevirtual 159	com/viber/voip/phone/vptt/v2/VideoPttCamera:getRecordSize	()Lcom/viber/voip/phone/vptt/v2/VideoPttCamera$VideoSize;
    //   170: astore 5
    //   172: aload_0
    //   173: getfield 64	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:mMediaRecorder	Landroid/media/MediaRecorder;
    //   176: aload 5
    //   178: getfield 164	com/viber/voip/phone/vptt/v2/VideoPttCamera$VideoSize:width	I
    //   181: aload 5
    //   183: getfield 167	com/viber/voip/phone/vptt/v2/VideoPttCamera$VideoSize:height	I
    //   186: invokevirtual 171	android/media/MediaRecorder:setVideoSize	(II)V
    //   189: aload_0
    //   190: new 173	java/io/File
    //   193: dup
    //   194: aload_1
    //   195: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   198: putfield 178	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:mOutputFile	Ljava/io/File;
    //   201: aload_0
    //   202: getfield 178	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:mOutputFile	Ljava/io/File;
    //   205: ifnonnull +44 -> 249
    //   208: aload_2
    //   209: new 180	java/lang/Error
    //   212: dup
    //   213: ldc 182
    //   215: invokespecial 183	java/lang/Error:<init>	(Ljava/lang/String;)V
    //   218: invokeinterface 189 2 0
    //   223: iconst_0
    //   224: ireturn
    //   225: astore_3
    //   226: aload_2
    //   227: new 180	java/lang/Error
    //   230: dup
    //   231: ldc 191
    //   233: aload_3
    //   234: invokespecial 194	java/lang/Error:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   237: invokeinterface 189 2 0
    //   242: aload_0
    //   243: aload_3
    //   244: invokevirtual 198	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:trackVptt2NonFatal	(Ljava/lang/Throwable;)V
    //   247: iconst_0
    //   248: ireturn
    //   249: aload_0
    //   250: getfield 64	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:mMediaRecorder	Landroid/media/MediaRecorder;
    //   253: aload_0
    //   254: getfield 178	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:mOutputFile	Ljava/io/File;
    //   257: invokevirtual 202	java/io/File:getPath	()Ljava/lang/String;
    //   260: invokevirtual 205	android/media/MediaRecorder:setOutputFile	(Ljava/lang/String;)V
    //   263: aload_0
    //   264: getfield 64	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:mMediaRecorder	Landroid/media/MediaRecorder;
    //   267: invokevirtual 208	android/media/MediaRecorder:prepare	()V
    //   270: aload_0
    //   271: getfield 64	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:mMediaRecorder	Landroid/media/MediaRecorder;
    //   274: invokevirtual 210	android/media/MediaRecorder:start	()V
    //   277: aload_0
    //   278: getfield 55	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:videoPttCamera	Lcom/viber/voip/phone/vptt/v2/VideoPttCamera;
    //   281: invokevirtual 75	com/viber/voip/phone/vptt/v2/VideoPttCamera:lock	()V
    //   284: aload_2
    //   285: aconst_null
    //   286: invokeinterface 189 2 0
    //   291: iconst_1
    //   292: ireturn
    //   293: astore 7
    //   295: aload_2
    //   296: new 180	java/lang/Error
    //   299: dup
    //   300: new 212	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   307: ldc 215
    //   309: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: aload 7
    //   314: invokevirtual 222	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   317: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokespecial 183	java/lang/Error:<init>	(Ljava/lang/String;)V
    //   326: invokeinterface 189 2 0
    //   331: aload_0
    //   332: invokespecial 80	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:releaseMediaRecorder	()V
    //   335: iconst_0
    //   336: ireturn
    //   337: astore 6
    //   339: aload_0
    //   340: invokespecial 80	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:releaseMediaRecorder	()V
    //   343: aload_2
    //   344: new 180	java/lang/Error
    //   347: dup
    //   348: new 212	java/lang/StringBuilder
    //   351: dup
    //   352: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   355: ldc 227
    //   357: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: aload 6
    //   362: invokevirtual 228	java/io/IOException:getMessage	()Ljava/lang/String;
    //   365: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokespecial 183	java/lang/Error:<init>	(Ljava/lang/String;)V
    //   374: invokeinterface 189 2 0
    //   379: iconst_0
    //   380: ireturn
    //   381: astore 8
    //   383: aload_0
    //   384: getfield 55	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:videoPttCamera	Lcom/viber/voip/phone/vptt/v2/VideoPttCamera;
    //   387: invokevirtual 231	com/viber/voip/phone/vptt/v2/VideoPttCamera:reconnect	()V
    //   390: aload_0
    //   391: getfield 64	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:mMediaRecorder	Landroid/media/MediaRecorder;
    //   394: invokevirtual 210	android/media/MediaRecorder:start	()V
    //   397: goto -120 -> 277
    //   400: astore 9
    //   402: aload_0
    //   403: aload 9
    //   405: invokevirtual 198	com/viber/voip/phone/vptt/v2/MrVideoPttRecorder:trackVptt2NonFatal	(Ljava/lang/Throwable;)V
    //   408: aload_2
    //   409: new 180	java/lang/Error
    //   412: dup
    //   413: ldc 191
    //   415: aload 9
    //   417: invokespecial 194	java/lang/Error:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   420: invokeinterface 189 2 0
    //   425: iconst_0
    //   426: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   0	14	225	java/lang/Throwable
    //   263	270	293	java/lang/IllegalStateException
    //   263	270	337	java/io/IOException
    //   270	277	381	java/lang/Throwable
    //   383	397	400	java/lang/Throwable
  }

  public void dispose()
  {
    releaseMediaRecorder();
  }

  public byte[] getJpegPreview()
  {
    try
    {
      Bitmap localBitmap = ThumbnailUtils.createVideoThumbnail(this.mOutputFile.getPath(), 1);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      localBitmap.compress(Bitmap.CompressFormat.JPEG, 60, localByteArrayOutputStream);
      byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
      return arrayOfByte;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public boolean isRecording()
  {
    return this.isRecording;
  }

  public void startRecording(String paramString, VideoPttRecord.Completion paramCompletion)
  {
    try
    {
      if (this.isRecording)
        stop(null);
      if (startRecord(paramString, paramCompletion))
      {
        this.isRecording = true;
        return;
      }
      releaseMediaRecorder();
      return;
    }
    catch (Throwable localThrowable)
    {
      paramCompletion.onCompletion(new Error("can't start recording", localThrowable));
      trackVptt2NonFatal(localThrowable);
      releaseMediaRecorder();
    }
  }

  public void startVideoPttRecord(String paramString, VideoPttRecord.Completion paramCompletion)
  {
    startRecording(paramString, paramCompletion);
  }

  public void stop(VideoPttRecord.StopCompletion paramStopCompletion)
  {
    if (this.isRecording);
    while (true)
    {
      try
      {
        this.mMediaRecorder.stop();
        this.videoPttCamera.stop();
        if (paramStopCompletion != null)
        {
          byte[] arrayOfByte2 = getJpegPreview();
          if (arrayOfByte2 == null)
          {
            releaseRecording();
            paramStopCompletion.onCompletion(true, null, arrayOfByte2);
            return;
          }
          paramStopCompletion.onCompletion(false, null, arrayOfByte2);
        }
        this.isRecording = false;
        releaseRecording();
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        this.mOutputFile.delete();
        if (paramStopCompletion == null)
          continue;
        byte[] arrayOfByte1 = getJpegPreview();
        if (arrayOfByte1 == null)
        {
          releaseRecording();
          paramStopCompletion.onCompletion(true, null, arrayOfByte1);
          return;
        }
        paramStopCompletion.onCompletion(false, null, arrayOfByte1);
        continue;
      }
      if (paramStopCompletion != null)
        paramStopCompletion.onCompletion(false, null, null);
    }
  }

  public void stopVideoPttRecord(VideoPttRecord.StopCompletion paramStopCompletion)
  {
    stop(paramStopCompletion);
  }

  public void trackVptt2NonFatal(Throwable paramThrowable)
  {
    L.a(paramThrowable, "VPTT2 error");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.vptt.v2.MrVideoPttRecorder
 * JD-Core Version:    0.6.2
 */