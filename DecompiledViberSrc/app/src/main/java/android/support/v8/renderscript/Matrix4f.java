package android.support.v8.renderscript;

public class Matrix4f
{
  final float[] mMat = new float[16];

  public Matrix4f()
  {
    loadIdentity();
  }

  public Matrix4f(float[] paramArrayOfFloat)
  {
    System.arraycopy(paramArrayOfFloat, 0, this.mMat, 0, this.mMat.length);
  }

  private float computeCofactor(int paramInt1, int paramInt2)
  {
    int i = (paramInt1 + 1) % 4;
    int j = (paramInt1 + 2) % 4;
    int k = (paramInt1 + 3) % 4;
    int m = (paramInt2 + 1) % 4;
    int n = (paramInt2 + 2) % 4;
    int i1 = (paramInt2 + 3) % 4;
    float f = this.mMat[(i + m * 4)] * (this.mMat[(j + n * 4)] * this.mMat[(k + i1 * 4)] - this.mMat[(j + i1 * 4)] * this.mMat[(k + n * 4)]) - this.mMat[(i + n * 4)] * (this.mMat[(j + m * 4)] * this.mMat[(k + i1 * 4)] - this.mMat[(j + i1 * 4)] * this.mMat[(k + m * 4)]) + this.mMat[(i + i1 * 4)] * (this.mMat[(j + m * 4)] * this.mMat[(k + n * 4)] - this.mMat[(j + n * 4)] * this.mMat[(k + m * 4)]);
    if ((0x1 & paramInt1 + paramInt2) != 0)
      f = -f;
    return f;
  }

  public float get(int paramInt1, int paramInt2)
  {
    return this.mMat[(paramInt2 + paramInt1 * 4)];
  }

  public float[] getArray()
  {
    return this.mMat;
  }

  public boolean inverse()
  {
    int i = 0;
    Matrix4f localMatrix4f = new Matrix4f();
    for (int j = 0; j < 4; j++)
      for (int k = 0; k < 4; k++)
        localMatrix4f.mMat[(k + j * 4)] = computeCofactor(j, k);
    float f1 = this.mMat[0] * localMatrix4f.mMat[0] + this.mMat[4] * localMatrix4f.mMat[1] + this.mMat[8] * localMatrix4f.mMat[2] + this.mMat[12] * localMatrix4f.mMat[3];
    if (Math.abs(f1) < 1.0E-006D)
      return false;
    float f2 = 1.0F / f1;
    while (i < 16)
    {
      this.mMat[i] = (f2 * localMatrix4f.mMat[i]);
      i++;
    }
    return true;
  }

  public boolean inverseTranspose()
  {
    int i = 0;
    Matrix4f localMatrix4f = new Matrix4f();
    for (int j = 0; j < 4; j++)
      for (int k = 0; k < 4; k++)
        localMatrix4f.mMat[(j + k * 4)] = computeCofactor(j, k);
    float f1 = this.mMat[0] * localMatrix4f.mMat[0] + this.mMat[4] * localMatrix4f.mMat[4] + this.mMat[8] * localMatrix4f.mMat[8] + this.mMat[12] * localMatrix4f.mMat[12];
    if (Math.abs(f1) < 1.0E-006D)
      return false;
    float f2 = 1.0F / f1;
    while (i < 16)
    {
      this.mMat[i] = (f2 * localMatrix4f.mMat[i]);
      i++;
    }
    return true;
  }

  public void load(Matrix3f paramMatrix3f)
  {
    this.mMat[0] = paramMatrix3f.mMat[0];
    this.mMat[1] = paramMatrix3f.mMat[1];
    this.mMat[2] = paramMatrix3f.mMat[2];
    this.mMat[3] = 0.0F;
    this.mMat[4] = paramMatrix3f.mMat[3];
    this.mMat[5] = paramMatrix3f.mMat[4];
    this.mMat[6] = paramMatrix3f.mMat[5];
    this.mMat[7] = 0.0F;
    this.mMat[8] = paramMatrix3f.mMat[6];
    this.mMat[9] = paramMatrix3f.mMat[7];
    this.mMat[10] = paramMatrix3f.mMat[8];
    this.mMat[11] = 0.0F;
    this.mMat[12] = 0.0F;
    this.mMat[13] = 0.0F;
    this.mMat[14] = 0.0F;
    this.mMat[15] = 1.0F;
  }

