@echo off
cd /d "%~dp0"

java --enable-native-access=javafx.graphics --module-path "D:\javafx-sdk-27\lib" --add-modules javafx.controls SmartTaskGUI

pause