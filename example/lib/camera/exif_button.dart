import 'package:camera/camera.dart';
import 'package:flutter/material.dart';

import '../camera/take_picture.dart';

class ExifButton extends StatefulWidget {
  @override
  _ExifButtonState createState() => _ExifButtonState();
}

class _ExifButtonState extends State<ExifButton> {
  CameraDescription firstCamera;

  @override
  void initState() {
    super.initState();
    initCamera();
  }

  Future<void> initCamera() async {
    WidgetsFlutterBinding.ensureInitialized();
    final cameras = await availableCameras();
    firstCamera = cameras.first;
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        FlatButton(
          color: Colors.lightBlue,
          textColor: Colors.white,
          disabledColor: Colors.grey,
          disabledTextColor: Colors.black,
          padding: EdgeInsets.all(8.0),
          splashColor: Colors.blueAccent,
          onPressed: () {
            print("ok!");
            Navigator.push(context, MaterialPageRoute(builder: (context) => TakePictureScreen(camera: firstCamera)));
          },
          child: Text(
            "Use camera to retrieve EXIF",
          ),
        ),
      ],
    );
  }
}
