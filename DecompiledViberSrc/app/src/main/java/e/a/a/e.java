package e.a.a;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

public class e
{
  private static String j = Type.getInternalName(d.class);
  final Class<?> a;
  final b[] b;
  final i c;
  final String d;
  final String e;
  final String f;
  final String g;
  final HashMap<Class<?>, Method> h = new HashMap();
  Class<? extends Exception> i = NoSuchFieldException.class;

  public e(Class<?> paramClass, b[] paramArrayOfb, i parami)
  {
    this.a = paramClass;
    this.b = paramArrayOfb;
    this.c = parami;
    this.d = paramClass.getName();
    if (this.d.startsWith("java."));
    for (this.e = ("net.minidev.asm." + this.d + "AccAccess"); ; this.e = this.d.concat("AccAccess"))
    {
      this.f = this.e.replace('.', '/');
      this.g = this.d.replace('.', '/');
      return;
    }
  }

  private void a(MethodVisitor paramMethodVisitor, int paramInt1, int paramInt2, Label paramLabel)
  {
    paramMethodVisitor.visitVarInsn(21, paramInt1);
    if (paramInt2 == 0)
    {
      paramMethodVisitor.visitJumpInsn(154, paramLabel);
      return;
    }
    if (paramInt2 == 1)
    {
      paramMethodVisitor.visitInsn(4);
      paramMethodVisitor.visitJumpInsn(160, paramLabel);
      return;
    }
    if (paramInt2 == 2)
    {
      paramMethodVisitor.visitInsn(5);
      paramMethodVisitor.visitJumpInsn(160, paramLabel);
      return;
    }
    if (paramInt2 == 3)
    {
      paramMethodVisitor.visitInsn(6);
      paramMethodVisitor.visitJumpInsn(160, paramLabel);
      return;
    }
    if (paramInt2 == 4)
    {
      paramMethodVisitor.visitInsn(7);
      paramMethodVisitor.visitJumpInsn(160, paramLabel);
      return;
    }
    if (paramInt2 == 5)
    {
      paramMethodVisitor.visitInsn(8);
      paramMethodVisitor.visitJumpInsn(160, paramLabel);
      return;
    }
    if (paramInt2 >= 6)
    {
      paramMethodVisitor.visitIntInsn(16, paramInt2);
      paramMethodVisitor.visitJumpInsn(160, paramLabel);
      return;
    }
    throw new RuntimeException("non supported negative values");
  }

  private void a(MethodVisitor paramMethodVisitor, b paramb)
  {
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitTypeInsn(192, this.g);
    paramMethodVisitor.visitVarInsn(25, 3);
    Type localType = Type.getType(paramb.e());
    Class localClass = paramb.e();
    String str1 = Type.getInternalName(localClass);
    Method localMethod = (Method)this.h.get(localClass);
    if (localMethod != null)
    {
      paramMethodVisitor.visitMethodInsn(184, Type.getInternalName(localMethod.getDeclaringClass()), localMethod.getName(), Type.getMethodDescriptor(localMethod));
      if (!paramb.b())
        break label380;
      paramMethodVisitor.visitFieldInsn(181, this.g, paramb.d(), localType.getDescriptor());
    }
    while (true)
    {
      paramMethodVisitor.visitInsn(177);
      return;
      if (paramb.c())
      {
        Label localLabel1 = new Label();
        paramMethodVisitor.visitJumpInsn(198, localLabel1);
        paramMethodVisitor.visitVarInsn(25, 3);
        paramMethodVisitor.visitMethodInsn(182, "java/lang/Object", "toString", "()Ljava/lang/String;");
        paramMethodVisitor.visitMethodInsn(184, str1, "valueOf", "(Ljava/lang/String;)L" + str1 + ";");
        paramMethodVisitor.visitVarInsn(58, 3);
        paramMethodVisitor.visitLabel(localLabel1);
        paramMethodVisitor.visitFrame(3, 0, null, 0, null);
        paramMethodVisitor.visitVarInsn(25, 1);
        paramMethodVisitor.visitTypeInsn(192, this.g);
        paramMethodVisitor.visitVarInsn(25, 3);
        paramMethodVisitor.visitTypeInsn(192, str1);
        break;
      }
      if (localClass.equals(String.class))
      {
        Label localLabel2 = new Label();
        paramMethodVisitor.visitJumpInsn(198, localLabel2);
        paramMethodVisitor.visitVarInsn(25, 3);
        paramMethodVisitor.visitMethodInsn(182, "java/lang/Object", "toString", "()Ljava/lang/String;");
        paramMethodVisitor.visitVarInsn(58, 3);
        paramMethodVisitor.visitLabel(localLabel2);
        paramMethodVisitor.visitFrame(3, 0, null, 0, null);
        paramMethodVisitor.visitVarInsn(25, 1);
        paramMethodVisitor.visitTypeInsn(192, this.g);
        paramMethodVisitor.visitVarInsn(25, 3);
        paramMethodVisitor.visitTypeInsn(192, str1);
        break;
      }
      paramMethodVisitor.visitTypeInsn(192, str1);
      break;
      label380: String str2 = Type.getMethodDescriptor(paramb.b);
      paramMethodVisitor.visitMethodInsn(182, this.g, paramb.b.getName(), str2);
    }
  }

