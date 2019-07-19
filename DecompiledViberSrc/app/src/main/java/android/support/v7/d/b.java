package android.support.v7.d;

public class b
  implements d
{
  final d a;
  int b = 0;
  int c = -1;
  int d = -1;
  Object e = null;

  public b(d paramd)
  {
    this.a = paramd;
  }

  public void a()
  {
    if (this.b == 0)
      return;
    switch (this.b)
    {
    default:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      this.e = null;
      this.b = 0;
      return;
      this.a.onInserted(this.c, this.d);
      continue;
      this.a.onRemoved(this.c, this.d);
      continue;
      this.a.onChanged(this.c, this.d, this.e);
    }
  }

  public void onChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    if ((this.b == 3) && (paramInt1 <= this.c + this.d) && (paramInt1 + paramInt2 >= this.c) && (this.e == paramObject))
    {
      int i = this.c + this.d;
      this.c = Math.min(paramInt1, this.c);
      this.d = (Math.max(i, paramInt1 + paramInt2) - this.c);
      return;
    }
    a();
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramObject;
    this.b = 3;
  }

  public void onInserted(int paramInt1, int paramInt2)
  {
    if ((this.b == 1) && (paramInt1 >= this.c) && (paramInt1 <= this.c + this.d))
    {
      this.d = (paramInt2 + this.d);
      this.c = Math.min(paramInt1, this.c);
      return;
    }
    a();
    this.c = paramInt1;
    this.d = paramInt2;
    this.b = 1;
  }

  public void onMoved(int paramInt1, int paramInt2)
  {
    a();
    this.a.onMoved(paramInt1, paramInt2);
  }

  public void onRemoved(int paramInt1, int paramInt2)
  {
    if ((this.b == 2) && (this.c >= paramInt1) && (this.c <= paramInt1 + paramInt2))
    {
      this.d = (paramInt2 + this.d);
      this.c = paramInt1;
      return;
    }
    a();
    this.c = paramInt1;
    this.d = paramInt2;
    this.b = 2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.d.b
 * JD-Core Version:    0.6.2
 */