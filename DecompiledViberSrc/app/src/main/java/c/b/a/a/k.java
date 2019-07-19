package c.b.a.a;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

public final class k
{
  public static class a
    implements Externalizable
  {
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private List<String> e = new ArrayList();
    private boolean f;
    private String g = "";
    private boolean h;
    private boolean i = false;
    private boolean j;
    private String k = "";

    public a a(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }

    public a a(boolean paramBoolean)
    {
      this.h = true;
      this.i = paramBoolean;
      return this;
    }

    public String a()
    {
      return this.b;
    }

    public String a(int paramInt)
    {
      return (String)this.e.get(paramInt);
    }

    public a b(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }

    public String b()
    {
      return this.d;
    }

    public int c()
    {
      return this.e.size();
    }

    public a c(String paramString)
    {
      this.f = true;
      this.g = paramString;
      return this;
    }

    public a d(String paramString)
    {
      this.j = true;
      this.k = paramString;
      return this;
    }

    public String d()
    {
      return this.g;
    }

    public boolean e()
    {
      return this.i;
    }

    public boolean f()
    {
      return this.j;
    }

    public String g()
    {
      return this.k;
    }

    public void readExternal(ObjectInput paramObjectInput)
      throws IOException
    {
      a(paramObjectInput.readUTF());
      b(paramObjectInput.readUTF());
      int m = paramObjectInput.readInt();
      for (int n = 0; n < m; n++)
        this.e.add(paramObjectInput.readUTF());
      if (paramObjectInput.readBoolean())
        c(paramObjectInput.readUTF());
      if (paramObjectInput.readBoolean())
        d(paramObjectInput.readUTF());
      a(paramObjectInput.readBoolean());
    }

    public void writeExternal(ObjectOutput paramObjectOutput)
      throws IOException
    {
      paramObjectOutput.writeUTF(this.b);
      paramObjectOutput.writeUTF(this.d);
      int m = c();
      paramObjectOutput.writeInt(m);
      for (int n = 0; n < m; n++)
        paramObjectOutput.writeUTF((String)this.e.get(n));
      paramObjectOutput.writeBoolean(this.f);
      if (this.f)
        paramObjectOutput.writeUTF(this.g);
      paramObjectOutput.writeBoolean(this.j);
      if (this.j)
        paramObjectOutput.writeUTF(this.k);
      paramObjectOutput.writeBoolean(this.i);
    }
  }

