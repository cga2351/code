
import 'dart:convert';
import 'dart:io';
import 'dart:isolate';

import 'package:english_words/english_words.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:permission_handler/permission_handler.dart';
import 'package:firstflutterapp/TestJsonSerializable.dart';
import 'LakeDemoUI.dart';

class Todo {
  final String who;
  final String what;

  const Todo(this.who, this.what);
}



typedef CompareFun = bool Function(int, int);
class TypedefClass {
  CompareFun compare;
  TypedefClass(this.compare);
}

class CallableClass {
  String call(String param1, int param2) {
    print("CallableClass.call(), entry");
    return param1 + param2.toString();
  }
}

class TestJsonEntity1 {
  int x;
  int y;
  int z;
  TestJsonEntity2 testJsonEntity2;
  List<TestJsonEntity2> testJsonEntity2s;

  TestJsonEntity1(this.x, this.y);

  Map toJson() {
    Map map = Map();
    map["testJsonEntity2"] = testJsonEntity2;
    map["x"] = x;
    map["y"] = y;
    map["z"] = z;
    map["testJsonEntity2s"] = testJsonEntity2s;
    return map;
  }
}

class TestJsonEntity2 {
  String param1;
  int param2;
  double param3;
  double param4;

  TestJsonEntity2(this.param1, this.param2, this.param3);

  Map toJson() {
    Map map = Map();
    map["param1"] = param1;
    map["param2"] = param2;
    map["param3"] = param3;
    map["param4"] = param4;
    return map;
  }
}

Future logInWithAsync(String userName, String password) {
  return Future<String>(() {
    print("log in process");
    if (userName == "cga" && password == "123") {
      return "success";
    } else {
      return "password error";
    }
  });
}

class ThreadParams {
  SendPort sendPort;
  String param1;
  int param2;
}
Future logInWithFuture(String userName, String password) {
  return Future<String>(() {
    print("logInWithFuture");
    if (userName == "cga" && password == "123") {
      return "success";
    } else {
      return "password error";
    }
  });
}

T fun<T>(T param1) {
  T obj = null;

  return param1;
}

class Base3<T extends Base2> {
  void fun() { print("Base3.fun(), T = ${T.toString()}"); }
}

class Child2 extends Base2 { void funChild2() {print("funChild2()");}}
class Child3 extends Base2 { void funChild3() {print("funChild3()");}}
class Base2 { void funBase() {print("funBase()");}}
void fun1(List<Base2> param) {
  Base2 obj = param[0];
  if (obj is Child2) {
    obj.funChild2();
  } else if (obj is Child3) {
    obj.funChild3();
  } else {
    obj.funBase();
  }
}

class Base1 {
  int x;
  int y;

  Base1(this.x, this.y);
}
class Child1 extends Base1 {
  int z;
  Child1(int x, int y, int z) : this.z = z, super(x, y);
  void fun1() {
    print("x = $x, y = $y,  z = $z");
  }
}

mixin A{
  fun1() {
    print("A");
  }
}
mixin B {
  fun1(){
    print("B");
  }
}
mixin C {
  fun1() => print("C");
}
class P {
  fun1() => print("P");
}
//class P {
//  fun1() => print("P");
//}
//class AB extends P with A, B {}
//class BA extends P with B, A {}
class AB extends P with A, B {}
class BA extends P with B, A {}
abstract class TestMixin {
  factory TestMixin._() => null;

  void func1() {

  }
}

enum Color {red, green, blue}

class TestNoSuchMethodBase {
  void func1() {
    print("TestNoSuchMethod.func1(), entry");
  }

  void func2(String param1, [String param2, String param3]) {
    print("TestNoSuchMethod.func1(), entry");
  }

}
class TestNoSuchMethodChild implements TestNoSuchMethodBase {

  @override
  dynamic noSuchMethod(Invocation invocation) {
    print("TestNoSuchMethodChild.noSuchMethod(), entry, " +
        ", invocation = ${invocation.memberName}, " +
        ", namedArguments = ${invocation.namedArguments}" +
        ", positionalArguments = ${invocation.positionalArguments}" +
        ", typeArguments = ${invocation.typeArguments}"
    );
  }

