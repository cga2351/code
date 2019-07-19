package com.viber.voip.videoconvert.gpu.e;

import com.viber.voip.videoconvert.gpu.encoders.c;
import com.viber.voip.videoconvert.gpu.encoders.c.a;
import com.viber.voip.videoconvert.gpu.f.d;
import com.viber.voip.videoconvert.gpu.f.d.a;
import com.viber.voip.videoconvert.gpu.f.d.b;

public abstract class a
  implements b
{
  protected c a;
  protected d b;
  protected b.a c;
  private d.a d;

  public void a()
  {
    if (this.b != null)
      this.b.a(new d.b()
      {
        public void a()
        {
          if (a.this.c != null)
            a.this.c.a();
        }

        public void b()
        {
          if (a.this.c != null)
            a.this.c.b();
        }
      });
  }

  public void a(b.a parama)
  {
    if (this.b != null)
      this.b.a(null);
    this.c = parama;
    a();
  }

  public void a(c paramc)
  {
    c.a locala = paramc.b();
    this.a = paramc;
    this.b.a(locala.f);
    this.b.a(locala.b, locala.c);
    this.b.a(this.d);
  }

  public void a(d paramd, d.a parama)
  {
    if (this.b != null)
      this.b.a(null);
    this.b = paramd;
    a();
    this.d = parama;
  }

  public void b()
  {
    this.b.h();
  }

  public void c()
  {
    this.b.b();
  }

  public void d()
  {
    this.b.c();
  }

  public void e()
  {
    if (this.b != null)
    {
      this.b.c();
      this.b.d();
      this.b = null;
    }
  }

  public long f()
  {
    return this.b.e();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.gpu.e.a
 * JD-Core Version:    0.6.2
 */