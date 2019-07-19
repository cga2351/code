package android.support.v4.graphics;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

public class PathParser
{
  private static final String LOGTAG = "PathParser";

  private static void addNode(ArrayList<PathDataNode> paramArrayList, char paramChar, float[] paramArrayOfFloat)
  {
    paramArrayList.add(new PathDataNode(paramChar, paramArrayOfFloat));
  }

  public static boolean canMorph(PathDataNode[] paramArrayOfPathDataNode1, PathDataNode[] paramArrayOfPathDataNode2)
  {
    if ((paramArrayOfPathDataNode1 == null) || (paramArrayOfPathDataNode2 == null));
    while (paramArrayOfPathDataNode1.length != paramArrayOfPathDataNode2.length)
      return false;
    for (int i = 0; ; i++)
    {
      if (i >= paramArrayOfPathDataNode1.length)
        break label63;
      if ((paramArrayOfPathDataNode1[i].mType != paramArrayOfPathDataNode2[i].mType) || (paramArrayOfPathDataNode1[i].mParams.length != paramArrayOfPathDataNode2[i].mParams.length))
        break;
    }
    label63: return true;
  }

  static float[] copyOfRange(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2)
      throw new IllegalArgumentException();
    int i = paramArrayOfFloat.length;
    if ((paramInt1 < 0) || (paramInt1 > i))
      throw new ArrayIndexOutOfBoundsException();
    int j = paramInt2 - paramInt1;
    int k = Math.min(j, i - paramInt1);
    float[] arrayOfFloat = new float[j];
    System.arraycopy(paramArrayOfFloat, paramInt1, arrayOfFloat, 0, k);
    return arrayOfFloat;
  }

  public static PathDataNode[] createNodesFromPathData(String paramString)
  {
    if (paramString == null)
      return null;
    ArrayList localArrayList = new ArrayList();
    int i = 1;
    int k;
    for (int j = 0; i < paramString.length(); j = k)
    {
      k = nextStart(paramString, i);
      String str = paramString.substring(j, k).trim();
      if (str.length() > 0)
      {
        float[] arrayOfFloat = getFloats(str);
        addNode(localArrayList, str.charAt(0), arrayOfFloat);
      }
      i = k + 1;
    }
    if ((i - j == 1) && (j < paramString.length()))
      addNode(localArrayList, paramString.charAt(j), new float[0]);
    return (PathDataNode[])localArrayList.toArray(new PathDataNode[localArrayList.size()]);
  }

  public static Path createPathFromPathData(String paramString)
  {
    Path localPath = new Path();
    PathDataNode[] arrayOfPathDataNode = createNodesFromPathData(paramString);
    if (arrayOfPathDataNode != null)
      try
      {
        PathDataNode.nodesToPath(arrayOfPathDataNode, localPath);
        return localPath;
      }
      catch (RuntimeException localRuntimeException)
      {
        throw new RuntimeException("Error in parsing " + paramString, localRuntimeException);
      }
    return null;
  }

  public static PathDataNode[] deepCopyNodes(PathDataNode[] paramArrayOfPathDataNode)
  {
    if (paramArrayOfPathDataNode == null)
      return null;
    PathDataNode[] arrayOfPathDataNode = new PathDataNode[paramArrayOfPathDataNode.length];
    for (int i = 0; i < paramArrayOfPathDataNode.length; i++)
      arrayOfPathDataNode[i] = new PathDataNode(paramArrayOfPathDataNode[i]);
    return arrayOfPathDataNode;
  }

  private static void extract(String paramString, int paramInt, ExtractFloatResult paramExtractFloatResult)
  {
    paramExtractFloatResult.mEndWithNegOrDot = false;
    int i = 0;
    int j = 0;
    int k = 0;
    label164: for (int m = paramInt; ; m++)
    {
      if (m < paramString.length())
        switch (paramString.charAt(m))
        {
        default:
          i = 0;
        case ' ':
        case ',':
        case '-':
        case '.':
        case 'E':
        case 'e':
        }
      while (true)
      {
        if (k == 0)
          break label164;
        paramExtractFloatResult.mEndPosition = m;
        return;
        k = 1;
        i = 0;
        continue;
        if ((m == paramInt) || (i != 0))
          break;
        paramExtractFloatResult.mEndWithNegOrDot = true;
        k = 1;
        i = 0;
        continue;
        if (j == 0)
        {
          j = 1;
          i = 0;
        }
        else
        {
          paramExtractFloatResult.mEndWithNegOrDot = true;
          k = 1;
          i = 0;
          continue;
          i = 1;
        }
      }
    }
  }

  private static float[] getFloats(String paramString)
  {
    int i = 0;
    if ((paramString.charAt(0) == 'z') || (paramString.charAt(0) == 'Z'))
      return new float[0];
    while (true)
    {
      int m;
      try
      {
        float[] arrayOfFloat1 = new float[paramString.length()];
        ExtractFloatResult localExtractFloatResult = new ExtractFloatResult();
        int j = paramString.length();
        k = 1;
        if (k < j)
        {
          extract(paramString, k, localExtractFloatResult);
          m = localExtractFloatResult.mEndPosition;
          if (k >= m)
            break label162;
          n = i + 1;
          arrayOfFloat1[i] = Float.parseFloat(paramString.substring(k, m));
          if (!localExtractFloatResult.mEndWithNegOrDot)
            break label168;
          k = m;
          i = n;
          continue;
        }
        float[] arrayOfFloat2 = copyOfRange(arrayOfFloat1, 0, i);
        return arrayOfFloat2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new RuntimeException("error in parsing \"" + paramString + "\"", localNumberFormatException);
      }
      label162: int n = i;
      continue;
      label168: int k = m + 1;
      i = n;
    }
  }

  private static int nextStart(String paramString, int paramInt)
  {
    while (true)
    {
      if (paramInt < paramString.length())
      {
        int i = paramString.charAt(paramInt);
        if ((((i - 65) * (i - 90) > 0) && ((i - 97) * (i - 122) > 0)) || (i == 101) || (i == 69));
      }
      else
      {
        return paramInt;
      }
      paramInt++;
    }
  }

  public static void updateNodes(PathDataNode[] paramArrayOfPathDataNode1, PathDataNode[] paramArrayOfPathDataNode2)
  {
    for (int i = 0; i < paramArrayOfPathDataNode2.length; i++)
    {
      paramArrayOfPathDataNode1[i].mType = paramArrayOfPathDataNode2[i].mType;
      for (int j = 0; j < paramArrayOfPathDataNode2[i].mParams.length; j++)
        paramArrayOfPathDataNode1[i].mParams[j] = paramArrayOfPathDataNode2[i].mParams[j];
    }
  }

  private static class ExtractFloatResult
  {
    int mEndPosition;
    boolean mEndWithNegOrDot;
  }

  public static class PathDataNode
  {
    public float[] mParams;
    public char mType;

    PathDataNode(char paramChar, float[] paramArrayOfFloat)
    {
      this.mType = paramChar;
      this.mParams = paramArrayOfFloat;
    }

    PathDataNode(PathDataNode paramPathDataNode)
    {
      this.mType = paramPathDataNode.mType;
      this.mParams = PathParser.copyOfRange(paramPathDataNode.mParams, 0, paramPathDataNode.mParams.length);
    }

    private static void addCommand(Path paramPath, float[] paramArrayOfFloat1, char paramChar1, char paramChar2, float[] paramArrayOfFloat2)
    {
      float f1 = paramArrayOfFloat1[0];
      float f2 = paramArrayOfFloat1[1];
      float f3 = paramArrayOfFloat1[2];
      float f4 = paramArrayOfFloat1[3];
      float f5 = paramArrayOfFloat1[4];
      float f6 = paramArrayOfFloat1[5];
      int i;
      int j;
      float f7;
      float f8;
      float f9;
      float f10;
      label222: float f18;
      float f19;
      float f20;
      float f21;
      float f22;
      float f23;
      float f55;
      switch (paramChar2)
      {
      default:
        i = 2;
        j = 0;
        f7 = f6;
        f8 = f5;
        f9 = f2;
        f10 = f1;
        if (j < paramArrayOfFloat2.length)
          switch (paramChar2)
          {
          default:
            f18 = f7;
            f19 = f8;
            f20 = f3;
            f21 = f9;
            f22 = f10;
            f23 = f4;
          case 'm':
          case 'M':
          case 'l':
          case 'L':
          case 'h':
          case 'H':
          case 'v':
          case 'V':
          case 'c':
          case 'C':
          case 's':
          case 'S':
          case 'q':
          case 'Q':
          case 't':
          case 'T':
          case 'a':
          case 'A':
          }
        break;
      case 'Z':
      case 'z':
      case 'L':
      case 'M':
      case 'T':
      case 'l':
      case 'm':
      case 't':
      case 'H':
      case 'V':
      case 'h':
      case 'v':
      case 'C':
      case 'c':
      case 'Q':
      case 'S':
      case 'q':
      case 's':
      case 'A':
      case 'a':
        while (true)
        {
          j += i;
          f7 = f18;
          f8 = f19;
          f9 = f21;
          f10 = f22;
          paramChar1 = paramChar2;
          f4 = f23;
          f3 = f20;
          break label222;
          paramPath.close();
          paramPath.moveTo(f5, f6);
          f4 = f6;
          f3 = f5;
          f2 = f6;
          f1 = f5;
          i = 2;
          break;
          i = 2;
          break;
          i = 1;
          break;
          i = 6;
          break;
          i = 4;
          break;
          i = 7;
          break;
          f19 = f10 + paramArrayOfFloat2[(j + 0)];
          f18 = f9 + paramArrayOfFloat2[(j + 1)];
          if (j > 0)
          {
            paramPath.rLineTo(paramArrayOfFloat2[(j + 0)], paramArrayOfFloat2[(j + 1)]);
            f20 = f3;
            f21 = f18;
            f22 = f19;
            f18 = f7;
            f19 = f8;
            f23 = f4;
          }
          else
          {
            paramPath.rMoveTo(paramArrayOfFloat2[(j + 0)], paramArrayOfFloat2[(j + 1)]);
            f20 = f3;
            f21 = f18;
            f22 = f19;
            f23 = f4;
            continue;
            f19 = paramArrayOfFloat2[(j + 0)];
            f18 = paramArrayOfFloat2[(j + 1)];
            if (j > 0)
            {
              paramPath.lineTo(paramArrayOfFloat2[(j + 0)], paramArrayOfFloat2[(j + 1)]);
              f20 = f3;
              f21 = f18;
              f22 = f19;
              f18 = f7;
              f19 = f8;
              f23 = f4;
            }
            else
            {
              paramPath.moveTo(paramArrayOfFloat2[(j + 0)], paramArrayOfFloat2[(j + 1)]);
              f20 = f3;
              f21 = f18;
              f22 = f19;
              f23 = f4;
              continue;
              paramPath.rLineTo(paramArrayOfFloat2[(j + 0)], paramArrayOfFloat2[(j + 1)]);
              float f76 = f10 + paramArrayOfFloat2[(j + 0)];
              float f77 = f9 + paramArrayOfFloat2[(j + 1)];
              f20 = f3;
              f21 = f77;
              f22 = f76;
              f18 = f7;
              f19 = f8;
              f23 = f4;
              continue;
              paramPath.lineTo(paramArrayOfFloat2[(j + 0)], paramArrayOfFloat2[(j + 1)]);
              float f74 = paramArrayOfFloat2[(j + 0)];
              float f75 = paramArrayOfFloat2[(j + 1)];
              f20 = f3;
              f21 = f75;
              f22 = f74;
              f18 = f7;
              f19 = f8;
              f23 = f4;
              continue;
              paramPath.rLineTo(paramArrayOfFloat2[(j + 0)], 0.0F);
              float f73 = f10 + paramArrayOfFloat2[(j + 0)];
              f18 = f7;
              f20 = f3;
              f21 = f9;
              f22 = f73;
              f23 = f4;
              f19 = f8;
              continue;
              paramPath.lineTo(paramArrayOfFloat2[(j + 0)], f9);
              float f72 = paramArrayOfFloat2[(j + 0)];
              f18 = f7;
              f20 = f3;
              f21 = f9;
              f22 = f72;
              f23 = f4;
              f19 = f8;
              continue;
              paramPath.rLineTo(0.0F, paramArrayOfFloat2[(j + 0)]);
              float f71 = f9 + paramArrayOfFloat2[(j + 0)];
              f19 = f8;
              f20 = f3;
              f21 = f71;
              f22 = f10;
              f23 = f4;
              f18 = f7;
              continue;
              float f69 = paramArrayOfFloat2[(j + 0)];
              paramPath.lineTo(f10, f69);
              float f70 = paramArrayOfFloat2[(j + 0)];
              f19 = f8;
              f20 = f3;
              f21 = f70;
              f22 = f10;
              f23 = f4;
              f18 = f7;
              continue;
              paramPath.rCubicTo(paramArrayOfFloat2[(j + 0)], paramArrayOfFloat2[(j + 1)], paramArrayOfFloat2[(j + 2)], paramArrayOfFloat2[(j + 3)], paramArrayOfFloat2[(j + 4)], paramArrayOfFloat2[(j + 5)]);
              float f65 = f10 + paramArrayOfFloat2[(j + 2)];
              float f66 = f9 + paramArrayOfFloat2[(j + 3)];
              float f67 = f10 + paramArrayOfFloat2[(j + 4)];
              float f68 = f9 + paramArrayOfFloat2[(j + 5)];
              f20 = f65;
              f21 = f68;
              f22 = f67;
              f18 = f7;
              f19 = f8;
              f23 = f66;
              continue;
              paramPath.cubicTo(paramArrayOfFloat2[(j + 0)], paramArrayOfFloat2[(j + 1)], paramArrayOfFloat2[(j + 2)], paramArrayOfFloat2[(j + 3)], paramArrayOfFloat2[(j + 4)], paramArrayOfFloat2[(j + 5)]);
              float f61 = paramArrayOfFloat2[(j + 4)];
              float f62 = paramArrayOfFloat2[(j + 5)];
              float f63 = paramArrayOfFloat2[(j + 2)];
              float f64 = paramArrayOfFloat2[(j + 3)];
              f20 = f63;
              f21 = f62;
              f22 = f61;
              f18 = f7;
              f19 = f8;
              f23 = f64;
            }
          }
        }
        if ((paramChar1 == 'c') || (paramChar1 == 's') || (paramChar1 == 'C') || (paramChar1 == 'S'))
          f55 = f10 - f3;
        break;
      }
      for (float f56 = f9 - f4; ; f56 = 0.0F)
      {
        paramPath.rCubicTo(f55, f56, paramArrayOfFloat2[(j + 0)], paramArrayOfFloat2[(j + 1)], paramArrayOfFloat2[(j + 2)], paramArrayOfFloat2[(j + 3)]);
        float f57 = f10 + paramArrayOfFloat2[(j + 0)];
        float f58 = f9 + paramArrayOfFloat2[(j + 1)];
        float f59 = f10 + paramArrayOfFloat2[(j + 2)];
        float f60 = f9 + paramArrayOfFloat2[(j + 3)];
        f20 = f57;
        f21 = f60;
        f22 = f59;
        f18 = f7;
        f19 = f8;
        f23 = f58;
        break;
        float f49;
        float f50;
        if ((paramChar1 == 'c') || (paramChar1 == 's') || (paramChar1 == 'C') || (paramChar1 == 'S'))
        {
          f49 = 2.0F * f10 - f3;
          f50 = 2.0F * f9 - f4;
        }
        while (true)
        {
          paramPath.cubicTo(f49, f50, paramArrayOfFloat2[(j + 0)], paramArrayOfFloat2[(j + 1)], paramArrayOfFloat2[(j + 2)], paramArrayOfFloat2[(j + 3)]);
          float f51 = paramArrayOfFloat2[(j + 0)];
          float f52 = paramArrayOfFloat2[(j + 1)];
          float f53 = paramArrayOfFloat2[(j + 2)];
          float f54 = paramArrayOfFloat2[(j + 3)];
          f20 = f51;
          f21 = f54;
          f22 = f53;
          f18 = f7;
          f19 = f8;
          f23 = f52;
          break;
          paramPath.rQuadTo(paramArrayOfFloat2[(j + 0)], paramArrayOfFloat2[(j + 1)], paramArrayOfFloat2[(j + 2)], paramArrayOfFloat2[(j + 3)]);
          float f45 = f10 + paramArrayOfFloat2[(j + 0)];
          float f46 = f9 + paramArrayOfFloat2[(j + 1)];
          float f47 = f10 + paramArrayOfFloat2[(j + 2)];
          float f48 = f9 + paramArrayOfFloat2[(j + 3)];
          f20 = f45;
          f21 = f48;
          f22 = f47;
          f18 = f7;
          f19 = f8;
          f23 = f46;
          break;
          paramPath.quadTo(paramArrayOfFloat2[(j + 0)], paramArrayOfFloat2[(j + 1)], paramArrayOfFloat2[(j + 2)], paramArrayOfFloat2[(j + 3)]);
          float f41 = paramArrayOfFloat2[(j + 0)];
          float f42 = paramArrayOfFloat2[(j + 1)];
          float f43 = paramArrayOfFloat2[(j + 2)];
          float f44 = paramArrayOfFloat2[(j + 3)];
          f20 = f41;
          f21 = f44;
          f22 = f43;
          f18 = f7;
          f19 = f8;
          f23 = f42;
          break;
          float f35;
          float f36;
          if ((paramChar1 == 'q') || (paramChar1 == 't') || (paramChar1 == 'Q') || (paramChar1 == 'T'))
          {
            f35 = f10 - f3;
            f36 = f9 - f4;
          }
          while (true)
          {
            paramPath.rQuadTo(f35, f36, paramArrayOfFloat2[(j + 0)], paramArrayOfFloat2[(j + 1)]);
            float f37 = f10 + f35;
            float f38 = f36 + f9;
            float f39 = f10 + paramArrayOfFloat2[(j + 0)];
            float f40 = f9 + paramArrayOfFloat2[(j + 1)];
            f20 = f37;
            f21 = f40;
            f22 = f39;
            f18 = f7;
            f19 = f8;
            f23 = f38;
            break;
            if ((paramChar1 == 'q') || (paramChar1 == 't') || (paramChar1 == 'Q') || (paramChar1 == 'T'))
            {
              f10 = 2.0F * f10 - f3;
              f9 = 2.0F * f9 - f4;
            }
            float f31 = paramArrayOfFloat2[(j + 0)];
            float f32 = paramArrayOfFloat2[(j + 1)];
            paramPath.quadTo(f10, f9, f31, f32);
            float f33 = paramArrayOfFloat2[(j + 0)];
            float f34 = paramArrayOfFloat2[(j + 1)];
            f23 = f9;
            f20 = f10;
            f21 = f34;
            f22 = f33;
            f18 = f7;
            f19 = f8;
            break;
            float f24 = f10 + paramArrayOfFloat2[(j + 5)];
            float f25 = f9 + paramArrayOfFloat2[(j + 6)];
            float f26 = paramArrayOfFloat2[(j + 0)];
            float f27 = paramArrayOfFloat2[(j + 1)];
            float f28 = paramArrayOfFloat2[(j + 2)];
            boolean bool3;
            if (paramArrayOfFloat2[(j + 3)] != 0.0F)
            {
              bool3 = true;
              label2093: if (paramArrayOfFloat2[(j + 4)] == 0.0F)
                break label2188;
            }
            label2188: for (boolean bool4 = true; ; bool4 = false)
            {
              drawArc(paramPath, f10, f9, f24, f25, f26, f27, f28, bool3, bool4);
              float f29 = f10 + paramArrayOfFloat2[(j + 5)];
              float f30 = f9 + paramArrayOfFloat2[(j + 6)];
              f18 = f7;
              f19 = f8;
              f20 = f29;
              f21 = f30;
              f22 = f29;
              f23 = f30;
              break;
              bool3 = false;
              break label2093;
            }
            float f11 = paramArrayOfFloat2[(j + 5)];
            float f12 = paramArrayOfFloat2[(j + 6)];
            float f13 = paramArrayOfFloat2[(j + 0)];
            float f14 = paramArrayOfFloat2[(j + 1)];
            float f15 = paramArrayOfFloat2[(j + 2)];
            boolean bool1;
            if (paramArrayOfFloat2[(j + 3)] != 0.0F)
            {
              bool1 = true;
              label2255: if (paramArrayOfFloat2[(j + 4)] == 0.0F)
                break label2344;
            }
            label2344: for (boolean bool2 = true; ; bool2 = false)
            {
              drawArc(paramPath, f10, f9, f11, f12, f13, f14, f15, bool1, bool2);
              float f16 = paramArrayOfFloat2[(j + 5)];
              float f17 = paramArrayOfFloat2[(j + 6)];
              f18 = f7;
              f19 = f8;
              f20 = f16;
              f21 = f17;
              f22 = f16;
              f23 = f17;
              break;
              bool1 = false;
              break label2255;
            }
            paramArrayOfFloat1[0] = f10;
            paramArrayOfFloat1[1] = f9;
            paramArrayOfFloat1[2] = f3;
            paramArrayOfFloat1[3] = f4;
            paramArrayOfFloat1[4] = f8;
            paramArrayOfFloat1[5] = f7;
            return;
            f36 = 0.0F;
            f35 = 0.0F;
          }
          f50 = f9;
          f49 = f10;
        }
        f55 = 0.0F;
      }
    }

    private static void arcToBezier(Path paramPath, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8, double paramDouble9)
    {
      int i = (int)Math.ceil(Math.abs(4.0D * paramDouble9 / 3.141592653589793D));
      double d1 = Math.cos(paramDouble7);
      double d2 = Math.sin(paramDouble7);
      double d3 = Math.cos(paramDouble8);
      double d4 = Math.sin(paramDouble8);
      double d5 = d4 * (d1 * -paramDouble3) - d3 * (paramDouble4 * d2);
      double d6 = d4 * (d2 * -paramDouble3) + d3 * (paramDouble4 * d1);
      double d7 = paramDouble9 / i;
      int j = 0;
      double d8 = d6;
      double d9 = d5;
      while (j < i)
      {
        double d10 = paramDouble8 + d7;
        double d11 = Math.sin(d10);
        double d12 = Math.cos(d10);
        double d13 = paramDouble1 + d12 * (paramDouble3 * d1) - d11 * (paramDouble4 * d2);
        double d14 = paramDouble2 + d12 * (paramDouble3 * d2) + d11 * (paramDouble4 * d1);
        double d15 = d11 * (d1 * -paramDouble3) - d12 * (paramDouble4 * d2);
        double d16 = d11 * (d2 * -paramDouble3) + d12 * (paramDouble4 * d1);
        double d17 = Math.tan((d10 - paramDouble8) / 2.0D);
        double d18 = Math.sin(d10 - paramDouble8) * (Math.sqrt(4.0D + d17 * (3.0D * d17)) - 1.0D) / 3.0D;
        double d19 = paramDouble5 + d9 * d18;
        double d20 = paramDouble6 + d8 * d18;
        double d21 = d13 - d18 * d15;
        double d22 = d14 - d18 * d16;
        paramPath.rLineTo(0.0F, 0.0F);
        paramPath.cubicTo((float)d19, (float)d20, (float)d21, (float)d22, (float)d13, (float)d14);
        j++;
        d9 = d15;
        paramDouble8 = d10;
        paramDouble6 = d14;
        paramDouble5 = d13;
        d8 = d16;
      }
    }

    private static void drawArc(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, boolean paramBoolean1, boolean paramBoolean2)
    {
      double d1 = Math.toRadians(paramFloat7);
      double d2 = Math.cos(d1);
      double d3 = Math.sin(d1);
      double d4 = (d2 * paramFloat1 + d3 * paramFloat2) / paramFloat5;
      double d5 = (d3 * -paramFloat1 + d2 * paramFloat2) / paramFloat6;
      double d6 = (d2 * paramFloat3 + d3 * paramFloat4) / paramFloat5;
      double d7 = (d3 * -paramFloat3 + d2 * paramFloat4) / paramFloat6;
      double d8 = d4 - d6;
      double d9 = d5 - d7;
      double d10 = (d4 + d6) / 2.0D;
      double d11 = (d5 + d7) / 2.0D;
      double d12 = d8 * d8 + d9 * d9;
      if (d12 == 0.0D)
      {
        Log.w("PathParser", " Points are coincident");
        return;
      }
      double d13 = 1.0D / d12 - 0.25D;
      if (d13 < 0.0D)
      {
        Log.w("PathParser", "Points are too far apart " + d12);
        float f = (float)(Math.sqrt(d12) / 1.99999D);
        drawArc(paramPath, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5 * f, paramFloat6 * f, paramFloat7, paramBoolean1, paramBoolean2);
        return;
      }
      double d14 = Math.sqrt(d13);
      double d15 = d8 * d14;
      double d16 = d9 * d14;
      double d17;
      double d18;
      double d19;
      double d20;
      boolean bool;
      if (paramBoolean1 == paramBoolean2)
      {
        d17 = d10 - d16;
        d18 = d15 + d11;
        d19 = Math.atan2(d5 - d18, d4 - d17);
        d20 = Math.atan2(d7 - d18, d6 - d17) - d19;
        if (d20 < 0.0D)
          break label423;
        bool = true;
        label325: if (paramBoolean2 != bool)
          if (d20 <= 0.0D)
            break label429;
      }
      label423: label429: for (d20 -= 6.283185307179586D; ; d20 += 6.283185307179586D)
      {
        double d21 = d17 * paramFloat5;
        double d22 = d18 * paramFloat6;
        arcToBezier(paramPath, d21 * d2 - d22 * d3, d21 * d3 + d22 * d2, paramFloat5, paramFloat6, paramFloat1, paramFloat2, d1, d19, d20);
        return;
        d17 = d16 + d10;
        d18 = d11 - d15;
        break;
        bool = false;
        break label325;
      }
    }

    public static void nodesToPath(PathDataNode[] paramArrayOfPathDataNode, Path paramPath)
    {
      float[] arrayOfFloat = new float[6];
      char c = 'm';
      for (int i = 0; i < paramArrayOfPathDataNode.length; i++)
      {
        addCommand(paramPath, arrayOfFloat, c, paramArrayOfPathDataNode[i].mType, paramArrayOfPathDataNode[i].mParams);
        c = paramArrayOfPathDataNode[i].mType;
      }
    }

    public void interpolatePathDataNode(PathDataNode paramPathDataNode1, PathDataNode paramPathDataNode2, float paramFloat)
    {
      for (int i = 0; i < paramPathDataNode1.mParams.length; i++)
        this.mParams[i] = (paramPathDataNode1.mParams[i] * (1.0F - paramFloat) + paramFloat * paramPathDataNode2.mParams[i]);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.graphics.PathParser
 * JD-Core Version:    0.6.2
 */