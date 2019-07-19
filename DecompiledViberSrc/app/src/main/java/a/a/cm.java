package a.a;

import java.util.concurrent.Executor;

public class cm
  implements cj
{
  private final cd a;
  private final fg b;
  private final d c;
  private final d d;
  private final Executor e;
  private final cx f;
  private final dd g;
  private final ct h;
  private au i;

  public cm(cd paramcd, fg paramfg, d paramd1, d paramd2, Executor paramExecutor, cx paramcx, dd paramdd, ct paramct)
  {
    this.a = paramcd;
    this.b = paramfg;
    this.c = paramd1;
    this.d = paramd2;
    this.e = paramExecutor;
    this.f = paramcx;
    this.g = paramdd;
    this.h = paramct;
  }

  private ca a(ch paramch)
  {
    return new ca(paramch, this.a, this.b, this.c, this.d, this.f, this.i, this.g, this.h);
  }

  public void a(au paramau)
  {
    this.i = paramau;
  }

  public void a(ci paramci)
  {
    ch localch = (ch)paramci;
    this.e.execute(a(localch));
  }

  public void b(ci paramci)
  {
    a((ch)paramci).run();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.cm
 * JD-Core Version:    0.6.2
 */