package com.viber.voip.messages.ui.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class b extends c
{
  private static final Logger b = ViberEnv.getLogger();
  private final Rect c = new Rect();
  private Drawable d;
  private Canvas e;
  private Bitmap f;

  public b(Drawable[] paramArrayOfDrawable)
  {
    super(paramArrayOfDrawable);
  }

  private void a(Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.f, 0.0F, 0.0F, null);
  }

  // ERROR //
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 48	com/viber/voip/messages/ui/a/b:d	Landroid/graphics/drawable/Drawable;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 34	com/viber/voip/messages/ui/a/b:c	Landroid/graphics/Rect;
    //   12: aload_0
    //   13: getfield 48	com/viber/voip/messages/ui/a/b:d	Landroid/graphics/drawable/Drawable;
    //   16: invokevirtual 54	android/graphics/drawable/Drawable:getBounds	()Landroid/graphics/Rect;
    //   19: invokevirtual 58	android/graphics/Rect:set	(Landroid/graphics/Rect;)V
    //   22: aload_0
    //   23: getfield 48	com/viber/voip/messages/ui/a/b:d	Landroid/graphics/drawable/Drawable;
    //   26: iconst_0
    //   27: iconst_0
    //   28: aload_0
    //   29: getfield 60	com/viber/voip/messages/ui/a/b:e	Landroid/graphics/Canvas;
    //   32: invokevirtual 64	android/graphics/Canvas:getWidth	()I
    //   35: aload_0
    //   36: getfield 60	com/viber/voip/messages/ui/a/b:e	Landroid/graphics/Canvas;
    //   39: invokevirtual 67	android/graphics/Canvas:getHeight	()I
    //   42: invokevirtual 71	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   45: aload_0
    //   46: getfield 48	com/viber/voip/messages/ui/a/b:d	Landroid/graphics/drawable/Drawable;
    //   49: aload_0
    //   50: getfield 60	com/viber/voip/messages/ui/a/b:e	Landroid/graphics/Canvas;
    //   53: invokevirtual 74	android/graphics/drawable/Drawable:draw	(Landroid/graphics/Canvas;)V
    //   56: aload_0
    //   57: getfield 48	com/viber/voip/messages/ui/a/b:d	Landroid/graphics/drawable/Drawable;
    //   60: aload_0
    //   61: getfield 34	com/viber/voip/messages/ui/a/b:c	Landroid/graphics/Rect;
    //   64: invokevirtual 76	android/graphics/drawable/Drawable:setBounds	(Landroid/graphics/Rect;)V
    //   67: return
    //   68: astore_2
    //   69: aload_0
    //   70: getfield 48	com/viber/voip/messages/ui/a/b:d	Landroid/graphics/drawable/Drawable;
    //   73: aload_0
    //   74: getfield 34	com/viber/voip/messages/ui/a/b:c	Landroid/graphics/Rect;
    //   77: invokevirtual 76	android/graphics/drawable/Drawable:setBounds	(Landroid/graphics/Rect;)V
    //   80: return
    //   81: astore_1
    //   82: aload_0
    //   83: getfield 48	com/viber/voip/messages/ui/a/b:d	Landroid/graphics/drawable/Drawable;
    //   86: aload_0
    //   87: getfield 34	com/viber/voip/messages/ui/a/b:c	Landroid/graphics/Rect;
    //   90: invokevirtual 76	android/graphics/drawable/Drawable:setBounds	(Landroid/graphics/Rect;)V
    //   93: aload_1
    //   94: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   22	56	68	java/lang/OutOfMemoryError
    //   22	56	81	finally
  }

  protected void a()
  {
    this.f.eraseColor(0);
  }

  protected void a(Canvas paramCanvas, Drawable paramDrawable)
  {
    this.d = paramDrawable;
    c();
    a(paramCanvas);
  }

  protected void a(Canvas paramCanvas, Drawable paramDrawable1, Drawable paramDrawable2, int paramInt, boolean paramBoolean)
  {
    this.d = paramDrawable1;
    if (paramBoolean)
      this.d.setAlpha(255 - paramInt);
    c();
    if (paramBoolean)
      this.d.setAlpha(255);
    if (paramInt > 0)
    {
      this.d = paramDrawable2;
      this.d.setAlpha(paramInt);
      c();
      this.d.setAlpha(255);
    }
    a(paramCanvas);
  }

  protected boolean b()
  {
    Rect localRect = getBounds();
    if (localRect.isEmpty())
      return false;
    if ((this.f == null) || (this.f.getWidth() != localRect.width()) || (this.f.getHeight() != localRect.height()))
    {
      this.f = Bitmap.createBitmap(localRect.width(), localRect.height(), Bitmap.Config.ARGB_8888);
      this.e = new Canvas(this.f);
    }
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.a.b
 * JD-Core Version:    0.6.2
 */