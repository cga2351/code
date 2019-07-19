package com.viber.voip.ui.doodle.b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.ui.doodle.a.a.a.b;
import com.viber.voip.ui.doodle.commands.movable.c;
import com.viber.voip.ui.doodle.extras.TextInfo;
import com.viber.voip.ui.doodle.extras.g;
import com.viber.voip.ui.doodle.objects.BaseObject;
import com.viber.voip.ui.doodle.objects.BaseObject.a;
import com.viber.voip.ui.doodle.objects.TextObject;
import com.viber.voip.ui.doodle.objects.b.e;
import com.viber.voip.ui.doodle.scene.SceneConfig;
import com.viber.voip.ui.doodle.undo.EditTextUndo;

class f extends d<TextObject>
{
  private static final Logger f = ViberEnv.getLogger();
  private final Context g;
  private final com.viber.voip.ui.doodle.objects.a.d h;

  f(Context paramContext, com.viber.voip.ui.doodle.scene.a parama, a.b paramb, com.viber.voip.ui.doodle.undo.a parama1, com.viber.voip.ui.doodle.objects.c.a parama2, g paramg, c.a parama3, Bundle paramBundle)
  {
    super(paramContext, parama, paramb, parama1, parama2, paramg, parama3, paramBundle);
    this.g = paramContext;
    this.h = new com.viber.voip.ui.doodle.objects.a.d();
  }

  private void c(TextInfo paramTextInfo)
  {
    c(this.h.a(new e(this.e.a(), this.g, this.b.f().getSceneCenterPoint(), this.b.f(), paramTextInfo)));
  }

  private void d(TextInfo paramTextInfo)
  {
    TextObject localTextObject = (TextObject)this.d.a(paramTextInfo.geId());
    if (localTextObject == null)
      return;
    if (TextUtils.isEmpty(paramTextInfo.getText()))
    {
      a(new c());
      return;
    }
    TextInfo localTextInfo = (TextInfo)localTextObject.getEditableInfo();
    if (localTextInfo != null)
      a(new EditTextUndo(localTextInfo));
    localTextObject.update(paramTextInfo);
    this.b.e(localTextObject);
  }

  boolean a(TextInfo paramTextInfo)
  {
    return (paramTextInfo.geId() <= 0L) && (TextUtils.isEmpty(paramTextInfo.getText()));
  }

  protected boolean a(BaseObject paramBaseObject)
  {
    return BaseObject.a.c == paramBaseObject.getType();
  }

  void b(TextInfo paramTextInfo)
  {
    if (paramTextInfo.geId() > 0L)
      d(paramTextInfo);
    while (TextUtils.isEmpty(paramTextInfo.getText()))
      return;
    c(paramTextInfo);
  }

  public c.b c()
  {
    return c.b.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.b.f
 * JD-Core Version:    0.6.2
 */