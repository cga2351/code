package com.viber.voip.messages.conversation.adapter.viewbinders.helpers.file;

import com.viber.voip.messages.conversation.aa;
import com.viber.voip.widget.FileIconView;
import com.viber.voip.widget.FileIconView.a;
import com.viber.voip.widget.FileIconView.e;

public abstract class b
{
  protected final FileIconView a;

  public b(FileIconView paramFileIconView)
  {
    this.a = paramFileIconView;
  }

  public abstract void a();

  public void a(double paramDouble)
  {
    this.a.a(paramDouble);
  }

  public abstract void a(aa paramaa);

  public void a(Runnable paramRunnable)
  {
    this.a.post(paramRunnable);
  }

  public FileIconView.e b()
  {
    return this.a.getUploadIcon();
  }

  public abstract void b(aa paramaa);

  public void b(Runnable paramRunnable)
  {
    this.a.removeCallbacks(paramRunnable);
  }

  public FileIconView.a c()
  {
    return this.a.getDownloadIcon();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.file.b
 * JD-Core Version:    0.6.2
 */