  @override
  void func1() {
    print("TestNoSuchMethodChild.func1(), entry");
  }
}

class BaseClass {
  final String _name = "aa";

  String get name {
    print("BaseClass.name getter(), entry");
  }

  set name(String value) {
    print("BaseClass.name setter(), entry");
  }

  void fun1() {
    print("BaseClass.fun1(), entry");
  }
  void fun2(){
    print("BaseClass.fun2(), entry");
  }
}

class ChildClass implements BaseClass {

  @override
  String _name;

  @override
  String get name {
    print("ChildClass.name getter(), entry");
  }

  @override
  set name(String value) {
    print("ChildClass.name setter(), entry");
  }

  @override
  void fun1() {
    print("ChildClass.fun1(), entry");
  }

  @override
  void fun2() {
    print("ChildClass.fun2(), entry");
  }

}


abstract class AbstractClass {
  void fun1() {
    print("AbstractClass.fun1(), entry");
  }
  void fun2();
}

class ConcreteClass extends AbstractClass {

//  @override
//  void fun1() {
//    print("ConcreteClass.fun1(), entry");
//  }

  @override
  void fun2() {
    print("ConcreteClass.fun2(), entry");
  }
}

class FactoryConstructorClass {
  String _name;
  String _mem;

  static final Map<String, FactoryConstructorClass> _cache = Map<String, FactoryConstructorClass>();

  factory FactoryConstructorClass(String name) {
    if (_cache.containsKey(name)) {
      return _cache[name];
    } else {
      FactoryConstructorClass factoryConstructorClass = FactoryConstructorClass._internal(name);
      _cache[name] = factoryConstructorClass;
      return factoryConstructorClass;
    }
  }

  FactoryConstructorClass._internal(this._name);

  void func() => print("func(), entry, name=$_name");

}

class Point2 {
  final num x;
  final num y;
  final num distanceFromOrigin;

  Point2(x, y): x = x, y = y, this.distanceFromOrigin = x + y;
}

class Person {
  String name;

//  Person();
  Person.fromJson(String jsonData) {
    print("Person's fromJson() entry");
  }
}

class Employee extends Person {
  Employee.fromJson(String jsonData) : super.fromJson(jsonData) {
    print("Employee's fromJson() entry");
  }

  static int staticFunc() {
    return 1;
  }
}

class Point {
  int a;
  int b;
  int c = 0;
  static int d = 0;
  static int e;
}

class Candidate {
  int yearExperience;
  String sex;
  String name;

  Candidate(this.yearExperience, this.sex, this.name);
  Candidate.constructor1() {
    sex = "male";
    yearExperience = 1;
    name = "constructor1";
  }
  Candidate.constructor2() {
    sex = "male";
    yearExperience = 2;
    name = "constructor2";
  }

  void interview() => print("$name's interview() entry");

}

abstract class MyAbstractClass {

}

class MyClass {
  int data;
  MyClass(this.data);
}



class TestAAA {
  int a;
  TestAAA(this.a);
  TestAAA.cons1(this.a);

  static void staticFun(int a) {

  }
}

voidFunc(){}

Function makeAdder(num addBy) => (num i) => addBy + i;

void optionalParamFunc1(bool param1, bool param2) {
  print("optionalParamFunc1(), entry, param1=$param1, param2=$param2");
}
void optionalParamFunc2(int param1, String param2, [bool param3, bool param4]) {
  print("optionalParamFunc2(), entry, param1=$param1, param2=$param2, param3=$param3, param4=$param4");
}
void optionalParamFunc3(int param1, String param2, {bool param3, bool param4}) {
  print("optionalParamFunc3(), entry, param1=$param1, param2=$param2, param3=$param3, param4=$param4");
}
void optionalParamFunc4(int param1, String param2, {bool param3, @required bool param4}) {
  print("optionalParamFunc4(), entry, param1=$param1, param2=$param2, param3=$param3, param4=$param4");
}

