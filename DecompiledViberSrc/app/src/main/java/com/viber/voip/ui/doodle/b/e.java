package com.viber.voip.ui.doodle.b;

import android.content.Context;
import android.os.Bundle;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.ui.doodle.a.a.a.b;
import com.viber.voip.ui.doodle.extras.g;
import com.viber.voip.ui.doodle.objects.BaseObject;
import com.viber.voip.ui.doodle.objects.BaseObject.a;
import com.viber.voip.ui.doodle.objects.BitmapObject;
import com.viber.voip.ui.doodle.objects.a.c;
import com.viber.voip.ui.doodle.scene.SceneConfig;

class e extends d<BitmapObject>
{
  private static final Logger f = ViberEnv.getLogger();
  private final c g = new c();

  e(Context paramContext, com.viber.voip.ui.doodle.scene.a parama, a.b paramb, com.viber.voip.ui.doodle.undo.a parama1, com.viber.voip.ui.doodle.objects.c.a parama2, g paramg, c.a parama3, Bundle paramBundle)
  {
    super(paramContext, parama, paramb, parama1, parama2, paramg, parama3, paramBundle);
  }

  void a(Sticker paramSticker)
  {
    c(this.g.a(new com.viber.voip.ui.doodle.objects.b.d(this.e.a(), this.b.f().getSceneCenterPoint(), this.b.f(), paramSticker)));
  }

  protected boolean a(BaseObject paramBaseObject)
  {
    return BaseObject.a.b == paramBaseObject.getType();
  }

  public c.b c()
  {
    return c.b.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.b.e
 * JD-Core Version:    0.6.2
 */