package com.viber.voip.notif.b.f.c;

import android.content.Context;
import android.graphics.Bitmap;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.notif.b.f.b;
import com.viber.voip.notif.b.f.b.e;
import com.viber.voip.notif.d.f.a;
import com.viber.voip.stickers.i;
import com.viber.voip.util.e.j;
import com.viber.voip.util.upload.ObjectId;

public class m extends b
{
  private final com.viber.voip.notif.i.m h;

  public m(com.viber.voip.notif.h.m paramm, e parame, com.viber.voip.notif.i.m paramm1)
  {
    super(paramm, parame);
    this.h = paramm1;
  }

  public f.a a(Context paramContext)
  {
    MessageEntity localMessageEntity = this.a.c();
    Bitmap localBitmap = j.a(this.h.a().u(localMessageEntity.getObjectId().toStickerId()));
    if (localBitmap == null)
      this.h.a(localMessageEntity);
    return new f.a(localBitmap);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.c.m
 * JD-Core Version:    0.6.2
 */