  public void load(Matrix4f paramMatrix4f)
  {
    System.arraycopy(paramMatrix4f.getArray(), 0, this.mMat, 0, this.mMat.length);
  }

  public void loadFrustum(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    loadIdentity();
    this.mMat[0] = (2.0F * paramFloat5 / (paramFloat2 - paramFloat1));
    this.mMat[5] = (2.0F * paramFloat5 / (paramFloat4 - paramFloat3));
    this.mMat[8] = ((paramFloat2 + paramFloat1) / (paramFloat2 - paramFloat1));
    this.mMat[9] = ((paramFloat4 + paramFloat3) / (paramFloat4 - paramFloat3));
    this.mMat[10] = (-(paramFloat6 + paramFloat5) / (paramFloat6 - paramFloat5));
    this.mMat[11] = -1.0F;
    this.mMat[14] = (paramFloat5 * (-2.0F * paramFloat6) / (paramFloat6 - paramFloat5));
    this.mMat[15] = 0.0F;
  }

  public void loadIdentity()
  {
    this.mMat[0] = 1.0F;
    this.mMat[1] = 0.0F;
    this.mMat[2] = 0.0F;
    this.mMat[3] = 0.0F;
    this.mMat[4] = 0.0F;
    this.mMat[5] = 1.0F;
    this.mMat[6] = 0.0F;
    this.mMat[7] = 0.0F;
    this.mMat[8] = 0.0F;
    this.mMat[9] = 0.0F;
    this.mMat[10] = 1.0F;
    this.mMat[11] = 0.0F;
    this.mMat[12] = 0.0F;
    this.mMat[13] = 0.0F;
    this.mMat[14] = 0.0F;
    this.mMat[15] = 1.0F;
  }

  public void loadMultiply(Matrix4f paramMatrix4f1, Matrix4f paramMatrix4f2)
  {
    for (int i = 0; i < 4; i++)
    {
      int j = 0;
      float f1 = 0.0F;
      float f2 = 0.0F;
      float f3 = 0.0F;
      float f4 = 0.0F;
      while (j < 4)
      {
        float f5 = paramMatrix4f2.get(i, j);
        f4 += f5 * paramMatrix4f1.get(j, 0);
        f3 += f5 * paramMatrix4f1.get(j, 1);
        f2 += f5 * paramMatrix4f1.get(j, 2);
        f1 += f5 * paramMatrix4f1.get(j, 3);
        j++;
      }
      set(i, 0, f4);
      set(i, 1, f3);
      set(i, 2, f2);
      set(i, 3, f1);
    }
  }

  public void loadOrtho(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    loadIdentity();
    this.mMat[0] = (2.0F / (paramFloat2 - paramFloat1));
    this.mMat[5] = (2.0F / (paramFloat4 - paramFloat3));
    this.mMat[10] = (-2.0F / (paramFloat6 - paramFloat5));
    this.mMat[12] = (-(paramFloat2 + paramFloat1) / (paramFloat2 - paramFloat1));
    this.mMat[13] = (-(paramFloat4 + paramFloat3) / (paramFloat4 - paramFloat3));
    this.mMat[14] = (-(paramFloat6 + paramFloat5) / (paramFloat6 - paramFloat5));
  }

  public void loadOrthoWindow(int paramInt1, int paramInt2)
  {
    loadOrtho(0.0F, paramInt1, paramInt2, 0.0F, -1.0F, 1.0F);
  }

  public void loadPerspective(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = paramFloat3 * (float)Math.tan((float)(3.141592653589793D * paramFloat1 / 360.0D));
    float f2 = -f1;
    loadFrustum(f2 * paramFloat2, f1 * paramFloat2, f2, f1, paramFloat3, paramFloat4);
  }