void optionalParamFunc5({
  List<int> param1 = const [1, 2, 3],
  Map<int, String> param2 = const {
    1: "aaa",
    2: "bbb"
  }}) {
  print("optionalParamFunc5(), entry, param1=$param1, param2=$param2");
}



@Todo('seth', 'make this do something')
void doSomething() {
  print('do something');
}

bool compareFun(int a, int b) {
  return a > b;
}

void testAsyncFeature() {
  withFuture();
  withAsync();

  requestPermission();

  listFile("/sdcard/mqms/temp");

  // write file
  File writeFile = File("/sdcard/mqms/tmp/xxWriteFile.txt");
  testWriteFile(writeFile);

  // read file
  File readFile = File("/sdcard/mqms/tmp/xxReadFile.txt");
  testReadFile(readFile);

  // multi thread
  ThreadParams threadParams = ThreadParams();
  ReceivePort receivePort = ReceivePort();
  threadParams.sendPort = receivePort.sendPort;
  threadParams.param1 = "abc";
  threadParams.param2 = 300;
  print("receivePort.sendPort=${receivePort.sendPort.hashCode}, threadParams=${threadParams.hashCode}");
  Isolate.spawn(computation, threadParams);
  receivePort.listen((data) {
    print("isolater return data=$data");
  });
}

computation(ThreadParams threadParams) {
  print("call sendPort.sendPort, receiver=${threadParams.hashCode}");
  print("call sendPort.sendPort, sendPort=${threadParams.sendPort.hashCode}");
//  print("call sendPort.sendPort, sendPort=${threadParams.receivePort.sendPort.hashCode}");
  print("computation(), receiver.param1=${threadParams.param1}, receiver.param2=${threadParams.param2}");
  threadParams.sendPort.send("xxxx");
  threadParams.sendPort.send("yyyy");
//  threadParams.receivePort.sendPort.send("xxxx");
//  threadParams.receivePort.sendPort.send("yyyy");
}

void testReadFile(File testFile) async {
  if (await testFile.exists()) {
    print("before readFile()");
    readFile(testFile);
    print("after readFile()");
  } else {
    print("testReadFile(), file not exist, path:${testFile.path}");
  }
}

void readFile(File file) async {
  print("readFile(), entry");
  Stream<List<int>> intStream = file.openRead();

  var stringStream = intStream.transform(utf8.decoder);
  // use await for, use intStream.transform
  try {
    print("readFile(), 1");
    await for (String data in stringStream) {
      print("readFile(), use await for, intStream.transform, data=$data");
    }
    print("readFile(), 2");
  } catch (e) {
    print("e=$e");
  }
//    // use listen, use intStream.transform
//    print("readFile(), 1");
//    stringStream.listen((data) {
//      print("readFile(), use listen, use intStream.transform, data=$data");
//    }, onDone: () {
//      print("onDone(), entry");
//    }, onError: (e) {
//      print("onError(), e=$e");
//    });
//    print("readFile(), 2");


//    // use await for, use utf8.decode
//    await for (List<int> data in intStream) {
//      print("readFile(), use await for, use utf8.decode, data=${utf8.decode(data)}");
//    }
//    // use listen, use utf8.decode
//    intStream.listen((data) {
//      print("readFile(), use listen, use utf8.decode, data=${utf8.decode(data)}");
//    });
}

void testWriteFile(File testFile) async {
  if (!await testFile.exists()) {
    print("testWriteFile(), file not exist, create file");
    await testFile.create(recursive: true);
  }
  writeFileString(testFile);
}


void writeFileString(File file) {
  IOSink fileSink = file.openWrite(mode: FileMode.write);

  // write string, invoke the object's toString() to convert to string
  fileSink.write("xxxx");
  fileSink.write([66, 67]);
  fileSink.write({77, 78});
  fileSink.write(Base1(1, 2));

  // write byte
  fileSink.add([0x41, 0x42]);
  fileSink.add([0x0d, 0x0a]);

  // write string, invoke the object's toString() to convert to string
  fileSink.write("yyyy");
  fileSink.write([88, 89]);
  fileSink.write({99, 90});
  fileSink.write(Base1(1, 2));

  // write byte
  fileSink.add([0x41, 0x42]);
  fileSink.add([0x0d, 0x0a]);

  fileSink.close();
}