  private void a(MethodVisitor paramMethodVisitor, Class<?> paramClass)
  {
    String str = Type.getInternalName(paramClass);
    paramMethodVisitor.visitTypeInsn(187, str);
    paramMethodVisitor.visitInsn(89);
    paramMethodVisitor.visitLdcInsn("mapping " + this.d + " failed to map field:");
    paramMethodVisitor.visitVarInsn(21, 2);
    paramMethodVisitor.visitMethodInsn(184, "java/lang/Integer", "toString", "(I)Ljava/lang/String;");
    paramMethodVisitor.visitMethodInsn(182, "java/lang/String", "concat", "(Ljava/lang/String;)Ljava/lang/String;");
    paramMethodVisitor.visitMethodInsn(183, str, "<init>", "(Ljava/lang/String;)V");
    paramMethodVisitor.visitInsn(191);
  }

  private void b(MethodVisitor paramMethodVisitor, Class<?> paramClass)
  {
    String str = Type.getInternalName(paramClass);
    paramMethodVisitor.visitTypeInsn(187, str);
    paramMethodVisitor.visitInsn(89);
    paramMethodVisitor.visitLdcInsn("mapping " + this.d + " failed to map field:");
    paramMethodVisitor.visitVarInsn(25, 2);
    paramMethodVisitor.visitMethodInsn(182, "java/lang/String", "concat", "(Ljava/lang/String;)Ljava/lang/String;");
    paramMethodVisitor.visitMethodInsn(183, str, "<init>", "(Ljava/lang/String;)V");
    paramMethodVisitor.visitInsn(191);
  }

