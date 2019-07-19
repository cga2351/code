package com.viber.voip.qrcode;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.google.e.n;
import com.viber.voip.R.id;
import com.viber.voip.util.dq;

public final class h extends Handler
{
  private final ScannerActivity a;
  private final e b;
  private a c;
  private final c d;

  h(ScannerActivity paramScannerActivity, c paramc)
  {
    this.a = paramScannerActivity;
    this.b = new e(paramScannerActivity, null);
    this.b.start();
    this.c = a.b;
    this.d = paramc;
    paramc.c();
  }

  private void b()
  {
    if ((this.c == a.b) || (this.c == a.c))
    {
      this.c = a.a;
      this.d.a(this.b.a(), R.id.decode);
      this.a.g();
    }
  }

  public void a()
  {
    this.c = a.d;
    this.d.d();
    Message.obtain(this.b.a(), R.id.quit).sendToTarget();
    try
    {
      this.b.join(500L);
      label40: removeMessages(R.id.decode_succeeded);
      removeMessages(R.id.decode_failed);
      removeMessages(R.id.pause_decoding);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label40;
    }
  }

  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == R.id.restart_preview)
    {
      b();
      return;
    }
    float f;
    Bitmap localBitmap2;
    if (paramMessage.what == R.id.decode_succeeded)
    {
      this.c = a.b;
      Bundle localBundle = paramMessage.getData();
      f = 1.0F;
      if (localBundle == null)
        break label203;
      byte[] arrayOfByte = localBundle.getByteArray("barcode_bitmap");
      localBitmap2 = null;
      if (arrayOfByte != null)
        localBitmap2 = dq.a(arrayOfByte, 0, arrayOfByte.length, null).copy(Bitmap.Config.ARGB_8888, true);
      f = localBundle.getFloat("barcode_scaled_factor");
    }
    label203: for (Bitmap localBitmap1 = localBitmap2; ; localBitmap1 = null)
    {
      this.a.a((n)paramMessage.obj, localBitmap1, f);
      return;
      if (paramMessage.what == R.id.decode_failed)
      {
        if (this.c == a.c)
          break;
        this.c = a.a;
        this.d.a(this.b.a(), R.id.decode);
        return;
      }
      if (paramMessage.what == R.id.return_scan_result)
      {
        this.a.setResult(-1, (Intent)paramMessage.obj);
        this.a.finish();
        return;
      }
      if (paramMessage.what != R.id.pause_decoding)
        break;
      this.c = a.c;
      return;
    }
  }

  private static enum a
  {
    static
    {
      a[] arrayOfa = new a[4];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.qrcode.h
 * JD-Core Version:    0.6.2
 */