package com.my.target;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.FrameLayout;

public class aq extends Dialog
{
  private final a a;

  private aq(a parama, Context paramContext)
  {
    super(paramContext);
    this.a = parama;
  }

  public static aq a(a parama, Context paramContext)
  {
    return new aq(parama, paramContext);
  }

  public void a()
  {
    Window localWindow = getWindow();
    if (localWindow != null)
      localWindow.setFlags(1024, 1024);
  }

  public void dismiss()
  {
    super.dismiss();
    this.a.a();
  }

  protected void onCreate(Bundle paramBundle)
  {
    requestWindowFeature(1);
    FrameLayout localFrameLayout = new FrameLayout(getContext());
    setContentView(localFrameLayout);
    Window localWindow = getWindow();
    if (localWindow != null)
    {
      localWindow.setBackgroundDrawable(new ColorDrawable(0));
      localWindow.setLayout(-1, -1);
    }
    this.a.a(this, localFrameLayout);
    super.onCreate(paramBundle);
  }

  public void onWindowFocusChanged(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(aq paramaq, FrameLayout paramFrameLayout);

    public abstract void a(boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.aq
 * JD-Core Version:    0.6.2
 */