void requestPermission() async {
  print("requestPermission(), entry");
  Map<PermissionGroup, PermissionStatus> permissionStatus =
  await PermissionHandler().requestPermissions([
    PermissionGroup.camera,
    PermissionGroup.storage,
  ]);

  permissionStatus.forEach((permission, status) {
    print("permission.value = ${permission.toString()}, status.value = ${status.toString()}");
  });
}

void listFile(String searchPath) {
  print("listFile(), entry");

  FileSystemEntity.isDirectory(searchPath).then((isDir) {
    if (isDir) {
      final startingDir = Directory(searchPath);
      startingDir
//            .list(recursive: true, followLinks: true)
          .list()
          .listen((entity) {
        if (entity is File) {
          print("listFile(), is file:${entity.path}");
        } else {
          print("listFile(), is directory:${entity.path}");
        }
      });
    } else {
      print("listFile(), $searchPath is file");
    }
  });
}
void withAsync() async {
  print("before logInWithAsync()");
  var result = await logInWithAsync("cga1", "123");
  print("logInWithAsync result = $result");
  print("after logInWithAsync()");
}

void withFuture() {
  print("before logInWithFuture()");
  logInWithFuture("cga1", "123").then((result) {
    print("log in result1 = $result, result type = ${result.runtimeType}");
    return 111;
  }).then((result) {
    print("log in result2 = $result, result type = ${result.runtimeType}");
    return 111.111;
  }).then((result) {
    print("log in result3 = $result, result type = ${result.runtimeType}");
    return "then3 result";
  });
  print("after logInWithFuture()");
}

