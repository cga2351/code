import 'dart:collection';
import 'dart:convert';
import 'dart:io';

import 'package:dailyexpense/bloc/expense_list_bloc.dart';
import 'package:dailyexpense/bloc/expense_edit_mode_bloc.dart';
import 'package:dailyexpense/bloc/expense_edit_mode_info_bloc.dart';
import 'package:dailyexpense/bloc/expense_item_select_bloc.dart';
import 'package:dailyexpense/bloc/home_bloc.dart';
import 'package:dailyexpense/constants.dart';
import 'package:dailyexpense/customViews/classic_button.dart';
import 'package:dailyexpense/customViews/expense_list_item_widget.dart';
import 'package:dailyexpense/data_provider/cached_local_data.dart';
import 'package:dailyexpense/http/http_req_if.dart';
import 'package:dailyexpense/model/expense_item.dart';
import 'package:dailyexpense/page/common/prompt_dialog.dart';
import 'package:dailyexpense/page/dialog/add_expense_type_dialog.dart';
import 'package:dailyexpense/page/dialog/edit_expense_item_dialog.dart';
import 'package:dailyexpense/page/edit_expense_type_page.dart';
import 'package:dailyexpense/utils/id_utils.dart';
import 'package:dailyexpense/utils/local_data_storage.dart';
import 'package:dailyexpense/utils/sys_utils.dart';
import 'package:excel/excel.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:flutter/scheduler.dart';
import 'package:flutter/widgets.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:fluttertoast/fluttertoast.dart';

class AnimationTickerProvider implements TickerProvider {
  const AnimationTickerProvider();

  @override
  Ticker createTicker(TickerCallback onTick) => Ticker(onTick);
}

class TabDailyExpenseView extends StatefulWidget{
  @override
  State createState() {
    return TabDailyExpenseState();
  }
}

class TabDailyExpenseState extends State<TabDailyExpenseView> with TickerProviderStateMixin {
  // DailyExpenseListBloc dailyExpenseListBloc = DailyExpenseListBloc();

  AnimationController testOpacityAnimationController = AnimationController(duration: Duration(milliseconds: 2000), vsync: AnimationTickerProvider());
  AnimationController testPositionAnimationController = AnimationController(duration: Duration(milliseconds: 2000), vsync: AnimationTickerProvider());
  AnimationController testScaleAnimationController = AnimationController(duration: Duration(milliseconds: 2000), vsync: AnimationTickerProvider());

  Tween<double> testOpacityTween = Tween<double>();
  RelativeRectTween testPositionTween = RelativeRectTween();
  Tween<double> testScaleTween = Tween<double>();

  Animation<double> testOpacityAnimation = Tween<double>().animate(AnimationController(duration: Duration(milliseconds: 2000), vsync: AnimationTickerProvider()));
  Animation<RelativeRect> testPositionAnimation = RelativeRectTween().animate(AnimationController(duration: Duration(milliseconds: 2000), vsync: AnimationTickerProvider()));
  Animation<double>  testScaleAnimation = Tween<double>().animate(AnimationController(duration: Duration(milliseconds: 2000), vsync: AnimationTickerProvider()));

  List<ExpenseItem> editModeSelectedItem = [];
  ExpenseItem invalidExpenseItem = ExpenseItem(0, 0, "", "", 0, "");

  ExpenseEditModeBloc _expenseEditModeBloc = ExpenseEditModeBloc(ExpenseEditModeStateOff());

  int lastClickBackTimestamp = 0;
  int editModeFadeInOutDuration = 200;

  Future<bool> onWillPop() async {
    if (_expenseEditModeBloc.state is ExpenseEditModeStateOn) {
      _expenseEditModeBloc.add(ExpenseEditModeEventFadeOut());
      return false;
    } else {
      int curTimestamp = DateTime.now().millisecondsSinceEpoch;
      if (curTimestamp - lastClickBackTimestamp < 1000) {
        return true;
      } else {
        lastClickBackTimestamp = curTimestamp;
        Fluttertoast.showToast(msg: "click one more time to exit");
        return false;
      }
    }
  }

  @override
  void initState() {
    // editBarFadeController = AnimationController(
    //   duration: Duration(milliseconds: 500),
    //   vsync: this,
    // );
    //
    // Tween(begin: 10, end: 50).animate(editBarFadeController);
    // editBarFadeController.forward();

    testOpacityAnimationController = AnimationController(duration: Duration(milliseconds: 2000), vsync: this);
    testPositionAnimationController = AnimationController(duration: Duration(milliseconds: 2000), vsync: this);
    testScaleAnimationController = AnimationController(duration: Duration(milliseconds: 2000), vsync: this);

    testOpacityTween = Tween<double>(begin : 0.0, end : 1.0);
    testPositionTween = RelativeRectTween(
        begin: RelativeRect.fromSize(
            Rect.fromLTWH(0, 0, 30, 30), Size(30, 30)),
        end: RelativeRect.fromSize(
            Rect.fromLTWH(10, 10, 40, 40), Size(30, 30))
    );
    testScaleTween = Tween<double>(begin : 0.0, end : 1.0);

    testOpacityAnimation = testOpacityTween.animate(testOpacityAnimationController);
    testPositionAnimation = testPositionTween.animate(testPositionAnimationController);
    testScaleAnimation = testScaleTween.animate(testScaleAnimationController);
  }

  @override
  Widget build(BuildContext context) {
    return WillPopScope(
      onWillPop: onWillPop,
      child: BlocProvider<ExpenseEditModeBloc>(
        create: (buildContext) => _expenseEditModeBloc,
        child: BlocProvider<ExpenseItemSelectBloc>(
          create: (buildContext) => ExpenseItemSelectBloc(
              ExpenseItemSelectState(ExpenseItem(0, 0, "", "", 0, ""))),
          child: BlocProvider<ExpenseEditModeInfoBloc>(
            create: (buildContext) => ExpenseEditModeInfoBloc(
                ExpenseEditModeInfoState(0)),
            child: _buildExpenseItemInfo(context),
          ),
        ),
      ),
    );
  }