  public static class b
    implements Externalizable
  {
    private boolean A;
    private k.d B = null;
    private boolean C;
    private k.d D = null;
    private boolean E;
    private k.d F = null;
    private boolean G;
    private k.d H = null;
    private boolean I;
    private String J = "";
    private boolean K;
    private int L = 0;
    private boolean M;
    private String N = "";
    private boolean O;
    private String P = "";
    private boolean Q;
    private String R = "";
    private boolean S;
    private String T = "";
    private boolean U;
    private String V = "";
    private boolean W;
    private String X = "";
    private boolean Y;
    private boolean Z = false;
    private boolean a;
    private List<k.a> aa = new ArrayList();
    private List<k.a> ab = new ArrayList();
    private boolean ac;
    private boolean ad = false;
    private boolean ae;
    private String af = "";
    private boolean ag;
    private boolean ah = false;
    private boolean ai;
    private boolean aj = false;
    private k.d b = null;
    private boolean c;
    private k.d d = null;
    private boolean e;
    private k.d f = null;
    private boolean g;
    private k.d h = null;
    private boolean i;
    private k.d j = null;
    private boolean k;
    private k.d l = null;
    private boolean m;
    private k.d n = null;
    private boolean o;
    private k.d p = null;
    private boolean q;
    private k.d r = null;
    private boolean s;
    private k.d t = null;
    private boolean u;
    private k.d v = null;
    private boolean w;
    private k.d x = null;
    private boolean y;
    private k.d z = null;

    public b a(int paramInt)
    {
      this.K = true;
      this.L = paramInt;
      return this;
    }

    public b a(k.d paramd)
    {
      if (paramd == null)
        throw new NullPointerException();
      this.a = true;
      this.b = paramd;
      return this;
    }

    public b a(String paramString)
    {
      this.I = true;
      this.J = paramString;
      return this;
    }

    public b a(boolean paramBoolean)
    {
      this.Y = true;
      this.Z = paramBoolean;
      return this;
    }

    public k.d a()
    {
      return this.b;
    }

    public b b(k.d paramd)
    {
      if (paramd == null)
        throw new NullPointerException();
      this.c = true;
      this.d = paramd;
      return this;
    }

    public b b(String paramString)
    {
      this.M = true;
      this.N = paramString;
      return this;
    }

    public b b(boolean paramBoolean)
    {
      this.ac = true;
      this.ad = paramBoolean;
      return this;
    }

    public k.d b()
    {
      return this.d;
    }

    public b c(k.d paramd)
    {
      if (paramd == null)
        throw new NullPointerException();
      this.e = true;
      this.f = paramd;
      return this;
    }

    public b c(String paramString)
    {
      this.O = true;
      this.P = paramString;
      return this;
    }

    public b c(boolean paramBoolean)
    {
      this.ag = true;
      this.ah = paramBoolean;
      return this;
    }

    public k.d c()
    {
      return this.f;
    }

    public b d(k.d paramd)
    {
      if (paramd == null)
        throw new NullPointerException();
      this.g = true;
      this.h = paramd;
      return this;
    }

    public b d(String paramString)
    {
      this.Q = true;
      this.R = paramString;
      return this;
    }

    public b d(boolean paramBoolean)
    {
      this.ai = true;
      this.aj = paramBoolean;
      return this;
    }

    public k.d d()
    {
      return this.h;
    }

    public b e(k.d paramd)
    {
      if (paramd == null)
        throw new NullPointerException();
      this.i = true;
      this.j = paramd;
      return this;
    }

    public b e(String paramString)
    {
      this.S = true;
      this.T = paramString;
      return this;
    }

    public k.d e()
    {
      return this.j;
    }

    public b f(k.d paramd)
    {
      if (paramd == null)
        throw new NullPointerException();
      this.k = true;
      this.l = paramd;
      return this;
    }

    public b f(String paramString)
    {
      this.U = true;
      this.V = paramString;
      return this;
    }

    public k.d f()
    {
      return this.l;
    }

    public b g(k.d paramd)
    {
      if (paramd == null)
        throw new NullPointerException();
      this.m = true;
      this.n = paramd;
      return this;
    }

    public b g(String paramString)
    {
      this.W = true;
      this.X = paramString;
      return this;
    }

    public k.d g()
    {
      return this.n;
    }

    public b h(k.d paramd)
    {
      if (paramd == null)
        throw new NullPointerException();
      this.o = true;
      this.p = paramd;
      return this;
    }

    public b h(String paramString)
    {
      this.ae = true;
      this.af = paramString;
      return this;
    }

    public k.d h()
    {
      return this.p;
    }

    public b i(k.d paramd)
    {
      if (paramd == null)
        throw new NullPointerException();
      this.q = true;
      this.r = paramd;
      return this;
    }

    public k.d i()
    {
      return this.r;
    }

    public b j(k.d paramd)
    {
      if (paramd == null)
        throw new NullPointerException();
      this.s = true;
      this.t = paramd;
      return this;
    }

    public k.d j()
    {
      return this.t;
    }

    public b k(k.d paramd)
    {
      if (paramd == null)
        throw new NullPointerException();
      this.u = true;
      this.v = paramd;
      return this;
    }

    public k.d k()
    {
      return this.x;
    }

    public int l()
    {
      return this.L;
    }

    public b l(k.d paramd)
    {
      if (paramd == null)
        throw new NullPointerException();
      this.w = true;
      this.x = paramd;
      return this;
    }

    public b m(k.d paramd)
    {
      if (paramd == null)
        throw new NullPointerException();
      this.y = true;
      this.z = paramd;
      return this;
    }

    public String m()
    {
      return this.N;
    }

    public b n(k.d paramd)
    {
      if (paramd == null)
        throw new NullPointerException();
      this.A = true;
      this.B = paramd;
      return this;
    }

    public boolean n()
    {
      return this.S;
    }

    public b o(k.d paramd)
    {
      if (paramd == null)
        throw new NullPointerException();
      this.C = true;
      this.D = paramd;
      return this;
    }

    public String o()
    {
      return this.T;
    }

    public b p(k.d paramd)
    {
      if (paramd == null)
        throw new NullPointerException();
      this.E = true;
      this.F = paramd;
      return this;
    }

    public boolean p()
    {
      return this.U;
    }

    public b q(k.d paramd)
    {
      if (paramd == null)
        throw new NullPointerException();
      this.G = true;
      this.H = paramd;
      return this;
    }

    public String q()
    {
      return this.V;
    }

    public String r()
    {
      return this.X;
    }

    public void readExternal(ObjectInput paramObjectInput)
      throws IOException
    {
      int i1 = 0;
      if (paramObjectInput.readBoolean())
      {
        k.d locald1 = new k.d();
        locald1.readExternal(paramObjectInput);
        a(locald1);
      }
      if (paramObjectInput.readBoolean())
      {
        k.d locald2 = new k.d();
        locald2.readExternal(paramObjectInput);
        b(locald2);
      }
      if (paramObjectInput.readBoolean())
      {
        k.d locald3 = new k.d();
        locald3.readExternal(paramObjectInput);
        c(locald3);
      }
      if (paramObjectInput.readBoolean())
      {
        k.d locald4 = new k.d();
        locald4.readExternal(paramObjectInput);
        d(locald4);
      }
      if (paramObjectInput.readBoolean())
      {
        k.d locald5 = new k.d();
        locald5.readExternal(paramObjectInput);
        e(locald5);
      }
      if (paramObjectInput.readBoolean())
      {
        k.d locald6 = new k.d();
        locald6.readExternal(paramObjectInput);
        f(locald6);
      }
      if (paramObjectInput.readBoolean())
      {
        k.d locald7 = new k.d();
        locald7.readExternal(paramObjectInput);
        g(locald7);
      }
      if (paramObjectInput.readBoolean())
      {
        k.d locald8 = new k.d();
        locald8.readExternal(paramObjectInput);
        h(locald8);
      }
      if (paramObjectInput.readBoolean())
      {
        k.d locald9 = new k.d();
        locald9.readExternal(paramObjectInput);
        i(locald9);
      }
      if (paramObjectInput.readBoolean())
      {
        k.d locald10 = new k.d();
        locald10.readExternal(paramObjectInput);
        j(locald10);
      }
      if (paramObjectInput.readBoolean())
      {
        k.d locald11 = new k.d();
        locald11.readExternal(paramObjectInput);
        k(locald11);
      }
      if (paramObjectInput.readBoolean())
      {
        k.d locald12 = new k.d();
        locald12.readExternal(paramObjectInput);
        l(locald12);
      }
      if (paramObjectInput.readBoolean())
      {
        k.d locald13 = new k.d();
        locald13.readExternal(paramObjectInput);
        m(locald13);
      }
      if (paramObjectInput.readBoolean())
      {
        k.d locald14 = new k.d();
        locald14.readExternal(paramObjectInput);
        n(locald14);
      }
      if (paramObjectInput.readBoolean())
      {
        k.d locald15 = new k.d();
        locald15.readExternal(paramObjectInput);
        o(locald15);
      }
      if (paramObjectInput.readBoolean())
      {
        k.d locald16 = new k.d();
        locald16.readExternal(paramObjectInput);
        p(locald16);
      }
      if (paramObjectInput.readBoolean())
      {
        k.d locald17 = new k.d();
        locald17.readExternal(paramObjectInput);
        q(locald17);
      }
      a(paramObjectInput.readUTF());
      a(paramObjectInput.readInt());
      b(paramObjectInput.readUTF());
      if (paramObjectInput.readBoolean())
        c(paramObjectInput.readUTF());
      if (paramObjectInput.readBoolean())
        d(paramObjectInput.readUTF());
      if (paramObjectInput.readBoolean())
        e(paramObjectInput.readUTF());
      if (paramObjectInput.readBoolean())
        f(paramObjectInput.readUTF());
      if (paramObjectInput.readBoolean())
        g(paramObjectInput.readUTF());
      a(paramObjectInput.readBoolean());
      int i2 = paramObjectInput.readInt();
      for (int i3 = 0; i3 < i2; i3++)
      {
        k.a locala1 = new k.a();
        locala1.readExternal(paramObjectInput);
        this.aa.add(locala1);
      }
      int i4 = paramObjectInput.readInt();
      while (i1 < i4)
      {
        k.a locala2 = new k.a();
        locala2.readExternal(paramObjectInput);
        this.ab.add(locala2);
        i1++;
      }
      b(paramObjectInput.readBoolean());
      if (paramObjectInput.readBoolean())
        h(paramObjectInput.readUTF());
      c(paramObjectInput.readBoolean());
      d(paramObjectInput.readBoolean());
    }

    public List<k.a> s()
    {
      return this.aa;
    }

    public int t()
    {
      return this.aa.size();
    }

    public List<k.a> u()
    {
      return this.ab;
    }

    public int v()
    {
      return this.ab.size();
    }

    public void writeExternal(ObjectOutput paramObjectOutput)
      throws IOException
    {
      int i1 = 0;
      paramObjectOutput.writeBoolean(this.a);
      if (this.a)
        this.b.writeExternal(paramObjectOutput);
      paramObjectOutput.writeBoolean(this.c);
      if (this.c)
        this.d.writeExternal(paramObjectOutput);
      paramObjectOutput.writeBoolean(this.e);
      if (this.e)
        this.f.writeExternal(paramObjectOutput);
      paramObjectOutput.writeBoolean(this.g);
      if (this.g)
        this.h.writeExternal(paramObjectOutput);
      paramObjectOutput.writeBoolean(this.i);
      if (this.i)
        this.j.writeExternal(paramObjectOutput);
      paramObjectOutput.writeBoolean(this.k);
      if (this.k)
        this.l.writeExternal(paramObjectOutput);
      paramObjectOutput.writeBoolean(this.m);
      if (this.m)
        this.n.writeExternal(paramObjectOutput);
      paramObjectOutput.writeBoolean(this.o);
      if (this.o)
        this.p.writeExternal(paramObjectOutput);
      paramObjectOutput.writeBoolean(this.q);
      if (this.q)
        this.r.writeExternal(paramObjectOutput);
      paramObjectOutput.writeBoolean(this.s);
      if (this.s)
        this.t.writeExternal(paramObjectOutput);
      paramObjectOutput.writeBoolean(this.u);
      if (this.u)
        this.v.writeExternal(paramObjectOutput);
      paramObjectOutput.writeBoolean(this.w);
      if (this.w)
        this.x.writeExternal(paramObjectOutput);
      paramObjectOutput.writeBoolean(this.y);
      if (this.y)
        this.z.writeExternal(paramObjectOutput);
      paramObjectOutput.writeBoolean(this.A);
      if (this.A)
        this.B.writeExternal(paramObjectOutput);
      paramObjectOutput.writeBoolean(this.C);
      if (this.C)
        this.D.writeExternal(paramObjectOutput);
      paramObjectOutput.writeBoolean(this.E);
      if (this.E)
        this.F.writeExternal(paramObjectOutput);
      paramObjectOutput.writeBoolean(this.G);
      if (this.G)
        this.H.writeExternal(paramObjectOutput);
      paramObjectOutput.writeUTF(this.J);
      paramObjectOutput.writeInt(this.L);
      paramObjectOutput.writeUTF(this.N);
      paramObjectOutput.writeBoolean(this.O);
      if (this.O)
        paramObjectOutput.writeUTF(this.P);
      paramObjectOutput.writeBoolean(this.Q);
      if (this.Q)
        paramObjectOutput.writeUTF(this.R);
      paramObjectOutput.writeBoolean(this.S);
      if (this.S)
        paramObjectOutput.writeUTF(this.T);
      paramObjectOutput.writeBoolean(this.U);
      if (this.U)
        paramObjectOutput.writeUTF(this.V);
      paramObjectOutput.writeBoolean(this.W);
      if (this.W)
        paramObjectOutput.writeUTF(this.X);
      paramObjectOutput.writeBoolean(this.Z);
      int i2 = t();
      paramObjectOutput.writeInt(i2);
      for (int i3 = 0; i3 < i2; i3++)
        ((k.a)this.aa.get(i3)).writeExternal(paramObjectOutput);
      int i4 = v();
      paramObjectOutput.writeInt(i4);
      while (i1 < i4)
      {
        ((k.a)this.ab.get(i1)).writeExternal(paramObjectOutput);
        i1++;
      }
      paramObjectOutput.writeBoolean(this.ad);
      paramObjectOutput.writeBoolean(this.ae);
      if (this.ae)
        paramObjectOutput.writeUTF(this.af);
      paramObjectOutput.writeBoolean(this.ah);
      paramObjectOutput.writeBoolean(this.aj);
    }
  }