void testDart(BuildContext buildContext) async {
  var var1 = "aaa";
  var var2 = "bbb";
  int var3 = 20;
  print("MyApp.build(), entry, var1 = $var1, var2 = $var2, express=${var1 + "," + var2 + "," + var3.toString()}, var3 = $var3");

  var intList = new List();
  for (int i = 0; i < 10; i++) {
    intList.add(i);
  }

  var dynamicList = new List<dynamic>();
  var _dynamicList = <dynamic>[];

  for (int i = 10; i < 20; i++) {
    dynamicList.add(i);
    if (i % 2 == 0) {
      _dynamicList.add(i);
    } else {
      _dynamicList.add("odd");
    }
  }

  print("intList=$intList, dynamicList=$dynamicList, _dynamicList=$_dynamicList");

  dynamic var4;
  print("var4=$var4");

  var4 = 10;
  print("var4=$var4");

  var4 = "abc";
  print("var4=$var4");

  var4 = 10;
  print("var4=$var4");


  final finalVar = var4;
  const constVar = "constVar";

  print("finalVar=$finalVar");
  print("constVar=$constVar");


  double doubleVar = double.parse("10.1");
  int intVar = int.parse("10");
  print("doubleVar = $doubleVar, intVar = $intVar");

  String a = "aaa";
  String b = "aaa";
  String c = "aaaaaa";
  print("(a+b) == c = ${(a+b) == c}");

  Object object1 = new Object();
  Object object2 = object1;
  print("object1 == object2 = ${object1 == object2}");

  String multiLineString = """
    this is 
    multi line 
    String
    """;
  print("multiLineString=$multiLineString");

  String rawString = r"this is raw string \\\\ isn't special";
  print("rawString = $rawString");

  // const 类型数据
  const aConstNum = 0;
  const aConstBool = true;
  const aConstString = 'a constant string';

  var constantList = const [1, 2, 3];
  constantList = [2, 3, 4];
  constantList[1] = 5; // 取消注释会引起错误。
  print("constList = $constantList");

  var listList = ["abc", "111", '***'];
  var setSet = {"111", "222", 'ccc'};
  var mapMap = {};

  print("listList.runtimeType = ${listList.runtimeType}");
  print("setSet.runtimeType = ${setSet.runtimeType}");
  print("mapMap.runtimeType = ${mapMap.runtimeType}");

  var symbolVar1 = 10;
  var symbolVar2 = "abc";
  print("symbolVar1 = ${#symbolVar1}, symbolVar2 = ${symbolVar2}");

  optionalParamFunc1(true, false);

  optionalParamFunc2(1, "bb", true, false);
  optionalParamFunc2(1, "bb", true);
  optionalParamFunc2(1, "bb");

  optionalParamFunc3(1, "bb");
  optionalParamFunc3(1, "bb", param3: true, param4: false);
  optionalParamFunc3(1, "bb", param3: true);
  optionalParamFunc3(1, "bb", param4: false);

  optionalParamFunc4(1, "bb", param4: true);

  optionalParamFunc5();
  optionalParamFunc5(param1: [3, 4, 5], param2: {3:"333", 4:"444"});

  var list1 = [10, 20, 30];
  list1.forEach((param) => print("param=$param"));

  Function add2 = makeAdder(2);
  var add4 = makeAdder(4);

  print("add2() return ${add2(10)}");
  print("add4() return ${add4(10)}");

  print("voidFunc() return ${voidFunc()}");

  var divide1 = 5;
  int divide2 = 5;
  double divide3 = 5;
  num divide4 = 5;
  int divider = 2;

  print("divide1/2 = ${divide1 / divider}, divide2 / 2 = ${divide2 / divider}, divide3 / 2 = ${divide3 / divider}, divide4 / 2 = ${divide4 / divider}, ");
  print("divide1~/2 = ${divide1 ~/ divider}, divide2 ~/ 2 = ${divide2 ~/ divider}, divide3 ~/ 2 = ${divide3 ~/ divider}, divide4 ~/ 2 = ${divide4 ~/ divider}, ");
  print("divide1%2 = ${divide1 % divider}, divide2 % 2 = ${divide2 % divider}, divide3 % 2 = ${divide3 % divider}, divide4 % 2 = ${divide4 % divider}, ");

  num oper1 = 5;
  num oper2 = 2;
  oper1 ~/= oper2;
  print("oper1 = ${oper1}");

  oper1 = 5;
  oper2 = 2;
  oper1 /= oper2;
  print("oper1 = ${oper1}");

  var oper3 = "1";
  var oper4 = "2";
  var oper5 = "12";
  print("((oper3 + oper4) == oper5) = ${(oper3 + oper4) == oper5}");


  num oper6 = 5;
  num oper7 = 2;
  num oper8;
  oper8 = (oper6 / oper7) as num;
  Type type = (oper6 / oper7).runtimeType;
  print("type = $type, oper8 = $oper8");

  int intVar1 = 1;
  double doubleVar2 = 2.0;
  num numVar3 = 3;
//    numVar3 = intVar1;
//    numVar3 = doubleVar2;
//    print("numVar3 = $numVar3");

  intVar1 = numVar3;
//    intVar1 = doubleVar2;
  print("intVar1 = $intVar1");

  num oper9 = 9;
  oper9 ??= 5;
  print("oper9 = $oper9");

  MyClass obj1 = MyClass(1);
  MyClass obj2;

  print("obj1.data = ${obj1?.data}, obj2.data = ${obj2?.data}");

  List<Candidate> candidates = [
    Candidate(3, "female", "tracy"),
    Candidate(6, "male", "jack"),
    Candidate(1, "male", "tom"),
    Candidate(7, "male", "john"),
    Candidate(8, "female", "lucy"),
    Candidate.constructor1(),
    Candidate.constructor2(),
  ];

  candidates
      .where((candidate) => candidate.sex == "male" && candidate.yearExperience < 5)
//        .where((candidate) => candidate.yearExperience < 5)
      .forEach((candidate) => candidate.interview());

  Point point = Point();

  print("point.a = ${point.a}, point.b = ${point.b}, point.c = ${point.c}, point.d = ${Point.d}, point.e = ${Point.e}");

  Employee employee = Employee.fromJson("aaa");

  Point2 point2 = Point2(2, 4);
  print("point2.dis = ${point2.distanceFromOrigin}");

  FactoryConstructorClass factoryConstructorClass1 = new FactoryConstructorClass("aaa");
  FactoryConstructorClass factoryConstructorClass2 = new FactoryConstructorClass("bbb");
  FactoryConstructorClass factoryConstructorClass3 = new FactoryConstructorClass("aaa");
  print("factoryConstructorClass1=${factoryConstructorClass1.hashCode.toRadixString(16)}");
  print("factoryConstructorClass2=${factoryConstructorClass2.hashCode.toRadixString(16)}");
  print("factoryConstructorClass3=${factoryConstructorClass3.hashCode.toRadixString(16)}");
  factoryConstructorClass1.func();
  factoryConstructorClass2.func();
  factoryConstructorClass3.func();

  ConcreteClass concreteClass = ConcreteClass();
  concreteClass.fun1();
  concreteClass.fun2();
//
//    AbstractClass abstractClass = AbstractClass();
//    abstractClass.fun1();
//    abstractClass.fun2();

  BaseClass baseClass = BaseClass();
  baseClass.name = "aa";
  baseClass.name;
  baseClass.fun1();
  baseClass.fun2();

  ChildClass childClass = ChildClass();
  childClass.name = "bb";
  childClass.name;
  childClass.fun1();
  childClass.fun2();

//    TestNoSuchMethodChild testNoSuchMethodChild = TestNoSuchMethodChild();
  dynamic testNoSuchMethodChild = TestNoSuchMethodChild();
  testNoSuchMethodChild.func1();
  testNoSuchMethodChild.func2("aa", "bb", "cc");
  testNoSuchMethodChild.xxx(100, "xxx");
  Color color = Color.red;
  color.index;
  List<Color> allColors = Color.values;
  allColors.forEach((color) => {print("index of ${color.index}:${color}")});

//    TestMixin testMixin = TestMixin._();
//    print("testMixin=$testMixin");

  AB ab = AB();

  ab.fun1();
  print("ab 1 ${ab is P}");
  print("ab 2 ${ab is A}");
  print("ab 3 ${ab is B}");

  BA ba = BA();
  ba.fun1();
  print("ba 4 ${ba is A}");
  print("ba 5 ${ba is B}");
  print("ba 6 ${ba is P}");

//    A objA = A();
//    objA.fun1();
//    B objB = B();
//    objB.fun1();

  Child1 child1 = Child1(5, 7, 9);
  child1.fun1();

  dynamic variant1 = 12;
  variant1 = "string";

  var genList = <String>["aaa", "bbb", "ccc"];
  var genSet = <String>{"aaa", "bbb", "ccc", "ccc"};
  var genMap = <String, String> {
    "aaa": "111",
    "bbb": "222",
    "ccc": "333",
  };
  print("genList type=${genList.runtimeType}, genSet type = ${genSet.runtimeType}, genMap type = ${genMap.runtimeType}");
  genSet.add("xxx");
  genSet.add("xxx");
  print("genSet = ${genSet.toString()}");
  print("genList = ${genList.toString()}");

  var genSet1 = Set<String>.from(genSet);

  Base2 base2 = Base2();
  Child2 child2 = Child2();
  Child3 child3 = Child3();
  List<Base2> base2s = List();
  List<Child2> child2s = List();
  List<Child3> child3s = List();
  base2s.add(base2);
  child2s.add(child2);
  child3s.add(child3);

  fun1(base2s);
  fun1(child2s);
  fun1(child3s);

  Base3 base31 = Base3<Base2>();
  base31.fun();

  Base3 base32 = Base3<Child2>();
  base32.fun();

  Base3 base33 = Base3<Child3>();
  base33.fun();

  fun(base2);
  fun(Base1(0, 0));

  testAsyncFeature();

  //
//    File file = File("/sdcard/mqms/performance.json");
  File file = File("/sdcard/mqms/tmp/script.json");
//    var jsonString = '[{"score": 40},{"score": 80, "key1": "value1", "key2": "value2", "key3":null}]';
  var jsonString = '{"score": 80, "key1": "value1", "key2": "value2", "key3":null}';
//    var jsonString = '{"score": 80, "key2": "value2", "key3":null}';
//    jsonString = file.readAsStringSync(encoding: utf8);
  print("jsonString 1=$jsonString");
  var mapObj = jsonDecode(jsonString);
  print("jsonDecode to mapObj=$mapObj");
  var score = Score.fromJson(jsonString);
  print("jsonDecode to Score.fromJson=$score");

  TestJsonEntity1 testJsonEntity1 = TestJsonEntity1(22, 33);
  testJsonEntity1.testJsonEntity2 = TestJsonEntity2("xxx", 555, 666.666);
  testJsonEntity1.testJsonEntity2s = List<TestJsonEntity2>();
  testJsonEntity1.testJsonEntity2s.add(TestJsonEntity2("aaa", 111, 111.111));
  testJsonEntity1.testJsonEntity2s.add(TestJsonEntity2("bbb", 222, 222.222));
  testJsonEntity1.testJsonEntity2s.add(TestJsonEntity2("ccc", 333, 333.333));
  jsonString = jsonEncode(testJsonEntity1);
  print("jsonEncode to string 1 =$jsonString");

  jsonString = jsonEncode(testJsonEntity1.testJsonEntity2s);
  print("jsonEncode to string 2 =$jsonString");

  var testJsonEntity2 = jsonDecode(jsonString);
  print("jsonDecode to object 2 =$testJsonEntity2");

  // test with json_serializable
  TestJsonSerializableEntity2 testJsonSerializableEntity2 = TestJsonSerializableEntity2(
      "TestJsonSerializableEntity2", 1000, 1000.1111, null);
  TestJsonSerializableEntity1 testJsonSerializableEntity1 = TestJsonSerializableEntity1(
      "testJsonSerializableEntity1", 1000, 1000.1111, null, testJsonSerializableEntity2);
  List<TestJsonSerializableEntity1> testJsonSerializableEntity1s = List();
  testJsonSerializableEntity1s.add(testJsonSerializableEntity1);
  testJsonSerializableEntity1s.add(testJsonSerializableEntity1);
  // to json
  String testJsonSerializableEntity1String = jsonEncode(testJsonSerializableEntity1);
  print("testJsonSerializableEntity1String=$testJsonSerializableEntity1String");
  String testJsonSerializableEntity1sString = jsonEncode(testJsonSerializableEntity1s);
  print("testJsonSerializableEntity1sString=$testJsonSerializableEntity1sString");
  // from json
  TestJsonSerializableEntity1 covertBackObj1 = TestJsonSerializableEntity1.fromJson(jsonDecode(testJsonSerializableEntity1String));
  print("covertBackObj1=$covertBackObj1");
  var obj11 = jsonDecode(testJsonSerializableEntity1String);
  print("obj11.runtimeType=${obj11.runtimeType}");
  var obj22 = jsonDecode(testJsonSerializableEntity1sString);
  print("obj22.runtimeType=${obj22.runtimeType}");
//    TestJsonSerializableEntity1 covertBackObj2 = TestJsonSerializableEntity1.fromJson(jsonDecode(testJsonSerializableEntity1sString));
//    print("covertBackObj2=$covertBackObj2");

  // callable class
  CallableClass callableClass = CallableClass();
  String result = callableClass("param1", 222);
  print("callableClass() return = $result");

  TypedefClass typedefClass = TypedefClass(compareFun);
  print("typedefClass.compare() return = ${typedefClass.compare(3, 2)}");

  List<int> utf8Bytes = utf8.encode("123滑有abc");
  String utf8String = utf8.decode(utf8Bytes);
  print("utf8String=$utf8String");

  // use root bundle
  rootBundle.loadString("assets/string/abc.json").then((value) {
    print("use rootBundle jsonFile=$value");
  });
  DefaultAssetBundle.of(buildContext).loadString("assets/string/abc.json").then((value) {
    print("use DefaultAssetBundle jsonFile=$value");
  });
}