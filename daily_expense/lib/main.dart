import 'dart:convert';
import 'dart:io';

import 'package:dailyexpense/view/home_tabs/tab_page1.dart';
import 'package:dailyexpense/view/home_tabs/tab_page2.dart';
import 'package:dailyexpense/view/home_tabs/tab_daily_expense.dart';
import 'package:excel/excel.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:permission_handler/permission_handler.dart';

import 'view/add_expense_item.dart';


/*
早饭 午饭 晚饭	 水 电 气	油费 停车费 过路费  车保养	   日常用品	  日常消费	   零食、水果	 娱乐消费	 上网  医药费用  买衣服		 房租	房贷	车贷	装修	其他
									                         支出 备注	 支出 备注	  支出 备注	 支出 备注	   支出 备注	      支出 备注	支出 备注					                支出 备注

 */
void main() => runApp(MainApp());

class MainApp extends StatelessWidget {

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    requestPermissions();

    return MaterialApp(
      title: 'Daily Expense of MainApp',
      theme: ThemeData(
        // This is the theme of your application.
        //
        // Try running your application with "flutter run". You'll see the
        // application has a blue toolbar. Then, without quitting the app, try
        // changing the primarySwatch below to Colors.green and then invoke
        // "hot reload" (press "r" in the console where you ran "flutter run",
        // or simply save your changes to "hot reload" in a Flutter IDE).
        // Notice that the counter didn't reset back to zero; the application
        // is not restarted.
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(title: 'Daily Expense'),
    );
  }

  List<PermissionGroup> permissions = [
    PermissionGroup.storage,
  ];

  void requestPermissions() async {
    print("requestPermissions(), entry");
    bool checkAllGranted = await checkPermissions();
    if (!checkAllGranted) {
      PermissionHandler().requestPermissions(permissions).then((value) {
        Map<PermissionGroup, PermissionStatus> result = value;
        bool allGranted = true;
        result.forEach((permission, status) {
          if (status == PermissionStatus.denied) {
            print("requestPermissions(), permission of $permission denied");
            allGranted = false;
          }
        });
        print("requestPermissions(), allGranted=$allGranted");
      });
    }
  }

  Future<bool> checkPermissions() async {
    bool checkAllGranted = true;

    for (int i = 0; i < permissions.length; i++) {
      PermissionStatus permissionStatus = await PermissionHandler()
          .checkPermissionStatus(permissions[i]);
      print("checkPermissions(), permissionStatus=${permissionStatus.value}");
      if (permissionStatus == PermissionStatus.denied) {
        checkAllGranted = false;
        print("checkPermissions(), not all permissions granted");
      }
    }
    return checkAllGranted;
  }
}

class MyHomePage extends StatefulWidget {
  MyHomePage({Key key, this.title}) : super(key: key);

  // This widget is the home page of your application. It is stateful, meaning
  // that it has a State object (defined below) that contains fields that affect
  // how it looks.

  // This class is the configuration for the state. It holds the values (in this
  // case the title) provided by the parent (in this case the App widget) and
  // used by the build method of the State. Fields in a Widget subclass are
  // always marked "final".

  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
  Center center;
  Container container;
}

class _MyHomePageState extends State<MyHomePage> with SingleTickerProviderStateMixin {
  BuildContext buildContext;

  List bottomTabStrings = ["DailyExpense", "Feature1", "Feature2"];
  PageView bottomPageView;
  PageController pageController = PageController(initialPage: 0);
  int currentBottomPageIndex = 0;
  FloatingActionButton fabAddExpense;


  GlobalKey<FormState> addExpenseTypeKey = GlobalKey<FormState>();
  bool autoValidateAddExpenseType = false;


  @override
  void initState() {
    print("_MyHomePageState.initState() entry");

    bottomPageView = PageView(
      children: <Widget>[
        TabDailyExpenseView(),
        TabPage1View(),
        TabPage2View(),
      ],
      controller: pageController,
      onPageChanged: (index) {
        setState(() {
          currentBottomPageIndex = index;
        });
      },
    );

    fabAddExpense = FloatingActionButton(
      onPressed: onFabAddExpense,
      child: Icon(Icons.add),
    );
  }

