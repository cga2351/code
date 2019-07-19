package e.a.a;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

public class a
{
  public static String a(String paramString)
  {
    int i = paramString.length();
    char[] arrayOfChar = new char[i + 3];
    arrayOfChar[0] = 's';
    arrayOfChar[1] = 'e';
    arrayOfChar[2] = 't';
    int j = paramString.charAt(0);
    if ((j >= 97) && (j <= 122))
      j = (char)(j - 32);
    arrayOfChar[3] = j;
    for (int k = 1; ; k++)
    {
      if (k >= i)
        return new String(arrayOfChar);
      arrayOfChar[(k + 3)] = paramString.charAt(k);
    }
  }

  protected static void a(MethodVisitor paramMethodVisitor, Type paramType)
  {
    switch (paramType.getSort())
    {
    default:
      return;
    case 1:
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
      return;
    case 3:
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
      return;
    case 2:
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
      return;
    case 4:
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
      return;
    case 5:
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
      return;
    case 6:
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
      return;
    case 7:
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
      return;
    case 8:
    }
    paramMethodVisitor.visitMethodInsn(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
  }

  public static b[] a(Class<?> paramClass, j paramj)
  {
    HashMap localHashMap = new HashMap();
    if (paramj == null)
      paramj = c.a;
    Field[] arrayOfField;
    int j;
    while (true)
    {
      if (paramClass == Object.class)
        return (b[])localHashMap.values().toArray(new b[localHashMap.size()]);
      arrayOfField = paramClass.getDeclaredFields();
      int i = arrayOfField.length;
      j = 0;
      if (j < i)
        break;
      paramClass = paramClass.getSuperclass();
    }
    Field localField = arrayOfField[j];
    String str = localField.getName();
    if (localHashMap.containsKey(str));
    while (true)
    {
      j++;
      break;
      b localb = new b(paramClass, localField, paramj);
      if (localb.f())
        localHashMap.put(str, localb);
    }
  }

  public static Label[] a(int paramInt)
  {
    Label[] arrayOfLabel = new Label[paramInt];
    for (int i = 0; ; i++)
    {
      if (i >= paramInt)
        return arrayOfLabel;
      arrayOfLabel[i] = new Label();
    }
  }

  public static String b(String paramString)
  {
    int i = paramString.length();
    char[] arrayOfChar = new char[i + 3];
    arrayOfChar[0] = 'g';
    arrayOfChar[1] = 'e';
    arrayOfChar[2] = 't';
    int j = paramString.charAt(0);
    if ((j >= 97) && (j <= 122))
      j = (char)(j - 32);
    arrayOfChar[3] = j;
    for (int k = 1; ; k++)
    {
      if (k >= i)
        return new String(arrayOfChar);
      arrayOfChar[(k + 3)] = paramString.charAt(k);
    }
  }

  public static String c(String paramString)
  {
    int i = paramString.length();
    char[] arrayOfChar = new char[i + 2];
    arrayOfChar[0] = 'i';
    arrayOfChar[1] = 's';
    int j = paramString.charAt(0);
    if ((j >= 97) && (j <= 122))
      j = (char)(j - 32);
    arrayOfChar[2] = j;
    for (int k = 1; ; k++)
    {
      if (k >= i)
        return new String(arrayOfChar);
      arrayOfChar[(k + 2)] = paramString.charAt(k);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     e.a.a.a
 * JD-Core Version:    0.6.2
 */