package e.a.a;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class b
{
  protected Field a;
  protected Method b;
  protected Method c;
  protected int d;
  protected Class<?> e;
  protected Type f;
  protected String g;

  public b(Class<?> paramClass, Field paramField, j paramj)
  {
    this.g = paramField.getName();
    int i = paramField.getModifiers();
    if ((i & 0x88) > 0);
    while (true)
    {
      return;
      if ((i & 0x1) > 0)
        this.a = paramField;
      String str1 = a.a(paramField.getName());
      try
      {
        Class[] arrayOfClass = new Class[1];
        arrayOfClass[0] = paramField.getType();
        this.b = paramClass.getDeclaredMethod(str1, arrayOfClass);
        label75: boolean bool = paramField.getType().equals(Boolean.TYPE);
        String str2;
        if (bool)
          str2 = a.c(paramField.getName());
        try
        {
          this.c = paramClass.getDeclaredMethod(str2, new Class[0]);
          label115: if ((this.c == null) && (bool));
          try
          {
            this.c = paramClass.getDeclaredMethod(a.b(paramField.getName()), new Class[0]);
            label146: if ((this.a == null) && (this.c == null) && (this.b == null))
              continue;
            if ((this.c != null) && (!paramj.a(paramField, this.c)))
              this.c = null;
            if ((this.b != null) && (!paramj.a(paramField, this.b)))
              this.b = null;
            if ((this.c == null) && (this.b == null) && (this.a == null))
              continue;
            this.e = paramField.getType();
            this.f = paramField.getGenericType();
            return;
            str2 = a.b(paramField.getName());
          }
          catch (Exception localException3)
          {
            break label146;
          }
        }
        catch (Exception localException2)
        {
          break label115;
        }
      }
      catch (Exception localException1)
      {
        break label75;
      }
    }
  }

  public int a()
  {
    return this.d;
  }

  public boolean b()
  {
    return this.b == null;
  }

  public boolean c()
  {
    return this.e.isEnum();
  }

  public String d()
  {
    return this.g;
  }

  public Class<?> e()
  {
    return this.e;
  }

  public boolean f()
  {
    return (this.a != null) || (this.c != null) || (this.b != null);
  }

  public boolean g()
  {
    return (this.a != null) || (this.c != null);
  }

  public boolean h()
  {
    return (this.a != null) || (this.c != null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     e.a.a.b
 * JD-Core Version:    0.6.2
 */