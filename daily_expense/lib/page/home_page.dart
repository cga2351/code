import 'dart:convert';
import 'dart:io';

import 'package:dailyexpense/bloc/home_bloc.dart';
import 'package:dailyexpense/page/dialog/edit_expense_item_dialog.dart';
import 'package:dailyexpense/page/home_tabs/tab_daily_expense.dart';
import 'package:dailyexpense/page/home_tabs/tab_page1.dart';
import 'package:dailyexpense/page/home_tabs/tab_page2.dart';
import 'package:excel/excel.dart';
import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

class HomePage extends StatefulWidget {
  HomePage({Key? key, this.title}) : super(key: key);
  final String? title;

  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> with SingleTickerProviderStateMixin {
  BuildContext? _buildContext;
  HomeBloc _homeViewBloc = HomeBloc(HomeStateNormal(0, 0));

  List bottomTabStrings = ["DailyExpense", "Feature1", "Feature2"];
  PageView? bottomPageView;
  PageController pageController = PageController(initialPage: 0);
  int currentBottomPageIndex = 0;
  FloatingActionButton? fabAddExpense;


  GlobalKey<FormState> addExpenseTypeKey = GlobalKey<FormState>();
  bool autoValidateAddExpenseType = false;

  @override
  void initState() {
    print("_MyHomePageState.initState() entry");
  }

  @override
  Widget build(BuildContext context) {
    _buildContext = context;
    _homeViewBloc = BlocProvider.of<HomeBloc>(context);

    return _buildHomeView(HomeStateNormal(0, 0));
  }

  void onFabAddExpense() {
    print("onFabAddExpense() entry");
//    testExcelReadWrite();
//    testShowDialog();
    EditExpenseItemDialog().show(_buildContext!);
  }

  void onBottomNavigationItemClicked(int index) {
    print("onBottomNavigationItemClicked() entry");
    _homeViewBloc.add(HomeEventSwitchTab(index, currentBottomPageIndex));
    currentBottomPageIndex = index;
    pageController.animateToPage(index, duration: Duration(milliseconds: 500), curve: Curves.ease);
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
        dailyExpenseIndex = 0;
        print("print allMatches() read new day of $lineContent");
        excel.updateCell(testImportSheet, CellIndex.indexByColumnRow(columnIndex: dailyExpenseIndex + 1, rowIndex: sheetCurRow), lineContent);
        sheetCurRow++;
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
          RegExp regExpExpenseItem = RegExp(r"[\D]+[\d\+\s]+");
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
    List<int>? encodeData = excel.encode();
    if (null != encodeData) {
      File(file)..createSync(recursive: true)
        ..writeAsBytesSync(encodeData);
    } else {
      print("testExcelReadWrite(), encode excel failed");
    }

  }

  void testShowDialog() {
    autoValidateAddExpenseType = false;
    showDialog(
        context: _buildContext!,
        builder: (dialogBuildContext) {
          return AlertDialog(
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
                        if (null == value || value.isEmpty) {
                          return "expense type name can't be empty";
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
              TextButton(child: Text("Cancel"), onPressed: onCancelAddExpenseType,),
              TextButton(child: Text("Add"), onPressed: onAddExpenseType,),
            ],
          );
        },
//         child: AlertDialog(
//           title: Text("Add Expense Type"),
//           content:Container(
//             width: 1000,
//             height: 100,
//             child: Form(
//               key: addExpenseTypeKey,
//               autovalidate: autoValidateAddExpenseType,
//               child: Column(
//                 mainAxisAlignment: MainAxisAlignment.spaceEvenly,
//                 children: <Widget>[
//                   TextFormField(
//                     decoration: InputDecoration(
//                       labelText: "expense type",
//                       hintText: "some common expense name",
// //                    helperText: "helper text 1",
// //                        icon: const Icon(Icons.person),
//                     ),
//                     validator: (value) {
//                       print("validator1() entry");
//                       if (value.isEmpty) {
//                         return "expense type name can't  be empty";
//                       } else {
//                         return null;
//                       }
//                     },
//                   ),
//
// //                TextFormField(
// //                  decoration: InputDecoration(
// //                    labelText: "labe text 2",
// //                    hintText: "hint text 2",
// //                    helperText: "helper text 2",
// ////                        icon: const Icon(Icons.person),
// //                  ),
// //                  validator: (value) {
// //                    print("validator2() entry");
// //                    if (value.isEmpty) {
// //                      return "error 2";
// //                    } else {
// //                      return null;
// //                    }
// //                  },
// //                ),
//
//                 ],
//               ),
//             ),
//           ),
//           actions: <Widget>[
//             TextButton(child: Text("Cancel"), onPressed: onCancelAddExpenseType,),
//             TextButton(child: Text("Add"), onPressed: onAddExpenseType,),
//           ],
//         )
    );
  }

  void onAddExpenseType() {
    bool? validate = addExpenseTypeKey.currentState?.validate();
    if (null != validate && validate) {
      print("all input ok");
    } else {
      print("not all input ok");
      autoValidateAddExpenseType = true;
    }
  }

  void onCancelAddExpenseType() {
    Navigator.pop(_buildContext!, true);
  }

  Widget _buildHomeView(HomeState state) {
    String title = null == widget.title ? "" : widget.title!;

    return Scaffold(
      resizeToAvoidBottomInset: false,
      appBar: AppBar(
        title: Text(title),
      ),

      // PageView
      body: PageView(
        children: <Widget>[
          TabDailyExpenseView(),
          TabPage1View(),
          TabPage2View(),
        ],
        controller: pageController,
        onPageChanged: (index) {
          _homeViewBloc.add(HomeEventSwitchTab(index, currentBottomPageIndex));
          currentBottomPageIndex = index;
          // setState(() {
          //   currentBottomPageIndex = index;
          // });
        },
      ),

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
      bottomNavigationBar: BlocBuilder<HomeBloc, HomeState>(
        builder: (context, state) {
          print("bottomNavigationBar builder entry");
          return BottomNavigationBar(
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
          );
        },
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
}