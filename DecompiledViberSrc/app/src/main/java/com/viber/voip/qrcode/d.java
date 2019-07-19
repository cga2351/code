package com.viber.voip.qrcode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.e.e;
import com.google.e.i;
import com.google.e.k;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.dq;
import java.util.Map;

final class d extends Handler
{
  private static final Logger a = ViberEnv.getLogger();
  private final ScannerActivity b;
  private final i c = new i();
  private boolean d = true;

  d(ScannerActivity paramScannerActivity, Map<e, Object> paramMap)
  {
    this.c.a(paramMap);
    this.b = paramScannerActivity;
  }

  private static void a(k paramk, Bundle paramBundle)
  {
    int[] arrayOfInt = paramk.f();
    int i = paramk.g();
    paramBundle.putByteArray("barcode_bitmap", dq.a(Bitmap.createBitmap(arrayOfInt, 0, i, i, paramk.h(), Bitmap.Config.ARGB_8888), Bitmap.CompressFormat.JPEG, 50));
    paramBundle.putFloat("barcode_scaled_factor", i / paramk.b());
  }

  // ERROR //
  private void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: invokestatic 100	java/lang/System:currentTimeMillis	()J
    //   3: pop2
    //   4: aload_0
    //   5: getfield 38	com/viber/voip/qrcode/d:b	Lcom/viber/voip/qrcode/ScannerActivity;
    //   8: invokevirtual 105	com/viber/voip/qrcode/ScannerActivity:f	()Lcom/viber/voip/qrcode/c;
    //   11: aload_1
    //   12: iload_2
    //   13: iload_3
    //   14: invokevirtual 110	com/viber/voip/qrcode/c:a	([BII)Lcom/google/e/k;
    //   17: astore 6
    //   19: aconst_null
    //   20: astore 7
    //   22: aload 6
    //   24: ifnull +43 -> 67
    //   27: new 112	com/google/e/c
    //   30: dup
    //   31: new 114	com/google/e/c/j
    //   34: dup
    //   35: aload 6
    //   37: invokespecial 117	com/google/e/c/j:<init>	(Lcom/google/e/h;)V
    //   40: invokespecial 120	com/google/e/c:<init>	(Lcom/google/e/b;)V
    //   43: astore 8
    //   45: aload_0
    //   46: getfield 33	com/viber/voip/qrcode/d:c	Lcom/google/e/i;
    //   49: aload 8
    //   51: invokevirtual 123	com/google/e/i:a	(Lcom/google/e/c;)Lcom/google/e/n;
    //   54: astore 16
    //   56: aload 16
    //   58: astore 7
    //   60: aload_0
    //   61: getfield 33	com/viber/voip/qrcode/d:c	Lcom/google/e/i;
    //   64: invokevirtual 125	com/google/e/i:a	()V
    //   67: aload_0
    //   68: getfield 38	com/viber/voip/qrcode/d:b	Lcom/viber/voip/qrcode/ScannerActivity;
    //   71: invokevirtual 129	com/viber/voip/qrcode/ScannerActivity:e	()Landroid/os/Handler;
    //   74: astore 11
    //   76: aload 7
    //   78: ifnull +80 -> 158
    //   81: invokestatic 100	java/lang/System:currentTimeMillis	()J
    //   84: pop2
    //   85: aload 11
    //   87: ifnull +43 -> 130
    //   90: aload 11
    //   92: getstatic 135	com/viber/voip/R$id:decode_succeeded	I
    //   95: aload 7
    //   97: invokestatic 141	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   100: astore 14
    //   102: new 79	android/os/Bundle
    //   105: dup
    //   106: invokespecial 142	android/os/Bundle:<init>	()V
    //   109: astore 15
    //   111: aload 6
    //   113: aload 15
    //   115: invokestatic 144	com/viber/voip/qrcode/d:a	(Lcom/google/e/k;Landroid/os/Bundle;)V
    //   118: aload 14
    //   120: aload 15
    //   122: invokevirtual 148	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   125: aload 14
    //   127: invokevirtual 151	android/os/Message:sendToTarget	()V
    //   130: return
    //   131: astore 10
    //   133: aload_0
    //   134: getfield 33	com/viber/voip/qrcode/d:c	Lcom/google/e/i;
    //   137: invokevirtual 125	com/google/e/i:a	()V
    //   140: aconst_null
    //   141: astore 7
    //   143: goto -76 -> 67
    //   146: astore 9
    //   148: aload_0
    //   149: getfield 33	com/viber/voip/qrcode/d:c	Lcom/google/e/i;
    //   152: invokevirtual 125	com/google/e/i:a	()V
    //   155: aload 9
    //   157: athrow
    //   158: aload 11
    //   160: ifnull -30 -> 130
    //   163: aload 11
    //   165: getstatic 154	com/viber/voip/R$id:decode_failed	I
    //   168: invokestatic 157	android/os/Message:obtain	(Landroid/os/Handler;I)Landroid/os/Message;
    //   171: invokevirtual 151	android/os/Message:sendToTarget	()V
    //   174: return
    //
    // Exception table:
    //   from	to	target	type
    //   45	56	131	com/google/e/m
    //   45	56	146	finally
  }

  public void handleMessage(Message paramMessage)
  {
    if (!this.d);
    do
    {
      return;
      if (paramMessage.what == R.id.decode)
      {
        a((byte[])paramMessage.obj, paramMessage.arg1, paramMessage.arg2);
        return;
      }
    }
    while (paramMessage.what != R.id.quit);
    this.d = false;
    Looper.myLooper().quit();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.qrcode.d
 * JD-Core Version:    0.6.2
 */