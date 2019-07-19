package com.viber.voip.messages.extensions.d;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.extensions.c;
import com.viber.voip.messages.ui.MessageComposerView.a;
import com.viber.voip.util.ca;

public class d
  implements TextWatcher
{
  private static final Logger a = ViberEnv.getLogger();
  private final Handler b;
  private final EditText c;
  private final b d;
  private final c e;
  private final MessageComposerView.a f;
  private Runnable g;
  private com.viber.voip.messages.extensions.d.a.a h;
  private boolean i;
  private ConversationItemLoaderEntity j;

  public d(Handler paramHandler, EditText paramEditText, b paramb, c paramc, MessageComposerView.a parama)
  {
    this.b = paramHandler;
    this.c = paramEditText;
    this.d = paramb;
    this.e = paramc;
    this.f = parama;
  }

  public com.viber.voip.messages.extensions.d.a.a a()
  {
    return this.h;
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    this.j = paramConversationItemLoaderEntity;
  }

  public void afterTextChanged(Editable paramEditable)
  {
    this.b.removeCallbacks(this.g);
    this.g = new a(paramEditable.toString());
    this.b.postDelayed(this.g, 300L);
  }

  public void b()
  {
    if (this.i);
    while (!this.d.c())
      return;
    this.i = true;
    this.c.addTextChangedListener(this);
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void c()
  {
    if (!this.i)
      return;
    this.b.removeCallbacks(this.g);
    this.c.removeTextChangedListener(this);
    this.i = false;
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  private class a
    implements Runnable
  {
    private String b;

    public a(String arg2)
    {
      Object localObject;
      this.b = localObject;
    }

    public void run()
    {
      boolean bool1 = com.viber.voip.messages.d.a.a(d.a(d.this), d.b(d.this));
      boolean bool2 = d.c(d.this).c();
      com.viber.voip.messages.extensions.d.a.a locala = null;
      if (!bool2)
      {
        locala = null;
        if (bool1)
          locala = d.d(d.this).a(this.b);
      }
      if (!ca.b(d.e(d.this), locala))
      {
        d.a(d.this, locala);
        d.c(d.this).a(d.e(d.this));
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.d.d
 * JD-Core Version:    0.6.2
 */