  Column _buildExpenseItemInfo(BuildContext context) {
    return Column(
      children: [
        Expanded(
          child: Scaffold(
            resizeToAvoidBottomInset: false,
            body: BlocBuilder<ExpenseEditModeBloc, ExpenseEditModeState>(
              builder: (buildContext, expenseEditModeState) {
                return Column(
                  children: [
                    _buildTopView(buildContext, expenseEditModeState),
                    _buildExpenseItemList(context, expenseEditModeState),
                  ],
                );
              },
            ),
            floatingActionButton: BlocBuilder<HomeBloc, HomeState>(
              builder: (context, state) {
                print("TabDailyExpenseState builder entry");
                print("4 context=$context");
                if (state is HomeStateNormal && state.newIndex == 0) {
                  return SizedBox(
                    // do not set height to make the size to wrap content.
                    // height: 180,
                    child: Column(
                      mainAxisSize: MainAxisSize.min,
                      children: [
                        // FloatingActionButton(
                        //   onPressed: () {
                        //     addType(context);
                        //   },
                        //   child: Icon(Icons.add),
                        // ),
                        // // SizedBox(height: 5),
                        // Text("type"),
                        // SizedBox(
                        //   height: 15,
                        // ),
                        FloatingActionButton(
                          onPressed: () {
                            addItem(context);
                          },
                          child: Icon(Icons.add),
                        ),
                        // SizedBox(height: 5),
                        // Text("item"),
                        SizedBox(
                          height: 10,
                        ),
                      ],
                    ),
                  );
                } else {
                  return SizedBox();
                }
              },
            ),
            floatingActionButtonLocation: FloatingActionButtonLocation.endFloat,
          ),
        ),

        // bottom tool bar
        Row(
          children: [
            SizedBox(width: 5),
            ClassicButton(
              width: 100,
              height: 40,
              text: "Edit Types",
              onTap: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(
                    builder: (context) {
                      return EditExpenseTypePage();
                    },
                  ),
                );
              },
            ),

            Expanded(child: SizedBox(height: 10,)),

            SizedBox(width: 5),
            ClassicButton(
              width: 100,
              height: 40,
              text: "Backup Record",
              onTap: () {
                LocalDataStorage.instance.backupExpenseRecord();
              },
            ),

            SizedBox(width: 5),
            ClassicButton(
              width: 100,
              height: 40,
              text: "ExportExcel",
              onTap: () {
                Fluttertoast.showToast(msg: "export to excel");
                _exportAllRecordToExcel();
              },
            ),

            SizedBox(width: 5),
          ],
        ),
        SizedBox(height: 5),

        // test button
        ..._buildTestButton(),
      ],
    );
  }

  List<Widget> _buildTestButton() {
    List<Widget> testViews = [];

    // debug mode show the test button
    if (kDebugMode) {
      testViews.add(Row(
          children: [
            SizedBox(
              width: 5,
            ),
            ClassicButton(
              width: 70,
              height: 40,
              text: "TestBtn1",
              onTap: () {
                testFunc(context);
              },
            ),

            ...buildTestAnimationWidgets(),
          ]
      ));
      testViews.add(SizedBox(height: 5));
    }

    return testViews;
  }

  Expanded _buildExpenseItemList(BuildContext context, ExpenseEditModeState expenseEditModeState) {
    print("_buildExpenseItemList(), entry, expenseEditModeState=$expenseEditModeState");
    return Expanded(
      child: Container(
        padding: EdgeInsets.fromLTRB(10, 5, 10, 10),
        child: BlocBuilder<ExpenseListBloc, ExpenseListState>(
          builder: (buildContext, expenseListState) {
            print("_buildExpenseItemList(), expenseListState is $expenseListState");
            if (expenseListState is ExpenseListStateInit) {
              Future.delayed(Duration(milliseconds: 1000)).then((value) {
                LocalDataStorage.instance.readAllExpenseRecordToCache();
                List<ExpenseItem> allExpenseItem =
                    LocalDataStorage.instance.getAllExpenseRecord();
                print("_buildExpenseItemList(), context 3=$context");
                BlocProvider.of<ExpenseListBloc>(context)
                    .add(ExpenseListEventUpdateList(allExpenseItem));
              });
              return Center(
                child: Text("Loading Daily Expense Record..."),
              );
            } else if (expenseListState is ExpenseListStateUpdateList) {
              List<ExpenseItem> allExpenseItem =
                  expenseListState.allExpenseItem;
              if (allExpenseItem.isEmpty) {
                return Center(
                  child: Text("no expense record"),
                );
              } else {
                // return BlocBuilder<ExpenseEditModeBloc, ExpenseEditModeState>(
                return BlocBuilder<ExpenseItemSelectBloc, ExpenseItemSelectState>(
                    builder: (buildContext, expenseItemSelectState) {
                      print("build expense item, ${editModeSelectedItem.contains(expenseItemSelectState.expenseItem)}");
                      print("build expense item, expenseItemSelectState.expenseItem=${expenseItemSelectState.expenseItem}");
                      print("build expense item, expenseItemSelectState=$expenseItemSelectState");
                      print("build expense item, cur ExpenseItemSelectState=${BlocProvider.of<ExpenseItemSelectBloc>(buildContext).state}");
                      print("build expense item, cur ExpenseEditModeState=${BlocProvider.of<ExpenseEditModeInfoBloc>(buildContext).state}");

                      if (expenseItemSelectState.expenseItem != invalidExpenseItem) {
                        if (editModeSelectedItem.contains(
                            expenseItemSelectState.expenseItem)) {
                          editModeSelectedItem.remove(
                              expenseItemSelectState.expenseItem);
                        } else {
                          editModeSelectedItem.add(expenseItemSelectState.expenseItem);
                        }
                        // update selected count in top view
                        BlocProvider.of<ExpenseEditModeInfoBloc>(buildContext)
                            .add(ExpenseEditModeInfoEvent(editModeSelectedItem.length));
                        expenseItemSelectState.expenseItem = invalidExpenseItem;
                      }

                      return ListView.separated(
                          itemBuilder: (buildContext, index) {
                            return ExpenseItemWidget.fromExpenseItem(
                                expenseEditModeState,
                                allExpenseItem[index],
                                editModeSelectedItem.contains(allExpenseItem[index]),
                                this,
                                editModeFadeInOutDuration
                            );
                          },
                          separatorBuilder: (buildContext, index) {
                            return Divider(
                              color: Colors.grey,
                              height: 1.0,
                            );
                          },
                          itemCount: allExpenseItem.length);
                    },
                );
              }
            } else {
              return Center(
                child: Text("Error, NormalState"),
              );
            }
          },
        ),
      ),
    );
  }


  List<Widget> buildTestAnimationWidgets() {
    return [
      // test PositionedTransition
      buildTestPositionedTransition(),

      // test FadeTransition
      buildTestFadeTransition(),

      // test ScaleTransition
      buildTestScaleTransition(),
    ];
  }

  SizedBox buildTestPositionedTransition() {
    return SizedBox(
            width: 30,
            height: 30,
            child: Stack(
              children: [
                PositionedTransition(
                    rect: testPositionAnimation,
                    child: FlutterLogo()
                ),
              ],
            ),
          );
  }

  FadeTransition buildTestFadeTransition() {
    return FadeTransition(
        opacity: testOpacityAnimation,
        child: SizedBox(
          width: 30,
          height: 30,
          child: FlutterLogo(),
        ),
    );
  }

  ScaleTransition buildTestScaleTransition() {
    print("testScaleAnimation=$testScaleAnimation");
    return ScaleTransition(
        scale: testScaleAnimation,
        child: SizedBox(
          width: 30,
          height: 30,
          child: Padding(padding: EdgeInsets.all(8), child: FlutterLogo()),
        )
    );
  }

  Widget _buildTopView(BuildContext buildContext, ExpenseEditModeState expenseEditModeState) {
    print("buildTopView(), entry, expenseEditModeState=$expenseEditModeState");
    double topViewWidth = double.infinity;
    double topViewHeight = 50;

    List<Widget> topViews = [];


    topViews.add(_buildRecordTitle(topViewWidth, topViewHeight));
    // edit mode off, show the title
    if (expenseEditModeState is ExpenseEditModeStateOff) {
      // exit edit mode, clear selected item
      editModeSelectedItem.clear();
    } else {
      topViews.add(_buildEditModeBar(buildContext, expenseEditModeState, topViewWidth, topViewHeight));
    }

    return SizedBox(
      width: topViewWidth,
      height: topViewHeight,
      child: Stack(
        children: [
          ...topViews
        ],
      ),
    );
  }

  Widget _buildRecordTitle(double topViewWidth, double topViewHeight) {
    return SizedBox(
      width: topViewWidth,
      height: topViewHeight,
      child: Container(
        // color: Colors.greenAccent,
        child: Center(
          child: Text("Daily Expense Record"),
        ),
      ),
    );
  }

  Widget _buildEditModeBar(
      BuildContext buildContext,
      ExpenseEditModeState expenseEditModeState,
      double topViewWidth,
      double topViewHeight) {

    print("buildEditModeBarSizedBox(), entry, context=$context");
    Animation<double>? topViewOpacityAnimation = initTopViewAnimation(
        buildContext,
        expenseEditModeState);

    double iconMargin = 20;
    double iconButtonSize = 30;

    return SizedBox(
      width: topViewWidth,
      height: topViewHeight,
      child: topViewOpacityAnimation != null ?
      FadeTransition(
        opacity: topViewOpacityAnimation,
        child: _buildEditBarViews(buildContext, iconButtonSize, topViewHeight, iconMargin),
      ) :
      _buildEditBarViews(buildContext, iconButtonSize, topViewHeight, iconMargin),
    );

  }

  BlocBuilder<ExpenseEditModeInfoBloc, ExpenseEditModeInfoState> _buildEditBarViews(
      BuildContext buildContext,
      double iconButtonSize,
      double topViewHeight,
      double iconMargin) {
    return BlocBuilder<ExpenseEditModeInfoBloc, ExpenseEditModeInfoState>(
          builder: (editBarBuildContext, expenseEditModeInfoState) {
            return Container(
              padding: EdgeInsets.only(left: 20, right: 20),
              color: Colors.yellow,
              child: Row(
                children: [
                  SizedBox(
                    width: iconButtonSize,
                    height: iconButtonSize,
                    child: IconButton(
                      splashRadius: topViewHeight / 2,
                      padding: EdgeInsets.all(0),
                      icon: Icon(Icons.arrow_back),
                      onPressed: () {
                        // exit edit mode
                        _expenseEditModeBloc.add(ExpenseEditModeEventFadeOut());
                      },
                    ),
                  ),
                  SizedBox(
                    width: iconMargin,
                  ),

                  Text("Selected ${expenseEditModeInfoState.selectedCount}"),
                  SizedBox(
                    width: iconMargin,
                  ),

                  Expanded(
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.end,
                      children: [
                        SizedBox(
                          width: iconButtonSize,
                          height: iconButtonSize,
                          child: IconButton(
                            splashRadius: topViewHeight / 2,
                            padding: EdgeInsets.all(0),
                            icon: Icon(Icons.delete),
                            onPressed: () {
                              showDialog<bool>(
                                  context: buildContext,
                                  builder: (dialogBuildContext) {
                                    return AlertDialog(
                                      title: Text("delete record"),
                                      content: Text("are you sure to delete?"),
                                      actions: [
                                        TextButton(onPressed: () {
                                          Navigator.pop(buildContext);
                                        }, child: Text("cancel")),

                                        TextButton(onPressed: () {
                                          Navigator.pop(buildContext);

                                          // delete the selected record
                                          onDeleteSelectedExpenses(buildContext);
                                        }, child: Text("delete")),
                                      ],
                                    );
                                  });


                            },
                          ),
                        ),
                      ],
                    ),
                  ),
                ],
              ),
            );
          },
      );
  }

  void onDeleteSelectedExpenses(BuildContext buildContext) {
    // delete the selected record
    editModeSelectedItem.forEach((expenseItem) {
      LocalDataStorage.instance.delExpenseItemById(expenseItem.id);
    });

    // send expense list update event
    BlocProvider.of<ExpenseListBloc>(buildContext)
        .add(ExpenseListEventUpdateList(LocalDataStorage.instance
        .getAllExpenseRecord()));

    // exit expense edit mode
    BlocProvider.of<ExpenseEditModeBloc>(buildContext)
        .add(ExpenseEditModeEventFadeOut());

    // delete success prompt, and send update event
    showPromptDialog(buildContext, "delete expense item success");
  }


  Animation<double>? initTopViewAnimation(
      BuildContext buildContext,
      ExpenseEditModeState expenseEditModeState) {

    // opacity
    Animation<double>? opacityAnimation;

    AnimationController editBarFadeController = AnimationController(
      duration: Duration(milliseconds: editModeFadeInOutDuration),
      vsync: this,
    );

    if (expenseEditModeState is ExpenseEditModeStateFadeIn) {
      opacityAnimation = Tween(begin: 0.0, end: 1.0).animate(editBarFadeController)
        ..addStatusListener((AnimationStatus status) {
            if (status == AnimationStatus.completed) {
              BlocProvider.of<ExpenseEditModeBloc>(buildContext)
                  .add(ExpenseEditModeEventOn());
            }
      });
      editBarFadeController.forward();
    } else if (expenseEditModeState is ExpenseEditModeStateFadeOut) {
      opacityAnimation = Tween(begin: 1.0, end: 0.0).animate(editBarFadeController)
        ..addStatusListener((status) {
        if (status == AnimationStatus.completed) {
          BlocProvider.of<ExpenseEditModeBloc>(buildContext)
              .add(ExpenseEditModeEventOff());
        }
      });
      editBarFadeController.forward();
    }

    return opacityAnimation;
  }

  List<ExpenseItem> _mergeSameTypeExpense(List<ExpenseItem> srcData) {
    List<ExpenseItem> dstData = [];
    if (srcData.isNotEmpty) {
      int curDay = srcData[0].dateTimestamp;
      List<ExpenseItem> curDayAllRecords = [];

      srcData.forEach((element) {
        if (element.comment.isNotEmpty) {
          element.comment += "," + element.amount.toString();
        }

        // check the current day expense has same type expense
        if (curDay == element.dateTimestamp) {
          // has the same type expense
          List<ExpenseItem> sameTypeExpenseItems = curDayAllRecords.where((value) => value.type == element.type).toList();
          if (sameTypeExpenseItems.isNotEmpty) {
            // sameTypeExpenseItems can only has one element
            sameTypeExpenseItems[0].amount += element.amount;
            if (element.comment.isNotEmpty) {
              sameTypeExpenseItems[0].comment += "\n${element.comment}";
            } else {
              sameTypeExpenseItems[0].comment += "\n,${element.amount}";
            }
          } else {
            curDayAllRecords.add(element);
          }
        } else {
          // the next day expense, add the current day expensed to the dstData
          dstData.addAll(curDayAllRecords);

          // merge the next day's same type expense.
          curDayAllRecords.clear();
          curDayAllRecords.add(element);
          curDay = element.dateTimestamp;
        }
      });

      // add last day records
      dstData.addAll(curDayAllRecords);
    }

    return dstData;
  }

  void _exportAllRecordToExcel() {
    // read all expense records
    List<ExpenseItem> allExpenseRecords = LocalDataStorage.instance.getAllExpenseRecord();

    // sort the original records by date increase
    allExpenseRecords.sort(ExpenseItem.comparatorDateIncrease);
    allExpenseRecords = _mergeSameTypeExpense(allExpenseRecords);

    if (allExpenseRecords.isNotEmpty) {
      // init sheet title
      int dailyExpenseItemStartRow = Constants.Title_ExpenseTotal_EndCellIndexRow + 1;
      Excel exportExcel = Excel.createExcel();
      String exportExpenseSheetName = "exportExpense";
      initSheetTitle(exportExcel, exportExpenseSheetName);

      // read daily expense record and write to excel
      List<ExpenseItem> curDayAllRecords = [];
      String curDay = allExpenseRecords[0].date;
      allExpenseRecords.forEach((curRecord) {
        // read all records of a day and merge the same type expense amount
        if (curDay == curRecord.date) {
          // type is no expense type, do not add to curDayAllRecords.
          if (curRecord.type != Constants.SpecialExpenseType_NoExpense) {
            curDayAllRecords.add(curRecord);
          }
        } else {
          // write the previous day's expense record to excel
          print("curDayAllRecords=$curDayAllRecords");
          addExcelDailyExpenseItems(exportExcel,
              exportExpenseSheetName,
              dailyExpenseItemStartRow,
              curDay,
              curDayAllRecords);
          dailyExpenseItemStartRow++;

          // clear the cur day record, and arrange the new day record
          curDayAllRecords.clear();
          curDayAllRecords.add(curRecord);
          curDay = curRecord.date;
        }
      });

      // write tha last daily expense record to excel
      print("last curDayAllRecords=$curDayAllRecords");
      addExcelDailyExpenseItems(exportExcel,
          exportExpenseSheetName,
          dailyExpenseItemStartRow,
          curDay,
          curDayAllRecords);
      dailyExpenseItemStartRow++;


      // save to excel file
      var file = "/sdcard/yl/testFlutter/dailyExpense/exportExpenseRecord.xlsx";
      exportExcel.setDefaultSheet(exportExpenseSheetName);

      List<int>? encodeData = exportExcel.encode();
      if (null != encodeData) {
        File(file)
          ..createSync(recursive: true)
          ..writeAsBytesSync(encodeData);
      } else {
        print("_exportAllRecordToExcel(), encode excel failed");
      }

    } else {
      Fluttertoast.showToast(msg: "No Records Found");
    }
  }

  void addType(BuildContext context) {
    AddExpenseTypeDialog().show(context);
  }

  void addItem(BuildContext context) {
    EditExpenseItemDialog().show(context);
  }

  int getColByExpenseType(String type) {
    return CachedLocalData.instance.expenseTypes.indexOf(type) * 2 + 3;
  }

  HashSet<String> allComments = HashSet();
  void recordAllComments(String comment) {
    if (allComments.contains(comment)) {
      print("recordAllComments(), comment name of $comment exist");
    }
    allComments.add(comment);
  }
  void printAllComments() {
    print("printAllComments(), allComments.length = ${allComments.length}");
    allComments.forEach((element) {
      print("printAllComments(), element = $element");
    });
  }

  bool testFlag = true;
  void testFunc(BuildContext _buildContext) {
    print("testFunc(), entry");

    //////////////////////////////////////////////////////////////////
    // test get expense item by id
    int id = 10;
    if (testFlag) {
      id = 10;
    } else {
      id = 11;
    }
    testFlag = !testFlag;

    // // ---------- test get expense item by id ----------
    // HttpReqIf.getExpenseItemById(id).then((value) {
    //   print("testFunc(), get expense item by id of $id, value=$value");
    // });
    //

    // // ---------- test get all expense item ----------
    // HttpReqIf.getAllExpenseItems().then((value) {
    //   // clear all cached expense item
    //   LocalDataStorage.instance.getAllExpenseRecord().forEach((element) {
    //     LocalDataStorage.instance.delExpenseItemById(element.id);
    //   });
    //
    //   // add to local cache
    //   value?.forEach((element) {
    //     print("testFunc(), get all expense items, element=$element");
    //     LocalDataStorage.instance.addExpenseItem(element);
    //   });
    //
    //   // update list
    //   BlocProvider.of<ExpenseListBloc>(_buildContext).add(
    //       ExpenseListEventUpdateList(
    //           LocalDataStorage.instance.getAllExpenseRecord()));
    // });

    // // ---------- test add expense item ----------
    // ExpenseItem expenseItem = ExpenseItem(IDUtils.genLocalIntID(), 1600000000, "2021.04.28", "车保养", 1600, "test add expense item");
    // HttpReqIf.addExpenseItem(expenseItem).then((value) {
    //   print("testFunc(), add expense item, value=$value");
    //   if (null != value) {
    //     expenseItem.serverId = value.serverId;
    //   }
    //   print("testFunc(), after add expense items, expenseItem=$expenseItem");
    // });

    // // ---------- test add expense item list ----------
    // List<ExpenseItem> expenseItems = [
    //   ExpenseItem(IDUtils.genLocalIntID(), 16000000000, "2021.03.01", "早饭", 5, "包子、油条"),
    //   ExpenseItem(IDUtils.genLocalIntID(), 16000000000, "2021.03.02", "午饭", 30, "汉堡王"),
    //   ExpenseItem(IDUtils.genLocalIntID(), 16000000000, "2021.03.03", "晚饭", 20, "老麻抄手"),
    // ];
    //
    // HttpReqIf.addExpenseItemList(expenseItems).then((value) {
    //   value?.forEach((element) {
    //     print("testFunc(), add expense item list, element=$element");
    //   });
    // });

    // // ---------- test update expense item ----------
    // HttpReqIf.getExpenseItemByServerId(1).then((value) {
    //   if (null != value) {
    //     value.comment = "test update item";
    //     HttpReqIf.updateExpenseItem(value);
    //   }
    // });

    // // ---------- test update expense item list ----------
    // List<ExpenseItem> expenseItems = [
    //   ExpenseItem(IDUtils.genLocalIntID(), 16000000000, "2021.03.01", "早饭", 11, "update item list 1", serverId: 61),
    //   ExpenseItem(IDUtils.genLocalIntID(), 16000000000, "2021.03.02", "午饭", 22, "update item list 2", serverId: 62),
    //   ExpenseItem(IDUtils.genLocalIntID(), 16000000000, "2021.03.03", "晚饭", 33, "update item list 3", serverId: 63),
    // ];
    // HttpReqIf.updateExpenseItemList(expenseItems);

    // ---------- test delete expense item list ----------
    // List<ExpenseItem> expenseItems = [
    //   ExpenseItem(IDUtils.genLocalIntID(), 16000000000, "2021.03.01", "早饭", 11, "update item list 1", serverId: 79),
    //   ExpenseItem(IDUtils.genLocalIntID(), 16000000000, "2021.03.02", "午饭", 22, "update item list 2", serverId: 80),
    //   ExpenseItem(IDUtils.genLocalIntID(), 16000000000, "2021.03.03", "晚饭", 33, "update item list 3", serverId: 63),
    // ];
    // HttpReqIf.deleteExpenseItemList(expenseItems).then((value) {
    //   print("deleteExpenseItemList return $value");
    // });

    // test get phone model name
    print("testFunc(), getPhoneModel = ${SysUtils.getPhoneModel()}");
    print("testFunc(), getPhoneNumber = ${SysUtils.getPhoneNumber()}");
    print("testFunc(), isPhysicalDevice = ${SysUtils.isPhysicalDevice()}");

    //////////////////////////////////////////////////////////////////
    // // test api of get with param
    // Map<String, dynamic> queryParams1 = Map<String, dynamic>()
    //   ..["subNickname"] = "cga2351"
    //   ..["subGender"] = "male"
    //   ..["subAge"] = 25;
    // HttpReqIf.testHttpGetWithParams(params: queryParams1).then((testApiSubData) {
    //       print("testFunc(), testHttpGetWithParams, testApiSubData = $testApiSubData");
    // });
    //
    // // test api of post json
    // dynamic postInfo = Map<String, dynamic>()
    //   ..["nickname"] = "cga2351_parent"
    //   ..["gender"] = "male"
    //   ..["age"] = 30
    //   ..["subInfo"] = (Map()
    //     ..["subNickname"] = "cga2351_sub"
    //     ..["subGender"] = "male"
    //     ..["subAge"] = 35);
    // HttpReqIf.testHttpPostJson(postInfo).then((testApiData) {
    //   print("testFunc(), testHttpPostJson, testApiData = $testApiData");
    // });
    //
    // // test get google url
    // HttpReqIf.testHttpGetGoogleUrl().then((_) {
    //   print("testFunc(), testHttpGetGoogleUrl");
    // });
    //////////////////////////////////////////////////////////////////
    // ExpenseItem aaa = ExpenseItem(1, 111, "date1", LocalDataStorage.instance.presetTypes[1], 10, "aaa");
    // ExpenseItem bbb = ExpenseItem(2, 222, "date2", LocalDataStorage.instance.presetTypes[1], 20, "bbb");
    // List<ExpenseItem> expenseItems1 = [aaa, bbb];
    // List<ExpenseItem> expenseItems2 = [];
    //
    // expenseItems2 = expenseItems1.map((e) => ExpenseItem.deepCopy(e)).toList();
    //
    // print("testFunc(), aaa=0x${aaa.hashCode.toRadixString(16)}");
    // print("testFunc(), bbb=0x${bbb.hashCode.toRadixString(16)}");
    // expenseItems1.forEach((element) {
    //   print("testFunc(), aaa's element=0x${element.hashCode.toRadixString(16)}");
    // });
    // expenseItems2.forEach((element) {
    //   print("testFunc(), bbb's element=0x${element.hashCode.toRadixString(16)}");
    // });

    //////////////////////////////////////////////////////////////////
    // position animation
    // testAnimation();
    //////////////////////////////////////////////////////////////////
    // LocalDataStorage.instance.delExpenseItemJsonById(3);
    // List<ExpenseItem> allExpenseItem = LocalDataStorage.instance.getAllExpenseRecord();
    // BlocProvider.of<DailyExpenseListBloc>(_buildContext)
    //     .add(DailyExpenseListEventUpdateList(allExpenseItem));
    //////////////////////////////////////////////////////////////////
    // LocalDataStorage.instance.init();
    //////////////////////////////////////////////////////////////////
    // IDUtils.genIntID();
    //////////////////////////////////////////////////////////////////
    // LocalDataStorage.instance.initLocalDataStorageDir();
    //////////////////////////////////////////////////////////////////
    // getExternalStorageDirectory().then((value) {print("testFunc(), getExternalStorageDirectory=${value.absolute.path}");});
    // getTemporaryDirectory().then((value) {print("testFunc(), getTemporaryDirectory=${value.absolute.path}");});
    // getApplicationSupportDirectory().then((value) {print("testFunc(), getApplicationSupportDirectory=${value.absolute.path}");});
    // getApplicationDocumentsDirectory().then((value) {print("testFunc(), getApplicationDocumentsDirectory=${value.absolute.path}");});
    // getExternalCacheDirectories().then((value) {print("testFunc(), getExternalCacheDirectories=$value");});
    // getExternalStorageDirectories(type:StorageDirectory.podcasts).then((value) {print("testFunc(), getExternalStorageDirectories=$value");});
    //////////////////////////////////////////////////////////////////
    // ExpenseItem expenseItem = ExpenseItem("1995.01.01", "早饭", 22, "testExpenseItem");
    // LocalDataStorage.instance.addExpenseItemJson(expenseItem);
    //////////////////////////////////////////////////////////////////
    // String emptyJsonString = "";
    // String singleJsonString = "{\"date\":\"2021.03.23\",\"type\":\"晚饭\",\"amount\":22,\"comment\":\"\"}";
    // String arrayJsonString = "[{\"date\":\"2021.03.23\",\"type\":\"晚饭\",\"amount\":22,\"comment\":\"\"},{\"date\":\"2021.03.23\",\"type\":\"晚饭\",\"amount\":33,\"comment\":\"\"}]";

    // List<ExpenseItem> objArray = ExpenseItem.fromJsonArrayString(arrayJsonString);
    // print("testFunc(), objArray=$objArray");
    // String jsonString = ExpenseItem.toJsonArrayString(objArray);
    // print("testFunc(), jsonString=$jsonString");

    // ExpenseItem expenseItem = ExpenseItem("1995.01.01", "早饭", 22, "testExpenseItem");
    // print("testFunc(), expenseItem.toJsonString()=${expenseItem.toJsonString()}");
    //////////////////////////////////////////////////////////////////
    // // test get lib
    // Get.snackbar("title", "message",
    //     animationDuration: Duration(milliseconds: 300),
    //     backgroundColor: Colors.white,
    //     colorText: Colors.black
    // );
    // // Get.defaultDialog(title: "title", textCancel: "cancel", textConfirm: "confirm", textCustom: "custom", middleText: "middle");
    // // Get.bottomSheet(Text("abc"));
    // _testCount++;
    //////////////////////////////////////////////////////////////////
    // List<ExpenseItem> expenseItems = LocalDataStorage.instance.readRecordExpenseItem();
    // print("testFunc(), expenseItems=$expenseItems");
    //////////////////////////////////////////////////////////////////
    // print("3.1 context=$context");
    // print("3.2 context=${globalNavigatorKey.currentState.overlay.context}");
    // print("3.3 context=${GlobalKey<NavigatorState>().currentContext}");
    // print("3.4 bloc=${BlocProvider.of<DailyExpenseListBloc>(context)}");
    //////////////////////////////////////////////////////////////////
    // convertOriginTxtToExcel();
    // convertOriginTxtToExcelNew();
    //////////////////////////////////////////////////////////////////
    // List<ExpenseItem> allExpenseItem = LocalDataStorage.instance.readRecordExpenseItem();
    // BlocProvider.of<DailyExpenseListBloc>(context).add(DailyExpenseListEventUpdateList(allExpenseItem));
    //////////////////////////////////////////////////////////////////
  }

  void testAnimation() {
     // position animation
    setState(() {
      testPositionTween = testPositionTween = RelativeRectTween(
          begin: RelativeRect.fromSize(
              Rect.fromLTWH(0, 0, 30, 30), Size(30, 30)),
          end: RelativeRect.fromSize(
              Rect.fromLTWH(10, 10, 30, 30), Size(30, 30))
      );
      testPositionAnimationController = AnimationController(duration: Duration(milliseconds: 1000), vsync: this);
      testPositionAnimation = testPositionTween.animate(testPositionAnimationController);
      testPositionAnimationController.forward();
    });

    // opacity animation
    setState(() {
      testOpacityTween = Tween<double>(begin : 0.0, end : 1.0);
      testOpacityAnimationController = AnimationController(duration: Duration(milliseconds: 1000), vsync: this);
      testOpacityAnimation = testOpacityTween.animate(testOpacityAnimationController);
      testOpacityAnimationController.forward();
    });

    // opacity animation
    setState(() {
      testScaleTween = Tween<double>(begin : 0.0, end : 1.0);
      testScaleAnimationController = AnimationController(duration: Duration(milliseconds: 1000), vsync: this);
      testScaleAnimation = testScaleTween.animate(testScaleAnimationController);
      testScaleAnimationController.forward();
    });
  }

  void convertOriginTxtToExcelNew() {
    // add expense type
    // addAllTypes();

    // allComments.clear();

    // read from original file
    String originContent = File("/sdcard/yl/testFlutter/DailyExpenseNote.txt").readAsStringSync(encoding: utf8);

    // write excel
    // int sheetCurRow = Constants.Title_Date_EndCellIndexRow + 1;
    int dailyExpenseCount = 0;
    int dailyExpenseItemStartRow = Constants.Title_ExpenseTotal_EndCellIndexRow;
    int dailyExpenseItemStartCol = Constants.Title_ExpenseTotal_EndCellIndexCol + 1;
    Excel excel = Excel.createExcel();
    String genSheetFromOriginTxt = "genSheetFromOriginTxt";
    List<String> splitContents = LineSplitter().convert(originContent);

    // init sheet title
    initSheetTitle(excel, genSheetFromOriginTxt);

    // separate to every expense name and expense value
    int expenseDateTimestamp = 0;
    String expenseDate = "";
    List<ExpenseItem> expenseItems = [];

    splitContents.forEach((lineContent) {
      if (lineContent.isNotEmpty) {
        if (lineContent == "每日支出") {
          // excel.updateCell(genSheetFromOriginTxt, CellIndex.indexByColumnRow(rowIndex: 0, columnIndex: 0), lineContent);
        } else if (lineContent.contains(".")) {
          // before read a new day expense list, add the last day's expense items
          if (expenseItems.isNotEmpty) {
            // print("call addDailyExpenseItems expenseItems=$expenseItems");
            addExcelDailyExpenseItems(excel,
                genSheetFromOriginTxt,
                dailyExpenseItemStartRow,
                expenseDate,
                expenseItems);

            // clear expense items
            expenseItems.clear();
          }

          // record new day expense date, and clear daily expense count,
          expenseDate = lineContent;
          List<String> dateTimeString = expenseDate.split(".");
          if (dateTimeString.length == 2) {
            expenseDateTimestamp = DateTime(DateTime.now().year, int.parse(dateTimeString[0]), int.parse(dateTimeString[1])).millisecondsSinceEpoch;
          } else if (dateTimeString.length == 3) {
            expenseDateTimestamp = DateTime(int.parse(dateTimeString[0]), int.parse(dateTimeString[1]), int.parse(dateTimeString[2])).millisecondsSinceEpoch;
          }

          dailyExpenseCount = 0;
          dailyExpenseItemStartRow++;
          // print("read new day of $lineContent");

        } else {
          // daily expense
          if (dailyExpenseCount == 0) {
            // breakfast
            // addExpenseItem(excel, genSheetFromOriginTxt, dailyExpenseItemStartRow, dailyExpenseItemStartCol, dailyExpenseCount, "早饭", lineContent);
            expenseItems.add(ExpenseItem(IDUtils.genLocalIntID(), expenseDateTimestamp, expenseDate, "早饭", int.parse(lineContent), "早饭"));
            dailyExpenseCount++;
          } else if (dailyExpenseCount == 1) {
            // launch
            // addExpenseItem(excel, genSheetFromOriginTxt, dailyExpenseItemStartRow, dailyExpenseItemStartCol, dailyExpenseCount, "午饭", lineContent);
            if (lineContent == "170肯德基外卖") {
              expenseItems.add(ExpenseItem(IDUtils.genLocalIntID(), expenseDateTimestamp, expenseDate, "午饭", 170, "肯德基外卖"));
            } else {
              expenseItems.add(ExpenseItem(IDUtils.genLocalIntID(), expenseDateTimestamp, expenseDate, "午饭", int.parse(lineContent), "午饭"));
            }
            dailyExpenseCount++;
          } else if (dailyExpenseCount == 2) {
            // dinner
            // addExpenseItem(excel, genSheetFromOriginTxt, dailyExpenseItemStartRow, dailyExpenseItemStartCol, dailyExpenseCount, "晚饭", lineContent);
            if (lineContent == "5人吃火锅，450") {
              expenseItems.add(ExpenseItem(IDUtils.genLocalIntID(), expenseDateTimestamp, expenseDate, "晚饭", 450, "5人吃火锅"));
            } else {
              expenseItems.add(ExpenseItem(IDUtils.genLocalIntID(), expenseDateTimestamp, expenseDate, "晚饭", int.parse(lineContent), "晚饭"));
            }

            dailyExpenseCount++;
          } else {
            // other expense

            if (lineContent == "奶茶50，5人") {
              lineContent = "奶茶五人50";
            }
            // separate name and amount
            RegExp regExpExpenseItem = RegExp(r"[\D]+[\d\+\s]+");
            regExpExpenseItem.allMatches(lineContent).forEach((match) {
              String expenseItem = lineContent.substring(match.start, match.end);
              int expenseAmountIndex = expenseItem.indexOf(RegExp(r"\d"));
              String expenseName = expenseItem.substring(0, expenseAmountIndex);
              String expenseAmount = expenseItem.substring(expenseAmountIndex);
              if (expenseName.trim().isEmpty) {
                expenseName = "空格";
              }
              // print("allMatches() expenseName:$expenseName, expenseAmount=$expenseAmount");
              // addExpenseItem(excel, genSheetFromOriginTxt, dailyExpenseItemStartRow, dailyExpenseItemStartCol, dailyExpenseCount, expenseName, expenseAmount);

              // classify the expense type by the comment
              String expenseType = getExpenseTypeByName(expenseName);
              ExpenseItem newExpenseItem = ExpenseItem(IDUtils.genLocalIntID(), expenseDateTimestamp, expenseDate, expenseType, int.parse(expenseAmount), expenseName + " " + expenseAmount);

              // check if has same expense type item
              ExpenseItem? existedExpenseItem;
              expenseItems.forEach((element) {
                if (element.type == newExpenseItem.type) {
                  existedExpenseItem = element;
                }
              });

              if (null == existedExpenseItem) {
                expenseItems.add(newExpenseItem);
              } else {
                // sum the same type expense amount and comment
                existedExpenseItem?.amount += newExpenseItem.amount;
                existedExpenseItem?.comment += "\n" + newExpenseItem.comment;
              }

              // print("convertOriginTxtToExcelNew(), add new other expense item = ${ExpenseItem(expenseType, int.parse(expenseAmount), expenseName)}");
              // recordAllComments(expenseName);

              dailyExpenseCount++;
            });
          }
        }
      }
    });

    // print("convertOriginTxtToExcelNew(), 1");

    // add last expense items
    if (expenseItems.isNotEmpty) {
      addExcelDailyExpenseItems(excel,
          genSheetFromOriginTxt,
          dailyExpenseItemStartRow,
          expenseDate,
          expenseItems);

      // clear expense items
      expenseItems.clear();
    }

    // print("convertOriginTxtToExcelNew(), 2");

    // save to excel file
    var file = "/sdcard/yl/testFlutter/genExcelFromOriginTxt.xlsx";
    excel.setDefaultSheet(genSheetFromOriginTxt);
    List<int>? encodeData = excel.encode();
    if (null != encodeData) {
      File(file)..createSync(recursive: true)
        ..writeAsBytesSync(encodeData);
    } else {
      print("convertOriginTxtToExcelNew(), encode excel failed");
    }

    print("convertOriginTxtToExcelNew(), 3");
    printAllComments();
  }

  void addExcelDailyExpenseItems(
      Excel excel,
      String genSheetFromOriginTxt,
      int dailyExpenseItemStartRow,
      String expenseDate,
      List<ExpenseItem> expenseItems) {
    // add date
    excel.updateCell(genSheetFromOriginTxt,
        CellIndex.indexByColumnRow(
            rowIndex: dailyExpenseItemStartRow,
            columnIndex: Constants.Title_Date_EndCellIndexCol),
        expenseDate);

    // add expense detail, if has no expense, only add a date
    if (expenseItems.isNotEmpty) {
      // add expense items
      expenseItems.forEach((expense) {
        int cellRow = dailyExpenseItemStartRow;
        int cellCol = getColByExpenseType(expense.type);
        print("addExcelDailyExpenseItems(),  expense of $expense's row = $cellRow, col = $cellCol, }");

        // expense amount
        excel.updateCell(
            genSheetFromOriginTxt,
            CellIndex.indexByColumnRow(rowIndex: cellRow, columnIndex: cellCol),
            expense.amount);

        // expense comment
        excel.updateCell(
            genSheetFromOriginTxt,
            CellIndex.indexByColumnRow(rowIndex: cellRow, columnIndex: cellCol + 1),
            expense.comment);
      });
    }

  }


  void convertOriginTxtToExcel() {

    // // add expense type
    // addAllTypes();


    // read from original file
    String originContent = File("/sdcard/yl/testFlutter/DailyExpenseNote.txt").readAsStringSync(encoding: utf8);
//    print("testExcelReadWrite(), originContent=$originContent");

    // write excel
    // int sheetCurRow = Constants.Title_Date_EndCellIndexRow + 1;
    int dailyExpenseCount = 0;
    int dailyExpenseItemStartRow = Constants.Title_ExpenseTotal_EndCellIndexRow;
    int dailyExpenseItemStartCol = Constants.Title_ExpenseTotal_EndCellIndexCol + 1;
    Excel excel = Excel.createExcel();
    String genSheetFromOriginTxt = "genSheetFromOriginTxt";
    List<String> splitContents = LineSplitter().convert(originContent);

    // init sheet title
    initSheetTitle(excel, genSheetFromOriginTxt);

    // separate to every expense name and expense value
    splitContents.forEach((lineContent) {
      if (lineContent.isNotEmpty) {
        if (lineContent == "每日支出") {
          // excel.updateCell(genSheetFromOriginTxt, CellIndex.indexByColumnRow(rowIndex: 0, columnIndex: 0), lineContent);
        } else if (lineContent.contains(".")) {
          // 新一天的支出，插入日期
          // sheetCurRow++;
          dailyExpenseItemStartRow++;
          dailyExpenseCount = 0;
          print("read new day of $lineContent");
          excel.updateCell(genSheetFromOriginTxt,
              CellIndex.indexByColumnRow(
                  rowIndex: dailyExpenseItemStartRow,
                  columnIndex: Constants.Title_Date_EndCellIndexCol),
              lineContent);
        } else {
          // daily expense
          if (dailyExpenseCount == 0) {
            // breakfast
            addExcelExpenseItem(excel, genSheetFromOriginTxt, dailyExpenseItemStartRow, dailyExpenseItemStartCol, dailyExpenseCount, "早饭", lineContent);
            dailyExpenseCount++;
          } else if (dailyExpenseCount == 1) {
            // launch
            addExcelExpenseItem(excel, genSheetFromOriginTxt, dailyExpenseItemStartRow, dailyExpenseItemStartCol, dailyExpenseCount, "午饭", lineContent);
            dailyExpenseCount++;
          } else if (dailyExpenseCount == 2) {
            // dinner
            addExcelExpenseItem(excel, genSheetFromOriginTxt, dailyExpenseItemStartRow, dailyExpenseItemStartCol, dailyExpenseCount, "晚饭", lineContent);
            dailyExpenseCount++;
          } else {
            // other expense

            // separate name and amount
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

              addExcelExpenseItem(excel, genSheetFromOriginTxt, dailyExpenseItemStartRow, dailyExpenseItemStartCol, dailyExpenseCount, expenseName, expenseValue);
              dailyExpenseCount++;
            });
          }
        }
      }
    });

    // save to excel file
    var file = "/sdcard/yl/testFlutter/genExcelFromOriginTxt.xlsx";
    excel.setDefaultSheet(genSheetFromOriginTxt);
    // excel.encode().then((value) {
    //   File(file)
    //     ..createSync(recursive: true)
    //     ..writeAsBytesSync(value);
    // });

    List<int>? encodeData = excel.encode();
    if (null != encodeData) {
      File(file)..createSync(recursive: true)
        ..writeAsBytesSync(encodeData);
    } else {
      print("convertOriginTxtToExcel(), encode excel failed");
    }
  }

  void addExcelExpenseItem(Excel excel, String genSheetFromOriginTxt,
      int dailyExpenseItemStartRow,
      int dailyExpenseItemStartCol,
      int dailyExpenseCount,
      String name,
      String amount) {
    // name
    excel.updateCell(genSheetFromOriginTxt,
        CellIndex.indexByColumnRow(
            rowIndex: dailyExpenseItemStartRow,
            columnIndex: dailyExpenseItemStartCol + dailyExpenseCount * 2),
        name);

    // amount
    excel.updateCell(genSheetFromOriginTxt,
        CellIndex.indexByColumnRow(
            rowIndex: dailyExpenseItemStartRow,
            columnIndex: dailyExpenseItemStartCol + 1 + dailyExpenseCount * 2),
        amount);
  }

  void initSheetTitle(Excel excel, String genSheetFromOriginTxt) {

    // 日期
    excel.merge(genSheetFromOriginTxt,
        CellIndex.indexByColumnRow(
            rowIndex: Constants.Title_Date_StartCellIndexRow,
            columnIndex: Constants.Title_Date_StartCellIndexCol),
        CellIndex.indexByColumnRow(
            rowIndex: Constants.Title_Date_EndCellIndexRow,
            columnIndex: Constants.Title_Date_EndCellIndexCol));
    excel.updateCell(genSheetFromOriginTxt,
        CellIndex.indexByColumnRow(
            rowIndex: Constants.Title_Date_StartCellIndexRow,
            columnIndex: Constants.Title_Date_StartCellIndexCol),
        "日期");

    // 支出总计
    excel.merge(genSheetFromOriginTxt,
        CellIndex.indexByColumnRow(
            rowIndex: Constants.Title_ExpenseTotal_StartCellIndexRow,
            columnIndex: Constants.Title_ExpenseTotal_StartCellIndexCol),
        CellIndex.indexByColumnRow(
            rowIndex: Constants.Title_ExpenseTotal_EndCellIndexRow,
            columnIndex: Constants.Title_ExpenseTotal_EndCellIndexCol));
    excel.updateCell(genSheetFromOriginTxt,
        CellIndex.indexByColumnRow(
            rowIndex: Constants.Title_ExpenseTotal_StartCellIndexRow,
            columnIndex: Constants.Title_ExpenseTotal_StartCellIndexCol),
        "支出总计");

    // 支出项目
    excel.merge(genSheetFromOriginTxt,
        CellIndex.indexByColumnRow(
            rowIndex: Constants.Title_ExpenseItem_StartCellIndexRow,
            columnIndex: Constants.Title_ExpenseItem_StartCellIndexCol),
        CellIndex.indexByColumnRow(
            rowIndex: Constants.Title_ExpenseItem_EndCellIndexRow,
            // columnIndex: Constants.Title_ExpenseItem_EndCellIndexCol));
            columnIndex: Constants.Title_ExpenseItem_StartCellIndexCol + CachedLocalData.instance.expenseTypes.length * 2 - 1));
    excel.updateCell(genSheetFromOriginTxt,
        CellIndex.indexByColumnRow(
            rowIndex: Constants.Title_ExpenseItem_StartCellIndexRow,
            columnIndex: Constants.Title_ExpenseItem_StartCellIndexCol),
        "支出项目");

    // 各个支出类型
    for (int i = 0; i < CachedLocalData.instance.expenseTypes.length; i++) {
      CachedLocalData.instance.expenseTypes[i];
      initTitleExpenseItem(excel, genSheetFromOriginTxt,
        CachedLocalData.instance.expenseTypes[i],
        Constants.Title_FirstExpenseItem_StartCellIndexRow,
        Constants.Title_FirstExpenseItem_StartCellIndexCol + i * 2,
        Constants.Title_FirstExpenseItem_EndCellIndexRow,
        Constants.Title_FirstExpenseItem_EndCellIndexCol + i * 2,
      );
    }
  }

  void initTitleExpenseItem(Excel excel, String genSheetFromOriginTxt,
      String expenseName,
      int startIndexRow, int startIndexCol,
      int endIndexRow, int endIndexCol,) {

    // 支出名
    excel.merge(genSheetFromOriginTxt,
        CellIndex.indexByColumnRow(rowIndex: startIndexRow, columnIndex: startIndexCol),
        CellIndex.indexByColumnRow(rowIndex: endIndexRow, columnIndex: endIndexCol));
    excel.updateCell(genSheetFromOriginTxt,
        CellIndex.indexByColumnRow(rowIndex: startIndexRow, columnIndex: startIndexCol),
        expenseName);

    // 支出
    excel.updateCell(genSheetFromOriginTxt,
        CellIndex.indexByColumnRow(
            rowIndex: startIndexRow + 1,
            columnIndex: startIndexCol),
        "支出");

    // 备注
    excel.updateCell(genSheetFromOriginTxt,
        CellIndex.indexByColumnRow(
            rowIndex: startIndexRow + 1,
            columnIndex: startIndexCol + 1),
        "备注");
  }

  String getExpenseTypeByName(String expenseName) {
    Map<String, String> allExpenseName = {
      "给爸爸买衣服钱" : "买衣服",
      "理发" : "日常消费",
      "买药" : "医药费用",
      "牛奶烤肠" : "零食、水果",
      "烤肠" : "零食、水果",
      "桃酥" : "零食、水果",
      "打网球" : "日常消费",
      "洗面奶" : "日常用品",
      "川贝母，三七粉" : "医药费用",
      "水" : "零食、水果",
      "妈妈医院检查" : "医药费用",
      "四姑生日红包" : "日常消费",
      "宽带充值" : "日常消费",
      "追尾赔" : "日常消费",
      "车保养" : "车保养",
      "一共:" : "DeletedName",
      "抽纸" : "日常用品",
      "爆米花" : "零食、水果",
      "抽血" : "医药费用",
      "游戏充值" : "娱乐消费",
      "净水器滤芯" : "日常用品",
      "电信充值" : "日常消费",
      "复印" : "日常消费",
      "两个饭盒" : "日常用品",
      "睡衣" : "买衣服",
      "过年爸妈红包" : "日常消费",
      "蓝牙耳机" : "日常用品",
      "蛋糕，水" : "零食、水果",
      "买dha两瓶 " : "医药费用",
      "泰康保险" : "日常消费",
      "麻花" : "零食、水果",
      "车费" : "日常消费",
      "裤子" : "买衣服",
      "面" : "零食、水果",
      "电费" : "电",
      "文件袋等" : "日常用品",
      "过路费" : "过路费",
      "螺旋藻，沙发垫等" : "日常用品",
      "充公交卡" : "日常消费",
      "火车票" : "日常消费",
      "洗车" : "日常消费",
      "可乐" : "零食、水果",
      "蛋糕" : "零食、水果",
      "dota游戏充值" : "娱乐消费",
      "摘草莓" : "娱乐消费",
      "手机充值" : "日常消费",
      "豌豆酥" : "零食、水果",
      "插线板 数据线" : "日常用品",
      "电脑" : "日常用品",
      "坚果" : "零食、水果",
      "小二洗脸仪" : "日常用品",
      "拖鞋" : "日常用品",
      "充电费" : "电",
      "牛奶" : "零食、水果",
      "打车 " : "日常消费",
      "高速过路费" : "过路费",
      "扫描户口本" : "日常消费",
      "买衣服" : "买衣服",
      "鸡肉卷" : "零食、水果",
      "产检买药" : "医药费用",
      "买花" : "日常消费",
      "保暖内衣" : "买衣服",
      "花生馍" : "零食、水果",
      "换驾照" : "日常消费",
      "士力架" : "零食、水果",
      "妈妈买手机" : "日常用品",
      "转小二" : "日常消费",
      "土豆" : "零食、水果",
      "止咳药" : "医药费用",
      "显示器" : "日常用品",
      "面包蛋黄酥" : "零食、水果",
      "租自行车" : "娱乐消费",
      "红包" : "日常消费",
      "三明治" : "零食、水果",
      "摩拜充值" : "日常消费",
      "买裤子" : "买衣服",
      "面包" : "零食、水果",
      "上网" : "上网",
      "停车费" : "停车费",
      "买备孕药" : "医药费用",
      "电影" : "娱乐消费",
      "雪芹妈过生红包" : "日常消费",
      "看电影" : "娱乐消费",
      "雪芹买鞋" : "买衣服",
      "租韩国wifi " : "日常消费",
      "给小二买手机" : "日常用品",
      "冰淇淋" : "零食、水果",
      "爱乐维复合维生素" : "医药费用",
      "套套" : "日常用品",
      "巧克力" : "零食、水果",
      "vpn " : "日常消费",
      "汤包" : "零食、水果",
      "按摩" : "娱乐消费",
      "饮料啤酒" : "零食、水果",
      "甜皮鸭" : "零食、水果",
      "补办驾照邮费 " : "日常消费",
      "冰粉" : "零食、水果",
      "旅游买路上吃的" : "零食、水果",
      "茶叶，干果，红枣等" : "零食、水果",
      "泉宏生日红包" : "日常消费",
      "垫子" : "日常用品",
      "医院买吃的" : "日常消费",
      "医院检查买药" : "医药费用",
      "买衣服 两条裤子" : "买衣服",
      "螃蟹" : "日常消费",
      "蛋黄酥" : "零食、水果",
      "钙片，优甲乐" : "医药费用",
      "换驾照体检" : "日常消费",
      "凳子" : "日常用品",
      "妈妈生日礼物，手链" : "日常消费",
      "检查" : "医药费用",
      "买纸" : "日常用品",
      "零食" : "零食、水果",
      "香皂牙膏毛巾等 " : "日常用品",
      "孕前检查" : "医药费用",
      "蜂蜜蛋糕，凉面" : "零食、水果",
      "电信宽带充值" : "日常消费",
      "存行李" : "日常消费",
      "医院停车费" : "停车费",
      "衣服袜子" : "买衣服",
      "证件照" : "日常消费",
      "风扇" : "日常用品",
      "酒精喷雾" : "日常用品",
      "秦陵博物馆解说" : "娱乐消费",
      "输液" : "日常消费",
      "零食，巧克力" : "零食、水果",
      "汽车质保期尾检查" : "车保养",
      "买手机" : "日常用品",
      "牙膏" : "日常用品",
      "小二输液" : "医药费用",
      "汽车保险" : "车保养",
      "充电话卡" : "日常消费",
      "气费" : "气",
      "挂号费" : "医药费用",
      "dota充值" : "娱乐消费",
      "买菜" : "日常消费",
      "优甲乐" : "医药费用",
      "产检，无创dna唐筛，" : "医药费用",
      "打乒乓" : "娱乐消费",
      "睡衣等" : "买衣服",
      "超市购物" : "日常消费",
      "加油" : "油费",
      "茶" : "日常消费",
      "B超" : "医药费用",
      "打乒乓球" : "娱乐消费",
      "水果" : "零食、水果",
      "拍照" : "日常消费",
      "电烧水壶" : "日常用品",
      "怀孕医院检查" : "医药费用",
      "两年停车费" : "停车费",
      "买水" : "零食、水果",
      "买风扇" : "日常用品",
      "关东煮，肯德基" : "零食、水果",
      "天府通充值" : "日常消费",
      "护膝" : "日常用品",
      "鼠标垫等" : "日常用品",
      "备孕药" : "医药费用",
      "买胃药" : "医药费用",
      "修车" : "车保养",
      "脱毛膏" : "日常用品",
      "锅巴土豆" : "零食、水果",
      "奶茶" : "零食、水果",
      "沙发垫" : "日常用品",
      "公交卡充值" : "日常消费",
      "烧饼" : "零食、水果",
      "鸡蛋仔" : "零食、水果",
      " 停车费" : "停车费",
      "鸭子" : "日常消费",
      "物业费" : "日常消费",
      "插座转换头 蓝牙鼠标" : "日常用品",
      "二手显示器" : "日常用品",
      "寄快递" : "日常消费",
      "纸" : "日常用品",
      "包子" : "零食、水果",
      "西安城墙门票" : "娱乐消费",
      "小二产检" : "医药费用",
      "彩超" : "医药费用",
      "胃药" : "医药费用",
      "星冰乐" : "零食、水果",
      "烟" : "日常消费",
      "停车" : "停车费",
      "音箱" : "日常用品",
      "违停罚款" : "日常消费",
      "挂号" : "医药费用",
      "打车" : "日常消费",
      "酸奶" : "零食、水果",
      "宜家购物 台灯等" : "日常用品",
      "感冒药" : "医药费用",
      "行车记录仪" : "日常用品",
      "餐边柜" : "日常用品",
      "衣服" : "买衣服",
      "奶茶五人" : "零食、水果",
      "潜水" : "娱乐消费",
      "碗" : "日常用品",
      "交电费" : "电",
      "模型" : "日常消费",
      "存储卡" : "日常用品",
      "买路由器两个" : "日常用品",
      "水费" : "水",
      "水，酒" : "零食、水果",
      "零食，牛肉干等" : "零食、水果",
      "爸爸买手机" : "日常用品",
      "泰康保险保费" : "日常消费",
      "衣架" : "日常用品",
      "产检" : "医药费用",
      "核酸检测" : "医药费用",
      "纸，烟" : "日常用品",
      "生产住院" : "医药费用",
      "收腹带" : "医药费用",
      "请护工" : "日常消费",
      "脸盆" : "日常用品",
      "吸管" : "日常用品",
      "水，面包" : "零食、水果",
      "一次性马桶垫" : "日常用品",
      "儿子黄疸检测" : "医药费用",
      "请客吃饭" : "日常消费",
      "牛奶酸奶" : "零食、水果",
      "小孩黄疸检测" : "医药费用",
      "额温枪，纸尿裤，维生素ad剂，牛奶等" : "日常用品",
      "小孩儿黄疸检测" : "医药费用",
      "复印证件" : "日常消费",
      "小孩儿交医保" : "日常消费",
      "小孩儿黄疸检测" : "医药费用",
      "防水肚脐贴" : "日常用品",
      "洗发水，洗面奶等" : "日常用品",
      "小孩儿黄疸检测" : "医药费用",
      "限行罚款" : "日常消费",
      "翻墙软件年费" : "日常消费",
      "小孩儿看病挂号" : "医药费用",
      "净水器换滤芯" : "日常用品",
      "请客吃饭" : "日常消费",
      "电瓶车" : "日常用品",
      "水，冰淇淋" : "零食、水果",
      "电瓶车停车月费" : "日常消费",
      "洗发水，牙膏等" : "日常用品",
      "零食牛肉干等" : "零食、水果",
      "小孩儿医保" : "日常消费",
      "买鞋子衣服" : "买衣服",
      "电瓶车停车费" : "日常消费",
      "帮妈妈买火车票" : "日常消费",
      "转小儿" : "日常消费",
      "地铁" : "日常消费",
      "建行信用卡还款" : "日常消费",
      "电瓶车停车费" : "日常消费",
      "钙尔奇钙片" : "医药费用",
      "蛋黄派，蛋糕" : "零食、水果",
      "消毒喷雾" : "日常用品",
      "小孩儿乳糖酶等" : "医药费用",
      "伊可新两盒" : "医药费用",
      "妈妈做胃镜" : "医药费用",
  };

    if (allExpenseName.containsKey(expenseName)) {
      return allExpenseName[expenseName]!;
    } else {
      print("error, no corresponding expense type, expenseName=$expenseName");
      return "no corresponding expense type";
    }
  }
}