  void onFabAddExpense() {
    print("onFabAddExpense() entry");
//    testExcelReadWrite();
//    testShowDialog();
    addExpenseItem(buildContext);
  }

  @override
  Widget build(BuildContext context) {
    buildContext = context;
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),

      // PageView
      body: bottomPageView,

      // Drawer
      drawer: Drawer(
        child: Container(
          child: Center(
            child: ListView(
              children: [
                ListTile(
                  leading: Icon(Icons.radio),
                  title: Text("drawer item1"),
                ),
                ListTile(
                  leading: Icon(Icons.radio),
                  title: Text("drawer item1"),
                )
              ],
            ),
          ),
        ),
      ),


      // BottomNavigationBar
      bottomNavigationBar: BottomNavigationBar(
//        items: [
//          BottomNavigationBarItem(
//            title: Text("index1"),
//            icon: Icon(Icons.phone)
//          ),
//          BottomNavigationBarItem(
//              title: Text("index2"),
//              icon: Icon(Icons.router)
//          ),
//          BottomNavigationBarItem(
//              title: Text("index3"),
//              icon: Icon(Icons.account_circle)
//          ),
//        ],
        items: bottomTabStrings.map((e) {
          return BottomNavigationBarItem(
              title: Text(e),
              icon: Icon(Icons.chat)
          );
        }).toList(),
        onTap: onBottomNavigationItemClicked,
        currentIndex: currentBottomPageIndex,
        selectedFontSize: 13,
        unselectedFontSize: 13,
      ),