  public static class c
    implements Externalizable
  {
    private List<k.b> a = new ArrayList();

    public List<k.b> a()
    {
      return this.a;
    }

    public int b()
    {
      return this.a.size();
    }

    public void readExternal(ObjectInput paramObjectInput)
      throws IOException
    {
      int i = paramObjectInput.readInt();
      for (int j = 0; j < i; j++)
      {
        k.b localb = new k.b();
        localb.readExternal(paramObjectInput);
        this.a.add(localb);
      }
    }

    public void writeExternal(ObjectOutput paramObjectOutput)
      throws IOException
    {
      int i = b();
      paramObjectOutput.writeInt(i);
      for (int j = 0; j < i; j++)
        ((k.b)this.a.get(j)).writeExternal(paramObjectOutput);
    }
  }

  public static class d
    implements Externalizable
  {
    private boolean a;
    private String b = "";
    private List<Integer> c = new ArrayList();
    private List<Integer> d = new ArrayList();
    private boolean e;
    private String f = "";

    public int a(int paramInt)
    {
      return ((Integer)this.c.get(paramInt)).intValue();
    }

    public d a(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }

    public String a()
    {
      return this.b;
    }

    public d b(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }

    public List<Integer> b()
    {
      return this.c;
    }

    public int c()
    {
      return this.c.size();
    }

    public List<Integer> d()
    {
      return this.d;
    }

    public int e()
    {
      return this.d.size();
    }

    public void readExternal(ObjectInput paramObjectInput)
      throws IOException
    {
      int i = 0;
      if (paramObjectInput.readBoolean())
        a(paramObjectInput.readUTF());
      int j = paramObjectInput.readInt();
      for (int k = 0; k < j; k++)
        this.c.add(Integer.valueOf(paramObjectInput.readInt()));
      int m = paramObjectInput.readInt();
      while (i < m)
      {
        this.d.add(Integer.valueOf(paramObjectInput.readInt()));
        i++;
      }
      if (paramObjectInput.readBoolean())
        b(paramObjectInput.readUTF());
    }

    public void writeExternal(ObjectOutput paramObjectOutput)
      throws IOException
    {
      int i = 0;
      paramObjectOutput.writeBoolean(this.a);
      if (this.a)
        paramObjectOutput.writeUTF(this.b);
      int j = c();
      paramObjectOutput.writeInt(j);
      for (int k = 0; k < j; k++)
        paramObjectOutput.writeInt(((Integer)this.c.get(k)).intValue());
      int m = e();
      paramObjectOutput.writeInt(m);
      while (i < m)
      {
        paramObjectOutput.writeInt(((Integer)this.d.get(i)).intValue());
        i++;
      }
      paramObjectOutput.writeBoolean(this.e);
      if (this.e)
        paramObjectOutput.writeUTF(this.f);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.b.a.a.k
 * JD-Core Version:    0.6.2
 */