  public Class<?> a()
  {
    ClassWriter localClassWriter = new ClassWriter(1);
    int k;
    MethodVisitor localMethodVisitor2;
    Label[] arrayOfLabel6;
    int i19;
    b[] arrayOfb6;
    int i21;
    label233: label250: MethodVisitor localMethodVisitor3;
    label316: MethodVisitor localMethodVisitor6;
    Label[] arrayOfLabel3;
    b[] arrayOfb3;
    int i8;
    int i9;
    label378: MethodVisitor localMethodVisitor5;
    label402: Label[] arrayOfLabel2;
    b[] arrayOfb2;
    int i4;
    int i5;
    if (this.b.length > 10)
    {
      k = 1;
      String str1 = "Lnet/minidev/asm/BeansAccess<L" + this.g + ";>;";
      localClassWriter.visit(50, 33, this.f, str1, j, null);
      MethodVisitor localMethodVisitor1 = localClassWriter.visitMethod(1, "<init>", "()V", null, null);
      localMethodVisitor1.visitCode();
      localMethodVisitor1.visitVarInsn(25, 0);
      localMethodVisitor1.visitMethodInsn(183, j, "<init>", "()V");
      localMethodVisitor1.visitInsn(177);
      localMethodVisitor1.visitMaxs(1, 1);
      localMethodVisitor1.visitEnd();
      localMethodVisitor2 = localClassWriter.visitMethod(1, "set", "(Ljava/lang/Object;ILjava/lang/Object;)V", null, null);
      localMethodVisitor2.visitCode();
      if (this.b.length != 0)
      {
        if (this.b.length <= 14)
          break label664;
        localMethodVisitor2.visitVarInsn(21, 2);
        arrayOfLabel6 = a.a(this.b.length);
        Label localLabel2 = new Label();
        localMethodVisitor2.visitTableSwitchInsn(0, -1 + arrayOfLabel6.length, localLabel2, arrayOfLabel6);
        i19 = 0;
        arrayOfb6 = this.b;
        int i20 = arrayOfb6.length;
        i21 = 0;
        if (i21 < i20)
          break label604;
        localMethodVisitor2.visitLabel(localLabel2);
      }
      if (this.i == null)
        break label763;
      a(localMethodVisitor2, this.i);
      localMethodVisitor2.visitMaxs(0, 0);
      localMethodVisitor2.visitEnd();
      localMethodVisitor3 = localClassWriter.visitMethod(1, "get", "(Ljava/lang/Object;I)Ljava/lang/Object;", null, null);
      localMethodVisitor3.visitCode();
      if (this.b.length != 0)
        break label774;
      localMethodVisitor3.visitFrame(3, 0, null, 0, null);
      if (this.i == null)
        break label1299;
      a(localMethodVisitor3, this.i);
      localMethodVisitor3.visitMaxs(0, 0);
      localMethodVisitor3.visitEnd();
      if (k == 0)
      {
        localMethodVisitor6 = localClassWriter.visitMethod(1, "set", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)V", null, null);
        localMethodVisitor6.visitCode();
        arrayOfLabel3 = a.a(this.b.length);
        arrayOfb3 = this.b;
        int i7 = arrayOfb3.length;
        i8 = 0;
        i9 = 0;
        if (i8 < i7)
          break label1316;
        if (this.i == null)
          break label1414;
        b(localMethodVisitor6, this.i);
        localMethodVisitor6.visitMaxs(0, 0);
        localMethodVisitor6.visitEnd();
      }
      if (k == 0)
      {
        localMethodVisitor5 = localClassWriter.visitMethod(1, "get", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", null, null);
        localMethodVisitor5.visitCode();
        arrayOfLabel2 = a.a(this.b.length);
        arrayOfb2 = this.b;
        int i3 = arrayOfb2.length;
        i4 = 0;
        i5 = 0;
        if (i4 < i3)
          break label1425;
        if (this.i == null)
          break label1625;
        b(localMethodVisitor5, this.i);
      }
    }
    while (true)
    {
      localMethodVisitor5.visitMaxs(0, 0);
      localMethodVisitor5.visitEnd();
      MethodVisitor localMethodVisitor4 = localClassWriter.visitMethod(1, "newInstance", "()Ljava/lang/Object;", null, null);
      localMethodVisitor4.visitCode();
      localMethodVisitor4.visitTypeInsn(187, this.g);
      localMethodVisitor4.visitInsn(89);
      localMethodVisitor4.visitMethodInsn(183, this.g, "<init>", "()V");
      localMethodVisitor4.visitInsn(176);
      localMethodVisitor4.visitMaxs(2, 1);
      localMethodVisitor4.visitEnd();
      localClassWriter.visitEnd();
      byte[] arrayOfByte = localClassWriter.toByteArray();
      return this.c.a(this.e, arrayOfByte);
      k = 0;
      break;
      label604: b localb6 = arrayOfb6[i21];
      int i22 = i19 + 1;
      localMethodVisitor2.visitLabel(arrayOfLabel6[i19]);
      if (!localb6.h())
        localMethodVisitor2.visitInsn(177);
      while (true)
      {
        i21++;
        i19 = i22;
        break;
        a(localMethodVisitor2, localb6);
      }
      label664: Label[] arrayOfLabel5 = a.a(this.b.length);
      b[] arrayOfb5 = this.b;
      int i15 = arrayOfb5.length;
      int i16 = 0;
      int i18;
      for (int i17 = 0; i16 < i15; i17 = i18)
      {
        b localb5 = arrayOfb5[i16];
        a(localMethodVisitor2, 2, i17, arrayOfLabel5[i17]);
        a(localMethodVisitor2, localb5);
        localMethodVisitor2.visitLabel(arrayOfLabel5[i17]);
        localMethodVisitor2.visitFrame(3, 0, null, 0, null);
        i18 = i17 + 1;
        i16++;
      }
      break label233;
      label763: localMethodVisitor2.visitInsn(177);
      break label250;
      label774: if (this.b.length > 14)
      {
        localMethodVisitor3.visitVarInsn(21, 2);
        Label[] arrayOfLabel4 = a.a(this.b.length);
        Label localLabel1 = new Label();
        localMethodVisitor3.visitTableSwitchInsn(0, -1 + arrayOfLabel4.length, localLabel1, arrayOfLabel4);
        b[] arrayOfb4 = this.b;
        int i11 = arrayOfb4.length;
        int i12 = 0;
        b localb4;
        int i14;
        for (int i13 = 0; ; i13 = i14)
        {
          if (i12 >= i11)
          {
            localMethodVisitor3.visitLabel(localLabel1);
            localMethodVisitor3.visitFrame(3, 0, null, 0, null);
            break;
          }
          localb4 = arrayOfb4[i12];
          i14 = i13 + 1;
          localMethodVisitor3.visitLabel(arrayOfLabel4[i13]);
          localMethodVisitor3.visitFrame(3, 0, null, 0, null);
          if (localb4.g())
            break label935;
          localMethodVisitor3.visitInsn(1);
          localMethodVisitor3.visitInsn(176);
          i12++;
        }
        label935: localMethodVisitor3.visitVarInsn(25, 1);
        localMethodVisitor3.visitTypeInsn(192, this.g);
        Type localType3 = Type.getType(localb4.e());
        if (localb4.b())
          localMethodVisitor3.visitFieldInsn(180, this.g, localb4.d(), localType3.getDescriptor());
        while (true)
        {
          a.a(localMethodVisitor3, localType3);
          localMethodVisitor3.visitInsn(176);
          break;
          String str4 = Type.getMethodDescriptor(localb4.c);
          localMethodVisitor3.visitMethodInsn(182, this.g, localb4.c.getName(), str4);
        }
      }
      Label[] arrayOfLabel1 = a.a(this.b.length);
      b[] arrayOfb1 = this.b;
      int m = arrayOfb1.length;
      int n = 0;
      int i1 = 0;
      label1075: b localb1;
      Type localType1;
      if (n < m)
      {
        localb1 = arrayOfb1[n];
        a(localMethodVisitor3, 2, i1, arrayOfLabel1[i1]);
        localMethodVisitor3.visitVarInsn(25, 1);
        localMethodVisitor3.visitTypeInsn(192, this.g);
        localType1 = Type.getType(localb1.e());
        if (!localb1.b())
          break label1214;
        localMethodVisitor3.visitFieldInsn(180, this.g, localb1.d(), localType1.getDescriptor());
      }
      while (true)
      {
        a.a(localMethodVisitor3, localType1);
        localMethodVisitor3.visitInsn(176);
        localMethodVisitor3.visitLabel(arrayOfLabel1[i1]);
        localMethodVisitor3.visitFrame(3, 0, null, 0, null);
        int i2 = i1 + 1;
        n++;
        i1 = i2;
        break label1075;
        break;
        label1214: if (localb1.c == null)
          throw new RuntimeException("no Getter for field " + localb1.d() + " in class " + this.d);
        String str2 = Type.getMethodDescriptor(localb1.c);
        localMethodVisitor3.visitMethodInsn(182, this.g, localb1.c.getName(), str2);
      }
      label1299: localMethodVisitor3.visitInsn(1);
      localMethodVisitor3.visitInsn(176);
      break label316;
      label1316: b localb3 = arrayOfb3[i8];
      localMethodVisitor6.visitVarInsn(25, 2);
      localMethodVisitor6.visitLdcInsn(localb3.g);
      localMethodVisitor6.visitMethodInsn(182, "java/lang/String", "equals", "(Ljava/lang/Object;)Z");
      localMethodVisitor6.visitJumpInsn(153, arrayOfLabel3[i9]);
      a(localMethodVisitor6, localb3);
      localMethodVisitor6.visitLabel(arrayOfLabel3[i9]);
      localMethodVisitor6.visitFrame(3, 0, null, 0, null);
      int i10 = i9 + 1;
      i8++;
      i9 = i10;
      break label378;
      label1414: localMethodVisitor6.visitInsn(177);
      break label402;
      label1425: b localb2 = arrayOfb2[i4];
      localMethodVisitor5.visitVarInsn(25, 2);
      localMethodVisitor5.visitLdcInsn(localb2.g);
      localMethodVisitor5.visitMethodInsn(182, "java/lang/String", "equals", "(Ljava/lang/Object;)Z");
      localMethodVisitor5.visitJumpInsn(153, arrayOfLabel2[i5]);
      localMethodVisitor5.visitVarInsn(25, 1);
      localMethodVisitor5.visitTypeInsn(192, this.g);
      Type localType2 = Type.getType(localb2.e());
      if (localb2.b())
        localMethodVisitor5.visitFieldInsn(180, this.g, localb2.d(), localType2.getDescriptor());
      while (true)
      {
        a.a(localMethodVisitor5, localType2);
        localMethodVisitor5.visitInsn(176);
        localMethodVisitor5.visitLabel(arrayOfLabel2[i5]);
        localMethodVisitor5.visitFrame(3, 0, null, 0, null);
        int i6 = i5 + 1;
        i4++;
        i5 = i6;
        break;
        String str3 = Type.getMethodDescriptor(localb2.c);
        localMethodVisitor5.visitMethodInsn(182, this.g, localb2.c.getName(), str3);
      }
      label1625: localMethodVisitor5.visitInsn(1);
      localMethodVisitor5.visitInsn(176);
    }
  }

  public void a(Class<?> paramClass)
  {
    if (paramClass == null)
      return;
    Method[] arrayOfMethod = paramClass.getMethods();
    int k = arrayOfMethod.length;
    int m = 0;
    label16: Method localMethod;
    if (m < k)
    {
      localMethod = arrayOfMethod[m];
      if ((0x8 & localMethod.getModifiers()) != 0)
        break label45;
    }
    while (true)
    {
      m++;
      break label16;
      break;
      label45: Class[] arrayOfClass = localMethod.getParameterTypes();
      if ((arrayOfClass.length == 1) && (arrayOfClass[0].equals(Object.class)))
      {
        Class localClass = localMethod.getReturnType();
        if (!localClass.equals(Void.TYPE))
          this.h.put(localClass, localMethod);
      }
    }
  }

  public void a(Iterable<Class<?>> paramIterable)
  {
    if (paramIterable == null);
    while (true)
    {
      return;
      Iterator localIterator = paramIterable.iterator();
      while (localIterator.hasNext())
        a((Class)localIterator.next());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     e.a.a.e
 * JD-Core Version:    0.6.2
 */