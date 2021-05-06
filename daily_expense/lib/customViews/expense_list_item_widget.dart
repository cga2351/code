import 'package:dailyexpense/bloc/expense_edit_mode_bloc.dart';
import 'package:dailyexpense/bloc/expense_edit_mode_info_bloc.dart';
import 'package:dailyexpense/bloc/expense_item_select_bloc.dart';
import 'package:dailyexpense/model/expense_item.dart';
import 'package:dailyexpense/page/dialog/edit_expense_item_dialog.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';


class ExpenseItemWidget extends StatelessWidget {

  final ExpenseEditModeState expenseEditModeState;
  final ExpenseItem expenseItem;
  final selected;
  final TickerProvider tickerProvider;
  final int duration;

  ExpenseItemWidget.fromExpenseItem(
      this.expenseEditModeState,
      this.expenseItem,
      this.selected,
      this.tickerProvider,
      this.duration);


  @override
  Widget build(BuildContext buildContext) {
    return GestureDetector(
      child: Material(
        child: Stack(
          children: _buildItemViews(buildContext),
        ),
      ),
      onLongPress: () {
        if (expenseEditModeState is ExpenseEditModeStateOff) {
          BlocProvider.of<ExpenseEditModeBloc>(buildContext)
              .add(ExpenseEditModeEventFadeIn());

          // update the checkbox
          print("expenseItem onLongPress() entry, send ExpenseItemSelectEvent");
          BlocProvider.of<ExpenseItemSelectBloc>(buildContext)
              .add(ExpenseItemSelectEvent(expenseItem));
        }
      },
      onTap: () {
        if (expenseEditModeState is ExpenseEditModeStateOn) {
          // update the checkbox
          print("expenseItem onTap() entry, send ExpenseItemSelectEvent");
          BlocProvider.of<ExpenseItemSelectBloc>(buildContext)
              .add(ExpenseItemSelectEvent(expenseItem));
        } else if (expenseEditModeState is ExpenseEditModeStateOff) {
          EditExpenseItemDialog().show(buildContext, editItem: expenseItem);
        }
      },
    );
  }

  List<Widget> _buildItemViews(BuildContext buildContext) {
    List<Widget> expenseItemViews = [];

    // if edit mode add checkbox
    double itemWidthHeight = 40;
    if (expenseEditModeState is ExpenseEditModeStateOn ||
        expenseEditModeState is ExpenseEditModeStateFadeIn ||
        expenseEditModeState is ExpenseEditModeStateFadeOut) {
      Widget itemCheckbox = _buildEditModeCheckbox(buildContext, itemWidthHeight);

      if (expenseEditModeState is ExpenseEditModeStateFadeIn ||
          expenseEditModeState is ExpenseEditModeStateFadeOut) {
        Animation<double> scaleAnimation;
        AnimationController checkBoxFadeInController = AnimationController(
            duration: Duration(milliseconds: duration),
            vsync: tickerProvider
        );
        scaleAnimation = createCheckboxAnimation(checkBoxFadeInController);
        itemCheckbox = ScaleTransition(scale: scaleAnimation, child: itemCheckbox,);
        checkBoxFadeInController.forward();
      }
      expenseItemViews.add(itemCheckbox);
    }

    // expense item view
    Widget expenseItemView = Container(
      alignment: Alignment.centerLeft,
      height: itemWidthHeight,
      child: Text(expenseItem.date + ", "
          + expenseItem.type + ", "
          + expenseItem.amount.toString() + ", "
          + expenseItem.comment,
      ),
    );

    if (expenseEditModeState is ExpenseEditModeStateFadeIn ||
        expenseEditModeState is ExpenseEditModeStateFadeOut ||
        expenseEditModeState is ExpenseEditModeStateOn) {
      // add fade in/out animation
      AnimationController animationController = AnimationController(
          duration: Duration(milliseconds: duration),
          vsync: tickerProvider);


      if (expenseEditModeState is ExpenseEditModeStateOn) {
        expenseItemView = Positioned(left: itemWidthHeight, right: 0, child: expenseItemView);
      } else {
        Animation<RelativeRect> positionedAnimation;
        if (expenseEditModeState is ExpenseEditModeStateFadeIn) {
          // edit mode slide right
          positionedAnimation =
              RelativeRectTween(begin: RelativeRect.fromLTRB(0, 0, 0, 0), end: RelativeRect.fromLTRB(itemWidthHeight, 0, 0, 0))
                  .animate(CurvedAnimation(parent: animationController, curve: Curves.easeInOut));
        } else  {
          // edit mode slide left
          positionedAnimation =
              RelativeRectTween(begin: RelativeRect.fromLTRB(itemWidthHeight, 0, 0, 0), end: RelativeRect.fromLTRB(0, 0, 0, 0))
                  .animate(CurvedAnimation(parent: animationController, curve: Curves.easeInOut));
        }
        expenseItemView = PositionedTransition(rect: positionedAnimation, child: expenseItemView,);

        animationController.forward();
      }

    }

    // expense item view
    // expenseItemViews.add(Expanded(child: expenseItemView));
    expenseItemViews.add(expenseItemView);

    return expenseItemViews;
  }

  Animation<double> createCheckboxAnimation(AnimationController checkBoxFadeInController) {
    Animation<double> scaleAnimation;
    if (expenseEditModeState is ExpenseEditModeStateFadeIn) {
      // edit mode fade in
      scaleAnimation = Tween(begin:0.0, end:1.0).animate(
          CurvedAnimation(
              parent: checkBoxFadeInController,
              curve:Curves.easeInOut
          )
      );
    } else if (expenseEditModeState is ExpenseEditModeStateFadeOut) {
      // edit mode fade out
      scaleAnimation = Tween(begin:1.0, end:0.0).animate(
          CurvedAnimation(
              parent: checkBoxFadeInController,
              curve:Curves.easeInOut
          )
      );
    } else {
      // default to edit mode fade out
      scaleAnimation = Tween(begin:1.0, end:0.0).animate(
          CurvedAnimation(
              parent: checkBoxFadeInController,
              curve:Curves.easeInOut
          )
      );
    }

    return scaleAnimation;
  }

  SizedBox _buildEditModeCheckbox(BuildContext buildContext, double size) {
    return SizedBox(
            height: size,
            width: size,
            child: Transform.scale(
              scale: 0.8,
              // child: CircularCheckBox(
              //   value: selected,
              //   onChanged: (boolValue) {
              //     print("_buildEditModeCheckbox(), onChanged() entry, send ExpenseItemSelectEvent");
              //     BlocProvider.of<ExpenseItemSelectBloc>(buildContext)
              //         .add(ExpenseItemSelectEvent(expenseItem));
              //   },
              // ),
              child: Checkbox(
                value: selected,
                onChanged: (boolValue) {
                  print("_buildEditModeCheckbox(), onChanged() entry, send ExpenseItemSelectEvent");
                  BlocProvider.of<ExpenseItemSelectBloc>(buildContext)
                      .add(ExpenseItemSelectEvent(expenseItem));
                },
              ),
            )
        );
  }
}