package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

@zzare
@TargetApi(14)
public final class zzbde extends Thread
  implements SurfaceTexture.OnFrameAvailableListener, zzbdd
{
  private static final float[] zzedf = { -1.0F, -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, -1.0F, 1.0F, -1.0F, 1.0F, 1.0F, -1.0F };
  private int height;
  private int width;
  private final float[] zzedc;
  private final zzbdb zzedg;
  private final float[] zzedh;
  private final float[] zzedi;
  private final float[] zzedj;
  private final float[] zzedk;
  private final float[] zzedl;
  private final float[] zzedm;
  private float zzedn;
  private float zzedo;
  private float zzedp;
  private SurfaceTexture zzedq;
  private SurfaceTexture zzedr;
  private int zzeds;
  private int zzedt;
  private int zzedu;
  private FloatBuffer zzedv = ByteBuffer.allocateDirect(zzedf.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
  private final CountDownLatch zzedw;
  private final Object zzedx;
  private EGL10 zzedy;
  private EGLDisplay zzedz;
  private EGLContext zzeea;
  private EGLSurface zzeeb;
  private volatile boolean zzeec;
  private volatile boolean zzeed;

  public zzbde(Context paramContext)
  {
    super("SphericalVideoProcessor");
    this.zzedv.put(zzedf).position(0);
    this.zzedc = new float[9];
    this.zzedh = new float[9];
    this.zzedi = new float[9];
    this.zzedj = new float[9];
    this.zzedk = new float[9];
    this.zzedl = new float[9];
    this.zzedm = new float[9];
    this.zzedn = (0.0F / 0.0F);
    this.zzedg = new zzbdb(paramContext);
    this.zzedg.zza(this);
    this.zzedw = new CountDownLatch(1);
    this.zzedx = new Object();
  }

  private static void zza(float[] paramArrayOfFloat, float paramFloat)
  {
    paramArrayOfFloat[0] = 1.0F;
    paramArrayOfFloat[1] = 0.0F;
    paramArrayOfFloat[2] = 0.0F;
    paramArrayOfFloat[3] = 0.0F;
    paramArrayOfFloat[4] = ((float)Math.cos(paramFloat));
    paramArrayOfFloat[5] = ((float)-Math.sin(paramFloat));
    paramArrayOfFloat[6] = 0.0F;
    paramArrayOfFloat[7] = ((float)Math.sin(paramFloat));
    paramArrayOfFloat[8] = ((float)Math.cos(paramFloat));
  }

  private static void zza(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3)
  {
    paramArrayOfFloat1[0] = (paramArrayOfFloat2[0] * paramArrayOfFloat3[0] + paramArrayOfFloat2[1] * paramArrayOfFloat3[3] + paramArrayOfFloat2[2] * paramArrayOfFloat3[6]);
    paramArrayOfFloat1[1] = (paramArrayOfFloat2[0] * paramArrayOfFloat3[1] + paramArrayOfFloat2[1] * paramArrayOfFloat3[4] + paramArrayOfFloat2[2] * paramArrayOfFloat3[7]);
    paramArrayOfFloat1[2] = (paramArrayOfFloat2[0] * paramArrayOfFloat3[2] + paramArrayOfFloat2[1] * paramArrayOfFloat3[5] + paramArrayOfFloat2[2] * paramArrayOfFloat3[8]);
    paramArrayOfFloat1[3] = (paramArrayOfFloat2[3] * paramArrayOfFloat3[0] + paramArrayOfFloat2[4] * paramArrayOfFloat3[3] + paramArrayOfFloat2[5] * paramArrayOfFloat3[6]);
    paramArrayOfFloat1[4] = (paramArrayOfFloat2[3] * paramArrayOfFloat3[1] + paramArrayOfFloat2[4] * paramArrayOfFloat3[4] + paramArrayOfFloat2[5] * paramArrayOfFloat3[7]);
    paramArrayOfFloat1[5] = (paramArrayOfFloat2[3] * paramArrayOfFloat3[2] + paramArrayOfFloat2[4] * paramArrayOfFloat3[5] + paramArrayOfFloat2[5] * paramArrayOfFloat3[8]);
    paramArrayOfFloat1[6] = (paramArrayOfFloat2[6] * paramArrayOfFloat3[0] + paramArrayOfFloat2[7] * paramArrayOfFloat3[3] + paramArrayOfFloat2[8] * paramArrayOfFloat3[6]);
    paramArrayOfFloat1[7] = (paramArrayOfFloat2[6] * paramArrayOfFloat3[1] + paramArrayOfFloat2[7] * paramArrayOfFloat3[4] + paramArrayOfFloat2[8] * paramArrayOfFloat3[7]);
    paramArrayOfFloat1[8] = (paramArrayOfFloat2[6] * paramArrayOfFloat3[2] + paramArrayOfFloat2[7] * paramArrayOfFloat3[5] + paramArrayOfFloat2[8] * paramArrayOfFloat3[8]);
  }

  private static void zzb(float[] paramArrayOfFloat, float paramFloat)
  {
    paramArrayOfFloat[0] = ((float)Math.cos(paramFloat));
    paramArrayOfFloat[1] = ((float)-Math.sin(paramFloat));
    paramArrayOfFloat[2] = 0.0F;
    paramArrayOfFloat[3] = ((float)Math.sin(paramFloat));
    paramArrayOfFloat[4] = ((float)Math.cos(paramFloat));
    paramArrayOfFloat[5] = 0.0F;
    paramArrayOfFloat[6] = 0.0F;
    paramArrayOfFloat[7] = 0.0F;
    paramArrayOfFloat[8] = 1.0F;
  }

  private static int zzd(int paramInt, String paramString)
  {
    int i = GLES20.glCreateShader(paramInt);
    zzes("createShader");
    if (i != 0)
    {
      GLES20.glShaderSource(i, paramString);
      zzes("shaderSource");
      GLES20.glCompileShader(i);
      zzes("compileShader");
      int[] arrayOfInt = new int[1];
      GLES20.glGetShaderiv(i, 35713, arrayOfInt, 0);
      zzes("getShaderiv");
      if (arrayOfInt[0] == 0)
      {
        Log.e("SphericalVideoRenderer", 37 + "Could not compile shader " + paramInt + ":");
        Log.e("SphericalVideoRenderer", GLES20.glGetShaderInfoLog(i));
        GLES20.glDeleteShader(i);
        zzes("deleteShader");
        return 0;
      }
    }
    return i;
  }

  private static void zzes(String paramString)
  {
    int i = GLES20.glGetError();
    if (i != 0)
      Log.e("SphericalVideoRenderer", 21 + String.valueOf(paramString).length() + paramString + ": glError " + i);
  }

  @VisibleForTesting
  private final boolean zzxz()
  {
    EGLSurface localEGLSurface1 = this.zzeeb;
    boolean bool = false;
    if (localEGLSurface1 != null)
    {
      EGLSurface localEGLSurface2 = this.zzeeb;
      EGLSurface localEGLSurface3 = EGL10.EGL_NO_SURFACE;
      bool = false;
      if (localEGLSurface2 != localEGLSurface3)
      {
        bool = false | this.zzedy.eglMakeCurrent(this.zzedz, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT) | this.zzedy.eglDestroySurface(this.zzedz, this.zzeeb);
        this.zzeeb = null;
      }
    }
    if (this.zzeea != null)
    {
      bool |= this.zzedy.eglDestroyContext(this.zzedz, this.zzeea);
      this.zzeea = null;
    }
    if (this.zzedz != null)
    {
      bool |= this.zzedy.eglTerminate(this.zzedz);
      this.zzedz = null;
    }
    return bool;
  }

  public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    this.zzedu = (1 + this.zzedu);
    synchronized (this.zzedx)
    {
      this.zzedx.notifyAll();
      return;
    }
  }

  public final void run()
  {
    int i = 1;
    if (this.zzedr == null)
    {
      zzaxa.zzen("SphericalVideoProcessor started with no output texture.");
      this.zzedw.countDown();
      return;
    }
    this.zzedy = ((EGL10)EGLContext.getEGL());
    this.zzedz = this.zzedy.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    int j;
    String str1;
    label101: int k;
    int n;
    label119: int i2;
    label371: String str3;
    if (this.zzedz == EGL10.EGL_NO_DISPLAY)
    {
      j = 0;
      zzaci localzzaci1 = zzact.zzcqf;
      if (((String)zzyr.zzpe().zzd(localzzaci1)).equals(localzzaci1.zzqm()))
        break label761;
      str1 = (String)zzyr.zzpe().zzd(localzzaci1);
      k = zzd(35633, str1);
      if (k != 0)
        break label769;
      n = 0;
      this.zzeds = n;
      GLES20.glUseProgram(this.zzeds);
      zzes("useProgram");
      int i1 = GLES20.glGetAttribLocation(this.zzeds, "aPosition");
      GLES20.glVertexAttribPointer(i1, 3, 5126, false, 12, this.zzedv);
      zzes("vertexAttribPointer");
      GLES20.glEnableVertexAttribArray(i1);
      zzes("enableVertexAttribArray");
      int[] arrayOfInt2 = new int[i];
      GLES20.glGenTextures(i, arrayOfInt2, 0);
      zzes("genTextures");
      i2 = arrayOfInt2[0];
      GLES20.glBindTexture(36197, i2);
      zzes("bindTextures");
      GLES20.glTexParameteri(36197, 10240, 9729);
      zzes("texParameteri");
      GLES20.glTexParameteri(36197, 10241, 9729);
      zzes("texParameteri");
      GLES20.glTexParameteri(36197, 10242, 33071);
      zzes("texParameteri");
      GLES20.glTexParameteri(36197, 10243, 33071);
      zzes("texParameteri");
      this.zzedt = GLES20.glGetUniformLocation(this.zzeds, "uVMat");
      float[] arrayOfFloat1 = { 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F };
      GLES20.glUniformMatrix3fv(this.zzedt, i, false, arrayOfFloat1, 0);
      if (this.zzeds == 0)
        break label972;
      if ((j != 0) && (i != 0))
        break label992;
      str3 = String.valueOf(GLUtils.getEGLErrorString(this.zzedy.eglGetError()));
      if (str3.length() == 0)
        break label977;
    }
    label769: label838: label972: label977: for (String str4 = "EGL initialization failed: ".concat(str3); ; str4 = new String("EGL initialization failed: "))
    {
      zzaxa.zzen(str4);
      zzk.zzlk().zza(new Throwable(str4), "SphericalVideoProcessor.run.1");
      zzxz();
      this.zzedw.countDown();
      return;
      int[] arrayOfInt1 = new int[2];
      if (!this.zzedy.eglInitialize(this.zzedz, arrayOfInt1))
      {
        j = 0;
        break;
      }
      int[] arrayOfInt4 = new int[i];
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
      int[] arrayOfInt5 = { 12352, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12344 };
      if ((this.zzedy.eglChooseConfig(this.zzedz, arrayOfInt5, arrayOfEGLConfig, i, arrayOfInt4)) && (arrayOfInt4[0] > 0));
      for (EGLConfig localEGLConfig = arrayOfEGLConfig[0]; ; localEGLConfig = null)
      {
        if (localEGLConfig != null)
          break label610;
        j = 0;
        break;
      }
      label610: int[] arrayOfInt6 = { 12440, 2, 12344 };
      this.zzeea = this.zzedy.eglCreateContext(this.zzedz, localEGLConfig, EGL10.EGL_NO_CONTEXT, arrayOfInt6);
      if ((this.zzeea == null) || (this.zzeea == EGL10.EGL_NO_CONTEXT))
      {
        j = 0;
        break;
      }
      this.zzeeb = this.zzedy.eglCreateWindowSurface(this.zzedz, localEGLConfig, this.zzedr, null);
      if ((this.zzeeb == null) || (this.zzeeb == EGL10.EGL_NO_SURFACE))
      {
        j = 0;
        break;
      }
      if (!this.zzedy.eglMakeCurrent(this.zzedz, this.zzeeb, this.zzeeb, this.zzeea))
      {
        j = 0;
        break;
      }
      j = i;
      break;
      label761: str1 = "attribute highp vec3 aPosition;varying vec3 pos;void main() {  gl_Position = vec4(aPosition, 1.0);  pos = aPosition;}";
      break label101;
      zzaci localzzaci2 = zzact.zzcqg;
      if (!((String)zzyr.zzpe().zzd(localzzaci2)).equals(localzzaci2.zzqm()));
      int m;
      for (String str2 = (String)zzyr.zzpe().zzd(localzzaci2); ; str2 = "#extension GL_OES_EGL_image_external : require\n#define INV_PI 0.3183\nprecision highp float;varying vec3 pos;uniform samplerExternalOES uSplr;uniform mat3 uVMat;uniform float uFOVx;uniform float uFOVy;void main() {  vec3 ray = vec3(pos.x * tan(uFOVx), pos.y * tan(uFOVy), -1);  ray = (uVMat * ray).xyz;  ray = normalize(ray);  vec2 texCrd = vec2(    0.5 + atan(ray.x, - ray.z) * INV_PI * 0.5, acos(ray.y) * INV_PI);  gl_FragColor = vec4(texture2D(uSplr, texCrd).xyz, 1.0);}")
      {
        m = zzd(35632, str2);
        if (m != 0)
          break label838;
        n = 0;
        break;
      }
      n = GLES20.glCreateProgram();
      zzes("createProgram");
      if (n == 0)
        break label119;
      GLES20.glAttachShader(n, k);
      zzes("attachShader");
      GLES20.glAttachShader(n, m);
      zzes("attachShader");
      GLES20.glLinkProgram(n);
      zzes("linkProgram");
      int[] arrayOfInt3 = new int[i];
      GLES20.glGetProgramiv(n, 35714, arrayOfInt3, 0);
      zzes("getProgramiv");
      if (arrayOfInt3[0] != i)
      {
        Log.e("SphericalVideoRenderer", "Could not link program: ");
        Log.e("SphericalVideoRenderer", GLES20.glGetProgramInfoLog(n));
        GLES20.glDeleteProgram(n);
        zzes("deleteProgram");
        n = 0;
        break label119;
      }
      GLES20.glValidateProgram(n);
      zzes("validateProgram");
      break label119;
      i = 0;
      break label371;
    }
    label992: this.zzedq = new SurfaceTexture(i2);
    this.zzedq.setOnFrameAvailableListener(this);
    this.zzedw.countDown();
    this.zzedg.start();
    try
    {
      this.zzeec = true;
      if (!this.zzeed)
        while (this.zzedu > 0)
        {
          this.zzedq.updateTexImage();
          this.zzedu = (-1 + this.zzedu);
        }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      zzaxa.zzep("SphericalVideoProcessor halted unexpectedly.");
      return;
      if (this.zzedg.zza(this.zzedc))
      {
        if (Float.isNaN(this.zzedn))
        {
          float[] arrayOfFloat2 = this.zzedc;
          float[] arrayOfFloat3 = { 0.0F, 1.0F, 0.0F };
          float[] arrayOfFloat4 = new float[3];
          arrayOfFloat4[0] = (arrayOfFloat2[0] * arrayOfFloat3[0] + arrayOfFloat2[1] * arrayOfFloat3[1] + arrayOfFloat2[2] * arrayOfFloat3[2]);
          arrayOfFloat4[1] = (arrayOfFloat2[3] * arrayOfFloat3[0] + arrayOfFloat2[4] * arrayOfFloat3[1] + arrayOfFloat2[5] * arrayOfFloat3[2]);
          arrayOfFloat4[2] = (arrayOfFloat2[6] * arrayOfFloat3[0] + arrayOfFloat2[7] * arrayOfFloat3[1] + arrayOfFloat2[8] * arrayOfFloat3[2]);
          this.zzedn = (-((float)Math.atan2(arrayOfFloat4[1], arrayOfFloat4[0]) - 1.570796F));
        }
        zzb(this.zzedl, this.zzedn + this.zzedo);
      }
      while (true)
      {
        zza(this.zzedh, 1.570796F);
        zza(this.zzedi, this.zzedl, this.zzedh);
        zza(this.zzedj, this.zzedc, this.zzedi);
        zza(this.zzedk, this.zzedp);
        zza(this.zzedm, this.zzedk, this.zzedj);
        GLES20.glUniformMatrix3fv(this.zzedt, 1, false, this.zzedm, 0);
        GLES20.glDrawArrays(5, 0, 4);
        zzes("drawArrays");
        GLES20.glFinish();
        this.zzedy.eglSwapBuffers(this.zzedz, this.zzeeb);
        if (this.zzeec)
        {
          GLES20.glViewport(0, 0, this.width, this.height);
          zzes("viewport");
          i3 = GLES20.glGetUniformLocation(this.zzeds, "uFOVx");
          i4 = GLES20.glGetUniformLocation(this.zzeds, "uFOVy");
          if (this.width <= this.height)
            break label1627;
          GLES20.glUniform1f(i3, 0.8726646F);
          GLES20.glUniform1f(i4, 0.8726646F * this.height / this.width);
          this.zzeec = false;
        }
        try
        {
          synchronized (this.zzedx)
          {
            if ((!this.zzeed) && (!this.zzeec) && (this.zzedu == 0))
              this.zzedx.wait();
          }
        }
        catch (InterruptedException localInterruptedException)
        {
        }
        break;
        zza(this.zzedc, -1.570796F);
        zzb(this.zzedl, this.zzedo);
      }
    }
    catch (Throwable localThrowable)
    {
      while (true)
      {
        int i3;
        int i4;
        zzaxa.zzc("SphericalVideoProcessor died.", localThrowable);
        zzk.zzlk().zza(localThrowable, "SphericalVideoProcessor.run.2");
        return;
        label1627: GLES20.glUniform1f(i3, 0.8726646F * this.width / this.height);
        GLES20.glUniform1f(i4, 0.8726646F);
      }
    }
    finally
    {
      this.zzedg.stop();
      this.zzedq.setOnFrameAvailableListener(null);
      this.zzedq = null;
      zzxz();
    }
    this.zzedg.stop();
    this.zzedq.setOnFrameAvailableListener(null);
    this.zzedq = null;
    zzxz();
  }

  public final void zza(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.zzedr = paramSurfaceTexture;
  }

  public final void zzb(float paramFloat1, float paramFloat2)
  {
    float f1;
    if (this.width > this.height)
      f1 = 1.745329F * paramFloat1 / this.width;
    for (float f2 = 1.745329F * paramFloat2 / this.width; ; f2 = 1.745329F * paramFloat2 / this.height)
    {
      this.zzedo -= f1;
      this.zzedp -= f2;
      if (this.zzedp < -1.570796F)
        this.zzedp = -1.570796F;
      if (this.zzedp > 1.570796F)
        this.zzedp = 1.570796F;
      return;
      f1 = 1.745329F * paramFloat1 / this.height;
    }
  }

  public final void zzm(int paramInt1, int paramInt2)
  {
    synchronized (this.zzedx)
    {
      this.width = paramInt1;
      this.height = paramInt2;
      this.zzeec = true;
      this.zzedx.notifyAll();
      return;
    }
  }

  public final void zztk()
  {
    synchronized (this.zzedx)
    {
      this.zzedx.notifyAll();
      return;
    }
  }

  public final void zzxx()
  {
    synchronized (this.zzedx)
    {
      this.zzeed = true;
      this.zzedr = null;
      this.zzedx.notifyAll();
      return;
    }
  }

  public final SurfaceTexture zzxy()
  {
    if (this.zzedr == null)
      return null;
    try
    {
      this.zzedw.await();
      label16: return this.zzedq;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label16;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbde
 * JD-Core Version:    0.6.2
 */