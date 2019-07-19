package com.viber.voip.messages.conversation.ui.view.b;

import android.content.Intent;
import android.net.Uri;

public class ae
{
  private final String a;
  private final String b;
  private final String c;

  public ae(Intent paramIntent)
  {
    Uri localUri = paramIntent.getData();
    this.a = localUri.getQueryParameter("lifespan");
    this.b = localUri.getQueryParameter("content");
    this.c = localUri.getQueryParameter("mime");
  }

  public String a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.view.b.ae
 * JD-Core Version:    0.6.2
 */