package e.a.b.b;

public class e extends Exception
{
  private int a;
  private Object b;
  private int c;

  public e(int paramInt1, int paramInt2, Object paramObject)
  {
    super(a(paramInt1, paramInt2, paramObject));
    this.c = paramInt1;
    this.a = paramInt2;
    this.b = paramObject;
  }

  public e(int paramInt, Throwable paramThrowable)
  {
    super(a(paramInt, 2, paramThrowable), paramThrowable);
    this.c = paramInt;
    this.a = 2;
    this.b = paramThrowable;
  }

  private static String a(int paramInt1, int paramInt2, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt2 == 0)
    {
      localStringBuilder.append("Unexpected character (");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(") at position ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(".");
    }
    while (true)
    {
      return localStringBuilder.toString();
      if (paramInt2 == 1)
      {
        localStringBuilder.append("Unexpected token ");
        localStringBuilder.append(paramObject);
        localStringBuilder.append(" at position ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(".");
      }
      else if (paramInt2 == 2)
      {
        localStringBuilder.append("Unexpected exception ");
        localStringBuilder.append(paramObject);
        localStringBuilder.append(" occur at position ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(".");
      }
      else if (paramInt2 == 3)
      {
        localStringBuilder.append("Unexpected End Of File position ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(": ");
        localStringBuilder.append(paramObject);
      }
      else if (paramInt2 == 4)
      {
        localStringBuilder.append("Unexpected unicode escape sequence ");
        localStringBuilder.append(paramObject);
        localStringBuilder.append(" at position ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(".");
      }
      else if (paramInt2 == 5)
      {
        localStringBuilder.append("Unexpected duplicate key:");
        localStringBuilder.append(paramObject);
        localStringBuilder.append(" at position ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(".");
      }
      else if (paramInt2 == 6)
      {
        localStringBuilder.append("Unexpected leading 0 in digit for token:");
        localStringBuilder.append(paramObject);
        localStringBuilder.append(" at position ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(".");
      }
      else
      {
        localStringBuilder.append("Unkown error at position ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(".");
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     e.a.b.b.e
 * JD-Core Version:    0.6.2
 */