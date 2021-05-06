import 'package:flutter/material.dart';
import 'package:get/get.dart';

class ClassicButton extends StatelessWidget {
  final Color? pressColor;
  final String? text;
  final TextStyle? textStyle;
  final Icon? icon;
  final GestureTapCallback? onTap;
  final double? width;
  final double? height;
  final Decoration? backgroundDecoration;
  final BorderRadius? borderRadius;

  ClassicButton({
    this.pressColor,
    this.text,
    this.textStyle,
    this.icon,
    this.width,
    this.height,
    this.backgroundDecoration,
    this.borderRadius,
    @required this.onTap,
  });

  @override
  Widget build(BuildContext context) {
    return Ink(
      // color: Colors.red,
      width: width,
      height: height,
      decoration: backgroundDecoration != null
          ? backgroundDecoration
          : ShapeDecoration(
              color: Colors.lightBlue,
              shape: RoundedRectangleBorder(
                borderRadius: BorderRadius.all(Radius.circular(10)),
              ),
            ),
      child: InkWell(
        highlightColor:
            pressColor != null ? pressColor : Colors.lightBlueAccent,
        borderRadius: borderRadius != null
            ? borderRadius
            : BorderRadius.all(Radius.circular(10)),
        child: Center(
            child: icon != null
                ? icon
                : Text(text == null ? "" : text!,
                    textAlign: TextAlign.center,
                    style: textStyle != null
                        ? textStyle
                        : TextStyle(color: Colors.white))),
        onTap: () {
          onTap!();
        },
      ),
    );
  }
}