      // BottomAppBar
//      bottomNavigationBar: BottomAppBar(
////        color: Colors.lightBlue,
//        shape: CircularNotchedRectangle(),
//        child: Row(
//          children: <Widget>[
//            IconButton(icon: Icon(Icons.account_circle), iconSize: 40),
////            SizedBox(), //中间位置空出
//            IconButton(icon: Icon(Icons.account_circle), iconSize: 40),
//          ],
//          mainAxisAlignment: MainAxisAlignment.spaceAround,
//        ),
//      ),

//      floatingActionButton: fabNew,
//      floatingActionButton: FloatingActionButton(
//        onPressed: null,
//        child: Icon(Icons.add),
//      ),

//       floatingActionButton: currentBottomPageIndex == 0 ? fabAddExpense : null,
//       floatingActionButtonLocation: FloatingActionButtonLocation.endFloat,
    );
  }

  void onBottomNavigationItemClicked(int index) {
    setState(() {
      currentBottomPageIndex = index;
      pageController.animateToPage(index, duration: Duration(milliseconds: 500), curve: Curves.ease);
    });
  }

  void testExcelReadWrite() {
    // read excel
//    var file = "/sdcard/yl/testFlutter/testReadExcel.xlsx";
//    var bytes = File(file).readAsBytesSync();
//    Excel excel = Excel.decodeBytes(bytes, update: true);
//    for (var table in excel.tables.keys) {
//      print("testExcelReadWrite(), table = ${table}");
//      print("testExcelReadWrite(), maxCols = ${excel.tables[table].maxCols}");
//      print("testExcelReadWrite(), maxRows = ${excel.tables[table].maxRows}");
//      for (var row in excel.tables[table].rows) {
//        print("testExcelReadWrite(), excel sheet of ${excel.tables[table].rows.indexOf(row)} rows = $row");
//      }
//    }


    // read from original file
    String originContent = File("/sdcard/yl/testFlutter/DailyExpenseNote.txt").readAsStringSync(encoding: utf8);
//    print("testExcelReadWrite(), originContent=$originContent");

    // write excel
    int sheetCurRow = 0;
    int dailyExpenseIndex = 0;
    Excel excel = Excel.createExcel();
    String testImportSheet = "testImportSheet";
    List<String> splitContents = LineSplitter().convert(originContent);

    // separate to every expense name and expense value
    splitContents.forEach((lineContent) {
      if (lineContent.contains(".")) {
        sheetCurRow++;
        dailyExpenseIndex = 0;
        print("print allMatches() read new day of $lineContent");
        excel.updateCell(testImportSheet, CellIndex.indexByColumnRow(columnIndex: dailyExpenseIndex + 1, rowIndex: sheetCurRow), lineContent);
      } else {
        // daily expense
        if (dailyExpenseIndex == 0) {
          // breakfast
          excel.updateCell(testImportSheet, CellIndex.indexByColumnRow(columnIndex: dailyExpenseIndex + 2, rowIndex: sheetCurRow), lineContent);
          dailyExpenseIndex++;
        } else if (dailyExpenseIndex == 1) {
          // launch
          excel.updateCell(testImportSheet, CellIndex.indexByColumnRow(columnIndex: dailyExpenseIndex + 2, rowIndex: sheetCurRow), lineContent);
          dailyExpenseIndex++;
        } else if (dailyExpenseIndex == 2) {
          // dinner
          excel.updateCell(testImportSheet, CellIndex.indexByColumnRow(columnIndex: dailyExpenseIndex + 2, rowIndex: sheetCurRow), lineContent);
          dailyExpenseIndex++;
        } else {
          // other expense
          RegExp regExpExpenseItem = RegExp(r"[\D]+[\d\+]+");
          regExpExpenseItem.allMatches(lineContent).forEach((match) {
            String expenseItem = lineContent.substring(match.start, match.end);
            int expenseValueIndex = expenseItem.indexOf(RegExp(r"\d"));
            String expenseName = expenseItem.substring(0, expenseValueIndex);
            String expenseValue = expenseItem.substring(expenseValueIndex);
            if (expenseName.trim().isEmpty) {
              expenseName = "空格";
            }
            print("allMatches() expenseName:$expenseName, expenseValue=$expenseValue");
            excel.updateCell(testImportSheet, CellIndex.indexByColumnRow(columnIndex: dailyExpenseIndex + 2, rowIndex: sheetCurRow), expenseName + expenseValue);
            dailyExpenseIndex++;
          });
        }
      }
    });

    // save to excel file
    var file = "/sdcard/yl/testFlutter/testImportExcel.xlsx";
    excel.setDefaultSheet(testImportSheet);
    excel.encode().then((value) {
      File(file)
        ..createSync(recursive: true)
        ..writeAsBytesSync(value);
    });
  }

  void testShowDialog() {
    autoValidateAddExpenseType = false;
    showDialog(
      context: buildContext,
      child: AlertDialog(
        title: Text("Add Expense Type"),
        content:Container(
          width: 1000,
          height: 100,
          child: Form(
            key: addExpenseTypeKey,
            autovalidate: autoValidateAddExpenseType,
            child: Column(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: <Widget>[
                TextFormField(
                  decoration: InputDecoration(
                    labelText: "expense type",
                    hintText: "some common expense name",
//                    helperText: "helper text 1",
//                        icon: const Icon(Icons.person),
                  ),
                  validator: (value) {
                    print("validator1() entry");
                    if (value.isEmpty) {
                      return "expense type name can't  be empty";
                    } else {
                      return null;
                    }
                  },
                ),

//                TextFormField(
//                  decoration: InputDecoration(
//                    labelText: "labe text 2",
//                    hintText: "hint text 2",
//                    helperText: "helper text 2",
////                        icon: const Icon(Icons.person),
//                  ),
//                  validator: (value) {
//                    print("validator2() entry");
//                    if (value.isEmpty) {
//                      return "error 2";
//                    } else {
//                      return null;
//                    }
//                  },
//                ),

              ],
            ),
          ),
        ),
        actions: <Widget>[
          FlatButton(child: Text("Cancel"), onPressed: onCancelAddExpenseType,),
          FlatButton(child: Text("Add"), onPressed: onAddExpenseType,),
        ],
      )
    );
  }

  void onAddExpenseType() {
    if (addExpenseTypeKey.currentState.validate()) {
      print("all input ok");
    } else {
      print("not all input ok");
      autoValidateAddExpenseType = true;
    }
  }

  void onCancelAddExpenseType() {
    Navigator.pop(buildContext, true);
  }
}



