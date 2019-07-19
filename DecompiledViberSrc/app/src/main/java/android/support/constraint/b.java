package android.support.constraint;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class b
{
  private static final int[] a = { 0, 4, 8 };
  private static SparseIntArray c = new SparseIntArray();
  private HashMap<Integer, a> b = new HashMap();

  static
  {
    c.append(R.styleable.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
    c.append(R.styleable.ConstraintSet_layout_constraintLeft_toRightOf, 26);
    c.append(R.styleable.ConstraintSet_layout_constraintRight_toLeftOf, 29);
    c.append(R.styleable.ConstraintSet_layout_constraintRight_toRightOf, 30);
    c.append(R.styleable.ConstraintSet_layout_constraintTop_toTopOf, 36);
    c.append(R.styleable.ConstraintSet_layout_constraintTop_toBottomOf, 35);
    c.append(R.styleable.ConstraintSet_layout_constraintBottom_toTopOf, 4);
    c.append(R.styleable.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
    c.append(R.styleable.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
    c.append(R.styleable.ConstraintSet_layout_editor_absoluteX, 6);
    c.append(R.styleable.ConstraintSet_layout_editor_absoluteY, 7);
    c.append(R.styleable.ConstraintSet_layout_constraintGuide_begin, 17);
    c.append(R.styleable.ConstraintSet_layout_constraintGuide_end, 18);
    c.append(R.styleable.ConstraintSet_layout_constraintGuide_percent, 19);
    c.append(R.styleable.ConstraintSet_android_orientation, 27);
    c.append(R.styleable.ConstraintSet_layout_constraintStart_toEndOf, 32);
    c.append(R.styleable.ConstraintSet_layout_constraintStart_toStartOf, 33);
    c.append(R.styleable.ConstraintSet_layout_constraintEnd_toStartOf, 10);
    c.append(R.styleable.ConstraintSet_layout_constraintEnd_toEndOf, 9);
    c.append(R.styleable.ConstraintSet_layout_goneMarginLeft, 13);
    c.append(R.styleable.ConstraintSet_layout_goneMarginTop, 16);
    c.append(R.styleable.ConstraintSet_layout_goneMarginRight, 14);
    c.append(R.styleable.ConstraintSet_layout_goneMarginBottom, 11);
    c.append(R.styleable.ConstraintSet_layout_goneMarginStart, 15);
    c.append(R.styleable.ConstraintSet_layout_goneMarginEnd, 12);
    c.append(R.styleable.ConstraintSet_layout_constraintVertical_weight, 40);
    c.append(R.styleable.ConstraintSet_layout_constraintHorizontal_weight, 39);
    c.append(R.styleable.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
    c.append(R.styleable.ConstraintSet_layout_constraintVertical_chainStyle, 42);
    c.append(R.styleable.ConstraintSet_layout_constraintHorizontal_bias, 20);
    c.append(R.styleable.ConstraintSet_layout_constraintVertical_bias, 37);
    c.append(R.styleable.ConstraintSet_layout_constraintDimensionRatio, 5);
    c.append(R.styleable.ConstraintSet_layout_constraintLeft_creator, 64);
    c.append(R.styleable.ConstraintSet_layout_constraintTop_creator, 64);
    c.append(R.styleable.ConstraintSet_layout_constraintRight_creator, 64);
    c.append(R.styleable.ConstraintSet_layout_constraintBottom_creator, 64);
    c.append(R.styleable.ConstraintSet_layout_constraintBaseline_creator, 64);
    c.append(R.styleable.ConstraintSet_android_layout_marginLeft, 24);
    c.append(R.styleable.ConstraintSet_android_layout_marginRight, 28);
    c.append(R.styleable.ConstraintSet_android_layout_marginStart, 31);
    c.append(R.styleable.ConstraintSet_android_layout_marginEnd, 8);
    c.append(R.styleable.ConstraintSet_android_layout_marginTop, 34);
    c.append(R.styleable.ConstraintSet_android_layout_marginBottom, 2);
    c.append(R.styleable.ConstraintSet_android_layout_width, 23);
    c.append(R.styleable.ConstraintSet_android_layout_height, 21);
    c.append(R.styleable.ConstraintSet_android_visibility, 22);
    c.append(R.styleable.ConstraintSet_android_alpha, 43);
    c.append(R.styleable.ConstraintSet_android_elevation, 44);
    c.append(R.styleable.ConstraintSet_android_rotationX, 45);
    c.append(R.styleable.ConstraintSet_android_rotationY, 46);
    c.append(R.styleable.ConstraintSet_android_rotation, 60);
    c.append(R.styleable.ConstraintSet_android_scaleX, 47);
    c.append(R.styleable.ConstraintSet_android_scaleY, 48);
    c.append(R.styleable.ConstraintSet_android_transformPivotX, 49);
    c.append(R.styleable.ConstraintSet_android_transformPivotY, 50);
    c.append(R.styleable.ConstraintSet_android_translationX, 51);
    c.append(R.styleable.ConstraintSet_android_translationY, 52);
    c.append(R.styleable.ConstraintSet_android_translationZ, 53);
    c.append(R.styleable.ConstraintSet_layout_constraintWidth_default, 54);
    c.append(R.styleable.ConstraintSet_layout_constraintHeight_default, 55);
    c.append(R.styleable.ConstraintSet_layout_constraintWidth_max, 56);
    c.append(R.styleable.ConstraintSet_layout_constraintHeight_max, 57);
    c.append(R.styleable.ConstraintSet_layout_constraintWidth_min, 58);
    c.append(R.styleable.ConstraintSet_layout_constraintHeight_min, 59);
    c.append(R.styleable.ConstraintSet_layout_constraintCircle, 61);
    c.append(R.styleable.ConstraintSet_layout_constraintCircleRadius, 62);
    c.append(R.styleable.ConstraintSet_layout_constraintCircleAngle, 63);
    c.append(R.styleable.ConstraintSet_android_id, 38);
  }

  private static int a(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    int i = paramTypedArray.getResourceId(paramInt1, paramInt2);
    if (i == -1)
      i = paramTypedArray.getInt(paramInt1, -1);
    return i;
  }

  private a a(Context paramContext, AttributeSet paramAttributeSet)
  {
    a locala = new a(null);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintSet);
    a(locala, localTypedArray);
    localTypedArray.recycle();
    return locala;
  }

  private void a(a parama, TypedArray paramTypedArray)
  {
    int i = paramTypedArray.getIndexCount();
    int j = 0;
    if (j < i)
    {
      int k = paramTypedArray.getIndex(j);
      switch (c.get(k))
      {
      case 54:
      case 55:
      case 56:
      case 57:
      case 58:
      case 59:
      default:
        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(k) + "   " + c.get(k));
      case 25:
      case 26:
      case 29:
      case 30:
      case 36:
      case 35:
      case 4:
      case 3:
      case 1:
      case 6:
      case 7:
      case 17:
      case 18:
      case 19:
      case 27:
      case 32:
      case 33:
      case 10:
      case 9:
      case 61:
      case 62:
      case 63:
      case 13:
      case 16:
      case 14:
      case 11:
      case 15:
      case 12:
      case 20:
      case 37:
      case 24:
      case 28:
      case 31:
      case 8:
      case 34:
      case 2:
      case 23:
      case 21:
      case 22:
      case 43:
      case 44:
      case 60:
      case 45:
      case 46:
      case 47:
      case 48:
      case 49:
      case 50:
      case 51:
      case 52:
      case 53:
      case 40:
      case 39:
      case 42:
      case 41:
      case 38:
      case 5:
      case 64:
      }
      while (true)
      {
        j++;
        break;
        parama.h = a(paramTypedArray, k, parama.h);
        continue;
        parama.i = a(paramTypedArray, k, parama.i);
        continue;
        parama.j = a(paramTypedArray, k, parama.j);
        continue;
        parama.k = a(paramTypedArray, k, parama.k);
        continue;
        parama.l = a(paramTypedArray, k, parama.l);
        continue;
        parama.m = a(paramTypedArray, k, parama.m);
        continue;
        parama.n = a(paramTypedArray, k, parama.n);
        continue;
        parama.o = a(paramTypedArray, k, parama.o);
        continue;
        parama.p = a(paramTypedArray, k, parama.p);
        continue;
        parama.A = paramTypedArray.getDimensionPixelOffset(k, parama.A);
        continue;
        parama.B = paramTypedArray.getDimensionPixelOffset(k, parama.B);
        continue;
        parama.e = paramTypedArray.getDimensionPixelOffset(k, parama.e);
        continue;
        parama.f = paramTypedArray.getDimensionPixelOffset(k, parama.f);
        continue;
        parama.g = paramTypedArray.getFloat(k, parama.g);
        continue;
        parama.C = paramTypedArray.getInt(k, parama.C);
        continue;
        parama.q = a(paramTypedArray, k, parama.q);
        continue;
        parama.r = a(paramTypedArray, k, parama.r);
        continue;
        parama.s = a(paramTypedArray, k, parama.s);
        continue;
        parama.t = a(paramTypedArray, k, parama.t);
        continue;
        parama.x = a(paramTypedArray, k, parama.x);
        continue;
        parama.y = paramTypedArray.getDimensionPixelSize(k, parama.y);
        continue;
        parama.z = paramTypedArray.getFloat(k, parama.z);
        continue;
        parama.K = paramTypedArray.getDimensionPixelSize(k, parama.K);
        continue;
        parama.L = paramTypedArray.getDimensionPixelSize(k, parama.L);
        continue;
        parama.M = paramTypedArray.getDimensionPixelSize(k, parama.M);
        continue;
        parama.N = paramTypedArray.getDimensionPixelSize(k, parama.N);
        continue;
        parama.P = paramTypedArray.getDimensionPixelSize(k, parama.P);
        continue;
        parama.O = paramTypedArray.getDimensionPixelSize(k, parama.O);
        continue;
        parama.u = paramTypedArray.getFloat(k, parama.u);
        continue;
        parama.v = paramTypedArray.getFloat(k, parama.v);
        continue;
        parama.D = paramTypedArray.getDimensionPixelSize(k, parama.D);
        continue;
        parama.E = paramTypedArray.getDimensionPixelSize(k, parama.E);
        continue;
        parama.I = paramTypedArray.getDimensionPixelSize(k, parama.I);
        continue;
        parama.H = paramTypedArray.getDimensionPixelSize(k, parama.H);
        continue;
        parama.F = paramTypedArray.getDimensionPixelSize(k, parama.F);
        continue;
        parama.G = paramTypedArray.getDimensionPixelSize(k, parama.G);
        continue;
        parama.b = paramTypedArray.getLayoutDimension(k, parama.b);
        continue;
        parama.c = paramTypedArray.getLayoutDimension(k, parama.c);
        continue;
        parama.J = paramTypedArray.getInt(k, parama.J);
        parama.J = a[parama.J];
        continue;
        parama.U = paramTypedArray.getFloat(k, parama.U);
        continue;
        parama.V = true;
        parama.W = paramTypedArray.getDimension(k, parama.W);
        continue;
        parama.X = paramTypedArray.getFloat(k, parama.X);
        continue;
        parama.Y = paramTypedArray.getFloat(k, parama.Y);
        continue;
        parama.Z = paramTypedArray.getFloat(k, parama.Z);
        continue;
        parama.aa = paramTypedArray.getFloat(k, parama.aa);
        continue;
        parama.ab = paramTypedArray.getFloat(k, parama.ab);
        continue;
        parama.ac = paramTypedArray.getFloat(k, parama.ac);
        continue;
        parama.ad = paramTypedArray.getFloat(k, parama.ad);
        continue;
        parama.ae = paramTypedArray.getDimension(k, parama.ae);
        continue;
        parama.af = paramTypedArray.getDimension(k, parama.af);
        continue;
        parama.ag = paramTypedArray.getDimension(k, parama.ag);
        continue;
        parama.Q = paramTypedArray.getFloat(k, parama.Q);
        continue;
        parama.R = paramTypedArray.getFloat(k, parama.R);
        continue;
        parama.T = paramTypedArray.getInt(k, parama.T);
        continue;
        parama.S = paramTypedArray.getInt(k, parama.S);
        continue;
        parama.d = paramTypedArray.getResourceId(k, parama.d);
        continue;
        parama.w = paramTypedArray.getString(k);
        continue;
        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(k) + "   " + c.get(k));
      }
    }
  }

  public void a(Context paramContext, int paramInt)
  {
    XmlResourceParser localXmlResourceParser = paramContext.getResources().getXml(paramInt);
    int i;
    do
      try
      {
        i = localXmlResourceParser.getEventType();
        continue;
        while (true)
        {
          i = localXmlResourceParser.next();
          break;
          localXmlResourceParser.getName();
        }
      }
      catch (XmlPullParserException localXmlPullParserException)
      {
        while (true)
        {
          localXmlPullParserException.printStackTrace();
          return;
          String str = localXmlResourceParser.getName();
          a locala = a(paramContext, Xml.asAttributeSet(localXmlResourceParser));
          if (str.equalsIgnoreCase("Guideline"))
            locala.a = true;
          this.b.put(Integer.valueOf(locala.d), locala);
        }
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        return;
      }
    while (i == 1);
    switch (i)
    {
    case 1:
    case 3:
    default:
    case 0:
    case 2:
    }
  }

  void a(ConstraintLayout paramConstraintLayout)
  {
    int i = paramConstraintLayout.getChildCount();
    HashSet localHashSet = new HashSet(this.b.keySet());
    int j = 0;
    if (j < i)
    {
      View localView = paramConstraintLayout.getChildAt(j);
      int k = localView.getId();
      if (k == -1)
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
      a locala4;
      if (this.b.containsKey(Integer.valueOf(k)))
      {
        localHashSet.remove(Integer.valueOf(k));
        locala4 = (a)this.b.get(Integer.valueOf(k));
        if (locala4.as != -1)
          switch (locala4.as)
          {
          default:
          case 1:
          }
      }
      while (true)
      {
        ConstraintLayout.a locala5 = (ConstraintLayout.a)localView.getLayoutParams();
        locala4.a(locala5);
        localView.setLayoutParams(locala5);
        localView.setVisibility(locala4.J);
        if (Build.VERSION.SDK_INT >= 17)
        {
          localView.setAlpha(locala4.U);
          localView.setRotation(locala4.X);
          localView.setRotationX(locala4.Y);
          localView.setRotationY(locala4.Z);
          localView.setScaleX(locala4.aa);
          localView.setScaleY(locala4.ab);
          if (!Float.isNaN(locala4.ac))
            localView.setPivotX(locala4.ac);
          if (!Float.isNaN(locala4.ad))
            localView.setPivotY(locala4.ad);
          localView.setTranslationX(locala4.ae);
          localView.setTranslationY(locala4.af);
          if (Build.VERSION.SDK_INT >= 21)
          {
            localView.setTranslationZ(locala4.ag);
            if (locala4.V)
              localView.setElevation(locala4.W);
          }
        }
        j++;
        break;
        Barrier localBarrier2 = (Barrier)localView;
        localBarrier2.setId(k);
        localBarrier2.setReferencedIds(locala4.at);
        localBarrier2.setType(locala4.ar);
        locala4.a(paramConstraintLayout.ag_());
      }
    }
    Iterator localIterator = localHashSet.iterator();
    label584: 
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      a locala1 = (a)this.b.get(localInteger);
      if (locala1.as != -1)
        switch (locala1.as)
        {
        default:
        case 1:
        }
      while (true)
      {
        if (!locala1.a)
          break label584;
        Guideline localGuideline = new Guideline(paramConstraintLayout.getContext());
        localGuideline.setId(localInteger.intValue());
        ConstraintLayout.a locala2 = paramConstraintLayout.ag_();
        locala1.a(locala2);
        paramConstraintLayout.addView(localGuideline, locala2);
        break;
        Barrier localBarrier1 = new Barrier(paramConstraintLayout.getContext());
        localBarrier1.setId(localInteger.intValue());
        localBarrier1.setReferencedIds(locala1.at);
        localBarrier1.setType(locala1.ar);
        ConstraintLayout.a locala3 = paramConstraintLayout.ag_();
        locala1.a(locala3);
        paramConstraintLayout.addView(localBarrier1, locala3);
      }
    }
  }

  public void a(c paramc)
  {
    int i = paramc.getChildCount();
    this.b.clear();
    for (int j = 0; j < i; j++)
    {
      View localView = paramc.getChildAt(j);
      c.a locala = (c.a)localView.getLayoutParams();
      int k = localView.getId();
      if (k == -1)
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
      if (!this.b.containsKey(Integer.valueOf(k)))
        this.b.put(Integer.valueOf(k), new a(null));
      a locala1 = (a)this.b.get(Integer.valueOf(k));
      if ((localView instanceof a))
        a.a(locala1, (a)localView, k, locala);
      a.a(locala1, k, locala);
    }
  }

  private static class a
  {
    public int A = -1;
    public int B = -1;
    public int C = -1;
    public int D = -1;
    public int E = -1;
    public int F = -1;
    public int G = -1;
    public int H = -1;
    public int I = -1;
    public int J = 0;
    public int K = -1;
    public int L = -1;
    public int M = -1;
    public int N = -1;
    public int O = -1;
    public int P = -1;
    public float Q = 0.0F;
    public float R = 0.0F;
    public int S = 0;
    public int T = 0;
    public float U = 1.0F;
    public boolean V = false;
    public float W = 0.0F;
    public float X = 0.0F;
    public float Y = 0.0F;
    public float Z = 0.0F;
    boolean a = false;
    public float aa = 1.0F;
    public float ab = 1.0F;
    public float ac = (0.0F / 0.0F);
    public float ad = (0.0F / 0.0F);
    public float ae = 0.0F;
    public float af = 0.0F;
    public float ag = 0.0F;
    public boolean ah = false;
    public boolean ai = false;
    public int aj = -1;
    public int ak = -1;
    public int al = -1;
    public int am = -1;
    public int an = -1;
    public int ao = -1;
    public float ap = 1.0F;
    public float aq = 1.0F;
    public int ar = -1;
    public int as = -1;
    public int[] at;
    public int b;
    public int c;
    int d;
    public int e = -1;
    public int f = -1;
    public float g = -1.0F;
    public int h = -1;
    public int i = -1;
    public int j = -1;
    public int k = -1;
    public int l = -1;
    public int m = -1;
    public int n = -1;
    public int o = -1;
    public int p = -1;
    public int q = -1;
    public int r = -1;
    public int s = -1;
    public int t = -1;
    public float u = 0.5F;
    public float v = 0.5F;
    public String w = null;
    public int x = -1;
    public int y = 0;
    public float z = 0.0F;

    private void a(int paramInt, ConstraintLayout.a parama)
    {
      this.d = paramInt;
      this.h = parama.d;
      this.i = parama.e;
      this.j = parama.f;
      this.k = parama.g;
      this.l = parama.h;
      this.m = parama.i;
      this.n = parama.j;
      this.o = parama.k;
      this.p = parama.l;
      this.q = parama.p;
      this.r = parama.q;
      this.s = parama.r;
      this.t = parama.s;
      this.u = parama.z;
      this.v = parama.A;
      this.w = parama.B;
      this.x = parama.m;
      this.y = parama.n;
      this.z = parama.o;
      this.A = parama.Q;
      this.B = parama.R;
      this.C = parama.S;
      this.g = parama.c;
      this.e = parama.a;
      this.f = parama.b;
      this.b = parama.width;
      this.c = parama.height;
      this.D = parama.leftMargin;
      this.E = parama.rightMargin;
      this.F = parama.topMargin;
      this.G = parama.bottomMargin;
      this.Q = parama.F;
      this.R = parama.E;
      this.T = parama.H;
      this.S = parama.G;
      this.ah = parama.T;
      this.ai = parama.U;
      this.aj = parama.I;
      this.ak = parama.J;
      this.ah = parama.T;
      this.al = parama.M;
      this.am = parama.N;
      this.an = parama.K;
      this.ao = parama.L;
      this.ap = parama.O;
      this.aq = parama.P;
      if (Build.VERSION.SDK_INT >= 17)
      {
        this.H = parama.getMarginEnd();
        this.I = parama.getMarginStart();
      }
    }

    private void a(int paramInt, c.a parama)
    {
      a(paramInt, parama);
      this.U = parama.an;
      this.X = parama.aq;
      this.Y = parama.ar;
      this.Z = parama.as;
      this.aa = parama.at;
      this.ab = parama.au;
      this.ac = parama.av;
      this.ad = parama.aw;
      this.ae = parama.ax;
      this.af = parama.ay;
      this.ag = parama.az;
      this.W = parama.ap;
      this.V = parama.ao;
    }

    private void a(a parama, int paramInt, c.a parama1)
    {
      a(paramInt, parama1);
      if ((parama instanceof Barrier))
      {
        this.as = 1;
        Barrier localBarrier = (Barrier)parama;
        this.ar = localBarrier.getType();
        this.at = localBarrier.getReferencedIds();
      }
    }

    public a a()
    {
      a locala = new a();
      locala.a = this.a;
      locala.b = this.b;
      locala.c = this.c;
      locala.e = this.e;
      locala.f = this.f;
      locala.g = this.g;
      locala.h = this.h;
      locala.i = this.i;
      locala.j = this.j;
      locala.k = this.k;
      locala.l = this.l;
      locala.m = this.m;
      locala.n = this.n;
      locala.o = this.o;
      locala.p = this.p;
      locala.q = this.q;
      locala.r = this.r;
      locala.s = this.s;
      locala.t = this.t;
      locala.u = this.u;
      locala.v = this.v;
      locala.w = this.w;
      locala.A = this.A;
      locala.B = this.B;
      locala.u = this.u;
      locala.u = this.u;
      locala.u = this.u;
      locala.u = this.u;
      locala.u = this.u;
      locala.C = this.C;
      locala.D = this.D;
      locala.E = this.E;
      locala.F = this.F;
      locala.G = this.G;
      locala.H = this.H;
      locala.I = this.I;
      locala.J = this.J;
      locala.K = this.K;
      locala.L = this.L;
      locala.M = this.M;
      locala.N = this.N;
      locala.O = this.O;
      locala.P = this.P;
      locala.Q = this.Q;
      locala.R = this.R;
      locala.S = this.S;
      locala.T = this.T;
      locala.U = this.U;
      locala.V = this.V;
      locala.W = this.W;
      locala.X = this.X;
      locala.Y = this.Y;
      locala.Z = this.Z;
      locala.aa = this.aa;
      locala.ab = this.ab;
      locala.ac = this.ac;
      locala.ad = this.ad;
      locala.ae = this.ae;
      locala.af = this.af;
      locala.ag = this.ag;
      locala.ah = this.ah;
      locala.ai = this.ai;
      locala.aj = this.aj;
      locala.ak = this.ak;
      locala.al = this.al;
      locala.am = this.am;
      locala.an = this.an;
      locala.ao = this.ao;
      locala.ap = this.ap;
      locala.aq = this.aq;
      locala.ar = this.ar;
      locala.as = this.as;
      if (this.at != null)
        locala.at = Arrays.copyOf(this.at, this.at.length);
      locala.x = this.x;
      locala.y = this.y;
      locala.z = this.z;
      return locala;
    }

    public void a(ConstraintLayout.a parama)
    {
      parama.d = this.h;
      parama.e = this.i;
      parama.f = this.j;
      parama.g = this.k;
      parama.h = this.l;
      parama.i = this.m;
      parama.j = this.n;
      parama.k = this.o;
      parama.l = this.p;
      parama.p = this.q;
      parama.q = this.r;
      parama.r = this.s;
      parama.s = this.t;
      parama.leftMargin = this.D;
      parama.rightMargin = this.E;
      parama.topMargin = this.F;
      parama.bottomMargin = this.G;
      parama.x = this.P;
      parama.y = this.O;
      parama.z = this.u;
      parama.A = this.v;
      parama.m = this.x;
      parama.n = this.y;
      parama.o = this.z;
      parama.B = this.w;
      parama.Q = this.A;
      parama.R = this.B;
      parama.F = this.Q;
      parama.E = this.R;
      parama.H = this.T;
      parama.G = this.S;
      parama.T = this.ah;
      parama.U = this.ai;
      parama.I = this.aj;
      parama.J = this.ak;
      parama.M = this.al;
      parama.N = this.am;
      parama.K = this.an;
      parama.L = this.ao;
      parama.O = this.ap;
      parama.P = this.aq;
      parama.S = this.C;
      parama.c = this.g;
      parama.a = this.e;
      parama.b = this.f;
      parama.width = this.b;
      parama.height = this.c;
      if (Build.VERSION.SDK_INT >= 17)
      {
        parama.setMarginStart(this.I);
        parama.setMarginEnd(this.H);
      }
      parama.a();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.constraint.b
 * JD-Core Version:    0.6.2
 */