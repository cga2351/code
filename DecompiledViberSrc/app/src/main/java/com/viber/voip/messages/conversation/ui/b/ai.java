package com.viber.voip.messages.conversation.ui.b;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.viber.voip.analytics.story.n;
import com.viber.voip.messages.conversation.ui.i;
import com.viber.voip.p;
import com.viber.voip.util.at;
import com.viber.voip.util.dv;

public class ai
{
  private final Context a;
  private final i b;

  public ai(Context paramContext, i parami)
  {
    this.a = paramContext.getApplicationContext();
    this.b = parami;
  }

  public Uri a(String paramString, boolean paramBoolean)
  {
    return dv.a.a(this.a, paramString, paramBoolean);
  }

  public Bundle a(String paramString)
  {
    return n.b(null, paramString);
  }

  public void a()
  {
    this.b.a();
  }

  public void a(Uri paramUri)
  {
    if ((paramUri != null) && (paramUri.getPath().startsWith(p.a)))
      at.d(this.a, paramUri);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.b.ai
 * JD-Core Version:    0.6.2
 */