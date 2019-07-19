package com.viber.voip.notif.b.f.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.notif.b.f.b;
import com.viber.voip.notif.d.f.a;
import com.viber.voip.notif.h.m;

public class g extends b
{
  private final com.viber.voip.notif.i.e h;

  public g(m paramm, com.viber.voip.notif.b.f.b.e parame, com.viber.voip.notif.i.e parame1)
  {
    super(paramm, parame);
    this.h = parame1;
  }

  public f.a a(Context paramContext)
  {
    MessageEntity localMessageEntity = this.a.c();
    String str = localMessageEntity.getMediaUri();
    Bitmap localBitmap1 = null;
    Uri localUri;
    if (TextUtils.isEmpty(str))
    {
      this.h.a(localMessageEntity);
      localUri = localMessageEntity.getThumbnailUri();
      if (localUri == null)
        break label79;
    }
    label79: for (Bitmap localBitmap2 = com.viber.voip.util.e.e.a(paramContext, localUri, true); ; localBitmap2 = localBitmap1)
    {
      return new f.a(localBitmap1, localBitmap2);
      localBitmap1 = com.viber.voip.util.e.e.a(paramContext, Uri.parse(str), true);
      break;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.c.g
 * JD-Core Version:    0.6.2
 */