  public void loadProjectionNormalized(int paramInt1, int paramInt2)
  {
    Matrix4f localMatrix4f1 = new Matrix4f();
    Matrix4f localMatrix4f2 = new Matrix4f();
    if (paramInt1 > paramInt2)
    {
      float f2 = paramInt1 / paramInt2;
      localMatrix4f1.loadFrustum(-f2, f2, -1.0F, 1.0F, 1.0F, 100.0F);
    }
    while (true)
    {
      localMatrix4f2.loadRotate(180.0F, 0.0F, 1.0F, 0.0F);
      localMatrix4f1.loadMultiply(localMatrix4f1, localMatrix4f2);
      localMatrix4f2.loadScale(-2.0F, 2.0F, 1.0F);
      localMatrix4f1.loadMultiply(localMatrix4f1, localMatrix4f2);
      localMatrix4f2.loadTranslate(0.0F, 0.0F, 2.0F);
      localMatrix4f1.loadMultiply(localMatrix4f1, localMatrix4f2);
      load(localMatrix4f1);
      return;
      float f1 = paramInt2 / paramInt1;
      localMatrix4f1.loadFrustum(-1.0F, 1.0F, -f1, f1, 1.0F, 100.0F);
    }
  }

  public void loadRotate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.mMat[3] = 0.0F;
    this.mMat[7] = 0.0F;
    this.mMat[11] = 0.0F;
    this.mMat[12] = 0.0F;
    this.mMat[13] = 0.0F;
    this.mMat[14] = 0.0F;
    this.mMat[15] = 1.0F;
    float f1 = 0.01745329F * paramFloat1;
    float f2 = (float)Math.cos(f1);
    float f3 = (float)Math.sin(f1);
    float f4 = (float)Math.sqrt(paramFloat2 * paramFloat2 + paramFloat3 * paramFloat3 + paramFloat4 * paramFloat4);
    if (f4 == 1.0F)
    {
      float f12 = 1.0F / f4;
      paramFloat2 *= f12;
      paramFloat3 *= f12;
      paramFloat4 *= f12;
    }
    float f5 = 1.0F - f2;
    float f6 = paramFloat2 * paramFloat3;
    float f7 = paramFloat3 * paramFloat4;
    float f8 = paramFloat4 * paramFloat2;
    float f9 = paramFloat2 * f3;
    float f10 = paramFloat3 * f3;
    float f11 = f3 * paramFloat4;
    this.mMat[0] = (f2 + f5 * (paramFloat2 * paramFloat2));
    this.mMat[4] = (f6 * f5 - f11);
    this.mMat[8] = (f10 + f8 * f5);
    this.mMat[1] = (f11 + f6 * f5);
    this.mMat[5] = (f2 + f5 * (paramFloat3 * paramFloat3));
    this.mMat[9] = (f7 * f5 - f9);
    this.mMat[2] = (f8 * f5 - f10);
    this.mMat[6] = (f9 + f7 * f5);
    this.mMat[10] = (f2 + f5 * (paramFloat4 * paramFloat4));
  }

  public void loadScale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    loadIdentity();
    this.mMat[0] = paramFloat1;
    this.mMat[5] = paramFloat2;
    this.mMat[10] = paramFloat3;
  }

  public void loadTranslate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    loadIdentity();
    this.mMat[12] = paramFloat1;
    this.mMat[13] = paramFloat2;
    this.mMat[14] = paramFloat3;
  }

  public void multiply(Matrix4f paramMatrix4f)
  {
    Matrix4f localMatrix4f = new Matrix4f();
    localMatrix4f.loadMultiply(this, paramMatrix4f);
    load(localMatrix4f);
  }

  public void rotate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Matrix4f localMatrix4f = new Matrix4f();
    localMatrix4f.loadRotate(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    multiply(localMatrix4f);
  }

  public void scale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Matrix4f localMatrix4f = new Matrix4f();
    localMatrix4f.loadScale(paramFloat1, paramFloat2, paramFloat3);
    multiply(localMatrix4f);
  }

  public void set(int paramInt1, int paramInt2, float paramFloat)
  {
    this.mMat[(paramInt2 + paramInt1 * 4)] = paramFloat;
  }

  public void translate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Matrix4f localMatrix4f = new Matrix4f();
    localMatrix4f.loadTranslate(paramFloat1, paramFloat2, paramFloat3);
    multiply(localMatrix4f);
  }

  public void transpose()
  {
    for (int i = 0; i < 3; i++)
      for (int j = i + 1; j < 4; j++)
      {
        float f = this.mMat[(j + i * 4)];
        this.mMat[(j + i * 4)] = this.mMat[(i + j * 4)];
        this.mMat[(i + j * 4)] = f;
      }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.Matrix4f
 * JD-Core Version:    0.6.2
 */